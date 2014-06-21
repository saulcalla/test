 package cl.ripley.GestionTV.struts.bean;
 
 import cl.ripley.GestionTV.comun.ConectaBD;
 import cl.ripley.GestionTV.comun.DownFile;
 import cl.ripley.GestionTV.comun.Util;
 import java.sql.ResultSet;
 import java.util.Map;
 import java.util.Vector;
 import javax.sql.DataSource;
 import org.apache.log4j.Logger;
 import org.apache.struts.util.MessageResources;
 
 public class AuditoriaGCPBean extends ConectaBD
 {
   static Logger log = Logger.getRootLogger();
   protected static MessageResources messages = MessageResources.getMessageResources("cl.ripley.GestionTV.struts.msgGestionTV");
   private String accion;
   private Vector vctDetalles;
   private String fec_inicio;
   private String codSucursal;
   private String glosaSucursal;
   private int contador = 0;
   private String flagDatosBD = "si";
   private String hayDatos = "no";
   private String hayDatosExportar = "no";
   private String hayProximoBloque = "si";
   private int indice = 0;
   private Vector listaPagina = new Vector();
   private String mensaje = "";
   private int nroBloque = -1;
   private int registrosPorBloque = 10;
   private int totalPaginas = 0;
   private int totalRegistros = 0;
   private int totalReg = 0;
   private Vector vctExportar = new Vector();
   private Vector vctExpHead = new Vector();
   private String fec_hasta;
   private String codRegalo;
 
   public Vector getPaginacion(DataSource dataSource, String strAra)
   {
     Vector vRes = new Vector();
     int maxIndice = getIndice() + getRegistrosPorBloque() + 1;
     String vInstruccion = "";
     Vector vWhere = new Vector();
     int intRes = 0;
 
     if (conecta(dataSource))
     {
       try
       {
         vInstruccion = (String)Util.getMap().get("gestion_47.inst01");
         vWhere.add("String," + getFec_inicio().substring(6, 10) + "-" + getFec_inicio().substring(3, 5) + "-" + getFec_inicio().substring(0, 2));
         vWhere.add("Int," + Integer.toString(getIndice()));
         vWhere.add("Int," + Integer.toString(maxIndice));
 
         vRes = consulta(dataSource, vInstruccion, vWhere, 18);
       }
       catch (Exception e) {
         log.error("::Exception, EN AuditoriaGCP " + e.toString());
       }
       finally {
         cierraRst();
       }
     }
 
     setContador(vRes.size());
 
     if (vRes.size() != 0) {
       setHayDatos("si");
       setNroBloque(
         getIndice() / getRegistrosPorBloque() + 1);
     } else {
       setHayDatos("no");
     }
 
     if (maxIndice < getTotalReg() + 1)
       setHayProximoBloque("si");
     else {
       setHayProximoBloque("no");
     }
 
     return vRes;
   }
 
   public int getTotalRegistros(DataSource dataSource, String strAra)
   {
     Vector vRes = new Vector();
     int intRes = 0;
     String statement = "";
     Vector vWhere = new Vector();
     try
     {
       if (conecta(dataSource))
       {
         statement = (String)Util.getMap().get("gestion_47.inst02");
         vWhere.add("String," + getFec_inicio().substring(6, 10) + "-" + getFec_inicio().substring(3, 5) + "-" + getFec_inicio().substring(0, 2));
 
         vRes = consulta(dataSource, statement, vWhere, 1);
         if (vRes.size() != 0) {
           Vector b = (Vector)vRes.elementAt(0);
           intRes = Integer.parseInt((String)b.get(0));
         }
       }
     } catch (Exception e) {
       log.error("ERROR:: AuditoriaGCP.getTotalRegistros() " + e);
     } finally {
       cierraRst();
     }
 
     return intRes;
   }
 
   public Vector getListaPagina()
   {
     Vector v = new Vector();
 
     int p = getTotalPaginas();
 
     for (int i = 1; i <= p; i++) {
       v.add(Integer.toString(i));
     }
     this.listaPagina = v;
 
     return this.listaPagina;
   }
 
   public void setListaPagina(Vector vector)
   {
     this.listaPagina = vector;
   }
 
   public int getTotalPaginas() {
     int p = 0;
 
     int r = getRegistrosPorBloque();
 
     if (r != 0) {
       p = getTotalReg() / r;
       int b = p * r;
 
       if (b != getTotalReg())
       {
         p++;
       }
     }
     this.totalPaginas = p;
     return this.totalPaginas;
   }
 
   public int getIndice()
   {
     return this.indice;
   }
 
   public int getNroBloque()
   {
     return this.nroBloque;
   }
 
   public int getRegistrosPorBloque()
   {
     if (this.registrosPorBloque == 0) {
       this.registrosPorBloque = 10;
     }
     return this.registrosPorBloque;
   }
 
   public void setIndice(int i)
   {
     this.indice = i;
   }
 
   public void setNroBloque(int i)
   {
     this.nroBloque = i;
   }
 
   public void setRegistrosPorBloque(int i)
   {
     this.registrosPorBloque = i;
   }
 
   public String getHayDatos()
   {
     return this.hayDatos;
   }
 
   public void setHayDatos(String string)
   {
     this.hayDatos = string;
   }
 
   public String getHayProximoBloque()
   {
     return this.hayProximoBloque;
   }
 
   public void setHayProximoBloque(String string)
   {
     this.hayProximoBloque = string;
   }
 
   public void setTotalPaginas(int i)
   {
     this.totalPaginas = i;
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
 
   public int getContador()
   {
     return this.contador;
   }
 
   public void setContador(int i)
   {
     this.contador = i;
   }
 
   public int getTotalReg()
   {
     return this.totalReg;
   }
 
   public void setTotalReg(int i)
   {
     this.totalReg = i;
   }
 
   public int getTotalRegistros()
   {
     return this.totalRegistros;
   }
 
   public void setTotalRegistros(int i)
   {
     this.totalRegistros = i;
   }
 
   public Vector filtra(ResultSet rst)
   {
     Vector vct_paso = new Vector();
     Vector f = new Vector();
     int k = 0;
     try {
       while (rst.next()) {
         Vector campos = new Vector();
         for (int i = 1; i <= 18; i++)
         {
           campos.add(rst.getString(i).toString());
         }
 
         f = (Vector)campos.clone();
         vct_paso.add(k, f);
         k++;
         campos.clear();
       }
     }
     catch (Exception e) {
       log.error("::Exception, " + e.getMessage() + "\n" + 
         e.getCause().toString());
     } finally {
       cierraRst();
     }
     return vct_paso;
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
 
   public Vector getVectorExportar(DataSource dataSource)
   {
     Vector vRes = new Vector();
     String statement = "";
     Vector vWhere = new Vector();
     try
     {
       if (conecta(dataSource))
       {
         statement = (String)Util.getMap().get("gestion_47.inst03");
         vWhere.add("String," + getFec_inicio().substring(6, 10) + "-" + getFec_inicio().substring(3, 5) + "-" + getFec_inicio().substring(0, 2));
         vRes = consulta(dataSource, statement, vWhere, 18);
       }
     }
     catch (Exception e) {
       log.error("ERROR:: AuditoriaGCP.getVectorExportar() " + e);
     } finally {
       cierraRst();
     }
 
     if (vRes.size() != 0)
       setHayDatosExportar("si");
     else {
       setHayDatosExportar("no");
     }
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
 
   public String getHayDatosExportar()
   {
     return this.hayDatosExportar;
   }
 
   public void setHayDatosExportar(String string)
   {
     this.hayDatosExportar = string;
   }
 
   public String getCodSucursal()
   {
     return this.codSucursal;
   }
 
   public void setCodSucursal(String codSucursal)
   {
     this.codSucursal = codSucursal;
   }
 
   public String getGlosaSucursal()
   {
     return this.glosaSucursal;
   }
 
   public void setGlosaSucursal(String glosaSucursal)
   {
     this.glosaSucursal = glosaSucursal;
   }
 
   public String getCodRegalo() {
     return this.codRegalo;
   }
 
   public void setCodRegalo(String codRegalo) {
     this.codRegalo = codRegalo;
   }
 
   public String getFec_hasta() {
     return this.fec_hasta;
   }
 
   public void setFec_hasta(String fec_hasta) {
     this.fec_hasta = fec_hasta;
   }
 }

/* Location:           C:\sitios\GestionTV_Ripley\trunk\docs\01 Requerimiento\Fuentes Gestión TV\GestionTV-WC7\WEB-INF\classes\
 * Qualified Name:     cl.ripley.GestionTV.struts.bean.AuditoriaGCPBean
 * JD-Core Version:    0.6.2
 */