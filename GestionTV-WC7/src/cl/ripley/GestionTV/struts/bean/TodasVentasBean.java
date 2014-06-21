 package cl.ripley.GestionTV.struts.bean;
 
 import cl.ripley.GestionTV.comun.ConectaBD;
 import cl.ripley.GestionTV.comun.DownFile;
 import cl.ripley.GestionTV.comun.Log;
 import cl.ripley.GestionTV.comun.Util;
 import java.sql.ResultSet;
 import java.util.Map;
 import java.util.Vector;
 import javax.sql.DataSource;
 import org.apache.struts.util.MessageResources;
 
 public class TodasVentasBean extends ConectaBD
 {
   protected static MessageResources messages = MessageResources.getMessageResources("cl.ripley.GestionTV.struts.msgGestionTV");
   private String accion;
   private Vector vctDetalles;
   private String fec_inicio;
   private String fec_fin;
   private String codSucursal;
   private String glosaSucursal;
   private int contador = 0;
   private String flagDatosBD = "si";
   private String hayDatos = "no";
   private String hayProximoBloque = "si";
   private int indice = 0;
   private Vector listaPagina = new Vector();
   private String mensaje = "";
   private int nroBloque = -1;
   private int registrosPorBloque = 10;
   private int totalPaginas = 0;
   private int totalRegistros = 0;
   private int totalReg = 0;
 
   private String hayDatosExportar = "no";
   private Vector vctExportar = new Vector();
   private Vector vctExpHeadNota = new Vector();
   private Vector vctExpHead = new Vector();
   
   private String sucursal = "";
 
   public Vector getVectorExportar(DataSource dataSource)
   {
     Vector vRes = new Vector();
     String statement = "";
     Vector vWhere = new Vector();
     if (conecta(dataSource))
     {
       if (getCodSucursal().equals("0")) {
         statement = (String)Util.getMap().get("gestion_27.inst02");
         vWhere.add("String," + getFec_inicio().substring(6, 10) + "-" + getFec_inicio().substring(3, 5) + "-" + getFec_inicio().substring(0, 2));
         vWhere.add("String," + getFec_fin().substring(6, 10) + "-" + getFec_fin().substring(3, 5) + "-" + getFec_fin().substring(0, 2));
         vWhere.add("String," + getFec_inicio().substring(6, 10) + "-" + getFec_inicio().substring(3, 5) + "-" + getFec_inicio().substring(0, 2));
         vWhere.add("String," + getFec_fin().substring(6, 10) + "-" + getFec_fin().substring(3, 5) + "-" + getFec_fin().substring(0, 2));
       }
       else {
    	   setSucursal(getCodSucursal());
         statement = (String)Util.getMap().get("gestion_09.inst03");
         vWhere.add("String," + getFec_inicio().substring(6, 10) + "-" + getFec_inicio().substring(3, 5) + "-" + getFec_inicio().substring(0, 2));
         vWhere.add("String," + getFec_fin().substring(6, 10) + "-" + getFec_fin().substring(3, 5) + "-" + getFec_fin().substring(0, 2));
         vWhere.add("String," + getSucursal());
         vWhere.add("String," + getFec_inicio().substring(6, 10) + "-" + getFec_inicio().substring(3, 5) + "-" + getFec_inicio().substring(0, 2));
         vWhere.add("String," + getFec_fin().substring(6, 10) + "-" + getFec_fin().substring(3, 5) + "-" + getFec_fin().substring(0, 2));
         vWhere.add("String," + getSucursal());
       }
 
       vRes = consulta(dataSource, statement, vWhere, 14);
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
       objDown.enviarArchivoNew(this.vctExpHead, this.vctDetalles, this.vctExpHeadNota);
     setMensaje(DownFile.getMensaje());
     return exportFile;
   }
 
   public Vector getPaginacion(DataSource dataSource, String strAra)
   {
     Vector vRes = new Vector();
     int maxIndice = getIndice() + getRegistrosPorBloque() + 1;
     String vInstruccion = "";
     Vector vWhere = new Vector();
     if (conecta(dataSource)) {
       if (getCodSucursal().equals("0")) {
         vInstruccion = "gestion_26.inst04";
         vWhere.add("String," + getFec_inicio().substring(6, 10) + "-" + getFec_inicio().substring(3, 5) + "-" + getFec_inicio().substring(0, 2));
         vWhere.add("String," + getFec_fin().substring(6, 10) + "-" + getFec_fin().substring(3, 5) + "-" + getFec_fin().substring(0, 2));
         vWhere.add("String," + getFec_inicio().substring(6, 10) + "-" + getFec_inicio().substring(3, 5) + "-" + getFec_inicio().substring(0, 2));
         vWhere.add("String," + getFec_fin().substring(6, 10) + "-" + getFec_fin().substring(3, 5) + "-" + getFec_fin().substring(0, 2));
         vWhere.add("Int," + Integer.toString(getIndice()));
         vWhere.add("Int," + Integer.toString(maxIndice));
       } else {
    	 setSucursal(getCodSucursal());
         vInstruccion = "gestion_03.inst01";
         vWhere.add("String," + getFec_inicio().substring(6, 10) + "-" + getFec_inicio().substring(3, 5) + "-" + getFec_inicio().substring(0, 2));
         vWhere.add("String," + getFec_fin().substring(6, 10) + "-" + getFec_fin().substring(3, 5) + "-" + getFec_fin().substring(0, 2));
         vWhere.add("String," + getSucursal());
         vWhere.add("String," + getFec_inicio().substring(6, 10) + "-" + getFec_inicio().substring(3, 5) + "-" + getFec_inicio().substring(0, 2));
         vWhere.add("String," + getFec_fin().substring(6, 10) + "-" + getFec_fin().substring(3, 5) + "-" + getFec_fin().substring(0, 2));
         vWhere.add("String," + getSucursal());
         vWhere.add("Int," + Integer.toString(getIndice()));
         vWhere.add("Int," + Integer.toString(maxIndice));
       }
       try
       {
         consultaRst(dataSource, vInstruccion, vWhere);
         vRes = filtra(getRst());
       } catch (Exception e) {
         Log.write("Error consulta rst:get paginacion  " + e.getMessage());
       } finally {
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
 
     if (conecta(dataSource)) {
       Vector vWhere = new Vector();
 
       if (getCodSucursal().equals("0")) {
         statement = (String)Util.getMap().get("gestion_26.inst03");
         vWhere.add("String," + getFec_inicio().substring(6, 10) + "-" + getFec_inicio().substring(3, 5) + "-" + getFec_inicio().substring(0, 2));
         vWhere.add("String," + getFec_fin().substring(6, 10) + "-" + getFec_fin().substring(3, 5) + "-" + getFec_fin().substring(0, 2));
         vWhere.add("String," + getFec_inicio().substring(6, 10) + "-" + getFec_inicio().substring(3, 5) + "-" + getFec_inicio().substring(0, 2));
         vWhere.add("String," + getFec_fin().substring(6, 10) + "-" + getFec_fin().substring(3, 5) + "-" + getFec_fin().substring(0, 2));
       }
       else {
    	 setSucursal(getCodSucursal());
         statement = (String)Util.getMap().get("gestion_07.inst03");
         vWhere.add("String," + getFec_inicio().substring(6, 10) + "-" + getFec_inicio().substring(3, 5) + "-" + getFec_inicio().substring(0, 2));
         vWhere.add("String," + getFec_fin().substring(6, 10) + "-" + getFec_fin().substring(3, 5) + "-" + getFec_fin().substring(0, 2));
         vWhere.add("String," + getSucursal());
         vWhere.add("String," + getFec_inicio().substring(6, 10) + "-" + getFec_inicio().substring(3, 5) + "-" + getFec_inicio().substring(0, 2));
         vWhere.add("String," + getFec_fin().substring(6, 10) + "-" + getFec_fin().substring(3, 5) + "-" + getFec_fin().substring(0, 2));
         vWhere.add("String," + getSucursal());
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
 
   public int getTotalPaginas()
   {
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
 
   private void setSucursal(String suc){
	   if("75".equalsIgnoreCase(suc)){
		   sucursal = "Fonocompras";
	   }else if("39".equalsIgnoreCase(suc)){
		   sucursal = "Tienda Virtual";
	   }else if("1".equalsIgnoreCase(suc)){
		   sucursal = "TV Mobile";
	   }
   }
   private String getSucursal(){
	   
	   return sucursal;
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
         for (int i = 1; i <= 14; i++) {
           if (i == 4) {
             String creacion = "";
             String fecha = "";
             String year = "";
             String mes = "";
             String dia = "";
             String hora = "";
             creacion = rst.getString(i);
 
             year = creacion.substring(0, 4);
             mes = creacion.substring(5, 7);
             dia = creacion.substring(8, 10);
             hora = creacion.substring(11, 16);
             //fecha = dia + "" + year + " " + hora; corregido 20140106 GPA
             fecha = dia + "" + mes + "" + year + " " + hora;
             
             campos.add(fecha);
           }
           else if (i == 5) {
             String confirma = "";
             String fecha = "";
             String year = "";
             String mes = "";
             String dia = "";
             String hora = "";
             confirma = rst.getString(i);
 
             year = confirma.substring(0, 4);
             mes = confirma.substring(5, 7);
             dia = confirma.substring(8, 10);
             hora = confirma.substring(11, 16);
             //fecha = dia + "" + year + " " + hora; corregido 20140106 GPA
             fecha = dia + "" + mes + "" + year + " " + hora;
 
             campos.add(fecha);
           }
           else if (i == 7) {
             String boleta = "";
             String fecha = "";
             String year = "";
             String mes = "";
             String dia = "";
             boleta = rst.getString(i);
             if (boleta.length() > 8) {
               year = boleta.substring(0, 4);
               mes = boleta.substring(5, 7);
               dia = boleta.substring(8, 10);
               //fecha = dia + "" + year; corregido 20140106 GPA 
               fecha = dia + "" + mes + "" + year;
               
               campos.add(fecha);
             }
             else
             {
               campos.add(rst.getString(i));
             }
           }
           else if (i == 3) {
             int valor = Integer.parseInt(rst.getString(i), 10);
             switch (valor) {
             case 0:
               if (Integer.parseInt(rst.getString(15)) == 999999) {
                 campos.add(messages.getMessage("ventas.estado.99"));
               }
               else
               {
                 campos.add(messages.getMessage("ventas.estado.0"));
               }
 
               break;
             case 1:
               campos.add(messages.getMessage("ventas.estado.1"));
               break;
             case 2:
               campos.add(messages.getMessage("ventas.estado.2"));
               break;
             case 3:
               campos.add(messages.getMessage("ventas.estado.3"));
               break;
             case 4:
               campos.add(messages.getMessage("ventas.estado.4"));
               break;
             case 7:
               campos.add(messages.getMessage("ventas.estado.7"));
               break;
             case 8:
               campos.add(messages.getMessage("ventas.estado.8"));
               break;
             case 5:
             case 6:
             default:
               campos.add(messages.getMessage("ventas.estado.default")); break;
             }
           }
           else {
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
       Log.write("Error consulta rst:  " + e.getMessage());
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
 
   public String getHayDatosExportar()
   {
     return this.hayDatosExportar;
   }
 
   public Vector getVctExpHead()
   {
     return this.vctExpHead;
   }
 
   public Vector getVctExpHeadNota()
   {
     return this.vctExpHeadNota;
   }
 
   public Vector getVctExportar()
   {
     return this.vctExportar;
   }
 
   public void setHayDatosExportar(String string)
   {
     this.hayDatosExportar = string;
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
 }

/* Location:           C:\sitios\GestionTV_Ripley\trunk\docs\01 Requerimiento\Fuentes Gestión TV\GestionTV-WC7\WEB-INF\classes\
 * Qualified Name:     cl.ripley.GestionTV.struts.bean.TodasVentasBean
 * JD-Core Version:    0.6.2
 */