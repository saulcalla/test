/*     */ package cl.ripley.GestionTV.struts.form;
/*     */ 
/*     */ import java.util.Vector;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ 
/*     */ public class ProductosRChannelForm extends ActionForm
/*     */ {
/*     */   private String accion;
/*  17 */   private Vector vctDetalles = new Vector();
/*     */   private String fec_inicio;
/*  20 */   private int contador = 0;
/*  21 */   private String flagDatosBD = "si";
/*     */   private String hayDatos;
/*     */   private String hayDatosExportar;
/*     */   private String hayProximoBloque;
/*     */   private int indice;
/*  26 */   private Vector listaPagina = new Vector();
/*     */   private String mensaje;
/*     */   private int nroBloque;
/*     */   private int registrosPorBloque;
/*  30 */   private int totalPaginas = 0;
/*     */   private int totalRegistros;
/*     */   private String exportFile;
/*     */   private String vctExpHead;
/*     */   private String corr;
/*     */   private String producto;
/*     */   private String descripcion;
/*     */   private String stock;
/*     */   private String vtaChannel;
/*     */   private String vtaTotal;
/*     */ 
/*     */   public String getAccion()
/*     */   {
/*  50 */     return this.accion;
/*     */   }
/*     */ 
/*     */   public void setAccion(String string)
/*     */   {
/*  62 */     this.accion = string;
/*     */   }
/*     */ 
/*     */   public Vector getVctDetalles()
/*     */   {
/*  72 */     return this.vctDetalles;
/*     */   }
/*     */ 
/*     */   public void setVctDetalles(Vector vVector)
/*     */   {
/*  84 */     this.vctDetalles = vVector;
/*     */   }
/*     */ 
/*     */   public void reset(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/*     */   }
/*     */ 
/*     */   public String getFec_inicio()
/*     */   {
/* 101 */     return this.fec_inicio;
/*     */   }
/*     */ 
/*     */   public void setFec_inicio(String string)
/*     */   {
/* 112 */     this.fec_inicio = string;
/*     */   }
/*     */ 
/*     */   public int getContador()
/*     */   {
/* 121 */     return this.contador;
/*     */   }
/*     */ 
/*     */   public String getHayDatos()
/*     */   {
/* 130 */     return this.hayDatos;
/*     */   }
/*     */ 
/*     */   public String getHayProximoBloque()
/*     */   {
/* 139 */     return this.hayProximoBloque;
/*     */   }
/*     */ 
/*     */   public int getIndice() {
/* 143 */     return this.indice;
/*     */   }
/*     */ 
/*     */   public Vector getListaPagina() {
/* 147 */     return this.listaPagina;
/*     */   }
/*     */ 
/*     */   public int getNroBloque() {
/* 151 */     return this.nroBloque;
/*     */   }
/*     */ 
/*     */   public int getRegistrosPorBloque() {
/* 155 */     return this.registrosPorBloque;
/*     */   }
/*     */ 
/*     */   public int getTotalRegistros() {
/* 159 */     return this.totalRegistros;
/*     */   }
/*     */ 
/*     */   public void setContador(int i)
/*     */   {
/* 164 */     this.contador = i;
/*     */   }
/*     */ 
/*     */   public void setHayDatos(String string) {
/* 168 */     this.hayDatos = string;
/*     */   }
/*     */ 
/*     */   public void setHayProximoBloque(String string) {
/* 172 */     this.hayProximoBloque = string;
/*     */   }
/*     */ 
/*     */   public void setIndice(int i) {
/* 176 */     this.indice = i;
/*     */   }
/*     */ 
/*     */   public void setListaPagina(Vector vector) {
/* 180 */     this.listaPagina = vector;
/*     */   }
/*     */ 
/*     */   public void setNroBloque(int i) {
/* 184 */     this.nroBloque = i;
/*     */   }
/*     */ 
/*     */   public void setRegistrosPorBloque(int i) {
/* 188 */     this.registrosPorBloque = i;
/*     */   }
/*     */ 
/*     */   public void setTotalRegistros(int i) {
/* 192 */     this.totalRegistros = i;
/*     */   }
/*     */ 
/*     */   public String getMensaje() {
/* 196 */     return this.mensaje;
/*     */   }
/*     */ 
/*     */   public void setMensaje(String string)
/*     */   {
/* 201 */     this.mensaje = string;
/*     */   }
/*     */ 
/*     */   public int getTotalPaginas()
/*     */   {
/* 206 */     return this.totalPaginas;
/*     */   }
/*     */ 
/*     */   public void setTotalPaginas(int i)
/*     */   {
/* 211 */     this.totalPaginas = i;
/*     */   }
/*     */ 
/*     */   public String getFlagDatosBD()
/*     */   {
/* 216 */     return this.flagDatosBD;
/*     */   }
/*     */ 
/*     */   public void setFlagDatosBD(String string) {
/* 220 */     this.flagDatosBD = string;
/*     */   }
/*     */ 
/*     */   public String getExportFile()
/*     */   {
/* 227 */     return this.exportFile;
/*     */   }
/*     */ 
/*     */   public String getVctExpHead()
/*     */   {
/* 234 */     return this.vctExpHead;
/*     */   }
/*     */ 
/*     */   public void setExportFile(String string)
/*     */   {
/* 241 */     this.exportFile = string;
/*     */   }
/*     */ 
/*     */   public void setVctExpHead(String string)
/*     */   {
/* 248 */     this.vctExpHead = string;
/*     */   }
/*     */ 
/*     */   public String getCorr()
/*     */   {
/* 255 */     return this.corr;
/*     */   }
/*     */ 
/*     */   public void setCorr(String string)
/*     */   {
/* 262 */     this.corr = string;
/*     */   }
/*     */ 
/*     */   public String getHayDatosExportar()
/*     */   {
/* 269 */     return this.hayDatosExportar;
/*     */   }
/*     */ 
/*     */   public void setHayDatosExportar(String string)
/*     */   {
/* 276 */     this.hayDatosExportar = string;
/*     */   }
/*     */ 
/*     */   public String getDescripcion()
/*     */   {
/* 284 */     return this.descripcion;
/*     */   }
/*     */ 
/*     */   public String getProducto()
/*     */   {
/* 291 */     return this.producto;
/*     */   }
/*     */ 
/*     */   public String getStock()
/*     */   {
/* 298 */     return this.stock;
/*     */   }
/*     */ 
/*     */   public String getVtaChannel()
/*     */   {
/* 305 */     return this.vtaChannel;
/*     */   }
/*     */ 
/*     */   public String getVtaTotal()
/*     */   {
/* 312 */     return this.vtaTotal;
/*     */   }
/*     */ 
/*     */   public void setDescripcion(String string)
/*     */   {
/* 319 */     this.descripcion = string;
/*     */   }
/*     */ 
/*     */   public void setProducto(String string)
/*     */   {
/* 326 */     this.producto = string;
/*     */   }
/*     */ 
/*     */   public void setStock(String string)
/*     */   {
/* 333 */     this.stock = string;
/*     */   }
/*     */ 
/*     */   public void setVtaChannel(String string)
/*     */   {
/* 340 */     this.vtaChannel = string;
/*     */   }
/*     */ 
/*     */   public void setVtaTotal(String string)
/*     */   {
/* 347 */     this.vtaTotal = string;
/*     */   }
/*     */ }

/* Location:           C:\sitios\GestionTV_Ripley\trunk\docs\01 Requerimiento\Fuentes Gestión TV\GestionTV-WC7\WEB-INF\classes\
 * Qualified Name:     cl.ripley.GestionTV.struts.form.ProductosRChannelForm
 * JD-Core Version:    0.6.2
 */