/*     */ package cl.ripley.GestionTV.struts.form;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.Vector;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ 
/*     */ public class DetalleProductoForm extends ActionForm
/*     */ {
/*     */   private String accion;
/*  20 */   private Vector vctDetalles = new Vector();
/*     */   private String fec_inicio;
/*     */   private String fec_fin;
/*  24 */   private int contador = 0;
/*  25 */   private String flagDatosBD = "si";
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
/*     */   private String codSucursal;
/*     */   private String glosaSucursal;
/*     */   private Collection collSucursal;
/*  43 */   private String[] selectSucursal = new String[0];
/*     */ 
/*  46 */   private String[] chkCodigos = { "01", "02", "03", "04" };
/*     */ 
/*     */   public String getAccion()
/*     */   {
/*  57 */     return this.accion;
/*     */   }
/*     */ 
/*     */   public void setAccion(String string)
/*     */   {
/*  69 */     this.accion = string;
/*     */   }
/*     */ 
/*     */   public Vector getVctDetalles()
/*     */   {
/*  79 */     return this.vctDetalles;
/*     */   }
/*     */ 
/*     */   public void setVctDetalles(Vector vVector)
/*     */   {
/*  91 */     this.vctDetalles = vVector;
/*     */   }
/*     */ 
/*     */   public void reset(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/*     */   }
/*     */ 
/*     */   public String getFec_inicio()
/*     */   {
/* 108 */     return this.fec_inicio;
/*     */   }
/*     */   public String getFec_fin() {
/* 111 */     return this.fec_fin;
/*     */   }
/*     */ 
/*     */   public void setFec_inicio(String string)
/*     */   {
/* 121 */     this.fec_inicio = string;
/*     */   }
/*     */   public void setFec_fin(String string) {
/* 124 */     this.fec_fin = string;
/*     */   }
/*     */ 
/*     */   public int getContador()
/*     */   {
/* 133 */     return this.contador;
/*     */   }
/*     */ 
/*     */   public String getHayDatos()
/*     */   {
/* 142 */     return this.hayDatos;
/*     */   }
/*     */ 
/*     */   public String getHayProximoBloque()
/*     */   {
/* 151 */     return this.hayProximoBloque;
/*     */   }
/*     */ 
/*     */   public int getIndice()
/*     */   {
/* 160 */     return this.indice;
/*     */   }
/*     */ 
/*     */   public Vector getListaPagina()
/*     */   {
/* 169 */     return this.listaPagina;
/*     */   }
/*     */ 
/*     */   public int getNroBloque()
/*     */   {
/* 178 */     return this.nroBloque;
/*     */   }
/*     */ 
/*     */   public int getRegistrosPorBloque()
/*     */   {
/* 187 */     return this.registrosPorBloque;
/*     */   }
/*     */ 
/*     */   public int getTotalRegistros()
/*     */   {
/* 196 */     return this.totalRegistros;
/*     */   }
/*     */ 
/*     */   public void setContador(int i)
/*     */   {
/* 206 */     this.contador = i;
/*     */   }
/*     */ 
/*     */   public void setHayDatos(String string)
/*     */   {
/* 215 */     this.hayDatos = string;
/*     */   }
/*     */ 
/*     */   public void setHayProximoBloque(String string)
/*     */   {
/* 224 */     this.hayProximoBloque = string;
/*     */   }
/*     */ 
/*     */   public void setIndice(int i)
/*     */   {
/* 233 */     this.indice = i;
/*     */   }
/*     */ 
/*     */   public void setListaPagina(Vector vector)
/*     */   {
/* 242 */     this.listaPagina = vector;
/*     */   }
/*     */ 
/*     */   public void setNroBloque(int i)
/*     */   {
/* 251 */     this.nroBloque = i;
/*     */   }
/*     */ 
/*     */   public void setRegistrosPorBloque(int i)
/*     */   {
/* 260 */     this.registrosPorBloque = i;
/*     */   }
/*     */ 
/*     */   public void setTotalRegistros(int i)
/*     */   {
/* 269 */     this.totalRegistros = i;
/*     */   }
/*     */ 
/*     */   public String getMensaje()
/*     */   {
/* 284 */     return this.mensaje;
/*     */   }
/*     */ 
/*     */   public void setMensaje(String string)
/*     */   {
/* 293 */     this.mensaje = string;
/*     */   }
/*     */ 
/*     */   public int getTotalPaginas()
/*     */   {
/* 303 */     return this.totalPaginas;
/*     */   }
/*     */ 
/*     */   public void setTotalPaginas(int i)
/*     */   {
/* 313 */     this.totalPaginas = i;
/*     */   }
/*     */ 
/*     */   public String getFlagDatosBD()
/*     */   {
/* 323 */     return this.flagDatosBD;
/*     */   }
/*     */ 
/*     */   public void setFlagDatosBD(String string)
/*     */   {
/* 332 */     this.flagDatosBD = string;
/*     */   }
/*     */ 
/*     */   public String getExportFile()
/*     */   {
/* 342 */     return this.exportFile;
/*     */   }
/*     */ 
/*     */   public String getVctExpHead()
/*     */   {
/* 349 */     return this.vctExpHead;
/*     */   }
/*     */ 
/*     */   public void setExportFile(String string)
/*     */   {
/* 356 */     this.exportFile = string;
/*     */   }
/*     */ 
/*     */   public void setVctExpHead(String string)
/*     */   {
/* 363 */     this.vctExpHead = string;
/*     */   }
/*     */ 
/*     */   public String getHayDatosExportar()
/*     */   {
/* 370 */     return this.hayDatosExportar;
/*     */   }
/*     */ 
/*     */   public void setHayDatosExportar(String string)
/*     */   {
/* 377 */     this.hayDatosExportar = string;
/*     */   }
/*     */ 
/*     */   public String getCodSucursal()
/*     */   {
/* 385 */     return this.codSucursal;
/*     */   }
/*     */ 
/*     */   public void setCodSucursal(String codSucursal)
/*     */   {
/* 391 */     this.codSucursal = codSucursal;
/*     */   }
/*     */ 
/*     */   public Collection getCollSucursal()
/*     */   {
/* 397 */     return this.collSucursal;
/*     */   }
/*     */ 
/*     */   public void setCollSucursal(Collection collSucursal)
/*     */   {
/* 403 */     this.collSucursal = collSucursal;
/*     */   }
/*     */ 
/*     */   public String getGlosaSucursal()
/*     */   {
/* 409 */     return this.glosaSucursal;
/*     */   }
/*     */ 
/*     */   public void setGlosaSucursal(String glosaSucursal)
/*     */   {
/* 415 */     this.glosaSucursal = glosaSucursal;
/*     */   }
/*     */ 
/*     */   public String[] getSelectSucursal()
/*     */   {
/* 421 */     return this.selectSucursal;
/*     */   }
/*     */ 
/*     */   public void setSelectSucursal(String[] selectSucursal)
/*     */   {
/* 427 */     this.selectSucursal = selectSucursal;
/*     */   }
/*     */ 
/*     */   public String[] getChkCodigos() {
/* 431 */     return this.chkCodigos;
/*     */   }
/*     */ 
/*     */   public void setChkCodigos(String[] chkCodigos) {
/* 435 */     this.chkCodigos = chkCodigos;
/*     */   }
/*     */ }

/* Location:           C:\sitios\GestionTV_Ripley\trunk\docs\01 Requerimiento\Fuentes Gestión TV\GestionTV-WC7\WEB-INF\classes\
 * Qualified Name:     cl.ripley.GestionTV.struts.form.DetalleProductoForm
 * JD-Core Version:    0.6.2
 */