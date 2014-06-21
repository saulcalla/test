/*     */ package cl.ripley.GestionTV.struts.form;
/*     */ 
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ 
/*     */ public class MenuForm extends ActionForm
/*     */ {
/*     */   private String accion;
/*     */   private String mensaje;
/*     */   private String sistema;
/*     */   private String clave;
/*     */   private String rutUsuario;
/*     */   private String nombreUsuario;
/*     */   private String accesoRangos;
/*     */ 
/*     */   public void reset(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/*  51 */     this.mensaje = "";
/*  52 */     this.accion = "";
/*     */   }
/*     */ 
/*     */   public String getAccion()
/*     */   {
/*  59 */     return this.accion;
/*     */   }
/*     */ 
/*     */   public void setAccion(String string)
/*     */   {
/*  66 */     this.accion = string;
/*     */   }
/*     */ 
/*     */   public String getMensaje()
/*     */   {
/*  73 */     return this.mensaje;
/*     */   }
/*     */ 
/*     */   public void setMensaje(String string)
/*     */   {
/*  80 */     this.mensaje = string;
/*     */   }
/*     */ 
/*     */   public String getRutUsuario()
/*     */   {
/*  87 */     return this.rutUsuario;
/*     */   }
/*     */ 
/*     */   public void setRutUsuario(String string)
/*     */   {
/*  94 */     this.rutUsuario = string;
/*     */   }
/*     */ 
/*     */   public String getClave()
/*     */   {
/* 102 */     return this.clave;
/*     */   }
/*     */ 
/*     */   public String getSistema()
/*     */   {
/* 109 */     return this.sistema;
/*     */   }
/*     */ 
/*     */   public void setClave(String string)
/*     */   {
/* 116 */     this.clave = string;
/*     */   }
/*     */ 
/*     */   public void setSistema(String string)
/*     */   {
/* 123 */     this.sistema = string;
/*     */   }
/*     */ 
/*     */   public String getAccesoRangos()
/*     */   {
/* 136 */     return this.accesoRangos;
/*     */   }
/*     */ 
/*     */   public void setAccesoRangos(String string)
/*     */   {
/* 147 */     this.accesoRangos = string;
/*     */   }
/*     */ 
/*     */   public String getNombreUsuario()
/*     */   {
/* 155 */     return this.nombreUsuario;
/*     */   }
/*     */ 
/*     */   public void setNombreUsuario(String nombreUsuario)
/*     */   {
/* 161 */     this.nombreUsuario = nombreUsuario;
/*     */   }
/*     */ }

/* Location:           C:\sitios\GestionTV_Ripley\trunk\docs\01 Requerimiento\Fuentes Gestión TV\GestionTV-WC7\WEB-INF\classes\
 * Qualified Name:     cl.ripley.GestionTV.struts.form.MenuForm
 * JD-Core Version:    0.6.2
 */