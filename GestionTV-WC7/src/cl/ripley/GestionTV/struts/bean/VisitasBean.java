 package cl.ripley.GestionTV.struts.bean;
 
 import cl.ripley.GestionTV.comun.ConectaBD;
 import cl.ripley.GestionTV.comun.DownFile;
 import cl.ripley.GestionTV.comun.Util;
 import java.util.Map;
 import java.util.Vector;
 import javax.sql.DataSource;
 import org.apache.struts.util.MessageResources;
 
 public class VisitasBean extends ConectaBD
 {
   private Vector vctDetalles;
   protected static MessageResources messages = MessageResources.getMessageResources("cl.ripley.GestionTV.struts.msgGestionTV");
   private String fec_inicio;
   private String fec_fin;
   private String flagDatosBD = "si";
   private String hayDatos = "no";
   private String hayDatosExportar = "no";
   private Vector vctExportar = new Vector();
   private Vector vctExpHead = new Vector();
   private String mensaje = "";
 
   public void consulta(DataSource dataSource)
   {
     String statement = (String)Util.getMap().get("gestion_01.inst04");
     if (conecta(dataSource)) {
       Vector vWhere = new Vector();
 
       vWhere.add("Date," + getFec_inicio().substring(6, 10) + "-" + getFec_inicio().substring(3, 5) + "-" + getFec_inicio().substring(0, 2));
       vWhere.add("Date," + getFec_fin().substring(6, 10) + "-" + getFec_fin().substring(3, 5) + "-" + getFec_fin().substring(0, 2));
       Vector vctDet = consulta(dataSource, statement, vWhere, 3);
       if (vctDet.size() != 0)
         setHayDatos("si");
       else {
         setHayDatos("no");
       }
       setVctDetalles(vctDet);
       cierraRst();
     }
   }
 
   public Vector getVctDetalles()
   {
     return this.vctDetalles;
   }
 
   public void setVctDetalles(Vector vector)
   {
     this.vctDetalles = vector;
   }
 
   public static MessageResources getMessages()
   {
     return messages;
   }
 
   public String getFec_fin()
   {
     return this.fec_fin;
   }
 
   public String getFec_inicio()
   {
     return this.fec_inicio;
   }
 
   public static void setMessages(MessageResources resources)
   {
     messages = resources;
   }
 
   public void setFec_fin(String string)
   {
     this.fec_fin = string;
   }
 
   public void setFec_inicio(String string)
   {
     this.fec_inicio = string;
   }
 
   public String getFlagDatosBD()
   {
     return this.flagDatosBD;
   }
 
   public void setFlagDatosBD(String string)
   {
     this.flagDatosBD = string;
   }
 
   public String getHayDatos()
   {
     return this.hayDatos;
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
 
   public void setHayDatos(String string)
   {
     this.hayDatos = string;
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
 
   public Vector getVectorExportar(DataSource dataSource)
   {
     Vector vctDet = new Vector();
 
     String statement = (String)Util.getMap().get("gestion_01.inst04");
     if (conecta(dataSource)) {
       Vector vWhere = new Vector();
       vWhere.add("Date," + getFec_inicio().substring(6, 10) + "-" + getFec_inicio().substring(3, 5) + "-" + getFec_inicio().substring(0, 2));
       vWhere.add("Date," + getFec_fin().substring(6, 10) + "-" + getFec_fin().substring(3, 5) + "-" + getFec_fin().substring(0, 2));
       vctDet = consulta(dataSource, statement, vWhere, 3);
       if (vctDet.size() != 0)
         setHayDatosExportar("si");
       else {
         setHayDatosExportar("no");
       }
 
       cierraRst();
     }
     return vctDet;
   }
 
   public String enviarArchivo()
   {
     DownFile objDown = new DownFile();
     String exportFile = 
       objDown.enviarArchivo(this.vctExpHead, this.vctDetalles);
     setMensaje(DownFile.getMensaje());
     return exportFile;
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
 * Qualified Name:     cl.ripley.GestionTV.struts.bean.VisitasBean
 * JD-Core Version:    0.6.2
 */