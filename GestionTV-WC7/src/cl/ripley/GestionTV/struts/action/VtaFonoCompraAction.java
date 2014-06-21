 package cl.ripley.GestionTV.struts.action;
 
 import cl.ripley.GestionTV.struts.bean.Estado;
 import cl.ripley.GestionTV.struts.bean.VtaFonoCompraBean;
 import cl.ripley.GestionTV.struts.form.VtaFonoCompraForm;
 import java.util.Vector;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import javax.servlet.http.HttpSession;
 import org.apache.struts.action.Action;
 import org.apache.struts.action.ActionForm;
 import org.apache.struts.action.ActionForward;
 import org.apache.struts.action.ActionMapping;
 
 public class VtaFonoCompraAction extends Action
 {
   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
     throws Exception
   {
     String Conectado = (String)request.getSession().getAttribute("Conectado");
     if (Conectado == null) {
       return mapping.findForward("timeOut");
     }
 
     VtaFonoCompraForm traForm = (VtaFonoCompraForm)form;
     VtaFonoCompraBean traBean = new VtaFonoCompraBean();
     Estado traEstado = new Estado();
 
     String idUsuario = (String)request.getSession().getAttribute("strRutUsr");
     String nombreUsuario = (String)request.getSession().getAttribute("strNomUsr");
 
     if (isCancelled(request)) {
       removeFormBean(mapping, request);
       return mapping.findForward("cancelar");
     }
 
     if (traForm.getAccion().equals("cancelar")) {
       removeFormBean(mapping, request);
       return mapping.findForward("cancelar");
     }
 
     if (traForm.getAccion().equals("InicioFonoCompra"))
     {
       traBean.setRegistrosPorBloque(10);
       traForm.setRegistrosPorBloque(10);
       traBean.setIndice(0);
       traForm.setIndice(0);
       traForm.setChkCodigos(new String[0]);
 
       traForm.setTotalRegistros(traBean
         .getTotalRegistros(getDataSource(request, "Db2")));
       traBean.setTotalReg(traForm.getTotalRegistros());
 
       traForm.setVctTabla(traBean.getPaginacion(getDataSource(request, "Db2")));
 
       traForm.setHayDatos(traBean.getHayDatos());
       traForm.setHayProximoBloque(traBean.getHayProximoBloque());
       traForm.setNroBloque(traBean.getNroBloque());
       traForm.setContador(traBean.getContador());
 
       traForm.setListaPagina(traBean
         .getListaPagina());
 
       traForm.setMensaje(traBean.getMensaje());
       return mapping.findForward("inicio");
     }
 
     if (traForm.getAccion().equals("editar_modificar"))
     {
       traBean.setCodigo(traForm.getCodigo());
 
       if (!traBean.buscarCredito(getDataSource(request, "Db2")))
       {
         traBean.setRegistrosPorBloque(10);
         traForm.setRegistrosPorBloque(10);
         traBean.setIndice(0);
         traForm.setIndice(0);
         traForm.setChkCodigos(new String[0]);
 
         traForm.setTotalRegistros(traBean
           .getTotalRegistros(getDataSource(request, "Db2")));
         traBean.setTotalReg(traForm.getTotalRegistros());
 
         traForm.setVctTabla(traBean.getPaginacion(getDataSource(request, "Db2")));
 
         traForm.setHayDatos(traBean.getHayDatos());
         traForm.setHayProximoBloque(traBean.getHayProximoBloque());
         traForm.setNroBloque(traBean.getNroBloque());
         traForm.setContador(traBean.getContador());
 
         traForm.setListaPagina(traBean
           .getListaPagina());
 
         traForm.setMensaje(traBean.getMensaje());
         return mapping.findForward("inicio");
       }
 
       traForm.setCollEstado(traEstado.getCollEstadoAlgunos(getDataSource(request, "Db2")));
       traForm.setCodEstado(traBean.getEstado());
 
       traForm.setEjecutivo(traBean.getEjecutivo());
       traForm.setCredito(traBean.getCredito());
       traForm.setRut(traBean.getRut());
       traForm.setNombres(traBean.getNombres());
       traForm.setApellidoMaterno(traBean.getApellidoMaterno());
       traForm.setApellidoPaterno(traBean.getApellidoPaterno());
       traForm.setNumero(traBean.getNumero());
       traForm.setComuna(traBean.getComuna());
       traForm.setCiudad(traBean.getCiudad());
       traForm.setTelefono1(traBean.getTelefono1());
       traForm.setTelefono2(traBean.getTelefono2());
       traForm.setCodigoProducto(traBean.getCodigoProducto());
       traForm.setObservacion(traBean.getObservacion());
       traForm.setCodigoCP(traBean.getCodigoCP());
       traForm.setNombreCP(traBean.getNombreCP());
       traForm.setCalle(traBean.getCalle());
       traForm.setDepartamento(traBean.getDepartamento());
       traForm.setVilla(traBean.getVilla());
       traForm.setReferencia(traBean.getReferencia());
       traForm.setNombreProducto(traBean.getNombreProducto());
       traForm.setOrdenCompra(traBean.getOrdenCompra());
       traForm.setMonto(traBean.getMonto());
 
       traForm.setDv(traBean.calculaDV(traBean.getRut()));
 
       return mapping.findForward("modificar");
     }
 
     if (traForm.getAccion().equals("grabar_modificar"))
     {
       traBean.setCredito(traForm.getCredito());
       traBean.setRut(traForm.getRut());
       traBean.setObservacion(traForm.getObservacion());
       traBean.setCodigoCP(traForm.getCodigoCP());
       traBean.setNombreCP(traForm.getNombreCP());
       traBean.setOrdenCompra(traForm.getOrdenCompra());
       traBean.setCodEstado(traForm.getCodEstado());
       traBean.setGlosaEstado(traForm.getGlosaEstado());
       traBean.setCodEjecutivo(idUsuario);
 
       if (!traBean.modificarCredito(getDataSource(request, "Db2"))) {
         traForm.setMensaje(traBean.getMensaje());
         return mapping.findForward("modificar");
       }
 
       traForm.setMensaje(traBean.getMensaje());
 
       traBean.setCredito(traForm.getCredito());
       traBean.setRut(traForm.getRut());
       traBean.setNombres(traForm.getNombres());
       traBean.setApellidoMaterno(traForm.getApellidoMaterno());
       traBean.setApellidoPaterno(traForm.getApellidoPaterno());
 
       traBean.setNroBloque(traForm.getNroBloque());
       traBean.setRegistrosPorBloque(traForm.getRegistrosPorBloque());
       traBean.setIndice(traForm.getIndice());
 
       traForm.setTotalRegistros(traBean
         .getTotalRegistros(getDataSource(request, "Db2")));
       traBean.setTotalReg(traForm.getTotalRegistros());
 
       traForm.setVctTabla(traBean
         .getPaginacion(getDataSource(request, "Db2")));
 
       traForm.setHayDatos(traBean.getHayDatos());
       traForm.setHayProximoBloque(traBean.getHayProximoBloque());
       traForm.setNroBloque(traBean.getNroBloque());
       traForm.setContador(traBean.getContador());
 
       traForm.setListaPagina(traBean
         .getListaPagina());
       traForm.setChkCodigos(new String[0]);
       return mapping.findForward("inicio");
     }
 
     if (traForm.getAccion().equals("mostrar"))
     {
       traBean.setNroBloque(traForm.getNroBloque());
       traBean.setRegistrosPorBloque(traForm.getRegistrosPorBloque());
       traBean.setIndice(traForm.getIndice());
 
       traForm.setTotalRegistros(traBean.getTotalRegistros(getDataSource(request, "Db2")));
       traBean.setTotalReg(traForm.getTotalRegistros());
 
       traForm.setVctTabla(traBean.getPaginacion(getDataSource(request, "Db2")));
       if (traForm.getVctTabla().size() == 0) {
         traForm.setFlagDatosBD("no");
       }
 
       traForm.setHayDatos(traBean.getHayDatos());
       traForm.setHayProximoBloque(traBean.getHayProximoBloque());
       traForm.setNroBloque(traBean.getNroBloque());
       traForm.setContador(traBean.getContador());
 
       traForm.setListaPagina(traBean.getListaPagina());
       traForm.setMensaje(traBean.getMensaje());
 
       return mapping.findForward("inicio");
     }
 
     removeFormBean(mapping, request);
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
 * Qualified Name:     cl.ripley.GestionTV.struts.action.VtaFonoCompraAction
 * JD-Core Version:    0.6.2
 */