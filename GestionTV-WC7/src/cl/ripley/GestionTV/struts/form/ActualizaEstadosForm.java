package cl.ripley.GestionTV.struts.form;

import java.util.Vector;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class ActualizaEstadosForm extends ActionForm
{
  private String accion;
  private Vector vctDetalles = new Vector();
  private String fec_inicio;
  private String num_Oc;
  private String num_Oc2;
  private String fecha_Cre;
  private String estado;
  private String fec_fin;
  private String check_1;
  private String check_2;
  private String est;
  private String grabado;
  private int contador = 0;
  private String flagDatosBD = "si";
  private String hayDatos;
  private String estado7;
  private String estado0;
  private String estado1;
  private String estadocorrecto;
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
  private String vctExpHeadNota;

  public String getAccion()
  {
    return this.accion;
  }

  public void setAccion(String string)
  {
    this.accion = string;
  }

  public String getFecha_Cre() {
    return this.fecha_Cre;
  }

  public String getEst() {
    return this.est;
  }

  public void setEst(String est) {
    this.est = est;
  }

  public void setFecha_Cre(String fechaCre) {
    this.fecha_Cre = fechaCre;
  }

  public String getEstadocorrecto() {
    return this.estadocorrecto;
  }

  public void setEstadocorrecto(String estadocorrecto) {
    this.estadocorrecto = estadocorrecto;
  }

  public String getEstado() {
    return this.estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public String getCheck_1() {
    return this.check_1;
  }

  public void setCheck_1(String check_1) {
    this.check_1 = check_1;
  }

  public String getCheck_2() {
    return this.check_2;
  }

  public void setCheck_2(String check_2) {
    check_2 = check_2;
  }

  public Vector getVctDetalles()
  {
    return this.vctDetalles;
  }

  public String getNum_Oc2() {
    return this.num_Oc2;
  }

  public void setNum_Oc2(String numOc2) {
    this.num_Oc2 = numOc2;
  }

  public void setVctDetalles(Vector vVector)
  {
    this.vctDetalles = vVector;
  }

  public void reset(ActionMapping mapping, HttpServletRequest request)
  {
  }

  public String getFec_inicio()
  {
    return this.fec_inicio;
  }
  public String getFec_fin() {
    return this.fec_fin;
  }

  public void setFec_inicio(String string)
  {
    this.fec_inicio = string;
  }

  public String getEstado7() {
    return this.estado7;
  }

  public void setEstado7(String estado7) {
    this.estado7 = estado7;
  }

  public String getEstado0() {
    return this.estado0;
  }

  public void setEstado0(String estado0) {
    this.estado0 = estado0;
  }

  public String getEstado1() {
    return this.estado1;
  }

  public void setEstado1(String estado1) {
    this.estado1 = estado1;
  }

  public String getNum_Oc() {
    return this.num_Oc;
  }

  public void setNum_Oc(String numOc) {
    this.num_Oc = numOc;
  }

  public void setFec_fin(String string) {
    this.fec_fin = string;
  }

  public int getContador()
  {
    return this.contador;
  }

  public String getHayDatos()
  {
    return this.hayDatos;
  }

  public String getHayProximoBloque()
  {
    return this.hayProximoBloque;
  }

  public int getIndice()
  {
    return this.indice;
  }

  public Vector getListaPagina()
  {
    return this.listaPagina;
  }

  public int getNroBloque()
  {
    return this.nroBloque;
  }

  public String getGrabado()
  {
    return this.grabado;
  }

  public void setGrabado(String grabado) {
    this.grabado = grabado;
  }

  public int getRegistrosPorBloque()
  {
    return this.registrosPorBloque;
  }

  public int getTotalRegistros()
  {
    return this.totalRegistros;
  }

  public void setContador(int i)
  {
    this.contador = i;
  }

  public void setHayDatos(String string)
  {
    this.hayDatos = string;
  }

  public void setHayProximoBloque(String string)
  {
    this.hayProximoBloque = string;
  }

  public void setIndice(int i)
  {
    this.indice = i;
  }

  public void setListaPagina(Vector vector)
  {
    this.listaPagina = vector;
  }

  public void setNroBloque(int i)
  {
    this.nroBloque = i;
  }

  public void setRegistrosPorBloque(int i)
  {
    this.registrosPorBloque = i;
  }

  public void setTotalRegistros(int i)
  {
    this.totalRegistros = i;
  }

  public String getMensaje()
  {
    return this.mensaje;
  }

  public void setMensaje(String string)
  {
    this.mensaje = string;
  }

  public int getTotalPaginas()
  {
    return this.totalPaginas;
  }

  public void setTotalPaginas(int i)
  {
    this.totalPaginas = i;
  }

  public String getFlagDatosBD()
  {
    return this.flagDatosBD;
  }

  public void setFlagDatosBD(String string)
  {
    this.flagDatosBD = string;
  }

  public String getExportFile()
  {
    return this.exportFile;
  }

  public String getVctExpHead()
  {
    return this.vctExpHead;
  }

  public String getVctExpHeadNota()
  {
    return this.vctExpHeadNota;
  }

  public void setExportFile(String string)
  {
    this.exportFile = string;
  }

  public void setVctExpHeadNota(String string)
  {
    this.vctExpHeadNota = string;
  }
  public void setVctExpHead(String string) {
    this.vctExpHead = string;
  }

  public String getHayDatosExportar()
  {
    return this.hayDatosExportar;
  }

  public void setHayDatosExportar(String string)
  {
    this.hayDatosExportar = string;
  }
}