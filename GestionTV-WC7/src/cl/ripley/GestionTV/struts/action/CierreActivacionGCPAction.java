 package cl.ripley.GestionTV.struts.action;
 
 import cl.ripley.GestionTV.struts.bean.ActivacionGCPBean;
 import cl.ripley.GestionTV.struts.form.CierreActivacionGCPForm;
 import java.text.SimpleDateFormat;
 import java.util.Calendar;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import javax.servlet.http.HttpSession;
 import org.apache.struts.action.Action;
 import org.apache.struts.action.ActionForm;
 import org.apache.struts.action.ActionForward;
 import org.apache.struts.action.ActionMapping;
 import org.apache.struts.util.MessageResources;
 
 public class CierreActivacionGCPAction extends Action
 {
   protected static MessageResources messages = MessageResources.getMessageResources("cl.ripley.GestionTV.struts.msgGestionTV");
 
   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
     throws Exception
   {
     String Conectado = (String)request.getSession().getAttribute(
       "Conectado");
     String sucursal = messages.getMessage("activacionGcp.sucursal");
     String caja = messages.getMessage("activacionGcp.caja");
 
     SimpleDateFormat sdf = new SimpleDateFormat(messages
       .getMessage("constante.FORMATO_FECHA_GCP"));
 
     if (Conectado == null) {
       return mapping.findForward("timeOut");
     }
 
     CierreActivacionGCPForm conForm = (CierreActivacionGCPForm)form;
 
     ActivacionGCPBean conBean = new ActivacionGCPBean();
 
     String idUsuario = (String)request.getSession().getAttribute(
       "strRutUsr");
     String nombreUsuario = (String)request.getSession().getAttribute(
       "strNomUsr");
     String usuario = idUsuario + "_" + nombreUsuario;
 
     Calendar fecha = Calendar.getInstance();
 
     if (conForm.getAccion().equals("InicioCierreActivacionGCP"))
     {
       conForm.setHayDatos("no");
       conForm.setFlagDatosBD("si");
       conForm.setTemp("no");
       conForm.setCierre("no");
 
       conForm.setMensaje("");
       return mapping.findForward("iniciar");
     }
 
     if (conForm.getAccion().equals("cierre"))
     {
       int dia = Integer.parseInt(conForm.getFec_inicio().substring(0, 2));
       int mes = Integer.parseInt(conForm.getFec_inicio().substring(3, 5));
       int anio = Integer.parseInt(conForm.getFec_inicio().substring(6, 10));
 
       fecha.set(5, dia);
       fecha.set(2, mes - 1);
       fecha.set(1, anio);
 
       conForm.setHayDatos("no");
       conForm.setMensaje("");
       conForm.setTemp("si");
 
       boolean apertura = conBean.validaAperturaCierre(getDataSource(request, "BO"), sucursal, caja, "42", fecha.getTime());
 
       if (!apertura)
       {
         conForm.setHayDatos("no");
         conForm.setMensaje("");
         conForm.setTemp("si");
         conForm.setMensaje("NO EXISTE APERTURA PARA FECHA " + conForm.getFec_inicio());
         return mapping.findForward("iniciar");
       }
 
       boolean cierre = conBean.validaAperturaCierre(getDataSource(request, "BO"), sucursal, caja, "44", fecha.getTime());
 
       if (!cierre) {
         conForm.setHayDatos("no");
         conForm.setMensaje("");
         conForm.setTemp("si");
         conForm.setMensaje("NO EXISTE CIERRE PARA FECHA " + conForm.getFec_inicio());
         return mapping.findForward("iniciar");
       }
 
       fecha.set(5, dia);
       fecha.set(2, mes - 1);
       fecha.set(1, anio);
 
       int resp = conBean.generaCierreGCP(getDataSource(request, "BO"), sucursal, caja, 
         "", fecha.getTime(), usuario);
 
       if (resp < 0) {
         conForm.setMensaje("ERROR AL GENERAR RESUMEN DE CIERRE");
       }
       else {
         conForm.setLinkVoucherHTML(conBean.getLink_voucherHTML());
         conForm.setCierre("ok");
         conForm.setMensaje("RESUMEN DE CIERRE GENERADO EXITOSAMENTE");
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
 * Qualified Name:     cl.ripley.GestionTV.struts.action.CierreActivacionGCPAction
 * JD-Core Version:    0.6.2
 */