 package cl.ripley.GestionTV.struts.action;
 
 import cl.ripley.GestionTV.struts.bean.CargaStockBTBean;
 import cl.ripley.GestionTV.struts.form.CargaStockBTForm;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import javax.servlet.http.HttpSession;
 import org.apache.struts.action.Action;
 import org.apache.struts.action.ActionForm;
 import org.apache.struts.action.ActionForward;
 import org.apache.struts.action.ActionMapping;
 
 public class CargaStockBTAction extends Action
 {
   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
     throws Exception
   {
     String Conectado = (String)request.getSession().getAttribute("Conectado");
     if (Conectado == null) {
       return mapping.findForward("timeOut");
     }
 
     CargaStockBTForm conForm = (CargaStockBTForm)form;
     CargaStockBTBean conBean = new CargaStockBTBean();
 
     if (conForm.getAccion().equals("InicioCargaStockBT"))
     {
       conForm.setHayDatos("no");
       conForm.setMensaje("");
 
       conBean.cargaStockBT();
 
       if (conBean.getMens_error().equals("")) {
         conBean.cargaStockTV(getDataSource(request, "Db2"));
         conForm.setHayDatos(conBean.getHayDatos());
         conForm.setTot_registros(conBean.getTot_datos());
         conForm.setMensaje(conBean.getMens_error());
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
 * Qualified Name:     cl.ripley.GestionTV.struts.action.CargaStockBTAction
 * JD-Core Version:    0.6.2
 */