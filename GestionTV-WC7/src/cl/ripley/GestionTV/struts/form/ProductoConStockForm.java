/*     */ package cl.ripley.GestionTV.struts.form;
/*     */ 
/*     */ import java.util.Vector;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ 
/*     */ public class ProductoConStockForm extends ActionForm
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
/*     */   public String getExportFile()
/*     */   {
/*  84 */     return this.exportFile;
/*     */   }
/*     */ 
/*     */   public void setExportFile(String string)
/*     */   {
/*  91 */     this.exportFile = string;
/*     */   }
/*     */ 
/*     */   public String getMensaje()
/*     */   {
/*  98 */     return this.mensaje;
/*     */   }
/*     */ 
/*     */   public void setMensaje(String string)
/*     */   {
/* 105 */     this.mensaje = string;
/*     */   }
/*     */ 
/*     */   public String getVctExpHead()
/*     */   {
/* 114 */     return this.vctExpHead;
/*     */   }
/*     */ 
/*     */   public void setVctExpHead(String string)
/*     */   {
/* 121 */     this.vctExpHead = string;
/*     */   }
/*     */ 
/*     */   public String getCantidad()
/*     */   {
/* 128 */     return this.cantidad;
/*     */   }
/*     */ 
/*     */   public String getNumProd()
/*     */   {
/* 135 */     return this.numProd;
/*     */   }
/*     */ 
/*     */   public void setCantidad(String string)
/*     */   {
/* 142 */     this.cantidad = string;
/*     */   }
/*     */ 
/*     */   public void setNumProd(String string)
/*     */   {
/* 149 */     this.numProd = string;
/*     */   }
/*     */ 
/*     */   public String getHayDatos()
/*     */   {
/* 156 */     return this.hayDatos;
/*     */   }
/*     */ 
/*     */   public void setHayDatos(String string)
/*     */   {
/* 163 */     this.hayDatos = string;
/*     */   }
/*     */ }

/* Location:           C:\sitios\GestionTV_Ripley\trunk\docs\01 Requerimiento\Fuentes Gestión TV\GestionTV-WC7\WEB-INF\classes\
 * Qualified Name:     cl.ripley.GestionTV.struts.form.ProductoConStockForm
 * JD-Core Version:    0.6.2
 */