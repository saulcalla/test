 package cl.ripley.GestionTV.struts.form;
 
 import java.util.Vector;
 import org.apache.struts.action.ActionForm;
 import org.apache.struts.upload.FormFile;
 
 public class ActualizaStockForm extends ActionForm
 {
   private String accion;
   private int contador = 0;
   private String flagDatosBD = "si";
   private String actualiza = "no";
   private String hayDatos;
   private String hayDatosExportar;
   private String hayProximoBloque;
   private int total_registros;
   private String mensaje;
   private String tipoBorrado;
   private Vector preview;
   private Vector sql_delete;
   private FormFile theFile;
 
   public FormFile getTheFile()
   {
     return this.theFile;
   }
 
   public void setTheFile(FormFile theFile)
   {
     this.theFile = theFile;
   }
 
   public String getAccion()
   {
     return this.accion;
   }
 
   public void setAccion(String string)
   {
     this.accion = string;
   }
 
   public int getContador()
   {
     return this.contador;
   }
 
   public String getHayDatos()
   {
     return this.hayDatos;
   }
 
   public String getHayProximoBloque()
   {
     return this.hayProximoBloque;
   }
 
   public int getTotal_registros()
   {
     return this.total_registros;
   }
 
   public void setContador(int i)
   {
     this.contador = i;
   }
 
   public void setHayDatos(String string)
   {
     this.hayDatos = string;
   }
 
   public void setHayProximoBloque(String string)
   {
     this.hayProximoBloque = string;
   }
 
   public void setTotal_registros(int i)
   {
     this.total_registros = i;
   }
 
   public String getFlagDatosBD()
   {
     return this.flagDatosBD;
   }
 
   public void setFlagDatosBD(String string)
   {
     this.flagDatosBD = string;
   }
 
   public String getHayDatosExportar()
   {
     return this.hayDatosExportar;
   }
 
   public void setHayDatosExportar(String string)
   {
     this.hayDatosExportar = string;
   }
 
   public String getActualiza()
   {
     return this.actualiza;
   }
 
   public void setActualiza(String actualiza) {
     this.actualiza = actualiza;
   }
   public String getMensaje() {
     return this.mensaje;
   }
   public void setMensaje(String mensaje) {
     this.mensaje = mensaje;
   }
   public String getTipoBorrado() {
     return this.tipoBorrado;
   }
   public void setTipoBorrado(String tipoBorrado) {
     this.tipoBorrado = tipoBorrado;
   }
   public Vector getPreview() {
     return this.preview;
   }
   public void setPreview(Vector preview) {
     this.preview = preview;
   }
   public Vector getSql_delete() {
     return this.sql_delete;
   }
   public void setSql_delete(Vector sql_delete) {
     this.sql_delete = sql_delete;
   }
 }

/* Location:           C:\sitios\GestionTV_Ripley\trunk\docs\01 Requerimiento\Fuentes Gestión TV\GestionTV-WC7\WEB-INF\classes\
 * Qualified Name:     cl.ripley.GestionTV.struts.form.ActualizaStockForm
 * JD-Core Version:    0.6.2
 */