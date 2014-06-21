 package cl.ripley.GestionTV.struts.action;
 
 import cl.ripley.GestionTV.struts.bean.Sucursal;
 import cl.ripley.GestionTV.struts.bean.TRE_RMCBean;
 import cl.ripley.GestionTV.struts.form.TRE_RMCForm;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import javax.servlet.http.HttpSession;
 import org.apache.struts.action.Action;
 import org.apache.struts.action.ActionForm;
 import org.apache.struts.action.ActionForward;
 import org.apache.struts.action.ActionMapping;
 
 public class TRE_RMCAction extends Action
 {
   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
     throws Exception
   {
     String Conectado = (String)request.getSession().getAttribute("Conectado");
     if (Conectado == null) {
       return mapping.findForward("timeOut");
     }
 
     TRE_RMCForm conForm = (TRE_RMCForm)form;
     TRE_RMCBean conBean = new TRE_RMCBean();
     Sucursal traSucursal = new Sucursal();
 
     String nombreUsuario = (String)request.getSession().getAttribute("strNomUsr");
     String idUsuario = (String)request.getSession().getAttribute("strRutUsr");
 
     if (conForm.getAccion().equals("InicioTRE_RMC"))
     {
       request.getSession().setAttribute("formulario_tre", null);
       conForm.setVctDetalles(null);
       conForm.setHayDatos("no");
       conForm.setFlagDatosBD("no");
       conForm.setHayDatosExportar("no");
       conForm.setFec_inicio("");
       conForm.setNum_rmc("");
       conForm.setNumTRE("");
       conForm.setActualiza("no");
 
       conForm.setCollSucursal(traSucursal.getCollSucursal(getDataSource(request, "Oracle"), "gestion_78.inst04"));
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
       conForm.setUsuario(nombreUsuario);
       conBean.getDepartamentos(getDataSource(request, "Oracle"), conForm.getNumTRE());
       conForm.setSelectDepartamentos(conBean.getDepartamentos());
       conForm.setGlosaDepartemento(conBean.getGrupoDepto());
 
       conForm.setMensaje("");
       conBean.setNroBloque(conForm.getNroBloque());
       conBean.setRegistrosPorBloque(conForm.getRegistrosPorBloque());
       conBean.setIndice(conForm.getIndice());
 
       conBean.getDatosTRE(getDataSource(request, "Oracle"), conForm.getNumTRE());
 
       if (conBean.getHayDatos().equals("si"))
       {
         conForm.setRutEmpresa(conBean.getRutEmpresa());
         conForm.setArea(conBean.getArea());
         conForm.setNumConvenio(conBean.getNumConvenio());
         conForm.setNumLote(conBean.getNumLote());
         conForm.setMontoOtorgado(conBean.getMontoOtorgado());
         conForm.setSaldoDisponible(conBean.getSaldoDisponible());
         conForm.setFechaVcto(conBean.getFechaVcto());
         conForm.setEstado(conBean.getEstado());
         conForm.setGlosaTarjeta(conBean.getGlosaTarjeta());
         conForm.setFechaVctoOrigen(conBean.getFechaVctoOrigen());
         conForm.setFlagDatosBD("si");
       } else {
         conForm.setMensaje("ERROR: Nº TRE no existe.");
         conForm.setFlagDatosBD("NO");
       }
 
       conBean.setTotalReg(conForm.getTotalRegistros());
 
       conForm.setHayDatos(conBean.getHayDatos());
       conForm.setHayProximoBloque("NO");
       conForm.setNroBloque(conBean.getNroBloque());
       conForm.setContador(conBean.getContador());
 
       conForm.setListaPagina(conBean.getListaPagina());
       conForm.setHayDatosExportar("no");
 
       return mapping.findForward("iniciar");
     }
 
     if (conForm.getAccion().equals("Grabar")) {
       int resp = 0;
       resp = conBean.grabarRMC(getDataSource(request, "Oracle"), conForm.getNumTRE(), conForm.getNum_rmc(), 
         nombreUsuario, idUsuario, conForm.getCodSucursal(), conForm.getGlosaSucursal());
 
       if (resp < 0)
       {
         conForm.setMensaje("Error al grabar Nº RMC.\nVerifique que Nº RMC no exista para la TRE: " + conForm.getNumTRE());
         return mapping.findForward("iniciar");
       }
 
       conForm.setMensaje("RMC grabada exitosamente.");
       conForm.setHayDatosExportar("si");
       return mapping.findForward("iniciar");
     }
 
     if (conForm.getAccion().equals("Imprimir"))
     {
       request.getSession().setAttribute("formulario_tre", conForm);
 
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
 * Qualified Name:     cl.ripley.GestionTV.struts.action.TRE_RMCAction
 * JD-Core Version:    0.6.2
 */