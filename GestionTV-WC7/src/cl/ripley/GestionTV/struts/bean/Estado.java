 package cl.ripley.GestionTV.struts.bean;
 
 import cl.ripley.GestionTV.comun.ConectaBD;
 import cl.ripley.GestionTV.comun.Util;
 import java.util.Collection;
 import java.util.Map;
 import java.util.Vector;
 import javax.sql.DataSource;
 import org.apache.struts.util.LabelValueBean;
 import org.apache.struts.util.MessageResources;
 
 public class Estado extends ConectaBD
 {
   protected static MessageResources messages = MessageResources.getMessageResources("cl.ripley.GestionTV.struts.msgGestionTV");
   private String primerCodEstado;
   private String primerNomEstado;
 
   public Collection getCollEstado(DataSource dataSource)
   {
     Vector vector = new Vector();
     Vector vWhere = new Vector();
     Vector v = new Vector();
     String statement = (String)Util.getMap().get("gestion_11.inst01");
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
         this.primerCodEstado = cod;
         this.primerNomEstado = nom;
       }
 
     }
 
     if (n == 0) {
       respuesta.add(new LabelValueBean("SIN ESTADO", "-1"));
       this.primerCodEstado = "-1";
       this.primerNomEstado = "SIN ESTADO";
     }
 
     cierraRst();
 
     beanCollection = respuesta;
     return beanCollection;
   }
 
   public Collection getCollEstadoAlgunos(DataSource dataSource)
   {
     Vector vector = new Vector();
     Vector vWhere = new Vector();
     Vector v = new Vector();
     String statement = (String)Util.getMap().get("gestion_16.inst04");
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
         this.primerCodEstado = cod;
         this.primerNomEstado = nom;
       }
 
     }
 
     if (n == 0) {
       respuesta.add(new LabelValueBean("SIN ESTADO", "-1"));
       this.primerCodEstado = "-1";
       this.primerNomEstado = "SIN ESTADO";
     }
 
     cierraRst();
 
     beanCollection = respuesta;
     return beanCollection;
   }
 
   public Collection inicializaEstado()
   {
     Vector respuesta = new Vector();
     respuesta.add(new LabelValueBean("SIN ESTADO", "-1"));
     this.primerCodEstado = "-1";
     this.primerNomEstado = "SIN ESTADO";
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
 
   public String getPrimerCodEstado()
   {
     return this.primerCodEstado;
   }
 
   public void setPrimerCodEstado(String primerCodEstado)
   {
     this.primerCodEstado = primerCodEstado;
   }
 
   public String getPrimerNomEstado()
   {
     return this.primerNomEstado;
   }
 
   public void setPrimerNomEstado(String primerNomEstado)
   {
     this.primerNomEstado = primerNomEstado;
   }
 }

/* Location:           C:\sitios\GestionTV_Ripley\trunk\docs\01 Requerimiento\Fuentes Gestión TV\GestionTV-WC7\WEB-INF\classes\
 * Qualified Name:     cl.ripley.GestionTV.struts.bean.Estado
 * JD-Core Version:    0.6.2
 */