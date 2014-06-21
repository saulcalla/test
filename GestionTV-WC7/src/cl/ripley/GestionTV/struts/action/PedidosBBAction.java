 package cl.ripley.GestionTV.struts.action;
 
 import cl.ripley.GestionTV.comun.Util;
 import cl.ripley.GestionTV.struts.bean.PedidosBean;
 import cl.ripley.GestionTV.struts.form.PedidosForm;
 import java.util.Vector;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import javax.servlet.http.HttpSession;
 import org.apache.struts.action.Action;
 import org.apache.struts.action.ActionForm;
 import org.apache.struts.action.ActionForward;
 import org.apache.struts.action.ActionMapping;
 
 public class PedidosBBAction extends Action
 {
   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
     throws Exception
   {
     PedidosForm conForm = (PedidosForm)form;
     PedidosBean conBean = new PedidosBean();
 
     if (conForm.getAccion().equals("buscar")) {
       conBean.setFec_inicio(conForm.getFec_inicio());
       conBean.setFec_fin(conForm.getFec_fin());
       conBean.setFec_inicio(conForm.getFec_inicio());
       conBean.setFec_fin(conForm.getFec_fin());
       conBean.consulta(getDataSource(request, "Db2"));
       conForm.setVctDetalles(conBean.getVctDetalles());
       conForm.setHayDatos(conBean.getHayDatos());
       if (conForm.getVctDetalles().size() == 0) {
         conForm.setFlagDatosBD("no");
       }
 
       return mapping.findForward("iniciar");
     }
 
     conForm.setVctDetalles(Util.stringToVector("[]"));
     conForm.setFec_inicio("");
     conForm.setFec_fin("");
     conForm.setFlagDatosBD("si");
     conForm.setMensaje("");
     conForm.setHayDatos("no");
     conForm.setHayDatosExportar("no");
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
 * Qualified Name:     cl.ripley.GestionTV.struts.action.PedidosBBAction
 * JD-Core Version:    0.6.2
 */