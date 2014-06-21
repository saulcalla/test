 package cl.ripley.GestionTV.struts.form;
 
 import javax.servlet.http.HttpServletRequest;
 import org.apache.struts.action.ActionForm;
 import org.apache.struts.action.ActionMapping;
 
 public class AperturaCierreGCPForm extends ActionForm
 {
   private String accion;
   private String flagDatosBD = "si";
   private String hayDatos;
   private String mensaje;
   private String temp = "no";
   private String aperturaCierre;
   private String fec_inicio;
 
   public String getAccion()
   {
     return this.accion;
   }
 
   public void setAccion(String string)
   {
     this.accion = string;
   }
 
   public void reset(ActionMapping mapping, HttpServletRequest request)
   {
   }
 
   public String getHayDatos()
   {
     return this.hayDatos;
   }
 
   public void setHayDatos(String string) {
     this.hayDatos = string;
   }
 
   public String getMensaje() {
     return this.mensaje;
   }
 
   public void setMensaje(String string) {
     this.mensaje = string;
   }
 
   public String getFlagDatosBD() {
     return this.flagDatosBD;
   }
 
   public void setFlagDatosBD(String string) {
     this.flagDatosBD = string;
   }
 
   public String getTemp()
   {
     return this.temp;
   }
 
   public void setTemp(String temp) {
     this.temp = temp;
   }
 
   public String getAperturaCierre()
   {
     return this.aperturaCierre;
   }
 
   public void setAperturaCierre(String aperturaCierre) {
     this.aperturaCierre = aperturaCierre;
   }
 
   public String getFec_inicio()
   {
     return this.fec_inicio;
   }
 
   public void setFec_inicio(String fec_inicio)
   {
     this.fec_inicio = fec_inicio;
   }
 }

/* Location:           C:\sitios\GestionTV_Ripley\trunk\docs\01 Requerimiento\Fuentes Gestión TV\GestionTV-WC7\WEB-INF\classes\
 * Qualified Name:     cl.ripley.GestionTV.struts.form.AperturaCierreGCPForm
 * JD-Core Version:    0.6.2
 */