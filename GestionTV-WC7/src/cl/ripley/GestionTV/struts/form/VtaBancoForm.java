/*      */ package cl.ripley.GestionTV.struts.form;
/*      */ 
/*      */ import java.util.Collection;
/*      */ import java.util.Vector;
/*      */ import javax.servlet.http.HttpServletRequest;
/*      */ import org.apache.struts.action.ActionErrors;
/*      */ import org.apache.struts.action.ActionForm;
/*      */ import org.apache.struts.action.ActionMapping;
/*      */ 
/*      */ public class VtaBancoForm extends ActionForm
/*      */ {
/*      */   private String mensaje;
/*      */   private String accion;
/*      */   private Vector vctTabla;
/*   22 */   private int contador = 0;
/*      */ 
/*   24 */   private String[] chkCodigos = new String[0];
/*      */   private String fechaCredito;
/*      */   private String fechaTermino;
/*      */   private String credito;
/*      */   private String rut;
/*      */   private String dv;
/*      */   private String nombres;
/*      */   private String apellidoMaterno;
/*      */   private String apellidoPaterno;
/*      */   private String numero;
/*      */   private String comuna;
/*      */   private String ciudad;
/*      */   private String telefono1;
/*      */   private String telefono2;
/*      */   private String codigoProducto;
/*      */   private String estado;
/*      */   private String observacion;
/*      */   private String codigoCP;
/*      */   private String nombreCP;
/*      */   private String ejecutivo;
/*      */   private String calle;
/*      */   private String departamento;
/*      */   private String villa;
/*      */   private String referencia;
/*      */   private String nombreProducto;
/*      */   private String ordenCompra;
/*      */   private String monto;
/*      */   private String codAutorizacion;
/*      */   private String codEstado;
/*      */   private String glosaEstado;
/*      */   private Collection collEstado;
/*   85 */   private String[] selectEstado = new String[0];
/*      */   private String codEjecutivo;
/*      */   private String glosaEjecutivo;
/*      */   private Collection collEjecutivo;
/*   93 */   private String[] selectEjecutivo = new String[0];
/*      */   private String tipoFiltro;
/*      */   private String creditoFiltro;
/*      */   private String fechaFiltro;
/*      */   private String rutFiltro;
/*      */   private String dvFiltro;
/*      */   private String nombreFiltro;
/*      */   private String paternoFiltro;
/*      */   private String maternoFiltro;
/*      */   private String estadoFiltro;
/*      */   private String codEstadoFiltro;
/*      */   private String glosaEstadoFiltro;
/*      */   private Collection collEstadoFiltro;
/*  111 */   private String[] selectEstadoFiltro = new String[0];
/*      */   private String codEjecutivoFiltro;
/*      */   private String glosaEjecutivoFiltro;
/*      */   private Collection collEjecutivoFiltro;
/*  118 */   private String[] selectEjecutivoFiltro = new String[0];
/*      */   private String filas;
/*      */   private String codigo;
/*      */   private int indice;
/*  127 */   private String flagDatosBD = "si";
/*      */   private int registrosPorBloque;
/*      */   private int nroBloque;
/*      */   private int totalRegistros;
/*      */   private String hayDatos;
/*      */   private String hayProximoBloque;
/*  139 */   private Vector listaPagina = new Vector();
/*      */ 
/*  141 */   private Vector vctElemento = new Vector();
/*      */ 
/*  143 */   private int totalPaginas = 0;
/*      */ 
/*      */   public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
/*      */   {
/*  159 */     throw new UnsupportedOperationException(
/*  160 */       "Generated method 'validate(...)' not implemented.");
/*      */   }
/*      */ 
/*      */   public void reset(ActionMapping mapping, HttpServletRequest request)
/*      */   {
/*  172 */     this.mensaje = "";
/*  173 */     this.accion = "";
/*      */   }
/*      */ 
/*      */   public String getMensaje()
/*      */   {
/*  183 */     return this.mensaje;
/*      */   }
/*      */ 
/*      */   public void setMensaje(String mensaje)
/*      */   {
/*  193 */     this.mensaje = mensaje;
/*      */   }
/*      */ 
/*      */   public String getAccion()
/*      */   {
/*  202 */     return this.accion;
/*      */   }
/*      */ 
/*      */   public void setAccion(String accion)
/*      */   {
/*  212 */     this.accion = accion;
/*      */   }
/*      */ 
/*      */   public Vector getVctTabla() {
/*  216 */     return this.vctTabla;
/*      */   }
/*      */ 
/*      */   public void setVctTabla(Vector vctTabla) {
/*  220 */     this.vctTabla = vctTabla;
/*      */   }
/*      */ 
/*      */   public String[] getChkCodigos() {
/*  224 */     return this.chkCodigos;
/*      */   }
/*      */ 
/*      */   public void setChkCodigos(String[] chkCodigos) {
/*  228 */     this.chkCodigos = chkCodigos;
/*      */   }
/*      */ 
/*      */   public int getContador() {
/*  232 */     return this.contador;
/*      */   }
/*      */ 
/*      */   public void setContador(int contador) {
/*  236 */     this.contador = contador;
/*      */   }
/*      */ 
/*      */   public int getIndice()
/*      */   {
/*  243 */     return this.indice;
/*      */   }
/*      */ 
/*      */   public int getNroBloque()
/*      */   {
/*  250 */     return this.nroBloque;
/*      */   }
/*      */ 
/*      */   public int getRegistrosPorBloque()
/*      */   {
/*  257 */     return this.registrosPorBloque;
/*      */   }
/*      */ 
/*      */   public int getTotalRegistros()
/*      */   {
/*  264 */     return this.totalRegistros;
/*      */   }
/*      */ 
/*      */   public void setIndice(int i)
/*      */   {
/*  271 */     this.indice = i;
/*      */   }
/*      */ 
/*      */   public void setNroBloque(int i)
/*      */   {
/*  278 */     this.nroBloque = i;
/*      */   }
/*      */ 
/*      */   public void setRegistrosPorBloque(int i)
/*      */   {
/*  285 */     this.registrosPorBloque = i;
/*      */   }
/*      */ 
/*      */   public void setTotalRegistros(int i)
/*      */   {
/*  292 */     this.totalRegistros = i;
/*      */   }
/*      */ 
/*      */   public String getHayDatos()
/*      */   {
/*  299 */     return this.hayDatos;
/*      */   }
/*      */ 
/*      */   public String getHayProximoBloque()
/*      */   {
/*  306 */     return this.hayProximoBloque;
/*      */   }
/*      */ 
/*      */   public void setHayDatos(String string)
/*      */   {
/*  313 */     this.hayDatos = string;
/*      */   }
/*      */ 
/*      */   public void setHayProximoBloque(String string)
/*      */   {
/*  320 */     this.hayProximoBloque = string;
/*      */   }
/*      */ 
/*      */   public Vector getListaPagina()
/*      */   {
/*  327 */     return this.listaPagina;
/*      */   }
/*      */ 
/*      */   public void setListaPagina(Vector vector)
/*      */   {
/*  334 */     this.listaPagina = vector;
/*      */   }
/*      */ 
/*      */   public Vector getVctElemento()
/*      */   {
/*  341 */     return this.vctElemento;
/*      */   }
/*      */ 
/*      */   public void setVctElemento(Vector vector)
/*      */   {
/*  348 */     this.vctElemento = vector;
/*      */   }
/*      */ 
/*      */   public String getCredito()
/*      */   {
/*  355 */     return this.credito;
/*      */   }
/*      */ 
/*      */   public void setCredito(String credito)
/*      */   {
/*  363 */     this.credito = credito;
/*      */   }
/*      */ 
/*      */   public String getNombres()
/*      */   {
/*  371 */     return this.nombres;
/*      */   }
/*      */ 
/*      */   public void setNombres(String nombre)
/*      */   {
/*  379 */     this.nombres = nombre;
/*      */   }
/*      */ 
/*      */   public String getRut()
/*      */   {
/*  386 */     return this.rut;
/*      */   }
/*      */ 
/*      */   public void setRut(String rut)
/*      */   {
/*  394 */     this.rut = rut;
/*      */   }
/*      */ 
/*      */   public String getApellidoMaterno()
/*      */   {
/*  401 */     return this.apellidoMaterno;
/*      */   }
/*      */ 
/*      */   public void setApellidoMaterno(String apellidoMaterno)
/*      */   {
/*  409 */     this.apellidoMaterno = apellidoMaterno;
/*      */   }
/*      */ 
/*      */   public String getApellidoPaterno()
/*      */   {
/*  416 */     return this.apellidoPaterno;
/*      */   }
/*      */ 
/*      */   public void setApellidoPaterno(String apellidoPaterno)
/*      */   {
/*  424 */     this.apellidoPaterno = apellidoPaterno;
/*      */   }
/*      */ 
/*      */   public String getCalle()
/*      */   {
/*  431 */     return this.calle;
/*      */   }
/*      */ 
/*      */   public void setCalle(String calle)
/*      */   {
/*  439 */     this.calle = calle;
/*      */   }
/*      */ 
/*      */   public String getCiudad()
/*      */   {
/*  446 */     return this.ciudad;
/*      */   }
/*      */ 
/*      */   public void setCiudad(String ciudad)
/*      */   {
/*  454 */     this.ciudad = ciudad;
/*      */   }
/*      */ 
/*      */   public String getCodAutorizacion()
/*      */   {
/*  461 */     return this.codAutorizacion;
/*      */   }
/*      */ 
/*      */   public void setCodAutorizacion(String codAutorizacion)
/*      */   {
/*  469 */     this.codAutorizacion = codAutorizacion;
/*      */   }
/*      */ 
/*      */   public String getCodigoCP()
/*      */   {
/*  476 */     return this.codigoCP;
/*      */   }
/*      */ 
/*      */   public void setCodigoCP(String codigoCP)
/*      */   {
/*  484 */     this.codigoCP = codigoCP;
/*      */   }
/*      */ 
/*      */   public String getCodigoProducto()
/*      */   {
/*  491 */     return this.codigoProducto;
/*      */   }
/*      */ 
/*      */   public void setCodigoProducto(String codigoProducto)
/*      */   {
/*  499 */     this.codigoProducto = codigoProducto;
/*      */   }
/*      */ 
/*      */   public String getComuna()
/*      */   {
/*  506 */     return this.comuna;
/*      */   }
/*      */ 
/*      */   public void setComuna(String comuna)
/*      */   {
/*  514 */     this.comuna = comuna;
/*      */   }
/*      */ 
/*      */   public String getDepartamento()
/*      */   {
/*  521 */     return this.departamento;
/*      */   }
/*      */ 
/*      */   public void setDepartamento(String departamento)
/*      */   {
/*  529 */     this.departamento = departamento;
/*      */   }
/*      */ 
/*      */   public String getEjecutivo()
/*      */   {
/*  536 */     return this.ejecutivo;
/*      */   }
/*      */ 
/*      */   public void setEjecutivo(String ejecutivo)
/*      */   {
/*  544 */     this.ejecutivo = ejecutivo;
/*      */   }
/*      */ 
/*      */   public String getEstado()
/*      */   {
/*  551 */     return this.estado;
/*      */   }
/*      */ 
/*      */   public void setEstado(String estado)
/*      */   {
/*  559 */     this.estado = estado;
/*      */   }
/*      */ 
/*      */   public String getMonto()
/*      */   {
/*  566 */     return this.monto;
/*      */   }
/*      */ 
/*      */   public void setMonto(String monto)
/*      */   {
/*  574 */     this.monto = monto;
/*      */   }
/*      */ 
/*      */   public String getNombreCP()
/*      */   {
/*  581 */     return this.nombreCP;
/*      */   }
/*      */ 
/*      */   public void setNombreCP(String nombreCP)
/*      */   {
/*  589 */     this.nombreCP = nombreCP;
/*      */   }
/*      */ 
/*      */   public String getNombreProducto()
/*      */   {
/*  596 */     return this.nombreProducto;
/*      */   }
/*      */ 
/*      */   public void setNombreProducto(String nombreProducto)
/*      */   {
/*  604 */     this.nombreProducto = nombreProducto;
/*      */   }
/*      */ 
/*      */   public String getNumero()
/*      */   {
/*  611 */     return this.numero;
/*      */   }
/*      */ 
/*      */   public void setNumero(String numero)
/*      */   {
/*  619 */     this.numero = numero;
/*      */   }
/*      */ 
/*      */   public String getObservacion()
/*      */   {
/*  626 */     return this.observacion;
/*      */   }
/*      */ 
/*      */   public void setObservacion(String observacion)
/*      */   {
/*  634 */     this.observacion = observacion;
/*      */   }
/*      */ 
/*      */   public String getOrdenCompra()
/*      */   {
/*  641 */     return this.ordenCompra;
/*      */   }
/*      */ 
/*      */   public void setOrdenCompra(String ordenCompra)
/*      */   {
/*  649 */     this.ordenCompra = ordenCompra;
/*      */   }
/*      */ 
/*      */   public String getReferencia()
/*      */   {
/*  656 */     return this.referencia;
/*      */   }
/*      */ 
/*      */   public void setReferencia(String referencia)
/*      */   {
/*  664 */     this.referencia = referencia;
/*      */   }
/*      */ 
/*      */   public String getTelefono1()
/*      */   {
/*  671 */     return this.telefono1;
/*      */   }
/*      */ 
/*      */   public void setTelefono1(String telefono1)
/*      */   {
/*  679 */     this.telefono1 = telefono1;
/*      */   }
/*      */ 
/*      */   public String getTelefono2()
/*      */   {
/*  686 */     return this.telefono2;
/*      */   }
/*      */ 
/*      */   public void setTelefono2(String telefono2)
/*      */   {
/*  694 */     this.telefono2 = telefono2;
/*      */   }
/*      */ 
/*      */   public String getVilla()
/*      */   {
/*  701 */     return this.villa;
/*      */   }
/*      */ 
/*      */   public void setVilla(String villa)
/*      */   {
/*  708 */     this.villa = villa;
/*      */   }
/*      */ 
/*      */   public String getCodEstado()
/*      */   {
/*  716 */     return this.codEstado;
/*      */   }
/*      */ 
/*      */   public void setCodEstado(String codEstado)
/*      */   {
/*  722 */     this.codEstado = codEstado;
/*      */   }
/*      */ 
/*      */   public Collection getCollEstado()
/*      */   {
/*  728 */     return this.collEstado;
/*      */   }
/*      */ 
/*      */   public void setCollEstado(Collection collEstado)
/*      */   {
/*  734 */     this.collEstado = collEstado;
/*      */   }
/*      */ 
/*      */   public String getGlosaEstado()
/*      */   {
/*  740 */     return this.glosaEstado;
/*      */   }
/*      */ 
/*      */   public void setGlosaEstado(String glosaEstado)
/*      */   {
/*  746 */     this.glosaEstado = glosaEstado;
/*      */   }
/*      */ 
/*      */   public String[] getSelectEstado()
/*      */   {
/*  752 */     return this.selectEstado;
/*      */   }
/*      */ 
/*      */   public void setSelectEstado(String[] selectEstado)
/*      */   {
/*  758 */     this.selectEstado = selectEstado;
/*      */   }
/*      */ 
/*      */   public String getDv()
/*      */   {
/*  766 */     return this.dv;
/*      */   }
/*      */ 
/*      */   public void setDv(String dv)
/*      */   {
/*  772 */     this.dv = dv;
/*      */   }
/*      */ 
/*      */   public String getFechaCredito()
/*      */   {
/*  781 */     return this.fechaCredito;
/*      */   }
/*      */ 
/*      */   public void setFechaCredito(String fechaCredito)
/*      */   {
/*  787 */     this.fechaCredito = fechaCredito;
/*      */   }
/*      */ 
/*      */   public String getFechaTermino()
/*      */   {
/*  793 */     return this.fechaTermino;
/*      */   }
/*      */ 
/*      */   public void setFechaTermino(String fechaTermino)
/*      */   {
/*  799 */     this.fechaTermino = fechaTermino;
/*      */   }
/*      */ 
/*      */   public int getTotalPaginas()
/*      */   {
/*  806 */     return this.totalPaginas;
/*      */   }
/*      */ 
/*      */   public void setTotalPaginas(int i)
/*      */   {
/*  813 */     this.totalPaginas = i;
/*      */   }
/*      */ 
/*      */   public String getFlagDatosBD()
/*      */   {
/*  821 */     return this.flagDatosBD;
/*      */   }
/*      */ 
/*      */   public void setFlagDatosBD(String string)
/*      */   {
/*  828 */     this.flagDatosBD = string;
/*      */   }
/*      */ 
/*      */   public String getCodigo()
/*      */   {
/*  835 */     return this.codigo;
/*      */   }
/*      */ 
/*      */   public void setCodigo(String string)
/*      */   {
/*  842 */     this.codigo = string;
/*      */   }
/*      */ 
/*      */   public String getCodEjecutivo()
/*      */   {
/*  850 */     return this.codEjecutivo;
/*      */   }
/*      */ 
/*      */   public void setCodEjecutivo(String codEjecutivo)
/*      */   {
/*  856 */     this.codEjecutivo = codEjecutivo;
/*      */   }
/*      */ 
/*      */   public Collection getCollEjecutivo()
/*      */   {
/*  862 */     return this.collEjecutivo;
/*      */   }
/*      */ 
/*      */   public void setCollEjecutivo(Collection collEjecutivo)
/*      */   {
/*  868 */     this.collEjecutivo = collEjecutivo;
/*      */   }
/*      */ 
/*      */   public String getGlosaEjecutivo()
/*      */   {
/*  874 */     return this.glosaEjecutivo;
/*      */   }
/*      */ 
/*      */   public void setGlosaEjecutivo(String glosaEjecutivo)
/*      */   {
/*  880 */     this.glosaEjecutivo = glosaEjecutivo;
/*      */   }
/*      */ 
/*      */   public String[] getSelectEjecutivo()
/*      */   {
/*  886 */     return this.selectEjecutivo;
/*      */   }
/*      */ 
/*      */   public void setSelectEjecutivo(String[] selectEjecutivo)
/*      */   {
/*  892 */     this.selectEjecutivo = selectEjecutivo;
/*      */   }
/*      */ 
/*      */   public String getTipoFiltro()
/*      */   {
/*  900 */     return this.tipoFiltro;
/*      */   }
/*      */ 
/*      */   public void setTipoFiltro(String tipoFiltro)
/*      */   {
/*  906 */     this.tipoFiltro = tipoFiltro;
/*      */   }
/*      */ 
/*      */   public String getCreditoFiltro()
/*      */   {
/*  913 */     return this.creditoFiltro;
/*      */   }
/*      */ 
/*      */   public String getEstadoFiltro()
/*      */   {
/*  920 */     return this.estadoFiltro;
/*      */   }
/*      */ 
/*      */   public String getFechaFiltro()
/*      */   {
/*  927 */     return this.fechaFiltro;
/*      */   }
/*      */ 
/*      */   public String getMaternoFiltro()
/*      */   {
/*  934 */     return this.maternoFiltro;
/*      */   }
/*      */ 
/*      */   public String getNombreFiltro()
/*      */   {
/*  941 */     return this.nombreFiltro;
/*      */   }
/*      */ 
/*      */   public String getPaternoFiltro()
/*      */   {
/*  948 */     return this.paternoFiltro;
/*      */   }
/*      */ 
/*      */   public String getRutFiltro()
/*      */   {
/*  955 */     return this.rutFiltro;
/*      */   }
/*      */ 
/*      */   public void setCreditoFiltro(String string)
/*      */   {
/*  962 */     this.creditoFiltro = string;
/*      */   }
/*      */ 
/*      */   public void setEstadoFiltro(String string)
/*      */   {
/*  969 */     this.estadoFiltro = string;
/*      */   }
/*      */ 
/*      */   public void setFechaFiltro(String string)
/*      */   {
/*  976 */     this.fechaFiltro = string;
/*      */   }
/*      */ 
/*      */   public void setMaternoFiltro(String string)
/*      */   {
/*  983 */     this.maternoFiltro = string;
/*      */   }
/*      */ 
/*      */   public void setNombreFiltro(String string)
/*      */   {
/*  990 */     this.nombreFiltro = string;
/*      */   }
/*      */ 
/*      */   public void setPaternoFiltro(String string)
/*      */   {
/*  997 */     this.paternoFiltro = string;
/*      */   }
/*      */ 
/*      */   public void setRutFiltro(String string)
/*      */   {
/* 1004 */     this.rutFiltro = string;
/*      */   }
/*      */ 
/*      */   public String getCodEstadoFiltro()
/*      */   {
/* 1011 */     return this.codEstadoFiltro;
/*      */   }
/*      */ 
/*      */   public Collection getCollEstadoFiltro()
/*      */   {
/* 1018 */     return this.collEstadoFiltro;
/*      */   }
/*      */ 
/*      */   public String getGlosaEstadoFiltro()
/*      */   {
/* 1025 */     return this.glosaEstadoFiltro;
/*      */   }
/*      */ 
/*      */   public String[] getSelectEstadoFiltro()
/*      */   {
/* 1032 */     return this.selectEstadoFiltro;
/*      */   }
/*      */ 
/*      */   public void setCodEstadoFiltro(String string)
/*      */   {
/* 1039 */     this.codEstadoFiltro = string;
/*      */   }
/*      */ 
/*      */   public void setCollEstadoFiltro(Collection collection)
/*      */   {
/* 1046 */     this.collEstadoFiltro = collection;
/*      */   }
/*      */ 
/*      */   public void setGlosaEstadoFiltro(String string)
/*      */   {
/* 1053 */     this.glosaEstadoFiltro = string;
/*      */   }
/*      */ 
/*      */   public void setSelectEstadoFiltro(String[] strings)
/*      */   {
/* 1060 */     this.selectEstadoFiltro = strings;
/*      */   }
/*      */ 
/*      */   public String getDvFiltro()
/*      */   {
/* 1067 */     return this.dvFiltro;
/*      */   }
/*      */ 
/*      */   public void setDvFiltro(String string)
/*      */   {
/* 1074 */     this.dvFiltro = string;
/*      */   }
/*      */ 
/*      */   public String getFilas()
/*      */   {
/* 1082 */     return this.filas;
/*      */   }
/*      */ 
/*      */   public void setFilas(String filas)
/*      */   {
/* 1088 */     this.filas = filas;
/*      */   }
/*      */ 
/*      */   public String getCodEjecutivoFiltro()
/*      */   {
/* 1095 */     return this.codEjecutivoFiltro;
/*      */   }
/*      */ 
/*      */   public Collection getCollEjecutivoFiltro()
/*      */   {
/* 1102 */     return this.collEjecutivoFiltro;
/*      */   }
/*      */ 
/*      */   public String getGlosaEjecutivoFiltro()
/*      */   {
/* 1109 */     return this.glosaEjecutivoFiltro;
/*      */   }
/*      */ 
/*      */   public String[] getSelectEjecutivoFiltro()
/*      */   {
/* 1116 */     return this.selectEjecutivoFiltro;
/*      */   }
/*      */ 
/*      */   public void setCodEjecutivoFiltro(String string)
/*      */   {
/* 1123 */     this.codEjecutivoFiltro = string;
/*      */   }
/*      */ 
/*      */   public void setCollEjecutivoFiltro(Collection collection)
/*      */   {
/* 1130 */     this.collEjecutivoFiltro = collection;
/*      */   }
/*      */ 
/*      */   public void setGlosaEjecutivoFiltro(String string)
/*      */   {
/* 1137 */     this.glosaEjecutivoFiltro = string;
/*      */   }
/*      */ 
/*      */   public void setSelectEjecutivoFiltro(String[] strings)
/*      */   {
/* 1144 */     this.selectEjecutivoFiltro = strings;
/*      */   }
/*      */ }

/* Location:           C:\sitios\GestionTV_Ripley\trunk\docs\01 Requerimiento\Fuentes Gestión TV\GestionTV-WC7\WEB-INF\classes\
 * Qualified Name:     cl.ripley.GestionTV.struts.form.VtaBancoForm
 * JD-Core Version:    0.6.2
 */