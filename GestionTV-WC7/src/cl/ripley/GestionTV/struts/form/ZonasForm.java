/*     */ package cl.ripley.GestionTV.struts.form;
/*     */ 
/*     */ import java.util.Vector;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.apache.struts.action.ActionErrors;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ 
/*     */ public class ZonasForm extends ActionForm
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
/*  63 */     return this.accion;
/*     */   }
/*     */ 
/*     */   public String getHayDatos()
/*     */   {
/*  70 */     return this.hayDatos;
/*     */   }
/*     */ 
/*     */   public String getHayProximoBloque()
/*     */   {
/*  77 */     return this.hayProximoBloque;
/*     */   }
/*     */ 
/*     */   public int getIndice()
/*     */   {
/*  84 */     return this.indice;
/*     */   }
/*     */ 
/*     */   public Vector getListaPagina()
/*     */   {
/*  91 */     return this.listaPagina;
/*     */   }
/*     */ 
/*     */   public String getNumeroPagina()
/*     */   {
/*  98 */     return this.numeroPagina;
/*     */   }
/*     */ 
/*     */   public String getTipo()
/*     */   {
/* 105 */     return this.tipo;
/*     */   }
/*     */ 
/*     */   public int getTotalPaginas()
/*     */   {
/* 112 */     return this.totalPaginas;
/*     */   }
/*     */ 
/*     */   public Vector getVctDetalles()
/*     */   {
/* 119 */     return this.vctDetalles;
/*     */   }
/*     */ 
/*     */   public Vector getVctPagina()
/*     */   {
/* 126 */     return this.vctPagina;
/*     */   }
/*     */ 
/*     */   public String getVctExpHead()
/*     */   {
/* 133 */     return this.vctExpHead;
/*     */   }
/*     */ 
/*     */   public String getExportFile()
/*     */   {
/* 140 */     return this.exportFile;
/*     */   }
/*     */ 
/*     */   public String getMensaje()
/*     */   {
/* 148 */     return this.mensaje;
/*     */   }
/*     */ 
/*     */   public Vector getVctDetTotales()
/*     */   {
/* 153 */     return this.vctDetTotales;
/*     */   }
/*     */ 
/*     */   public void setExportFile(String string)
/*     */   {
/* 161 */     this.exportFile = string;
/*     */   }
/*     */ 
/*     */   public void setAccion(String string)
/*     */   {
/* 169 */     this.accion = string;
/*     */   }
/*     */ 
/*     */   public void setHayDatos(String string)
/*     */   {
/* 176 */     this.hayDatos = string;
/*     */   }
/*     */ 
/*     */   public void setHayProximoBloque(String string)
/*     */   {
/* 183 */     this.hayProximoBloque = string;
/*     */   }
/*     */ 
/*     */   public void setIndice(int i)
/*     */   {
/* 190 */     this.indice = i;
/*     */   }
/*     */ 
/*     */   public void setListaPagina(Vector vector)
/*     */   {
/* 197 */     this.listaPagina = vector;
/*     */   }
/*     */ 
/*     */   public void setNumeroPagina(String string)
/*     */   {
/* 204 */     this.numeroPagina = string;
/*     */   }
/*     */ 
/*     */   public void setTipo(String string)
/*     */   {
/* 211 */     this.tipo = string;
/*     */   }
/*     */ 
/*     */   public void setTotalPaginas(int i)
/*     */   {
/* 218 */     this.totalPaginas = i;
/*     */   }
/*     */ 
/*     */   public void setVctDetalles(Vector vector)
/*     */   {
/* 225 */     this.vctDetalles = vector;
/*     */   }
/*     */ 
/*     */   public void setVctPagina(Vector vector)
/*     */   {
/* 232 */     this.vctPagina = vector;
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
 * Qualified Name:     cl.ripley.GestionTV.struts.form.ZonasForm
 * JD-Core Version:    0.6.2
 */