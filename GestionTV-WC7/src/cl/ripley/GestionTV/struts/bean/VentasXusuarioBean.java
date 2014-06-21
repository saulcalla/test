 package cl.ripley.GestionTV.struts.bean;
 
 import cl.ripley.GestionTV.comun.ConectaBD;
 import cl.ripley.GestionTV.comun.DownFile;
 import cl.ripley.GestionTV.comun.Util;
 import java.sql.ResultSet;
 import java.util.Collection;
 import java.util.Map;
 import java.util.Vector;
 import javax.sql.DataSource;
 import org.apache.log4j.Logger;
 import org.apache.struts.util.LabelValueBean;
 import org.apache.struts.util.MessageResources;
 
 public class VentasXusuarioBean extends ConectaBD
 {
   static Logger log = Logger.getRootLogger();
 
   protected static MessageResources messages = MessageResources.getMessageResources("cl.ripley.GestionTV.struts.msgGestionTV");
   private String accion;
   private Vector vctDetalles;
   private String fec_inicio;
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
   private String rut_usuario;
   private String[] ventas;
   private String selecEjecutivo;
 
   public Vector getPaginacion(DataSource dataSource)
   {
     Vector vRes = new Vector();
     int maxIndice = getIndice() + getRegistrosPorBloque() + 1;
     String vInstruccion = "";
     Vector vWhere = new Vector();
     String nick = "";
     if (conecta(dataSource))
     {
       if (!getSelecEjecutivo().equals("")) {
         nick = getSelecEjecutivo().substring(1, getSelecEjecutivo().length() - 1);
       }
 
       if ((!getSelecEjecutivo().equals("")) && (getFec_inicio().equals(""))) {
         vInstruccion = "gestion_56.inst01";
         vWhere.add("String," + nick);
         vWhere.add("Int," + Integer.toString(getIndice()));
         vWhere.add("Int," + Integer.toString(maxIndice));
       }
 
       if ((!getFec_inicio().equals("")) && (getSelecEjecutivo().equals(""))) {
         vInstruccion = "gestion_57.inst01";
         vWhere.add("String," + getFec_inicio().substring(6, 10) + "-" + 
           getFec_inicio().substring(3, 5) + "-" + 
           getFec_inicio().substring(0, 2));
 
         vWhere.add("Int," + Integer.toString(getIndice()));
         vWhere.add("Int," + Integer.toString(maxIndice));
       }
 
       if ((!getFec_inicio().equals("")) && (!getSelecEjecutivo().equals(""))) {
         vInstruccion = "gestion_57.inst03";
         vWhere.add("String," + getFec_inicio().substring(6, 10) + "-" + 
           getFec_inicio().substring(3, 5) + "-" + 
           getFec_inicio().substring(0, 2));
 
         vWhere.add("String," + nick);
 
         vWhere.add("Int," + Integer.toString(getIndice()));
         vWhere.add("Int," + Integer.toString(maxIndice));
       }
       try
       {
         consultaRst(dataSource, vInstruccion, vWhere);
         vRes = filtra(getRst());
       } catch (Exception e) {
         log.error("::Exception, " + e);
       }
       finally {
         cierraRst();
       }
     }
 
     setContador(vRes.size());
 
     if (vRes.size() != 0) {
       setHayDatos("si");
       setNroBloque(getIndice() / getRegistrosPorBloque() + 
         1);
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
 
   public int getTotalRegistros(DataSource dataSource) {
     Vector vRes = new Vector();
     int intRes = 0;
     String statement = "";
     Vector vWhere = new Vector();
     String nick = "";
     if (conecta(dataSource))
     {
       if (!getSelecEjecutivo().equals("")) {
         nick = getSelecEjecutivo().substring(1, getSelecEjecutivo().length() - 1);
       }
 
       if ((!getSelecEjecutivo().equals("")) && (getFec_inicio().equals(""))) {
         statement = (String)Util.getMap().get("gestion_56.inst02");
         vWhere.add("String," + nick);
       }
 
       if ((!getFec_inicio().equals("")) && (getSelecEjecutivo().equals(""))) {
         statement = (String)Util.getMap().get("gestion_57.inst02");
         vWhere.add("String," + getFec_inicio().substring(6, 10) + "-" + 
           getFec_inicio().substring(3, 5) + "-" + 
           getFec_inicio().substring(0, 2));
       }
 
       if ((!getFec_inicio().equals("")) && (!getSelecEjecutivo().equals(""))) {
         statement = (String)Util.getMap().get("gestion_57.inst04");
         vWhere.add("String," + getFec_inicio().substring(6, 10) + "-" + 
           getFec_inicio().substring(3, 5) + "-" + 
           getFec_inicio().substring(0, 2));
 
         vWhere.add("String," + nick);
       }
 
       vRes = consulta(dataSource, statement, vWhere, 1);
       if (vRes.size() != 0) {
         Vector b = (Vector)vRes.elementAt(0);
         intRes = Integer.parseInt((String)b.get(0));
       }
       cierraRst();
     }
     return intRes;
   }
 
   public int actualizaRegistros(DataSource dataSource)
   {
     int intRes = 0;
     String statement = "";
     Vector update = new Vector();
 
     if (conecta(dataSource))
     {
       String cadena = null;
       for (int i = 0; i < this.ventas.length; i++)
       {
         cadena = this.ventas[i];
       }
 
       String[] vCadena = cadena.split(",");
 
       String sql = "";
       statement = (String)Util.getMap().get("gestion_56.inst04");
       statement = statement.replaceAll("\n", "");
       statement = statement.replaceAll("\t", "");
 
       for (int j = 0; j < vCadena.length; j++)
       {
         sql = statement.replaceAll("X", vCadena[j]);
         update.add(sql);
       }
 
       intRes = update_sql(dataSource, update);
 
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
     int cont = 0;
     boolean tc = false;
     try {
       while (rst.next()) {
         Vector campos = new Vector();
         for (int i = 1; i <= 13; i++)
         {
           if (i == 1)
           {
             String val = rst.getString(i);
 
             if (val.equals("T"))
             {
               campos.add(val);
               tc = true;
             }
             else
             {
               tc = false;
             }
 
           }
           else if (i == 2)
           {
             String oc = rst.getString(i);
             campos.add(oc);
 
             if (!tc) {
               campos.add(oc);
             }
 
           }
           else if (i == 13) {
             String tipo = rst.getString(i).trim();
             if (tipo.trim().equals("0")) {
               tipo = "TARJ. RIPLEY";
             }
             campos.add(tipo);
           }
           else
           {
             campos.add(rst.getString(i));
           }
         }
 
         f = (Vector)campos.clone();
         vct_paso.add(k, f);
         k++;
         campos.clear();
       }
     }
     catch (Exception e) {
       log.error("::Exception, " + e);
     }
     finally {
       cierraRst();
     }
     return vct_paso;
   }
 
   public Collection getCollEjecutivos(DataSource dataSource)
   {
     Vector vector = new Vector();
     Vector vWhere = new Vector();
     Vector v = new Vector();
     String statement = (String)Util.getMap().get("gestion_56.inst03");
     String cod = "";
     String nom = "";
     Collection beanCollection = null;
     Vector respuesta = new Vector();
 
     vector = consulta(dataSource, statement, 1);
 
     int n = vector.size();
     for (int i = 0; i < n; i++) {
       nom = vector.elementAt(i).toString();
 
       if (i == 0) {
         respuesta.add(new LabelValueBean("SELECCIONE", ""));
         respuesta.add(new LabelValueBean(nom, nom));
       } else {
         respuesta.add(new LabelValueBean(nom, nom));
       }
 
     }
 
     if (n == 0) {
       respuesta.add(new LabelValueBean("SIN ESTADO", "-1"));
     }
 
     cierraRst();
 
     beanCollection = respuesta;
     return beanCollection;
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
     String nick = "";
 
     if (conecta(dataSource))
     {
       if (!getSelecEjecutivo().equals("")) {
         nick = getSelecEjecutivo().substring(1, getSelecEjecutivo().length() - 1);
       }
 
       if ((!getSelecEjecutivo().equals("")) && (getFec_inicio().equals("")))
       {
         statement = (String)Util.getMap().get("gestion_58.inst02");
         vWhere.add("String," + nick);
       }
 
       if ((!getFec_inicio().equals("")) && (getSelecEjecutivo().equals("")))
       {
         statement = (String)Util.getMap().get("gestion_58.inst01");
         vWhere.add("String," + getFec_inicio().substring(6, 10) + "-" + 
           getFec_inicio().substring(3, 5) + "-" + 
           getFec_inicio().substring(0, 2));
       }
 
       if ((!getFec_inicio().equals("")) && (!getSelecEjecutivo().equals("")))
       {
         statement = (String)Util.getMap().get("gestion_58.inst03");
 
         vWhere.add("String," + getFec_inicio().substring(6, 10) + "-" + 
           getFec_inicio().substring(3, 5) + "-" + 
           getFec_inicio().substring(0, 2));
 
         vWhere.add("String," + nick);
       }
 
       vRes = consulta(dataSource, statement, vWhere, 13);
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
     String exportFile = objDown.enviarArchivo(this.vctExpHead, 
       this.vctDetalles);
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
 
   public String getRut_usuario() {
     return this.rut_usuario;
   }
 
   public void setRut_usuario(String rut_usuario) {
     this.rut_usuario = rut_usuario;
   }
 
   public String getSelecEjecutivo() {
     return this.selecEjecutivo;
   }
 
   public void setSelecEjecutivo(String selecEjecutivo) {
     this.selecEjecutivo = selecEjecutivo;
   }
 
   public String[] getVentas() {
     return this.ventas;
   }
 
   public void setVentas(String[] ventas) {
     this.ventas = ventas;
   }
 }

/* Location:           C:\sitios\GestionTV_Ripley\trunk\docs\01 Requerimiento\Fuentes Gestión TV\GestionTV-WC7\WEB-INF\classes\
 * Qualified Name:     cl.ripley.GestionTV.struts.bean.VentasXusuarioBean
 * JD-Core Version:    0.6.2
 */