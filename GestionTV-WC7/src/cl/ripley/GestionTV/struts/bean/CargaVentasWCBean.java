package cl.ripley.GestionTV.struts.bean;

import cl.ripley.GestionTV.comun.ConectaBD;
import cl.ripley.GestionTV.comun.Util;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.sql.DataSource;
import org.apache.log4j.Logger;
import org.apache.struts.util.MessageResources;

public class CargaVentasWCBean extends ConectaBD {
	
	static Logger log = Logger.getRootLogger();
	
	private static String RETORNO_CORRECTO = "Correcto";
	
	protected static MessageResources messages = MessageResources
			.getMessageResources("cl.ripley.GestionTV.struts.msgGestionTV");
	private String accion;
	private int contador = 0;
	private String hayDatos = "no";
	private String hayDatosExportar = "no";
	private String hayProximoBloque = "si";
	private int indice = 0;
	private Vector listaPagina = new Vector();
	private String mensaje = "";
	private int nroBloque = -1;
	private int registrosPorBloque = 10;
	private int totalPaginas = 0;
	private int totalRegistros = 0;
	private int totalReg = 0;
	private Vector vctExportar = new Vector();
	private Vector vctExpHead = new Vector();
	private Vector sql_insert = new Vector();

	String rutStr = "";
	String timePlaced = "";
	String cod_regalo = "";
	String msj_tarjeta = "";
	String fch_creacion = "";
	String dir_cliente = "";
	String dir_despacho = "";
	String address_id = "";
	String esRegalo = "";
	String com_despacho = "";
	String reg_despacho = "";
	String monto_venta = "";
	String tipo_regalo = "0";
	String sucursal_vta = "39";

	public String iniciaCarga(DataSource dataSource, String orderId) {
		String resp = null;
		String sql_insert_str = null;
		try {
			setSucursalVenta(dataSource, orderId);

			sql_insert_str = getSQLNotaVenta(dataSource, orderId);

			if (sql_insert_str != null)
				return RETORNO_CORRECTO;
			else
				setMens_error("ERROR:: Al generar tabla NOTA_VENTA\nVerifique N� de Orden.");

			sql_insert_str = getSQLDespacho(dataSource, orderId);

			if (sql_insert_str == null) {
				setMens_error("ERROR:: Al generar tabla DESPACHO\nVerifique N� de Orden.");
			} else {
				sql_insert_str = getSQLArtituloVenta(dataSource, orderId);

				if (sql_insert_str == null) {
					setMens_error("ERROR:: Al generar tabla ARTICULO_VENTA\nVerifique Nº de Orden.");
				} else {
					sql_insert_str = getSQLTarjetaBancaria(dataSource, orderId);

					if (sql_insert_str != null)
						return RETORNO_CORRECTO;
					sql_insert_str = getSQLTarjetaRipley(dataSource, orderId);

					setMens_error("ERROR:: Al generar tabla TARJETA RIPLEY\nVerifique Nº de Orden.");
				}
			}

			int resultado = 0;
			resultado = cargaVentas(dataSource);

			if (resultado < 0) {
				resp = getMens_error();
				return null;
			}

			resp = "Venta Cargada Exitosamente.";
		} catch (Exception e) {
			log.error("ERROR:: InicioCarga Ventas " + e);
		} finally {
			cierraRst();
		}

		return resp;
	}

	public Vector filtra(ResultSet rst, int numColum) {
		Vector vct_paso = new Vector(numColum);
		try {
			while (rst.next()) {
				for (int i = 1; i <= numColum; i++) {
					if (rst.getString(i) == null)
						vct_paso.add(" - ");
					else
						vct_paso.add(rst.getString(i).toString());
				}
			}
		} catch (Exception e) {
			log.error("::Exception, " + e.getMessage() + "\n"
					+ e.getCause().toString());
			return vct_paso;
		}

		return vct_paso;
	}

	public void setSucursalVenta(DataSource dataSource, String orderId) {
		Vector vRes = null;
		String vInstruccion = "";
		Vector vWhere = new Vector();
		boolean existe = false;
		try {
			vInstruccion = "gestion_72.inst04";

			vWhere.add("Int," + orderId);
			consultaRst(dataSource, vInstruccion, vWhere);

			while (getRst().next()) {
				existe = true;
				String value = getRst().getString("logonid");

				if (value.length() > 0) {
					if (value.substring(0, 3).equals("FCH"))
						setSucursal_vta("75");
					else
						setSucursal_vta("39");
				} else {
					setSucursal_vta("39");
				}
			}

			if (!existe) {
				setSucursal_vta("39");
			}
		} catch (Exception e) {
			log.error("ERROR:: Obtener sucursal de venta" + e);
			setSucursal_vta("39");
			setMens_error("ERROR:: Obtener sucursal de venta");
		} finally {
			cierraRst();
		}
	}

	public String getSQLNotaVenta(DataSource dataSource, String orderId) {
		Vector vRes = null;
		Vector vctTmp = null;
		String vInstruccion = "";
		Vector vWhere = new Vector();
		Vector rutCliente = null;

		if (conecta(dataSource)) {
			try {
				vInstruccion = "gestion_70.inst01";

				vWhere.add("\\?," + orderId);

				vInstruccion = generaSQL(vInstruccion, vWhere);

				vctTmp = consulta(dataSource, vInstruccion, 9);

				vRes = filtraDatos(vctTmp, 9);

				if ((vRes != null) && (vRes.size() > 0)) {
					rutCliente = new Vector();
					vInstruccion = "gestion_70.inst03";
					vWhere.clear();

					vWhere.add("Int," + vRes.get(5).toString());
					consultaRst(dataSource, vInstruccion, vWhere);
					rutCliente = filtra(getRst(), 1);

					cierraRst();

					vInstruccion = (String) Util.getMap().get(
							"gestion_70.inst02");

					vInstruccion = vInstruccion + vRes.get(0).toString() + ", ";

					setFch_creacion(vRes.get(1).toString());
					vInstruccion = vInstruccion + "'" + getFch_creacion()
							+ "', ";

					vInstruccion = vInstruccion + "'" + vRes.get(1).toString()
							+ "', ";

					vInstruccion = vInstruccion + "8, ";

					if (vRes.get(2) == null)
						setMonto_venta("0");
					else {
						setMonto_venta(vRes.get(2).toString());
					}

					vInstruccion = vInstruccion + getMonto_venta() + ", ";

					vInstruccion = vInstruccion + vRes.get(3) + ", ";

					vInstruccion = vInstruccion + "0, ";

					this.rutStr = rutCliente.get(0).toString();
					int id = this.rutStr.indexOf("-");
					vInstruccion = vInstruccion + this.rutStr.substring(0, id)
							+ ", ";

					String dv_cli = this.rutStr.substring(id + 1,
							this.rutStr.length());
					if (dv_cli.toUpperCase().equals("K"))
						vInstruccion = vInstruccion + "'" + dv_cli + "', ";
					else {
						vInstruccion = vInstruccion + "'"
								+ dv_cli.substring(0, 1) + "', ";
					}

					vInstruccion = vInstruccion + getSucursal_vta() + ", ";

					String str_cd_regalo = vRes.get(4).toString();
					id = str_cd_regalo.indexOf("-");

					if (id > 0) {
						setCod_regalo(str_cd_regalo.substring(id + 1,
								str_cd_regalo.length()));

						vInstruccion = vInstruccion + getCod_regalo() + ", ";
						setTipo_regalo(str_cd_regalo.substring(0, 1));

						vInstruccion = vInstruccion + getTipo_regalo() + " ) ";
					} else {
						setTipo_regalo("0");
						setCod_regalo("0");

						vInstruccion = vInstruccion + "0, ";

						vInstruccion = vInstruccion + "0 ) ";
					}

					setDir_cliente(vRes.get(6).toString());

					setMsj_tarjeta(vRes.get(7).toString());

					if (vRes.get(8) == null)
						setEsRegalo("");
					else {
						setEsRegalo(vRes.get(8).toString());
					}
					getSql_insert().add(vInstruccion);

					log.debug("SQL NOTA_VENTA:");
					log.debug(vInstruccion);
				} else {
					vInstruccion = null;
				}

			} catch (Exception e) {
				log.error("::Exception Al genera SQL INSERT NOTA_VENTA " + e);
				return null;
			} finally {
				cierraRst();
			}

		}

		return vInstruccion;
	}

	public String getSQLDespacho(DataSource dataSource, String orderId) {
		Vector vRes = null;
		Vector vctTmp = new Vector();
		String vInstruccion = "";
		Vector vWhere = new Vector();
		Vector rutCliente = null;

		if (conecta(dataSource)) {
			try {
				vInstruccion = "gestion_71.inst01";

				vWhere.add("Int," + getDir_cliente());
				consultaRst(dataSource, vInstruccion, vWhere);

				vRes = filtra(getRst(), 12);

				if ((vRes != null) && (vRes.size() > 0)) {
					Vector comentario = new Vector();
					vInstruccion = "gestion_71.inst03";
					vWhere.clear();

					vWhere.add("\\?," + orderId);
					vInstruccion = generaSQL(vInstruccion, vWhere);
					vctTmp = consulta(dataSource, vInstruccion, 1);
					comentario = filtraDatos(vctTmp, 1);

					Vector dirDespacho = new Vector();
					vInstruccion = "gestion_71.inst04";
					vWhere.clear();
					vctTmp.clear();

					vWhere.add("\\?," + orderId);
					vInstruccion = generaSQL(vInstruccion, vWhere);
					vctTmp = consulta(dataSource, vInstruccion, 1);
					dirDespacho = filtraDatos(vctTmp, 1);

					String idDirDespacho = "";
					if (dirDespacho != null)
						idDirDespacho = dirDespacho.get(0).toString();
					else {
						idDirDespacho = getAddress_id();
					}
					dirDespacho.clear();

					vInstruccion = "gestion_71.inst01";
					vWhere.clear();
					vctTmp.clear();

					vWhere.add("\\?," + idDirDespacho);
					vInstruccion = generaSQL(vInstruccion, vWhere);
					vctTmp = consulta(dataSource, vInstruccion, 12);
					dirDespacho = filtraDatos(vctTmp, 12);

					vInstruccion = (String) Util.getMap().get(
							"gestion_71.inst02");

					vInstruccion = vInstruccion + orderId + ", ";

					vInstruccion = vInstruccion + "0, ";

					String nombre_desp = dirDespacho.get(1).toString() + " "
							+ dirDespacho.get(2).toString() + " "
							+ dirDespacho.get(3).toString();

					if (nombre_desp.length() >= 50)
						vInstruccion = vInstruccion + "'"
								+ nombre_desp.substring(0, 50) + "', ";
					else {
						vInstruccion = vInstruccion + "'" + nombre_desp + "', ";
					}
					vInstruccion = vInstruccion + "'" + getFch_creacion()
							+ "', ";

					vInstruccion = vInstruccion + getSucursal_vta() + ", ";

					String com_despacho = dirDespacho.get(4).toString();

					setCom_despacho(com_despacho);

					com_despacho = com_despacho.substring(2, 4);
					vInstruccion = vInstruccion + com_despacho + ", ";

					setReg_despacho(dirDespacho.get(5).toString());
					vInstruccion = vInstruccion + getReg_despacho() + ", ";

					String direccion_desp = dirDespacho.get(6).toString() + " "
							+ dirDespacho.get(7).toString() + " "
							+ dirDespacho.get(8).toString();

					if (direccion_desp.length() >= 50) {
						vInstruccion = vInstruccion + "'"
								+ direccion_desp.substring(0, 50) + "', ";
					} else {
						vInstruccion = vInstruccion + "'" + direccion_desp
								+ "', ";
					}

					vInstruccion = vInstruccion + "'"
							+ dirDespacho.get(10).toString() + "', ";

					vInstruccion = vInstruccion + "'S', ";

					if ((comentario != null) && (comentario.size() > 0))
						vInstruccion = vInstruccion + "'"
								+ comentario.get(0).toString() + "', ";
					else {
						vInstruccion = vInstruccion + "'', ";
					}

					int id = this.rutStr.indexOf("-");
					vInstruccion = vInstruccion + this.rutStr.substring(0, id)
							+ ", ";
					String direccion_cli = "";
					if (vRes.size() > 5) {
						direccion_cli = vRes.get(6).toString() + " "
								+ vRes.get(7).toString() + " "
								+ vRes.get(8).toString() + " "
								+ vRes.get(9).toString();
					}

					if (direccion_cli.length() >= 50)
						vInstruccion = vInstruccion + "'"
								+ direccion_cli.substring(0, 50) + "', ";
					else {
						vInstruccion = vInstruccion + "'" + direccion_cli
								+ "', ";
					}

					if (vRes.size() > 11)
						vInstruccion = vInstruccion + "'"
								+ vRes.get(10).toString() + "', ";
					else {
						vInstruccion = vInstruccion + "'', ";
					}
					vInstruccion = vInstruccion + "0, ";

					if (vRes.size() > 11)
						vInstruccion = vInstruccion + "'"
								+ vRes.get(1).toString() + "', ";
					else {
						vInstruccion = vInstruccion + "'', ";
					}

					if (vRes.size() > 11)
						vInstruccion = vInstruccion + "'"
								+ vRes.get(2).toString() + "', ";
					else {
						vInstruccion = vInstruccion + "'', ";
					}

					if (vRes.size() > 11)
						vInstruccion = vInstruccion + "'"
								+ vRes.get(3).toString() + "', ";
					else {
						vInstruccion = vInstruccion + "'', ";
					}

					vInstruccion = vInstruccion + "3, ";

					if (vRes.size() > 11)
						vInstruccion = vInstruccion + "'"
								+ vRes.get(11).toString() + "', ";
					else {
						vInstruccion = vInstruccion + "'', ";
					}

					vInstruccion = vInstruccion + getCod_regalo() + ", ";

					vInstruccion = vInstruccion + "'" + getMsj_tarjeta()
							+ "' )";

					getSql_insert().add(vInstruccion);

					log.debug("SQL DESPACHO:");
					log.debug(vInstruccion);
				} else {
					vInstruccion = null;
				}
			} catch (Exception e) {
				log.error("::Exception Al genera SQL INSERT DESPACHO " + e);
				return null;
			} finally {
				cierraRst();
			}

		}

		return vInstruccion;
	}

	public String getSQLArtituloVenta(DataSource dataSource, String orderId) {
		Vector vRes = new Vector();
		String vInstruccion = "";
		Vector vWhere = new Vector();
		Vector vSql = new Vector();
		Vector vctTmp = new Vector();
		ResultSet rstProductos = null;
		String sql = "";
		String partnum = "";
		if (conecta(dataSource)) {
			try {
				vInstruccion = "gestion_72.inst02";

				vWhere.add("Int," + orderId);
				consultaRst(dataSource, vInstruccion, vWhere);

				rstProductos = getRst();
				int correlativo = 1;

				while (rstProductos.next()) {
					vInstruccion = (String) Util.getMap().get(
							"gestion_72.inst01");
					for (int i = 1; i < 15; i++) {
						String value = "";

						if (rstProductos.getString(i) != null)
							value = rstProductos.getString(i).toString();
						else {
							value = "";
						}

						if (i == 1) {
							vInstruccion = vInstruccion + orderId + ",";
						}

						if (i == 2) {
							partnum = value;
							vInstruccion = vInstruccion + correlativo + ",";
						}

						if (i == 3) {
							if (value.equalsIgnoreCase("DESPACHOCENTR")) {
								StringTokenizer tokens = new StringTokenizer(
										partnum, "|");

								while (tokens.hasMoreTokens()) {
									partnum = tokens.nextToken();
								}

								vInstruccion = vInstruccion + "'" + partnum
										+ "',";
							} else {
								vInstruccion = vInstruccion + "'" + value
										+ "',";
							}

						}

						if (i == 4) {
							Vector v_desc = new Vector();
							sql = "";
							vWhere.clear();

							sql = "gestion_72.inst03";
							vctTmp.clear();

							vWhere.add("\\?,"
									+ rstProductos.getString(14).toString());
							sql = generaSQL(sql, vWhere);
							vctTmp = consulta(dataSource, sql, 1);
							v_desc = filtraDatos(vctTmp, 1);

							if (v_desc.size() == 0) {
								vWhere.clear();
								sql = "";
								sql = "gestion_72.inst03";

								vctTmp.clear();
								vWhere.add("\\?,"
										+ rstProductos.getString(14).toString());
								sql = generaSQL(sql, vWhere);
								vctTmp = consulta(dataSource, sql, 1);
								v_desc = filtraDatos(vctTmp, 1);

								if (v_desc.size() == 0) {
									vInstruccion = vInstruccion + "'',";
								} else {
									vInstruccion = vInstruccion + "'"
											+ v_desc.get(0).toString() + "',";
								}
							} else {
								vInstruccion = vInstruccion + "'"
										+ v_desc.get(0).toString() + "',";
							}

						}

						if (i == 5) {
							vInstruccion = vInstruccion
									+ rstProductos.getString(i).toString()
									+ ",";
						}

						if (i == 6) {
							vInstruccion = vInstruccion
									+ rstProductos.getString(i).toString()
									+ ",";
						}

						if (i == 7) {
							vInstruccion = vInstruccion + "0,";
						}

						if (i == 8) {
							vInstruccion = vInstruccion + "0,";
						}

						if (i == 9) {
							vInstruccion = vInstruccion + "0,";
						}

						if (i == 10) {
							String cud = "039001" + generaCUD(orderId, 10);

							String prod = generaCUD(
									String.valueOf(correlativo), 5);

							vInstruccion = vInstruccion + "'" + cud + prod
									+ "',";
						}

						if (i == 11) {
							if (getCod_regalo() == null)
								vInstruccion = vInstruccion + "0,";
							else {
								vInstruccion = vInstruccion + getCod_regalo()
										+ ",";
							}
						}

						if (i == 12) {
							if (getEsRegalo() == null)
								vInstruccion = vInstruccion + "'',";
							else {
								vInstruccion = vInstruccion + "'"
										+ getEsRegalo() + "',";
							}
						}

						if (i == 13) {
							if (getMsj_tarjeta() == null)
								vInstruccion = vInstruccion + "'',";
							else {
								vInstruccion = vInstruccion + "'"
										+ getMsj_tarjeta() + "',";
							}
						}

						if (i == 14) {
							vInstruccion = vInstruccion + "0,";

							vInstruccion = vInstruccion + "'"
									+ getFch_creacion() + "',";

							vInstruccion = vInstruccion + "'"
									+ getFch_creacion() + "',";

							vInstruccion = vInstruccion + "0,";

							vInstruccion = vInstruccion + "0,";

							vInstruccion = vInstruccion + "0,";

							vInstruccion = vInstruccion + "'0')";
						}

					}

					vSql.add(vInstruccion);
					correlativo++;
					vInstruccion = "";
				}

				if (correlativo > 1) {
					String tipo_desp = "SML";
					String cantidad = "0";
					String precio = "0";
					String desc_precio = "0";
					String sku_despacho = "";
					String desc_despacho = "";
					vWhere.clear();
					vInstruccion = "gestion_73.inst01";
					vWhere.add("Int," + orderId);
					rstProductos = null;
					consultaRst(dataSource, vInstruccion, vWhere);
					rstProductos = getRst();

					while (rstProductos.next()) {
						vInstruccion = (String) Util.getMap().get(
								"gestion_72.inst01");

						vInstruccion = vInstruccion + orderId + ",";

						vInstruccion = vInstruccion + correlativo + ",";

						tipo_desp = rstProductos.getString("tamanio").trim();
						cantidad = rstProductos.getString("cantidad").trim();
						precio = rstProductos.getString("costo_envio").trim();
						desc_precio = rstProductos
								.getString("desc_costo_envio").trim();

						if ((precio != null) && (cantidad != null)) {
							int precio_int = Integer.parseInt(precio);
							int costo = 0;
							costo = precio_int;
							precio = String.valueOf(costo);
						} else {
							precio = "0";
						}

						String reg_com = getCom_despacho();
						vWhere.clear();
						vRes.clear();

						sql = "gestion_73.inst02";

						vctTmp.clear();
						vWhere.add("\\?,'" + reg_com + "'");
						sql = generaSQL(sql, vWhere);
						vctTmp = consulta(dataSource, sql, 4);
						log.debug("Cantidad Despacho " + vctTmp.size());

						vRes = filtraDatos(vctTmp, 4);

						if ((vRes != null) && (vRes.size() > 0)) {
							for (int i = 0; i < vRes.size(); i++) {
								String s_envio = vRes.get(i).toString();
								log.debug("DESPACHO " + s_envio);
								if (tipo_desp.equals("SML")) {
									String val = s_envio;
									val = val.substring(1);
									sku_despacho = val.trim();
									desc_despacho = "COSTO DE ENVIO SUPER PEQUEÑO";
								}

								if (tipo_desp.equals("MED")) {
									sku_despacho = s_envio;
									desc_despacho = "COSTO DE ENVIO PEQUEÑO";
								}

								if (tipo_desp.equals("LRG")) {
									sku_despacho = s_envio;
									desc_despacho = "COSTO DE ENVIO MEDIANO";
								}

								if (tipo_desp.equals("PRO")) {
									String value = s_envio;
									value = value.substring(0,
											value.length() - 1);
									sku_despacho = value.trim();
									desc_despacho = "COSTO DE ENVIO PROMOCIONAL";
								}
							}
						} else {
							sku_despacho = "2044640010003";
							desc_despacho = "COSTO DE ENVIO";
						}

						vInstruccion = vInstruccion + "'" + sku_despacho + "',";

						vInstruccion = vInstruccion + "'" + desc_despacho
								+ "',";

						vInstruccion = vInstruccion + precio + ",";

						vInstruccion = vInstruccion + cantidad + ",";

						vInstruccion = vInstruccion + "0,";

						vInstruccion = vInstruccion + desc_precio + ",";

						vInstruccion = vInstruccion + "0,";

						String cud = "039001" + generaCUD(orderId, 10);

						String prod = generaCUD(String.valueOf(correlativo), 5);

						vInstruccion = vInstruccion + "'" + cud + prod + "',";

						if (getCod_regalo() == null)
							vInstruccion = vInstruccion + "0,";
						else {
							vInstruccion = vInstruccion + getCod_regalo() + ",";
						}

						if (getEsRegalo() == null)
							vInstruccion = vInstruccion + "'',";
						else {
							vInstruccion = vInstruccion + "'" + getEsRegalo()
									+ "',";
						}

						if (getMsj_tarjeta() == null)
							vInstruccion = vInstruccion + "'',";
						else {
							vInstruccion = vInstruccion + "'"
									+ getMsj_tarjeta() + "',";
						}

						vInstruccion = vInstruccion + "0,";

						vInstruccion = vInstruccion + "'" + getFch_creacion()
								+ "',";

						vInstruccion = vInstruccion + "'" + getFch_creacion()
								+ "',";

						vInstruccion = vInstruccion + "0,";

						vInstruccion = vInstruccion + "0,";

						vInstruccion = vInstruccion + "0,";

						vInstruccion = vInstruccion + "'0')";

						vSql.add(vInstruccion);

						vInstruccion = "";
						correlativo++;
					}

					String sql_vec = "";
					log.debug("SQL ART. VENTA :");

					for (int i = 0; i < vSql.size(); i++) {
						sql_vec = vSql.get(i).toString();
						log.debug(sql_vec);
						getSql_insert().add(sql_vec);
						sql_vec = "";
					}
				} else {
					vInstruccion = null;
				}
			} catch (Exception e) {
				e.printStackTrace();
				log.error("::Exception Al genera SQL INSERT ARTICULO_VENTA "
						+ e);
				return null;
			} finally {
				if (rstProductos != null) {
					try {
						rstProductos.close();
					} catch (SQLException e) {
						log.error("ERROR:: Cerrar RST en articulo_venta " + e);
					}

				}

				cierraRst();
			}

		}

		return vInstruccion;
	}

	public String getSQLTarjetaBancaria(DataSource dataSource, String orderId) {
		Vector vRes = new Vector();
		String vInstruccion = "";
		Vector vWhere = new Vector();
		String codAutorizador = null;

		if (conecta(dataSource)) {
			try {
				vInstruccion = "gestion_73.inst04";

				vWhere.add("Int," + orderId);
				consultaRst(dataSource, vInstruccion, vWhere);

				vRes = filtra(getRst(), 1);

				if ((vRes != null) && (vRes.size() > 0)) {
					codAutorizador = vRes.get(0).toString();
					vInstruccion = (String) Util.getMap().get(
							"gestion_73.inst03");

					vInstruccion = vInstruccion + orderId + ",";

					vInstruccion = vInstruccion + "0,";

					vInstruccion = vInstruccion + "'" + codAutorizador + "',";

					vInstruccion = vInstruccion + getMonto_venta() + ")";

					getSql_insert().add(vInstruccion);

					log.debug("SQL TARJETA_BANCARIA");
					log.debug(vInstruccion);
				} else {
					vInstruccion = null;
				}

			} catch (Exception e) {
				log.error("::Exception Al genera SQL INSERT Tarjeta Bancaria"
						+ e);
				return null;
			} finally {
				cierraRst();
			}

		}

		return vInstruccion;
	}

	public String getSQLTarjetaRipley(DataSource dataSource, String orderId) {
		String vInstruccion = "";
		Vector vWhere = new Vector();
		String car_embozado = "";
		String car_rut = "";
		String dv_rut = "";
		String car_plazo = "";
		String car_diferido = "";
		String car_valor_cuota = "";
		String car_fecha_venc = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat sdf2 = new SimpleDateFormat(
				"yyyy-MM-dd 00:00:00.000000");

		int contador = 0;

		if (conecta(dataSource)) {
			try {
				vInstruccion = "gestion_76.inst01";

				vWhere.add("Int," + orderId);
				consultaRst(dataSource, vInstruccion, vWhere);

				vInstruccion = (String) Util.getMap().get("gestion_76.inst02");

				vInstruccion = vInstruccion + orderId + ",";

				while (getRst().next()) {
					if (getRst().getString("name").trim()
							.equals("CAR_EMBOZADO")) {
						car_embozado = getRst().getString("value");
					}
					if (getRst().getString("name").trim().equals("CAR_RUT")) {
						car_rut = getRst().getString("value");
						car_embozado = car_embozado
								+ getRst().getString("value");
					}
					if (getRst().getString("name").trim()
							.equals("CAR_DIFERIDO")) {
						car_rut = getRst().getString("value");
						car_embozado = car_embozado
								+ getRst().getString("value");
					}

					if (getRst().getString("name").trim().equals("CAR_PLAZO")) {
						car_plazo = getRst().getString("value");
					}
					if (getRst().getString("name").trim()
							.equals("CAR_DIFERIDO")) {
						car_diferido = getRst().getString("value");
					}
					if (getRst().getString("name").trim().equals("dv")) {
						dv_rut = "0";
					}
					if (getRst().getString("name").trim()
							.equals("CAR_VALOR_CUOTA")) {
						car_valor_cuota = getRst().getString("value");
					}
					if (getRst().getString("name").trim()
							.equals("CAR_FECHA_VENC")) {
						car_fecha_venc = getRst().getString("value");
					}
					contador++;
				}

				if (contador == 0) {
					return null;
				}

				vInstruccion = vInstruccion + car_embozado.substring(0, 1)
						+ ",";

				vInstruccion = vInstruccion + car_embozado.substring(1, 3)
						+ ",";

				vInstruccion = vInstruccion + car_embozado.substring(3, 5)
						+ ",";

				vInstruccion = vInstruccion + car_embozado.substring(6, 14)
						+ ",";

				vInstruccion = vInstruccion + car_rut + ",";

				vInstruccion = vInstruccion + car_plazo + ",";

				vInstruccion = vInstruccion + car_diferido + ",";

				vInstruccion = vInstruccion + getMonto_venta() + ",";

				vInstruccion = vInstruccion + "0,";

				vInstruccion = vInstruccion + "0,";

				vInstruccion = vInstruccion + "0,";

				vInstruccion = vInstruccion + "0,";

				vInstruccion = vInstruccion + car_embozado.substring(5, 6)
						+ ",";

				String dv_tit = car_embozado.substring(14, 16);
				if (dv_tit.equals("11"))
					vInstruccion = vInstruccion + "'k',";
				else {
					vInstruccion = vInstruccion + dv_tit.substring(1, 2) + ",";
				}

				vInstruccion = vInstruccion + car_embozado.substring(5, 6)
						+ ",";

				vInstruccion = vInstruccion + car_embozado.substring(5, 6)
						+ ",";

				vInstruccion = vInstruccion + car_embozado.substring(5, 6)
						+ ",";

				String dv_pod = dv_rut.toUpperCase();

				if (dv_pod.equals("K"))
					vInstruccion = vInstruccion + "'K',";
				else {
					vInstruccion = vInstruccion + "'" + dv_pod + "',";
				}

				vInstruccion = vInstruccion + car_valor_cuota + ",";

				Date fecha = sdf.parse(car_fecha_venc);
				vInstruccion = vInstruccion + "'" + sdf2.format(fecha) + "')";
				getSql_insert().add(vInstruccion);

				log.debug("SQL TARJETA_RIPLEY");
				log.debug(vInstruccion);
			} catch (Exception e) {
				log.error("::Exception Al genera SQL INSERT Tarjeta Ripley" + e);
				return null;
			} finally {
				cierraRst();
			}
			cierraRst();
		}

		return vInstruccion;
	}

	public String generaCUD(String orderId, int tot) {
		String cud = "";

		cud = agregaCerosIzquierda(orderId, tot);

		return cud;
	}

	public int cargaVentas(DataSource dataSource) {
		int intRes = 0;
		if (conecta(dataSource)) {
			try {
				if (getSql_insert().size() > 0)
					intRes = update_sql(dataSource, getSql_insert());
				else
					setMens_error("Problemas al cargar tablas.");
			} catch (Exception e) {
				log.error("::Exception, EN carga de tablas " + e.toString());
				setMens_error("Error al cargar tablas."
						+ e.getLocalizedMessage());
				intRes = -1;
			}

		}

		return intRes;
	}

	public Vector filtraDatos(Vector vct_in, int num) {
		Vector tmp = new Vector();
		String[] str_tmp = new String[num];
		String dato = null;
		try {
			if (vct_in.size() > 0) {
				dato = vct_in.get(0).toString();
				dato = dato.substring(1, dato.length() - 1);
				str_tmp = dato.split(",");

				for (int i = 0; i < num; i++)
					tmp.add(str_tmp[i].trim());
			} else {
				return null;
			}
		} catch (Exception e) {
			log.error("ERROR:: Al filtrar datos desde RST " + e);
			return null;
		}

		return tmp;
	}

	public String generaSQL(String id_sql, Vector datos) {
		String resp = null;
		try {
			if ((id_sql != null) && (datos != null)) {
				String vSql = (String) Util.getMap().get(id_sql);
				String v1 = null;
				String v2 = null;
				for (int j = 0; j < datos.size(); j++) {
					String[] vCadena = datos.elementAt(j).toString().split(",");

					if (vCadena != null) {
						v1 = vCadena[0].toUpperCase().trim();
						v2 = vCadena[1].toUpperCase().trim();

						resp = vSql.replaceAll(v1, v2);
					}

				}

				log.debug("SQL FINAL : " + resp);
			}
		} catch (Exception e) {
			log.error("ERROR: GeneraSQL, carga ventas WC " + e);
		}

		return resp;
	}

	public String agregaCerosIzquierda(String datoCantidad, int numCaracteres) {
		String resultado = "";
		int largoElem = datoCantidad.length();
		if (largoElem < numCaracteres) {
			int diferencia = numCaracteres + 1 - largoElem;
			String faltante = "";
			for (int k = 1; k < diferencia; k++) {
				faltante = faltante + "0";
			}
			resultado = faltante + datoCantidad;
		} else {
			resultado = datoCantidad;
		}
		return resultado;
	}

	public Vector getListaPagina() {
		Vector v = new Vector();

		int p = getTotalPaginas();

		for (int i = 1; i <= p; i++) {
			v.add(Integer.toString(i));
		}
		this.listaPagina = v;

		return this.listaPagina;
	}

	public void setListaPagina(Vector vector) {
		this.listaPagina = vector;
	}

	public int getTotalPaginas() {
		int p = 0;

		int r = getRegistrosPorBloque();

		if (r != 0) {
			p = getTotalReg() / r;
			int b = p * r;

			if (b != getTotalReg()) {
				p++;
			}
		}
		this.totalPaginas = p;
		return this.totalPaginas;
	}

	public int getIndice() {
		return this.indice;
	}

	public int getNroBloque() {
		return this.nroBloque;
	}

	public int getRegistrosPorBloque() {
		if (this.registrosPorBloque == 0) {
			this.registrosPorBloque = 10;
		}
		return this.registrosPorBloque;
	}

	public void setIndice(int i) {
		this.indice = i;
	}

	public void setNroBloque(int i) {
		this.nroBloque = i;
	}

	public void setRegistrosPorBloque(int i) {
		this.registrosPorBloque = i;
	}

	public String getHayDatos() {
		return this.hayDatos;
	}

	public void setHayDatos(String string) {
		this.hayDatos = string;
	}

	public String getHayProximoBloque() {
		return this.hayProximoBloque;
	}

	public void setHayProximoBloque(String string) {
		this.hayProximoBloque = string;
	}

	public void setTotalPaginas(int i) {
		this.totalPaginas = i;
	}

	public static MessageResources getMessages() {
		return messages;
	}

	public String getMensaje() {
		return this.mensaje;
	}

	public void setMensaje(String string) {
		this.mensaje = string;
	}

	public int getContador() {
		return this.contador;
	}

	public void setContador(int i) {
		this.contador = i;
	}

	public int getTotalReg() {
		return this.totalReg;
	}

	public void setTotalReg(int i) {
		this.totalReg = i;
	}

	public int getTotalRegistros() {
		return this.totalRegistros;
	}

	public void setTotalRegistros(int i) {
		this.totalRegistros = i;
	}

	public Vector getVctExpHead() {
		return this.vctExpHead;
	}

	public Vector getVctExportar() {
		return this.vctExportar;
	}

	public void setVctExpHead(Vector vector) {
		this.vctExpHead = vector;
	}

	public void setVctExportar(Vector vector) {
		this.vctExportar = vector;
	}

	public String getHayDatosExportar() {
		return this.hayDatosExportar;
	}

	public void setHayDatosExportar(String string) {
		this.hayDatosExportar = string;
	}

	public String getRutStr() {
		return this.rutStr;
	}

	public void setRutStr(String rutStr) {
		this.rutStr = rutStr;
	}

	public String getTimePlaced() {
		return this.timePlaced;
	}

	public void setTimePlaced(String timePlaced) {
		this.timePlaced = timePlaced;
	}

	public String getCod_regalo() {
		return this.cod_regalo;
	}

	public void setCod_regalo(String cod_regalo) {
		this.cod_regalo = cod_regalo;
	}

	public String getMsj_tarjeta() {
		return this.msj_tarjeta;
	}

	public void setMsj_tarjeta(String msj_tarjeta) {
		if ((msj_tarjeta != null) && (msj_tarjeta.length() > 40))
			this.msj_tarjeta = msj_tarjeta.substring(0, 40);
		else
			this.msj_tarjeta = msj_tarjeta;
	}

	public String getFch_creacion() {
		return this.fch_creacion;
	}

	public void setFch_creacion(String fch_creacion) {
		this.fch_creacion = fch_creacion;
	}

	public String getAddress_id() {
		return this.address_id;
	}

	public void setAddress_id(String address_id) {
		this.address_id = address_id;
	}

	public String getDir_cliente() {
		return this.dir_cliente;
	}

	public void setDir_cliente(String dir_cliente) {
		this.dir_cliente = dir_cliente;
	}

	public String getDir_despacho() {
		return this.dir_despacho;
	}

	public void setDir_despacho(String dir_despacho) {
		this.dir_despacho = dir_despacho;
	}

	public String getEsRegalo() {
		return this.esRegalo;
	}

	public void setEsRegalo(String esRegalo) {
		this.esRegalo = esRegalo;
	}

	public String getCom_despacho() {
		return this.com_despacho;
	}

	public void setCom_despacho(String com_despacho) {
		this.com_despacho = com_despacho;
	}

	public String getReg_despacho() {
		return this.reg_despacho;
	}

	public void setReg_despacho(String reg_despacho) {
		this.reg_despacho = reg_despacho;
	}

	public String getMonto_venta() {
		return this.monto_venta;
	}

	public void setMonto_venta(String monto_venta) {
		this.monto_venta = monto_venta;
	}

	public Vector getSql_insert() {
		return this.sql_insert;
	}

	public void setSql_insert(Vector sql_insert) {
		this.sql_insert = sql_insert;
	}

	public String getTipo_regalo() {
		return this.tipo_regalo;
	}

	public void setTipo_regalo(String tipo_regalo) {
		this.tipo_regalo = tipo_regalo;
	}

	public String getSucursal_vta() {
		return this.sucursal_vta;
	}

	public void setSucursal_vta(String sucursal_vta) {
		this.sucursal_vta = sucursal_vta;
	}
}

/*
 * Location: C:\sitios\GestionTV_Ripley\trunk\docs\01 Requerimiento\Fuentes
 * Gestión TV\GestionTV-WC7\WEB-INF\classes\ Qualified Name:
 * cl.ripley.GestionTV.struts.bean.CargaVentasWCBean JD-Core Version: 0.6.2
 */