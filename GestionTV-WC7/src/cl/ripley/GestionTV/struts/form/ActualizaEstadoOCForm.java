 package cl.ripley.GestionTV.struts.form;
 
 import java.util.Collection;
 import java.util.Vector;
 import javax.servlet.http.HttpServletRequest;
 import org.apache.struts.action.ActionForm;
 import org.apache.struts.action.ActionMapping;
 
 public class ActualizaEstadoOCForm extends ActionForm
 {
   private String accion;
   private Vector vctDetalles = new Vector();
   private String fec_inicio;
   private int contador = 0;
   private String flagDatosBD = "si";
   private String hayDatos;
   private String hayDatosExportar;
   private String hayProximoBloque;
   private int indice;
   private Vector listaPagina = new Vector();
   private String mensaje;
   private int nroBloque;
   private int registrosPorBloque;
   private int totalPaginas = 0;
   private int totalRegistros;
   private String exportFile;
   private String vctExpHead;
   private String fec_hasta;
   private String codRegalo;
   private String glosaSucursal;
   private Collection collSucursal;
   private String[] selectSucursal = new String[0];
 
   public String getAccion()
   {
     return this.accion;
   }
 
   public void setAccion(String string)
   {
     this.accion = string;
   }
 
   public Vector getVctDetalles()
   {
     return this.vctDetalles;
   }
 
   public void setVctDetalles(Vector vVector)
   {
     this.vctDetalles = vVector;
   }
 
   public void reset(ActionMapping mapping, HttpServletRequest request)
   {
   }
 
   public String getFec_inicio()
   {
     return this.fec_inicio;
   }
 
   public void setFec_inicio(String string)
   {
     this.fec_inicio = string;
   }
 
   public int getContador()
   {
     return this.contador;
   }
 
   public String getHayDatos()
   {
     return this.hayDatos;
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
 
   public int getNroBloque()
   {
     return this.nroBloque;
   }
 
   public int getRegistrosPorBloque()
   {
     return this.registrosPorBloque;
   }
 
   public int getTotalRegistros()
   {
     return this.totalRegistros;
   }
 
   public void setContador(int i)
   {
     this.contador = i;
   }
 
   public void setHayDatos(String string)
   {
     this.hayDatos = string;
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
 
   public void setNroBloque(int i)
   {
     this.nroBloque = i;
   }
 
   public void setRegistrosPorBloque(int i)
   {
     this.registrosPorBloque = i;
   }
 
   public void setTotalRegistros(int i)
   {
     this.totalRegistros = i;
   }
 
   public String getMensaje()
   {
     return this.mensaje;
   }
 
   public void setMensaje(String string)
   {
     this.mensaje = string;
   }
 
   public int getTotalPaginas()
   {
     return this.totalPaginas;
   }
 
   public void setTotalPaginas(int i)
   {
     this.totalPaginas = i;
   }
 
   public String getFlagDatosBD()
   {
     return this.flagDatosBD;
   }
 
   public void setFlagDatosBD(String string)
   {
     this.flagDatosBD = string;
   }
 
   public String getExportFile()
   {
     return this.exportFile;
   }
 
   public String getVctExpHead()
   {
     return this.vctExpHead;
   }
 
   public void setExportFile(String string)
   {
     this.exportFile = string;
   }
 
   public void setVctExpHead(String string)
   {
     this.vctExpHead = string;
   }
 
   public String getHayDatosExportar()
   {
     return this.hayDatosExportar;
   }
 
   public void setHayDatosExportar(String string)
   {
     this.hayDatosExportar = string;
   }
 
   public Collection getCollSucursal()
   {
     return this.collSucursal;
   }
 
   public void setCollSucursal(Collection collSucursal)
   {
     this.collSucursal = collSucursal;
   }
 
   public String getGlosaSucursal()
   {
     return this.glosaSucursal;
   }
 
   public void setGlosaSucursal(String glosaSucursal)
   {
     this.glosaSucursal = glosaSucursal;
   }
 
   public String[] getSelectSucursal()
   {
     return this.selectSucursal;
   }
 
   public void setSelectSucursal(String[] selectSucursal)
   {
     this.selectSucursal = selectSucursal;
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
 * Qualified Name:     cl.ripley.GestionTV.struts.form.ActualizaEstadoOCForm
 * JD-Core Version:    0.6.2
 */