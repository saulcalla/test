/*    */ package cl.ripley.GestionTV.struts.form;
/*    */ 
/*    */ import org.apache.struts.action.ActionForm;
/*    */ 
/*    */ public class CargaStockBTForm extends ActionForm
/*    */ {
/*    */   private String accion;
/*    */   private String hayDatos;
/*    */   private String mensaje;
/* 22 */   private int tot_registros = 0;
/*    */ 
/*    */   public String getAccion()
/*    */   {
/* 33 */     return this.accion;
/*    */   }
/*    */ 
/*    */   public void setAccion(String string)
/*    */   {
/* 45 */     this.accion = string;
/*    */   }
/*    */ 
/*    */   public String getHayDatos()
/*    */   {
/* 50 */     return this.hayDatos;
/*    */   }
/*    */ 
/*    */   public void setHayDatos(String hayDatos) {
/* 54 */     this.hayDatos = hayDatos;
/*    */   }
/*    */ 
/*    */   public int getTot_registros() {
/* 58 */     return this.tot_registros;
/*    */   }
/*    */ 
/*    */   public void setTot_registros(int tot_registros) {
/* 62 */     this.tot_registros = tot_registros;
/*    */   }
/*    */ 
/*    */   public String getMensaje() {
/* 66 */     return this.mensaje;
/*    */   }
/*    */ 
/*    */   public void setMensaje(String mensaje) {
/* 70 */     this.mensaje = mensaje;
/*    */   }
/*    */ }

/* Location:           C:\sitios\GestionTV_Ripley\trunk\docs\01 Requerimiento\Fuentes Gestión TV\GestionTV-WC7\WEB-INF\classes\
 * Qualified Name:     cl.ripley.GestionTV.struts.form.CargaStockBTForm
 * JD-Core Version:    0.6.2
 */