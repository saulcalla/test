 package cl.ripley.GestionTV.struts.action;
 
 import cl.ripley.GestionTV.comun.Util;
 import cl.ripley.GestionTV.struts.bean.VisitasBean;
 import cl.ripley.GestionTV.struts.form.VisitasForm;
 import java.util.Vector;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import javax.servlet.http.HttpSession;
 import org.apache.struts.action.Action;
 import org.apache.struts.action.ActionForm;
 import org.apache.struts.action.ActionForward;
 import org.apache.struts.action.ActionMapping;
 
 public class VisitasAction extends Action
 {
   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
     throws Exception
   {
     String Conectado = (String)request.getSession().getAttribute("Conectado");
     if (Conectado == null) {
       return mapping.findForward("timeOut");
     }
 
     VisitasForm conForm = (VisitasForm)form;
     VisitasBean conBean = new VisitasBean();
 
     if (conForm.getAccion().equals("buscar")) {
       conBean.setFec_inicio(conForm.getFec_inicio());
       conBean.setFec_fin(conForm.getFec_final());
       conBean.consulta(getDataSource(request, "Db2"));
       conForm.setVctDetalles(conBean.getVctDetalles());
       conForm.setHayDatos(conBean.getHayDatos());
       if (conForm.getVctDetalles().size() == 0) {
         conForm.setFlagDatosBD("no");
       }
 
       return mapping.findForward("iniciar");
     }if (conForm.getAccion().equals("InicioVisitas")) {
       conForm.setVctDetalles(Util.stringToVector("[]"));
       conForm.setFec_inicio("");
       conForm.setFec_final("");
       conForm.setFlagDatosBD("si");
       conForm.setMensaje("");
       conForm.setHayDatos("no");
       conForm.setHayDatosExportar("no");
       return mapping.findForward("iniciar");
     }
     if (conForm.getAccion().equals("excel")) {
       conBean.setFec_inicio(conForm.getFec_inicio());
       conBean.setFec_fin(conForm.getFec_final());
       conBean.setVctExpHead(Util.stringToVector(conForm.getVctExpHead()));
       conBean.setVctDetalles(
         conBean.getVectorExportar(
         getDataSource(request, "Db2")));
 
       conForm.setExportFile(conBean.enviarArchivo());
 
       if (conForm.getVctDetalles().size() == 0) {
         conForm.setFlagDatosBD("no");
       }
 
       conForm.setHayDatos(conBean.getHayDatos());
       conForm.setMensaje(conBean.getMensaje());
       conForm.setHayDatosExportar(conBean.getHayDatosExportar());
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
 * Qualified Name:     cl.ripley.GestionTV.struts.action.VisitasAction
 * JD-Core Version:    0.6.2
 */