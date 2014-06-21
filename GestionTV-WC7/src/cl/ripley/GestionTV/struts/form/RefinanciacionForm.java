/*     */ package cl.ripley.GestionTV.struts.form;
/*     */ 
/*     */ import java.util.Vector;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ 
/*     */ public class RefinanciacionForm extends ActionForm
/*     */ {
/*     */   private String accion;
/*  20 */   private Vector vctDetalles = new Vector();
/*     */   private String fec_inicio;
/*  23 */   private int contador = 0;
/*  24 */   private String flagDatosBD = "si";
/*     */   private String hayDatos;
/*     */   private String hayDatosExportar;
/*     */   private String hayProximoBloque;
/*     */   private int indice;
/*  29 */   private Vector listaPagina = new Vector();
/*     */   private String mensaje;
/*     */   private int nroBloque;
/*     */   private int registrosPorBloque;
/*  33 */   private int totalPaginas = 0;
/*     */   private int totalRegistros;
/*     */   private String exportFile;
/*     */   private String vctExpHead;
/*     */   private String horario;
/*     */ 
/*     */   public String getAccion()
/*     */   {
/*  44 */     return this.accion;
/*     */   }
/*     */ 
/*     */   public void setAccion(String string)
/*     */   {
/*  49 */     this.accion = string;
/*     */   }
/*     */ 
/*     */   public Vector getVctDetalles() {
/*  53 */     return this.vctDetalles;
/*     */   }
/*     */ 
/*     */   public void setVctDetalles(Vector vVector) {
/*  57 */     this.vctDetalles = vVector;
/*     */   }
/*     */ 
/*     */   public void reset(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/*     */   }
/*     */ 
/*     */   public String getFec_inicio()
/*     */   {
/*  74 */     return this.fec_inicio;
/*     */   }
/*     */ 
/*     */   public void setFec_inicio(String string)
/*     */   {
/*  85 */     this.fec_inicio = string;
/*     */   }
/*     */   public int getContador() {
/*  88 */     return this.contador;
/*     */   }
/*     */ 
/*     */   public String getHayDatos() {
/*  92 */     return this.hayDatos;
/*     */   }
/*     */ 
/*     */   public String getHayProximoBloque() {
/*  96 */     return this.hayProximoBloque;
/*     */   }
/*     */ 
/*     */   public int getIndice() {
/* 100 */     return this.indice;
/*     */   }
/*     */ 
/*     */   public Vector getListaPagina() {
/* 104 */     return this.listaPagina;
/*     */   }
/*     */ 
/*     */   public int getNroBloque() {
/* 108 */     return this.nroBloque;
/*     */   }
/*     */ 
/*     */   public int getRegistrosPorBloque() {
/* 112 */     return this.registrosPorBloque;
/*     */   }
/*     */ 
/*     */   public int getTotalRegistros() {
/* 116 */     return this.totalRegistros;
/*     */   }
/*     */ 
/*     */   public void setContador(int i) {
/* 120 */     this.contador = i;
/*     */   }
/*     */ 
/*     */   public void setHayDatos(String string) {
/* 124 */     this.hayDatos = string;
/*     */   }
/*     */ 
/*     */   public void setHayProximoBloque(String string) {
/* 128 */     this.hayProximoBloque = string;
/*     */   }
/*     */ 
/*     */   public void setIndice(int i) {
/* 132 */     this.indice = i;
/*     */   }
/*     */   public void setListaPagina(Vector vector) {
/* 135 */     this.listaPagina = vector;
/*     */   }
/*     */ 
/*     */   public void setNroBloque(int i) {
/* 139 */     this.nroBloque = i;
/*     */   }
/*     */   public void setRegistrosPorBloque(int i) {
/* 142 */     this.registrosPorBloque = i;
/*     */   }
/*     */ 
/*     */   public void setTotalRegistros(int i) {
/* 146 */     this.totalRegistros = i;
/*     */   }
/*     */ 
/*     */   public String getMensaje()
/*     */   {
/* 151 */     return this.mensaje;
/*     */   }
/*     */ 
/*     */   public void setMensaje(String string) {
/* 155 */     this.mensaje = string;
/*     */   }
/*     */   public int getTotalPaginas() {
/* 158 */     return this.totalPaginas;
/*     */   }
/*     */ 
/*     */   public void setTotalPaginas(int i)
/*     */   {
/* 163 */     this.totalPaginas = i;
/*     */   }
/*     */   public String getFlagDatosBD() {
/* 166 */     return this.flagDatosBD;
/*     */   }
/*     */ 
/*     */   public void setFlagDatosBD(String string) {
/* 170 */     this.flagDatosBD = string;
/*     */   }
/*     */ 
/*     */   public String getExportFile() {
/* 174 */     return this.exportFile;
/*     */   }
/*     */   public String getVctExpHead() {
/* 177 */     return this.vctExpHead;
/*     */   }
/*     */ 
/*     */   public void setExportFile(String string) {
/* 181 */     this.exportFile = string;
/*     */   }
/*     */ 
/*     */   public void setVctExpHead(String string) {
/* 185 */     this.vctExpHead = string;
/*     */   }
/*     */ 
/*     */   public String getHayDatosExportar() {
/* 189 */     return this.hayDatosExportar;
/*     */   }
/*     */ 
/*     */   public void setHayDatosExportar(String string) {
/* 193 */     this.hayDatosExportar = string;
/*     */   }
/*     */ 
/*     */   public String getHorario() {
/* 197 */     return this.horario;
/*     */   }
/*     */ 
/*     */   public void setHorario(String horario) {
/* 201 */     this.horario = horario;
/*     */   }
/*     */ }

/* Location:           C:\sitios\GestionTV_Ripley\trunk\docs\01 Requerimiento\Fuentes Gestión TV\GestionTV-WC7\WEB-INF\classes\
 * Qualified Name:     cl.ripley.GestionTV.struts.form.RefinanciacionForm
 * JD-Core Version:    0.6.2
 */