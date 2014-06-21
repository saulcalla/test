 package cl.ripley.GestionTV.struts.action;
 
 import cl.ripley.GestionTV.comun.ConectaBD;
 import cl.ripley.GestionTV.comun.GestionTVFuncion;
 import cl.ripley.GestionTV.struts.bean.EnviaMail;
 import cl.ripley.GestionTV.struts.form.MenuForm;
 import java.util.Vector;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import javax.servlet.http.HttpSession;
 import org.apache.log4j.Logger;
 import org.apache.struts.action.Action;
 import org.apache.struts.action.ActionForm;
 import org.apache.struts.action.ActionForward;
 import org.apache.struts.action.ActionMapping;
 import org.apache.struts.util.MessageResources;
 
 public class MenuAction extends Action
 {
   static Logger log = Logger.getRootLogger();
   protected static MessageResources messages = MessageResources.getMessageResources("cl.ripley.GestionTV.struts.msgGestionTV");
 
   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
     throws Exception
   {
     MenuForm objetoForm = (MenuForm)form;
 
     ConectaBD objBD = new ConectaBD();
     EnviaMail objMail = new EnviaMail();
 
     if (objetoForm.getAccion() == null) {
       objetoForm.setAccion("");
     }
 
     if (isCancelled(request)) {
       removeFormBean(mapping, request);
       return mapping.findForward("cancelar");
     }
 
     if (objetoForm.getAccion().equals("cancelar")) {
       removeFormBean(mapping, request);
       return mapping.findForward("cancelar");
     }
     if (objetoForm.getAccion().equals("menuIndex")) {
       GestionTVFuncion objFuncion = new GestionTVFuncion();
       if ((objetoForm.getRutUsuario() == null) || 
         (objetoForm.getClave() == null) || 
         (objetoForm.getSistema() == null)) {
         return mapping.findForward("cancelar");
       }
 
       Vector vctMENU = objFuncion.getOpcionesMenu(getDataSource(request, "Oracle"), objetoForm.getRutUsuario(), objetoForm.getClave(), objetoForm.getSistema());
       
       String ambiente = messages.getMessage("ambiente");
       if (vctMENU.size() == 0)
       {
         log.info(ambiente + "::GestionTV::Oracle::Menu..");
         objMail.Email(ambiente + "::GestionTV::Oracle::Menu...");
         return mapping.findForward("errorBD");
       }
 
       String statement = "SELECT count(1) FROM NOTA_VENTA";
       Vector vWhere = new Vector();
       Vector vRes = new Vector();
       vRes = objBD.consulta(getDataSource(request, "Db2"), statement, vWhere, 1);
 
       if (vRes.size() == 0)
       {
         log.info(ambiente + "::GestionTV::DB2::Menu...");
         objMail.Email(ambiente + "::GestionTV::DB2::Menu...");
         return mapping.findForward("errorBDB2");
       }
 
       String MENU = vctMENU.toString();
     
       request.getSession().setAttribute("strMenu", MENU);
       request.getSession().setAttribute("Conectado", "OK");
 
       request.getSession().setAttribute("strRutUsr", objetoForm.getRutUsuario());
 
       request.getSession().setAttribute("strNomUsr", objetoForm.getNombreUsuario());
 
       if (MENU.indexOf("ADMSISTEMA") != -1)
         objetoForm.setAccesoRangos("SI");
       else
         objetoForm.setAccesoRangos("NO");
       request.getSession().setAttribute("AccesoRangos", objetoForm.getAccesoRangos());
 
       objetoForm.setMensaje("");
       return mapping.findForward("doIndex");
     }
     if (objetoForm.getAccion().equals("InicioVisitas")) {
       return mapping.findForward("doInicioVisitas");
     }
     if (objetoForm.getAccion().equals("InicioPedidos")) {
       return mapping.findForward("doInicioPedidos");
     }
     if (objetoForm.getAccion().equals("InicioActualizaEstados")) {
         return mapping.findForward("doInicioActualizaEstados");
     }
     if (objetoForm.getAccion().equals("InicioPedidosBlackBerry")) {
       return mapping.findForward("doInicioPedidosBB");
     }
 
     if (objetoForm.getAccion().equals("InicioTarjetaRipley")) {
       return mapping.findForward("doInicioTarjetaRipley");
     }
     if (objetoForm.getAccion().equals("InicioTarjetaBancaria")) {
       return mapping.findForward("doInicioTarjetaBancaria");
     }
     if (objetoForm.getAccion().equals("InicioTodasVentas")) {
       return mapping.findForward("doInicioTodasVentas");
     }
     if (objetoForm.getAccion().equals("InicioDetalleProducto")) {
       return mapping.findForward("doInicioDetalleProducto");
     }
     if (objetoForm.getAccion().equals("InicioReporteRegalo")) {
       return mapping.findForward("doInicioReporteRegalo");
     }
     if (objetoForm.getAccion().equals("InicioFonoComprasMes")) {
       return mapping.findForward("doInicioFonoComprasMes");
     }
     if (objetoForm.getAccion().equals("InicioProductoConStock")) {
       return mapping.findForward("doInicioProductoConStock");
     }
     if (objetoForm.getAccion().equals("InicioProductoSinStock")) {
       return mapping.findForward("doInicioProductoSinStock");
     }
     if (objetoForm.getAccion().equals("InicioCargaStockBT")) {
       return mapping.findForward("doInicioCargaStockBT");
     }
     if (objetoForm.getAccion().equals("InicioTodosProductos")) {
       return mapping.findForward("doInicioTodosProductos");
     }
     if (objetoForm.getAccion().equals("InicioStockBTTV")) {
       return mapping.findForward("doInicioReporteStockBTTV");
     }
     if (objetoForm.getAccion().equals("InicioProductos")) {
       return mapping.findForward("doInicioProductos");
     }
     if (objetoForm.getAccion().equals("InicioCatalogos")) {
       return mapping.findForward("doInicioCatalogos");
     }
     if (objetoForm.getAccion().equals("InicioPromociones")) {
       return mapping.findForward("doInicioPromociones");
     }
     if (objetoForm.getAccion().equals("InicioAsociaciones")) {
       return mapping.findForward("doInicioAsociaciones");
     }
     if (objetoForm.getAccion().equals("InicioZonas")) {
       return mapping.findForward("doInicioZonas");
     }
     if (objetoForm.getAccion().equals("InicioBundles")) {
       return mapping.findForward("doInicioBundles");
     }
     if (objetoForm.getAccion().equals("InicioCargas")) {
       return mapping.findForward("doInicioCargas");
     }
     if (objetoForm.getAccion().equals("InicioPopup")) {
       return mapping.findForward("doInicioPopup");
     }
     if (objetoForm.getAccion().equals("InicioLog")) {
       return mapping.findForward("doInicioLog");
     }
     if (objetoForm.getAccion().equals("InicioClientescar")) {
       return mapping.findForward("doInicioClientescar");
     }
     if (objetoForm.getAccion().equals("InicioOtrosOrigenes")) {
       return mapping.findForward("doInicioOtrosOrigenes");
     }
     if (objetoForm.getAccion().equals("InicioBanco")) {
       return mapping.findForward("doBanco");
     }
     if (objetoForm.getAccion().equals("InicioFonoCompra")) {
       return mapping.findForward("doFonoCompra");
     }
     if (objetoForm.getAccion().equals("InicioAdm")) {
       return mapping.findForward("doBanco");
     }
     if (objetoForm.getAccion().equals("InicioRipleyDatos")) {
       return mapping.findForward("doRipleyDatos");
     }
     if (objetoForm.getAccion().equals("InicioSavReporte")) {
       return mapping.findForward("doSavReporte");
     }
     if (objetoForm.getAccion().equals("InicioActualizaFechaBoleta")) {
       return mapping.findForward("doActualizaFechaBoleta");
     }
     if (objetoForm.getAccion().equals("InicioActivacionGCP")) {
       return mapping.findForward("doActivacionGCP");
     }
     if (objetoForm.getAccion().equals("InicioAuditoriaGCP")) {
       return mapping.findForward("doAuditoriaGCP");
     }
     if (objetoForm.getAccion().equals("InicioAperturaCierreGCP")) {
       return mapping.findForward("doAperturaCierreGCP");
     }
     if (objetoForm.getAccion().equals("InicioReporteRMC")) {
       return mapping.findForward("doReporteRMC");
     }
     if (objetoForm.getAccion().equals("InicioBusquedaRMC")) {
       return mapping.findForward("doBusquedaRMC");
     }
     if (objetoForm.getAccion().equals("InicioCierreActivacionGCP")) {
       return mapping.findForward("doCierreActivacionGCP");
     }
     if (objetoForm.getAccion().equals("InicioProductoChannel")) {
       return mapping.findForward("doProdChannel");
     }
     if (objetoForm.getAccion().equals("InicioVentasXusuario")) {
       return mapping.findForward("doInicioVentasXusuario");
     }
     if (objetoForm.getAccion().equals("InicioRefinanciacion")) {
       return mapping.findForward("doInicioRefinanciacion");
     }
     if (objetoForm.getAccion().equals("InicioReporteStockExcel")) {
       return mapping.findForward("doInicioReporteStockExcel");
     }
     if (objetoForm.getAccion().equals("InicioBorradoPromociones")) {
       return mapping.findForward("doInicioBorradoPromociones");
     }
     if (objetoForm.getAccion().equals("InicioCargaVentasWC")) {
       return mapping.findForward("doInicioCargaVentasWC");
     }
     if (objetoForm.getAccion().equals("InicioLimpiezaBolsaCompra")) {
       return mapping.findForward("doInicioLimpiezaBolsaCompra");
     }
     if (objetoForm.getAccion().equals("InicioTRE_RMC")) {
       return mapping.findForward("doInicioTRE_RMC");
     }
     if (objetoForm.getAccion().equals("InicioActualizaStock")) {
       return mapping.findForward("doInicioActualizaStock");
     }
     if (objetoForm.getAccion().equals("InicioActualizaEstadoOC")) {
       return mapping.findForward("doInicioActualizaEstadoOC");
     }
     if (objetoForm.getAccion().equals("InicioReporteWebPayIncompleta")) {
       return mapping.findForward("doInicioReporteWebPayIncompleta");
     }
     if (objetoForm.getAccion().equals("ReporteClientesEncuesta")) {
         return mapping.findForward("doReporteClientesEncuesta");
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
 * Qualified Name:     cl.ripley.GestionTV.struts.action.MenuAction
 * JD-Core Version:    0.6.2
 */