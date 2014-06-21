 package cl.ripley.GestionTV.struts.action;
 
 import cl.ripley.GestionTV.struts.bean.LimpiezaBolsaCompraBean;
 import cl.ripley.GestionTV.struts.form.LimpiezaBolsaCompraForm;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import javax.servlet.http.HttpSession;
 import org.apache.struts.action.Action;
 import org.apache.struts.action.ActionForm;
 import org.apache.struts.action.ActionForward;
 import org.apache.struts.action.ActionMapping;
 
 public class LimpiezaBolsaCompraAction extends Action
 {
   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
     throws Exception
   {
     String Conectado = (String)request.getSession().getAttribute("Conectado");
     if (Conectado == null) {
       return mapping.findForward("timeOut");
     }
 
     LimpiezaBolsaCompraForm conForm = (LimpiezaBolsaCompraForm)form;
     LimpiezaBolsaCompraBean conBean = new LimpiezaBolsaCompraBean();
 
     if (conForm.getAccion().equals("InicioLimpiezaBolsaCompra"))
     {
       conForm.setRut("");
 
       conForm.setIndice(0);
       conForm.setMensaje("");
 
       return mapping.findForward("iniciar");
     }
 
     if (conForm.getAccion().equals("limpiar"))
     {
       conForm.setMensaje("");
 
       String id_cliente = null;
       String resp = null;
 
       id_cliente = conBean.getUserId(getDataSource(request, "Db2"), conForm.getRut());
 
       if (id_cliente == null) {
         conForm.setMensaje(conBean.getMens_error());
         return mapping.findForward("iniciar");
       }
 
       resp = conBean.limpiezaBolsa(getDataSource(request, "Db2"), id_cliente);
 
       if (resp == null)
         conForm.setMensaje("ERROR: Al limpiar bolsa de compra.");
       else {
         conForm.setMensaje("Bolsa de Compra limpiada exitosamente.");
       }
 
       return mapping.findForward("iniciar");
     }
 
     return mapping.findForward("cancelar");
   }
 
   protected void removeFormBean(ActionMapping mapping, HttpServletRequest request) {
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
 * Qualified Name:     cl.ripley.GestionTV.struts.action.LimpiezaBolsaCompraAction
 * JD-Core Version:    0.6.2
 */