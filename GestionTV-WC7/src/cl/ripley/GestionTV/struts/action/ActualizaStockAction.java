 package cl.ripley.GestionTV.struts.action;
 
 import cl.ripley.GestionTV.struts.bean.ActualizaStockBean;
 import cl.ripley.GestionTV.struts.form.ActualizaStockForm;
 import java.util.Vector;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import javax.servlet.http.HttpSession;
 import org.apache.struts.action.Action;
 import org.apache.struts.action.ActionForm;
 import org.apache.struts.action.ActionForward;
 import org.apache.struts.action.ActionMapping;
 import org.apache.struts.upload.FormFile;
 
 public class ActualizaStockAction extends Action
 {
   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
     throws Exception
   {
     String Conectado = (String)request.getSession().getAttribute("Conectado");
 
     if (Conectado == null) {
       return mapping.findForward("timeOut");
     }
 
     ActualizaStockForm conForm = (ActualizaStockForm)form;
     ActualizaStockBean conBean = new ActualizaStockBean();
 
     conForm.setMensaje("");
     if (conForm.getAccion().equals("InicioActualizaStock"))
     {
       conForm.setHayDatos("no");
       conForm.setFlagDatosBD("si");
       conForm.setHayDatosExportar("no");
       conForm.setActualiza("no");
       conForm.setMensaje("");
 
       conForm.setTotal_registros(0);
       conForm.setPreview(null);
       return mapping.findForward("iniciar");
     }
 
     if (conForm.getAccion().equals("buscar"))
     {
       FormFile myFile = conForm.getTheFile();
 
       if (myFile.getContentType().equals("application/vnd.ms-excel"))
       {
         Vector data_xls = new Vector();
 
         data_xls = conBean.lecturaExcel(myFile);
 
         if (data_xls == null)
         {
           conForm.setMensaje(conBean.getMens_error());
         }
         else if (data_xls.size() > 100)
         {
           conForm.setMensaje("ERROR: El máximo de productos para actualizar son 100 registros.\nFavor editar el archivo y cargarlo nuevamente.");
         }
         else
         {
           conForm.setHayDatos("si");
           conForm.setPreview(data_xls);
           conForm.setTotal_registros(data_xls.size());
           conBean.SqlBorradoDePromociones(getDataSource(request, "Db2"), data_xls);
 
           conForm.setSql_delete(conBean.getVectDelete());
         }
 
       }
       else if (myFile.getContentType().equals("application/octet-stream")) {
         conForm.setMensaje("ERROR: Debe cerrar archivo que desea cargar");
       } else {
         conForm.setMensaje("ERROR: Archivo debe ser formato EXCEL (.xls)");
       }
 
       conForm.setHayDatos("no");
       conForm.setAccion("");
       conForm.setActualiza("no");
 
       return mapping.findForward("iniciar");
     }
 
     if (conForm.getAccion().equals("actualizar")) {
       int res = 0;
       conBean.setVectDelete(conForm.getSql_delete());
       res = conBean.actualizarStock(getDataSource(request, "Db2"));
       conForm.setActualiza("OK");
 
       if (res >= 0)
       {
         conForm.setMensaje("Stock Actualizado.");
       }
       else conForm.setMensaje(conBean.getMens_error());
 
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
 * Qualified Name:     cl.ripley.GestionTV.struts.action.ActualizaStockAction
 * JD-Core Version:    0.6.2
 */