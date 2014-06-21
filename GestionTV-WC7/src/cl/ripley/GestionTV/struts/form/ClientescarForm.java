/*     */ package cl.ripley.GestionTV.struts.form;
/*     */ 
/*     */ import java.util.Vector;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.apache.struts.action.ActionErrors;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ 
/*     */ public class ClientescarForm extends ActionForm
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
/*  45 */     throw new UnsupportedOperationException("Generated method 'validate(...)' not implemented.");
/*     */   }
/*     */ 
/*     */   public void reset(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/*  54 */     this.accion = "";
/*     */   }
/*     */ 
/*     */   public String getAccion()
/*     */   {
/*  62 */     return this.accion;
/*     */   }
/*     */ 
/*     */   public String getHayDatos()
/*     */   {
/*  69 */     return this.hayDatos;
/*     */   }
/*     */ 
/*     */   public String getHayProximoBloque()
/*     */   {
/*  76 */     return this.hayProximoBloque;
/*     */   }
/*     */ 
/*     */   public int getIndice()
/*     */   {
/*  83 */     return this.indice;
/*     */   }
/*     */ 
/*     */   public Vector getListaPagina()
/*     */   {
/*  90 */     return this.listaPagina;
/*     */   }
/*     */ 
/*     */   public String getNumeroPagina()
/*     */   {
/*  97 */     return this.numeroPagina;
/*     */   }
/*     */ 
/*     */   public String getTipo()
/*     */   {
/* 104 */     return this.tipo;
/*     */   }
/*     */ 
/*     */   public int getTotalPaginas()
/*     */   {
/* 111 */     return this.totalPaginas;
/*     */   }
/*     */ 
/*     */   public Vector getVctDetalles()
/*     */   {
/* 118 */     return this.vctDetalles;
/*     */   }
/*     */ 
/*     */   public Vector getVctPagina()
/*     */   {
/* 125 */     return this.vctPagina;
/*     */   }
/*     */ 
/*     */   public String getVctExpHead()
/*     */   {
/* 132 */     return this.vctExpHead;
/*     */   }
/*     */ 
/*     */   public String getExportFile()
/*     */   {
/* 139 */     return this.exportFile;
/*     */   }
/*     */ 
/*     */   public String getMensaje()
/*     */   {
/* 147 */     return this.mensaje;
/*     */   }
/*     */ 
/*     */   public Vector getVctDetTotales()
/*     */   {
/* 152 */     return this.vctDetTotales;
/*     */   }
/*     */ 
/*     */   public void setExportFile(String string)
/*     */   {
/* 160 */     this.exportFile = string;
/*     */   }
/*     */ 
/*     */   public void setAccion(String string)
/*     */   {
/* 168 */     this.accion = string;
/*     */   }
/*     */ 
/*     */   public void setHayDatos(String string)
/*     */   {
/* 175 */     this.hayDatos = string;
/*     */   }
/*     */ 
/*     */   public void setHayProximoBloque(String string)
/*     */   {
/* 182 */     this.hayProximoBloque = string;
/*     */   }
/*     */ 
/*     */   public void setIndice(int i)
/*     */   {
/* 189 */     this.indice = i;
/*     */   }
/*     */ 
/*     */   public void setListaPagina(Vector vector)
/*     */   {
/* 196 */     this.listaPagina = vector;
/*     */   }
/*     */ 
/*     */   public void setNumeroPagina(String string)
/*     */   {
/* 203 */     this.numeroPagina = string;
/*     */   }
/*     */ 
/*     */   public void setTipo(String string)
/*     */   {
/* 210 */     this.tipo = string;
/*     */   }
/*     */ 
/*     */   public void setTotalPaginas(int i)
/*     */   {
/* 217 */     this.totalPaginas = i;
/*     */   }
/*     */ 
/*     */   public void setVctDetalles(Vector vector)
/*     */   {
/* 224 */     this.vctDetalles = vector;
/*     */   }
/*     */ 
/*     */   public void setVctPagina(Vector vector)
/*     */   {
/* 231 */     this.vctPagina = vector;
/*     */   }
/*     */ 
/*     */   public void setVctExpHead(String string)
/*     */   {
/* 238 */     this.vctExpHead = string;
/*     */   }
/*     */ 
/*     */   public void setMensaje(String string)
/*     */   {
/* 245 */     this.mensaje = string;
/*     */   }
/*     */ 
/*     */   public void setVctDetTotales(Vector vector) {
/* 249 */     this.vctDetTotales = vector;
/*     */   }
/*     */ }

/* Location:           C:\sitios\GestionTV_Ripley\trunk\docs\01 Requerimiento\Fuentes Gestión TV\GestionTV-WC7\WEB-INF\classes\
 * Qualified Name:     cl.ripley.GestionTV.struts.form.ClientescarForm
 * JD-Core Version:    0.6.2
 */