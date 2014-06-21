/*     */ package cl.ripley.GestionTV.struts.form;
/*     */ 
/*     */ import java.util.Vector;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ 
/*     */ public class CargaVentasWCForm extends ActionForm
/*     */ {
/*     */   private String accion;
/*  20 */   private Vector vctDetalles = new Vector();
/*     */ 
/*  22 */   private int contador = 0;
/*  23 */   private String flagDatosBD = "si";
/*     */   private String hayDatos;
/*     */   private String hayDatosExportar;
/*     */   private String hayProximoBloque;
/*     */   private int indice;
/*  28 */   private Vector listaPagina = new Vector();
/*     */   private String mensaje;
/*     */   private int nroBloque;
/*     */   private int registrosPorBloque;
/*  32 */   private int totalPaginas = 0;
/*     */   private int totalRegistros;
/*     */   private String exportFile;
/*     */   private String vctExpHead;
/*     */   private String numOrden;
/*     */ 
/*     */   public String getAccion()
/*     */   {
/*  41 */     return this.accion;
/*     */   }
/*     */ 
/*     */   public void setAccion(String string)
/*     */   {
/*  46 */     this.accion = string;
/*     */   }
/*     */ 
/*     */   public Vector getVctDetalles()
/*     */   {
/*  51 */     return this.vctDetalles;
/*     */   }
/*     */ 
/*     */   public void setVctDetalles(Vector vVector)
/*     */   {
/*  56 */     this.vctDetalles = vVector;
/*     */   }
/*     */ 
/*     */   public void reset(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/*     */   }
/*     */ 
/*     */   public int getContador()
/*     */   {
/*  68 */     return this.contador;
/*     */   }
/*     */ 
/*     */   public String getHayDatos()
/*     */   {
/*  73 */     return this.hayDatos;
/*     */   }
/*     */ 
/*     */   public String getHayProximoBloque()
/*     */   {
/*  78 */     return this.hayProximoBloque;
/*     */   }
/*     */ 
/*     */   public int getIndice()
/*     */   {
/*  83 */     return this.indice;
/*     */   }
/*     */ 
/*     */   public Vector getListaPagina()
/*     */   {
/*  88 */     return this.listaPagina;
/*     */   }
/*     */ 
/*     */   public int getNroBloque() {
/*  92 */     return this.nroBloque;
/*     */   }
/*     */ 
/*     */   public int getRegistrosPorBloque()
/*     */   {
/*  97 */     return this.registrosPorBloque;
/*     */   }
/*     */ 
/*     */   public int getTotalRegistros()
/*     */   {
/* 102 */     return this.totalRegistros;
/*     */   }
/*     */ 
/*     */   public void setContador(int i)
/*     */   {
/* 107 */     this.contador = i;
/*     */   }
/*     */ 
/*     */   public void setHayDatos(String string)
/*     */   {
/* 112 */     this.hayDatos = string;
/*     */   }
/*     */ 
/*     */   public void setHayProximoBloque(String string) {
/* 116 */     this.hayProximoBloque = string;
/*     */   }
/*     */ 
/*     */   public void setIndice(int i)
/*     */   {
/* 121 */     this.indice = i;
/*     */   }
/*     */ 
/*     */   public void setListaPagina(Vector vector) {
/* 125 */     this.listaPagina = vector;
/*     */   }
/*     */ 
/*     */   public void setNroBloque(int i) {
/* 129 */     this.nroBloque = i;
/*     */   }
/*     */ 
/*     */   public void setRegistrosPorBloque(int i) {
/* 133 */     this.registrosPorBloque = i;
/*     */   }
/*     */ 
/*     */   public void setTotalRegistros(int i) {
/* 137 */     this.totalRegistros = i;
/*     */   }
/*     */ 
/*     */   public String getMensaje() {
/* 141 */     return this.mensaje;
/*     */   }
/*     */ 
/*     */   public void setMensaje(String string) {
/* 145 */     this.mensaje = string;
/*     */   }
/*     */ 
/*     */   public int getTotalPaginas()
/*     */   {
/* 150 */     return this.totalPaginas;
/*     */   }
/*     */ 
/*     */   public void setTotalPaginas(int i) {
/* 154 */     this.totalPaginas = i;
/*     */   }
/*     */ 
/*     */   public String getFlagDatosBD()
/*     */   {
/* 159 */     return this.flagDatosBD;
/*     */   }
/*     */ 
/*     */   public void setFlagDatosBD(String string) {
/* 163 */     this.flagDatosBD = string;
/*     */   }
/*     */ 
/*     */   public String getExportFile()
/*     */   {
/* 168 */     return this.exportFile;
/*     */   }
/*     */ 
/*     */   public String getVctExpHead()
/*     */   {
/* 175 */     return this.vctExpHead;
/*     */   }
/*     */ 
/*     */   public void setExportFile(String string)
/*     */   {
/* 182 */     this.exportFile = string;
/*     */   }
/*     */ 
/*     */   public void setVctExpHead(String string)
/*     */   {
/* 189 */     this.vctExpHead = string;
/*     */   }
/*     */ 
/*     */   public String getHayDatosExportar()
/*     */   {
/* 196 */     return this.hayDatosExportar;
/*     */   }
/*     */ 
/*     */   public void setHayDatosExportar(String string)
/*     */   {
/* 203 */     this.hayDatosExportar = string;
/*     */   }
/*     */ 
/*     */   public String getNumOrden()
/*     */   {
/* 208 */     return this.numOrden;
/*     */   }
/*     */ 
/*     */   public void setNumOrden(String numOrden)
/*     */   {
/* 213 */     this.numOrden = numOrden;
/*     */   }
/*     */ }

/* Location:           C:\sitios\GestionTV_Ripley\trunk\docs\01 Requerimiento\Fuentes Gestión TV\GestionTV-WC7\WEB-INF\classes\
 * Qualified Name:     cl.ripley.GestionTV.struts.form.CargaVentasWCForm
 * JD-Core Version:    0.6.2
 */