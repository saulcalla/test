/*     */ package cl.ripley.GestionTV.struts.form;
/*     */ 
/*     */ import java.util.Vector;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ 
/*     */ public class TarjetaRipleyDatosForm extends ActionForm
/*     */ {
/*     */   private String accion;
/*  18 */   private Vector vctDetalles = new Vector();
/*     */   private String fec_inicio;
/*  21 */   private int contador = 0;
/*  22 */   private String flagDatosBD = "si";
/*     */   private String hayDatos;
/*     */   private String hayDatosExportar;
/*     */   private String hayProximoBloque;
/*     */   private int indice;
/*  27 */   private Vector listaPagina = new Vector();
/*     */   private String mensaje;
/*     */   private int nroBloque;
/*     */   private int registrosPorBloque;
/*  31 */   private int totalPaginas = 0;
/*     */   private int totalRegistros;
/*     */   private String exportFile;
/*     */   private String vctExpHead;
/*     */   private String corr;
/*     */   private String rut;
/*     */   private String nombre;
/*     */   private String telCasa;
/*     */   private String telCelular;
/*     */   private String telTrabajo;
/*     */   private String email;
/*     */   private String mensajeRipley;
/*     */ 
/*     */   public String getAccion()
/*     */   {
/*  52 */     return this.accion;
/*     */   }
/*     */ 
/*     */   public void setAccion(String string)
/*     */   {
/*  64 */     this.accion = string;
/*     */   }
/*     */ 
/*     */   public Vector getVctDetalles()
/*     */   {
/*  74 */     return this.vctDetalles;
/*     */   }
/*     */ 
/*     */   public void setVctDetalles(Vector vVector)
/*     */   {
/*  86 */     this.vctDetalles = vVector;
/*     */   }
/*     */ 
/*     */   public void reset(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/*     */   }
/*     */ 
/*     */   public String getFec_inicio()
/*     */   {
/* 103 */     return this.fec_inicio;
/*     */   }
/*     */ 
/*     */   public void setFec_inicio(String string)
/*     */   {
/* 114 */     this.fec_inicio = string;
/*     */   }
/*     */ 
/*     */   public int getContador()
/*     */   {
/* 123 */     return this.contador;
/*     */   }
/*     */ 
/*     */   public String getHayDatos()
/*     */   {
/* 132 */     return this.hayDatos;
/*     */   }
/*     */ 
/*     */   public String getHayProximoBloque()
/*     */   {
/* 141 */     return this.hayProximoBloque;
/*     */   }
/*     */ 
/*     */   public int getIndice()
/*     */   {
/* 150 */     return this.indice;
/*     */   }
/*     */ 
/*     */   public Vector getListaPagina()
/*     */   {
/* 159 */     return this.listaPagina;
/*     */   }
/*     */ 
/*     */   public int getNroBloque()
/*     */   {
/* 168 */     return this.nroBloque;
/*     */   }
/*     */ 
/*     */   public int getRegistrosPorBloque()
/*     */   {
/* 177 */     return this.registrosPorBloque;
/*     */   }
/*     */ 
/*     */   public int getTotalRegistros()
/*     */   {
/* 186 */     return this.totalRegistros;
/*     */   }
/*     */ 
/*     */   public void setContador(int i)
/*     */   {
/* 196 */     this.contador = i;
/*     */   }
/*     */ 
/*     */   public void setHayDatos(String string)
/*     */   {
/* 205 */     this.hayDatos = string;
/*     */   }
/*     */ 
/*     */   public void setHayProximoBloque(String string)
/*     */   {
/* 214 */     this.hayProximoBloque = string;
/*     */   }
/*     */ 
/*     */   public void setIndice(int i)
/*     */   {
/* 223 */     this.indice = i;
/*     */   }
/*     */ 
/*     */   public void setListaPagina(Vector vector)
/*     */   {
/* 232 */     this.listaPagina = vector;
/*     */   }
/*     */ 
/*     */   public void setNroBloque(int i)
/*     */   {
/* 241 */     this.nroBloque = i;
/*     */   }
/*     */ 
/*     */   public void setRegistrosPorBloque(int i)
/*     */   {
/* 250 */     this.registrosPorBloque = i;
/*     */   }
/*     */ 
/*     */   public void setTotalRegistros(int i)
/*     */   {
/* 259 */     this.totalRegistros = i;
/*     */   }
/*     */ 
/*     */   public String getMensaje()
/*     */   {
/* 274 */     return this.mensaje;
/*     */   }
/*     */ 
/*     */   public void setMensaje(String string)
/*     */   {
/* 283 */     this.mensaje = string;
/*     */   }
/*     */ 
/*     */   public int getTotalPaginas()
/*     */   {
/* 293 */     return this.totalPaginas;
/*     */   }
/*     */ 
/*     */   public void setTotalPaginas(int i)
/*     */   {
/* 303 */     this.totalPaginas = i;
/*     */   }
/*     */ 
/*     */   public String getFlagDatosBD()
/*     */   {
/* 313 */     return this.flagDatosBD;
/*     */   }
/*     */ 
/*     */   public void setFlagDatosBD(String string)
/*     */   {
/* 322 */     this.flagDatosBD = string;
/*     */   }
/*     */ 
/*     */   public String getExportFile()
/*     */   {
/* 329 */     return this.exportFile;
/*     */   }
/*     */ 
/*     */   public String getVctExpHead()
/*     */   {
/* 336 */     return this.vctExpHead;
/*     */   }
/*     */ 
/*     */   public void setExportFile(String string)
/*     */   {
/* 343 */     this.exportFile = string;
/*     */   }
/*     */ 
/*     */   public void setVctExpHead(String string)
/*     */   {
/* 350 */     this.vctExpHead = string;
/*     */   }
/*     */ 
/*     */   public String getCorr()
/*     */   {
/* 357 */     return this.corr;
/*     */   }
/*     */ 
/*     */   public void setCorr(String string)
/*     */   {
/* 364 */     this.corr = string;
/*     */   }
/*     */ 
/*     */   public String getHayDatosExportar()
/*     */   {
/* 371 */     return this.hayDatosExportar;
/*     */   }
/*     */ 
/*     */   public void setHayDatosExportar(String string)
/*     */   {
/* 378 */     this.hayDatosExportar = string;
/*     */   }
/*     */ 
/*     */   public String getEmail()
/*     */   {
/* 385 */     return this.email;
/*     */   }
/*     */ 
/*     */   public String getMensajeRipley()
/*     */   {
/* 392 */     return this.mensajeRipley;
/*     */   }
/*     */ 
/*     */   public String getNombre()
/*     */   {
/* 399 */     return this.nombre;
/*     */   }
/*     */ 
/*     */   public String getRut()
/*     */   {
/* 406 */     return this.rut;
/*     */   }
/*     */ 
/*     */   public String getTelCasa()
/*     */   {
/* 413 */     return this.telCasa;
/*     */   }
/*     */ 
/*     */   public String getTelCelular()
/*     */   {
/* 420 */     return this.telCelular;
/*     */   }
/*     */ 
/*     */   public String getTelTrabajo()
/*     */   {
/* 427 */     return this.telTrabajo;
/*     */   }
/*     */ 
/*     */   public void setEmail(String string)
/*     */   {
/* 434 */     this.email = string;
/*     */   }
/*     */ 
/*     */   public void setMensajeRipley(String string)
/*     */   {
/* 441 */     this.mensajeRipley = string;
/*     */   }
/*     */ 
/*     */   public void setNombre(String string)
/*     */   {
/* 448 */     this.nombre = string;
/*     */   }
/*     */ 
/*     */   public void setRut(String string)
/*     */   {
/* 455 */     this.rut = string;
/*     */   }
/*     */ 
/*     */   public void setTelCasa(String string)
/*     */   {
/* 462 */     this.telCasa = string;
/*     */   }
/*     */ 
/*     */   public void setTelCelular(String string)
/*     */   {
/* 469 */     this.telCelular = string;
/*     */   }
/*     */ 
/*     */   public void setTelTrabajo(String string)
/*     */   {
/* 476 */     this.telTrabajo = string;
/*     */   }
/*     */ }

/* Location:           C:\sitios\GestionTV_Ripley\trunk\docs\01 Requerimiento\Fuentes Gestión TV\GestionTV-WC7\WEB-INF\classes\
 * Qualified Name:     cl.ripley.GestionTV.struts.form.TarjetaRipleyDatosForm
 * JD-Core Version:    0.6.2
 */