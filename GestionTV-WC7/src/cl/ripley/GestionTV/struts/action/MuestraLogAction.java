 package cl.ripley.GestionTV.struts.action;
 
 import cl.ripley.GestionTV.struts.bean.CargasBean;
 import cl.ripley.GestionTV.struts.form.MuestraLogForm;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import javax.servlet.http.HttpSession;
 import org.apache.struts.action.Action;
 import org.apache.struts.action.ActionForm;
 import org.apache.struts.action.ActionForward;
 import org.apache.struts.action.ActionMapping;
 
 public class MuestraLogAction extends Action
 {
   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
     throws Exception
   {
     String Conectado = (String)request.getSession().getAttribute("Conectado");
     if (Conectado == null) {
       return mapping.findForward("timeOut");
     }
 
     MuestraLogForm objForm = (MuestraLogForm)form;
     CargasBean objBean = new CargasBean();
 
     if (objForm.getAccion() == null) objForm.setAccion("");
 
     if (isCancelled(request)) {
       removeFormBean(mapping, request);
       return mapping.findForward("cancelar");
     }
 
     if (objForm.getAccion().equals("cancelar")) {
       removeFormBean(mapping, request);
       return mapping.findForward("cancelar");
     }
 
     if (objForm.getAccion().equals("InicioLog")) {
       objBean.setTipo("ARCHIVO_LOG");
       objBean.setNumeroPagina("");
       objForm.setVctDetalles(objBean.llenaVector());
       objForm.setHayDatos(objBean.getHayDatos());
       objForm.setTotalPaginas(objBean.getTotalPaginas());
       objForm.setListaPagina(objBean.getListaPagina());
       objForm.setHayProximoBloque(objBean.getHayProximoBloque());
       if (objBean.getHayDatos().equals("no"))
         objBean.setNumeroPagina("");
       else {
         objForm.setNumeroPagina("1");
       }
       return mapping.findForward("iniciar");
     }
     if (objForm.getAccion().equals("BuscarPagina")) {
       objBean.setNumeroPagina(objForm.getNumeroPagina());
       objBean.setTipo("ARCHIVO_LOG");
       objForm.setVctDetalles(objBean.llenaVector());
       objForm.setHayDatos(objBean.getHayDatos());
       objForm.setTotalPaginas(objBean.getTotalPaginas());
       objForm.setListaPagina(objBean.getListaPagina());
       objForm.setHayProximoBloque(objBean.getHayProximoBloque());
       objForm.setNumeroPagina(objBean.getNumeroPagina());
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
 * Qualified Name:     cl.ripley.GestionTV.struts.action.MuestraLogAction
 * JD-Core Version:    0.6.2
 */