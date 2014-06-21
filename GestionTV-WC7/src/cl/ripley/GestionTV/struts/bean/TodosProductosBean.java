 package cl.ripley.GestionTV.struts.bean;
 
 import cl.ripley.GestionTV.comun.ConectaBD;
 import cl.ripley.GestionTV.comun.DownFile;
 import cl.ripley.GestionTV.comun.Util;

import java.sql.SQLException;
 import java.util.Map;
 import java.util.Vector;
 import javax.sql.DataSource;
import org.apache.struts.util.MessageResources;
 
 public class TodosProductosBean extends ConectaBD
 {
   protected static MessageResources messages = MessageResources.getMessageResources("cl.ripley.GestionTV.struts.msgGestionTV");
   private Vector vctDetalles = new Vector();
   private Vector vctExportar = new Vector();
   private Vector vctExpHead = new Vector();
   private String mensaje = "";
   private String hayDatos = "no";
   private String hayDatosExportar = "no";
   
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
 
   public void consulta(DataSource dataSource) { String statement = (String)Util.getMap().get("gestion_04.inst02");
     Vector vctDet = new Vector();
     if (conecta(dataSource)) {
       vctDet = consulta(dataSource, statement, 2);
       setVctDetalles(vctDet);
       cierraRst();
     }
     if (getVctDetalles().size() != 0)
     {
       setHayDatos("si");
     }
     else setHayDatos("no");
   }
 
   public Vector getVctDetalles()
   {
     return this.vctDetalles;
   }
 
   public void setVctDetalles(Vector vector)
   {
     this.vctDetalles = vector;
   }
 
   public Vector getVectorExportar(DataSource dataSource, String strAra, String strAra2)
   {
     Vector vRes = new Vector();
     String statement = 
       (String)Util.getMap().get("gestion_04.inst02");
     if (conecta(dataSource)) {
       Vector vWhere = new Vector();
       vRes = consulta(dataSource, statement, 2);
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
 
   public static MessageResources getMessages()
   {
     return messages;
   }
 
   public String getMensaje()
   {
     return this.mensaje;
   }
 
   public Vector getVctExpHead()
   {
     return this.vctExpHead;
   }
 
   public Vector getVctExportar()
   {
     return this.vctExportar;
   }
 
   public static void setMessages(MessageResources resources)
   {
     messages = resources;
   }
 
   public void setMensaje(String string)
   {
     this.mensaje = string;
   }
 
   public void setVctExpHead(Vector vector)
   {
     this.vctExpHead = vector;
   }
 
   public void setVctExportar(Vector vector)
   {
     this.vctExportar = vector;
   }
 
   public String getHayDatos()
   {
     return this.hayDatos;
   }
 
   public void setHayDatos(String string)
   {
     this.hayDatos = string;
   }
 
   public String getHayDatosExportar()
   {
     return this.hayDatosExportar;
   }
 
   public void setHayDatosExportar(String string)
   {
     this.hayDatosExportar = string;
   }
 }

/* Location:           C:\sitios\GestionTV_Ripley\trunk\docs\01 Requerimiento\Fuentes Gestión TV\GestionTV-WC7\WEB-INF\classes\
 * Qualified Name:     cl.ripley.GestionTV.struts.bean.TodosProductosBean
 * JD-Core Version:    0.6.2
 */