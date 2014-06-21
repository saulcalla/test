 package cl.ripley.GestionTV.struts.action;
 
 import cl.ripley.GestionTV.struts.bean.PopupBean;
 import cl.ripley.GestionTV.struts.form.PopupForm;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import javax.servlet.http.HttpSession;
 import org.apache.struts.action.Action;
 import org.apache.struts.action.ActionForm;
 import org.apache.struts.action.ActionForward;
 import org.apache.struts.action.ActionMapping;
 
 public class PopupAction extends Action
 {
   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
     throws Exception
   {
     String Conectado = (String)request.getSession().getAttribute("Conectado");
     if (Conectado == null) {
       return mapping.findForward("timeOut");
     }
 
     PopupForm objetoForm = (PopupForm)form;
     PopupBean objetoBean = new PopupBean();
 
     if (objetoForm.getAccion().equals("InicioPopup")) {
       objetoBean.consulta(getDataSource(request, "Db2"));
       objetoForm.setVctDetalles(objetoBean.getVctDetalles());
       objetoForm.setGlosa_est("");
       objetoForm.setGlosa_prop("");
       objetoForm.setGlosa_url("");
       return mapping.findForward("iniciar");
     }
 
     if (objetoForm.getAccion().equals("GrabarPopup")) {
       objetoBean.setGlosa_est(objetoForm.getGlosa_est());
       objetoBean.setGlosa_prop(objetoForm.getGlosa_prop());
       objetoBean.setGlosa_url(objetoForm.getGlosa_url());
 
       objetoBean.agregarpop(getDataSource(request, "Db2"));
 
       objetoBean.consulta(getDataSource(request, "Db2"));
       objetoForm.setVctDetalles(objetoBean.getVctDetalles());
       return mapping.findForward("agregar");
     }
 
     if (objetoForm.getAccion().equals("ModificarPopup")) {
       objetoBean.setGlosa_est(objetoForm.getGlosa_est());
       objetoBean.setGlosa_prop(objetoForm.getGlosa_prop());
       objetoBean.setGlosa_url(objetoForm.getGlosa_url());
       objetoBean.setIdpopup(objetoForm.getIdpopup());
 
       objetoBean.modificarpop(getDataSource(request, "Db2"));
 
       objetoBean.consulta(getDataSource(request, "Db2"));
       objetoForm.setVctDetalles(objetoBean.getVctDetalles());
       return mapping.findForward("modificar");
     }
 
     if (objetoForm.getAccion().equals("VolverPopup"))
     {
       objetoForm.setGlosa_est("");
       objetoForm.setGlosa_prop("");
       objetoForm.setGlosa_url("");
       return mapping.findForward("iniciar");
     }
 
     if (objetoForm.getAccion().equals("agregar")) {
       return mapping.findForward("agregar");
     }
 
     if (objetoForm.getAccion().equals("modificar")) {
       return mapping.findForward("modificar");
     }
 
     return mapping.findForward("cancelar");
   }
 
   protected void removeFormBean(ActionMapping mapping, HttpServletRequest request) {
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
 * Qualified Name:     cl.ripley.GestionTV.struts.action.PopupAction
 * JD-Core Version:    0.6.2
 */