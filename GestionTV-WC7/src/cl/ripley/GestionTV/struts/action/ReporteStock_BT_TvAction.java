 package cl.ripley.GestionTV.struts.action;
 
 import cl.ripley.GestionTV.comun.Util;
 import cl.ripley.GestionTV.struts.bean.ReporteStock_BT_TvBean;
 import cl.ripley.GestionTV.struts.form.ReporteStock_BT_TvForm;
 import java.util.Vector;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import javax.servlet.http.HttpSession;
 import org.apache.struts.action.Action;
 import org.apache.struts.action.ActionForm;
 import org.apache.struts.action.ActionForward;
 import org.apache.struts.action.ActionMapping;
 
 public class ReporteStock_BT_TvAction extends Action
 {
   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
     throws Exception
   {
     String Conectado = (String)request.getSession().getAttribute("Conectado");
     if (Conectado == null) {
       return mapping.findForward("timeOut");
     }
 
     ReporteStock_BT_TvForm conForm = (ReporteStock_BT_TvForm)form;
     ReporteStock_BT_TvBean conBean = new ReporteStock_BT_TvBean();
 
     if (conForm.getAccion().equals("InicioStockBTTV")) {
       conForm.setVctDetalles(null);
       conForm.setHayDatos("no");
       conForm.setHayDatosExportar("no");
       conForm.setFlagDatosBD("si");
       conForm.setOpcion_filtro("");
       conForm.setOpcion_filtro("");
       conForm.setCodProducto("");
 
       conForm.setIndice(0);
       conForm.setRegistrosPorBloque(10);
       conForm.setNroBloque(1);
       conForm.setMensaje("");
 
       return mapping.findForward("iniciar");
     }
 
     if (conForm.getAccion().equals("buscar"))
     {
       conForm.setMensaje("");
       conBean.setNroBloque(conForm.getNroBloque());
       conBean.setRegistrosPorBloque(conForm.getRegistrosPorBloque());
       conBean.setIndice(conForm.getIndice());
       conBean.setFiltro(conForm.getFiltro());
       conBean.setOpcion_filtro(conForm.getOpcion_filtro());
       conBean.setCodProducto(conForm.getCodProducto());
       conForm.setVctDetalles(conBean.getRegistros(getDataSource(request, "Db2")));
       conForm.setTotalRegistros(conBean.getTotalRegistros(getDataSource(request, "Db2")));
       conBean.setTotalReg(conForm.getTotalRegistros());
 
       conForm.setHayDatos(conBean.getHayDatos());
       conForm.setHayProximoBloque(conBean.getHayProximoBloque());
       conForm.setNroBloque(conBean.getNroBloque());
       conForm.setContador(conBean.getContador());
 
       if (conForm.getVctDetalles().size() == 0) {
         conForm.setFlagDatosBD("no");
       }
 
       conForm.setListaPagina(conBean.getListaPagina());
       conForm.setHayDatosExportar("no");
       conForm.setMensaje(conBean.getMensaje());
 
       return mapping.findForward("iniciar");
     }
     if (conForm.getAccion().equals("excel"))
     {
       conBean.setVctExpHead(Util.stringToVector(conForm.getVctExpHead()));
       conBean.setFiltro(conForm.getFiltro());
       conBean.setOpcion_filtro(conForm.getOpcion_filtro());
       conBean.setCodProducto(conForm.getCodProducto());
       conBean.setVctDetalles(conBean.getVectorExportar(getDataSource(request, "Db2")));
 
       conForm.setExportFile(conBean.enviarArchivo());
 
       conBean.setNroBloque(conForm.getNroBloque());
       conBean.setRegistrosPorBloque(conForm.getRegistrosPorBloque());
       conBean.setIndice(conForm.getIndice());
 
       conForm.setTotalRegistros(conBean.getTotalRegistros(getDataSource(request, "Db2")));
       conBean.setTotalReg(conForm.getTotalRegistros());
 
       conForm.setVctDetalles(conBean.getRegistros(getDataSource(request, "Db2")));
 
       conBean.setTotalReg(conForm.getTotalRegistros());
 
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
 * Qualified Name:     cl.ripley.GestionTV.struts.action.ReporteStock_BT_TvAction
 * JD-Core Version:    0.6.2
 */