/*     */ package cl.ripley.GestionTV.struts.form;
/*     */ 
/*     */ import java.util.Vector;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ 
/*     */ public class TodosProductosForm extends ActionForm
/*     */ {
/*     */   private String accion;
/*  19 */   private Vector vctDetalles = new Vector();
/*     */   private String exportFile;
/*     */   private String mensaje;
/*     */   private String vctExpHead;
/*     */   private String numProd;
/*     */   private String cantidad;
/*     */   private String hayDatos;
/*     */ 
/*     */   public String getAccion()
/*     */   {
/*  34 */     return this.accion;
/*     */   }
/*     */ 
/*     */   public void setAccion(String string)
/*     */   {
/*  46 */     this.accion = string;
/*     */   }
/*     */ 
/*     */   public Vector getVctDetalles()
/*     */   {
/*  56 */     return this.vctDetalles;
/*     */   }
/*     */ 
/*     */   public void setVctDetalles(Vector vVector)
/*     */   {
/*  68 */     this.vctDetalles = vVector;
/*     */   }
/*     */ 
/*     */   public void reset(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/*     */   }
/*     */ 
/*     */   public String getCantidad()
/*     */   {
/*  84 */     return this.cantidad;
/*     */   }
/*     */ 
/*     */   public String getExportFile()
/*     */   {
/*  91 */     return this.exportFile;
/*     */   }
/*     */ 
/*     */   public String getMensaje()
/*     */   {
/*  98 */     return this.mensaje;
/*     */   }
/*     */ 
/*     */   public String getNumProd()
/*     */   {
/* 105 */     return this.numProd;
/*     */   }
/*     */ 
/*     */   public String getVctExpHead()
/*     */   {
/* 112 */     return this.vctExpHead;
/*     */   }
/*     */ 
/*     */   public void setCantidad(String string)
/*     */   {
/* 119 */     this.cantidad = string;
/*     */   }
/*     */ 
/*     */   public void setExportFile(String string)
/*     */   {
/* 126 */     this.exportFile = string;
/*     */   }
/*     */ 
/*     */   public void setMensaje(String string)
/*     */   {
/* 133 */     this.mensaje = string;
/*     */   }
/*     */ 
/*     */   public void setNumProd(String string)
/*     */   {
/* 140 */     this.numProd = string;
/*     */   }
/*     */ 
/*     */   public void setVctExpHead(String string)
/*     */   {
/* 147 */     this.vctExpHead = string;
/*     */   }
/*     */ 
/*     */   public String getHayDatos()
/*     */   {
/* 154 */     return this.hayDatos;
/*     */   }
/*     */ 
/*     */   public void setHayDatos(String string)
/*     */   {
/* 161 */     this.hayDatos = string;
/*     */   }
/*     */ }

/* Location:           C:\sitios\GestionTV_Ripley\trunk\docs\01 Requerimiento\Fuentes Gestión TV\GestionTV-WC7\WEB-INF\classes\
 * Qualified Name:     cl.ripley.GestionTV.struts.form.TodosProductosForm
 * JD-Core Version:    0.6.2
 */