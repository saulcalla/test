/*     */ package cl.ripley.GestionTV.struts.form;
/*     */ 
/*     */ import java.util.Vector;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ 
/*     */ public class ProductoSinStockForm extends ActionForm
/*     */ {
/*     */   private String accion;
/*  19 */   private Vector vctDetalles = new Vector();
/*     */   private String exportFile;
/*     */   private String mensaje;
/*     */   private String vctExpHead;
/*     */   private String numProd;
/*     */   private String cantidad;
/*     */   private String hayDatos;
/*     */   private String bodega;
/*     */   private String dispBigticket;
/*     */   private String reservInternet;
/*     */   private String stockTvi;
/*     */ 
/*     */   public String getAccion()
/*     */   {
/*  39 */     return this.accion;
/*     */   }
/*     */ 
/*     */   public void setAccion(String string)
/*     */   {
/*  51 */     this.accion = string;
/*     */   }
/*     */ 
/*     */   public Vector getVctDetalles()
/*     */   {
/*  61 */     return this.vctDetalles;
/*     */   }
/*     */ 
/*     */   public void setVctDetalles(Vector vVector)
/*     */   {
/*  73 */     this.vctDetalles = vVector;
/*     */   }
/*     */ 
/*     */   public void reset(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/*     */   }
/*     */ 
/*     */   public String getCantidad()
/*     */   {
/*  89 */     return this.cantidad;
/*     */   }
/*     */ 
/*     */   public String getExportFile()
/*     */   {
/*  96 */     return this.exportFile;
/*     */   }
/*     */ 
/*     */   public String getMensaje()
/*     */   {
/* 103 */     return this.mensaje;
/*     */   }
/*     */ 
/*     */   public String getNumProd()
/*     */   {
/* 110 */     return this.numProd;
/*     */   }
/*     */ 
/*     */   public String getVctExpHead()
/*     */   {
/* 117 */     return this.vctExpHead;
/*     */   }
/*     */ 
/*     */   public void setCantidad(String string)
/*     */   {
/* 124 */     this.cantidad = string;
/*     */   }
/*     */ 
/*     */   public void setExportFile(String string)
/*     */   {
/* 131 */     this.exportFile = string;
/*     */   }
/*     */ 
/*     */   public void setMensaje(String string)
/*     */   {
/* 138 */     this.mensaje = string;
/*     */   }
/*     */ 
/*     */   public void setNumProd(String string)
/*     */   {
/* 145 */     this.numProd = string;
/*     */   }
/*     */ 
/*     */   public void setVctExpHead(String string)
/*     */   {
/* 152 */     this.vctExpHead = string;
/*     */   }
/*     */ 
/*     */   public String getHayDatos()
/*     */   {
/* 159 */     return this.hayDatos;
/*     */   }
/*     */ 
/*     */   public void setHayDatos(String string)
/*     */   {
/* 166 */     this.hayDatos = string;
/*     */   }
/*     */ 
/*     */   public String getBodega() {
/* 170 */     return this.bodega;
/*     */   }
/*     */ 
/*     */   public void setBodega(String bodega) {
/* 174 */     this.bodega = bodega;
/*     */   }
/*     */ 
/*     */   public String getDispBigticket() {
/* 178 */     return this.dispBigticket;
/*     */   }
/*     */ 
/*     */   public void setDispBigticket(String dispBigticket) {
/* 182 */     this.dispBigticket = dispBigticket;
/*     */   }
/*     */ 
/*     */   public String getReservInternet() {
/* 186 */     return this.reservInternet;
/*     */   }
/*     */ 
/*     */   public void setReservInternet(String reservInternet) {
/* 190 */     this.reservInternet = reservInternet;
/*     */   }
/*     */ 
/*     */   public String getStockTvi() {
/* 194 */     return this.stockTvi;
/*     */   }
/*     */ 
/*     */   public void setStockTvi(String stockTvi) {
/* 198 */     this.stockTvi = stockTvi;
/*     */   }
/*     */ }

/* Location:           C:\sitios\GestionTV_Ripley\trunk\docs\01 Requerimiento\Fuentes Gestión TV\GestionTV-WC7\WEB-INF\classes\
 * Qualified Name:     cl.ripley.GestionTV.struts.form.ProductoSinStockForm
 * JD-Core Version:    0.6.2
 */