 package cl.ripley.GestionTV.struts.bean;
 
 import cl.ripley.GestionTV.comun.ConectaBD;
 import cl.ripley.GestionTV.comun.DownFile;
 import cl.ripley.GestionTV.comun.Util;

import java.sql.SQLException;
 import java.util.Map;
 import java.util.Vector;
 import javax.sql.DataSource;
 import org.apache.log4j.Logger;
import org.apache.struts.util.MessageResources;
 
 public class ReporteStockExcelBean extends ConectaBD
 {
   static Logger log = Logger.getRootLogger();
 
   protected static MessageResources messages = MessageResources.getMessageResources("cl.ripley.GestionTV.struts.msgGestionTV");
   private String accion;
   private Vector vctDetalles = new Vector();
   private Vector vctExportar = new Vector();
   private Vector vctExpHead = new Vector();
 
   private String flagDatosBD = "si";
   private String hayDatos = "no";
   private String mensaje = "";
   private long monto_activacion = 500000L;
   private long monto_anulacion = 500000L;
   private String voucher = "";
   private String voucherHTML = "";
   private String link_voucherHTML = "";
 
   public Vector getVectorExportar(DataSource dataSource, String strAra, String strAra2)
   {
     Vector vRes = new Vector();
     String temporal = "";
     String statement = 
       (String)Util.getMap().get("gestion_65.inst01");
     if (conecta(dataSource)) {
       vRes = consulta(dataSource, statement, 9);
 
       cierraRst();
     }
     if (vRes.size() != 0)
     {
       setHayDatos("si");
     }
     else setHayDatos("no");
 
     return vRes;
   }
 
   public String enviarArchivo()
   {
     DownFile objDown = new DownFile();
     String exportFile = 
       objDown.enviarArchivo(this.vctExpHead, this.vctDetalles);
 
     setMensaje(DownFile.getMensaje());
     return exportFile;
   }
   
   public int procedure(DataSource dataSource, Vector detalles){	   
	   String statement = (String)Util.getMap().get("gestion_04.inst03");	   	   
	   int cantidad = 0;
	   if (conecta(dataSource)) {
	       try {
	    	   	    	   
	    	   for(int i = 0; i < detalles.size();i++){
	    		   Vector vec = (Vector)detalles.get(i);	
	    		   Vector vParam = new Vector();
	    		   
	    		   vParam.add("Int,"+(String)vec.get(0));
		    	   vParam.add("Int,"+(String)vec.get(1));
		    	   vParam.add("String,"+(String)vec.get(2));		    	   
	    		  
		    	   cantidad = procedure(dataSource,statement,vParam);		    	   		    	  
	    	   }
	    	   
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	       
	       cierraRst();
	    }	
	   
	   return cantidad;
   }
   
   public Vector consultaParams(DataSource dataSource, String itemspcId) { 
	   
	   String statement = (String)Util.getMap().get("gestion_04.inst04");
	   Vector vctDet = new Vector();
	   if (conecta(dataSource)) {
	     vctDet = consultaParams(dataSource, statement, 3, itemspcId);
	     //setVctDetalles(vctDet);
	     cierraRst();
	   }	   	   
	   return vctDet;
   }
   
   public Vector consultaPrecios(DataSource dataSource, Vector condicion) { 
	   
	   String statement = (String)Util.getMap().get("gestion_65.inst04");
	   Vector vctDet = new Vector();
	   if (conecta(dataSource)) {
	     vctDet = consulta(dataSource, statement, condicion, 1);
	     //setVctDetalles(vctDet);
	     cierraRst();
	   }	   	   
	   return vctDet;
   }
 
   public String getHayDatos()
   {
     return this.hayDatos;
   }
 
   public void setHayDatos(String string)
   {
     this.hayDatos = string;
   }
 
   public static MessageResources getMessages()
   {
     return messages;
   }
 
   public String getMensaje()
   {
     return this.mensaje;
   }
 
   public void setMensaje(String string)
   {
     this.mensaje = string;
   }
 
   public Vector getVctDetalles() {
     return this.vctDetalles;
   }
 
   public void setVctDetalles(Vector vctDetalles) {
     this.vctDetalles = vctDetalles;
   }
 
   public Vector getVctExpHead() {
     return this.vctExpHead;
   }
 
   public void setVctExpHead(Vector vctExpHead) {
     this.vctExpHead = vctExpHead;
   }
 
   public Vector getVctExportar() {
     return this.vctExportar;
   }
 
   public void setVctExportar(Vector vctExportar) {
     this.vctExportar = vctExportar;
   }
 }

/* Location:           C:\sitios\GestionTV_Ripley\trunk\docs\01 Requerimiento\Fuentes Gestión TV\GestionTV-WC7\WEB-INF\classes\
 * Qualified Name:     cl.ripley.GestionTV.struts.bean.ReporteStockExcelBean
 * JD-Core Version:    0.6.2
 */