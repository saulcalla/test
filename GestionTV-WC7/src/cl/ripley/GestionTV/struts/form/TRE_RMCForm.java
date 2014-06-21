/*     */ package cl.ripley.GestionTV.struts.form;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.Vector;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ 
/*     */ public class TRE_RMCForm extends ActionForm
/*     */ {
/*     */   private String accion;
/*  20 */   private Vector vctDetalles = new Vector();
/*     */   private String fec_inicio;
/*  23 */   private int contador = 0;
/*  24 */   private String flagDatosBD = "si";
/*  25 */   private String actualiza = "no";
/*     */   private String hayDatos;
/*     */   private String hayDatosExportar;
/*     */   private String hayProximoBloque;
/*     */   private int indice;
/*  30 */   private Vector listaPagina = new Vector();
/*     */   private String mensaje;
/*     */   private int nroBloque;
/*     */   private int registrosPorBloque;
/*  34 */   private int totalPaginas = 0;
/*     */   private int totalRegistros;
/*     */   private String exportFile;
/*     */   private String vctExpHead;
/*     */   private String numTRE;
/*     */   private String rutEmpresa;
/*     */   private String glosaTarjeta;
/*     */   private String estado;
/*     */   private String area;
/*     */   private String numConvenio;
/*     */   private String numLote;
/*     */   private String fechaVcto;
/*     */   private String fechaVctoOrigen;
/*     */   private String montoOtorgado;
/*     */   private String saldoDisponible;
/*     */   private String usuario;
/*     */   private String glosaDepartemento;
/*  57 */   private Object[] selectDepartamentos = new Object[0];
/*     */   private String codSucursal;
/*     */   private String glosaSucursal;
/*     */   private Collection collSucursal;
/*  67 */   private String[] selectSucursal = new String[0];
/*     */   private String num_rmc;
/*     */ 
/*     */   public String getAccion()
/*     */   {
/*  60 */     return this.accion;
/*     */   }
/*     */ 
/*     */   public void setAccion(String string)
/*     */   {
/*  75 */     this.accion = string;
/*     */   }
/*     */ 
/*     */   public Vector getVctDetalles()
/*     */   {
/*  80 */     return this.vctDetalles;
/*     */   }
/*     */ 
/*     */   public void setVctDetalles(Vector vVector) {
/*  84 */     this.vctDetalles = vVector;
/*     */   }
/*     */ 
/*     */   public void reset(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/*     */   }
/*     */ 
/*     */   public String getFec_inicio() {
/*  92 */     return this.fec_inicio;
/*     */   }
/*     */ 
/*     */   public void setFec_inicio(String string)
/*     */   {
/*  97 */     this.fec_inicio = string;
/*     */   }
/*     */ 
/*     */   public int getContador()
/*     */   {
/* 102 */     return this.contador;
/*     */   }
/*     */ 
/*     */   public String getHayDatos()
/*     */   {
/* 107 */     return this.hayDatos;
/*     */   }
/*     */ 
/*     */   public String getHayProximoBloque()
/*     */   {
/* 112 */     return this.hayProximoBloque;
/*     */   }
/*     */ 
/*     */   public int getIndice()
/*     */   {
/* 117 */     return this.indice;
/*     */   }
/*     */ 
/*     */   public Vector getListaPagina()
/*     */   {
/* 122 */     return this.listaPagina;
/*     */   }
/*     */ 
/*     */   public int getNroBloque()
/*     */   {
/* 127 */     return this.nroBloque;
/*     */   }
/*     */ 
/*     */   public int getRegistrosPorBloque()
/*     */   {
/* 132 */     return this.registrosPorBloque;
/*     */   }
/*     */ 
/*     */   public int getTotalRegistros()
/*     */   {
/* 137 */     return this.totalRegistros;
/*     */   }
/*     */ 
/*     */   public void setContador(int i)
/*     */   {
/* 143 */     this.contador = i;
/*     */   }
/*     */ 
/*     */   public void setHayDatos(String string)
/*     */   {
/* 148 */     this.hayDatos = string;
/*     */   }
/*     */ 
/*     */   public void setHayProximoBloque(String string)
/*     */   {
/* 153 */     this.hayProximoBloque = string;
/*     */   }
/*     */ 
/*     */   public void setIndice(int i)
/*     */   {
/* 158 */     this.indice = i;
/*     */   }
/*     */ 
/*     */   public void setListaPagina(Vector vector)
/*     */   {
/* 163 */     this.listaPagina = vector;
/*     */   }
/*     */ 
/*     */   public void setNroBloque(int i)
/*     */   {
/* 168 */     this.nroBloque = i;
/*     */   }
/*     */ 
/*     */   public void setRegistrosPorBloque(int i)
/*     */   {
/* 173 */     this.registrosPorBloque = i;
/*     */   }
/*     */ 
/*     */   public void setTotalRegistros(int i)
/*     */   {
/* 178 */     this.totalRegistros = i;
/*     */   }
/*     */ 
/*     */   public String getMensaje()
/*     */   {
/* 183 */     return this.mensaje;
/*     */   }
/*     */ 
/*     */   public void setMensaje(String string)
/*     */   {
/* 188 */     this.mensaje = string;
/*     */   }
/*     */ 
/*     */   public int getTotalPaginas()
/*     */   {
/* 194 */     return this.totalPaginas;
/*     */   }
/*     */ 
/*     */   public void setTotalPaginas(int i)
/*     */   {
/* 200 */     this.totalPaginas = i;
/*     */   }
/*     */ 
/*     */   public String getFlagDatosBD()
/*     */   {
/* 206 */     return this.flagDatosBD;
/*     */   }
/*     */ 
/*     */   public void setFlagDatosBD(String string)
/*     */   {
/* 211 */     this.flagDatosBD = string;
/*     */   }
/*     */ 
/*     */   public String getExportFile()
/*     */   {
/* 221 */     return this.exportFile;
/*     */   }
/*     */ 
/*     */   public String getVctExpHead()
/*     */   {
/* 228 */     return this.vctExpHead;
/*     */   }
/*     */ 
/*     */   public void setExportFile(String string)
/*     */   {
/* 235 */     this.exportFile = string;
/*     */   }
/*     */ 
/*     */   public void setVctExpHead(String string)
/*     */   {
/* 242 */     this.vctExpHead = string;
/*     */   }
/*     */ 
/*     */   public String getHayDatosExportar()
/*     */   {
/* 249 */     return this.hayDatosExportar;
/*     */   }
/*     */ 
/*     */   public void setHayDatosExportar(String string)
/*     */   {
/* 256 */     this.hayDatosExportar = string;
/*     */   }
/*     */ 
/*     */   public String getActualiza() {
/* 260 */     return this.actualiza;
/*     */   }
/*     */ 
/*     */   public void setActualiza(String actualiza) {
/* 264 */     this.actualiza = actualiza;
/*     */   }
/*     */ 
/*     */   public String getRutEmpresa() {
/* 268 */     return this.rutEmpresa;
/*     */   }
/*     */ 
/*     */   public void setRutEmpresa(String rutEmpresa) {
/* 272 */     this.rutEmpresa = rutEmpresa;
/*     */   }
/*     */ 
/*     */   public String getGlosaTarjeta() {
/* 276 */     return this.glosaTarjeta;
/*     */   }
/*     */ 
/*     */   public void setGlosaTarjeta(String glosaTarjeta) {
/* 280 */     this.glosaTarjeta = glosaTarjeta;
/*     */   }
/*     */ 
/*     */   public String getEstado() {
/* 284 */     return this.estado;
/*     */   }
/*     */ 
/*     */   public void setEstado(String estado) {
/* 288 */     this.estado = estado;
/*     */   }
/*     */ 
/*     */   public String getArea() {
/* 292 */     return this.area;
/*     */   }
/*     */ 
/*     */   public void setArea(String area) {
/* 296 */     this.area = area;
/*     */   }
/*     */ 
/*     */   public String getNumConvenio() {
/* 300 */     return this.numConvenio;
/*     */   }
/*     */ 
/*     */   public void setNumConvenio(String numConvenio) {
/* 304 */     this.numConvenio = numConvenio;
/*     */   }
/*     */ 
/*     */   public String getNumLote() {
/* 308 */     return this.numLote;
/*     */   }
/*     */ 
/*     */   public void setNumLote(String numLote) {
/* 312 */     this.numLote = numLote;
/*     */   }
/*     */ 
/*     */   public String getFechaVcto() {
/* 316 */     return this.fechaVcto;
/*     */   }
/*     */ 
/*     */   public void setFechaVcto(String fechaVcto) {
/* 320 */     this.fechaVcto = fechaVcto;
/*     */   }
/*     */ 
/*     */   public String getFechaVctoOrigen() {
/* 324 */     return this.fechaVctoOrigen;
/*     */   }
/*     */ 
/*     */   public void setFechaVctoOrigen(String fechaVctoOrigen) {
/* 328 */     this.fechaVctoOrigen = fechaVctoOrigen;
/*     */   }
/*     */ 
/*     */   public String getMontoOtorgado() {
/* 332 */     return this.montoOtorgado;
/*     */   }
/*     */ 
/*     */   public void setMontoOtorgado(String montoOtorgado) {
/* 336 */     this.montoOtorgado = montoOtorgado;
/*     */   }
/*     */ 
/*     */   public String getSaldoDisponible() {
/* 340 */     return this.saldoDisponible;
/*     */   }
/*     */ 
/*     */   public void setSaldoDisponible(String saldoDisponible) {
/* 344 */     this.saldoDisponible = saldoDisponible;
/*     */   }
/*     */ 
/*     */   public Object[] getSelectDepartamentos() {
/* 348 */     return this.selectDepartamentos;
/*     */   }
/*     */ 
/*     */   public void setSelectDepartamentos(Object[] selectDepartamentos)
/*     */   {
/* 354 */     this.selectDepartamentos = selectDepartamentos;
/*     */   }
/*     */ 
/*     */   public String getGlosaDepartemento()
/*     */   {
/* 360 */     return this.glosaDepartemento;
/*     */   }
/*     */ 
/*     */   public void setGlosaDepartemento(String glosaDepartemento)
/*     */   {
/* 366 */     this.glosaDepartemento = glosaDepartemento;
/*     */   }
/*     */ 
/*     */   public String getCodSucursal()
/*     */   {
/* 371 */     return this.codSucursal;
/*     */   }
/*     */ 
/*     */   public void setCodSucursal(String codSucursal)
/*     */   {
/* 376 */     this.codSucursal = codSucursal;
/*     */   }
/*     */ 
/*     */   public String getGlosaSucursal()
/*     */   {
/* 381 */     return this.glosaSucursal;
/*     */   }
/*     */ 
/*     */   public void setGlosaSucursal(String glosaSucursal)
/*     */   {
/* 386 */     this.glosaSucursal = glosaSucursal;
/*     */   }
/*     */ 
/*     */   public Collection getCollSucursal()
/*     */   {
/* 391 */     return this.collSucursal;
/*     */   }
/*     */ 
/*     */   public void setCollSucursal(Collection collSucursal)
/*     */   {
/* 396 */     this.collSucursal = collSucursal;
/*     */   }
/*     */ 
/*     */   public String[] getSelectSucursal()
/*     */   {
/* 401 */     return this.selectSucursal;
/*     */   }
/*     */ 
/*     */   public void setSelectSucursal(String[] selectSucursal)
/*     */   {
/* 406 */     this.selectSucursal = selectSucursal;
/*     */   }
/*     */ 
/*     */   public String getNumTRE()
/*     */   {
/* 411 */     return this.numTRE;
/*     */   }
/*     */ 
/*     */   public void setNumTRE(String numTRE)
/*     */   {
/* 416 */     this.numTRE = numTRE;
/*     */   }
/*     */ 
/*     */   public String getNum_rmc()
/*     */   {
/* 421 */     return this.num_rmc;
/*     */   }
/*     */ 
/*     */   public void setNum_rmc(String num_rmc)
/*     */   {
/* 426 */     this.num_rmc = num_rmc;
/*     */   }
/*     */ 
/*     */   public String getUsuario()
/*     */   {
/* 431 */     return this.usuario;
/*     */   }
/*     */ 
/*     */   public void setUsuario(String usuario)
/*     */   {
/* 436 */     this.usuario = usuario;
/*     */   }
/*     */ }

/* Location:           C:\sitios\GestionTV_Ripley\trunk\docs\01 Requerimiento\Fuentes Gestión TV\GestionTV-WC7\WEB-INF\classes\
 * Qualified Name:     cl.ripley.GestionTV.struts.form.TRE_RMCForm
 * JD-Core Version:    0.6.2
 */