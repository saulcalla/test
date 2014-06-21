 package cl.ripley.GestionTV.struts.action;
 
 import cl.ripley.GestionTV.comun.Util;
 import cl.ripley.GestionTV.struts.bean.ProductosRChannelBean;
 import cl.ripley.GestionTV.struts.form.ProductosRChannelForm;
 import cl.ripley.framework.util.PdfFile;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import org.apache.struts.action.Action;
 import org.apache.struts.action.ActionForm;
 import org.apache.struts.action.ActionForward;
 import org.apache.struts.action.ActionMapping;
 
 public class GenerarPDFAction extends Action
 {
   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
     throws Exception
   {
     response.setHeader("Cache-Control", "no-cache");
     response.setHeader("Pragma", "no-cache");
     response.setDateHeader("Expires", 0L);
 
     ProductosRChannelForm conForm = (ProductosRChannelForm)form;
     ProductosRChannelBean conBean = new ProductosRChannelBean();
 
     conBean.setFec_inicio(conForm.getFec_inicio());
     conBean.setVctExpHead(Util.stringToVector(conForm.getVctExpHead()));
     conBean.setVctDetalles(conBean.getVectorExportar(getDataSource(request, "Db2")));
 
     PdfFile pdf = new PdfFile();
     pdf.GenerarPDF(request, response, conBean.getVctDetalles(), conBean.getFec_inicio());
     return null;
   }
 }

/* Location:           C:\sitios\GestionTV_Ripley\trunk\docs\01 Requerimiento\Fuentes Gestión TV\GestionTV-WC7\WEB-INF\classes\
 * Qualified Name:     cl.ripley.GestionTV.struts.action.GenerarPDFAction
 * JD-Core Version:    0.6.2
 */