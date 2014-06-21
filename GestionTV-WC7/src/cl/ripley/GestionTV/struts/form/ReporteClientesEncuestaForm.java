package cl.ripley.GestionTV.struts.form;

import java.util.Collection;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class ReporteClientesEncuestaForm extends ActionForm {

	private static final long serialVersionUID = 8635919936119175014L;
	private String accion;
	private Vector vctDetalles = new Vector();
	private String fec_inicio;
	private String fec_fin;
	private int contador = 0;
	private String flagDatosBD = "si";
	private String hayDatos;
	private String hayDatosExportar;
	private String hayProximoBloque;
	private int indice;
	private Vector listaPagina = new Vector();
	private String mensaje;
	private int nroBloque;
	private int registrosPorBloque;
	private int totalPaginas = 0;
	private int totalRegistros;
	private String exportFile;
	private String vctExpHead;		
	private String codSucursal;
	private String glosaSucursal;
	private Collection collSucursal;
	private String[] selectSucursal = new String[0];

	private String[] chkCodigos = { "01", "02", "03", "04" };

	public String getAccion() {
		return this.accion;
	}

	public void setAccion(String string) {
		this.accion = string;
	}

	public Vector getVctDetalles() {
		return this.vctDetalles;
	}

	public void setVctDetalles(Vector vVector) {
		this.vctDetalles = vVector;
	}

	public void reset(ActionMapping mapping, HttpServletRequest request) {
	}

	public String getFec_inicio() {
		return this.fec_inicio;
	}

	public String getFec_fin() {
		return this.fec_fin;
	}

	public void setFec_inicio(String string) {
		this.fec_inicio = string;
	}

	public void setFec_fin(String string) {
		this.fec_fin = string;
	}

	public int getContador() {
		return this.contador;
	}

	public String getHayDatos() {
		return this.hayDatos;
	}

	public String getHayProximoBloque() {
		return this.hayProximoBloque;
	}

	public int getIndice() {
		return this.indice;
	}

	public Vector getListaPagina() {
		return this.listaPagina;
	}

	public int getNroBloque() {
		return this.nroBloque;
	}

	public int getRegistrosPorBloque() {
		return this.registrosPorBloque;
	}

	public int getTotalRegistros() {
		return this.totalRegistros;
	}

	public void setContador(int i) {
		this.contador = i;
	}

	public void setHayDatos(String string) {
		this.hayDatos = string;
	}

	public void setHayProximoBloque(String string) {
		this.hayProximoBloque = string;
	}

	public void setIndice(int i) {
		this.indice = i;
	}

	public void setListaPagina(Vector vector) {
		this.listaPagina = vector;
	}

	public void setNroBloque(int i) {
		this.nroBloque = i;
	}

	public void setRegistrosPorBloque(int i) {
		this.registrosPorBloque = i;
	}

	public void setTotalRegistros(int i) {
		this.totalRegistros = i;
	}

	public String getMensaje() {
		return this.mensaje;
	}

	public void setMensaje(String string) {
		this.mensaje = string;
	}

	public int getTotalPaginas() {
		return this.totalPaginas;
	}

	public void setTotalPaginas(int i) {
		this.totalPaginas = i;
	}

	public String getFlagDatosBD() {
		return this.flagDatosBD;
	}

	public void setFlagDatosBD(String string) {
		this.flagDatosBD = string;
	}

	public String getExportFile() {
		return this.exportFile;
	}

	public String getVctExpHead() {
		return this.vctExpHead;
	}

	public void setExportFile(String string) {
		this.exportFile = string;
	}

	public void setVctExpHead(String string) {
		this.vctExpHead = string;
	}

	public String getCodSucursal() {
		return codSucursal;
	}

	public void setCodSucursal(String codSucursal) {
		this.codSucursal = codSucursal;
	}

	public String getGlosaSucursal() {
		return glosaSucursal;
	}

	public void setGlosaSucursal(String glosaSucursal) {
		this.glosaSucursal = glosaSucursal;
	}

	public String getHayDatosExportar() {
		return this.hayDatosExportar;
	}

	public void setHayDatosExportar(String string) {
		this.hayDatosExportar = string;
	}

	public Collection getCollSucursal() {
		return this.collSucursal;
	}

	public void setCollSucursal(Collection collSucursal) {
		this.collSucursal = collSucursal;
	}

	public String[] getSelectSucursal() {
		return this.selectSucursal;
	}

	public void setSelectSucursal(String[] selectSucursal) {
		this.selectSucursal = selectSucursal;
	}

	public String[] getChkCodigos() {
		return this.chkCodigos;
	}

	public void setChkCodigos(String[] chkCodigos) {
		this.chkCodigos = chkCodigos;
	}
}
