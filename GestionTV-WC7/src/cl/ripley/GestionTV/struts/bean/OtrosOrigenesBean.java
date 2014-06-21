 package cl.ripley.GestionTV.struts.bean;
 
 import cl.ripley.GestionTV.comun.ConectaBD;
 import cl.ripley.GestionTV.comun.Util;
 import java.util.Map;
 import java.util.Vector;
 import javax.sql.DataSource;
 import org.apache.log4j.Logger;
 import org.apache.struts.util.MessageResources;
 
 public class OtrosOrigenesBean extends ConectaBD
 {
   static Logger log = Logger.getRootLogger();
   protected static MessageResources messages = MessageResources.getMessageResources("cl.ripley.GestionTV.struts.msgGestionTV");
   private String accion;
   private Vector vctDetalles;
   private String hayDatos = "no";
   private String mensaje;
   private Vector vctExportar = new Vector();
   private Vector vctExpHead = new Vector();
   private String hayDatosExportar;
   private String fec_inicio = "";
   private String fec_final = "";
   private String accesoRangos;
 
   public void consulta(DataSource dataSource)
   {
     Vector vRes = new Vector();
     String statement = (String)Util.getMap().get("gestion_10.inst02");
     if (conecta(dataSource)) {
       Vector vWhere = new Vector();
       vWhere.add("Date," + getFec_inicio().substring(6, 10) + "-" + getFec_inicio().substring(3, 5) + "-" + getFec_inicio().substring(0, 2));
       vWhere.add("Date," + getFec_final().substring(6, 10) + "-" + getFec_final().substring(3, 5) + "-" + getFec_final().substring(0, 2));
 
       vRes = consulta(dataSource, statement, vWhere, 21);
     }
 
     if (vRes.size() != 0) {
       setHayDatos("si");
     }
     else
     {
       setHayDatos("no");
     }
 
     setVctDetalles(vRes);
   }
 
   public String getHayDatos()
   {
     return this.hayDatos;
   }
 
   public void setHayDatos(String string)
   {
     this.hayDatos = string;
   }
 
   public Vector getVctDetalles()
   {
     return this.vctDetalles;
   }
 
   public void setVctDetalles(Vector vector)
   {
     this.vctDetalles = vector;
   }
 
   public String getMensaje()
   {
     return this.mensaje;
   }
 
   public void setMensaje(String string)
   {
     this.mensaje = string;
   }
 
   public String getFec_inicio()
   {
     return this.fec_inicio;
   }
 
   public void setFec_inicio(String string)
   {
     this.fec_inicio = string;
   }
 
   public Vector getVctExpHead()
   {
     return this.vctExpHead;
   }
 
   public Vector getVctExportar()
   {
     return this.vctExportar;
   }
 
   public void setVctExpHead(Vector vector)
   {
     this.vctExpHead = vector;
   }
 
   public void setVctExportar(Vector vector)
   {
     this.vctExportar = vector;
   }
 
   public String getFec_final()
   {
     return this.fec_final;
   }
 
   public void setFec_final(String string)
   {
     this.fec_final = string;
   }
 
   public String getAccesoRangos()
   {
     return this.accesoRangos;
   }
 
   public void setAccesoRangos(String string)
   {
     this.accesoRangos = string;
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
 * Qualified Name:     cl.ripley.GestionTV.struts.bean.OtrosOrigenesBean
 * JD-Core Version:    0.6.2
 */