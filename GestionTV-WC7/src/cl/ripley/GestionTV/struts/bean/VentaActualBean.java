package cl.ripley.GestionTV.struts.bean;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import cl.ripley.GestionTV.comun.ConectaBD;
import cl.ripley.GestionTV.comun.Util;

public class VentaActualBean extends ConectaBD{
	 static Logger log = Logger.getRootLogger();
	 private SimpleDateFormat formateadorFecha = new SimpleDateFormat("yyyy-MM-dd");
     private DecimalFormat formateadorNumero = new DecimalFormat("###,###.##");
	 
	 public String getVentaActual(DataSource dataSource){
		 Vector vRes = new Vector();
		 String vInstruccion = "";
		 Vector vWhere = new Vector();
		 String valorActual = "";
		 
		 //Recuperando la fecha actual
		 Date currentTime = new Date();
		 String fechaActual = formateadorFecha.format(currentTime);
		 
		 if (conecta(dataSource)){
	       try{
	         vInstruccion = (String)Util.getMap().get("gestion_82.inst01");
	         
	         vWhere.add("String,"+ fechaActual);
	         vWhere.add("String,"+ fechaActual);
	         vRes = consulta(dataSource, vInstruccion, vWhere, 1);
	         if (vRes.size() != 0) {
	        	 Vector b = (Vector)vRes.elementAt(0);
	             valorActual = (String)b.get(0);
	         }
	       }
	       catch (Exception e) {
	    	 e.printStackTrace();
	         log.error("::Exception, Venta actual" + e.getMessage());
	       }
	       finally {
	         cierraRst();
	       }
	     }
		 //Formateando el valor con separador de miles
		 String ventaFormateada = "";
	     try{
	     	ventaFormateada = formateadorNumero.format (Long.parseLong(valorActual));
	     } catch (Exception e) {
	     	log.error("ERROR: FormatPrecio Venta Actual, "
					+ e.getLocalizedMessage());
	   		return "0";
	   	 }
	     log.debug("ventaFormateada: " + ventaFormateada);
		 return ventaFormateada;
	 }
}
