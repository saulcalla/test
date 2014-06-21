 package cl.ripley.GestionTV.struts.bean;
 
 import cl.ripley.GestionTV.comun.Archivo;
 import cl.ripley.GestionTV.comun.Log;
 import cl.ripley.GestionTV.oem.OEMasociaciones;
 import cl.ripley.GestionTV.oem.OEMbundles;
 import cl.ripley.GestionTV.oem.OEMcatalogos;
 import cl.ripley.GestionTV.oem.OEMclientescar;
 import cl.ripley.GestionTV.oem.OEMmuestralog;
 import cl.ripley.GestionTV.oem.OEMproductos;
 import cl.ripley.GestionTV.oem.OEMpromociones;
 import cl.ripley.GestionTV.oem.OEMzonas;
 import java.util.Calendar;
 import java.util.Vector;
 import org.apache.struts.util.MessageResources;
 
 public class CargasBean extends Archivo
 {
   String tipo = "";
   String txt = "";
   private String hayProximoBloque;
   private String numeroPagina;
   private int totalPaginas;
   private Vector listaPagina = new Vector();
   private Vector vctDetalles;
   private int indice;
   private String estado1;
   private String estado2;
   private String estado3;
   private String estado4;
   private String estado5;
   private String estado6;
   private String estado7;
   private String estado8;
   private String fec1;
   private String fec2;
   private String fec3;
   private String fec4;
   private String fec5;
   private String fec6;
   private String fec7;
   private String fec8;
   private String hayDatos;
   private String fechacarga = "";
   private String mensaje = "";
 
   private Vector vctExpHead = new Vector();
 
   protected static MessageResources messages = MessageResources.getMessageResources("cl.ripley.GestionTV.struts.msgGestionTV");
 
   public Vector llenaVector() {
     setTxt(getTipo());
     String path = messages.getMessage("pathDirTxt");
     String fName = "";
     Vector vctPagina = new Vector();
     try
     {
       Vector vctTmp = new Vector();
 
       if (getTipo().equals("ARCHIVO_PROD"))
       {
         if (getNumeroPagina().equals(""))
         {
           vctPagina = OEMproductos.CargaPaginas("1");
         }
         else vctPagina = OEMproductos.CargaPaginas(getNumeroPagina());
 
         if (vctPagina.size() > 0) {
           Vector v = new Vector();
           setTotalPaginas(OEMproductos.getTotalPaginas());
           int j = 0;
           for (j = 1; j <= getTotalPaginas(); j++) {
             v.add(Integer.toString(j));
           }
           this.listaPagina = v;
           setHayDatos("si");
           setHayProximoBloque(OEMproductos.getHayProximoBloque());
         }
         else {
           setHayDatos("no");
         }
 
       }
 
       if (getTipo().equals("ARCHIVO_CATALOGO"))
       {
         if (getNumeroPagina().equals(""))
         {
           vctPagina = OEMcatalogos.CargaPaginas("1");
         }
         else vctPagina = OEMcatalogos.CargaPaginas(getNumeroPagina());
 
         if (vctPagina.size() > 0) {
           Vector v = new Vector();
           setTotalPaginas(OEMcatalogos.getTotalPaginas());
           int j = 0;
           for (j = 1; j <= getTotalPaginas(); j++) {
             v.add(Integer.toString(j));
           }
           this.listaPagina = v;
           setHayDatos("si");
           setHayProximoBloque(OEMcatalogos.getHayProximoBloque());
         }
         else {
           setHayDatos("no");
         }
 
       }
 
       if (getTipo().equals("ARCHIVO_ZONA"))
       {
         if (getNumeroPagina().equals(""))
         {
           vctPagina = OEMzonas.CargaPaginas("1");
         }
         else vctPagina = OEMzonas.CargaPaginas(getNumeroPagina());
 
         if (vctPagina.size() > 0) {
           Vector v = new Vector();
           setTotalPaginas(OEMzonas.getTotalPaginas());
           int j = 0;
           for (j = 1; j <= getTotalPaginas(); j++) {
             v.add(Integer.toString(j));
           }
           this.listaPagina = v;
           setHayDatos("si");
           setHayProximoBloque(OEMzonas.getHayProximoBloque());
         }
         else {
           setHayDatos("no");
         }
 
       }
 
       if (getTipo().equals("ARCHIVO_PROMOCION"))
       {
         if (getNumeroPagina().equals(""))
         {
           vctPagina = OEMpromociones.CargaPaginas("1");
         }
         else vctPagina = OEMpromociones.CargaPaginas(getNumeroPagina());
 
         if (vctPagina.size() > 0) {
           Vector v = new Vector();
           setTotalPaginas(OEMpromociones.getTotalPaginas());
           int j = 0;
           for (j = 1; j <= getTotalPaginas(); j++) {
             v.add(Integer.toString(j));
           }
           this.listaPagina = v;
           setHayDatos("si");
           setHayProximoBloque(OEMpromociones.getHayProximoBloque());
         }
         else {
           setHayDatos("no");
         }
 
       }
 
       if (getTipo().equals("ARCHIVO_ASOCIACION"))
       {
         if (getNumeroPagina().equals(""))
         {
           vctPagina = OEMasociaciones.CargaPaginas("1");
         }
         else vctPagina = OEMasociaciones.CargaPaginas(getNumeroPagina());
 
         if (vctPagina.size() > 0) {
           Vector v = new Vector();
           setTotalPaginas(OEMasociaciones.getTotalPaginas());
           int j = 0;
           for (j = 1; j <= getTotalPaginas(); j++) {
             v.add(Integer.toString(j));
           }
           this.listaPagina = v;
           setHayDatos("si");
           setHayProximoBloque(OEMasociaciones.getHayProximoBloque());
         }
         else {
           setHayDatos("no");
         }
 
       }
 
       if (getTipo().equals("ARCHIVO_BUNDLES"))
       {
         if (getNumeroPagina().equals(""))
         {
           vctPagina = OEMbundles.CargaPaginas("1");
         }
         else vctPagina = OEMbundles.CargaPaginas(getNumeroPagina());
 
         if (vctPagina.size() > 0) {
           Vector v = new Vector();
           setTotalPaginas(OEMbundles.getTotalPaginas());
           int j = 0;
           for (j = 1; j <= getTotalPaginas(); j++) {
             v.add(Integer.toString(j));
           }
           this.listaPagina = v;
           setHayDatos("si");
           setHayProximoBloque(OEMbundles.getHayProximoBloque());
         }
         else {
           setHayDatos("no");
         }
 
       }
 
       if (getTipo().equals("ARCHIVO_LOG"))
       {
         if (getNumeroPagina().equals(""))
           vctPagina = OEMmuestralog.CargaPaginas("1");
         else {
           vctPagina = OEMmuestralog.CargaPaginas(getNumeroPagina());
         }
         if (vctPagina.size() > 0) {
           Vector v = new Vector();
           setTotalPaginas(OEMmuestralog.getTotalPaginas());
           int j = 0;
           for (j = 1; j <= getTotalPaginas(); j++) {
             v.add(Integer.toString(j));
           }
           this.listaPagina = v;
           setHayDatos("si");
           setHayProximoBloque(OEMmuestralog.getHayProximoBloque());
         } else {
           setHayDatos("no");
         }
       }
       if (getTipo().equals("ARCHIVO_CLIENTESCAR"))
       {
         if (getNumeroPagina().equals(""))
           vctPagina = OEMclientescar.CargaPaginas("1");
         else {
           vctPagina = OEMclientescar.CargaPaginas(getNumeroPagina());
         }
         if (vctPagina.size() > 0) {
           Vector v = new Vector();
           setTotalPaginas(OEMclientescar.getTotalPaginas());
           int j = 0;
           for (j = 1; j <= getTotalPaginas(); j++) {
             v.add(Integer.toString(j));
           }
           this.listaPagina = v;
           setHayDatos("si");
           setHayProximoBloque(OEMclientescar.getHayProximoBloque());
         } else {
           setHayDatos("no");
         }
       }
     }
     catch (Exception e)
     {
       Log.write("ERROR " + e.toString());
     }
     return vctPagina;
   }
 
   public Vector llenaVectorExportar()
   {
     setTxt(getTipo());
     String path = messages.getMessage("pathDirTxt");
     String fName = "";
     Vector vctPagina = new Vector();
     try
     {
       Vector vctTmp = new Vector();
 
       if (getTipo().equals("ARCHIVO_PROD"))
       {
         if (getNumeroPagina().equals("")) {
           vctPagina = OEMproductos.getVectorExportar();
         }
         if (vctPagina.size() > 0)
           setHayDatos("si");
         else {
           setHayDatos("no");
         }
       }
 
       if (getTipo().equals("ARCHIVO_CATALOGO"))
       {
         if (getNumeroPagina().equals("")) {
           vctPagina = OEMcatalogos.getVectorExportar();
         }
 
         if (vctPagina.size() > 0)
           setHayDatos("si");
         else {
           setHayDatos("no");
         }
 
       }
 
       if (getTipo().equals("ARCHIVO_ZONA"))
       {
         if (getNumeroPagina().equals("")) {
           vctPagina = OEMzonas.getVectorExportar();
         }
 
         if (vctPagina.size() > 0)
           setHayDatos("si");
         else {
           setHayDatos("no");
         }
 
       }
 
       if (getTipo().equals("ARCHIVO_PROMOCION"))
       {
         if (getNumeroPagina().equals("")) {
           vctPagina = OEMpromociones.getVectorExportar();
         }
 
         if (vctPagina.size() > 0)
           setHayDatos("si");
         else {
           setHayDatos("no");
         }
 
       }
 
       if (getTipo().equals("ARCHIVO_ASOCIACION"))
       {
         if (getNumeroPagina().equals("")) {
           vctPagina = OEMasociaciones.getVectorExportar();
         }
 
         if (vctPagina.size() > 0)
           setHayDatos("si");
         else {
           setHayDatos("no");
         }
 
       }
 
       if (getTipo().equals("ARCHIVO_BUNDLES"))
       {
         if (getNumeroPagina().equals("")) {
           vctPagina = OEMbundles.getVectorExportar();
         }
 
         if (vctPagina.size() > 0)
           setHayDatos("si");
         else {
           setHayDatos("no");
         }
 
       }
 
       if (getTipo().equals("ARCHIVO_LOG"))
       {
         if (getNumeroPagina().equals("")) {
           vctPagina = OEMmuestralog.getVectorExportar();
         }
 
         if (vctPagina.size() > 0)
           setHayDatos("si");
         else {
           setHayDatos("no");
         }
       }
       if (getTipo().equals("ARCHIVO_CLIENTESCAR"))
       {
         if (getNumeroPagina().equals("")) {
           vctPagina = OEMclientescar.getVectorExportar();
         }
         if (vctPagina.size() > 0)
           setHayDatos("si");
         else {
           setHayDatos("no");
         }
       }
     }
     catch (Exception e)
     {
       Log.write("ERROR " + e.toString());
     }
     return vctPagina;
   }
 
   public String fechadecarga()
   {
     Calendar date = Calendar.getInstance();
 
     int ddaux = date.get(5);
     String ddaux2;
     if (ddaux < 10)
       ddaux2 = "0" + ddaux;
     else {
       ddaux2 = "" + ddaux;
     }
 
     int dmaux = date.get(2);
     dmaux++;
     String dmaux2;
     if (dmaux < 10)
       dmaux2 = "0" + dmaux;
     else {
       dmaux2 = "" + dmaux;
     }
 
     int dhaux = date.get(11) + 1;
     String dhaux2;
     if (dhaux < 10)
       dhaux2 = "0" + dhaux;
     else {
       dhaux2 = "" + dhaux;
     }
 
     int dnaux = date.get(12);
     String dnaux2;
     if (dnaux < 10)
       dnaux2 = "0" + dnaux;
     else {
       dnaux2 = "" + dnaux;
     }
 
     String fechaFormatoDDMMYYYY = ddaux2 + "/" + 
       dmaux2 + "/" + 
       date.get(1) + " " + 
       dhaux2 + ":" + 
       dnaux2;
     return fechaFormatoDDMMYYYY;
   }
 
   public void cargaOEM() {
     setTxt(getTipo());
     String path = messages.getMessage("pathDirTxt");
     String fName = "";
     try
     {
       Vector vctTmp = new Vector();
 
       if (getTipo().equals("ARCHIVO_PROD")) {
         fName = messages.getMessage("ARCHIVO_PROD");
         vctTmp = txtToVector(path, fName);
         OEMproductos.CargaTodasPaginasExportar(vctTmp);
         OEMproductos.CargaTodasPaginasBD(vctTmp);
         OEMproductos.setFechacarga(fechadecarga());
         setFec1(OEMproductos.getFechacarga());
         if (OEMproductos.getHayDatos().equals("si"))
           setEstado1("1");
         else {
           setEstado1("0");
         }
       }
       if (getTipo().equals("ARCHIVO_CATALOGO"))
       {
         fName = messages.getMessage("ARCHIVO_CATALOGO");
         vctTmp = txtToVector(path, fName);
         OEMcatalogos.CargaTodasPaginasExportar(vctTmp);
         OEMcatalogos.CargaTodasPaginasBD(vctTmp);
         OEMcatalogos.setFechacarga(fechadecarga());
         setFec2(OEMcatalogos.getFechacarga());
         if (OEMcatalogos.getHayDatos().equals("si"))
           setEstado2("1");
         else {
           setEstado2("0");
         }
       }
 
       if (getTipo().equals("ARCHIVO_ZONA")) {
         fName = messages.getMessage("ARCHIVO_ZONA");
         vctTmp = txtToVector(path, fName);
         OEMzonas.CargaTodasPaginasExportar(vctTmp);
         OEMzonas.CargaTodasPaginasBD(vctTmp);
         OEMzonas.setFechacarga(fechadecarga());
         setFec5(OEMzonas.getFechacarga());
         if (OEMzonas.getHayDatos().equals("si"))
           setEstado5("1");
         else {
           setEstado5("0");
         }
       }
 
       if (getTipo().equals("ARCHIVO_PROMOCION")) {
         fName = messages.getMessage("ARCHIVO_PROMOCION");
         vctTmp = txtToVector(path, fName);
         OEMpromociones.CargaTodasPaginasExportar(vctTmp);
         OEMpromociones.CargaTodasPaginasBD(vctTmp);
         OEMpromociones.setFechacarga(fechadecarga());
         setFec3(OEMpromociones.getFechacarga());
         if (OEMpromociones.getHayDatos().equals("si"))
           setEstado3("1");
         else {
           setEstado3("0");
         }
       }
 
       if (getTipo().equals("ARCHIVO_ASOCIACION")) {
         fName = messages.getMessage("ARCHIVO_ASOCIACION");
         vctTmp = txtToVector(path, fName);
         OEMasociaciones.CargaTodasPaginasExportar(vctTmp);
         OEMasociaciones.CargaTodasPaginasBD(vctTmp);
         OEMasociaciones.setFechacarga(fechadecarga());
         setFec4(OEMasociaciones.getFechacarga());
         if (OEMasociaciones.getHayDatos().equals("si"))
           setEstado4("1");
         else {
           setEstado4("0");
         }
       }
 
       if (getTipo().equals("ARCHIVO_BUNDLES")) {
         fName = messages.getMessage("ARCHIVO_BUNDLES");
         vctTmp = txtToVector(path, fName);
         OEMbundles.CargaTodasPaginasExportar(vctTmp);
         OEMbundles.CargaTodasPaginasBD(vctTmp);
         OEMbundles.setFechacarga(fechadecarga());
         setFec6(OEMbundles.getFechacarga());
         if (OEMbundles.getHayDatos().equals("si"))
           setEstado6("1");
         else {
           setEstado6("0");
         }
       }
 
       if (getTipo().equals("ARCHIVO_LOG"))
       {
         fName = messages.getMessage("ARCHIVO_LOG");
         vctTmp = txtToVector(path, fName);
         OEMmuestralog.CargaTodasPaginasExportar(vctTmp);
         OEMmuestralog.CargaTodasPaginasBD(vctTmp);
         OEMmuestralog.setFechacarga(fechadecarga());
         setfec7(OEMmuestralog.getFechacarga());
         if (OEMmuestralog.getHayDatos().equals("si"))
           setestado7("1");
         else {
           setestado7("0");
         }
 
       }
 
       if (getTipo().equals("ARCHIVO_CLIENTESCAR"))
       {
         fName = messages.getMessage("ARCHIVO_CLIENTESCAR");
         vctTmp = txtToVector(path, fName);
         OEMclientescar.CargaTodasPaginasExportar(vctTmp);
         OEMclientescar.CargaTodasPaginasBD(vctTmp);
         OEMclientescar.setFechacarga(fechadecarga());
         setFec8(OEMclientescar.getFechacarga());
         if (OEMclientescar.getHayDatos().equals("si"))
           setEstado8("1");
         else
           setEstado8("0");
       }
     }
     catch (Exception e)
     {
       Log.write("ERROR " + e.toString());
     }
   }
 
   public void consultaOEM()
   {
     setFec1(OEMproductos.getFechacarga());
     if (OEMproductos.getHayDatos().equals("si"))
       setEstado1("1");
     else {
       setEstado1("0");
     }
 
     setFec2(OEMcatalogos.getFechacarga());
     if (OEMcatalogos.getHayDatos().equals("si"))
       setEstado2("1");
     else {
       setEstado2("0");
     }
 
     setFec5(OEMzonas.getFechacarga());
     if (OEMzonas.getHayDatos().equals("si"))
       setEstado5("1");
     else {
       setEstado5("0");
     }
 
     setFec3(OEMpromociones.getFechacarga());
     if (OEMpromociones.getHayDatos().equals("si"))
       setEstado3("1");
     else {
       setEstado3("0");
     }
 
     setFec4(OEMasociaciones.getFechacarga());
     if (OEMasociaciones.getHayDatos().equals("si"))
       setEstado4("1");
     else {
       setEstado4("0");
     }
 
     setFec6(OEMbundles.getFechacarga());
     if (OEMbundles.getHayDatos().equals("si"))
       setEstado6("1");
     else {
       setEstado6("0");
     }
     setfec7(OEMmuestralog.getFechacarga());
     if (OEMmuestralog.getHayDatos().equals("si"))
       setestado7("1");
     else {
       setestado7("0");
     }
     setfec7(OEMclientescar.getFechacarga());
     if (OEMclientescar.getHayDatos().equals("si"))
       setEstado8("1");
     else
       setEstado8("0");
   }
 
   public String getTipo()
   {
     return this.tipo;
   }
 
   public void setTipo(String string)
   {
     this.tipo = string;
   }
 
   public String getTxt()
   {
     return this.txt;
   }
 
   public void setTxt(String string)
   {
     this.txt = string;
   }
 
   public String getHayProximoBloque()
   {
     return this.hayProximoBloque;
   }
 
   public int getIndice()
   {
     return this.indice;
   }
 
   public Vector getListaPagina()
   {
     return this.listaPagina;
   }
 
   public String getNumeroPagina()
   {
     return this.numeroPagina;
   }
 
   public int getTotalPaginas()
   {
     return this.totalPaginas;
   }
 
   public void setHayProximoBloque(String string)
   {
     this.hayProximoBloque = string;
   }
 
   public void setIndice(int i)
   {
     this.indice = i;
   }
 
   public void setListaPagina(Vector vector)
   {
     this.listaPagina = vector;
   }
 
   public void setNumeroPagina(String string)
   {
     this.numeroPagina = string;
   }
 
   public void setTotalPaginas(int i)
   {
     this.totalPaginas = i;
   }
 
   public String getHayDatos()
   {
     return this.hayDatos;
   }
 
   public void setHayDatos(String string)
   {
     this.hayDatos = string;
   }
 
   public String getFechacarga()
   {
     return this.fechacarga;
   }
 
   public void setFechacarga(String string)
   {
     this.fechacarga = string;
   }
 
   public String getEstado1()
   {
     return this.estado1;
   }
 
   public String getEstado2()
   {
     return this.estado2;
   }
 
   public String getEstado3()
   {
     return this.estado3;
   }
 
   public String getEstado4()
   {
     return this.estado4;
   }
 
   public String getEstado5()
   {
     return this.estado5;
   }
 
   public String getEstado6()
   {
     return this.estado6;
   }
 
   public String getFec1()
   {
     return this.fec1;
   }
 
   public String getFec2()
   {
     return this.fec2;
   }
 
   public String getFec3()
   {
     return this.fec3;
   }
 
   public String getFec4()
   {
     return this.fec4;
   }
 
   public String getFec5()
   {
     return this.fec5;
   }
 
   public String getFec6()
   {
     return this.fec6;
   }
 
   public Vector getVctDetalles()
   {
     return this.vctDetalles;
   }
 
   public String getMensaje()
   {
     return this.mensaje;
   }
 
   public void setVctDetalles(Vector vector)
   {
     this.vctDetalles = vector;
   }
 
   public void setMensaje(String string)
   {
     this.mensaje = string;
   }
 
   public void setEstado1(String string)
   {
     this.estado1 = string;
   }
 
   public void setEstado2(String string)
   {
     this.estado2 = string;
   }
 
   public void setEstado3(String string)
   {
     this.estado3 = string;
   }
 
   public void setEstado4(String string)
   {
     this.estado4 = string;
   }
 
   public void setEstado5(String string)
   {
     this.estado5 = string;
   }
 
   public void setEstado6(String string)
   {
     this.estado6 = string;
   }
 
   public void setFec1(String string)
   {
     this.fec1 = string;
   }
 
   public void setFec2(String string)
   {
     this.fec2 = string;
   }
 
   public void setFec3(String string)
   {
     this.fec3 = string;
   }
 
   public void setFec4(String string)
   {
     this.fec4 = string;
   }
 
   public void setFec5(String string)
   {
     this.fec5 = string;
   }
 
   public void setFec6(String string)
   {
     this.fec6 = string;
   }
 
   public void setVctExpHead(Vector vector) {
     this.vctExpHead = vector;
   }
 
   public Vector getVctExpHead()
   {
     return this.vctExpHead;
   }
 
   public String getestado7()
   {
     return this.estado7;
   }
 
   public String getfec7()
   {
     return this.fec7;
   }
 
   public void setestado7(String string)
   {
     this.estado7 = string;
   }
 
   public void setfec7(String string)
   {
     this.fec7 = string;
   }
 
   public String getEstado8()
   {
     return this.estado8;
   }
 
   public void setEstado8(String string)
   {
     this.estado8 = string;
   }
 
   public String getFec8()
   {
     return this.fec8;
   }
 
   public void setFec8(String string)
   {
     this.fec8 = string;
   }
 }

/* Location:           C:\sitios\GestionTV_Ripley\trunk\docs\01 Requerimiento\Fuentes Gestión TV\GestionTV-WC7\WEB-INF\classes\
 * Qualified Name:     cl.ripley.GestionTV.struts.bean.CargasBean
 * JD-Core Version:    0.6.2
 */