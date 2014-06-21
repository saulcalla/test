 package cl.ripley.GestionTV.struts.action;
 
 import cl.ripley.GestionTV.comun.Util;
 import cl.ripley.GestionTV.struts.bean.ProductoSinStockBean;
 import cl.ripley.GestionTV.struts.form.ProductoSinStockForm;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import javax.servlet.http.HttpSession;
 import org.apache.struts.action.Action;
 import org.apache.struts.action.ActionForm;
 import org.apache.struts.action.ActionForward;
 import org.apache.struts.action.ActionMapping;
 
 public class ProductoSinStockAction extends Action
 {
   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
     throws Exception
   {
     String Conectado = (String)request.getSession().getAttribute("Conectado");
     if (Conectado == null) {
       return mapping.findForward("timeOut");
     }
 
     ProductoSinStockForm objetoForm = (ProductoSinStockForm)form;
     ProductoSinStockBean objetoBean = new ProductoSinStockBean();
     if (objetoForm.getAccion().equals("InicioProductoSinStock")) {
       objetoBean.consulta(getDataSource(request, "Db2"));
       objetoForm.setVctDetalles(objetoBean.getVctDetalles());
       objetoForm.setHayDatos(objetoBean.getHayDatos());
       objetoForm.setMensaje("");
       return mapping.findForward("productosinstock");
     }
     if (objetoForm.getAccion().equals("excel"))
     {
       objetoBean.setVctExpHead(Util.stringToVector(objetoForm.getVctExpHead()));
       objetoBean.setVctDetalles(
         objetoBean.getVectorExportar(
         getDataSource(request, "Db2"), 
         objetoForm.getNumProd(), 
         objetoForm.getCantidad()));
       objetoForm.setExportFile(objetoBean.enviarArchivo());
       objetoForm.setHayDatos(objetoBean.getHayDatos());
       objetoForm.setMensaje(objetoBean.getMensaje());
       return mapping.findForward("productosinstock");
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
 * Qualified Name:     cl.ripley.GestionTV.struts.action.ProductoSinStockAction
 * JD-Core Version:    0.6.2
 */