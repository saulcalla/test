 package cl.ripley.GestionTV.struts.bean;
 
 import cl.ripley.GestionTV.comun.ConectaBD;
 import java.sql.ResultSet;
 import java.text.DecimalFormat;
 import java.text.SimpleDateFormat;
 import java.util.Date;
 import java.util.Vector;
 import javax.sql.DataSource;
 import org.apache.log4j.Logger;
 import org.apache.struts.util.MessageResources;
 
 public class CierreActivacionGCPBean extends ConectaBD
 {
   static Logger log = Logger.getRootLogger();
 
   protected static MessageResources messages = MessageResources.getMessageResources("cl.ripley.GestionTV.struts.msgGestionTV");
   private String accion;
   private Vector vctDetalles;
   private String flagDatosBD = "si";
   private String hayDatos = "no";
   private String mensaje = "";
   private long monto_activacion = 500000L;
   private long monto_anulacion = 500000L;
   private String voucher = "";
   private String voucherHTML = "";
   private String link_voucherHTML = "";
 
   private long monto_original = 0L;
   private long docto_original = 0L;
   private long plazo_original = 0L;
   private String fecha_original = "";
 
   private SimpleDateFormat sdf = new SimpleDateFormat(messages.getMessage("constante.FORMATO_FECHA_2"));
   private SimpleDateFormat sdf2 = new SimpleDateFormat(messages.getMessage("constante.FORMATO_FECHA_GCP"));
   private SimpleDateFormat sdf3 = new SimpleDateFormat(messages.getMessage("constante.FORMATO_FECHA_3"));
   private SimpleDateFormat dfamd = new SimpleDateFormat(messages.getMessage("constante.FORMATO_FECHA"));
   private SimpleDateFormat dfdmy = new SimpleDateFormat(messages.getMessage("constante.FORMATO_FECHA_BO"));
 
   public int generaCierreGCP(DataSource dataSource, String sucursal, String caja, String cod_trx, Date fecha, String usuario)
   {
     Vector vWhere = new Vector();
     String vInstruccion = "gestion_54.inst03";
     int resp = 0;
     String monto_activacion = "0";
     String monto_anulacion = "0";
     String m_total = "0";
     String link = "";
     String web = messages.getMessage("email.gcp.servidor");
     long m_activacion = 0L;
     long m_anulacion = 0L;
     long total = 0L;
     String fecha_cierre = "";
     try
     {
       fecha_cierre = this.sdf.format(fecha);
       if (conecta(dataSource))
       {
         vWhere.add("String," + fecha_cierre);
         vWhere.add("Int," + sucursal);
         vWhere.add("Int," + caja);
         vWhere.add("Int,28");
 
         vWhere.add("String," + fecha_cierre);
         vWhere.add("Int," + sucursal);
         vWhere.add("Int," + caja);
         vWhere.add("Int,38");
 
         consultaRst(dataSource, vInstruccion, vWhere);
 
         while (getRst().next()) {
           setHayDatos("si");
           m_activacion = getRst().getLong("total_activacion");
           m_anulacion = getRst().getLong("total_desactivacion");
         }
 
         total = m_activacion - m_anulacion;
 
         m_total = formateaPrecio(total);
         monto_activacion = formateaPrecio(m_activacion);
         monto_anulacion = formateaPrecio(m_anulacion);
 
         if (getHayDatos().equals("no")) {
           return -1;
         }
 
         link = "informeCierreGCPHTML.jsp?sucursal=" + sucursal + "&caja=" + caja + "&activacion=" + monto_activacion + 
           "&anulacion=" + monto_anulacion + "&total=" + m_total + "&usuario=" + usuario + "&fec_inicio=" + fecha_cierre;
 
         link = link.replaceAll(" ", "%20");
         link = web + link;
         setLink_voucherHTML(link);
       }
     }
     catch (Exception e) {
       log.error("Error generaCierreGCP() : " + e);
       return -1;
     }
     finally {
       cierraRst(); } cierraRst();
 
     return resp;
   }
 
   public boolean validaAperturaCierre(DataSource dataSource, String sucursal, String caja, String tipo_trx, Date fecha)
   {
     String vInstruccion = "gestion_48.inst01";
     Vector vWhere = new Vector();
     boolean existe_trx = false;
     try
     {
       if (conecta(dataSource)) {
         vWhere.add("Int," + sucursal);
         vWhere.add("Int," + caja);
         vWhere.add("Int," + tipo_trx);
         vWhere.add("Datedmy," + this.sdf.format(fecha));
 
         setRst(null);
         consultaRst(dataSource, vInstruccion, vWhere);
 
         if (getRst().next())
           return true;
       }
     }
     catch (Exception e) {
       log.error("Error Validacion validaAperturaCierre() : " + e);
     }
     finally {
       cierraRst(); } cierraRst();
 
     return existe_trx;
   }
 
   private String formateaPrecio(long pPrecio)
     throws Exception
   {
     DecimalFormat formateador = new DecimalFormat("##################,###");
 
     String n_precio = "";
     try
     {
       n_precio = formateador.format(pPrecio);
     }
     catch (Exception e) {
       log.error("ERROR: FormatPrecio CierreActivacionGCP " + 
         e.getLocalizedMessage());
       return "0";
     }
     return n_precio;
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
 
   public long getDocto_original() {
     return this.docto_original;
   }
 
   public void setDocto_original(long docto_original) {
     this.docto_original = docto_original;
   }
 
   public String getFecha_original() {
     return this.fecha_original;
   }
 
   public void setFecha_original(String fecha_original) {
     this.fecha_original = fecha_original;
   }
 
   public long getMonto_original() {
     return this.monto_original;
   }
 
   public void setMonto_original(long monto_original) {
     this.monto_original = monto_original;
   }
 
   public long getPlazo_original() {
     return this.plazo_original;
   }
 
   public void setPlazo_original(long plazo_original) {
     this.plazo_original = plazo_original;
   }
 
   public String getVoucher() {
     return this.voucher;
   }
 
   public void setVoucher(String voucher) {
     this.voucher = voucher;
   }
 
   public String getVoucherHTML() {
     return this.voucherHTML;
   }
 
   public void setVoucherHTML(String voucherHTML) {
     this.voucherHTML = voucherHTML;
   }
 
   public String getLink_voucherHTML() {
     return this.link_voucherHTML;
   }
 
   public void setLink_voucherHTML(String link_voucherHTML) {
     this.link_voucherHTML = link_voucherHTML;
   }
 }

/* Location:           C:\sitios\GestionTV_Ripley\trunk\docs\01 Requerimiento\Fuentes Gestión TV\GestionTV-WC7\WEB-INF\classes\
 * Qualified Name:     cl.ripley.GestionTV.struts.bean.CierreActivacionGCPBean
 * JD-Core Version:    0.6.2
 */