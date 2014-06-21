 package cl.ripley.GestionTV.struts.bean;
 
 import cl.ripley.GestionTV.comun.ConectaBD;
 import cl.ripley.GestionTV.comun.Util;
 import java.util.Map;
 import java.util.Vector;
 import javax.sql.DataSource;
 import org.apache.struts.util.MessageResources;
 
 public class PopupBean extends ConectaBD
 {
   protected static MessageResources messages = MessageResources.getMessageResources("cl.ripley.GestionTV.struts.msgGestionTV");
   private Vector vctDetalles = new Vector();
   private String glosa_est;
   private String glosa_prop;
   private String glosa_url;
   private int idpopup;
   private String mensaje = new String("");
 
   public void consulta(DataSource dataSource) {
     String statement = (String)Util.getMap().get("gestion_06.inst01");
     Vector vctDet = new Vector();
     if (conecta(dataSource)) {
       vctDet = consulta(dataSource, statement, 4);
       setVctDetalles(vctDet);
     }
   }
 
   public boolean agregarpop(DataSource dataSource) { String statement = (String)Util.getMap().get("gestion_06.inst02");
     Vector vWhere = new Vector();
     int intRes = 0;
     boolean retorno = false;
 
     Vector listanumpop = new Vector();
     Vector vecpaso = new Vector();
     String stcuenta = (String)Util.getMap().get("gestion_06.inst04");
 
     listanumpop = consulta(dataSource, stcuenta, 1);
     int largo = listanumpop.size();
     int num2;
     if (largo == 0) {
       num2 = 0;
     }
     else
     {
       int pos;
       if (largo == 1) {
         pos = largo - 1;
         vecpaso = (Vector)listanumpop.get(pos);
 
         String str1 = (String)vecpaso.elementAt(0);
         num2 = Integer.valueOf(str1).intValue();
       }
       else
       {
         pos = largo - 1;
       }vecpaso = (Vector)listanumpop.get(pos);
       String str1 = (String)vecpaso.elementAt(0);
       num2 = Integer.valueOf(str1).intValue();
     }
 
     vWhere.add("Int," + (num2 + 1));
     vWhere.add("Int," + getGlosa_est());
 
     vWhere.add("String," + getGlosa_prop().trim());
     vWhere.add("String," + this.glosa_url.trim());
 
     intRes = inserta(dataSource, statement, vWhere);
     if (intRes > 0) {
       setMensaje(messages.getMessage("popup.agregar.ok"));
       retorno = true;
     }
     else {
       setMensaje(messages.getMessage("popup.agregar.err"));
       return retorno;
     }
     return retorno; }
 
   public boolean modificarpop(DataSource dataSource) {
     String statement = (String)Util.getMap().get("gestion_06.inst03");
     Vector vWhere = new Vector();
     int intRes = 0;
 
     boolean retorno = false;
     vWhere.add("Int," + getGlosa_est());
 
     vWhere.add("String," + getGlosa_prop().trim());
     vWhere.add("String," + this.glosa_url.trim());
 
     vWhere.add("Int," + getIdpopup());
     intRes = inserta(dataSource, statement, vWhere);
     if (intRes > 0) {
       setMensaje(messages.getMessage("popup.modificar.ok"));
       retorno = true;
     }
     else {
       setMensaje(messages.getMessage("popup.modificar.err"));
       return retorno;
     }
     return retorno;
   }
 
   public Vector getVctDetalles() {
     return this.vctDetalles;
   }
   public void setVctDetalles(Vector vector) {
     this.vctDetalles = vector;
   }
 
   public static MessageResources getMessages()
   {
     return messages;
   }
 
   public String getGlosa_est()
   {
     return this.glosa_est;
   }
 
   public String getGlosa_prop()
   {
     return this.glosa_prop;
   }
 
   public String getGlosa_url()
   {
     return this.glosa_url;
   }
 
   public static void setMessages(MessageResources resources)
   {
     messages = resources;
   }
 
   public void setGlosa_est(String string)
   {
     this.glosa_est = string;
   }
 
   public void setGlosa_prop(String string)
   {
     this.glosa_prop = string;
   }
 
   public void setGlosa_url(String string)
   {
     this.glosa_url = string;
   }
 
   public String getMensaje()
   {
     return this.mensaje;
   }
 
   public void setMensaje(String string)
   {
     this.mensaje = string;
   }
 
   public int getIdpopup()
   {
     return this.idpopup;
   }
 
   public void setIdpopup(int i)
   {
     this.idpopup = i;
   }
 }

/* Location:           C:\sitios\GestionTV_Ripley\trunk\docs\01 Requerimiento\Fuentes Gestión TV\GestionTV-WC7\WEB-INF\classes\
 * Qualified Name:     cl.ripley.GestionTV.struts.bean.PopupBean
 * JD-Core Version:    0.6.2
 */