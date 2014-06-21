 package cl.ripley.GestionTV.struts.action;
 
 import java.util.Vector;

import cl.ripley.GestionTV.comun.Util;
 import cl.ripley.GestionTV.struts.bean.TodosProductosBean;
 import cl.ripley.GestionTV.struts.form.TodosProductosForm;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import javax.servlet.http.HttpSession;
 import org.apache.struts.action.Action;
 import org.apache.struts.action.ActionForm;
 import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
 
 public class TodosProductosAction extends Action
 {
   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
     throws Exception
   {
     String Conectado = (String)request.getSession().getAttribute("Conectado");
     if (Conectado == null) {
       return mapping.findForward("timeOut");
     }
 
     TodosProductosForm objetoForm = (TodosProductosForm)form;
     TodosProductosBean objetoBean = new TodosProductosBean();
 
     if (objetoForm.getAccion().equals("InicioTodosProductos")) {
    	     	 
    	 objetoBean.consulta(getDataSource(request, "Db2"));
    	       
    	 Vector vecFinal = new Vector();
    	 for(int i = 0;i < objetoBean.getVctDetalles().size();i++){
    		 Vector vec = (Vector)objetoBean.getVctDetalles().get(i);
    		 String item = (String) vec.get(0);
    		 if(item != null){
    			 Vector paramSP = new Vector();    	   
        		 paramSP = objetoBean.consultaParams(getDataSource(request, "Db2"),item);
        		 int cantidad = objetoBean.procedure(getDataSource(request, "Db2"),paramSP);
        		 String cant = String.valueOf(cantidad);   
        		 String partNumber = (String)vec.get(1);
        		 Vector campos = new Vector();
        		 campos.add(partNumber);
        		 campos.add(cant);
        		 vecFinal.add(campos);
    		 }    		 
    	 }
	 //objetoForm.setVctDetalles(objetoBean.getVctDetalles());
	 objetoForm.setVctDetalles(vecFinal);
	 objetoForm.setHayDatos(objetoBean.getHayDatos());
	 objetoForm.setMensaje("");
	 return mapping.findForward("todosproductos");
     }
     if (objetoForm.getAccion().equals("excel")) {
       objetoBean.setVctExpHead(Util.stringToVector(objetoForm.getVctExpHead()));     
       
       objetoBean.consulta(getDataSource(request, "Db2"));
       Vector vecFinal = new Vector();
       for(int i = 0;i < objetoBean.getVctDetalles().size();i++){
    	   Vector vec = (Vector)objetoBean.getVctDetalles().get(i);
    	   String item = (String) vec.get(0);
    	   if(item != null){
    		   Vector paramSP = new Vector();    	   
    		   paramSP = objetoBean.consultaParams(getDataSource(request, "Db2"),item);
    		   int cantidad = objetoBean.procedure(getDataSource(request, "Db2"),paramSP);
    		   String cant = String.valueOf(cantidad);   
    		   String partNumber = (String)vec.get(1);
    		   Vector campos = new Vector();
    		   campos.add(partNumber);
    		   campos.add(cant);
    		   vecFinal.add(campos);
    	   }    		 
       }
       objetoBean.setVctDetalles(vecFinal);
       /*
       objetoBean.setVctDetalles(
         objetoBean.getVectorExportar(
         getDataSource(request, "Db2"), 
         objetoForm.getNumProd(), 
         objetoForm.getCantidad()));
       */
       objetoForm.setExportFile(objetoBean.enviarArchivo());
       objetoForm.setHayDatos(objetoBean.getHayDatos());
       objetoForm.setMensaje(objetoBean.getMensaje());
       return mapping.findForward("todosproductos");
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
 * Qualified Name:     cl.ripley.GestionTV.struts.action.TodosProductosAction
 * JD-Core Version:    0.6.2
 */