 package cl.ripley.GestionTV.struts.action;
 
 import cl.ripley.GestionTV.comun.Util;
 import cl.ripley.GestionTV.struts.bean.ActualizaFechaBoletaBean;
 import cl.ripley.GestionTV.struts.form.ActualizaFechaBoletaForm;
 import java.util.Vector;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import javax.servlet.http.HttpSession;
 import org.apache.struts.action.Action;
 import org.apache.struts.action.ActionForm;
 import org.apache.struts.action.ActionForward;
 import org.apache.struts.action.ActionMapping;
 
 public class ActualizaFechaBoletaAction extends Action
 {
   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
     throws Exception
   {
     String Conectado = (String)request.getSession().getAttribute("Conectado");
     if (Conectado == null) {
       return mapping.findForward("timeOut");
     }
 
     ActualizaFechaBoletaForm conForm = (ActualizaFechaBoletaForm)form;
     ActualizaFechaBoletaBean conBean = new ActualizaFechaBoletaBean();
 
     if (conForm.getAccion().equals("InicioActualizaFechaBoleta")) {
       conForm.setVctDetalles(null);
       conForm.setHayDatos("no");
       conForm.setFlagDatosBD("si");
       conForm.setHayDatosExportar("no");
       conForm.setFec_inicio("");
       conForm.setFec_nueva("");
       conForm.setCodRegalo("");
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
       if (conForm.getFec_nueva() == null) {
         conForm.setFec_nueva("");
         conBean.setFec_hasta("");
       }
       else {
         conBean.setFec_hasta(conForm.getFec_nueva());
       }
 
       conForm.setMensaje("");
 
       conBean.setCodRegalo(conForm.getCodRegalo());
       conBean.setNroBloque(conForm.getNroBloque());
       conBean.setRegistrosPorBloque(conForm.getRegistrosPorBloque());
       conBean.setIndice(conForm.getIndice());
 
       if (conForm.getActualiza().equals("no"))
         conForm.setVctRegistros(conBean.filtraOC(getDataSource(request, "Db2")));
       else {
         conBean.setVctRegistros(conForm.getVctRegistros());
       }
 
       conForm.setTotalRegistros(conBean.getTotalRegistros(getDataSource(request, "Db2"), conForm.getFec_inicio()));
       conBean.setTotalReg(conForm.getTotalRegistros());
 
       conForm.setVctDetalles(conBean.getPaginacion(getDataSource(request, "Db2")));
 
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
 
       if (conForm.getFec_nueva() == null)
         conBean.setFec_hasta("");
       else {
         conBean.setFec_hasta(conForm.getFec_nueva());
       }
       conBean.setCodRegalo(conForm.getCodRegalo());
 
       conBean.setVctRegistros(conForm.getVctRegistros());
 
       conBean.setVctExpHead(Util.stringToVector(conForm.getVctExpHead()));
       conBean.setVctDetalles(
         conBean.getVectorExportar(getDataSource(request, "Db2")));
       conForm.setExportFile(conBean.enviarArchivo());
 
       conBean.setNroBloque(conForm.getNroBloque());
       conBean.setRegistrosPorBloque(conForm.getRegistrosPorBloque());
       conBean.setIndice(conForm.getIndice());
 
       conForm.setTotalRegistros(conBean.getTotalRegistros(getDataSource(request, "Db2"), conForm.getFec_inicio()));
       conBean.setTotalReg(conForm.getTotalRegistros());
 
       conForm.setVctDetalles(conBean.getPaginacion(getDataSource(request, "Db2")));
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
 * Qualified Name:     cl.ripley.GestionTV.struts.action.ActualizaFechaBoletaAction
 * JD-Core Version:    0.6.2
 */