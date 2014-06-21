/*     */ package cl.ripley.GestionTV.struts.form;
/*     */ 
/*     */ import java.util.Vector;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.apache.struts.action.ActionErrors;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ 
/*     */ public class MuestraLogForm extends ActionForm
/*     */ {
/*     */   private String accion;
/*  21 */   private Vector vctDetalles = new Vector();
/*     */   private Vector vctPagina;
/*  23 */   private String tipo = "";
/*     */   private String hayDatos;
/*     */   private String hayProximoBloque;
/*     */   private String numeroPagina;
/*     */   private int totalPaginas;
/*  29 */   private Vector listaPagina = new Vector();
/*     */   private int indice;
/*     */ 
/*     */   public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/*  42 */     throw new UnsupportedOperationException("Generated method 'validate(...)' not implemented.");
/*     */   }
/*     */ 
/*     */   public void reset(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/*  51 */     this.accion = "";
/*     */   }
/*     */ 
/*     */   public String getAccion()
/*     */   {
/*  59 */     return this.accion;
/*     */   }
/*     */ 
/*     */   public void setAccion(String string)
/*     */   {
/*  66 */     this.accion = string;
/*     */   }
/*     */ 
/*     */   public String getHayDatos()
/*     */   {
/*  73 */     return this.hayDatos;
/*     */   }
/*     */ 
/*     */   public String getHayProximoBloque()
/*     */   {
/*  80 */     return this.hayProximoBloque;
/*     */   }
/*     */ 
/*     */   public int getIndice()
/*     */   {
/*  87 */     return this.indice;
/*     */   }
/*     */ 
/*     */   public Vector getListaPagina()
/*     */   {
/*  94 */     return this.listaPagina;
/*     */   }
/*     */ 
/*     */   public String getNumeroPagina()
/*     */   {
/* 101 */     return this.numeroPagina;
/*     */   }
/*     */ 
/*     */   public String getTipo()
/*     */   {
/* 108 */     return this.tipo;
/*     */   }
/*     */ 
/*     */   public int getTotalPaginas()
/*     */   {
/* 115 */     return this.totalPaginas;
/*     */   }
/*     */ 
/*     */   public Vector getVctDetalles()
/*     */   {
/* 122 */     return this.vctDetalles;
/*     */   }
/*     */ 
/*     */   public Vector getVctPagina()
/*     */   {
/* 129 */     return this.vctPagina;
/*     */   }
/*     */ 
/*     */   public void setHayDatos(String string)
/*     */   {
/* 136 */     this.hayDatos = string;
/*     */   }
/*     */ 
/*     */   public void setHayProximoBloque(String string)
/*     */   {
/* 143 */     this.hayProximoBloque = string;
/*     */   }
/*     */ 
/*     */   public void setIndice(int i)
/*     */   {
/* 150 */     this.indice = i;
/*     */   }
/*     */ 
/*     */   public void setListaPagina(Vector vector)
/*     */   {
/* 157 */     this.listaPagina = vector;
/*     */   }
/*     */ 
/*     */   public void setNumeroPagina(String string)
/*     */   {
/* 164 */     this.numeroPagina = string;
/*     */   }
/*     */ 
/*     */   public void setTipo(String string)
/*     */   {
/* 171 */     this.tipo = string;
/*     */   }
/*     */ 
/*     */   public void setTotalPaginas(int i)
/*     */   {
/* 178 */     this.totalPaginas = i;
/*     */   }
/*     */ 
/*     */   public void setVctDetalles(Vector vector)
/*     */   {
/* 185 */     this.vctDetalles = vector;
/*     */   }
/*     */ 
/*     */   public void setVctPagina(Vector vector)
/*     */   {
/* 192 */     this.vctPagina = vector;
/*     */   }
/*     */ }

/* Location:           C:\sitios\GestionTV_Ripley\trunk\docs\01 Requerimiento\Fuentes Gestión TV\GestionTV-WC7\WEB-INF\classes\
 * Qualified Name:     cl.ripley.GestionTV.struts.form.MuestraLogForm
 * JD-Core Version:    0.6.2
 */