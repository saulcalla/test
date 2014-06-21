package cl.ripley.GestionTV.struts.bean;

import cl.ripley.GestionTV.comun.ConectaBD;

import cl.ripley.GestionTV.comun.Util;

import cl.ripley.framework.util.MirrorJava;

import java.io.BufferedReader;

import java.io.InputStreamReader;

import java.net.URL;

import java.net.URLConnection;

import java.sql.SQLException;

import java.text.DecimalFormat;

import java.text.ParseException;

import java.text.SimpleDateFormat;

import java.util.Calendar;

import java.util.Date;

import java.util.Vector;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import org.apache.struts.util.MessageResources;

public class ActivacionGCPBean extends ConectaBD {
	static Logger log = Logger.getRootLogger();

	protected static MessageResources messages = MessageResources
			.getMessageResources("cl.ripley.GestionTV.struts.msgGestionTV");
	private String accion;
	private Vector vctDetalles;
	private String flagDatosBD = "si";
	private String hayDatos = "no";
	private String mensaje = "";
	private long valor = 0L;
	private long flag_monto_cero = 0L;
	private long estado = 0L;
	private long monto_minimo = 0L;
	private long monto_maximo = 500000L;
	private long num_transaccion = 0L;
	private long num_documento = 0L;

	private long monto_refina = 0L;
	private String voucher = "";
	private String voucherHTML = "";
	private String link_voucherHTML = "";

	private long monto_original = 0L;
	private long docto_original = 0L;
	private long plazo_original = 0L;
	private String fecha_original = "";

	private String plazo_activ = "1";
	private SimpleDateFormat sdf = new SimpleDateFormat(
			messages.getMessage("constante.FORMATO_FECHA_2"));
	private SimpleDateFormat sdf2 = new SimpleDateFormat(
			messages.getMessage("constante.FORMATO_FECHA_GCP"));
	private SimpleDateFormat sdf3 = new SimpleDateFormat(
			messages.getMessage("constante.FORMATO_FECHA_3"));
	private SimpleDateFormat dfamd = new SimpleDateFormat(
			messages.getMessage("constante.FORMATO_FECHA"));
	private String mes_vencimiento;
	private String anio_vencimiento;
	private String cvv;
	private String num_pan;

	public boolean getValidacionActivacion(DataSource dataSource,
			String numTarjeta, String monto_act) throws Exception {
		try {
			if (conecta(dataSource)) {
				if (!getValidaMontoMinActivacionGCP(dataSource, numTarjeta,
						monto_act)) {
					setMens_error("Monto de Activaci�n de tarjeta de regalo debe ser mayor a : "
							+ getMonto_minimo());
				}

				if (!getValidaMontoMaxActivacionGCP(dataSource, numTarjeta,
						monto_act)) {
					setMens_error("Monto de Activaci�n de tarjeta mayor al MAXIMO : "
							+ getMonto_maximo());
				} else if (getValidacionStockGCP(dataSource, numTarjeta,
						monto_act)) {
					if (getEstado() != 1L) {
						setMens_error("Estado Tarjeta de regalo erroneo ");
					} else if (getFlag_monto_cero() == 1L) {
						if (getValor() == 0L)
							return true;
						setMens_error("Monto tarjeta de regalo no corresponde");
					} else {
						setMens_error("Tarjeta de Regalo debe ser sin monto preemitido");
					}
				} else {
					setMens_error("No existe la tarjeta de regalo en stock");
				}
			}
		} catch (Exception e) {
			log.error("Exception Validacion Activacion GCP ::: " + e.toString());
			return false;
		} finally {
			cierraRst();
		}
		cierraRst();

		return false;
	}

	public boolean getValidacionDesActivacion(DataSource dataSource,
			String numTarjeta, String monto_desc) {
		try {
			if (conecta(dataSource)) {
				if (getValidacionStockGCP(dataSource, numTarjeta, monto_desc)) {
					if (getValidacionMontoDesactivacionGCP(dataSource,
							numTarjeta, monto_desc)) {
						if (getAbonoGCP(dataSource, numTarjeta, monto_desc))
							return true;
						else {
							setMens_error("No existe la tarjeta de regalo en stock");
							return false;
						}

					}

				}
				/* *
				 * /*
				 */}
		} catch (Exception e) {
			log.error("Exception ::: getValidacionDesActivacion "
					+ e.toString());
			return false;
		} finally {
			cierraRst();
		}
		cierraRst();

		return false;
	}

	private boolean getValidacionStockGCP(DataSource dataSource,
			String numTarjeta, String monto_desc) {
		log.info("Validacion stock GCP");
		String vInstruccion = "gestion_43.inst01";
		Vector vWhere = new Vector();
		boolean existe_gcp = true;
		try {
			vWhere.add("Int," + numTarjeta);

			setRst(null);
			consultaRst(dataSource, vInstruccion, vWhere);

			while (getRst().next()) {
				setHayDatos("si");
				setValor(getRst().getLong("valor"));
				setFlag_monto_cero(getRst().getLong("flag_monto_cero"));
				setEstado(getRst().getLong("estado"));
			}

			if (getHayDatos().equals("no"))
				return false;
		} catch (Exception e) {
			log.error("Error Validacion DesActivacion GCP : " + e.toString());
		} finally {
			cierraRst();
		}
		cierraRst();

		return existe_gcp;
	}

	private boolean getValidacionMontoDesactivacionGCP(DataSource dataSource,
			String numTarjeta, String monto_desc) {
		String vInstruccion = "gestion_43.inst04";
		Vector vWhere = new Vector();
		boolean existe_gcp = true;
		try {
			if (conecta(dataSource)) {
				vWhere.add("Int," + numTarjeta);
				setRst(null);
				consultaRst(dataSource, vInstruccion, vWhere);

				while (getRst().next()) {
					setHayDatos("si");
					setFlag_monto_cero(getRst().getLong("montodisp"));
				}

				if (getHayDatos().equals("no")) {
					setMens_error("No existe la tarjeta de regalo o no esta activa");
					return false;
				}

				long m_desactivacion = Long.parseLong(monto_desc);

				if (m_desactivacion != getFlag_monto_cero()) {
					setMens_error("Diferencias entre el monto de ANULACION y \n SALDO de tarjeta. GCP No puede ser anulada");
					return false;
				}
			}
		} catch (Exception e) {
			log.error("Error Validacion DesActivacion GCP : " + e.toString());
			setMens_error("Error Validacion DesActivacion GCP");
			return false;
		} finally {
			cierraRst();
		}
		cierraRst();

		return existe_gcp;
	}

	private boolean getValidaMontoMinActivacionGCP(DataSource dataSource,
			String numTarjeta, String monto_desc) {
		log.info("Validacion monto minimo activacion");

		String vInstruccion = "gestion_43.inst02";
		Vector vWhere = new Vector();
		try {
			if (conecta(dataSource)) {
				setRst(null);
				consultaRst(dataSource, vInstruccion, vWhere);
				long monto_desactivacion = Long.parseLong(monto_desc);

				while (getRst().next()) {
					setHayDatos("si");
					setMonto_minimo(getRst().getLong("min_monto_actv"));
				}

				if (monto_desactivacion < getMonto_minimo())
					return false;
			}
		} catch (Exception e) {
			log.error("Error Validacion Monto Minimo: " + e.toString());
		} finally {
			cierraRst();
			setRst(null);
		}
		cierraRst();
		setRst(null);

		return true;
	}

	public String validaClienteCAR(String num_tarjeta) throws Exception {
		log.info("Validacion cliente CAR");
		MirrorJava mirror = new MirrorJava();
		String resp_mirror = "";
		try {
			MirrorJava
					.setServidorMirror(messages.getMessage("servidor_mirror"));
			MirrorJava.setPuertoMirror(messages.getMessage("puerto_mirror"));
			MirrorJava
					.setServicioMirror(messages.getMessage("servicio_mirror"));

			String rut_cli = num_tarjeta.substring(6, 14);

			this.mensaje = ("000000T023000" + rut_cli + "040150C000");

			int resp = mirror.enviaMirror(this.mensaje);
			resp_mirror = mirror.getMensajeRespMirror().trim();

			if (resp == 0) {
				String nombre_cli = resp_mirror.substring(10, 20).trim();
				if (nombre_cli.trim().equals("")) {
					log.info("CLIENTE NO EXISTE " + nombre_cli);
					return null;
				}
				log.info("NOMBRE CLIENTE [" + nombre_cli + "]");
				return nombre_cli;
			}

			return null;
		} catch (Exception e) {
			log.error("ERROR: validaClienteCAR() " + e.toString());
		}
		return null;
	}

	public String validaTarjetaCFT(String num_tarjeta, String cvv,
			String mes_vcto, String anio_vcto) throws Exception {
		log.debug("Validacion tarjeta CFT");
		MirrorJava mirror = new MirrorJava();
		String resp_mirror = "";
		String verbo = "";
		try {
			MirrorJava
					.setServidorMirror(messages.getMessage("servidor_mirror"));
			MirrorJava.setPuertoMirror(messages.getMessage("puerto_mirror"));
			MirrorJava
					.setServicioMirror(messages.getMessage("servicio_mirror"));

			verbo = messages.getMessage("activacionGcp.servMirrorCFT");

			this.mensaje = ("000000" + verbo + "000000000000000000000000"
					+ num_tarjeta + anio_vcto + mes_vcto + cvv + "106");

			int resp = mirror.enviaMirror(this.mensaje);
			resp_mirror = mirror.getMensajeRespMirror().trim();

			if (resp == 0) {
				if (resp_mirror != null) {
					log.info("VALIDACION CFT [" + resp_mirror.substring(67)
							+ "]");

					log.info("VALIDACION CFT [" + resp_mirror.substring(30)
							+ "]");
					log.info("LARGO :" + resp_mirror.length());

					if (resp_mirror.regionMatches(true, 67,
							" Tarjeta VALIDA para TRX", 0, 23)) {
						log.info("¡¡¡¡¡¡ TARJETA VALIDA PARA TRX !!!!!");

						if (resp_mirror.regionMatches(true, 49, "00000000", 0,
								8)) {
							log.info("¡¡¡¡¡¡ TARJETA TITULAR!!!!! ["
									+ resp_mirror.substring(33, 41) + "]");
							resp_mirror = resp_mirror.substring(30);
						} else {
							setMens_error("ERROR: TARJETA ADICIONAL NO PUEDE ACTIVAR GCP");
							return null;
						}
					} else {
						setMens_error(resp_mirror.substring(67));
						return null;
					}
				}
			} else {
				return null;
			}
		} catch (Exception e) {
			log.error("ERROR: validaTarjetaCFT " + e.toString());
			return null;
		}
		return resp_mirror;
	}

	private boolean getValidaMontoMaxActivacionGCP(DataSource dataSource,
			String numTarjeta, String monto_activacion) {
		String vInstruccion = "gestion_44.inst01";
		Vector vWhere = new Vector();
		try {
			if (conecta(dataSource)) {
				setRst(null);
				consultaRst(dataSource, vInstruccion, vWhere);
				long monto_activ = Long.parseLong(monto_activacion);

				while (getRst().next()) {
					setHayDatos("si");
					setMonto_maximo(getRst().getLong("monto_maximo"));
				}

				if (monto_activ > getMonto_maximo())
					return false;
			}
		} catch (Exception e) {
			log.error("Error Validacion Monto MAXIMO ACTIVACION : "
					+ e.toString());
		} finally {
			cierraRst();
			setRst(null);
		}
		cierraRst();
		setRst(null);

		return true;
	}

	private boolean getAbonoGCP(DataSource dataSource, String numTarjeta,
			String monto_desact) {
		String vInstruccion = "gestion_43.inst03";
		Vector vWhere = new Vector();
		try {
			vWhere.add("Int," + numTarjeta);

			setRst(null);
			consultaRst(dataSource, vInstruccion, vWhere);

			int cont = 0;
			while (getRst().next()) {
				cont++;
				setHayDatos("si");
			}

			if (getHayDatos().equals("no")) {
				setMens_error("La tarjeta regalo no tiene saldo");
				return false;
			}

			if (cont > 1) {
				setMens_error("Tarjeta GCP ya tiene movimientos y no puede ser ANULADA.");
				return false;
			} else {
				if (getEstado() == 2L) {
					setMens_error("No existe la tarjeta de regalo o no esta activa");
					return false;
				}
			}

		} catch (Exception e) {
			log.error("Error Validacion DesActivacion GCP : " + e.toString());
		} finally {
			cierraRst();
		}
		cierraRst();

		return true;
	}

	public boolean getDocumentoOriginal(DataSource dataSource,
			String numTarjetaGCP, String monto_anulacion, String num_tarj_car) {
		String vInstruccion = "gestion_45.inst01";
		Vector vWhere = new Vector();
		String sucursal = messages.getMessage("activacionGcp.sucursal");
		String caja = messages.getMessage("activacionGcp.caja");
		try {
			if (conecta(dataSource)) {
				vWhere.add("Long," + num_tarj_car);
				vWhere.add("Int," + numTarjetaGCP);
				vWhere.add("Int," + sucursal);
				vWhere.add("Int," + caja);
				setRst(null);
				consultaRst(dataSource, vInstruccion, vWhere);

				int i = 0;
				while (getRst().next()) {
					i++;

					setDocto_original(getRst().getLong("nro_documento"));
					Date f_orig = getRst().getDate("fecha");

					setFecha_original(this.sdf3.format(f_orig));

					setMonto_original(getRst().getLong("monto"));
					setMonto_refina(getRst().getLong("monto_refina"));
					setPlazo_original(getRst().getLong("nro_cuotas"));
				}

				if (i == 0) {
					setMens_error("No se puede obtener datos originales de activacion de GCP \n Verifique que n° GCP corresponda al cliente");

					return false;
				}
			}
		} catch (Exception e) {
			log.error("Error getDocumentoOriginal GCP : " + e.toString());
		} finally {
			cierraRst();
		}
		cierraRst();

		return true;
	}

	public int activacionGCP(DataSource dataSource, String numTarjeta,
			String monto_activacion) throws Exception {
		String vInstruccion = "{"
				+ (String) Util.getMap().get("gestion_44.inst02") + "}";
		vInstruccion = vInstruccion.replaceAll("\n", "");

		Vector vParam = new Vector();
		int sql_code = 0;
		String sucursal = messages.getMessage("activacionGcp.sucursal");
		String caja = messages.getMessage("activacionGcp.caja");
		try {
			if (conecta(dataSource)) {
				sucursal = agregaCerosIzquierda(sucursal, 3);

				log.info("Ejecutando pl insert GCP");

				vParam.add("Int," + numTarjeta);
				vParam.add("Int,206");
				vParam.add("Int," + monto_activacion);
				vParam.add("Int,1");
				vParam.add("Int," + sucursal);
				vParam.add("Int," + caja);
				vParam.add("Int," + getNum_transaccion());
				vParam.add("String,tcac");
				vParam.add("Int,0");
				vParam.add("Int,0");

				sql_code = activaGCP_pl(dataSource, vInstruccion, vParam);

				if (sql_code == 0) {
					log.info("PL INSERT GCP - OK");
					setMens_error(getMens_pl());
				} else {
					log.info("error en insert GCP");
					setMens_error("Error al insertar en tablas GCP");
					return -1;
				}
			}
		} catch (Exception e) {
			setMens_error("Error al insertar en tablas GCP");
			log.error(e.toString());
			return -1;
		} finally {
			cierraRst();
		}
		cierraRst();

		return sql_code;
	}

	public String activacionGCPMirror(String mensaje, boolean activacion,
			String tarj_car, String tarj_gcp, String abono, String usuario) {
		MirrorJava mirror = new MirrorJava();
		String respuesta_mirror = null;
		String servidor_web = messages.getMessage("email.gcp.servidor");
		String cabecera = messages.getMessage("email.gcp.cabecera_activacion");
		try {
			MirrorJava
					.setServidorMirror(messages.getMessage("servidor_mirror"));
			MirrorJava.setPuertoMirror(messages.getMessage("puerto_mirror"));
			MirrorJava
					.setServicioMirror(messages.getMessage("servicio_mirror"));
			mirror.setVerbo(mensaje);
			int resp = mirror.enviaMirror(mensaje);

			if (resp == 0) {
				respuesta_mirror = mirror.getMensajeRespMirror();

				if (!respuesta_mirror.substring(15, 16).equals("0")) {
					log.info("TRX RECHAZADA POR EL AUTORIZADOR ["
							+ respuesta_mirror + "]");
					setMens_error("TRANSACCION RECHAZADA POR EL AUTORIZADOR. \nVERIFIQUE DATOS DE CUENTA DEL CLIENTE");
					return null;
				}

				if (activacion) {
					if (getVoucherMirror(respuesta_mirror, tarj_car, tarj_gcp,
							abono) == null) {
						log.info("Error al generar trx MIRROR. Respuesta ["
								+ respuesta_mirror + "]");
						setMens_error("ERROR AL GENERAR ACTIVACION GCP ");
						return null;
					}

					voucherHTML(respuesta_mirror, tarj_car, tarj_gcp, abono,
							servidor_web, cabecera, usuario, activacion);
				} else {
					if (validaAnulacionMIRROR(respuesta_mirror)) {
						cabecera = messages
								.getMessage("email.gcp.cabecera_desactivacion");

						voucherHTML(respuesta_mirror, tarj_car, tarj_gcp,
								abono, servidor_web, cabecera, usuario,
								activacion);

						setMens_error("ANULACION REALIZADA EXISTOSAMENTE");
						return respuesta_mirror;
					}
					log.error(respuesta_mirror);
					setMens_error("ERROR RESPUESTA SERVICIO ANULACION");
					return null;
				}
			} else {
				setMens_error("ERROR AL GENERAR TRX AL AUTORIZADOR");
			}
		} catch (Exception e) {
			log.error("ERROR : activacionGCPMirror() " + e.toString());
			return null;
		}

		return respuesta_mirror;
	}

	public boolean validaAnulacionMIRROR(String resp_mirror) {
		int busqueda = resp_mirror.indexOf("AU");
		if (busqueda >= 0) {
			return false;
		}
		setVoucher("ANULACION");
		return true;
	}

	public String getVoucherMirror(String mensaje_resp_mirror, String tarj_car,
			String tarj_gcp, String abono) {
		String resp = "";
		String sucursal = messages.getMessage("activacionGcp.sucursal");
		try {
			int largo_mens = mensaje_resp_mirror.length();
			if (largo_mens < 54) {
				return null;
			}

			sucursal = agregaCerosIzquierda(sucursal, 3);

			String fecha_v = mensaje_resp_mirror.substring(46, 48) + ""
					+ mensaje_resp_mirror.substring(50, 54);

			resp = resp + "FECHA PRIMER VENCIMIENTO\t" + fecha_v + "\n";

			long vcuota = Long.parseLong(mensaje_resp_mirror.substring(38, 46));

			resp = resp + "CUOTAS " + getPlazo_activ() + "\n";

			resp = resp + "VALOR CUOTAS\t" + vcuota + "\n";

			long tot_refina = vcuota * Integer.parseInt(getPlazo_activ());

			setMonto_refina(tot_refina);

			resp = resp + "TOTAL A PAGAR \t\t\t" + getMonto_refina() + "\n";

			log.info("Voucher generado \n" + resp);

			setVoucher(resp);
		} catch (Exception e) {
			log.error("ERROR: getVoucherMirror() " + e.toString());
			return null;
		}

		return resp;
	}

	public String generaMensajeMirror(DataSource dataSource, String num_cuotas,
			String num_tarjeta, String monto_activacion) {
		String tipo_cliente = num_tarjeta.substring(16, 17);
		String pref_cli = num_tarjeta.substring(5, 6);
		String rut_cli = num_tarjeta.substring(6, 14);
		String dv_rut_cli = num_tarjeta.substring(14, 16);
		String num_boleta = String.valueOf(getNumeroDocumento(dataSource));
		String sucursal = messages.getMessage("activacionGcp.sucursal");

		String mirror = messages.getMessage("activacionGcp.servMirror");

		String mensaje_mirror = null;
		try {
			setPlazo_activ(num_cuotas);
			mensaje_mirror = "000000"
					+ mirror
					+ "00000000000000000000009400000000000000010078000100000100";

			mensaje_mirror = mensaje_mirror
					+ agregaCerosIzquierda(num_boleta, 8);

			mensaje_mirror = mensaje_mirror + "0003500000"
					+ agregaCerosIzquierda(num_cuotas, 2);
			mensaje_mirror = mensaje_mirror + "000000040150" + tipo_cliente
					+ "401000000000";

			mensaje_mirror = mensaje_mirror + pref_cli + rut_cli + dv_rut_cli;
			mensaje_mirror = mensaje_mirror + "00000001"
					+ agregaCerosIzquierda(sucursal, 4) + "0000";

			mensaje_mirror = mensaje_mirror
					+ agregaCerosIzquierda(monto_activacion, 12);
			mensaje_mirror = mensaje_mirror + "0000000000000000000";
			mensaje_mirror = mensaje_mirror
					+ "000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
			mensaje_mirror = mensaje_mirror
					+ "000000000000000000000000000000000000000000000000000000010000000000";

			mensaje_mirror = mensaje_mirror + pref_cli + rut_cli + dv_rut_cli;
			mensaje_mirror = mensaje_mirror
					+ "0160919210000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
			mensaje_mirror = mensaje_mirror
					+ "000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
			mensaje_mirror = mensaje_mirror
					+ "000000000000000000000000000000000000000";

			log.info("MENSAJE MIRROR ACTIVACION");
			log.info(mensaje_mirror);
		} catch (Exception e) {
			log.error("ERROR: generaMensajeMirror() + " + e.toString());
			return null;
		} finally {
			cierraRst();
		}
		return mensaje_mirror;
	}

	public String generaMensajeAnulacionMirror(DataSource dataSource,
			String num_tarjeta) {
		String pref_cli = num_tarjeta.substring(5, 6);
		String rut_cli = num_tarjeta.substring(6, 14);
		String monto_refinanciado = String.valueOf(getMonto_original());
		String dcto_orig = String.valueOf(getDocto_original());
		String num_cuotas = String.valueOf(getPlazo_original());
		String num_boleta = String.valueOf(getNumeroDocumento(dataSource));
		String sucursal = messages.getMessage("activacionGcp.sucursal");
		String caja = messages.getMessage("activacionGcp.caja");
		String mirror = messages.getMessage("activacionGcp.servMirror");
		String mensaje_mirror = null;
		try {
			mensaje_mirror = "000000"
					+ mirror
					+ "00000000000000000000009400000000000000000000000000000000";
			mensaje_mirror = mensaje_mirror
					+ agregaCerosIzquierda(num_boleta, 8) + "0023500000";
			mensaje_mirror = mensaje_mirror
					+ agregaCerosIzquierda(num_cuotas, 2)
					+ "0000000401501400000000000";
			mensaje_mirror = mensaje_mirror + pref_cli + rut_cli + "0000000001"
					+ agregaCerosIzquierda(sucursal, 4) + "0000";
			mensaje_mirror = mensaje_mirror
					+ agregaCerosIzquierda(monto_refinanciado, 12) + "0000";
			mensaje_mirror = mensaje_mirror + getFecha_original()
					+ "000000000871";
			mensaje_mirror = mensaje_mirror
					+ agregaCerosIzquierda(dcto_orig, 8) + "0000"
					+ agregaCerosIzquierda(caja, 4)
					+ "000100010000000000000000000000000";
			mensaje_mirror = mensaje_mirror
					+ "0000000000000000000000000000000000000000000000000000000000000000000000000000000000";
			mensaje_mirror = mensaje_mirror
					+ "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
			mensaje_mirror = mensaje_mirror
					+ "0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
			mensaje_mirror = mensaje_mirror
					+ "00000000000000000000000000000000000000000000000000000";

			log.info("MENSAJE MIRROR ANULACION");
			log.info(mensaje_mirror);
		} catch (Exception e) {
			log.error("ERROR: generaMensajeMirror() + " + e.toString());

			return null;
		} finally {
			cierraRst();
		}
		return mensaje_mirror;
	}

	public String generaCierreTotalBO(DataSource dataSource, String sucursal,
			String caja, String cod_trx, Date fecha) {
		Vector vWhere = new Vector();
		String vInstruccion = "gestion_54.inst03";
		int resp = 0;
		String monto_activacion = "0";
		String monto_anulacion = "0";
		String m_total = "0";
		String link = "";
		String web = messages.getMessage("email.gcp.servidor");
		long m_activacion = 0L;
		long m_anulacion = 0L;
		long total = 0L;
		String fecha_cierre = "";
		try {
			fecha_cierre = this.sdf.format(fecha);
			if (conecta(dataSource)) {
				vWhere.add("String," + fecha_cierre);
				vWhere.add("Int," + sucursal);
				vWhere.add("Int," + caja);
				vWhere.add("Int,28");

				vWhere.add("String," + fecha_cierre);
				vWhere.add("Int," + sucursal);
				vWhere.add("Int," + caja);
				vWhere.add("Int,38");

				consultaRst(dataSource, vInstruccion, vWhere);

				while (getRst().next()) {
					setHayDatos("si");
					m_activacion = getRst().getLong("total_activacion");
					m_anulacion = getRst().getLong("total_desactivacion");
				}

				total = m_activacion - m_anulacion;

				m_total = formateaPrecio(total);
			}
		} catch (Exception e) {
			log.error("Error generaTOTAL cierreGCP() : " + e);
			return null;
		} finally {
			cierraRst();
		}

		return m_total;
	}

	public int insertaTRX_ABONOS(DataSource dataSource, String num_cuotas,
			String num_tarjeta, String monto_activacion, String tipo_trx,
			String cod_credito) {
		String vInstruccion = (String) Util.getMap().get("gestion_46.inst01");
		Calendar fecha_actual = Calendar.getInstance();

		Vector vParam = new Vector();
		int sql_code = 0;
		String sucursal = messages.getMessage("activacionGcp.sucursal");
		String caja = messages.getMessage("activacionGcp.caja");
		try {
			if (conecta(dataSource)) {
				log.info("Ejecutando pl insert 'trx_abonos' en BackOfice");
				sucursal = agregaCerosIzquierda(sucursal, 3);

				vParam.add("Datebo," + this.sdf2.format(fecha_actual.getTime()));
				vParam.add("Int," + sucursal);
				vParam.add("Int," + caja);
				vParam.add("Int," + getNum_transaccion());
				vParam.add("Int," + getNum_documento());
				vParam.add("Int," + tipo_trx);
				vParam.add("Int,4");
				vParam.add("Int,1");
				vParam.add("Int,70");
				vParam.add("Int," + num_tarjeta);
				vParam.add("Int,0");
				vParam.add("Int,0");
				vParam.add("Int,0");
				vParam.add("Int," + monto_activacion);
				vParam.add("Int,0");
				vParam.add("Int,0");
				vParam.add("Int,0");
				vParam.add("Int,0");
				vParam.add("Int,0");
				vParam.add("Int,0");
				vParam.add("Int," + num_cuotas);
				vParam.add("Int,0");
				vParam.add("Int,0");
				vParam.add("Int,0");
				vParam.add("Int," + monto_activacion);
				vParam.add("String,0");
				vParam.add("Int," + cod_credito);
				vParam.add("Int,0");
				vParam.add("Int,0");

				sql_code = inserta(dataSource, vInstruccion, vParam);
				if (sql_code < 0)
					setMens_error("Error al insertar en tabla BackOffice 'TRX_ABONOS'");
			}
		} catch (Exception e) {
			setMens_error("Error al insertar en tabla BackOffice 'TRX_ABONOS'");
			log.error(e.toString());
			return -1;
		} finally {
			cierraRst();
		}
		return sql_code;
	}

	public int insertaAUDITORIA(DataSource dataSource, String nom_usuario,
			String rut_usuario, String num_cuotas, String num_tarjeta_gcp,
			String num_tarjeta_car, String monto_activacion, String cod_trx,
			String estado, String desc) throws Exception {
		String vInstruccion = (String) Util.getMap().get("gestion_45.inst02");
		Date fecha_actual = new Date();

		Vector vParam = new Vector();
		int sql_code = 0;
		String sucursal = messages.getMessage("activacionGcp.sucursal");
		String caja = messages.getMessage("activacionGcp.caja");
		String rut_cliente = "000";
		String rut_vendedor = "000";
		String dv_rut_cliente = "0";
		try {
			if ((rut_usuario != null) && (rut_usuario.length() > 6))
				rut_vendedor = rut_usuario.substring(0, 8);
			else {
				rut_vendedor = "9800";
			}
			sucursal = agregaCerosIzquierda(sucursal, 4);
			caja = agregaCerosIzquierda(caja, 6);

			if ((!num_tarjeta_car.equals(""))
					&& (num_tarjeta_car.length() > 16)) {
				rut_cliente = num_tarjeta_car.substring(6, 14);
				if (num_tarjeta_car.substring(14, 16).equals("11"))
					dv_rut_cliente = "K";
				else {
					dv_rut_cliente = num_tarjeta_car.substring(15, 16);
				}
				rut_cliente = rut_cliente + "-" + dv_rut_cliente;
			}

			if (getNum_pan() != null) {
				num_tarjeta_car = getNum_pan();
			}

			if (desc == null) {
				desc = getMens_error();
			} else if (desc.equals("")) {
				desc = getMens_error();
			}
			if (conecta(dataSource)) {
				log.info("Ejecutando insert 'insertaAUDITORIA'");

				vParam.add("Datehm," + this.sdf2.format(fecha_actual));
				vParam.add("Long," + num_tarjeta_gcp);
				vParam.add("Long," + num_tarjeta_car);
				vParam.add("Int," + sucursal);
				vParam.add("Int," + caja);
				vParam.add("Int," + getNum_documento());
				vParam.add("Int," + cod_trx);
				vParam.add("Int," + getNum_transaccion());
				vParam.add("Int," + monto_activacion);
				vParam.add("Int," + num_cuotas);
				vParam.add("Int," + estado);
				vParam.add("String," + nom_usuario);
				vParam.add("Int," + getMonto_refina());
				vParam.add("String," + desc);
				vParam.add("String," + rut_cliente);
				vParam.add("String," + rut_vendedor);
				vParam.add("String," + getDocto_original());
				vParam.add("Int,0");

				sql_code = inserta(dataSource, vInstruccion, vParam);

				if (sql_code < 0) {
					setMens_error("Error al insertar en tabla BackOffice 'insertaAUDITORIA'");
				}
			}
		} catch (Exception e) {
			setMens_error("Error al insertar en tabla BackOffice 'insertaAUDITORIA'");
			log.error(e.toString());
			return -1;
		} finally {
			cierraRst();
		}
		return sql_code;
	}

	public int insertaTRX_TRANSACCION(DataSource dataSource, String num_cuotas,
			String num_tarjeta, String monto_activacion, String tipo_trx,
			String rut_usuario) {
		String vInstruccion = (String) Util.getMap().get("gestion_46.inst02");
		Date fecha_actual = new Date();

		Vector vParam = new Vector();
		int sql_code = 0;
		String sucursal = messages.getMessage("activacionGcp.sucursal");
		String caja = messages.getMessage("activacionGcp.caja");
		try {
			sucursal = agregaCerosIzquierda(sucursal, 3);
			caja = agregaCerosIzquierda(caja, 3);

			if (conecta(dataSource)) {
				log.info("Ejecutando pl insert 'insertaTRX_TRANSACCION' en BackOfice");

				vParam.add("Datebo," + this.sdf2.format(fecha_actual));
				vParam.add("Int," + sucursal);
				vParam.add("Int," + caja);
				vParam.add("Int," + getNum_transaccion());
				vParam.add("Int," + getNum_documento());
				vParam.add("Int," + tipo_trx);
				vParam.add("Int," + monto_activacion);
				vParam.add("Int,0");
				vParam.add("Datebo," + this.sdf2.format(fecha_actual));
				vParam.add("Int,0");
				vParam.add("Int," + getDocto_original());
				vParam.add("Int,0");
				vParam.add("Int,0");
				vParam.add("Int," + rut_usuario);
				vParam.add("Int,0");
				vParam.add("Int,0");
				vParam.add("Int,0");
				vParam.add("Int,0");
				vParam.add("Int,0");
				vParam.add("Datehm," + this.sdf2.format(fecha_actual));
				vParam.add("Int,0");
				vParam.add("Int,0");
				vParam.add("Int,0");
				vParam.add("Int,0");
				vParam.add("Int,0");

				sql_code = inserta(dataSource, vInstruccion, vParam);

				if (sql_code < 0) {
					setMens_error("Error al insertar en tabla BackOffice 'TRX_TRANSACCION'");
				}
			}
		} catch (Exception e) {
			setMens_error("Error al insertar en tabla BackOffice 'TRX_TRANSACCION'");
			log.error(e.toString());
			return -1;
		} finally {
			cierraRst();
		}
		return sql_code;
	}

	public int insertaTRX_TAR_RIPLEY(DataSource dataSource, String num_cuotas,
			String monto_activacion, String numTarjeta) {
		String vInstruccion = (String) Util.getMap().get("gestion_46.inst03");

		Vector vParam = new Vector();

		Calendar fecha_actual = Calendar.getInstance();
		int sql_code = 0;

		String sucursal = messages.getMessage("activacionGcp.sucursal");
		String caja = messages.getMessage("activacionGcp.caja");
		try {
			sucursal = agregaCerosIzquierda(sucursal, 2);
			if (conecta(dataSource)) {
				System.out.println(numTarjeta);
				String rut_cli = numTarjeta.substring(6, 14);

				log.info("Ejecutando insert tabla 'trx_tar_ripley");

				vParam.add("Datebo," + this.sdf2.format(fecha_actual.getTime()));
				vParam.add("Int," + sucursal);
				vParam.add("Int," + caja);
				vParam.add("Int," + getNum_transaccion());
				vParam.add("Int,4");
				vParam.add("Int,1");
				vParam.add("Int,50");
				vParam.add("Int," + rut_cli);
				vParam.add("Int,0");
				vParam.add("Int," + num_cuotas);
				vParam.add("Int,0");
				vParam.add("Int," + monto_activacion);
				vParam.add("Int,0");
				vParam.add("Int,0");
				vParam.add("Int,0");
				vParam.add("Int,0");
				vParam.add("Int,0");
				vParam.add("Int,0");

				sql_code = inserta(dataSource, vInstruccion, vParam);

				if (sql_code < 0) {
					setMens_error("Error al insertar en tabla BackOffice 'TRX_TAR_RIPLEY'");
				}
			}
		} catch (Exception e) {
			setMens_error("Error al insertar en 'TRX_TAR_RIPLEY'"
					+ e.toString());
			return -1;
		} finally {
			cierraRst();
		}
		return sql_code;
	}

	public boolean anulacionGCP(DataSource dataSource, String numTarjetaGCP) {
		String vInstruccion = "{"
				+ (String) Util.getMap().get("gestion_45.inst03") + "}";

		vInstruccion = vInstruccion.replaceAll("\n", "").trim();
		vInstruccion = vInstruccion.replaceAll("\t", "").trim();
		vInstruccion = vInstruccion.trim();
		Vector vParam = new Vector();
		try {
			if (conecta(dataSource)) {
				log.info("Ejecutando pl que reversa una GCP");

				vParam.add("Int," + numTarjetaGCP);

				int sql_code = 0;

				sql_code = anulaGCP_pl(dataSource, vInstruccion, vParam);

				if (sql_code == 0) {
					log.info("PL ANULA GCP - OK");
					setMens_error("Tarjeta GCP anulada exitosamente");
					return true;
				}
				log.info("error en anulacion GCP");
				setMens_error(getMens_pl());
				return false;
			}
		} catch (Exception e) {
			setMens_error("Error anulando Tarjeta GCP");
			log.error(e.toString());
			return false;
		}

		return false;
	}

	public long getNumeroTransaccion(DataSource dataSource) {
		String vInstruccion = "gestion_44.inst04";
		Vector vWhere = new Vector();
		try {
			if (conecta(dataSource)) {
				setRst(null);

				consultaRst(dataSource, vInstruccion, vWhere);
				log.info("getNumeroTransaccion");

				while (getRst().next()) {
					setHayDatos("si");

					setNum_transaccion(getRst().getLong("nro_transaccion"));
				}
			}
		} catch (SQLException e) {
			log.error("Exception getNumTransaccion : " + e.toString());
		} finally {
			cierraRst();
		}

		log.info("getNumeroTransaccion : " + getNum_transaccion());

		return getNum_transaccion();
	}

	public long getNumeroDocumento(DataSource dataSource) {
		String vInstruccion = "gestion_45.inst04";
		Vector vWhere = new Vector();
		try {
			if (conecta(dataSource)) {
				setRst(null);

				consultaRst(dataSource, vInstruccion, vWhere);

				while (getRst().next()) {
					setHayDatos("si");
					setNum_documento(getRst().getLong("nro_documento"));
				}
			}
		} catch (SQLException e) {
			log.error("Exception getNumDocumento : " + e.toString());
		} finally {
			cierraRst();
		}

		log.info("num_documento : " + getNum_documento());

		return getNum_documento();
	}

	public int insertaAperturaCierre(DataSource dataSource, DataSource dsGCP,
			String sucursal, String caja, String cod_trx, Date fecha,
			String vendedor) throws Exception {
		String vInstruccion = "";
		Vector vWhere = new Vector();
		String nro_trx = String.valueOf(getNumeroTransaccion(dataSource));
		int resp = 0;
		String total = "0";
		long total_act = 0L;
		String desc = "";
		try {
			if (conecta(dataSource)) {
				vWhere.add("Date," + this.sdf.format(fecha));
				vWhere.add("Int," + sucursal);
				vWhere.add("Int," + caja);
				vWhere.add("Int," + nro_trx);
				vWhere.add("Int,0");
				vWhere.add("Int," + cod_trx);

				if (vendedor.length() >= 8)
					vendedor = vendedor.substring(0, 8);
				else {
					vendedor = "9800";
				}

				vWhere.add("Int," + vendedor);
				vWhere.add("Int,9800");
				vWhere.add("Int,1");

				if (cod_trx.equals("42")) {
					desc = "APERTURA - " + this.sdf.format(fecha);
					vInstruccion = "{"
							+ (String) Util.getMap().get("gestion_48.inst02")
							+ "}";
					vWhere.add("Int,0");
				}
				if (cod_trx.equals("44")) {
					desc = "CIERRE - " + this.sdf.format(fecha);
					vInstruccion = "{"
							+ (String) Util.getMap().get("gestion_48.inst03")
							+ "}";

					total = generaCierreTotalBO(dataSource, sucursal, caja,
							cod_trx, fecha);
					vWhere.add("Int,0");
					vWhere.add("Int,0");
					vWhere.add("Int," + total);
				}

				vWhere.add("Datehm," + this.sdf2.format(fecha));

				vInstruccion = vInstruccion.replaceAll("\n", "").trim();
				vInstruccion = vInstruccion.replaceAll("\t", "").trim();
				vInstruccion = vInstruccion.trim();

				resp = insertaPLAperturaCierre(dataSource, vInstruccion, vWhere);

				insertaAUDITORIA(dsGCP, vendedor, "00", "00", "00", "00",
						total, cod_trx, "0", desc);
			}
		} catch (Exception e) {
			log.error("Error insertaAperturaCierre() : " + e);
			setMens_error("Error insertaAperturaCierre()");
			resp = -1;
		} finally {
			cierraRst();
		}
		return resp;
	}

	public boolean aperturaCierreAutomatico(DataSource dataSource,
			DataSource dsGCP, String sucursal, String caja, String tipo_trx,
			Date fecha_hoy, String usuario) throws Exception {
		String vInstruccion = "gestion_48.inst04";
		Vector vWhere = new Vector();
		boolean existe_trx = false;
		Date fec_ult_act = new Date();
		try {
			if (conecta(dataSource)) {
				vWhere.add("Int," + sucursal);
				vWhere.add("Int," + caja);
				vWhere.add("Int," + tipo_trx);

				setRst(null);
				consultaRst(dataSource, vInstruccion, vWhere);

				if (getRst().next())
					fec_ult_act = getRst().getDate("fecha_trx");
			}
		} catch (Exception e) {
			log.error("Error Obtener fecha ultima activacion: " + e.toString());
		} finally {
			cierraRst();
		}

		boolean cierre = false;
		boolean apertura = false;
		Calendar cal_ult_act = Calendar.getInstance();
		Calendar cal_hoy = Calendar.getInstance();

		String str_fec_hoy = this.dfamd.format(fecha_hoy);
		String str_fec_act = this.dfamd.format(fec_ult_act);
		try {
			cal_hoy.setTime(this.dfamd.parse(str_fec_hoy));
			cal_ult_act.setTime(this.dfamd.parse(str_fec_act));
		} catch (ParseException e) {
			log.error("ERROR:: Al parsear fechas de ult. activacion - cierreAutomatico()");
			log.error(e);
			setMens_error("ERROR:: Al parsear fechas de ult. activacion - cierreAutomatico()");
		}
		try {
			while (cal_ult_act.getTime().before(cal_hoy.getTime())) {
				log.info(this.dfamd.format(cal_ult_act.getTime()));
				log.info(this.dfamd.format(cal_hoy.getTime()));
				apertura = validaAperturaCierre(dataSource, sucursal, caja,
						"42", cal_ult_act.getTime());

				if (!apertura) {
					insertaAperturaCierre(dataSource, dsGCP, sucursal, caja,
							"42", cal_ult_act.getTime(), usuario);
				}

				cierre = validaAperturaCierre(dataSource, sucursal, caja, "44",
						cal_ult_act.getTime());

				if (!cierre) {
					insertaAperturaCierre(dataSource, dsGCP, sucursal, caja,
							"44", cal_ult_act.getTime(), usuario);
				}
				cal_ult_act = comparaFechas(cal_ult_act, cal_hoy);
			}
		} catch (Exception e) {
			log.error("ERROR:: generando Apertura-Cierre Automatico");
			log.error(e);
			setMens_error("ERROR:: generando Apertura-Cierre Automatico");
			throw new Exception(e);
		} finally {
			cierraRst();
		}
		return existe_trx;
	}

	public Calendar comparaFechas(Calendar fecha_1, Calendar fecha_2) {
		int dia_cal = fecha_1.get(5);

		if (fecha_1.getTime().before(fecha_2.getTime())) {
			dia_cal++;
			fecha_1.set(5, dia_cal);
		}

		return fecha_1;
	}

	public boolean validaAperturaCierre(DataSource dataSource, String sucursal,
			String caja, String tipo_trx, Date fecha) throws Exception {
		String vInstruccion = "gestion_48.inst01";
		Vector vWhere = new Vector();
		boolean existe_trx = false;
		try {
			if (conecta(dataSource)) {
				vWhere.add("Int," + sucursal);
				vWhere.add("Int," + caja);
				vWhere.add("Int," + tipo_trx);
				vWhere.add("Datedmy," + this.sdf.format(fecha));

				setRst(null);
				consultaRst(dataSource, vInstruccion, vWhere);

				if (getRst().next())
					return true;
			}
		} catch (Exception e) {
			log.error("Error Validacion validaAperturaCierre() : "
					+ e.toString());
		} finally {
			cierraRst();
		}
		cierraRst();

		return existe_trx;
	}

	public boolean getPlazo(DataSource dataSource, String num_tarj_gcp) {
		String vInstruccion = "gestion_45.inst02";
		Vector vWhere = new Vector();
		try {
			if (conecta(dataSource)) {
				setRst(null);
				vWhere.add("Int," + num_tarj_gcp);

				consultaRst(dataSource, vInstruccion, vWhere);
				log.info("getPlazoOriginal");

				while (getRst().next()) {
					setPlazo_original(getRst().getLong("plazo"));
				}
			}
		} catch (SQLException e) {
			log.error("Exception getPlazo : " + e.toString());
			return false;
		} finally {
			cierraRst();
		}

		return true;
	}

	public String enviaMail(String to_mail_cliente, String tarj_gcp,
			String mensaje, String tipo_trx) {
		String resultado = null;
		String mensj_error = "";
		try {
			EnviaMail mail = new EnviaMail();

			String host = messages.getMessage("email.gcp.host");
			String port = messages.getMessage("email.gcp.port");
			String protocolo = messages.getMessage("email.gcp.protocolo");
			String from = messages.getMessage("email.gcp.from");
			String subject = "";
			String usermail = messages.getMessage("email.gcp.usermail");
			String passmail = messages.getMessage("email.gcp.passmail");
			String mailcontactcenter = messages
					.getMessage("email.gcp.contactcenter");

			if (tipo_trx.equals("activar"))
				subject = messages.getMessage("email.gcp.subject_act");
			else {
				subject = messages.getMessage("email.gcp.subject_des");
			}

			subject = subject + " N° " + tarj_gcp;
			if (mensaje != null) {
				mensaje = mensaje.replaceAll("\n", "<br>");
			}

			String body = "<br><br>" + mensaje;

			log.info("Enviando Mail CONTACTCENTER");
			resultado = mail.enviaEmailGCP(from, mailcontactcenter, host, port,
					protocolo, subject, body, usermail, passmail);

			log.info("FIN Mail CONTACTCENTER");

			if (resultado == null)
				mensj_error = "ERROR ENVIANDO EMAIL A CONTACTCENTER :"
						+ mailcontactcenter;
			else {
				resultado = resultado
						+ "\nEMAIL CONTACT CENTER ENVIADO EXITOSAMENTE";
			}

			log.info("Ejecutando envia Mail CLIENTE");
			resultado = mail.enviaEmailGCP(from, to_mail_cliente, host, port,
					protocolo, subject, body, usermail, passmail);

			log.info("FIN envia Mail CLIENTE");

			if (resultado == null) {
				mensj_error = mensj_error + "ERROR ENVIANDO EMAIL A CLIENTE "
						+ to_mail_cliente;
				setMens_error(mensj_error);
				return null;
			}
			resultado = "EMAIL CLIENTE ENVIADO EXITOSAMENTE";
		} catch (Exception e) {
			log.error("ERROR:: Enviando Mail a - enviaEmail() " + e);
			setMens_error(mensj_error);
			return null;
		}

		return resultado;
	}

	public String voucherHTML(String resp_mirror, String tarj_car,
			String tarj_gcp, String abono, String servidor_web,
			String cabecera, String usuario, boolean activacion) {
		String sucursal = messages.getMessage("activacionGcp.sucursal");
		String caja = messages.getMessage("activacionGcp.caja");
		String primer_venc = "";
		String cuotas = "";
		String tasa = "";
		String glosa = "";
		String web = servidor_web;
		String link = "";
		String mensaje = "";
		String doc_original = "";
		String anulacion = "";
		long vcuota = 0L;
		try {
			if (activacion) {
				primer_venc = resp_mirror.substring(46, 48) + "/"
						+ resp_mirror.substring(48, 50) + "/"
						+ resp_mirror.substring(50, 54);

				vcuota = Long.parseLong(resp_mirror.substring(38, 46));

				cuotas = getPlazo_activ() == null ? "1" : getPlazo_activ();
			} else {
				cuotas = String.valueOf(getPlazo_original());
				primer_venc = getFecha_original();
				abono = String.valueOf(getMonto_original());
				anulacion = "true";
				doc_original = String.valueOf(getDocto_original());
			}

			link = "voucherGCPHTML.jsp?";

			if (getNum_pan() == null)
				link = link + "cuenta_car=" + tarj_car;
			else {
				link = link + "cuenta_car=" + getNum_pan();
			}
			link = link + "&cuenta_gcp=" + tarj_gcp + "&sucursal=" + sucursal
					+ "&caja=" + caja + "&abono=" + abono + "&total_refina="
					+ getMonto_refina() + "&primer_venc=" + primer_venc
					+ "&cuotas=" + cuotas + "&tasa=" + tasa + "&glosa=" + glosa
					+ "&documento=" + getNum_documento() + "&cabecera="
					+ cabecera + "&usuario=" + usuario + "&anulacion="
					+ anulacion + "&doc_original=" + doc_original + "&v_cuota="
					+ vcuota;

			link = link.replaceAll(" ", "%20");
			link = web + link;
			setLink_voucherHTML(link);

			URL url = new URL(link);
			URLConnection httpCon = url.openConnection();

			BufferedReader rd = new BufferedReader(new InputStreamReader(
					httpCon.getInputStream()));
			String line;
			while ((line = rd.readLine()) != null) {
				mensaje = mensaje + line;
			}

			setVoucherHTML(mensaje);
		} catch (Exception e) {
			log.error("ERROR: Genrando voucher HTML");
			log.error(e.toString());
			return null;
		}
		return mensaje;
	}

	public int generaCierreGCP(DataSource dataSource, String sucursal,
			String caja, String cod_trx, Date fecha, String usuario) {
		Vector vWhere = new Vector();
		String vInstruccion = "gestion_54.inst03";
		int resp = 0;
		String monto_activacion = "0";
		String monto_anulacion = "0";
		String m_total = "0";
		String link = "";
		String web = messages.getMessage("email.gcp.servidor");
		long m_activacion = 0L;
		long m_anulacion = 0L;
		long total = 0L;
		String fecha_cierre = "";
		try {
			fecha_cierre = this.sdf.format(fecha);
			if (conecta(dataSource)) {
				vWhere.add("String," + fecha_cierre);
				vWhere.add("Int," + sucursal);
				vWhere.add("Int," + caja);
				vWhere.add("Int,28");

				vWhere.add("String," + fecha_cierre);
				vWhere.add("Int," + sucursal);
				vWhere.add("Int," + caja);
				vWhere.add("Int,38");

				consultaRst(dataSource, vInstruccion, vWhere);

				while (getRst().next()) {
					setHayDatos("si");
					m_activacion = getRst().getLong("total_activacion");
					m_anulacion = getRst().getLong("total_desactivacion");
				}

				total = m_activacion - m_anulacion;

				m_total = formateaPrecio(total);
				monto_activacion = formateaPrecio(m_activacion);
				monto_anulacion = formateaPrecio(m_anulacion);

				if (getHayDatos().equals("no")) {
					return -1;
				}

				link = "informeCierreGCPHTML.jsp?sucursal=" + sucursal
						+ "&caja=" + caja + "&activacion=" + monto_activacion
						+ "&anulacion=" + monto_anulacion + "&total=" + m_total
						+ "&usuario=" + usuario + "&fec_inicio=" + fecha_cierre;

				link = link.replaceAll(" ", "%20");
				link = web + link;
				setLink_voucherHTML(link);
			}
		} catch (Exception e) {
			log.error("Error generaCierreGCP() : " + e);
			return -1;
		} finally {
			cierraRst();
		}
		cierraRst();

		return resp;
	}

	public String generaTarjetaCAR(String param) {
		String tarjeta = null;
		String dv = "";
		String prefijo = "";
		String rut = "";
		VtaBancoBean vb = new VtaBancoBean();

		rut = param.substring(3, 11);
		dv = vb.calculaDV(param.substring(3, 11));

		System.out.println("DV " + dv);

		prefijo = param.substring(29, 30);
		System.out.println("prefijo " + prefijo);

		System.out.println("DV " + dv);

		if (dv.equalsIgnoreCase("K"))
			dv = "11";
		else {
			dv = "0" + dv;
		}

		tarjeta = "40150" + prefijo + rut + dv + "14";

		System.out.println("[" + tarjeta + "]");

		return tarjeta;
	}

	public String voucherAnulacionHTML(String tarj_car, String tarj_gcp,
			String abono, String servidor_web, String cabecera, String usuario) {
		String sucursal = "";
		String caja = "";
		String total_refina = "";
		String primer_venc = "";
		String cuotas = "";
		String tasa = "";
		String glosa = "";
		String web = servidor_web;
		String link = "";
		String mensaje = "";
		try {
			link = "voucherGCPHTML.jsp?cuenta_car=" + tarj_car + "&cuenta_gcp="
					+ tarj_gcp + "&sucursal=" + sucursal + "&caja=" + caja
					+ "&abono=" + abono + "&total_refina=" + total_refina
					+ "&primer_venc=" + primer_venc + "&cuotas=" + cuotas
					+ "&tasa=" + tasa + "&glosa=" + glosa + "&documento="
					+ getNum_documento() + "&cabecera=" + cabecera
					+ "&cabecera=" + usuario + "&anulacion=true"
					+ "&anulacion=true";

			link = link.replaceAll(" ", "%20");
			link = web + link;
			setLink_voucherHTML(link);

			log.info(link);
			URL url = new URL(link);

			URLConnection httpCon = url.openConnection();

			BufferedReader rd = new BufferedReader(new InputStreamReader(
					httpCon.getInputStream()));
			String line;
			while ((line = rd.readLine()) != null) {
				mensaje = mensaje + line;
			}

			setVoucherHTML(mensaje);
		} catch (Exception e) {
			log.error("ERROR: Genrando voucher HTML");
			log.error(e.toString());
			return null;
		}
		return mensaje;
	}

	private String formateaPrecio(long pPrecio) throws Exception {
		DecimalFormat formateador = new DecimalFormat("#####################");

		String n_precio = "";
		try {
			n_precio = formateador.format(pPrecio);
		} catch (Exception e) {
			log.error("ERROR: FormatPrecio CierreActivacionGCP "
					+ e.getLocalizedMessage());
			return "0";
		}
		return n_precio;
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

	public String getHayDatos() {
		return this.hayDatos;
	}

	public void setHayDatos(String string) {
		this.hayDatos = string;
	}

	public Vector getVctDetalles() {
		return this.vctDetalles;
	}

	public void setVctDetalles(Vector vector) {
		this.vctDetalles = vector;
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

	public long getEstado() {
		return this.estado;
	}

	public void setEstado(long estado) {
		this.estado = estado;
	}

	public long getFlag_monto_cero() {
		return this.flag_monto_cero;
	}

	public void setFlag_monto_cero(long flag_monto_cero) {
		this.flag_monto_cero = flag_monto_cero;
	}

	public long getValor() {
		return this.valor;
	}

	public void setValor(long valor) {
		this.valor = valor;
	}

	public long getMonto_minimo() {
		return this.monto_minimo;
	}

	public void setMonto_minimo(long monto_minimo) {
		this.monto_minimo = monto_minimo;
	}

	public long getMonto_maximo() {
		return this.monto_maximo;
	}

	public void setMonto_maximo(long monto_maximo) {
		this.monto_maximo = monto_maximo;
	}

	public long getDocto_original() {
		return this.docto_original;
	}

	public void setDocto_original(long docto_original) {
		this.docto_original = docto_original;
	}

	public String getFecha_original() {
		return this.fecha_original;
	}

	public void setFecha_original(String fecha_original) {
		this.fecha_original = fecha_original;
	}

	public long getMonto_original() {
		return this.monto_original;
	}

	public void setMonto_original(long monto_original) {
		this.monto_original = monto_original;
	}

	public long getPlazo_original() {
		return this.plazo_original;
	}

	public void setPlazo_original(long plazo_original) {
		this.plazo_original = plazo_original;
	}

	public long getMonto_refina() {
		return this.monto_refina;
	}

	public void setMonto_refina(long monto_refina) {
		this.monto_refina = monto_refina;
	}

	public String getVoucher() {
		return this.voucher;
	}

	public void setVoucher(String voucher) {
		this.voucher = voucher;
	}

	public String getVoucherHTML() {
		return this.voucherHTML;
	}

	public void setVoucherHTML(String voucherHTML) {
		this.voucherHTML = voucherHTML;
	}

	public String getLink_voucherHTML() {
		return this.link_voucherHTML;
	}

	public void setLink_voucherHTML(String link_voucherHTML) {
		this.link_voucherHTML = link_voucherHTML;
	}

	public long getNum_documento() {
		return this.num_documento;
	}

	public void setNum_documento(long num_documento) {
		this.num_documento = num_documento;
	}

	public long getNum_transaccion() {
		return this.num_transaccion;
	}

	public void setNum_transaccion(long num_transaccion) {
		this.num_transaccion = num_transaccion;
	}

	public String getPlazo_activ() {
		return this.plazo_activ;
	}

	public void setPlazo_activ(String plazo_activ) {
		this.plazo_activ = plazo_activ;
	}

	public String getMes_vencimiento() {
		return this.mes_vencimiento;
	}

	public void setMes_vencimiento(String mes_vencimiento) {
		this.mes_vencimiento = mes_vencimiento;
	}

	public String getAnio_vencimiento() {
		return this.anio_vencimiento;
	}

	public void setAnio_vencimiento(String anio_vencimiento) {
		this.anio_vencimiento = anio_vencimiento;
	}

	public String getCvv() {
		return this.cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public String getNum_pan() {
		return this.num_pan;
	}

	public void setNum_pan(String num_pan) {
		this.num_pan = num_pan;
	}

}

/*
 * Location: C:\sitios\GestionTV_Ripley\trunk\docs\01 Requerimiento\Fuentes
 * Gestión TV\GestionTV-WC7\WEB-INF\classes\ Qualified Name:
 * cl.ripley.GestionTV.struts.bean.ActivacionGCPBean JD-Core Version: 0.6.2
 */