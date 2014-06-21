/*     */ package cl.ripley.GestionTV.struts.form;
/*     */ 
/*     */ import java.util.Vector;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.apache.struts.action.ActionErrors;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ 
/*     */ public class ProductosForm extends ActionForm
/*     */ {
/*     */   private String accion;
/*  21 */   private Vector vctDetalles = new Vector();
/*  22 */   private Vector vctDetTotales = new Vector();
/*     */   private Vector vctPagina;
/*  24 */   private String tipo = "";
/*     */   private String hayDatos;
/*     */   private String hayProximoBloque;
/*     */   private String numeroPagina;
/*     */   private int totalPaginas;
/*  30 */   private Vector listaPagina = new Vector();
/*     */   private int indice;
/*     */   private String vctExpHead;
/*     */   private String exportFile;
/*     */   private String mensaje;
/*     */ 
/*     */   public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/*  47 */     throw new UnsupportedOperationException("Generated method 'validate(...)' not implemented.");
/*     */   }
/*     */ 
/*     */   public void reset(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/*  56 */     this.accion = "";
/*     */   }
/*     */ 
/*     */   public String getAccion()
/*     */   {
/*  64 */     return this.accion;
/*     */   }
/*     */ 
/*     */   public void setAccion(String string)
/*     */   {
/*  71 */     this.accion = string;
/*     */   }
/*     */ 
/*     */   public String getHayDatos()
/*     */   {
/*  78 */     return this.hayDatos;
/*     */   }
/*     */ 
/*     */   public String getHayProximoBloque()
/*     */   {
/*  85 */     return this.hayProximoBloque;
/*     */   }
/*     */ 
/*     */   public int getIndice()
/*     */   {
/*  92 */     return this.indice;
/*     */   }
/*     */ 
/*     */   public Vector getListaPagina()
/*     */   {
/*  99 */     return this.listaPagina;
/*     */   }
/*     */ 
/*     */   public String getNumeroPagina()
/*     */   {
/* 106 */     return this.numeroPagina;
/*     */   }
/*     */ 
/*     */   public String getTipo()
/*     */   {
/* 113 */     return this.tipo;
/*     */   }
/*     */ 
/*     */   public int getTotalPaginas()
/*     */   {
/* 120 */     return this.totalPaginas;
/*     */   }
/*     */ 
/*     */   public Vector getVctDetalles()
/*     */   {
/* 127 */     return this.vctDetalles;
/*     */   }
/*     */ 
/*     */   public Vector getVctPagina()
/*     */   {
/* 134 */     return this.vctPagina;
/*     */   }
/*     */ 
/*     */   public String getVctExpHead()
/*     */   {
/* 142 */     return this.vctExpHead;
/*     */   }
/*     */ 
/*     */   public String getExportFile()
/*     */   {
/* 149 */     return this.exportFile;
/*     */   }
/*     */ 
/*     */   public String getMensaje()
/*     */   {
/* 157 */     return this.mensaje;
/*     */   }
/*     */ 
/*     */   public Vector getVctDetTotales()
/*     */   {
/* 162 */     return this.vctDetTotales;
/*     */   }
/*     */ 
/*     */   public void setExportFile(String string)
/*     */   {
/* 170 */     this.exportFile = string;
/*     */   }
/*     */ 
/*     */   public void setHayDatos(String string)
/*     */   {
/* 179 */     this.hayDatos = string;
/*     */   }
/*     */ 
/*     */   public void setHayProximoBloque(String string)
/*     */   {
/* 186 */     this.hayProximoBloque = string;
/*     */   }
/*     */ 
/*     */   public void setIndice(int i)
/*     */   {
/* 193 */     this.indice = i;
/*     */   }
/*     */ 
/*     */   public void setListaPagina(Vector vector)
/*     */   {
/* 200 */     this.listaPagina = vector;
/*     */   }
/*     */ 
/*     */   public void setNumeroPagina(String string)
/*     */   {
/* 207 */     this.numeroPagina = string;
/*     */   }
/*     */ 
/*     */   public void setTipo(String string)
/*     */   {
/* 214 */     this.tipo = string;
/*     */   }
/*     */ 
/*     */   public void setTotalPaginas(int i)
/*     */   {
/* 221 */     this.totalPaginas = i;
/*     */   }
/*     */ 
/*     */   public void setVctDetalles(Vector vector)
/*     */   {
/* 228 */     this.vctDetalles = vector;
/*     */   }
/*     */ 
/*     */   public void setVctPagina(Vector vector)
/*     */   {
/* 235 */     this.vctPagina = vector;
/*     */   }
/*     */ 
/*     */   public void setVctExpHead(String string)
/*     */   {
/* 242 */     this.vctExpHead = string;
/*     */   }
/*     */ 
/*     */   public void setMensaje(String string)
/*     */   {
/* 249 */     this.mensaje = string;
/*     */   }
/*     */ 
/*     */   public void setVctDetTotales(Vector vector) {
/* 253 */     this.vctDetTotales = vector;
/*     */   }
/*     */ }

/* Location:           C:\sitios\GestionTV_Ripley\trunk\docs\01 Requerimiento\Fuentes Gestión TV\GestionTV-WC7\WEB-INF\classes\
 * Qualified Name:     cl.ripley.GestionTV.struts.form.ProductosForm
 * JD-Core Version:    0.6.2
 */