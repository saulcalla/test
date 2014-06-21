 package cl.ripley.GestionTV.struts.bean;
 
 import cl.ripley.GestionTV.comun.ConectaBD;
 import cl.ripley.GestionTV.comun.Util;
 import java.util.Collection;
 import java.util.Map;
 import java.util.Vector;
 import javax.sql.DataSource;
 import org.apache.struts.util.LabelValueBean;
 import org.apache.struts.util.MessageResources;
 
 public class Ejecutivo extends ConectaBD
 {
   protected static MessageResources messages = MessageResources.getMessageResources("cl.ripley.GestionTV.struts.msgGestionTV");
   private String primerCodEjecutivo;
   private String primerNomEjecutivo;
 
   public Collection getCollEjecutivo(DataSource dataSource)
   {
     Vector vector = new Vector();
     Vector vWhere = new Vector();
     Vector v = new Vector();
     String statement = (String)Util.getMap().get("gestion_14.inst03");
     String cod = "";
     String nom = "";
     Collection beanCollection = null;
     Vector respuesta = new Vector();
 
     vector = consulta(dataSource, statement, 2);
     int n = vector.size();
     for (int i = 0; i < n; i++) {
       v = (Vector)vector.elementAt(i);
       cod = (String)v.elementAt(0);
       nom = (String)v.elementAt(1);
 
       respuesta.add(new LabelValueBean(nom, cod));
 
       if (i == 0) {
         this.primerCodEjecutivo = cod;
         this.primerNomEjecutivo = nom;
       }
 
     }
 
     if (n == 0) {
       respuesta.add(new LabelValueBean("SIN EJECUTIVO", "-1"));
       this.primerCodEjecutivo = "-1";
       this.primerNomEjecutivo = "SIN EJECUTIVO";
     } else {
       respuesta.add(new LabelValueBean("TODOS", "0"));
       this.primerCodEjecutivo = "0";
       this.primerNomEjecutivo = "TODOS";
     }
 
     cierraRst();
 
     beanCollection = respuesta;
     return beanCollection;
   }
 
   public Collection inicializaEjecutivo()
   {
     Vector respuesta = new Vector();
     respuesta.add(new LabelValueBean("SIN EJECUTIVO", "-1"));
     this.primerCodEjecutivo = "-1";
     this.primerNomEjecutivo = "SIN EJECUTIVO";
     return respuesta;
   }
 
   public static MessageResources getMessages()
   {
     return messages;
   }
 
   public static void setMessages(MessageResources messages)
   {
     messages = messages;
   }
 
   public String getPrimerCodEjecutivo()
   {
     return this.primerCodEjecutivo;
   }
 
   public void setPrimerCodEjecutivo(String primerCodEjecutivo)
   {
     this.primerCodEjecutivo = primerCodEjecutivo;
   }
 
   public String getPrimerNomEjecutivo()
   {
     return this.primerNomEjecutivo;
   }
 
   public void setPrimerNomEjecutivo(String primerNomEjecutivo)
   {
     this.primerNomEjecutivo = primerNomEjecutivo;
   }
 }

/* Location:           C:\sitios\GestionTV_Ripley\trunk\docs\01 Requerimiento\Fuentes Gestión TV\GestionTV-WC7\WEB-INF\classes\
 * Qualified Name:     cl.ripley.GestionTV.struts.bean.Ejecutivo
 * JD-Core Version:    0.6.2
 */