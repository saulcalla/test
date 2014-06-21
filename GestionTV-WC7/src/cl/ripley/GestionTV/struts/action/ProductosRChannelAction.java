 package cl.ripley.GestionTV.struts.action;
 
 import cl.ripley.GestionTV.comun.Util;
 import cl.ripley.GestionTV.struts.bean.ProductosRChannelBean;
 import cl.ripley.GestionTV.struts.form.ProductosRChannelForm;
 import cl.ripley.framework.mvc.action.ForwardParameters;
 import java.util.Vector;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import javax.servlet.http.HttpSession;
 import org.apache.struts.action.Action;
 import org.apache.struts.action.ActionForm;
 import org.apache.struts.action.ActionForward;
 import org.apache.struts.action.ActionMapping;
 
 public class ProductosRChannelAction extends Action
 {
   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
     throws Exception
   {
     String Conectado = (String)request.getSession().getAttribute("Conectado");
     if (Conectado == null) {
       return mapping.findForward("timeOut");
     }
 
     ProductosRChannelForm conForm = (ProductosRChannelForm)form;
     ProductosRChannelBean conBean = new ProductosRChannelBean();
 
     if (conForm.getAccion().equals("InicioProductoChannel")) {
       conForm.setVctDetalles(null);
       conForm.setHayDatos("no");
       conForm.setFec_inicio("");
       conForm.setFlagDatosBD("si");
       conForm.setIndice(0);
       conForm.setRegistrosPorBloque(10);
       conForm.setNroBloque(1);
       conForm.setMensaje("");
       conBean.setMensaje("");
       return mapping.findForward("inicio");
     }
 
     if (conForm.getAccion().equals("buscar"))
     {
       conBean.setFec_inicio(conForm.getFec_inicio());
 
       conBean.setNroBloque(conForm.getNroBloque());
       conBean.setRegistrosPorBloque(conForm.getRegistrosPorBloque());
       conBean.setIndice(conForm.getIndice());
       conForm.setTotalRegistros(conBean.getTotalRegistros(getDataSource(request, "Db2")));
       conBean.setTotalReg(conForm.getTotalRegistros());
       conForm.setVctDetalles(conBean.getPaginacion(getDataSource(request, "Db2")));
       if (conForm.getVctDetalles().size() == 0) {
         conForm.setFlagDatosBD("no");
       }
 
       conForm.setHayDatos(conBean.getHayDatos());
       conForm.setHayProximoBloque(conBean.getHayProximoBloque());
       conForm.setNroBloque(conBean.getNroBloque());
       conForm.setContador(conBean.getContador());
       conForm.setListaPagina(conBean.getListaPagina());
       conForm.setMensaje(conBean.getMensaje());
       conForm.setHayDatosExportar("no");
       return mapping.findForward("inicio");
     }
 
     if (conForm.getAccion().equals("excel")) {
       conBean.setFec_inicio(conForm.getFec_inicio());
       conBean.setVctExpHead(Util.stringToVector(conForm.getVctExpHead()));
       conBean.setVctDetalles(conBean.getVectorExportar(getDataSource(request, "Db2")));
       conForm.setExportFile(conBean.enviarArchivo());
 
       conBean.setNroBloque(conForm.getNroBloque());
       conBean.setRegistrosPorBloque(conForm.getRegistrosPorBloque());
       conBean.setIndice(conForm.getIndice());
 
       conForm.setTotalRegistros(conBean.getTotalRegistros(getDataSource(request, "Db2")));
       conBean.setTotalReg(conForm.getTotalRegistros());
 
       conForm.setVctDetalles(conBean.getPaginacion(getDataSource(request, "Db2")));
       if (conForm.getVctDetalles().size() == 0) {
         conForm.setFlagDatosBD("no");
       }
       conForm.setHayDatos(conBean.getHayDatos());
       conForm.setHayProximoBloque(conBean.getHayProximoBloque());
       conForm.setNroBloque(conBean.getNroBloque());
       conForm.setContador(conBean.getContador());
 
       conForm.setListaPagina(conBean.getListaPagina());
       conForm.setMensaje(conBean.getMensaje());
       conForm.setHayDatosExportar(conBean.getHayDatosExportar());
       return mapping.findForward("inicio");
     }
     if (conForm.getAccion().equals("ExportarPdf")) {
       return new ForwardParameters().add("format", "1")
         .add("action", "preview")
         .add("report", "002")
         .add("JRDatasource", "cl.ripley.framework.mvc.action.GestionTVBeanFactory")
         .add("bundle", "cl.ripley.GestionTV.struts.ReportsResources")
         .add("PV_FECHA", conForm.getFec_inicio().trim())
         .forward(mapping.findForward("doReport"));
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
 * Qualified Name:     cl.ripley.GestionTV.struts.action.ProductosRChannelAction
 * JD-Core Version:    0.6.2
 */