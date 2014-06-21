 package cl.ripley.GestionTV.struts.form;
 
 import javax.servlet.http.HttpServletRequest;
 import org.apache.struts.action.ActionForm;
 import org.apache.struts.action.ActionMapping;
 
 public class ActivacionGCPForm extends ActionForm
 {
   private static final long serialVersionUID = 1L;
   private String accion;
   private String flagDatosBD = "si";
   private String hayDatos;
   private String mensaje;
   private String temp = "no";
   private String numTarjetaGCP;
   private String montoActivacion;
   private String numTarjetaCAR;
   private String numCuotas;
   private String voucher_mirror;
   private String activacion;
   private String mailCliente;
   private String opcion;
   private String voucherHTML;
   private String linkVoucherHTML = "http://localhost";
   private String mes_vencimiento;
   private String anio_vencimiento;
   private String cvv;
 
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
 
   public String getMontoActivacion()
   {
     return this.montoActivacion;
   }
 
   public void setMontoActivacion(String montoActivacion) {
     this.montoActivacion = montoActivacion;
   }
 
   public String getNumTarjetaCAR() {
     return this.numTarjetaCAR;
   }
 
   public void setNumTarjetaCAR(String numTarjetaCAR) {
     this.numTarjetaCAR = numTarjetaCAR;
   }
 
   public String getNumTarjetaGCP() {
     return this.numTarjetaGCP;
   }
 
   public void setNumTarjetaGCP(String numTarjetaGCP) {
     this.numTarjetaGCP = numTarjetaGCP;
   }
 
   public String getTemp() {
     return this.temp;
   }
 
   public void setTemp(String temp) {
     this.temp = temp;
   }
 
   public String getNumCuotas() {
     return this.numCuotas;
   }
 
   public void setNumCuotas(String numCuotas) {
     this.numCuotas = numCuotas;
   }
 
   public String getVoucher_mirror() {
     return this.voucher_mirror;
   }
 
   public void setVoucher_mirror(String resp_mirror) {
     this.voucher_mirror = resp_mirror;
   }
 
   public String getActivacion() {
     return this.activacion;
   }
 
   public void setActivacion(String activacion) {
     this.activacion = activacion;
   }
 
   public String getMailCliente() {
     return this.mailCliente;
   }
 
   public void setMailCliente(String mailCliente) {
     this.mailCliente = mailCliente;
   }
 
   public String getVoucherHTML() {
     return this.voucherHTML;
   }
 
   public void setVoucherHTML(String voucherHTML) {
     this.voucherHTML = voucherHTML;
   }
 
   public String getLinkVoucherHTML() {
     return this.linkVoucherHTML;
   }
 
   public String getLinkVoucher()
   {
     String url = getLinkVoucherHTML();
 
     return url.substring(38);
   }
 
   public void setLinkVoucherHTML(String linkVoucherHTML) {
     this.linkVoucherHTML = linkVoucherHTML;
   }
 
   public String getOpcion() {
     return this.opcion;
   }
 
   public void setOpcion(String opcion) {
     this.opcion = opcion;
   }
 
   public String getCvv() {
     return this.cvv;
   }
 
   public void setCvv(String cvv) {
     this.cvv = cvv;
   }
 
   public String getMes_vencimiento() {
     return this.mes_vencimiento;
   }
 
   public void setMes_vencimiento(String mes_vencimiento) {
     this.mes_vencimiento = mes_vencimiento;
   }
 
   public String getAnio_vencimiento() {
     return this.anio_vencimiento;
   }
 
   public void setAnio_vencimiento(String anio_vencimiento) {
     this.anio_vencimiento = anio_vencimiento;
   }
 }

/* Location:           C:\sitios\GestionTV_Ripley\trunk\docs\01 Requerimiento\Fuentes Gestión TV\GestionTV-WC7\WEB-INF\classes\
 * Qualified Name:     cl.ripley.GestionTV.struts.form.ActivacionGCPForm
 * JD-Core Version:    0.6.2
 */