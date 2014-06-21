/*     */ package cl.ripley.GestionTV.struts.form;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.Vector;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ 
/*     */ public class VentasXusuarioForm extends ActionForm
/*     */ {
/*     */   private String accion;
/*  19 */   private Vector vctDetalles = new Vector();
/*     */   private String fec_inicio;
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
/*     */   private String codEjecutivoFiltro;
/*     */   private String glosaEjecutivoFiltro;
/*     */   private Collection collEjecutivoFiltro;
/*     */   private String selectEjecutivoFiltro;
/*     */   private String[] ventasTC;
/*     */   private Vector ventas;
/*     */   private String respuesta;
/*     */ 
/*     */   public String getAccion()
/*     */   {
/*  50 */     return this.accion;
/*     */   }
/*     */ 
/*     */   public void setAccion(String string)
/*     */   {
/*  55 */     this.accion = string;
/*     */   }
/*     */ 
/*     */   public Vector getVctDetalles()
/*     */   {
/*  60 */     return this.vctDetalles;
/*     */   }
/*     */ 
/*     */   public void setVctDetalles(Vector vVector) {
/*  64 */     this.vctDetalles = vVector;
/*     */   }
/*     */ 
/*     */   public void reset(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/*     */   }
/*     */ 
/*     */   public String getFec_inicio()
/*     */   {
/*  81 */     return this.fec_inicio;
/*     */   }
/*     */ 
/*     */   public void setFec_inicio(String string)
/*     */   {
/*  92 */     this.fec_inicio = string;
/*     */   }
/*     */ 
/*     */   public int getContador()
/*     */   {
/*  97 */     return this.contador;
/*     */   }
/*     */ 
/*     */   public String getHayDatos()
/*     */   {
/* 102 */     return this.hayDatos;
/*     */   }
/*     */ 
/*     */   public String getHayProximoBloque()
/*     */   {
/* 107 */     return this.hayProximoBloque;
/*     */   }
/*     */ 
/*     */   public int getIndice()
/*     */   {
/* 112 */     return this.indice;
/*     */   }
/*     */ 
/*     */   public Vector getListaPagina()
/*     */   {
/* 117 */     return this.listaPagina;
/*     */   }
/*     */ 
/*     */   public int getNroBloque()
/*     */   {
/* 122 */     return this.nroBloque;
/*     */   }
/*     */ 
/*     */   public int getRegistrosPorBloque()
/*     */   {
/* 127 */     return this.registrosPorBloque;
/*     */   }
/*     */ 
/*     */   public int getTotalRegistros()
/*     */   {
/* 132 */     return this.totalRegistros;
/*     */   }
/*     */ 
/*     */   public void setContador(int i)
/*     */   {
/* 137 */     this.contador = i;
/*     */   }
/*     */ 
/*     */   public void setHayDatos(String string)
/*     */   {
/* 142 */     this.hayDatos = string;
/*     */   }
/*     */ 
/*     */   public void setHayProximoBloque(String string)
/*     */   {
/* 147 */     this.hayProximoBloque = string;
/*     */   }
/*     */ 
/*     */   public void setIndice(int i) {
/* 151 */     this.indice = i;
/*     */   }
/*     */ 
/*     */   public void setListaPagina(Vector vector)
/*     */   {
/* 156 */     this.listaPagina = vector;
/*     */   }
/*     */ 
/*     */   public void setNroBloque(int i)
/*     */   {
/* 161 */     this.nroBloque = i;
/*     */   }
/*     */ 
/*     */   public void setRegistrosPorBloque(int i)
/*     */   {
/* 166 */     this.registrosPorBloque = i;
/*     */   }
/*     */ 
/*     */   public void setTotalRegistros(int i)
/*     */   {
/* 171 */     this.totalRegistros = i;
/*     */   }
/*     */ 
/*     */   public String getMensaje() {
/* 175 */     return this.mensaje;
/*     */   }
/*     */ 
/*     */   public void setMensaje(String string)
/*     */   {
/* 180 */     this.mensaje = string;
/*     */   }
/*     */ 
/*     */   public int getTotalPaginas()
/*     */   {
/* 186 */     return this.totalPaginas;
/*     */   }
/*     */ 
/*     */   public void setTotalPaginas(int i)
/*     */   {
/* 191 */     this.totalPaginas = i;
/*     */   }
/*     */ 
/*     */   public String getFlagDatosBD()
/*     */   {
/* 196 */     return this.flagDatosBD;
/*     */   }
/*     */ 
/*     */   public void setFlagDatosBD(String string)
/*     */   {
/* 201 */     this.flagDatosBD = string;
/*     */   }
/*     */ 
/*     */   public String getExportFile()
/*     */   {
/* 211 */     return this.exportFile;
/*     */   }
/*     */ 
/*     */   public String getVctExpHead()
/*     */   {
/* 218 */     return this.vctExpHead;
/*     */   }
/*     */ 
/*     */   public void setExportFile(String string)
/*     */   {
/* 225 */     this.exportFile = string;
/*     */   }
/*     */ 
/*     */   public void setVctExpHead(String string)
/*     */   {
/* 232 */     this.vctExpHead = string;
/*     */   }
/*     */ 
/*     */   public String getHayDatosExportar()
/*     */   {
/* 239 */     return this.hayDatosExportar;
/*     */   }
/*     */ 
/*     */   public void setHayDatosExportar(String string)
/*     */   {
/* 246 */     this.hayDatosExportar = string;
/*     */   }
/*     */ 
/*     */   public Vector getVentas()
/*     */   {
/* 251 */     return this.ventas;
/*     */   }
/*     */ 
/*     */   public void setVentas(Vector ventas)
/*     */   {
/* 256 */     this.ventas = ventas;
/*     */   }
/*     */ 
/*     */   public String getCodEjecutivoFiltro()
/*     */   {
/* 261 */     return this.codEjecutivoFiltro;
/*     */   }
/*     */ 
/*     */   public void setCodEjecutivoFiltro(String codEjecutivoFiltro)
/*     */   {
/* 266 */     this.codEjecutivoFiltro = codEjecutivoFiltro;
/*     */   }
/*     */ 
/*     */   public Collection getCollEjecutivoFiltro()
/*     */   {
/* 271 */     return this.collEjecutivoFiltro;
/*     */   }
/*     */ 
/*     */   public void setCollEjecutivoFiltro(Collection collEjecutivoFiltro)
/*     */   {
/* 276 */     this.collEjecutivoFiltro = collEjecutivoFiltro;
/*     */   }
/*     */ 
/*     */   public String getGlosaEjecutivoFiltro()
/*     */   {
/* 281 */     return this.glosaEjecutivoFiltro;
/*     */   }
/*     */ 
/*     */   public void setGlosaEjecutivoFiltro(String glosaEjecutivoFiltro)
/*     */   {
/* 286 */     this.glosaEjecutivoFiltro = glosaEjecutivoFiltro;
/*     */   }
/*     */ 
/*     */   public String getSelectEjecutivoFiltro()
/*     */   {
/* 291 */     return this.selectEjecutivoFiltro;
/*     */   }
/*     */ 
/*     */   public void setSelectEjecutivoFiltro(String selectEjecutivoFiltro)
/*     */   {
/* 296 */     this.selectEjecutivoFiltro = selectEjecutivoFiltro;
/*     */   }
/*     */ 
/*     */   public String[] getVentasTC() {
/* 300 */     return this.ventasTC;
/*     */   }
/*     */ 
/*     */   public void setVentasTC(String[] ventasTC)
/*     */   {
/* 305 */     this.ventasTC = ventasTC;
/*     */   }
/*     */ 
/*     */   public String getRespuesta()
/*     */   {
/* 310 */     return this.respuesta;
/*     */   }
/*     */ 
/*     */   public void setRespuesta(String respuesta)
/*     */   {
/* 315 */     this.respuesta = respuesta;
/*     */   }
/*     */ }

/* Location:           C:\sitios\GestionTV_Ripley\trunk\docs\01 Requerimiento\Fuentes Gestión TV\GestionTV-WC7\WEB-INF\classes\
 * Qualified Name:     cl.ripley.GestionTV.struts.form.VentasXusuarioForm
 * JD-Core Version:    0.6.2
 */