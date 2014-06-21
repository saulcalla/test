 package cl.ripley.GestionTV.struts.action;
 
 import java.util.Vector;

import cl.ripley.GestionTV.comun.Util;
 import cl.ripley.GestionTV.struts.bean.ReporteStockExcelBean;
 import cl.ripley.GestionTV.struts.form.ReporteStockExcelForm;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import javax.servlet.http.HttpSession;
 import org.apache.struts.action.Action;
 import org.apache.struts.action.ActionForm;
 import org.apache.struts.action.ActionForward;
 import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.MessageResources;
 
 public class ReporteStockExcelAction extends Action
 {
   protected static MessageResources messages = MessageResources.getMessageResources("cl.ripley.GestionTV.struts.msgGestionTV");
 
   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
     throws Exception
   {
     String Conectado = (String)request.getSession().getAttribute(
       "Conectado");
 
     if (Conectado == null) {
       return mapping.findForward("timeOut");
     }
 
     ReporteStockExcelForm conForm = (ReporteStockExcelForm)form;
     ReporteStockExcelBean conBean = new ReporteStockExcelBean();
 
     if (conForm.getAccion().equals("InicioReporteStockExcel"))
     {
       conForm.setHayDatos("no");
       conForm.setFlagDatosBD("si");
       conForm.setTemp("no");
 
       conForm.setMensaje("");
       return mapping.findForward("iniciar");
     }
 
     if (conForm.getAccion().equals("excel")) {
       conBean.setVctExpHead(Util.stringToVector(conForm.getVctExpHead()));
       
       Vector vecFinal = new Vector();
       Vector datos = new Vector();
       datos = conBean.getVectorExportar(getDataSource(request, "Db2"), "", "");
       
       for(int i = 0;i < datos.size();i++){
    	   Vector vec = (Vector)datos.get(i);
    	   String item = (String) vec.get(0);
    	   //String catentry = (String) vec.get(1);
    	   //String offer = (String) vec.get(2);
    	   if(item != null){
    		   Vector paramSP = new Vector();
    		   paramSP = conBean.consultaParams(getDataSource(request, "Db2"),item);
    		   int cantidad = conBean.procedure(getDataSource(request, "Db2"),paramSP);
    		   String cant = String.valueOf(cantidad);  //INTEGER(i.quantity) as Stk, 
    		   
    		   Vector campos = new Vector();
    		   for(int x = 2;x < vec.size();x++){
    			   if(x == 3){
    				   campos.add(cant); 
    			   } 
    			   campos.add(vec.get(x));
    		   }
    		   vecFinal.add(campos);    		   
    	   }
       }
       conBean.setVctDetalles(vecFinal);
       /*
       conBean.setVctDetalles(
       conBean.getVectorExportar(getDataSource(request, "Db2"), "", ""));
 	   */
       conForm.setExportFile(conBean.enviarArchivo());
       conForm.setHayDatos(conBean.getHayDatos());
       if("no".equalsIgnoreCase(conBean.getHayDatos())){
    	   conForm.setFlagDatosBD("no");
       }
       conForm.setMensaje(conBean.getMensaje());
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
 * Qualified Name:     cl.ripley.GestionTV.struts.action.ReporteStockExcelAction
 * JD-Core Version:    0.6.2
 */