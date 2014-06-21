/*     */ package cl.ripley.GestionTV.struts.form;
/*     */ 
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ 
/*     */ public class ReporteStockExcelForm extends ActionForm
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private String accion;
/*  18 */   private String flagDatosBD = "si";
/*     */   private String hayDatos;
/*     */   private String mensaje;
/*  21 */   private String temp = "no";
/*     */   private String vctExpHead;
/*     */   private String exportFile;
/*     */ 
/*     */   public String getAccion()
/*     */   {
/*  26 */     return this.accion;
/*     */   }
/*     */ 
/*     */   public void setAccion(String string)
/*     */   {
/*  32 */     this.accion = string;
/*     */   }
/*     */ 
/*     */   public void reset(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/*     */   }
/*     */ 
/*     */   public String getHayDatos()
/*     */   {
/*  42 */     return this.hayDatos;
/*     */   }
/*     */ 
/*     */   public void setHayDatos(String string) {
/*  46 */     this.hayDatos = string;
/*     */   }
/*     */ 
/*     */   public String getMensaje() {
/*  50 */     return this.mensaje;
/*     */   }
/*     */ 
/*     */   public void setMensaje(String string) {
/*  54 */     this.mensaje = string;
/*     */   }
/*     */ 
/*     */   public String getFlagDatosBD() {
/*  58 */     return this.flagDatosBD;
/*     */   }
/*     */ 
/*     */   public void setFlagDatosBD(String string) {
/*  62 */     this.flagDatosBD = string;
/*     */   }
/*     */ 
/*     */   public String getTemp()
/*     */   {
/*  69 */     return this.temp;
/*     */   }
/*     */ 
/*     */   public void setTemp(String temp) {
/*  73 */     this.temp = temp;
/*     */   }
/*     */ 
/*     */   public String getVctExpHead()
/*     */   {
/*  79 */     return this.vctExpHead;
/*     */   }
/*     */ 
/*     */   public void setVctExpHead(String vctExpHead)
/*     */   {
/*  85 */     this.vctExpHead = vctExpHead;
/*     */   }
/*     */ 
/*     */   public static long getSerialVersionUID()
/*     */   {
/*  91 */     return 1L;
/*     */   }
/*     */ 
/*     */   public String getExportFile() {
/*  95 */     return this.exportFile;
/*     */   }
/*     */ 
/*     */   public void setExportFile(String exportFile)
/*     */   {
/* 101 */     this.exportFile = exportFile;
/*     */   }
/*     */ }

/* Location:           C:\sitios\GestionTV_Ripley\trunk\docs\01 Requerimiento\Fuentes Gestión TV\GestionTV-WC7\WEB-INF\classes\
 * Qualified Name:     cl.ripley.GestionTV.struts.form.ReporteStockExcelForm
 * JD-Core Version:    0.6.2
 */