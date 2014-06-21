/*     */ package cl.ripley.GestionTV.struts.form;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.Vector;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ 
/*     */ public class TarjetaRipleyForm extends ActionForm
/*     */ {
/*     */   private String accion;
/*  20 */   private Vector vctDetalles = new Vector();
/*     */   private String fec_inicio;
/*  23 */   private int contador = 0;
/*  24 */   private String flagDatosBD = "si";
/*     */   private String hayDatos;
/*     */   private String hayDatosExportar;
/*     */   private String hayProximoBloque;
/*     */   private int indice;
/*  29 */   private Vector listaPagina = new Vector();
/*     */   private String mensaje;
/*     */   private int nroBloque;
/*     */   private int registrosPorBloque;
/*  33 */   private int totalPaginas = 0;
/*     */   private int totalRegistros;
/*     */   private String exportFile;
/*     */   private String vctExpHead;
/*     */   private String corr;
/*     */   private String estado;
/*     */   private String fechaBoleta;
/*     */   private String boleta;
/*     */   private String credito;
/*     */   private String fechaCredito;
/*     */   private String orden;
/*     */   private String ordenTpk;
/*     */   private String autor;
/*     */   private String cliente;
/*     */   private String rutCliente;
/*     */   private String monto;
/*     */   private String mili;
/*     */   private String codSucursal;
/*     */   private String glosaSucursal;
/*     */   private Collection collSucursal;
/*  56 */   private String[] selectSucursal = new String[0];
/*     */ 
/*     */   public String getAccion()
/*     */   {
/*  67 */     return this.accion;
/*     */   }
/*     */ 
/*     */   public void setAccion(String string)
/*     */   {
/*  79 */     this.accion = string;
/*     */   }
/*     */ 
/*     */   public Vector getVctDetalles()
/*     */   {
/*  89 */     return this.vctDetalles;
/*     */   }
/*     */ 
/*     */   public void setVctDetalles(Vector vVector)
/*     */   {
/* 101 */     this.vctDetalles = vVector;
/*     */   }
/*     */ 
/*     */   public void reset(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/*     */   }
/*     */ 
/*     */   public String getFec_inicio()
/*     */   {
/* 118 */     return this.fec_inicio;
/*     */   }
/*     */ 
/*     */   public void setFec_inicio(String string)
/*     */   {
/* 129 */     this.fec_inicio = string;
/*     */   }
/*     */ 
/*     */   public int getContador()
/*     */   {
/* 138 */     return this.contador;
/*     */   }
/*     */ 
/*     */   public String getHayDatos()
/*     */   {
/* 147 */     return this.hayDatos;
/*     */   }
/*     */ 
/*     */   public String getHayProximoBloque()
/*     */   {
/* 156 */     return this.hayProximoBloque;
/*     */   }
/*     */ 
/*     */   public int getIndice()
/*     */   {
/* 165 */     return this.indice;
/*     */   }
/*     */ 
/*     */   public Vector getListaPagina()
/*     */   {
/* 174 */     return this.listaPagina;
/*     */   }
/*     */ 
/*     */   public int getNroBloque()
/*     */   {
/* 183 */     return this.nroBloque;
/*     */   }
/*     */ 
/*     */   public int getRegistrosPorBloque()
/*     */   {
/* 192 */     return this.registrosPorBloque;
/*     */   }
/*     */ 
/*     */   public int getTotalRegistros()
/*     */   {
/* 201 */     return this.totalRegistros;
/*     */   }
/*     */ 
/*     */   public void setContador(int i)
/*     */   {
/* 211 */     this.contador = i;
/*     */   }
/*     */ 
/*     */   public void setHayDatos(String string)
/*     */   {
/* 220 */     this.hayDatos = string;
/*     */   }
/*     */ 
/*     */   public void setHayProximoBloque(String string)
/*     */   {
/* 229 */     this.hayProximoBloque = string;
/*     */   }
/*     */ 
/*     */   public void setIndice(int i)
/*     */   {
/* 238 */     this.indice = i;
/*     */   }
/*     */ 
/*     */   public void setListaPagina(Vector vector)
/*     */   {
/* 247 */     this.listaPagina = vector;
/*     */   }
/*     */ 
/*     */   public void setNroBloque(int i)
/*     */   {
/* 256 */     this.nroBloque = i;
/*     */   }
/*     */ 
/*     */   public void setRegistrosPorBloque(int i)
/*     */   {
/* 265 */     this.registrosPorBloque = i;
/*     */   }
/*     */ 
/*     */   public void setTotalRegistros(int i)
/*     */   {
/* 274 */     this.totalRegistros = i;
/*     */   }
/*     */ 
/*     */   public String getMensaje()
/*     */   {
/* 289 */     return this.mensaje;
/*     */   }
/*     */ 
/*     */   public void setMensaje(String string)
/*     */   {
/* 298 */     this.mensaje = string;
/*     */   }
/*     */ 
/*     */   public int getTotalPaginas()
/*     */   {
/* 308 */     return this.totalPaginas;
/*     */   }
/*     */ 
/*     */   public void setTotalPaginas(int i)
/*     */   {
/* 318 */     this.totalPaginas = i;
/*     */   }
/*     */ 
/*     */   public String getFlagDatosBD()
/*     */   {
/* 328 */     return this.flagDatosBD;
/*     */   }
/*     */ 
/*     */   public void setFlagDatosBD(String string)
/*     */   {
/* 337 */     this.flagDatosBD = string;
/*     */   }
/*     */ 
/*     */   public String getExportFile()
/*     */   {
/* 344 */     return this.exportFile;
/*     */   }
/*     */ 
/*     */   public String getVctExpHead()
/*     */   {
/* 351 */     return this.vctExpHead;
/*     */   }
/*     */ 
/*     */   public void setExportFile(String string)
/*     */   {
/* 358 */     this.exportFile = string;
/*     */   }
/*     */ 
/*     */   public void setVctExpHead(String string)
/*     */   {
/* 365 */     this.vctExpHead = string;
/*     */   }
/*     */ 
/*     */   public String getAutor()
/*     */   {
/* 372 */     return this.autor;
/*     */   }
/*     */ 
/*     */   public String getBoleta()
/*     */   {
/* 379 */     return this.boleta;
/*     */   }
/*     */ 
/*     */   public String getCliente()
/*     */   {
/* 386 */     return this.cliente;
/*     */   }
/*     */ 
/*     */   public String getCorr()
/*     */   {
/* 393 */     return this.corr;
/*     */   }
/*     */ 
/*     */   public String getCredito()
/*     */   {
/* 400 */     return this.credito;
/*     */   }
/*     */ 
/*     */   public String getEstado()
/*     */   {
/* 407 */     return this.estado;
/*     */   }
/*     */ 
/*     */   public String getFechaBoleta()
/*     */   {
/* 414 */     return this.fechaBoleta;
/*     */   }
/*     */ 
/*     */   public String getFechaCredito()
/*     */   {
/* 421 */     return this.fechaCredito;
/*     */   }
/*     */ 
/*     */   public String getMili()
/*     */   {
/* 428 */     return this.mili;
/*     */   }
/*     */ 
/*     */   public String getMonto()
/*     */   {
/* 435 */     return this.monto;
/*     */   }
/*     */ 
/*     */   public String getOrden()
/*     */   {
/* 442 */     return this.orden;
/*     */   }
/*     */ 
/*     */   public String getOrdenTpk()
/*     */   {
/* 449 */     return this.ordenTpk;
/*     */   }
/*     */ 
/*     */   public String getRutCliente()
/*     */   {
/* 456 */     return this.rutCliente;
/*     */   }
/*     */ 
/*     */   public void setAutor(String string)
/*     */   {
/* 463 */     this.autor = string;
/*     */   }
/*     */ 
/*     */   public void setBoleta(String string)
/*     */   {
/* 470 */     this.boleta = string;
/*     */   }
/*     */ 
/*     */   public void setCliente(String string)
/*     */   {
/* 477 */     this.cliente = string;
/*     */   }
/*     */ 
/*     */   public void setCorr(String string)
/*     */   {
/* 484 */     this.corr = string;
/*     */   }
/*     */ 
/*     */   public void setCredito(String string)
/*     */   {
/* 491 */     this.credito = string;
/*     */   }
/*     */ 
/*     */   public void setEstado(String string)
/*     */   {
/* 498 */     this.estado = string;
/*     */   }
/*     */ 
/*     */   public void setFechaBoleta(String string)
/*     */   {
/* 505 */     this.fechaBoleta = string;
/*     */   }
/*     */ 
/*     */   public void setFechaCredito(String string)
/*     */   {
/* 512 */     this.fechaCredito = string;
/*     */   }
/*     */ 
/*     */   public void setMili(String string)
/*     */   {
/* 519 */     this.mili = string;
/*     */   }
/*     */ 
/*     */   public void setMonto(String string)
/*     */   {
/* 526 */     this.monto = string;
/*     */   }
/*     */ 
/*     */   public void setOrden(String string)
/*     */   {
/* 533 */     this.orden = string;
/*     */   }
/*     */ 
/*     */   public void setOrdenTpk(String string)
/*     */   {
/* 540 */     this.ordenTpk = string;
/*     */   }
/*     */ 
/*     */   public void setRutCliente(String string)
/*     */   {
/* 547 */     this.rutCliente = string;
/*     */   }
/*     */ 
/*     */   public String getHayDatosExportar()
/*     */   {
/* 554 */     return this.hayDatosExportar;
/*     */   }
/*     */ 
/*     */   public void setHayDatosExportar(String string)
/*     */   {
/* 561 */     this.hayDatosExportar = string;
/*     */   }
/*     */ 
/*     */   public String getCodSucursal()
/*     */   {
/* 568 */     return this.codSucursal;
/*     */   }
/*     */ 
/*     */   public void setCodSucursal(String codSucursal)
/*     */   {
/* 574 */     this.codSucursal = codSucursal;
/*     */   }
/*     */ 
/*     */   public Collection getCollSucursal()
/*     */   {
/* 580 */     return this.collSucursal;
/*     */   }
/*     */ 
/*     */   public void setCollSucursal(Collection collSucursal)
/*     */   {
/* 586 */     this.collSucursal = collSucursal;
/*     */   }
/*     */ 
/*     */   public String getGlosaSucursal()
/*     */   {
/* 592 */     return this.glosaSucursal;
/*     */   }
/*     */ 
/*     */   public void setGlosaSucursal(String glosaSucursal)
/*     */   {
/* 598 */     this.glosaSucursal = glosaSucursal;
/*     */   }
/*     */ 
/*     */   public String[] getSelectSucursal()
/*     */   {
/* 604 */     return this.selectSucursal;
/*     */   }
/*     */ 
/*     */   public void setSelectSucursal(String[] selectSucursal)
/*     */   {
/* 610 */     this.selectSucursal = selectSucursal;
/*     */   }
/*     */ }

/* Location:           C:\sitios\GestionTV_Ripley\trunk\docs\01 Requerimiento\Fuentes Gestión TV\GestionTV-WC7\WEB-INF\classes\
 * Qualified Name:     cl.ripley.GestionTV.struts.form.TarjetaRipleyForm
 * JD-Core Version:    0.6.2
 */