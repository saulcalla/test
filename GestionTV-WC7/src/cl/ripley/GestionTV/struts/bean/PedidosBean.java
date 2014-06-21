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
 
 public class PedidosBean extends ConectaBD
 {
   static Logger log = Logger.getRootLogger();
   protected static MessageResources messages = MessageResources.getMessageResources("cl.ripley.GestionTV.struts.msgGestionTV");
   private String accion;
   private Vector vctDetalles;
   private String fec_inicio;
   private String fec_fin;
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
   private Vector vctExpHeadNota = new Vector();
   private Vector vctExpHead = new Vector();
   private int i;
   private int j;
   private int k;
   private String str1;
   private String str2;
   private String str3;
   private String str4;
   private String str5;
   private String str6;
 
   public void consulta(DataSource dataSource)
   {
     String statement = (String)Util.getMap().get("gestion_02.inst01");
     Vector vctDet = new Vector();
 
     Vector vWhere = new Vector();
     vWhere.add("Date," + getFec_inicio().substring(6, 10) + "-" + getFec_inicio().substring(3, 5) + "-" + getFec_inicio().substring(0, 2));
     vWhere.add("Date," + getFec_fin().substring(6, 10) + "-" + getFec_fin().substring(3, 5) + "-" + getFec_fin().substring(0, 2));
     vWhere.add("Date," + getFec_inicio().substring(6, 10) + "-" + getFec_inicio().substring(3, 5) + "-" + getFec_inicio().substring(0, 2));
     vWhere.add("Date," + getFec_fin().substring(6, 10) + "-" + getFec_fin().substring(3, 5) + "-" + getFec_fin().substring(0, 2));
     vctDet = consulta(dataSource, statement, vWhere, 3);
     if (vctDet.size() != 0)
       setHayDatos("si");
     else {
       setHayDatos("no");
     }
 
     Vector d = new Vector();
     Vector e = new Vector();
     Vector x = new Vector();
     Vector c = new Vector();
     Vector copiavctDet = new Vector();
     Vector vct_paso = new Vector(x);
     this.i = 0; this.k = 0;
     int largo = vctDet.size();
     copiavctDet = (Vector)vctDet.clone();
     while (this.i <= largo - 1)
     {
       Vector b = (Vector)copiavctDet.elementAt(this.i);
       this.i += 1;
       this.str1 = ((String)b.get(0)); this.str2 = ((String)b.get(1)); this.str3 = ((String)b.get(2));
 
       if (this.i <= largo - 1)
       {
         c = (Vector)copiavctDet.elementAt(this.i);
         this.i += 1;
         this.str4 = ((String)c.get(0)); this.str5 = ((String)c.get(1)); this.str6 = ((String)c.get(2));
         if (this.str1.equals(this.str4)) {
           if ((this.str3.equals("1")) && (this.str6.equals("2"))) { d.add(0, this.str1); d.add(1, this.str2); d.add(2, this.str5); }
           e = d;
           vct_paso.add(this.k, e);
           d = new Vector(); b = new Vector(); c = new Vector();
           this.str1 = ""; this.str2 = ""; this.str3 = ""; this.str4 = ""; this.str5 = ""; this.str6 = "";
           this.k += 1;
         }
         else {
           this.i -= 1;
           if (this.str3.equals("1")) { d.add(0, this.str1); d.add(1, this.str2); d.add(2, "0");
           } else if (this.str3.equals("2")) { d.add(0, this.str1); d.add(1, "0"); d.add(2, this.str2); }
           e = d;
           vct_paso.add(this.k, e);
           d = new Vector(); b = new Vector(); c = new Vector();
           this.str1 = ""; this.str2 = ""; this.str3 = ""; this.str4 = ""; this.str5 = ""; this.str6 = "";
           this.k += 1;
         }
       }
       else {
         if (this.str3.equals("1")) { d.add(0, this.str1); d.add(1, this.str2); d.add(2, "0"); }
         if (this.str3.equals("2")) { d.add(0, this.str1); d.add(1, "0"); d.add(2, this.str2);
         }
         e = d;
         vct_paso.add(this.k, e);
         d = new Vector(); b = new Vector();
         this.str1 = ""; this.str2 = ""; this.str3 = ""; this.str4 = ""; this.str5 = ""; this.str6 = "";
         this.k += 1;
       }
     }
     setVctDetalles(vct_paso);
   }
 
   public Vector getPaginacion(DataSource dataSource, String strAra)
   {
     Vector vRes = new Vector();
     int maxIndice = getIndice() + getRegistrosPorBloque() + 1;
     String vInstruccion = "";
     Vector vWhere = new Vector();
 
     if (conecta(dataSource)) {
       vInstruccion = "gestion_80.inst01";
       vWhere.add("String," + getFec_inicio().substring(6, 10) + "-" + getFec_inicio().substring(3, 5) + "-" + getFec_inicio().substring(0, 2));
       vWhere.add("String," + getFec_fin().substring(6, 10) + "-" + getFec_fin().substring(3, 5) + "-" + getFec_fin().substring(0, 2));
       vWhere.add("Int," + Integer.toString(getIndice()));
       vWhere.add("Int," + Integer.toString(maxIndice));
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
 
   public int getTotalRegistros(DataSource dataSource, String strAra) {
     Vector vRes = new Vector();
     int intRes = 0;
     String statement = "";
     Vector vWhere = new Vector();
 
     if (conecta(dataSource)) {
       statement = (String)Util.getMap().get("gestion_80.inst02");
       vWhere.add("String," + getFec_inicio().substring(6, 10) + "-" + getFec_inicio().substring(3, 5) + "-" + getFec_inicio().substring(0, 2));
       vWhere.add("String," + getFec_fin().substring(6, 10) + "-" + getFec_fin().substring(3, 5) + "-" + getFec_fin().substring(0, 2));
       try
       {
         vRes = consulta(dataSource, statement, vWhere, 1);
         if (vRes.size() != 0) {
           Vector b = (Vector)vRes.elementAt(0);
           intRes = Integer.parseInt((String)b.get(0));
         }
       } catch (Exception e) {
         log.error("::Exception, " + e);
       }
       finally {
         cierraRst();
       }
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
         for (int i = 1; i <= 13; i++)
         {
           if (i == 1) {
             String fechaCrea = "";
             String fecha = "";
             String year = "";
             String mes = "";
             String dia = "";
             fechaCrea = rst.getString(i);
             if (fechaCrea.length() > 0) {
               year = fechaCrea.substring(0, 4);
               mes = fechaCrea.substring(5, 7);
               dia = fechaCrea.substring(8, 10);
               fecha = dia + "" + year;
 
               campos.add(fecha);
             }
             else
             {
               campos.add(rst.getString(i));
             }
 
           }
           else
           {
             campos.add(rst.getString(i).toString());
           }
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
   public String getFec_fin() {
     return this.fec_fin;
   }
 
   public void setFec_inicio(String string)
   {
     this.fec_inicio = string;
   }
   public void setFec_fin(String string) {
     this.fec_fin = string;
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
 
   public void setVctExpHeadNota(Vector vector)
   {
     this.vctExpHeadNota = vector;
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
     try {
       if (conecta(dataSource))
       {
         statement = (String)Util.getMap().get("gestion_80.inst03");
         vWhere.add("String," + getFec_inicio().substring(6, 10) + "-" + getFec_inicio().substring(3, 5) + "-" + getFec_inicio().substring(0, 2));
         vWhere.add("String," + getFec_fin().substring(6, 10) + "-" + getFec_fin().substring(3, 5) + "-" + getFec_fin().substring(0, 2));
 
         vRes = consulta(dataSource, statement, vWhere, 13);
       }
 
       if (vRes.size() != 0)
         setHayDatosExportar("si");
       else
         setHayDatosExportar("no");
     }
     catch (Exception e)
     {
       log.error(e);
     } finally {
       cierraRst();
     }
 
     return vRes;
   }
 
   public String enviarArchivo()
   {
     DownFile objDown = new DownFile();
     String exportFile = 
       objDown.enviarArchivoNew(this.vctExpHead, this.vctDetalles, this.vctExpHeadNota);
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
 * Qualified Name:     cl.ripley.GestionTV.struts.bean.PedidosBean
 * JD-Core Version:    0.6.2
 */