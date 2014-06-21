/*     */ package cl.ripley.GestionTV.struts.form;
/*     */ 
/*     */ import java.util.Vector;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ 
/*     */ public class FonoCompraForm extends ActionForm
/*     */ {
/*     */   private String accion;
/*  18 */   private Vector vctDetalles = new Vector();
/*     */   private String fec_inicio;
/*     */   private String fec_fin;
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
/*     */ 
/*     */   public String getAccion()
/*     */   {
/*  44 */     return this.accion;
/*     */   }
/*     */ 
/*     */   public void setAccion(String string)
/*     */   {
/*  56 */     this.accion = string;
/*     */   }
/*     */ 
/*     */   public Vector getVctDetalles()
/*     */   {
/*  66 */     return this.vctDetalles;
/*     */   }
/*     */ 
/*     */   public void setVctDetalles(Vector vVector)
/*     */   {
/*  78 */     this.vctDetalles = vVector;
/*     */   }
/*     */ 
/*     */   public void reset(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/*     */   }
/*     */ 
/*     */   public String getFec_inicio()
/*     */   {
/*  95 */     return this.fec_inicio;
/*     */   }
/*     */ 
/*     */   public void setFec_inicio(String string)
/*     */   {
/* 106 */     this.fec_inicio = string;
/*     */   }
/*     */ 
/*     */   public int getContador()
/*     */   {
/* 115 */     return this.contador;
/*     */   }
/*     */ 
/*     */   public String getHayDatos()
/*     */   {
/* 124 */     return this.hayDatos;
/*     */   }
/*     */ 
/*     */   public String getHayProximoBloque()
/*     */   {
/* 133 */     return this.hayProximoBloque;
/*     */   }
/*     */ 
/*     */   public int getIndice()
/*     */   {
/* 142 */     return this.indice;
/*     */   }
/*     */ 
/*     */   public Vector getListaPagina()
/*     */   {
/* 151 */     return this.listaPagina;
/*     */   }
/*     */ 
/*     */   public int getNroBloque()
/*     */   {
/* 160 */     return this.nroBloque;
/*     */   }
/*     */ 
/*     */   public int getRegistrosPorBloque()
/*     */   {
/* 169 */     return this.registrosPorBloque;
/*     */   }
/*     */ 
/*     */   public int getTotalRegistros()
/*     */   {
/* 178 */     return this.totalRegistros;
/*     */   }
/*     */ 
/*     */   public void setContador(int i)
/*     */   {
/* 188 */     this.contador = i;
/*     */   }
/*     */ 
/*     */   public void setHayDatos(String string)
/*     */   {
/* 197 */     this.hayDatos = string;
/*     */   }
/*     */ 
/*     */   public void setHayProximoBloque(String string)
/*     */   {
/* 206 */     this.hayProximoBloque = string;
/*     */   }
/*     */ 
/*     */   public void setIndice(int i)
/*     */   {
/* 215 */     this.indice = i;
/*     */   }
/*     */ 
/*     */   public void setListaPagina(Vector vector)
/*     */   {
/* 224 */     this.listaPagina = vector;
/*     */   }
/*     */ 
/*     */   public void setNroBloque(int i)
/*     */   {
/* 233 */     this.nroBloque = i;
/*     */   }
/*     */ 
/*     */   public void setRegistrosPorBloque(int i)
/*     */   {
/* 242 */     this.registrosPorBloque = i;
/*     */   }
/*     */ 
/*     */   public void setTotalRegistros(int i)
/*     */   {
/* 251 */     this.totalRegistros = i;
/*     */   }
/*     */ 
/*     */   public String getMensaje()
/*     */   {
/* 266 */     return this.mensaje;
/*     */   }
/*     */ 
/*     */   public void setMensaje(String string)
/*     */   {
/* 275 */     this.mensaje = string;
/*     */   }
/*     */ 
/*     */   public int getTotalPaginas()
/*     */   {
/* 285 */     return this.totalPaginas;
/*     */   }
/*     */ 
/*     */   public void setTotalPaginas(int i)
/*     */   {
/* 295 */     this.totalPaginas = i;
/*     */   }
/*     */ 
/*     */   public String getFlagDatosBD()
/*     */   {
/* 305 */     return this.flagDatosBD;
/*     */   }
/*     */ 
/*     */   public void setFlagDatosBD(String string)
/*     */   {
/* 314 */     this.flagDatosBD = string;
/*     */   }
/*     */ 
/*     */   public String getFec_fin()
/*     */   {
/* 326 */     return this.fec_fin;
/*     */   }
/*     */ 
/*     */   public void setFec_fin(String string)
/*     */   {
/* 335 */     this.fec_fin = string;
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
/*     */ }

/* Location:           C:\sitios\GestionTV_Ripley\trunk\docs\01 Requerimiento\Fuentes Gestión TV\GestionTV-WC7\WEB-INF\classes\
 * Qualified Name:     cl.ripley.GestionTV.struts.form.FonoCompraForm
 * JD-Core Version:    0.6.2
 */