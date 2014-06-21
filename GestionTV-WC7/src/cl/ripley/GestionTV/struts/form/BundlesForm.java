/*     */ package cl.ripley.GestionTV.struts.form;
/*     */ 
/*     */ import java.util.Vector;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.apache.struts.action.ActionErrors;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ 
/*     */ public class BundlesForm extends ActionForm
/*     */ {
/*     */   private String accion;
/*  20 */   private Vector vctDetalles = new Vector();
/*  21 */   private Vector vctDetTotales = new Vector();
/*     */   private Vector vctPagina;
/*  23 */   private String tipo = "";
/*     */   private String hayDatos;
/*     */   private String hayProximoBloque;
/*     */   private String numeroPagina;
/*     */   private int totalPaginas;
/*  29 */   private Vector listaPagina = new Vector();
/*     */   private int indice;
/*     */   private String vctExpHead;
/*     */   private String exportFile;
/*     */   private String mensaje;
/*     */ 
/*     */   public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/*  46 */     throw new UnsupportedOperationException("Generated method 'validate(...)' not implemented.");
/*     */   }
/*     */ 
/*     */   public void reset(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/*  55 */     this.accion = "";
/*     */   }
/*     */ 
/*     */   public String getAccion()
/*     */   {
/*  64 */     return this.accion;
/*     */   }
/*     */ 
/*     */   public String getHayDatos()
/*     */   {
/*  71 */     return this.hayDatos;
/*     */   }
/*     */ 
/*     */   public String getHayProximoBloque()
/*     */   {
/*  78 */     return this.hayProximoBloque;
/*     */   }
/*     */ 
/*     */   public int getIndice()
/*     */   {
/*  85 */     return this.indice;
/*     */   }
/*     */ 
/*     */   public Vector getListaPagina()
/*     */   {
/*  92 */     return this.listaPagina;
/*     */   }
/*     */ 
/*     */   public String getNumeroPagina()
/*     */   {
/*  99 */     return this.numeroPagina;
/*     */   }
/*     */ 
/*     */   public String getTipo()
/*     */   {
/* 106 */     return this.tipo;
/*     */   }
/*     */ 
/*     */   public int getTotalPaginas()
/*     */   {
/* 113 */     return this.totalPaginas;
/*     */   }
/*     */ 
/*     */   public Vector getVctDetalles()
/*     */   {
/* 120 */     return this.vctDetalles;
/*     */   }
/*     */ 
/*     */   public Vector getVctPagina()
/*     */   {
/* 127 */     return this.vctPagina;
/*     */   }
/*     */ 
/*     */   public void setAccion(String string)
/*     */   {
/* 134 */     this.accion = string;
/*     */   }
/*     */ 
/*     */   public void setHayDatos(String string)
/*     */   {
/* 141 */     this.hayDatos = string;
/*     */   }
/*     */ 
/*     */   public void setHayProximoBloque(String string)
/*     */   {
/* 148 */     this.hayProximoBloque = string;
/*     */   }
/*     */ 
/*     */   public void setIndice(int i)
/*     */   {
/* 155 */     this.indice = i;
/*     */   }
/*     */ 
/*     */   public void setListaPagina(Vector vector)
/*     */   {
/* 162 */     this.listaPagina = vector;
/*     */   }
/*     */ 
/*     */   public void setNumeroPagina(String string)
/*     */   {
/* 169 */     this.numeroPagina = string;
/*     */   }
/*     */ 
/*     */   public void setTipo(String string)
/*     */   {
/* 176 */     this.tipo = string;
/*     */   }
/*     */ 
/*     */   public void setTotalPaginas(int i)
/*     */   {
/* 183 */     this.totalPaginas = i;
/*     */   }
/*     */ 
/*     */   public void setVctDetalles(Vector vector)
/*     */   {
/* 190 */     this.vctDetalles = vector;
/*     */   }
/*     */ 
/*     */   public void setVctPagina(Vector vector)
/*     */   {
/* 197 */     this.vctPagina = vector;
/*     */   }
/*     */ 
/*     */   public String getVctExpHead()
/*     */   {
/* 204 */     return this.vctExpHead;
/*     */   }
/*     */ 
/*     */   public String getExportFile()
/*     */   {
/* 211 */     return this.exportFile;
/*     */   }
/*     */ 
/*     */   public String getMensaje()
/*     */   {
/* 219 */     return this.mensaje;
/*     */   }
/*     */ 
/*     */   public Vector getVctDetTotales()
/*     */   {
/* 224 */     return this.vctDetTotales;
/*     */   }
/*     */ 
/*     */   public void setExportFile(String string)
/*     */   {
/* 232 */     this.exportFile = string;
/*     */   }
/*     */ 
/*     */   public void setVctExpHead(String string)
/*     */   {
/* 239 */     this.vctExpHead = string;
/*     */   }
/*     */ 
/*     */   public void setMensaje(String string)
/*     */   {
/* 246 */     this.mensaje = string;
/*     */   }
/*     */ 
/*     */   public void setVctDetTotales(Vector vector) {
/* 250 */     this.vctDetTotales = vector;
/*     */   }
/*     */ }

/* Location:           C:\sitios\GestionTV_Ripley\trunk\docs\01 Requerimiento\Fuentes Gestión TV\GestionTV-WC7\WEB-INF\classes\
 * Qualified Name:     cl.ripley.GestionTV.struts.form.BundlesForm
 * JD-Core Version:    0.6.2
 */