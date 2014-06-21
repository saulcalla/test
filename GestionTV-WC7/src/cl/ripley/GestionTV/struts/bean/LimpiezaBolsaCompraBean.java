package cl.ripley.GestionTV.struts.bean;

import cl.ripley.GestionTV.comun.ConectaBD;
import cl.ripley.GestionTV.comun.Util;
import java.sql.ResultSet;
import java.util.Map;
import java.util.Vector;
import javax.sql.DataSource;
import org.apache.log4j.Logger;
import org.apache.struts.util.MessageResources;

public class LimpiezaBolsaCompraBean extends ConectaBD {
	static Logger log = Logger.getRootLogger();
	protected static MessageResources messages = MessageResources
			.getMessageResources("cl.ripley.GestionTV.struts.msgGestionTV");
	private String accion;
	private String mensaje = "";

	public Vector filtra(ResultSet rst, int numColum) {
		Vector vct_paso = new Vector();
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
			return null;
		} finally {
			cierraRst();
		}
		return vct_paso;
	}

	public String getUserId(DataSource dataSource, String rut) {
		Vector vRes = new Vector();
		String vInstruccion = "";
		Vector vWhere = new Vector();
		String id_cliente = null;

		if (conecta(dataSource)) {
			try {
				vInstruccion = "gestion_75.inst01";

				vWhere.add("String," + rut.toLowerCase());
				consultaRst(dataSource, vInstruccion, vWhere);

				vRes = filtra(getRst(), 1);

				if (vRes != null) {
					id_cliente = vRes.get(0).toString();
				}
			} catch (Exception e) {
				setMens_error("ERROR: Al obtner ID de cliente \nVerifique rut ingresado.");
				log.error("::ERROR: Al obtner ID de cliente " + e);
				return null;
			} finally {
				cierraRst();
			}

		}

		return id_cliente;
	}

	public String limpiezaBolsa(DataSource dataSource, String userId) {
		String vInstruccion = "";
		Vector vWhere = new Vector();
		String resp = "";
		int resultado = 0;
		if (conecta(dataSource)) {
			try {
				vInstruccion = (String) Util.getMap().get("gestion_75.inst02");

				vWhere.add("Int," + userId);

				resultado = actualiza(dataSource, vInstruccion, vWhere);

				if (resultado < 0) {
					setMens_error("ERROR: Al actualizar tabla 'Orders'");
					resp = null;
				}
				
					vInstruccion = (String) Util.getMap().get(
							"gestion_75.inst03");

					resultado = actualiza(dataSource, vInstruccion, vWhere);

					if (resultado >= 0){}
					else{
					setMens_error("ERROR: Al actualizar tabla 'OrdersItems'");
						resp = null;
					}
				

			} catch (Exception e) {
				setMens_error("ERROR: Al Limpiar bolsa de Compras");
				log.error("::ERROR: Al Limpiar bolsa de Compras" + e);
				return null;
			} finally {
				cierraRst();
			}
			cierraRst();
		}

		return resp;
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
}

/*
 * Location: C:\sitios\GestionTV_Ripley\trunk\docs\01 Requerimiento\Fuentes
 * Gestión TV\GestionTV-WC7\WEB-INF\classes\ Qualified Name:
 * cl.ripley.GestionTV.struts.bean.LimpiezaBolsaCompraBean JD-Core Version:
 * 0.6.2
 */