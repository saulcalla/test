 package cl.ripley.GestionTV.struts.bean;
 
 import cl.ripley.GestionTV.comun.ConectaBD;
 import cl.ripley.GestionTV.comun.DownFile;
 import cl.ripley.GestionTV.comun.Util;
 import java.util.Map;
 import java.util.Vector;
 import javax.sql.DataSource;
 import org.apache.struts.util.MessageResources;
 
 public class ProductoConStockBean extends ConectaBD
 {
   protected static MessageResources messages = MessageResources.getMessageResources("cl.ripley.GestionTV.struts.msgGestionTV");
   private Vector vctDetalles = new Vector();
   private Vector vctExportar = new Vector();
   private Vector vctExpHead = new Vector();
   private String mensaje = "";
   private String hayDatos = "no";
 
   public void consulta(DataSource dataSource) { String statement = (String)Util.getMap().get("gestion_03.inst04");
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
       (String)Util.getMap().get("gestion_03.inst04");
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
 
   public void setVctExpHead(Vector vector)
   {
     this.vctExpHead = vector;
   }
 
   public void setVctExportar(Vector vector)
   {
     this.vctExportar = vector;
   }
 
   public String getMensaje()
   {
     return this.mensaje;
   }
 
   public void setMensaje(String string)
   {
     this.mensaje = string;
   }
 
   public String getHayDatos()
   {
     return this.hayDatos;
   }
 
   public void setHayDatos(String string)
   {
     this.hayDatos = string;
   }
 }

/* Location:           C:\sitios\GestionTV_Ripley\trunk\docs\01 Requerimiento\Fuentes Gestión TV\GestionTV-WC7\WEB-INF\classes\
 * Qualified Name:     cl.ripley.GestionTV.struts.bean.ProductoConStockBean
 * JD-Core Version:    0.6.2
 */