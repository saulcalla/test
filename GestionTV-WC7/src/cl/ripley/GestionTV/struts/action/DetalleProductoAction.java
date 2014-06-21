 package cl.ripley.GestionTV.struts.action;
 
 import cl.ripley.GestionTV.comun.Util;
 import cl.ripley.GestionTV.struts.bean.DetalleProductoBean;
 import cl.ripley.GestionTV.struts.bean.Sucursal;
 import cl.ripley.GestionTV.struts.form.DetalleProductoForm;
 import java.util.Vector;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import javax.servlet.http.HttpSession;
 import org.apache.struts.action.Action;
 import org.apache.struts.action.ActionForm;
 import org.apache.struts.action.ActionForward;
 import org.apache.struts.action.ActionMapping;
 
 public class DetalleProductoAction extends Action
 {
   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
     throws Exception
   {
     String Conectado = (String)request.getSession().getAttribute("Conectado");
     if (Conectado == null) {
       return mapping.findForward("timeOut");
     }
 
     DetalleProductoForm conForm = (DetalleProductoForm)form;
     DetalleProductoBean conBean = new DetalleProductoBean();
     Sucursal traSucursal = new Sucursal();
 
     if (conForm.getAccion().equals("InicioDetalleProducto")) {
       conForm.setVctDetalles(null);
       conForm.setHayDatos("no");
       conForm.setHayDatosExportar("no");
       conForm.setFec_inicio("");
       conForm.setFec_fin("");
       conForm.setFlagDatosBD("si");
 
       conForm.setCollSucursal(traSucursal.getCollSucursal(getDataSource(request, "Db2"), "gestion_26.inst02"));
       conForm.setCodSucursal(traSucursal.getPrimerCodSucursal());
       conForm.setGlosaSucursal(traSucursal.getPrimerNomSucursal());
 
       conForm.setIndice(0);
       conForm.setRegistrosPorBloque(10);
       conForm.setNroBloque(1);
       conForm.setMensaje("");
 
       return mapping.findForward("iniciar");
     }
 
     if (conForm.getAccion().equals("buscar"))
     {
       conBean.setFec_inicio(conForm.getFec_inicio());
       conBean.setFec_fin(conForm.getFec_fin());
       conBean.setCodSucursal(conForm.getCodSucursal());
       conForm.setMensaje("");
 
       conBean.setNroBloque(conForm.getNroBloque());
       conBean.setRegistrosPorBloque(conForm.getRegistrosPorBloque());
       conBean.setIndice(conForm.getIndice());
 
       conForm.setTotalRegistros(conBean.getTotalRegistros(getDataSource(request, "Db2"), conForm.getFec_inicio()));
       conBean.setTotalReg(conForm.getTotalRegistros());
 
       conForm.setVctDetalles(conBean.getPaginacion(getDataSource(request, "Db2"), conForm.getFec_inicio()));
       if (conForm.getVctDetalles().size() == 0) {
         conForm.setFlagDatosBD("no");
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
     if (conForm.getAccion().equals("excel")) {
       conBean.setFec_inicio(conForm.getFec_inicio());
       conBean.setFec_fin(conForm.getFec_fin());
       conBean.setCodSucursal(conForm.getCodSucursal());
       conBean.setVctExpHead(Util.stringToVector(conForm.getVctExpHead()));
       conBean.setVctDetalles(conBean.getVectorExportar(getDataSource(request, "Db2")));
 
       conForm.setExportFile(conBean.enviarArchivo());
 
       conBean.setNroBloque(conForm.getNroBloque());
       conBean.setRegistrosPorBloque(conForm.getRegistrosPorBloque());
       conBean.setIndice(conForm.getIndice());
 
       conForm.setTotalRegistros(conBean.getTotalRegistros(getDataSource(request, "Db2"), conForm.getFec_inicio()));
       conBean.setTotalReg(conForm.getTotalRegistros());
 
       conForm.setVctDetalles(conBean.getPaginacion(getDataSource(request, "Db2"), conForm.getFec_inicio()));
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
 * Qualified Name:     cl.ripley.GestionTV.struts.action.DetalleProductoAction
 * JD-Core Version:    0.6.2
 */