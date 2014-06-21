/*     */ package cl.ripley.GestionTV.struts.form;
/*     */ 
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ 
/*     */ public class CierreActivacionGCPForm extends ActionForm
/*     */ {
/*     */   private String accion;
/*  14 */   private String flagDatosBD = "si";
/*     */   private String hayDatos;
/*     */   private String mensaje;
/*  17 */   private String temp = "no";
/*     */   private String aperturaCierre;
/*     */   private String fec_inicio;
/*     */   private String cierre;
/*  21 */   private String linkVoucherHTML = "http://localhost";
/*     */ 
/*     */   public String getAccion()
/*     */   {
/*  25 */     return this.accion;
/*     */   }
/*     */ 
/*     */   public void setAccion(String string)
/*     */   {
/*  31 */     this.accion = string;
/*     */   }
/*     */ 
/*     */   public void reset(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/*     */   }
/*     */ 
/*     */   public String getHayDatos()
/*     */   {
/*  41 */     return this.hayDatos;
/*     */   }
/*     */ 
/*     */   public void setHayDatos(String string) {
/*  45 */     this.hayDatos = string;
/*     */   }
/*     */ 
/*     */   public String getMensaje() {
/*  49 */     return this.mensaje;
/*     */   }
/*     */ 
/*     */   public void setMensaje(String string) {
/*  53 */     this.mensaje = string;
/*     */   }
/*     */ 
/*     */   public String getFlagDatosBD() {
/*  57 */     return this.flagDatosBD;
/*     */   }
/*     */ 
/*     */   public void setFlagDatosBD(String string) {
/*  61 */     this.flagDatosBD = string;
/*     */   }
/*     */ 
/*     */   public String getTemp()
/*     */   {
/*  68 */     return this.temp;
/*     */   }
/*     */ 
/*     */   public void setTemp(String temp) {
/*  72 */     this.temp = temp;
/*     */   }
/*     */ 
/*     */   public String getAperturaCierre()
/*     */   {
/*  78 */     return this.aperturaCierre;
/*     */   }
/*     */ 
/*     */   public void setAperturaCierre(String aperturaCierre) {
/*  82 */     this.aperturaCierre = aperturaCierre;
/*     */   }
/*     */ 
/*     */   public String getFec_inicio()
/*     */   {
/*  88 */     return this.fec_inicio;
/*     */   }
/*     */ 
/*     */   public void setFec_inicio(String fec_inicio)
/*     */   {
/*  94 */     this.fec_inicio = fec_inicio;
/*     */   }
/*     */ 
/*     */   public String getCierre()
/*     */   {
/* 100 */     return this.cierre;
/*     */   }
/*     */ 
/*     */   public void setCierre(String cierre)
/*     */   {
/* 106 */     this.cierre = cierre;
/*     */   }
/*     */ 
/*     */   public String getLinkVoucherHTML()
/*     */   {
/* 112 */     return this.linkVoucherHTML;
/*     */   }
/*     */ 
/*     */   public void setLinkVoucherHTML(String linkVoucherHTML)
/*     */   {
/* 118 */     this.linkVoucherHTML = linkVoucherHTML;
/*     */   }
/*     */ }

/* Location:           C:\sitios\GestionTV_Ripley\trunk\docs\01 Requerimiento\Fuentes Gestión TV\GestionTV-WC7\WEB-INF\classes\
 * Qualified Name:     cl.ripley.GestionTV.struts.form.CierreActivacionGCPForm
 * JD-Core Version:    0.6.2
 */