/*    */ package cl.ripley.GestionTV.struts.form;
/*    */ 
/*    */ import java.util.Vector;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import org.apache.struts.action.ActionForm;
/*    */ import org.apache.struts.action.ActionMapping;
/*    */ 
/*    */ public class PopupForm extends ActionForm
/*    */ {
/*    */   private String accion;
/* 19 */   private Vector vctDetalles = new Vector();
/*    */   private String glosa_est;
/*    */   private String glosa_prop;
/*    */   private String glosa_url;
/*    */   private int idpopup;
/*    */   private String mensaje;
/*    */ 
/*    */   public String getAccion()
/*    */   {
/* 30 */     return this.accion;
/*    */   }
/*    */   public void setAccion(String string) {
/* 33 */     this.accion = string;
/*    */   }
/*    */   public Vector getVctDetalles() {
/* 36 */     return this.vctDetalles;
/*    */   }
/*    */ 
/*    */   public void setVctDetalles(Vector vVector) {
/* 40 */     this.vctDetalles = vVector;
/*    */   }
/*    */ 
/*    */   public void reset(ActionMapping mapping, HttpServletRequest request) {
/*    */   }
/*    */ 
/*    */   public String getGlosa_est() {
/* 47 */     return this.glosa_est;
/*    */   }
/*    */   public String getGlosa_prop() {
/* 50 */     return this.glosa_prop;
/*    */   }
/*    */   public String getGlosa_url() {
/* 53 */     return this.glosa_url;
/*    */   }
/*    */   public void setGlosa_est(String string) {
/* 56 */     this.glosa_est = string;
/*    */   }
/*    */   public void setGlosa_prop(String string) {
/* 59 */     this.glosa_prop = string;
/*    */   }
/*    */   public void setGlosa_url(String string) {
/* 62 */     this.glosa_url = string;
/*    */   }
/*    */   public String getMensaje() {
/* 65 */     return this.mensaje;
/*    */   }
/*    */   public void setMensaje(String string) {
/* 68 */     this.mensaje = string;
/*    */   }
/*    */   public int getIdpopup() {
/* 71 */     return this.idpopup;
/*    */   }
/*    */   public void setIdpopup(int i) {
/* 74 */     this.idpopup = i;
/*    */   }
/*    */ }

/* Location:           C:\sitios\GestionTV_Ripley\trunk\docs\01 Requerimiento\Fuentes Gestión TV\GestionTV-WC7\WEB-INF\classes\
 * Qualified Name:     cl.ripley.GestionTV.struts.form.PopupForm
 * JD-Core Version:    0.6.2
 */