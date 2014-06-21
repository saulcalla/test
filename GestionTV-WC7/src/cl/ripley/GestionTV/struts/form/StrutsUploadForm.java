/*    */ package cl.ripley.GestionTV.struts.form;
/*    */ 
/*    */ import org.apache.struts.action.ActionForm;
/*    */ import org.apache.struts.upload.FormFile;
/*    */ 
/*    */ public class StrutsUploadForm extends ActionForm
/*    */ {
/*    */   private FormFile theFile;
/*    */ 
/*    */   public FormFile getTheFile()
/*    */   {
/* 26 */     return this.theFile;
/*    */   }
/*    */ 
/*    */   public void setTheFile(FormFile theFile)
/*    */   {
/* 32 */     this.theFile = theFile;
/*    */   }
/*    */ }

/* Location:           C:\sitios\GestionTV_Ripley\trunk\docs\01 Requerimiento\Fuentes Gestión TV\GestionTV-WC7\WEB-INF\classes\
 * Qualified Name:     cl.ripley.GestionTV.struts.form.StrutsUploadForm
 * JD-Core Version:    0.6.2
 */