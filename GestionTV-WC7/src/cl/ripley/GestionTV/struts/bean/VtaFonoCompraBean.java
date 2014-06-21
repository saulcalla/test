 package cl.ripley.GestionTV.struts.bean;
 
 import cl.ripley.GestionTV.comun.ConectaBD;
 import cl.ripley.GestionTV.comun.Util;
 import java.util.Map;
 import java.util.Vector;
 import javax.sql.DataSource;
 import org.apache.struts.util.MessageResources;
 
 public class VtaFonoCompraBean extends ConectaBD
 {
   protected static MessageResources messages = MessageResources.getMessageResources("cl.ripley.GestionTV.struts.msgGestionTV");
   private String fechaCredito;
   private String fechaTermino;
   private String credito;
   private String rut;
   private String dv;
   private String nombres;
   private String apellidoMaterno;
   private String apellidoPaterno;
   private String numero;
   private String comuna;
   private String ciudad;
   private String telefono1;
   private String telefono2;
   private String codigoProducto;
   private String estado;
   private String observacion;
   private String codigoCP;
   private String nombreCP;
   private String ejecutivo;
   private String calle;
   private String departamento;
   private String villa;
   private String referencia;
   private String nombreProducto;
   private String ordenCompra;
   private String monto;
   private String codAutorizacion;
   private String codEstado;
   private String glosaEstado;
   private String codigo;
   private String apellidos;
   private String codEjecutivo;
   private String filas;
   private String mensaje = new String("");
   private int contador = 0;
   private String hayDatos = "no";
   private String hayProximoBloque = "si";
   private int indice = 0;
   private int registrosPorBloque = 10;
   private int nroBloque = -1;
   private int totalRegistros = 0;
   private Vector vctElemento = new Vector();
   private Vector listaPagina = new Vector();
   private int totalPaginas = 0;
   private int totalReg = 0;
   private int sTamano;
 
   public String calculaDV(String rut)
   {
     int Sum = 0;
     int factor = 2;
     int largo = rut.length();
     int largo2 = rut.length();
     String car = "";
     String digito = "";
     int d = 0;
     for (int j = 0; j < largo2; j++)
     {
       car = rut.substring(largo - 1, largo);
 
       Sum += Integer.parseInt(car) * factor;
       if (factor == 7) {
         factor = 2;
       }
       else
       {
         factor++;
       }
       largo--;
     }
     d = 11 - Sum % 11;
     if (d == 10) {
       digito = "K";
     }
     else if (d == 11)
     {
       digito = "0";
     }
     else digito = String.valueOf(d);
 
     return digito;
   }
 
   public Vector getPaginacion(DataSource dataSource) {
     Vector vRes = new Vector();
     int maxIndice = getIndice() + getRegistrosPorBloque() + 1;
     String statement = (String)Util.getMap().get("gestion_20.inst01");
 
     if (conecta(dataSource)) {
       Vector vWhere = new Vector();
       vWhere.add("Int," + messages.getMessage("estado.ingresado"));
       vWhere.add("Int," + Integer.toString(getIndice()));
       vWhere.add("Int," + Integer.toString(maxIndice));
       vRes = consulta(dataSource, statement, vWhere, 9);
       cierraRst();
     }
     setContador(vRes.size());
     if (vRes.size() != 0) {
       setHayDatos("si");
       setNroBloque(
         getIndice() / getRegistrosPorBloque() + 1);
     } else {
       setHayDatos("no");
     }
     if (maxIndice < getTotalReg() + 1)
       setHayProximoBloque("si");
     else {
       setHayProximoBloque("no");
     }
     return vRes;
   }
 
   public boolean buscarCredito(DataSource dataSource)
   {
     Vector vRes = new Vector();
     boolean retorno = false;
     String statement = (String)Util.getMap().get("gestion_13.inst01");
 
     String[] vkey = getCodigo().split("#");
     setCredito(vkey[0]);
     setRut(vkey[1]);
 
     if (conecta(dataSource)) {
       Vector vWhere = new Vector();
       vWhere.add("String," + getCredito().trim());
       vWhere.add("String," + getRut().trim());
       vRes = consulta(dataSource, statement, vWhere, 21);
       cierraRst();
     }
     if (vRes.size() > 0) {
       retorno = true;
 
       for (int j = 0; j < vRes.size(); j++) {
         Vector b = (Vector)vRes.get(j);
         setNombres(Util.verificaNulo((String)b.get(0)));
         setApellidoMaterno(Util.verificaNulo((String)b.get(1)));
         setNumero(Util.verificaNulo((String)b.get(2)));
         setComuna(Util.verificaNulo((String)b.get(3)));
         setCiudad(Util.verificaNulo((String)b.get(4)));
         setTelefono1(Util.verificaNulo((String)b.get(5)));
         setCodigoProducto(Util.verificaNulo((String)b.get(6)));
         setObservacion(Util.verificaNulo((String)b.get(7)));
         setApellidoPaterno(Util.verificaNulo((String)b.get(8)));
         setCalle(Util.verificaNulo((String)b.get(9)));
         setDepartamento(Util.verificaNulo((String)b.get(10)));
         setVilla(Util.verificaNulo((String)b.get(11)));
         setReferencia(Util.verificaNulo((String)b.get(12)));
         setTelefono2(Util.verificaNulo((String)b.get(13)));
         setNombreProducto(Util.verificaNulo((String)b.get(14)));
         setRut(Util.verificaNulo((String)b.get(15)));
         setEjecutivo(Util.verificaNulo((String)b.get(16)));
         setMonto(Util.verificaNulo((String)b.get(17)));
         setCodigoCP(Util.verificaNulo((String)b.get(18)));
         setNombreCP(Util.verificaNulo((String)b.get(19)));
         setEstado(Util.verificaNulo((String)b.get(20)));
       }
     } else {
       setMensaje(messages.getMessage("Mensaje.error.modificar.no.existe", "credito: " + getCredito()));
     }
 
     return retorno;
   }
 
   public boolean modificarCredito(DataSource dataSource) {
     Vector vRes = new Vector();
     int intRes = 0;
     String statement = (String)Util.getMap().get("gestion_13.inst02");
     boolean retorno = false;
 
     if (conecta(dataSource)) {
       Vector vWhere = new Vector();
       vWhere.add("String," + Util.esNuloStr(getCodigoCP()));
       vWhere.add("String," + Util.esNuloStr(getNombreCP()));
       vWhere.add("String," + Util.esNuloStr(getOrdenCompra()));
       vWhere.add("String," + Util.esNuloStr(getObservacion()));
       vWhere.add("String," + Util.esNuloStr(getCodEstado()));
       vWhere.add("String," + Util.esNuloStr(getCodEjecutivo()));
       vWhere.add("String," + Util.esNuloStr(getCredito()));
       vWhere.add("String," + Util.esNuloStr(getRut()));
       intRes = inserta(dataSource, statement, vWhere);
       cierraRst();
     }
     if (intRes > 0) {
       setMensaje(messages.getMessage("banco.ok.Modificar"));
       retorno = true;
     } else {
       setMensaje(
         messages.getMessage(
         "Mensaje.error.modificar", 
         "crédito: " + getCredito()));
     }
     return retorno;
   }
 
   public Vector getListaPagina()
   {
     Vector v = new Vector();
 
     int p = getTotalPaginas();
 
     for (int i = 1; i <= p; i++) {
       v.add(Integer.toString(i));
     }
     this.listaPagina = v;
 
     return this.listaPagina;
   }
 
   public int getRegistrosPorBloque()
   {
     if (this.registrosPorBloque == 0) {
       this.registrosPorBloque = 10;
     }
     return this.registrosPorBloque;
   }
 
   public int getTotalPaginas()
   {
     int p = 0;
 
     int r = getRegistrosPorBloque();
 
     if (r != 0)
     {
       p = getTotalReg() / r;
       int b = p * r;
 
       if (b != getTotalReg()) {
         p++;
       }
     }
     this.totalPaginas = p;
     return this.totalPaginas;
   }
 
   public int getTotalRegistros(DataSource dataSource)
   {
     Vector vRes = new Vector();
     int intRes = 0;
     Vector vWhere = new Vector();
 
     String statement = (String)Util.getMap().get("gestion_20.inst02");
     vWhere.add("Int," + messages.getMessage("estado.ingresado"));
     if (conecta(dataSource)) {
       vRes = consulta(dataSource, statement, vWhere, 1);
       if (vRes.size() != 0) {
         Vector b = (Vector)vRes.elementAt(0);
         intRes = Integer.parseInt((String)b.get(0));
       }
       cierraRst();
     }
     return intRes;
   }
 
   public String getMensaje() {
     return this.mensaje;
   }
 
   public void setMensaje(String mensaje) {
     this.mensaje = mensaje;
   }
 
   public int getContador() {
     return this.contador;
   }
 
   public void setContador(int contador) {
     this.contador = contador;
   }
 
   public String getHayDatos() {
     return this.hayDatos;
   }
 
   public String getHayProximoBloque() {
     return this.hayProximoBloque;
   }
 
   public int getIndice() {
     return this.indice;
   }
 
   public int getNroBloque() {
     return this.nroBloque;
   }
   public void setHayDatos(String string) {
     this.hayDatos = string;
   }
 
   public void setHayProximoBloque(String string) {
     this.hayProximoBloque = string;
   }
 
   public void setIndice(int i) {
     this.indice = i;
   }
 
   public void setListaPagina(Vector vector) {
     this.listaPagina = vector;
   }
 
   public void setNroBloque(int i) {
     this.nroBloque = i;
   }
 
   public void setRegistrosPorBloque(int i) {
     this.registrosPorBloque = i;
   }
 
   public void setTotalPaginas(int i) {
     this.totalPaginas = i;
   }
 
   public Vector getVctElemento() {
     return this.vctElemento;
   }
 
   public void setVctElemento(Vector vector) {
     this.vctElemento = vector;
   }
 
   public int getTotalReg() {
     return this.totalReg;
   }
 
   public void setTotalReg(int i) {
     this.totalReg = i;
   }
 
   public static MessageResources getMessages()
   {
     return messages;
   }
 
   public static void setMessages(MessageResources resources)
   {
     messages = resources;
   }
 
   public void setTotalRegistros(int i)
   {
     this.totalRegistros = i;
   }
 
   public int getTotalRegistros()
   {
     return this.totalRegistros;
   }
 
   public String getApellidoMaterno()
   {
     return this.apellidoMaterno;
   }
 
   public void setApellidoMaterno(String apellidoMaterno)
   {
     this.apellidoMaterno = apellidoMaterno;
   }
 
   public String getApellidoPaterno()
   {
     return this.apellidoPaterno;
   }
 
   public void setApellidoPaterno(String apellidoPaterno)
   {
     this.apellidoPaterno = apellidoPaterno;
   }
 
   public String getCalle()
   {
     return this.calle;
   }
 
   public void setCalle(String calle)
   {
     this.calle = calle;
   }
 
   public String getCiudad()
   {
     return this.ciudad;
   }
 
   public void setCiudad(String ciudad)
   {
     this.ciudad = ciudad;
   }
 
   public String getCodAutorizacion()
   {
     return this.codAutorizacion;
   }
 
   public void setCodAutorizacion(String codAutorizacion)
   {
     this.codAutorizacion = codAutorizacion;
   }
 
   public String getCodigoCP()
   {
     return this.codigoCP;
   }
 
   public void setCodigoCP(String codigoCP)
   {
     this.codigoCP = codigoCP;
   }
 
   public String getCodigoProducto()
   {
     return this.codigoProducto;
   }
 
   public void setCodigoProducto(String codigoProducto)
   {
     this.codigoProducto = codigoProducto;
   }
 
   public String getComuna()
   {
     return this.comuna;
   }
 
   public void setComuna(String comuna)
   {
     this.comuna = comuna;
   }
 
   public String getCredito()
   {
     return this.credito;
   }
 
   public void setCredito(String credito)
   {
     this.credito = credito;
   }
 
   public String getDepartamento()
   {
     return this.departamento;
   }
 
   public void setDepartamento(String departamento)
   {
     this.departamento = departamento;
   }
 
   public String getEjecutivo()
   {
     return this.ejecutivo;
   }
 
   public void setEjecutivo(String ejecutivo)
   {
     this.ejecutivo = ejecutivo;
   }
 
   public String getEstado()
   {
     return this.estado;
   }
 
   public void setEstado(String estado)
   {
     this.estado = estado;
   }
 
   public String getMonto()
   {
     return this.monto;
   }
 
   public void setMonto(String monto)
   {
     this.monto = monto;
   }
 
   public String getNombreCP()
   {
     return this.nombreCP;
   }
 
   public void setNombreCP(String nombreCP)
   {
     this.nombreCP = nombreCP;
   }
 
   public String getNombreProducto()
   {
     return this.nombreProducto;
   }
 
   public void setNombreProducto(String nombreProducto)
   {
     this.nombreProducto = nombreProducto;
   }
 
   public String getNombres()
   {
     return this.nombres;
   }
 
   public void setNombres(String nombres)
   {
     this.nombres = nombres;
   }
 
   public String getNumero()
   {
     return this.numero;
   }
 
   public void setNumero(String numero)
   {
     this.numero = numero;
   }
 
   public String getObservacion()
   {
     return this.observacion;
   }
 
   public void setObservacion(String observacion)
   {
     this.observacion = observacion;
   }
 
   public String getOrdenCompra()
   {
     return this.ordenCompra;
   }
 
   public void setOrdenCompra(String ordenCompra)
   {
     this.ordenCompra = ordenCompra;
   }
 
   public String getReferencia()
   {
     return this.referencia;
   }
 
   public void setReferencia(String referencia)
   {
     this.referencia = referencia;
   }
 
   public String getRut()
   {
     return this.rut;
   }
 
   public void setRut(String rut)
   {
     this.rut = rut;
   }
 
   public int getSTamano()
   {
     return this.sTamano;
   }
 
   public void setSTamano(int tamano)
   {
     this.sTamano = tamano;
   }
 
   public String getTelefono1()
   {
     return this.telefono1;
   }
 
   public void setTelefono1(String telefono1)
   {
     this.telefono1 = telefono1;
   }
 
   public String getTelefono2()
   {
     return this.telefono2;
   }
 
   public void setTelefono2(String telefono2)
   {
     this.telefono2 = telefono2;
   }
 
   public String getVilla()
   {
     return this.villa;
   }
 
   public void setVilla(String villa)
   {
     this.villa = villa;
   }
 
   public String getCodEstado()
   {
     return this.codEstado;
   }
 
   public void setCodEstado(String codEstado)
   {
     this.codEstado = codEstado;
   }
 
   public String getGlosaEstado()
   {
     return this.glosaEstado;
   }
 
   public void setGlosaEstado(String glosaEstado)
   {
     this.glosaEstado = glosaEstado;
   }
 
   public String getDv()
   {
     return this.dv;
   }
 
   public void setDv(String dv)
   {
     this.dv = dv;
   }
 
   public String getFechaCredito()
   {
     return this.fechaCredito;
   }
 
   public void setFechaCredito(String fechaCredito)
   {
     this.fechaCredito = fechaCredito;
   }
 
   public String getFechaTermino()
   {
     return this.fechaTermino;
   }
 
   public void setFechaTermino(String fechaTermino)
   {
     this.fechaTermino = fechaTermino;
   }
 
   public String getCodigo()
   {
     return this.codigo;
   }
 
   public void setCodigo(String codigo)
   {
     this.codigo = codigo;
   }
 
   public String getApellidos()
   {
     return this.apellidos;
   }
 
   public void setApellidos(String apellidos)
   {
     this.apellidos = apellidos;
   }
 
   public String getFilas()
   {
     return this.filas;
   }
 
   public void setFilas(String filas)
   {
     this.filas = filas;
   }
 
   public String getCodEjecutivo()
   {
     return this.codEjecutivo;
   }
 
   public void setCodEjecutivo(String codEjecutivo)
   {
     this.codEjecutivo = codEjecutivo;
   }
 }

/* Location:           C:\sitios\GestionTV_Ripley\trunk\docs\01 Requerimiento\Fuentes Gestión TV\GestionTV-WC7\WEB-INF\classes\
 * Qualified Name:     cl.ripley.GestionTV.struts.bean.VtaFonoCompraBean
 * JD-Core Version:    0.6.2
 */