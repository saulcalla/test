 package cl.ripley.GestionTV.struts.action;
 
 import cl.ripley.GestionTV.struts.bean.Ejecutivo;
 import cl.ripley.GestionTV.struts.bean.Estado;
 import cl.ripley.GestionTV.struts.bean.VtaBancoBean;
 import cl.ripley.GestionTV.struts.form.VtaBancoForm;
 import java.util.Vector;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import javax.servlet.http.HttpSession;
 import org.apache.struts.action.Action;
 import org.apache.struts.action.ActionForm;
 import org.apache.struts.action.ActionForward;
 import org.apache.struts.action.ActionMapping;
 
 public class VtaBancoAction extends Action
 {
   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
     throws Exception
   {
     String Conectado = (String)request.getSession().getAttribute("Conectado");
     if (Conectado == null) {
       return mapping.findForward("timeOut");
     }
 
     VtaBancoForm traForm = (VtaBancoForm)form;
     VtaBancoBean traBean = new VtaBancoBean();
     Estado traEstado = new Estado();
     Ejecutivo traEjecutivo = new Ejecutivo();
 
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
 
     if (traForm.getAccion().equals("InicioBanco")) {
       traForm.setHayDatos("no");
       traForm.setFechaFiltro("");
       traForm.setCreditoFiltro("");
       traForm.setRutFiltro("");
       traForm.setDvFiltro("");
       traForm.setNombreFiltro("");
       traForm.setMaternoFiltro("");
       traForm.setPaternoFiltro("");
       traForm.setCollEstadoFiltro(traEstado.getCollEstado(getDataSource(request, "Db2")));
       traForm.setCodEstadoFiltro(traEstado.getPrimerCodEstado());
       traForm.setGlosaEstadoFiltro(traEstado.getPrimerNomEstado());
       traForm.setTipoFiltro("0");
       traForm.setHayDatos("no");
       return mapping.findForward("grilla");
     }
 
     if (traForm.getAccion().equals("buscar"))
     {
       traBean.setFechaFiltro(traForm.getFechaFiltro());
       traBean.setCreditoFiltro(traForm.getCreditoFiltro());
       traBean.setRutFiltro(traForm.getRutFiltro());
       traBean.setNombreFiltro(traForm.getNombreFiltro());
       traBean.setMaternoFiltro(traForm.getMaternoFiltro());
       traBean.setPaternoFiltro(traForm.getPaternoFiltro());
       traBean.setCodEstadoFiltro(traForm.getCodEstadoFiltro());
       traBean.setTipoFiltro(traForm.getTipoFiltro());
 
       traBean.setCodEjecutivo(idUsuario);
 
       traBean.setRegistrosPorBloque(50);
       traForm.setRegistrosPorBloque(0);
       traBean.setIndice(0);
       traForm.setIndice(0);
       traForm.setChkCodigos(new String[0]);
 
       traForm.setTotalRegistros(traBean
         .getTotalRegistrosFiltro(getDataSource(request, "Db2")));
       traBean.setTotalReg(traForm.getTotalRegistros());
 
       traForm.setVctTabla(traBean.getPaginacionFiltro(getDataSource(request, "Db2")));
 
       traForm.setHayDatos(traBean.getHayDatos());
       traForm.setHayProximoBloque(traBean.getHayProximoBloque());
       traForm.setNroBloque(traBean.getNroBloque());
       traForm.setContador(traBean.getContador());
 
       traForm.setFechaFiltro(traBean.getFechaFiltro());
       traForm.setCreditoFiltro(traBean.getCreditoFiltro());
       traForm.setRutFiltro(traBean.getRutFiltro());
       traForm.setNombreFiltro(traBean.getNombreFiltro());
       traForm.setMaternoFiltro(traBean.getMaternoFiltro());
       traForm.setPaternoFiltro(traBean.getPaternoFiltro());
       traForm.setCodEstadoFiltro(traBean.getCodEstadoFiltro());
 
       traForm.setListaPagina(traBean
         .getListaPagina());
 
       traForm.setMensaje(traBean.getMensaje());
       traForm.setFlagDatosBD("si");
       return mapping.findForward("grilla");
     }
 
     if (traForm.getAccion().equals("InicioAdm")) {
       traForm.setHayDatos("no");
       traForm.setFechaFiltro("");
       traForm.setCreditoFiltro("");
       traForm.setRutFiltro("");
       traForm.setDvFiltro("");
       traForm.setNombreFiltro("");
       traForm.setMaternoFiltro("");
       traForm.setPaternoFiltro("");
       traForm.setCollEstadoFiltro(traEstado.getCollEstado(getDataSource(request, "Db2")));
       traForm.setCodEstadoFiltro(traEstado.getPrimerCodEstado());
       traForm.setGlosaEstadoFiltro(traEstado.getPrimerNomEstado());
       traForm.setCollEjecutivoFiltro(traEjecutivo.getCollEjecutivo(getDataSource(request, "Db2")));
       traForm.setCodEjecutivoFiltro(traEjecutivo.getPrimerCodEjecutivo());
       traForm.setGlosaEjecutivoFiltro(traEjecutivo.getPrimerNomEjecutivo());
       traForm.setTipoFiltro("0");
       traForm.setHayDatos("no");
       return mapping.findForward("grillaadm");
     }
 
     if (traForm.getAccion().equals("buscarAdm"))
     {
       traBean.setFechaFiltro(traForm.getFechaFiltro());
       traBean.setCreditoFiltro(traForm.getCreditoFiltro());
       traBean.setRutFiltro(traForm.getRutFiltro());
       traBean.setNombreFiltro(traForm.getNombreFiltro());
       traBean.setMaternoFiltro(traForm.getMaternoFiltro());
       traBean.setPaternoFiltro(traForm.getPaternoFiltro());
       traBean.setCodEstadoFiltro(traForm.getCodEstadoFiltro());
       traBean.setCodEjecutivoFiltro(traForm.getCodEjecutivoFiltro());
       traBean.setTipoFiltro(traForm.getTipoFiltro());
 
       traBean.setRegistrosPorBloque(50);
       traForm.setRegistrosPorBloque(0);
       traBean.setIndice(0);
       traForm.setIndice(0);
       traForm.setChkCodigos(new String[0]);
 
       traForm.setTotalRegistros(traBean
         .getTotalRegistrosFiltroAdm(getDataSource(request, "Db2")));
       traBean.setTotalReg(traForm.getTotalRegistros());
 
       traForm.setVctTabla(traBean.getPaginacionFiltroAdm(getDataSource(request, "Db2")));
 
       traForm.setHayDatos(traBean.getHayDatos());
       traForm.setHayProximoBloque(traBean.getHayProximoBloque());
       traForm.setNroBloque(traBean.getNroBloque());
       traForm.setContador(traBean.getContador());
 
       traForm.setFechaFiltro(traBean.getFechaFiltro());
       traForm.setCreditoFiltro(traBean.getCreditoFiltro());
       traForm.setRutFiltro(traBean.getRutFiltro());
       traForm.setNombreFiltro(traBean.getNombreFiltro());
       traForm.setMaternoFiltro(traBean.getMaternoFiltro());
       traForm.setPaternoFiltro(traBean.getPaternoFiltro());
       traForm.setCodEstadoFiltro(traBean.getCodEstadoFiltro());
       traForm.setCodEjecutivoFiltro(traBean.getCodEjecutivoFiltro());
       traForm.setTipoFiltro(traBean.getTipoFiltro());
 
       traForm.setListaPagina(traBean
         .getListaPagina());
 
       traForm.setMensaje(traBean.getMensaje());
       traForm.setFlagDatosBD("si");
 
       if (traForm.getRut() != null)
       {
         traForm.setDv(traBean.calculaDV(traForm.getRut()));
       }
 
       return mapping.findForward("grillaadm");
     }
 
     if (traForm.getAccion().equals("editar_ingresar")) {
       traForm.setCredito("");
       traForm.setRut("");
       traForm.setDv("");
       traForm.setNombres("");
       traForm.setApellidoMaterno("");
       traForm.setApellidoPaterno("");
       traForm.setNumero("");
       traForm.setComuna("");
       traForm.setCiudad("");
       traForm.setTelefono1("");
       traForm.setTelefono2("");
       traForm.setCodigoProducto("");
       traForm.setObservacion("");
       traForm.setCodigoCP("");
       traForm.setNombreCP("");
       traForm.setCalle("");
       traForm.setDepartamento("");
       traForm.setVilla("");
       traForm.setReferencia("");
       traForm.setNombreProducto("");
       traForm.setOrdenCompra("");
       traForm.setMonto("");
 
       traForm.setEjecutivo(nombreUsuario);
 
       traBean.getMensaje();
       return mapping.findForward("ingresar");
     }
 
     if (traForm.getAccion().equals("editar_modificar"))
     {
       traBean.setCodigo(traForm.getCodigo());
 
       if (!traBean.buscarCredito(getDataSource(request, "Db2")))
       {
         traBean.setFechaFiltro(traForm.getFechaFiltro());
         traBean.setCreditoFiltro(traForm.getCreditoFiltro());
         traBean.setRutFiltro(traForm.getRutFiltro());
         traBean.setNombreFiltro(traForm.getNombreFiltro());
         traBean.setMaternoFiltro(traForm.getMaternoFiltro());
         traBean.setPaternoFiltro(traForm.getPaternoFiltro());
         traBean.setCodEstadoFiltro(traForm.getCodEstadoFiltro());
         traBean.setTipoFiltro(traForm.getTipoFiltro());
 
         traBean.setRegistrosPorBloque(10);
         traForm.setRegistrosPorBloque(10);
         traBean.setIndice(0);
         traForm.setIndice(0);
         traForm.setChkCodigos(new String[0]);
 
         traBean.setCodEjecutivo(idUsuario);
 
         traForm.setTotalRegistros(traBean
           .getTotalRegistrosFiltro(getDataSource(request, "Db2")));
         traBean.setTotalReg(traForm.getTotalRegistros());
 
         traForm.setVctTabla(traBean.getPaginacionFiltro(getDataSource(request, "Db2")));
 
         traForm.setHayDatos(traBean.getHayDatos());
         traForm.setHayProximoBloque(traBean.getHayProximoBloque());
         traForm.setNroBloque(traBean.getNroBloque());
         traForm.setContador(traBean.getContador());
 
         traForm.setFechaFiltro(traBean.getFechaFiltro());
         traForm.setCreditoFiltro(traBean.getCreditoFiltro());
         traForm.setRutFiltro(traBean.getRutFiltro());
         traForm.setNombreFiltro(traBean.getNombreFiltro());
         traForm.setMaternoFiltro(traBean.getMaternoFiltro());
         traForm.setPaternoFiltro(traBean.getPaternoFiltro());
         traForm.setCodEstadoFiltro(traBean.getCodEstadoFiltro());
 
         traForm.setListaPagina(traBean
           .getListaPagina());
 
         traForm.setMensaje(traBean.getMensaje());
         traForm.setFlagDatosBD("si");
         return mapping.findForward("grilla");
       }
 
       traForm.setCodEstado(traBean.getCodEstado());
 
       traForm.setCredito(traBean.getCredito());
       traForm.setRut(traBean.getRut());
       traForm.setDv(traBean.calculaDV(traBean.getRut()));
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
 
       traForm.setCalle(traBean.getCalle());
       traForm.setDepartamento(traBean.getDepartamento());
       traForm.setVilla(traBean.getVilla());
       traForm.setReferencia(traBean.getReferencia());
       traForm.setNombreProducto(traBean.getNombreProducto());
 
       traForm.setMonto(traBean.getMonto());
 
       traForm.setEjecutivo(traBean.getEjecutivo());
 
       traForm.setMensaje(traBean.getMensaje());
       return mapping.findForward("modificar");
     }
 
     if (traForm.getAccion().equals("editar_modificar_adm"))
     {
       traBean.setCodigo(traForm.getCodigo());
 
       if (!traBean.buscarCreditoAdm(getDataSource(request, "Db2")))
       {
         traBean.setFechaFiltro(traForm.getFechaFiltro());
         traBean.setCreditoFiltro(traForm.getCreditoFiltro());
         traBean.setRutFiltro(traForm.getRutFiltro());
         traBean.setNombreFiltro(traForm.getNombreFiltro());
         traBean.setMaternoFiltro(traForm.getMaternoFiltro());
         traBean.setPaternoFiltro(traForm.getPaternoFiltro());
         traBean.setCodEstadoFiltro(traForm.getCodEstadoFiltro());
         traBean.setCodEjecutivoFiltro(traForm.getCodEjecutivoFiltro());
         traBean.setTipoFiltro(traForm.getTipoFiltro());
 
         traBean.setRegistrosPorBloque(10);
         traForm.setRegistrosPorBloque(10);
         traBean.setIndice(0);
         traForm.setIndice(0);
         traForm.setChkCodigos(new String[0]);
 
         traForm.setTotalRegistros(traBean
           .getTotalRegistrosFiltroAdm(getDataSource(request, "Db2")));
         traBean.setTotalReg(traForm.getTotalRegistros());
 
         traForm.setVctTabla(traBean.getPaginacionFiltroAdm(getDataSource(request, "Db2")));
 
         traForm.setHayDatos(traBean.getHayDatos());
         traForm.setHayProximoBloque(traBean.getHayProximoBloque());
         traForm.setNroBloque(traBean.getNroBloque());
         traForm.setContador(traBean.getContador());
 
         traForm.setFechaFiltro(traBean.getFechaFiltro());
         traForm.setCreditoFiltro(traBean.getCreditoFiltro());
         traForm.setRutFiltro(traBean.getRutFiltro());
         traForm.setNombreFiltro(traBean.getNombreFiltro());
         traForm.setMaternoFiltro(traBean.getMaternoFiltro());
         traForm.setPaternoFiltro(traBean.getPaternoFiltro());
         traForm.setCodEstadoFiltro(traBean.getCodEstadoFiltro());
         traForm.setCodEjecutivoFiltro(traBean.getCodEjecutivoFiltro());
 
         traForm.setListaPagina(traBean
           .getListaPagina());
 
         traForm.setMensaje(traBean.getMensaje());
         traForm.setFlagDatosBD("si");
         return mapping.findForward("grillaadm");
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
 
       traForm.setMensaje(traBean.getMensaje());
 
       if (traForm.getRut() != null)
       {
         traForm.setDv(traBean.calculaDV(traForm.getRut()));
       }
 
       return mapping.findForward("modificaradm");
     }
 
     if (traForm.getAccion().equals("grabar_modificar"))
     {
       traBean.setCredito(traForm.getCredito());
       traBean.setRut(traForm.getRut());
       traBean.setNombres(traForm.getNombres());
       traBean.setApellidoMaterno(traForm.getApellidoMaterno());
       traBean.setApellidoPaterno(traForm.getApellidoPaterno());
       traBean.setCalle(traForm.getCalle());
       traBean.setNumero(traForm.getNumero());
       traBean.setDepartamento(traForm.getDepartamento());
       traBean.setComuna(traForm.getComuna());
       traBean.setVilla(traForm.getVilla());
       traBean.setCiudad(traForm.getCiudad());
       traBean.setReferencia(traForm.getReferencia());
       traBean.setTelefono1(traForm.getTelefono1());
       traBean.setTelefono2(traForm.getTelefono2());
       traBean.setCodigoProducto(traForm.getCodigoProducto());
       traBean.setNombreProducto(traForm.getNombreProducto());
       traBean.setMonto(traForm.getMonto());
       traBean.setObservacion(traForm.getObservacion());
 
       traBean.setCodEjecutivo(idUsuario);
 
       if (!traBean.modificarCredito(getDataSource(request, "Db2"))) {
         traForm.setMensaje(traBean.getMensaje());
         return mapping.findForward("modificar");
       }
 
       traForm.setMensaje(traBean.getMensaje());
 
       traBean.setFechaFiltro(traForm.getFechaFiltro());
       traBean.setCreditoFiltro(traForm.getCreditoFiltro());
       traBean.setRutFiltro(traForm.getRutFiltro());
       traBean.setNombreFiltro(traForm.getNombreFiltro());
       traBean.setMaternoFiltro(traForm.getMaternoFiltro());
       traBean.setPaternoFiltro(traForm.getPaternoFiltro());
       traBean.setCodEstadoFiltro(traForm.getCodEstadoFiltro());
       traBean.setTipoFiltro(traForm.getTipoFiltro());
 
       traBean.setNroBloque(traForm.getNroBloque());
       traBean.setRegistrosPorBloque(traForm.getRegistrosPorBloque());
       traBean.setIndice(traForm.getIndice());
 
       traBean.setCodEjecutivo(idUsuario);
 
       traForm.setTotalRegistros(traBean
         .getTotalRegistrosFiltro(getDataSource(request, "Db2")));
       traBean.setTotalReg(traForm.getTotalRegistros());
 
       traForm.setVctTabla(traBean
         .getPaginacionFiltro(getDataSource(request, "Db2")));
 
       traForm.setHayDatos(traBean.getHayDatos());
       traForm.setHayProximoBloque(traBean.getHayProximoBloque());
       traForm.setNroBloque(traBean.getNroBloque());
       traForm.setContador(traBean.getContador());
 
       traForm.setFechaFiltro(traBean.getFechaFiltro());
       traForm.setCreditoFiltro(traBean.getCreditoFiltro());
       traForm.setRutFiltro(traBean.getRutFiltro());
       traForm.setNombreFiltro(traBean.getNombreFiltro());
       traForm.setMaternoFiltro(traBean.getMaternoFiltro());
       traForm.setPaternoFiltro(traBean.getPaternoFiltro());
       traForm.setCodEstadoFiltro(traBean.getCodEstadoFiltro());
 
       traForm.setListaPagina(traBean
         .getListaPagina());
       traForm.setChkCodigos(new String[0]);
 
       return mapping.findForward("grilla");
     }
 
     if (traForm.getAccion().equals("grabar_modificar_adm"))
     {
       traBean.setCredito(traForm.getCredito());
       traBean.setRut(traForm.getRut());
       traBean.setNombres(traForm.getNombres());
       traBean.setApellidoMaterno(traForm.getApellidoMaterno());
       traBean.setApellidoPaterno(traForm.getApellidoPaterno());
       traBean.setCalle(traForm.getCalle());
       traBean.setNumero(traForm.getNumero());
       traBean.setDepartamento(traForm.getDepartamento());
       traBean.setComuna(traForm.getComuna());
       traBean.setVilla(traForm.getVilla());
       traBean.setCiudad(traForm.getCiudad());
       traBean.setReferencia(traForm.getReferencia());
       traBean.setTelefono1(traForm.getTelefono1());
       traBean.setTelefono2(traForm.getTelefono2());
       traBean.setCodigoProducto(traForm.getCodigoProducto());
       traBean.setNombreProducto(traForm.getNombreProducto());
       traBean.setMonto(traForm.getMonto());
       traBean.setObservacion(traForm.getObservacion());
       traBean.setCodigoCP(traForm.getCodigoCP());
       traBean.setNombreCP(traForm.getNombreCP());
       traBean.setOrdenCompra(traForm.getOrdenCompra());
 
       traBean.setCodEstado(traForm.getCodEstado());
       traBean.setGlosaEstado(traForm.getGlosaEstado());
 
       traBean.setCodAdministrador(idUsuario);
 
       if (!traBean.modificarCreditoAdm(getDataSource(request, "Db2"))) {
         traForm.setMensaje(traBean.getMensaje());
         return mapping.findForward("modificaradm");
       }
 
       traForm.setMensaje(traBean.getMensaje());
 
       traBean.setFechaFiltro(traForm.getFechaFiltro());
       traBean.setCreditoFiltro(traForm.getCreditoFiltro());
       traBean.setRutFiltro(traForm.getRutFiltro());
       traBean.setNombreFiltro(traForm.getNombreFiltro());
       traBean.setMaternoFiltro(traForm.getMaternoFiltro());
       traBean.setPaternoFiltro(traForm.getPaternoFiltro());
       traBean.setCodEstadoFiltro(traForm.getCodEstadoFiltro());
       traBean.setCodEjecutivoFiltro(traForm.getCodEjecutivoFiltro());
       traBean.setTipoFiltro(traForm.getTipoFiltro());
 
       traBean.setNroBloque(traForm.getNroBloque());
       traBean.setRegistrosPorBloque(traForm.getRegistrosPorBloque());
       traBean.setIndice(traForm.getIndice());
 
       traForm.setTotalRegistros(traBean
         .getTotalRegistrosFiltroAdm(getDataSource(request, "Db2")));
       traBean.setTotalReg(traForm.getTotalRegistros());
 
       traForm.setVctTabla(traBean
         .getPaginacionFiltroAdm(getDataSource(request, "Db2")));
 
       traForm.setHayDatos(traBean.getHayDatos());
       traForm.setHayProximoBloque(traBean.getHayProximoBloque());
       traForm.setNroBloque(traBean.getNroBloque());
       traForm.setContador(traBean.getContador());
 
       traForm.setListaPagina(traBean
         .getListaPagina());
       traForm.setChkCodigos(new String[0]);
       return mapping.findForward("grillaadm");
     }
 
     if (traForm.getAccion().equals("grabar_nuevo"))
     {
       traBean.setCredito(traForm.getCredito());
       traBean.setRut(traForm.getRut());
       traBean.setNombres(traForm.getNombres());
       traBean.setApellidoMaterno(traForm.getApellidoMaterno());
       traBean.setApellidoPaterno(traForm.getApellidoPaterno());
       traBean.setCalle(traForm.getCalle());
       traBean.setNumero(traForm.getNumero());
       traBean.setCiudad(traForm.getCiudad());
       traBean.setComuna(traForm.getComuna());
       traBean.setDepartamento(traForm.getDepartamento());
       traBean.setVilla(traForm.getVilla());
       traBean.setTelefono1(traForm.getTelefono1());
       traBean.setTelefono2(traForm.getTelefono2());
       traBean.setCodigoProducto(traForm.getCodigoProducto());
       traBean.setNombreProducto(traForm.getNombreProducto());
       traBean.setMonto(traForm.getMonto());
       traBean.setObservacion(traForm.getObservacion());
       traBean.setReferencia(traForm.getReferencia());
 
       traBean.setCodEjecutivo(idUsuario);
       traBean.setEjecutivo(nombreUsuario);
 
       if (traBean.checkExiste(getDataSource(request, "Db2")))
       {
         traForm.setMensaje(traBean.getMensaje());
         traForm.setAccion("editar_ingresar");
         return mapping.findForward("ingresar");
       }
 
       if (!traBean.ingresarCredito(getDataSource(request, "Db2"))) {
         traForm.setMensaje(traBean.getMensaje());
         traForm.setAccion("editar_ingresar");
         return mapping.findForward("ingresar");
       }
 
       traForm.setCredito("");
       traForm.setRut("");
       traForm.setDv("");
       traForm.setNombres("");
       traForm.setApellidoMaterno("");
       traForm.setApellidoPaterno("");
       traForm.setNumero("");
       traForm.setComuna("");
       traForm.setCiudad("");
       traForm.setTelefono1("");
       traForm.setTelefono2("");
       traForm.setCodigoProducto("");
       traForm.setObservacion("");
       traForm.setCodigoCP("");
       traForm.setNombreCP("");
       traForm.setCalle("");
       traForm.setDepartamento("");
       traForm.setVilla("");
       traForm.setReferencia("");
       traForm.setNombreProducto("");
       traForm.setOrdenCompra("");
       traForm.setMonto("");
 
       traForm.setCodEstado("");
 
       traForm.setMensaje(traBean.getMensaje());
 
       traBean.setFechaFiltro(traForm.getFechaFiltro());
       traBean.setCreditoFiltro(traForm.getCreditoFiltro());
       traBean.setRutFiltro(traForm.getRutFiltro());
       traBean.setNombreFiltro(traForm.getNombreFiltro());
       traBean.setMaternoFiltro(traForm.getMaternoFiltro());
       traBean.setPaternoFiltro(traForm.getPaternoFiltro());
       traBean.setCodEstadoFiltro(traForm.getCodEstadoFiltro());
       traBean.setTipoFiltro(traForm.getTipoFiltro());
 
       traBean.setCodEjecutivo(idUsuario);
 
       traBean.setNroBloque(traForm.getNroBloque());
       traBean.setRegistrosPorBloque(traForm
         .getRegistrosPorBloque());
       traBean.setIndice(traForm.getIndice());
 
       traForm.setTotalRegistros(traBean
         .getTotalRegistrosFiltro(getDataSource(request, "Db2")));
       traBean.setTotalReg(traForm.getTotalRegistros());
 
       traForm.setVctTabla(traBean
         .getPaginacionFiltro(getDataSource(request, "Db2")));
 
       traForm.setHayDatos(traBean.getHayDatos());
       traForm.setHayProximoBloque(traBean.getHayProximoBloque());
       traForm.setNroBloque(traBean.getNroBloque());
       traForm.setContador(traBean.getContador());
 
       traForm.setFechaFiltro(traBean.getFechaFiltro());
       traForm.setCreditoFiltro(traBean.getCreditoFiltro());
       traForm.setRutFiltro(traBean.getRutFiltro());
       traForm.setNombreFiltro(traBean.getNombreFiltro());
       traForm.setMaternoFiltro(traBean.getMaternoFiltro());
       traForm.setPaternoFiltro(traBean.getPaternoFiltro());
       traForm.setCodEstadoFiltro(traBean.getCodEstadoFiltro());
 
       traForm.setListaPagina(traBean
         .getListaPagina());
       traForm.setChkCodigos(new String[0]);
 
       return mapping.findForward("grilla");
     }
 
     if (traForm.getAccion().equals("mostrar"))
     {
       traBean.setNroBloque(traForm.getNroBloque());
       traBean.setRegistrosPorBloque(traForm.getRegistrosPorBloque());
       traBean.setIndice(traForm.getIndice());
 
       traBean.setFechaFiltro(traForm.getFechaFiltro());
       traBean.setCreditoFiltro(traForm.getCreditoFiltro());
       traBean.setRutFiltro(traForm.getRutFiltro());
       traBean.setNombreFiltro(traForm.getNombreFiltro());
       traBean.setMaternoFiltro(traForm.getMaternoFiltro());
       traBean.setPaternoFiltro(traForm.getPaternoFiltro());
       traBean.setCodEstadoFiltro(traForm.getCodEstadoFiltro());
       traBean.setTipoFiltro(traForm.getTipoFiltro());
 
       traBean.setCodEjecutivo(idUsuario);
 
       traForm.setTotalRegistros(traBean.getTotalRegistrosFiltro(getDataSource(request, "Db2")));
       traBean.setTotalReg(traForm.getTotalRegistros());
 
       traForm.setVctTabla(traBean.getPaginacionFiltro(getDataSource(request, "Db2")));
       if (traForm.getVctTabla().size() == 0) {
         traForm.setFlagDatosBD("no");
       }
 
       traForm.setHayDatos(traBean.getHayDatos());
       traForm.setHayProximoBloque(traBean.getHayProximoBloque());
       traForm.setNroBloque(traBean.getNroBloque());
       traForm.setContador(traBean.getContador());
 
       traForm.setListaPagina(traBean.getListaPagina());
 
       traForm.setMensaje(traBean.getMensaje());
 
       traForm.setTipoFiltro(traBean.getTipoFiltro());
       traForm.setFechaFiltro(traBean.getFechaFiltro());
       traForm.setCreditoFiltro(traBean.getCreditoFiltro());
       traForm.setRutFiltro(traBean.getRutFiltro());
       traForm.setNombreFiltro(traBean.getNombreFiltro());
       traForm.setMaternoFiltro(traBean.getMaternoFiltro());
       traForm.setPaternoFiltro(traBean.getPaternoFiltro());
       traForm.setCodEstadoFiltro(traBean.getCodEstadoFiltro());
 
       traForm.setFlagDatosBD("si");
       return mapping.findForward("grilla");
     }
     if (traForm.getAccion().equals("mostrarAdm"))
     {
       traBean.setNroBloque(traForm.getNroBloque());
       traBean.setRegistrosPorBloque(traForm.getRegistrosPorBloque());
       traBean.setIndice(traForm.getIndice());
 
       traBean.setFechaFiltro(traForm.getFechaFiltro());
       traBean.setCreditoFiltro(traForm.getCreditoFiltro());
       traBean.setRutFiltro(traForm.getRutFiltro());
       traBean.setNombreFiltro(traForm.getNombreFiltro());
       traBean.setMaternoFiltro(traForm.getMaternoFiltro());
       traBean.setPaternoFiltro(traForm.getPaternoFiltro());
       traBean.setCodEstadoFiltro(traForm.getCodEstadoFiltro());
       traBean.setCodEjecutivoFiltro(traForm.getCodEjecutivoFiltro());
       traBean.setTipoFiltro(traForm.getTipoFiltro());
 
       traForm.setTotalRegistros(traBean.getTotalRegistrosFiltroAdm(getDataSource(request, "Db2")));
       traBean.setTotalReg(traForm.getTotalRegistros());
 
       traForm.setVctTabla(traBean.getPaginacionFiltroAdm(getDataSource(request, "Db2")));
       if (traForm.getVctTabla().size() == 0) {
         traForm.setFlagDatosBD("no");
       }
 
       traForm.setHayDatos(traBean.getHayDatos());
       traForm.setHayProximoBloque(traBean.getHayProximoBloque());
       traForm.setNroBloque(traBean.getNroBloque());
       traForm.setContador(traBean.getContador());
 
       traForm.setTipoFiltro(traBean.getTipoFiltro());
       traForm.setFechaFiltro(traBean.getFechaFiltro());
       traForm.setCreditoFiltro(traBean.getCreditoFiltro());
       traForm.setRutFiltro(traBean.getRutFiltro());
       traForm.setNombreFiltro(traBean.getNombreFiltro());
       traForm.setMaternoFiltro(traBean.getMaternoFiltro());
       traForm.setPaternoFiltro(traBean.getPaternoFiltro());
       traForm.setCodEstadoFiltro(traBean.getCodEstadoFiltro());
       traForm.setCodEjecutivoFiltro(traBean.getCodEjecutivoFiltro());
 
       traForm.setListaPagina(traBean.getListaPagina());
 
       traForm.setMensaje(traBean.getMensaje());
 
       traForm.setFlagDatosBD("si");
       return mapping.findForward("grillaadm");
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
 * Qualified Name:     cl.ripley.GestionTV.struts.action.VtaBancoAction
 * JD-Core Version:    0.6.2
 */