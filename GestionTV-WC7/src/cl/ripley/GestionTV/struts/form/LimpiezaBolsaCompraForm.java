/*    */ package cl.ripley.GestionTV.struts.form;
/*    */ 
/*    */ import java.util.Vector;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import org.apache.struts.action.ActionForm;
/*    */ import org.apache.struts.action.ActionMapping;
/*    */ 
/*    */ public class LimpiezaBolsaCompraForm extends ActionForm
/*    */ {
/*    */   private String accion;
/* 20 */   private Vector vctDetalles = new Vector();
/*    */   private int indice;
/* 24 */   private Vector listaPagina = new Vector();
/*    */   private String mensaje;
/*    */   private String rutFiltro;
/*    */   private String dvFiltro;
/*    */   private String rut;
/*    */ 
/*    */   public String getAccion()
/*    */   {
/* 41 */     return this.accion;
/*    */   }
/*    */ 
/*    */   public void setAccion(String string)
/*    */   {
/* 46 */     this.accion = string;
/*    */   }
/*    */ 
/*    */   public Vector getVctDetalles() {
/* 50 */     return this.vctDetalles;
/*    */   }
/*    */ 
/*    */   public void setVctDetalles(Vector vVector) {
/* 54 */     this.vctDetalles = vVector;
/*    */   }
/*    */ 
/*    */   public void reset(ActionMapping mapping, HttpServletRequest request)
/*    */   {
/*    */   }
/*    */ 
/*    */   public int getIndice()
/*    */   {
/* 64 */     return this.indice;
/*    */   }
/*    */ 
/*    */   public Vector getListaPagina() {
/* 68 */     return this.listaPagina;
/*    */   }
/*    */ 
/*    */   public void setIndice(int i)
/*    */   {
/* 73 */     this.indice = i;
/*    */   }
/*    */ 
/*    */   public void setListaPagina(Vector vector) {
/* 77 */     this.listaPagina = vector;
/*    */   }
/*    */ 
/*    */   public String getMensaje()
/*    */   {
/* 82 */     return this.mensaje;
/*    */   }
/*    */ 
/*    */   public void setMensaje(String string) {
/* 86 */     this.mensaje = string;
/*    */   }
/*    */ 
/*    */   public String getRut()
/*    */   {
/* 91 */     return this.rut;
/*    */   }
/*    */ 
/*    */   public void setRut(String rut) {
/* 95 */     this.rut = rut;
/*    */   }
/*    */ }

/* Location:           C:\sitios\GestionTV_Ripley\trunk\docs\01 Requerimiento\Fuentes Gestión TV\GestionTV-WC7\WEB-INF\classes\
 * Qualified Name:     cl.ripley.GestionTV.struts.form.LimpiezaBolsaCompraForm
 * JD-Core Version:    0.6.2
 */