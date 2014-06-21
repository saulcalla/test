/*     */ package cl.ripley.GestionTV.struts.form;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.Vector;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ 
/*     */ public class BusquedaRMCForm extends ActionForm
/*     */ {
/*     */   private String accion;
/*  20 */   private Vector vctDetalles = new Vector();
/*     */   private String fec_inicio;
/*  23 */   private int contador = 0;
/*  24 */   private String flagDatosBD = "si";
/*  25 */   private String actualiza = "no";
/*     */   private String hayDatos;
/*     */   private String hayDatosExportar;
/*     */   private String hayProximoBloque;
/*     */   private int indice;
/*  30 */   private Vector listaPagina = new Vector();
/*     */   private String mensaje;
/*     */   private int nroBloque;
/*     */   private int registrosPorBloque;
/*  34 */   private int totalPaginas = 0;
/*     */   private int totalRegistros;
/*     */   private String exportFile;
/*     */   private String vctExpHead;
/*     */   private String fec_nueva;
/*     */   private String nro_rmc;
/*     */   private String glosaSucursal;
/*     */   private Collection collSucursal;
/*  44 */   private String[] selectSucursal = new String[0];
/*     */ 
/*     */   public String getAccion()
/*     */   {
/*  55 */     return this.accion;
/*     */   }
/*     */ 
/*     */   public void setAccion(String string)
/*     */   {
/*  67 */     this.accion = string;
/*     */   }
/*     */ 
/*     */   public Vector getVctDetalles()
/*     */   {
/*  77 */     return this.vctDetalles;
/*     */   }
/*     */ 
/*     */   public void setVctDetalles(Vector vVector)
/*     */   {
/*  89 */     this.vctDetalles = vVector;
/*     */   }
/*     */ 
/*     */   public void reset(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/*     */   }
/*     */ 
/*     */   public String getFec_inicio()
/*     */   {
/* 106 */     return this.fec_inicio;
/*     */   }
/*     */ 
/*     */   public void setFec_inicio(String string)
/*     */   {
/* 117 */     this.fec_inicio = string;
/*     */   }
/*     */ 
/*     */   public int getContador()
/*     */   {
/* 126 */     return this.contador;
/*     */   }
/*     */ 
/*     */   public String getHayDatos()
/*     */   {
/* 135 */     return this.hayDatos;
/*     */   }
/*     */ 
/*     */   public String getHayProximoBloque()
/*     */   {
/* 144 */     return this.hayProximoBloque;
/*     */   }
/*     */ 
/*     */   public int getIndice()
/*     */   {
/* 153 */     return this.indice;
/*     */   }
/*     */ 
/*     */   public Vector getListaPagina()
/*     */   {
/* 162 */     return this.listaPagina;
/*     */   }
/*     */ 
/*     */   public int getNroBloque()
/*     */   {
/* 171 */     return this.nroBloque;
/*     */   }
/*     */ 
/*     */   public int getRegistrosPorBloque()
/*     */   {
/* 180 */     return this.registrosPorBloque;
/*     */   }
/*     */ 
/*     */   public int getTotalRegistros()
/*     */   {
/* 189 */     return this.totalRegistros;
/*     */   }
/*     */ 
/*     */   public void setContador(int i)
/*     */   {
/* 199 */     this.contador = i;
/*     */   }
/*     */ 
/*     */   public void setHayDatos(String string)
/*     */   {
/* 208 */     this.hayDatos = string;
/*     */   }
/*     */ 
/*     */   public void setHayProximoBloque(String string)
/*     */   {
/* 217 */     this.hayProximoBloque = string;
/*     */   }
/*     */ 
/*     */   public void setIndice(int i)
/*     */   {
/* 226 */     this.indice = i;
/*     */   }
/*     */ 
/*     */   public void setListaPagina(Vector vector)
/*     */   {
/* 235 */     this.listaPagina = vector;
/*     */   }
/*     */ 
/*     */   public void setNroBloque(int i)
/*     */   {
/* 244 */     this.nroBloque = i;
/*     */   }
/*     */ 
/*     */   public void setRegistrosPorBloque(int i)
/*     */   {
/* 253 */     this.registrosPorBloque = i;
/*     */   }
/*     */ 
/*     */   public void setTotalRegistros(int i)
/*     */   {
/* 262 */     this.totalRegistros = i;
/*     */   }
/*     */ 
/*     */   public String getMensaje()
/*     */   {
/* 277 */     return this.mensaje;
/*     */   }
/*     */ 
/*     */   public void setMensaje(String string)
/*     */   {
/* 286 */     this.mensaje = string;
/*     */   }
/*     */ 
/*     */   public int getTotalPaginas()
/*     */   {
/* 296 */     return this.totalPaginas;
/*     */   }
/*     */ 
/*     */   public void setTotalPaginas(int i)
/*     */   {
/* 306 */     this.totalPaginas = i;
/*     */   }
/*     */ 
/*     */   public String getFlagDatosBD()
/*     */   {
/* 316 */     return this.flagDatosBD;
/*     */   }
/*     */ 
/*     */   public void setFlagDatosBD(String string)
/*     */   {
/* 325 */     this.flagDatosBD = string;
/*     */   }
/*     */ 
/*     */   public String getExportFile()
/*     */   {
/* 335 */     return this.exportFile;
/*     */   }
/*     */ 
/*     */   public String getVctExpHead()
/*     */   {
/* 342 */     return this.vctExpHead;
/*     */   }
/*     */ 
/*     */   public void setExportFile(String string)
/*     */   {
/* 349 */     this.exportFile = string;
/*     */   }
/*     */ 
/*     */   public void setVctExpHead(String string)
/*     */   {
/* 356 */     this.vctExpHead = string;
/*     */   }
/*     */ 
/*     */   public String getHayDatosExportar()
/*     */   {
/* 363 */     return this.hayDatosExportar;
/*     */   }
/*     */ 
/*     */   public void setHayDatosExportar(String string)
/*     */   {
/* 370 */     this.hayDatosExportar = string;
/*     */   }
/*     */ 
/*     */   public Collection getCollSucursal()
/*     */   {
/* 379 */     return this.collSucursal;
/*     */   }
/*     */ 
/*     */   public void setCollSucursal(Collection collSucursal)
/*     */   {
/* 385 */     this.collSucursal = collSucursal;
/*     */   }
/*     */ 
/*     */   public String getGlosaSucursal()
/*     */   {
/* 391 */     return this.glosaSucursal;
/*     */   }
/*     */ 
/*     */   public void setGlosaSucursal(String glosaSucursal)
/*     */   {
/* 397 */     this.glosaSucursal = glosaSucursal;
/*     */   }
/*     */ 
/*     */   public String[] getSelectSucursal()
/*     */   {
/* 403 */     return this.selectSucursal;
/*     */   }
/*     */ 
/*     */   public void setSelectSucursal(String[] selectSucursal)
/*     */   {
/* 409 */     this.selectSucursal = selectSucursal;
/*     */   }
/*     */ 
/*     */   public String getNro_rmc() {
/* 413 */     return this.nro_rmc;
/*     */   }
/*     */ 
/*     */   public void setNro_rmc(String nro_rmc) {
/* 417 */     this.nro_rmc = nro_rmc;
/*     */   }
/*     */ 
/*     */   public String getFec_nueva() {
/* 421 */     return this.fec_nueva;
/*     */   }
/*     */ 
/*     */   public void setFec_nueva(String fec_hasta) {
/* 425 */     this.fec_nueva = fec_hasta;
/*     */   }
/*     */ 
/*     */   public String getActualiza() {
/* 429 */     return this.actualiza;
/*     */   }
/*     */ 
/*     */   public void setActualiza(String actualiza) {
/* 433 */     this.actualiza = actualiza;
/*     */   }
/*     */ }

/* Location:           C:\sitios\GestionTV_Ripley\trunk\docs\01 Requerimiento\Fuentes Gestión TV\GestionTV-WC7\WEB-INF\classes\
 * Qualified Name:     cl.ripley.GestionTV.struts.form.BusquedaRMCForm
 * JD-Core Version:    0.6.2
 */