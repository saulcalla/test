 package cl.ripley.GestionTV.struts.action;
 
 import cl.ripley.GestionTV.comun.ConfigManager;
import cl.ripley.GestionTV.comun.Log;
import cl.ripley.GestionTV.struts.bean.CargaVentasWCBean;
 import cl.ripley.GestionTV.struts.form.CargaVentasWCForm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.net.URLConnection;
 import java.util.Vector;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import javax.servlet.http.HttpSession;
 import org.apache.struts.action.Action;
 import org.apache.struts.action.ActionForm;
 import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
 
 public class CargaVentasWCAction extends Action
 {
   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
     throws Exception
   {
     String Conectado = (String)request.getSession().getAttribute("Conectado");
     if (Conectado == null) {
       return mapping.findForward("timeOut");
     }
 
     CargaVentasWCForm conForm = (CargaVentasWCForm)form;
     CargaVentasWCBean conBean = new CargaVentasWCBean();
 
     if (conForm.getAccion().equals("InicioCargaVentasWC")) {
       conForm.setVctDetalles(null);
       conForm.setHayDatos("no");
       conForm.setHayDatosExportar("no");
       conForm.setFlagDatosBD("si");
       conForm.setNumOrden("");
 
       conForm.setIndice(0);
       conForm.setRegistrosPorBloque(10);
       conForm.setNroBloque(1);
       conForm.setMensaje("");
 
       return mapping.findForward("iniciar");
     }
 
     if (conForm.getAccion().equals("buscar"))
     {
    	 String host = ConfigManager.getProperty("url.host");
    	 String langId = ConfigManager.getProperty("url.langid");
    	 String storeId = ConfigManager.getProperty("url.storeid");
    	 String catalogId = ConfigManager.getProperty("url.catalogid");
    	 String orderId = conForm.getNumOrden().trim();
    	 
    	 StringBuffer resultado = new StringBuffer("");
    	 
    	 String url = "http://"+host+"/webapp/wcs/stores/servlet/ExportarModeloExtendido?" +
    	 		"langId="+langId+
    	 		"&storeId="+storeId+
    	 		"&catalogId="+catalogId+
    	 		"&orderId="+orderId;
    	 try{
    		 URL miURL = new URL(url);
    		 URLConnection con = miURL.openConnection();
    		 
    		 BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
    		     		
    	     String linea;
    	     while ((linea = in.readLine()) != null) {
    	    	 System.out.println(linea);
    	    	 Log.write(linea);
    	    	 resultado.append(linea);
    	     }  
    	 }catch(MalformedURLException ex){
    		 ex.printStackTrace();
    	 }catch(IOException ex){
    		 ex.printStackTrace();
    	 }
    	 
    	 conForm.setMensaje(resultado.toString());
       /* 
       String resp = "";
       conForm.setMensaje("");
       String sql_insert = "";
       resp = conBean.iniciaCarga(getDataSource(request, "Db2"), conForm.getNumOrden().trim());
 
       if (resp == null)
         conForm.setMensaje(conBean.getMens_error());
       else {
         conForm.setMensaje("Venta Cargada Exitosamente.");
       }
 
       conForm.setHayDatos(conBean.getHayDatos());
       conForm.setHayProximoBloque(conBean.getHayProximoBloque());
       conForm.setNroBloque(conBean.getNroBloque());
       conForm.setContador(conBean.getContador());
 
       conForm.setListaPagina(conBean.getListaPagina());
       conForm.setHayDatosExportar("no");
 	   */
       return mapping.findForward("iniciar");
     }
     if (conForm.getAccion().equals("excel"))
     {
       conBean.setTotalReg(conForm.getTotalRegistros());
 
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
 * Qualified Name:     cl.ripley.GestionTV.struts.action.CargaVentasWCAction
 * JD-Core Version:    0.6.2
 */