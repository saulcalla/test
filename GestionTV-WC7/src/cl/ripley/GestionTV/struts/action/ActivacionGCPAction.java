 package cl.ripley.GestionTV.struts.action;
 
 import cl.ripley.GestionTV.struts.bean.ActivacionGCPBean;
 import cl.ripley.GestionTV.struts.form.ActivacionGCPForm;
 import java.text.SimpleDateFormat;
 import java.util.Calendar;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import javax.servlet.http.HttpSession;
 import org.apache.log4j.Logger;
 import org.apache.struts.action.Action;
 import org.apache.struts.action.ActionForm;
 import org.apache.struts.action.ActionForward;
 import org.apache.struts.action.ActionMapping;
 import org.apache.struts.util.MessageResources;
 
 public class ActivacionGCPAction extends Action
 {
   protected static MessageResources messages = MessageResources.getMessageResources("cl.ripley.GestionTV.struts.msgGestionTV");
 
   static Logger log = Logger.getRootLogger();
 
   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
     throws Exception
   {
     String Conectado = (String)request.getSession().getAttribute("Conectado");
     String sucursal = messages.getMessage("activacionGcp.sucursal");
     String caja = messages.getMessage("activacionGcp.caja");
     SimpleDateFormat sdf = new SimpleDateFormat(messages.getMessage("constante.FORMATO_FECHA_GCP"));
     Calendar fecha_hoy = Calendar.getInstance();
 
     if (Conectado == null) {
       return mapping.findForward("timeOut");
     }
 
     ActivacionGCPForm conForm = (ActivacionGCPForm)form;
     ActivacionGCPBean conBean = new ActivacionGCPBean();
 
     String idUsuario = (String)request.getSession().getAttribute("strRutUsr");
     String nombreUsuario = (String)request.getSession().getAttribute("strNomUsr");
     String usuario = nombreUsuario;
     String num_tarjeta = conForm.getNumTarjetaCAR();
     boolean cft = false;
 
     if (conForm.getAccion().equals("InicioActivacionGCP"))
     {
       conForm.setHayDatos("no");
       conForm.setFlagDatosBD("si");
       conForm.setTemp("no");
       conForm.setVoucher_mirror("");
       conForm.setActivacion("");
       conForm.setMailCliente("");
 
       conForm.setMensaje("");
       return mapping.findForward("iniciar");
     }
 
     if (conForm.getAccion().equals("activar"))
     {
       conForm.setHayDatos("no");
       conForm.setMensaje("");
       conForm.setTemp("si");
       conForm.setVoucher_mirror("");
       conForm.setActivacion("");
       conForm.setMailCliente("");
       conBean.setPlazo_activ("3");
       conForm.setMensaje("");
       conBean.setMens_error("");
       conBean.setMensaje("");
       conBean.setAnio_vencimiento(conForm.getAnio_vencimiento());
       conBean.setCvv(conForm.getCvv());
       conBean.setMes_vencimiento(conForm.getMes_vencimiento());
       try
       {
         if (conForm.getNumTarjetaCAR().regionMatches(0, "628156", 0, 6)) {
           cft = true;
           String valida_cft = "";
           conBean.setNum_pan(conForm.getNumTarjetaCAR());
           valida_cft = conBean.validaTarjetaCFT(conForm.getNumTarjetaCAR(), conForm.getCvv(), conForm.getMes_vencimiento(), conForm.getAnio_vencimiento().substring(2));
 
           if (valida_cft == null) {
             conForm.setMensaje(conBean.getMens_error());
             conForm.setFlagDatosBD("CFT");
 
             return mapping.findForward("iniciar");
           }
           num_tarjeta = conBean.generaTarjetaCAR(valida_cft);
         }
       }
       catch (Exception e) {
         log.error(e);
         conForm.setMensaje("ERROR AL VALIDAR TARJETA RIPLEY");
         return mapping.findForward("iniciar");
       }
 		String valid_cli;
       try
       {
         conForm.setFlagDatosBD("");
         valid_cli = conBean.validaClienteCAR(num_tarjeta);
       }
       catch (Exception e)
       {
         conForm.setMensaje("ERROR AL VALIDAR CLIENTE");
         log.error(e);
         return mapping.findForward("iniciar");
       }
 
       try
       {
         conBean.getValidacionActivacion(getDataSource(request, "BOGCP"), 
           conForm.getNumTarjetaGCP(), 
           conForm.getMontoActivacion());
       }
       catch (Exception e)
       {
         conForm.setMensaje("ERROR AL VALIDAR ACTIVACION GCP");
         log.error(e);
         return mapping.findForward("iniciar");
       }
 
       try
       {
         conBean.aperturaCierreAutomatico(getDataSource(request, "BO"), getDataSource(request, "BOGCP"), 
           sucursal, caja, "42", fecha_hoy.getTime(), idUsuario);
 
         boolean apertura = conBean.validaAperturaCierre(
           getDataSource(request, "BO"), sucursal, caja, "42", 
           fecha_hoy.getTime());
 
         if (!apertura)
         {
           int resp_ape_cie = conBean.insertaAperturaCierre(
             getDataSource(request, "BO"), getDataSource(request, "BOGCP"), sucursal, caja, 
             "42", fecha_hoy.getTime(), idUsuario);
 
           if (resp_ape_cie < 0)
           {
             conForm.setMensaje("ERROR GENERANDO TRX DE APERTURA EN BO");
 
             conBean.insertaAUDITORIA(getDataSource(request, "BOGCP"), usuario, idUsuario, conForm.getNumCuotas(), 
               conForm.getNumTarjetaGCP(), num_tarjeta, 
               conForm.getMontoActivacion(), "99", "9", "ERROR GENERANDO TRX DE APERTURA EN BO");
 
             return mapping.findForward("iniciar");
           }
         }
       }
       catch (Exception e) {
         log.error(e);
         conForm.setMensaje(conBean.getMens_error());
 
         conBean.insertaAUDITORIA(getDataSource(request, "BOGCP"), usuario, idUsuario, conForm.getNumCuotas(), 
           conForm.getNumTarjetaGCP(), num_tarjeta, conForm.getMontoActivacion(), 
           "99", "9", "ERROR GENERANDO TRX APERTURA-CIERRE AUTOMATICO EN BO");
 
         return mapping.findForward("iniciar");
       }
 
       if (conBean.getMens_error().equals(""))
       {
         String mens_mirror = conBean.generaMensajeMirror(getDataSource(request, "BOGCP"), 
           conForm.getNumCuotas(), num_tarjeta, 
           conForm.getMontoActivacion());
 
         if (mens_mirror == null) {
           conForm.setMensaje("ERROR AL GENERAR MENSAJE DE ACTIVACION \n INTENTE NUEVAMENTE...");
 
           conBean.insertaAUDITORIA(getDataSource(request, "BOGCP"), usuario, idUsuario, conForm.getNumCuotas(), 
             conForm.getNumTarjetaGCP(), num_tarjeta, conForm.getMontoActivacion(), 
             "99", "9", "ERROR AL GENERAR MENSAJE MIRROR DE ACTIVACION");
 
           return mapping.findForward("iniciar");
         }
 
         String resp_mirror = conBean.activacionGCPMirror(mens_mirror, true, 
           num_tarjeta, conForm.getNumTarjetaGCP(), 
           conForm.getMontoActivacion(), usuario);
 
         if (resp_mirror == null)
         {
           conForm.setMensaje(conBean.getMens_error());
 
           conBean.insertaAUDITORIA(getDataSource(request, "BOGCP"), usuario, idUsuario, conForm.getNumCuotas(), 
             conForm.getNumTarjetaGCP(), num_tarjeta, conForm.getMontoActivacion(), 
             "99", "9", conForm.getMensaje());
 
           return mapping.findForward("iniciar");
         }
 
         conBean.getNumeroTransaccion(getDataSource(request, "BOGCP"));
         int resp_sql = 0;
         String mens_error = "";
 
         resp_sql = conBean.activacionGCP(getDataSource(request, "BOGCP"), 
           conForm.getNumTarjetaGCP(), 
           conForm.getMontoActivacion());
 
         if (resp_sql >= 0)
         {
           resp_sql = conBean.insertaTRX_ABONOS(getDataSource(request, "BO"), 
             conForm.getNumCuotas(), conForm.getNumTarjetaGCP(), 
             conForm.getMontoActivacion(), "28", "401");
 
           if (resp_sql >= 0)
           {
             resp_sql = conBean.insertaTRX_TRANSACCION(getDataSource(request, "BO"), 
               conForm.getNumCuotas(), conForm.getNumTarjetaGCP(), 
               conForm.getMontoActivacion(), "28", idUsuario);
 
             if (resp_sql >= 0) {
               resp_sql = conBean.insertaTRX_TAR_RIPLEY(getDataSource(request, "BO"), 
                 conForm.getNumCuotas(), conForm.getMontoActivacion(), 
                 num_tarjeta);
 
               if (resp_sql >= 0) {
                 conForm.setActivacion("ok");
                 conForm.setVoucher_mirror(conBean.getVoucher());
                 conForm.setVoucherHTML(conBean.getVoucherHTML());
                 conForm.setLinkVoucherHTML(conBean.getLink_voucherHTML());
                 conForm.setOpcion("activar");
 
                 conBean.insertaAUDITORIA(getDataSource(request, "BOGCP"), usuario, idUsuario, conForm.getNumCuotas(), 
                   conForm.getNumTarjetaGCP(), num_tarjeta, conForm.getMontoActivacion(), 
                   "28", "1", "ACTIVACION");
 
                 return mapping.findForward("iniciar");
               }
 
               mens_error = "ERROR INSERTAR TABLAS BO - TRX_TAR_RIPLEY";
             }
             else
             {
               mens_error = "ERROR INSERTAR TABLAS BO - TRX_TRANSACCION";
             }
           } else {
             mens_error = "ERROR INSERTAR TABLAS BO - TRX_ABONOS";
           }
         }
         else {
           mens_error = "ERROR INSERTAR TABLAS GCP";
         }
 
         if (resp_sql < 0)
         {
           conBean.insertaAUDITORIA(getDataSource(request, "BOGCP"), usuario, idUsuario, conForm.getNumCuotas(), 
             conForm.getNumTarjetaGCP(), num_tarjeta, conForm.getMontoActivacion(), 
             "99", "9", mens_error);
         }
 
       }
 
       conForm.setMensaje(conBean.getMens_error());
 
       return mapping.findForward("iniciar");
     }
 
     if (conForm.getAccion().equals("desactivar"))
     {
       conForm.setHayDatos("no");
       conForm.setMensaje("");
       conForm.setTemp("si");
       conForm.setVoucher_mirror("");
       conForm.setActivacion("");
       conForm.setMailCliente("");
       String mens_error = "";
       conForm.setMensaje("");
       conBean.setMens_error("");
       conBean.setMensaje("");
       try
       {
         if (conForm.getNumTarjetaCAR().regionMatches(0, "628156", 0, 6)) {
           cft = true;
           String valida_cft = "";
           conBean.setNum_pan(conForm.getNumTarjetaCAR());
           valida_cft = conBean.validaTarjetaCFT(conForm.getNumTarjetaCAR(), conForm.getCvv(), conForm.getMes_vencimiento(), conForm.getAnio_vencimiento().substring(2));
 
           if (valida_cft == null) {
             conForm.setMensaje(conBean.getMens_error());
             conForm.setFlagDatosBD("CFT");
 
             return mapping.findForward("iniciar");
           }
           num_tarjeta = conBean.generaTarjetaCAR(valida_cft);
         }
       }
       catch (Exception e) {
         log.error(e);
         conForm.setMensaje("ERROR AL VALIDAR TARJETA RIPLEY");
         return mapping.findForward("iniciar");
       }
 
       boolean des_gcp = conBean.getValidacionDesActivacion(getDataSource(request, "BOGCP"), 
         conForm.getNumTarjetaGCP(), 
         conForm.getMontoActivacion());
 
       if (!des_gcp) {
         conForm.setMensaje(conBean.getMens_error());
         return mapping.findForward("iniciar");
       }
 
       try
       {
         conBean.aperturaCierreAutomatico(getDataSource(request, "BO"), getDataSource(request, "BOGCP"), 
           sucursal, caja, "42", fecha_hoy.getTime(), idUsuario);
 
         boolean apertura = conBean.validaAperturaCierre(
           getDataSource(request, "BO"), sucursal, caja, "42", 
           fecha_hoy.getTime());
 
         if (!apertura)
         {
           int resp_ape_cie = conBean.insertaAperturaCierre(
             getDataSource(request, "BO"), getDataSource(request, "BOGCP"), sucursal, caja, 
             "42", fecha_hoy.getTime(), idUsuario);
 
           if (resp_ape_cie < 0)
           {
             conForm.setMensaje("ERROR GENERANDO TRX DE APERTURA EN BO");
 
             conBean.insertaAUDITORIA(getDataSource(request, "BOGCP"), usuario, idUsuario, conForm.getNumCuotas(), 
               conForm.getNumTarjetaGCP(), num_tarjeta, 
               conForm.getMontoActivacion(), "99", "9", "ERROR GENERANDO TRX DE APERTURA EN BO");
 
             return mapping.findForward("iniciar");
           }
         }
       }
       catch (Exception e) {
         log.error(e);
         conForm.setMensaje(conBean.getMens_error());
 
         conBean.insertaAUDITORIA(getDataSource(request, "BOGCP"), usuario, idUsuario, conForm.getNumCuotas(), 
           conForm.getNumTarjetaGCP(), num_tarjeta, conForm.getMontoActivacion(), 
           "99", "9", "ERROR GENERANDO TRX APERTURA-CIERRE AUTOMATICO EN BO");
 
         return mapping.findForward("iniciar");
       }
 
       boolean anulacion = false;
 
       if (cft) {
         anulacion = conBean.getDocumentoOriginal(getDataSource(request, "BOGCP"), 
           conForm.getNumTarjetaGCP(), conForm.getMontoActivacion(), 
           conForm.getNumTarjetaCAR());
       }
       else {
         anulacion = conBean.getDocumentoOriginal(getDataSource(request, "BOGCP"), 
           conForm.getNumTarjetaGCP(), conForm.getMontoActivacion(), 
           num_tarjeta);
       }
 
       if (anulacion)
       {
         String plazo_orig = String.valueOf(conBean
           .getPlazo_original());
 
         String monto_orig = String.valueOf(conBean
           .getMonto_original());
 
         String msj_anulacion_mirror = conBean.generaMensajeAnulacionMirror(getDataSource(
           request, "BOGCP"), num_tarjeta);
 
         String resp_mirror = conBean.activacionGCPMirror(
           msj_anulacion_mirror, false, num_tarjeta, 
           conForm.getNumTarjetaGCP(), conForm.getMontoActivacion(), usuario);
 
         if (resp_mirror == null) {
           conForm.setMensaje(conBean.getMens_error());
         }
         else
         {
           conBean.getNumeroTransaccion(getDataSource(request, "BOGCP"));
 
           int resp_sql = 0;
           resp_sql = conBean.insertaAUDITORIA(getDataSource(
             request, "BOGCP"), usuario, idUsuario, plazo_orig, 
             conForm.getNumTarjetaGCP(), num_tarjeta, monto_orig, 
             "38", "2", "ANULACION");
 
           if (conBean.anulacionGCP(getDataSource(request, 
             "BOGCP"), conForm.getNumTarjetaGCP()))
           {
             resp_sql = conBean.insertaTRX_ABONOS(
               getDataSource(request, "BO"), 
               plazo_orig, conForm.getNumTarjetaGCP(), 
               monto_orig, "38", "402");
 
             if (resp_sql >= 0)
             {
               resp_sql = conBean.insertaTRX_TRANSACCION(
                 getDataSource(request, "BO"), 
                 plazo_orig, conForm
                 .getNumTarjetaGCP(), 
                 monto_orig, "38", idUsuario);
 
               if (resp_sql >= 0) {
                 resp_sql = conBean
                   .insertaTRX_TAR_RIPLEY(
                   getDataSource(request, 
                   "BO"), 
                   plazo_orig, 
                   monto_orig, 
                   num_tarjeta);
 
                 if (resp_sql >= 0)
                 {
                   conForm.setActivacion("ok");
                   conForm.setOpcion("desactivar");
                   conForm.setVoucher_mirror(conBean
                     .getVoucher());
                   conForm.setVoucherHTML(conBean
                     .getVoucherHTML());
                   conForm.setLinkVoucherHTML(conBean
                     .getLink_voucherHTML());
                   conForm
                     .setMensaje("TARJETA ANULADA EXITOSAMENTE.");
 
                   return mapping
                     .findForward("iniciar");
                 }
                 mens_error = "ERROR INSERTAR TABLAS BO - TRX_TAR_RIPLEY";
               }
               else {
                 mens_error = "ERROR INSERTAR TABLAS BO - TRX_TRANSACCION";
               }
             }
             else
             {
               mens_error = "ERROR INSERTAR TABLAS BO - TRX_ABONOS";
             }
           }
           else {
             mens_error = "ERROR ANULACION TABLAS GCP";
           }
           conForm.setMensaje(conBean.getMens_error());
         }
       }
       else
       {
         mens_error = "ANULACION - ERROR OBTENER DOC. ORIGINAL";
       }
 
       conBean.insertaAUDITORIA(getDataSource(request, "BOGCP"), usuario, idUsuario, conForm.getNumCuotas(), 
         conForm.getNumTarjetaGCP(), num_tarjeta, conForm.getMontoActivacion(), 
         "99", "9", mens_error);
 
       conForm.setMensaje(conBean.getMens_error());
 
       return mapping.findForward("iniciar");
     }
     if (conForm.getAccion().equals("enviarMail"))
     {
       String resp = conBean.enviaMail(conForm.getMailCliente(), conForm.getNumTarjetaGCP(), 
         conForm.getVoucherHTML(), conForm.getOpcion());
 
       if (resp == null)
         conForm.setMensaje(conBean.getMens_error());
       else {
         conForm.setMensaje(resp);
       }
       return mapping.findForward("iniciar");
     }
 
     if (conForm.getAccion().equals("aperturaCierre"))
     {
       String resp = conBean.enviaMail(conForm.getMailCliente(), conForm.getNumTarjetaGCP(), 
         conForm.getVoucherHTML(), conForm.getAccion());
 
       if (resp == null)
         conForm.setMensaje(conBean.getMens_error());
       else {
         conForm.setMensaje(resp);
       }
       return mapping.findForward("iniciar");
     }
 
     return mapping.findForward("cancelar");
   }
 
   protected void removeFormBean(ActionMapping mapping, HttpServletRequest request)
   {
     if (mapping.getAttribute() != null)
       if ("request".equals(mapping.getScope())) {
         request.removeAttribute(mapping.getAttribute());
       } else {
         HttpSession session = request.getSession();
         session.removeAttribute(mapping.getAttribute());
       }
   }
 }

/* Location:           C:\sitios\GestionTV_Ripley\trunk\docs\01 Requerimiento\Fuentes Gestión TV\GestionTV-WC7\WEB-INF\classes\
 * Qualified Name:     cl.ripley.GestionTV.struts.action.ActivacionGCPAction
 * JD-Core Version:    0.6.2
 */