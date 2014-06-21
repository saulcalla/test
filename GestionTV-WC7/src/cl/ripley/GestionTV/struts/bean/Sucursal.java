 package cl.ripley.GestionTV.struts.bean;
 
 import cl.ripley.GestionTV.comun.ConectaBD;
 import cl.ripley.GestionTV.comun.Util;
 import java.util.Collection;
 import java.util.Map;
 import java.util.Vector;
 import javax.sql.DataSource;
 import org.apache.struts.util.LabelValueBean;
 import org.apache.struts.util.MessageResources;
 
 public class Sucursal extends ConectaBD
 {
   protected static MessageResources messages = MessageResources.getMessageResources("cl.ripley.GestionTV.struts.msgGestionTV");
   private String primerCodSucursal;
   private String primerNomSucursal;
 
   public Collection getCollSucursal(DataSource dataSource, String query)
   {
     Vector vector = new Vector();
     Vector vWhere = new Vector();
     Vector v = new Vector();
     String statement = (String)Util.getMap().get(query);
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
     }
 
     respuesta.add(new LabelValueBean("Todas", "0"));
 
     if (n == 0) {
       respuesta.add(new LabelValueBean("SIN SUCURSAL", "-1"));
       this.primerCodSucursal = "-1";
       this.primerNomSucursal = "SIN SUCURSAL";
     }
     else
     {
       this.primerCodSucursal = "0";
       this.primerNomSucursal = "Todas";
     }
     cierraRst();
 
     beanCollection = respuesta;
     return beanCollection;
   }
 
   public static MessageResources getMessages()
   {
     return messages;
   }
 
   public static void setMessages(MessageResources messages)
   {
     messages = messages;
   }
 
   public String getPrimerCodSucursal()
   {
     return this.primerCodSucursal;
   }
 
   public void setPrimerCodSucursal(String primerCodSucursal)
   {
     this.primerCodSucursal = primerCodSucursal;
   }
 
   public String getPrimerNomSucursal()
   {
     return this.primerNomSucursal;
   }
 
   public void setPrimerNomSucursal(String primerNomSucursal)
   {
     this.primerNomSucursal = primerNomSucursal;
   }
 }

/* Location:           C:\sitios\GestionTV_Ripley\trunk\docs\01 Requerimiento\Fuentes Gestión TV\GestionTV-WC7\WEB-INF\classes\
 * Qualified Name:     cl.ripley.GestionTV.struts.bean.Sucursal
 * JD-Core Version:    0.6.2
 */