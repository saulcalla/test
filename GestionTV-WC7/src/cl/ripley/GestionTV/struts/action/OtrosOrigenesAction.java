 package cl.ripley.GestionTV.struts.action;
 
 import cl.ripley.GestionTV.comun.DownFile;
 import cl.ripley.GestionTV.comun.Util;
 import cl.ripley.GestionTV.struts.bean.OtrosOrigenesBean;
 import cl.ripley.GestionTV.struts.form.OtrosOrigenesForm;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import javax.servlet.http.HttpSession;
 import org.apache.struts.action.Action;
 import org.apache.struts.action.ActionForm;
 import org.apache.struts.action.ActionForward;
 import org.apache.struts.action.ActionMapping;
 
 public class OtrosOrigenesAction extends Action
 {
   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
     throws Exception
   {
     OtrosOrigenesForm objForm = (OtrosOrigenesForm)form;
     OtrosOrigenesBean objBean = new OtrosOrigenesBean();
     DownFile objDownFile = new DownFile();
 
     String Conectado = (String)request.getSession().getAttribute("Conectado");
 
     if (((String)request.getSession().getAttribute("AccesoRangos")).equals("SI")) {
       objForm.setAccesoRangos("SI");
       objBean.setAccesoRangos("SI");
     } else {
       objForm.setAccesoRangos("NO");
       objBean.setAccesoRangos("NO");
     }
 
     if (Conectado == null) {
       return mapping.findForward("timeOut");
     }
 
     if (objForm.getAccion().equals("InicioOtrosOrigenes")) {
       objForm.setVctDetalles(Util.stringToVector("[]"));
       objForm.setFec_inicio("");
       objForm.setFec_final("");
       objForm.setMensaje("");
       objForm.setHayDatos("");
       objForm.setHayDatosExportar("no");
       return mapping.findForward("iniciar");
     }
     if (objForm.getAccion().equals("buscar")) {
       objBean.setFec_inicio(objForm.getFec_inicio());
       objBean.setFec_final(objForm.getFec_final());
       objBean.consulta(getDataSource(request, "Db2"));
       objForm.setVctDetalles(objBean.getVctDetalles());
       objForm.setHayDatos(objBean.getHayDatos());
       return mapping.findForward("iniciar");
     }
     if (objForm.getAccion().equals("excel")) {
       objBean.setVctExpHead(Util.stringToVector(objForm.getVctExpHead()));
 
       objForm.setExportFile(objDownFile.enviarArchivo(objBean.getVctExpHead(), objForm.getVctDetalles()));
 
       objForm.setMensaje(DownFile.getMensaje());
       if (objForm.getMensaje().equals("Exportación exitosa.."))
         objForm.setHayDatosExportar("si");
       else {
         objForm.setHayDatosExportar("no");
       }
       objForm.setMensaje(DownFile.getMensaje());
       return mapping.findForward("iniciar");
     }
 
     return mapping.findForward("cancelar");
   }
 
   protected void removeFormBean(ActionMapping mapping, HttpServletRequest request)
   {
     if (mapping.getAttribute() != null)
       if ("request".equals(mapping.getScope())) {
         request.removeAttribute(mapping.getAttribute());
       }
       else {
         HttpSession session = request.getSession();
         session.removeAttribute(mapping.getAttribute());
       }
   }
 }

/* Location:           C:\sitios\GestionTV_Ripley\trunk\docs\01 Requerimiento\Fuentes Gestión TV\GestionTV-WC7\WEB-INF\classes\
 * Qualified Name:     cl.ripley.GestionTV.struts.action.OtrosOrigenesAction
 * JD-Core Version:    0.6.2
 */