 package cl.ripley.GestionTV.struts.action;
 
 import cl.ripley.GestionTV.struts.bean.CargasBean;
 import cl.ripley.GestionTV.struts.form.CargasForm;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import javax.servlet.http.HttpSession;
 import org.apache.struts.action.Action;
 import org.apache.struts.action.ActionForm;
 import org.apache.struts.action.ActionForward;
 import org.apache.struts.action.ActionMapping;
 
 public class CargasAction extends Action
 {
   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
     throws Exception
   {
     String Conectado = (String)request.getSession().getAttribute("Conectado");
     if (Conectado == null) {
       return mapping.findForward("timeOut");
     }
 
     CargasForm objForm = (CargasForm)form;
     CargasBean objBean = new CargasBean();
 
     if (objForm.getAccion().equals("cargarProductos")) {
       objBean.setTipo("ARCHIVO_PROD");
       objBean.cargaOEM();
       objForm.setfec1(objBean.getFec1());
       objForm.setestado1(objBean.getEstado1());
       return mapping.findForward("iniciar");
     }
 
     if (objForm.getAccion().equals("cargarCatalogos")) {
       objBean.setTipo("ARCHIVO_CATALOGO");
       objBean.cargaOEM();
       objForm.setfec2(objBean.getFec2());
       objForm.setestado2(objBean.getEstado2());
       return mapping.findForward("iniciar");
     }
 
     if (objForm.getAccion().equals("cargarPromociones")) {
       objBean.setTipo("ARCHIVO_PROMOCION");
       objBean.cargaOEM();
       objForm.setfec3(objBean.getFec3());
       objForm.setestado3(objBean.getEstado3());
       return mapping.findForward("iniciar");
     }
 
     if (objForm.getAccion().equals("cargarAsociaciones")) {
       objBean.setTipo("ARCHIVO_ASOCIACION");
       objBean.cargaOEM();
       objForm.setfec4(objBean.getFec4());
       objForm.setestado4(objBean.getEstado4());
       return mapping.findForward("iniciar");
     }
 
     if (objForm.getAccion().equals("cargarZonas")) {
       objBean.setTipo("ARCHIVO_ZONA");
       objBean.cargaOEM();
       objForm.setfec5(objBean.getFec5());
       objForm.setestado5(objBean.getEstado5());
       return mapping.findForward("iniciar");
     }
 
     if (objForm.getAccion().equals("cargarBundles")) {
       objBean.setTipo("ARCHIVO_BUNDLES");
       objBean.cargaOEM();
       objForm.setfec6(objBean.getFec6());
       objForm.setestado6(objBean.getEstado6());
       return mapping.findForward("iniciar");
     }
 
     if (objForm.getAccion().equals("cargarLog")) {
       objBean.setTipo("ARCHIVO_LOG");
       objBean.cargaOEM();
       objForm.setfec7(objBean.getfec7());
       objForm.setestado7(objBean.getestado7());
       return mapping.findForward("iniciar");
     }
     if (objForm.getAccion().equals("cargarClientescar")) {
       objBean.setTipo("ARCHIVO_CLIENTESCAR");
       objBean.cargaOEM();
       objForm.setfec8(objBean.getFec8());
       objForm.setestado8(objBean.getEstado8());
       return mapping.findForward("iniciar");
     }
     if (objForm.getAccion().equals("cancelar")) {
       return mapping.findForward("cancelar");
     }
 
     objBean.consultaOEM();
     objForm.setfec1(objBean.getFec1());
     objForm.setestado1(objBean.getEstado1());
     objForm.setfec2(objBean.getFec2());
     objForm.setestado2(objBean.getEstado2());
     objForm.setfec3(objBean.getFec3());
     objForm.setestado3(objBean.getEstado3());
     objForm.setfec4(objBean.getFec4());
     objForm.setestado4(objBean.getEstado4());
     objForm.setfec5(objBean.getFec5());
     objForm.setestado5(objBean.getEstado5());
     objForm.setfec6(objBean.getFec6());
     objForm.setestado6(objBean.getEstado6());
     objForm.setfec7(objBean.getfec7());
     objForm.setestado7(objBean.getestado7());
     objForm.setfec8(objBean.getFec8());
     objForm.setestado8(objBean.getEstado8());
 
     return mapping.findForward("iniciar");
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
 * Qualified Name:     cl.ripley.GestionTV.struts.action.CargasAction
 * JD-Core Version:    0.6.2
 */