 package cl.ripley.GestionTV.struts.action;
 
 import cl.ripley.GestionTV.comun.Util;
 import cl.ripley.GestionTV.struts.bean.BusquedaRMCBean;
 import cl.ripley.GestionTV.struts.form.BusquedaRMCForm;
 import java.util.Vector;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import javax.servlet.http.HttpSession;
 import org.apache.struts.action.Action;
 import org.apache.struts.action.ActionForm;
 import org.apache.struts.action.ActionForward;
 import org.apache.struts.action.ActionMapping;
 
 public class BusquedaRMCAction extends Action
 {
   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
     throws Exception
   {
     String Conectado = (String)request.getSession().getAttribute("Conectado");
     if (Conectado == null) {
       return mapping.findForward("timeOut");
     }
 
     BusquedaRMCForm conForm = (BusquedaRMCForm)form;
     BusquedaRMCBean conBean = new BusquedaRMCBean();
 
     if (conForm.getAccion().equals("InicioBusquedaRMC")) {
       conForm.setVctDetalles(null);
       conForm.setHayDatos("no");
       conForm.setFlagDatosBD("si");
       conForm.setHayDatosExportar("no");
       conForm.setFec_inicio("");
       conForm.setFec_nueva("");
       conForm.setNro_rmc("");
       conForm.setActualiza("no");
 
       conForm.setIndice(0);
       conForm.setRegistrosPorBloque(10);
       conForm.setNroBloque(1);
       conForm.setMensaje("");
 
       return mapping.findForward("iniciar");
     }
 
     if (conForm.getAccion().equals("buscar"))
     {
       conBean.setFec_inicio(conForm.getFec_inicio());
       conBean.setFec_hasta(conForm.getFec_nueva());
       conForm.setMensaje("");
       conForm.setNro_rmc(conForm.getNro_rmc());
       conBean.setNroBloque(conForm.getNroBloque());
       conBean.setRegistrosPorBloque(conForm.getRegistrosPorBloque());
       conBean.setIndice(conForm.getIndice());
 
       conForm.setTotalRegistros(conBean.getTotalRegistros(getDataSource(request, "RMC"), conForm.getNro_rmc()));
       conBean.setTotalReg(conForm.getTotalRegistros());
 
       conForm.setVctDetalles(conBean.getPaginacion(getDataSource(request, "RMC"), conForm.getNro_rmc()));
       if (conForm.getVctDetalles().size() == 0) {
         conForm.setFlagDatosBD("no");
         conForm.setActualiza("no");
       }
 
       if ((conForm.getVctDetalles().size() > 0) && (!conForm.getFec_nueva().equals(""))) {
         conForm.setActualiza("si");
       }
 
       conForm.setHayDatos(conBean.getHayDatos());
       conForm.setHayProximoBloque(conBean.getHayProximoBloque());
       conForm.setNroBloque(conBean.getNroBloque());
       conForm.setContador(conBean.getContador());
 
       conForm.setListaPagina(conBean.getListaPagina());
       conForm.setHayDatosExportar("no");
       conForm.setMensaje(conBean.getMensaje());
 
       return mapping.findForward("iniciar");
     }
     if (conForm.getAccion().equals("excel"))
     {
       conBean.setFec_inicio(conForm.getFec_inicio());
       conBean.setFec_hasta(conForm.getFec_nueva());
       conForm.setNro_rmc(conForm.getNro_rmc());
       conBean.setVctExpHead(Util.stringToVector(conForm.getVctExpHead()));
       conBean.setVctDetalles(
         conBean.getVectorExportar(getDataSource(request, "RMC"), conForm.getNro_rmc()));
       conForm.setExportFile(conBean.enviarArchivo());
 
       conBean.setNroBloque(conForm.getNroBloque());
       conBean.setRegistrosPorBloque(conForm.getRegistrosPorBloque());
       conBean.setIndice(conForm.getIndice());
 
       conForm.setTotalRegistros(conBean.getTotalRegistros(getDataSource(request, "RMC"), conForm.getNro_rmc()));
       conBean.setTotalReg(conForm.getTotalRegistros());
 
       conForm.setVctDetalles(conBean.getPaginacion(getDataSource(request, "RMC"), conForm.getNro_rmc()));
       if (conForm.getVctDetalles().size() == 0) {
         conForm.setFlagDatosBD("no");
         conForm.setActualiza("no");
       }
 
       conForm.setHayDatos(conBean.getHayDatos());
       conForm.setHayProximoBloque(conBean.getHayProximoBloque());
       conForm.setNroBloque(conBean.getNroBloque());
       conForm.setContador(conBean.getContador());
 
       conForm.setListaPagina(conBean.getListaPagina());
       conForm.setMensaje(conBean.getMensaje());
       conForm.setHayDatosExportar(conBean.getHayDatosExportar());
 
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
 * Qualified Name:     cl.ripley.GestionTV.struts.action.BusquedaRMCAction
 * JD-Core Version:    0.6.2
 */