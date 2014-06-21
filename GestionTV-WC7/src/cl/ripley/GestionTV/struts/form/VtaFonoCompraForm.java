/*     */ package cl.ripley.GestionTV.struts.form;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.Vector;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.apache.struts.action.ActionErrors;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ 
/*     */ public class VtaFonoCompraForm extends ActionForm
/*     */ {
/*     */   private String mensaje;
/*     */   private String accion;
/*     */   private Vector vctTabla;
/*  22 */   private int contador = 0;
/*     */ 
/*  24 */   private String[] chkCodigos = new String[0];
/*     */   private String fechaCredito;
/*     */   private String fechaTermino;
/*     */   private String credito;
/*     */   private String rut;
/*     */   private String dv;
/*     */   private String nombres;
/*     */   private String apellidoMaterno;
/*     */   private String apellidoPaterno;
/*     */   private String numero;
/*     */   private String comuna;
/*     */   private String ciudad;
/*     */   private String telefono1;
/*     */   private String telefono2;
/*     */   private String codigoProducto;
/*     */   private String estado;
/*     */   private String observacion;
/*     */   private String codigoCP;
/*     */   private String nombreCP;
/*     */   private String ejecutivo;
/*     */   private String calle;
/*     */   private String departamento;
/*     */   private String villa;
/*     */   private String referencia;
/*     */   private String nombreProducto;
/*     */   private String ordenCompra;
/*     */   private String monto;
/*     */   private String codAutorizacion;
/*     */   private String apellidos;
/*  83 */   private String cambioproducto = "N";
/*     */   private String valorCP;
/*     */   private String codEstado;
/*     */   private String glosaEstado;
/*     */   private Collection collEstado;
/*  91 */   private String[] selectEstado = new String[0];
/*     */   private String codEjecutivo;
/*     */   private String filas;
/*     */   private String codigo;
/*     */   private int indice;
/* 103 */   private String flagDatosBD = "si";
/*     */   private int registrosPorBloque;
/*     */   private int nroBloque;
/*     */   private int totalRegistros;
/*     */   private String hayDatos;
/*     */   private String hayProximoBloque;
/* 115 */   private Vector listaPagina = new Vector();
/*     */ 
/* 117 */   private Vector vctElemento = new Vector();
/*     */ 
/* 119 */   private int totalPaginas = 0;
/*     */ 
/*     */   public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/* 135 */     throw new UnsupportedOperationException(
/* 136 */       "Generated method 'validate(...)' not implemented.");
/*     */   }
/*     */ 
/*     */   public void reset(ActionMapping mapping, HttpServletRequest request)
/*     */   {
/* 148 */     this.mensaje = "";
/* 149 */     this.accion = "";
/*     */   }
/*     */ 
/*     */   public String getMensaje()
/*     */   {
/* 159 */     return this.mensaje;
/*     */   }
/*     */ 
/*     */   public void setMensaje(String mensaje)
/*     */   {
/* 169 */     this.mensaje = mensaje;
/*     */   }
/*     */ 
/*     */   public String getAccion()
/*     */   {
/* 178 */     return this.accion;
/*     */   }
/*     */ 
/*     */   public void setAccion(String accion)
/*     */   {
/* 188 */     this.accion = accion;
/*     */   }
/*     */ 
/*     */   public Vector getVctTabla() {
/* 192 */     return this.vctTabla;
/*     */   }
/*     */ 
/*     */   public void setVctTabla(Vector vctTabla) {
/* 196 */     this.vctTabla = vctTabla;
/*     */   }
/*     */ 
/*     */   public String[] getChkCodigos() {
/* 200 */     return this.chkCodigos;
/*     */   }
/*     */ 
/*     */   public void setChkCodigos(String[] chkCodigos) {
/* 204 */     this.chkCodigos = chkCodigos;
/*     */   }
/*     */ 
/*     */   public int getContador() {
/* 208 */     return this.contador;
/*     */   }
/*     */ 
/*     */   public void setContador(int contador) {
/* 212 */     this.contador = contador;
/*     */   }
/*     */ 
/*     */   public int getIndice()
/*     */   {
/* 219 */     return this.indice;
/*     */   }
/*     */ 
/*     */   public int getNroBloque()
/*     */   {
/* 226 */     return this.nroBloque;
/*     */   }
/*     */ 
/*     */   public int getRegistrosPorBloque()
/*     */   {
/* 233 */     return this.registrosPorBloque;
/*     */   }
/*     */ 
/*     */   public int getTotalRegistros()
/*     */   {
/* 240 */     return this.totalRegistros;
/*     */   }
/*     */ 
/*     */   public void setIndice(int i)
/*     */   {
/* 247 */     this.indice = i;
/*     */   }
/*     */ 
/*     */   public void setNroBloque(int i)
/*     */   {
/* 254 */     this.nroBloque = i;
/*     */   }
/*     */ 
/*     */   public void setRegistrosPorBloque(int i)
/*     */   {
/* 261 */     this.registrosPorBloque = i;
/*     */   }
/*     */ 
/*     */   public void setTotalRegistros(int i)
/*     */   {
/* 268 */     this.totalRegistros = i;
/*     */   }
/*     */ 
/*     */   public String getHayDatos()
/*     */   {
/* 275 */     return this.hayDatos;
/*     */   }
/*     */ 
/*     */   public String getHayProximoBloque()
/*     */   {
/* 282 */     return this.hayProximoBloque;
/*     */   }
/*     */ 
/*     */   public void setHayDatos(String string)
/*     */   {
/* 289 */     this.hayDatos = string;
/*     */   }
/*     */ 
/*     */   public void setHayProximoBloque(String string)
/*     */   {
/* 296 */     this.hayProximoBloque = string;
/*     */   }
/*     */ 
/*     */   public Vector getListaPagina()
/*     */   {
/* 303 */     return this.listaPagina;
/*     */   }
/*     */ 
/*     */   public void setListaPagina(Vector vector)
/*     */   {
/* 310 */     this.listaPagina = vector;
/*     */   }
/*     */ 
/*     */   public Vector getVctElemento()
/*     */   {
/* 317 */     return this.vctElemento;
/*     */   }
/*     */ 
/*     */   public void setVctElemento(Vector vector)
/*     */   {
/* 324 */     this.vctElemento = vector;
/*     */   }
/*     */ 
/*     */   public String getCredito()
/*     */   {
/* 331 */     return this.credito;
/*     */   }
/*     */ 
/*     */   public void setCredito(String credito)
/*     */   {
/* 339 */     this.credito = credito;
/*     */   }
/*     */ 
/*     */   public String getNombres()
/*     */   {
/* 347 */     return this.nombres;
/*     */   }
/*     */ 
/*     */   public void setNombres(String nombre)
/*     */   {
/* 355 */     this.nombres = nombre;
/*     */   }
/*     */ 
/*     */   public String getRut()
/*     */   {
/* 362 */     return this.rut;
/*     */   }
/*     */ 
/*     */   public void setRut(String rut)
/*     */   {
/* 370 */     this.rut = rut;
/*     */   }
/*     */ 
/*     */   public String getApellidoMaterno()
/*     */   {
/* 377 */     return this.apellidoMaterno;
/*     */   }
/*     */ 
/*     */   public void setApellidoMaterno(String apellidoMaterno)
/*     */   {
/* 385 */     this.apellidoMaterno = apellidoMaterno;
/*     */   }
/*     */ 
/*     */   public String getApellidoPaterno()
/*     */   {
/* 392 */     return this.apellidoPaterno;
/*     */   }
/*     */ 
/*     */   public void setApellidoPaterno(String apellidoPaterno)
/*     */   {
/* 400 */     this.apellidoPaterno = apellidoPaterno;
/*     */   }
/*     */ 
/*     */   public String getCalle()
/*     */   {
/* 407 */     return this.calle;
/*     */   }
/*     */ 
/*     */   public void setCalle(String calle)
/*     */   {
/* 415 */     this.calle = calle;
/*     */   }
/*     */ 
/*     */   public String getCiudad()
/*     */   {
/* 422 */     return this.ciudad;
/*     */   }
/*     */ 
/*     */   public void setCiudad(String ciudad)
/*     */   {
/* 430 */     this.ciudad = ciudad;
/*     */   }
/*     */ 
/*     */   public String getCodAutorizacion()
/*     */   {
/* 437 */     return this.codAutorizacion;
/*     */   }
/*     */ 
/*     */   public void setCodAutorizacion(String codAutorizacion)
/*     */   {
/* 445 */     this.codAutorizacion = codAutorizacion;
/*     */   }
/*     */ 
/*     */   public String getCodigoCP()
/*     */   {
/* 452 */     return this.codigoCP;
/*     */   }
/*     */ 
/*     */   public void setCodigoCP(String codigoCP)
/*     */   {
/* 460 */     this.codigoCP = codigoCP;
/*     */   }
/*     */ 
/*     */   public String getCodigoProducto()
/*     */   {
/* 467 */     return this.codigoProducto;
/*     */   }
/*     */ 
/*     */   public void setCodigoProducto(String codigoProducto)
/*     */   {
/* 475 */     this.codigoProducto = codigoProducto;
/*     */   }
/*     */ 
/*     */   public String getComuna()
/*     */   {
/* 482 */     return this.comuna;
/*     */   }
/*     */ 
/*     */   public void setComuna(String comuna)
/*     */   {
/* 490 */     this.comuna = comuna;
/*     */   }
/*     */ 
/*     */   public String getDepartamento()
/*     */   {
/* 497 */     return this.departamento;
/*     */   }
/*     */ 
/*     */   public void setDepartamento(String departamento)
/*     */   {
/* 505 */     this.departamento = departamento;
/*     */   }
/*     */ 
/*     */   public String getEjecutivo()
/*     */   {
/* 512 */     return this.ejecutivo;
/*     */   }
/*     */ 
/*     */   public void setEjecutivo(String ejecutivo)
/*     */   {
/* 520 */     this.ejecutivo = ejecutivo;
/*     */   }
/*     */ 
/*     */   public String getEstado()
/*     */   {
/* 527 */     return this.estado;
/*     */   }
/*     */ 
/*     */   public void setEstado(String estado)
/*     */   {
/* 535 */     this.estado = estado;
/*     */   }
/*     */ 
/*     */   public String getMonto()
/*     */   {
/* 542 */     return this.monto;
/*     */   }
/*     */ 
/*     */   public void setMonto(String monto)
/*     */   {
/* 550 */     this.monto = monto;
/*     */   }
/*     */ 
/*     */   public String getNombreCP()
/*     */   {
/* 557 */     return this.nombreCP;
/*     */   }
/*     */ 
/*     */   public void setNombreCP(String nombreCP)
/*     */   {
/* 565 */     this.nombreCP = nombreCP;
/*     */   }
/*     */ 
/*     */   public String getNombreProducto()
/*     */   {
/* 572 */     return this.nombreProducto;
/*     */   }
/*     */ 
/*     */   public void setNombreProducto(String nombreProducto)
/*     */   {
/* 580 */     this.nombreProducto = nombreProducto;
/*     */   }
/*     */ 
/*     */   public String getNumero()
/*     */   {
/* 587 */     return this.numero;
/*     */   }
/*     */ 
/*     */   public void setNumero(String numero)
/*     */   {
/* 595 */     this.numero = numero;
/*     */   }
/*     */ 
/*     */   public String getObservacion()
/*     */   {
/* 602 */     return this.observacion;
/*     */   }
/*     */ 
/*     */   public void setObservacion(String observacion)
/*     */   {
/* 610 */     this.observacion = observacion;
/*     */   }
/*     */ 
/*     */   public String getOrdenCompra()
/*     */   {
/* 617 */     return this.ordenCompra;
/*     */   }
/*     */ 
/*     */   public void setOrdenCompra(String ordenCompra)
/*     */   {
/* 625 */     this.ordenCompra = ordenCompra;
/*     */   }
/*     */ 
/*     */   public String getReferencia()
/*     */   {
/* 632 */     return this.referencia;
/*     */   }
/*     */ 
/*     */   public void setReferencia(String referencia)
/*     */   {
/* 640 */     this.referencia = referencia;
/*     */   }
/*     */ 
/*     */   public String getTelefono1()
/*     */   {
/* 647 */     return this.telefono1;
/*     */   }
/*     */ 
/*     */   public void setTelefono1(String telefono1)
/*     */   {
/* 655 */     this.telefono1 = telefono1;
/*     */   }
/*     */ 
/*     */   public String getTelefono2()
/*     */   {
/* 662 */     return this.telefono2;
/*     */   }
/*     */ 
/*     */   public void setTelefono2(String telefono2)
/*     */   {
/* 670 */     this.telefono2 = telefono2;
/*     */   }
/*     */ 
/*     */   public String getVilla()
/*     */   {
/* 677 */     return this.villa;
/*     */   }
/*     */ 
/*     */   public void setVilla(String villa)
/*     */   {
/* 684 */     this.villa = villa;
/*     */   }
/*     */ 
/*     */   public String getCodEstado()
/*     */   {
/* 692 */     return this.codEstado;
/*     */   }
/*     */ 
/*     */   public void setCodEstado(String codEstado)
/*     */   {
/* 698 */     this.codEstado = codEstado;
/*     */   }
/*     */ 
/*     */   public Collection getCollEstado()
/*     */   {
/* 704 */     return this.collEstado;
/*     */   }
/*     */ 
/*     */   public void setCollEstado(Collection collEstado)
/*     */   {
/* 710 */     this.collEstado = collEstado;
/*     */   }
/*     */ 
/*     */   public String getGlosaEstado()
/*     */   {
/* 716 */     return this.glosaEstado;
/*     */   }
/*     */ 
/*     */   public void setGlosaEstado(String glosaEstado)
/*     */   {
/* 722 */     this.glosaEstado = glosaEstado;
/*     */   }
/*     */ 
/*     */   public String[] getSelectEstado()
/*     */   {
/* 728 */     return this.selectEstado;
/*     */   }
/*     */ 
/*     */   public void setSelectEstado(String[] selectEstado)
/*     */   {
/* 734 */     this.selectEstado = selectEstado;
/*     */   }
/*     */ 
/*     */   public String getDv()
/*     */   {
/* 742 */     return this.dv;
/*     */   }
/*     */ 
/*     */   public void setDv(String dv)
/*     */   {
/* 748 */     this.dv = dv;
/*     */   }
/*     */ 
/*     */   public String getFechaCredito()
/*     */   {
/* 757 */     return this.fechaCredito;
/*     */   }
/*     */ 
/*     */   public void setFechaCredito(String fechaCredito)
/*     */   {
/* 763 */     this.fechaCredito = fechaCredito;
/*     */   }
/*     */ 
/*     */   public String getFechaTermino()
/*     */   {
/* 769 */     return this.fechaTermino;
/*     */   }
/*     */ 
/*     */   public void setFechaTermino(String fechaTermino)
/*     */   {
/* 775 */     this.fechaTermino = fechaTermino;
/*     */   }
/*     */ 
/*     */   public int getTotalPaginas()
/*     */   {
/* 782 */     return this.totalPaginas;
/*     */   }
/*     */ 
/*     */   public void setTotalPaginas(int i)
/*     */   {
/* 789 */     this.totalPaginas = i;
/*     */   }
/*     */ 
/*     */   public String getFlagDatosBD()
/*     */   {
/* 797 */     return this.flagDatosBD;
/*     */   }
/*     */ 
/*     */   public void setFlagDatosBD(String string)
/*     */   {
/* 804 */     this.flagDatosBD = string;
/*     */   }
/*     */ 
/*     */   public String getCodigo()
/*     */   {
/* 811 */     return this.codigo;
/*     */   }
/*     */ 
/*     */   public void setCodigo(String string)
/*     */   {
/* 818 */     this.codigo = string;
/*     */   }
/*     */ 
/*     */   public String getApellidos()
/*     */   {
/* 825 */     return this.apellidos;
/*     */   }
/*     */ 
/*     */   public void setApellidos(String apellidos)
/*     */   {
/* 831 */     this.apellidos = apellidos;
/*     */   }
/*     */ 
/*     */   public String getCambioproducto()
/*     */   {
/* 838 */     return this.cambioproducto;
/*     */   }
/*     */ 
/*     */   public void setCambioproducto(String cambioproducto)
/*     */   {
/* 844 */     this.cambioproducto = cambioproducto;
/*     */   }
/*     */ 
/*     */   public String getValorCP()
/*     */   {
/* 850 */     return this.valorCP;
/*     */   }
/*     */ 
/*     */   public void setValorCP(String valorCP)
/*     */   {
/* 856 */     this.valorCP = valorCP;
/*     */   }
/*     */ 
/*     */   public String getFilas()
/*     */   {
/* 864 */     return this.filas;
/*     */   }
/*     */ 
/*     */   public void setFilas(String filas)
/*     */   {
/* 870 */     this.filas = filas;
/*     */   }
/*     */ 
/*     */   public String getCodEjecutivo()
/*     */   {
/* 877 */     return this.codEjecutivo;
/*     */   }
/*     */ 
/*     */   public void setCodEjecutivo(String codEjecutivo)
/*     */   {
/* 883 */     this.codEjecutivo = codEjecutivo;
/*     */   }
/*     */ }

/* Location:           C:\sitios\GestionTV_Ripley\trunk\docs\01 Requerimiento\Fuentes Gestión TV\GestionTV-WC7\WEB-INF\classes\
 * Qualified Name:     cl.ripley.GestionTV.struts.form.VtaFonoCompraForm
 * JD-Core Version:    0.6.2
 */