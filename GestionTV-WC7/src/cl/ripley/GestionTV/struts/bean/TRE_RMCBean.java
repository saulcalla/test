 package cl.ripley.GestionTV.struts.bean;
 
 import cl.ripley.GestionTV.comun.ConectaBD;
 import cl.ripley.GestionTV.comun.DownFile;
 import cl.ripley.GestionTV.comun.Util;
 import java.sql.ResultSet;
 import java.text.SimpleDateFormat;
 import java.util.Date;
 import java.util.Map;
 import java.util.Vector;
 import javax.sql.DataSource;
 import org.apache.log4j.Logger;
 import org.apache.struts.util.MessageResources;
 
 public class TRE_RMCBean extends ConectaBD
 {
   static Logger log = Logger.getRootLogger();
   protected static MessageResources messages = MessageResources.getMessageResources("cl.ripley.GestionTV.struts.msgGestionTV");
   private String accion;
   private Vector vctDetalles;
   private String fec_inicio;
   private String codSucursal;
   private String glosaSucursal;
   private int contador = 0;
   private String flagDatosBD = "si";
   private String hayDatos = "no";
   private String hayDatosExportar = "no";
   private String hayProximoBloque = "si";
   private int indice = 0;
   private Vector listaPagina = new Vector();
   private String mensaje = "";
   private int nroBloque = -1;
   private int registrosPorBloque = 10;
   private int totalPaginas = 0;
   private int totalRegistros = 0;
   private int totalReg = 0;
   private Vector vctExportar = new Vector();
   private Vector vctExpHead = new Vector();
   private String numRMC;
   private String rutEmpresa;
   private String glosaTarjeta;
   private String estado;
   private String area;
   private String numConvenio;
   private String numLote;
   private String fechaVcto;
   private String fechaVctoOrigen;
   private String montoOtorgado;
   private String saldoDisponible;
   private String grupoDepto;
   private Object[] departamentos;
 
   public Vector getDatosTRE(DataSource dataSource, String numTRE)
   {
     Vector vRes = new Vector();
     String vInstruccion = "";
     Vector vWhere = new Vector();
     int intRes = 0;
     SimpleDateFormat sdf = new SimpleDateFormat("ddyyyy");
 
     if (conecta(dataSource))
     {
       try
       {
         vInstruccion = "gestion_78.inst01";
         vWhere.add("String," + numTRE);
 
         consultaRst(dataSource, vInstruccion, vWhere);
 
         setContador(vRes.size());
 
         while (getRst().next())
         {
           intRes++;
           setHayDatos("si");
 
           setRutEmpresa(getRst().getString("RUT_EMPRESA"));
 
           setArea(getRst().getString("COD_AREA"));
 
           setNumConvenio(getRst().getString("NUM_CONVENIO"));
 
           setNumLote(getRst().getString("NUM_LOTE"));
 
           setMontoOtorgado(getRst().getString("MONTO_OTORGADO"));
 
           setSaldoDisponible(getRst().getString("SALDO_DISP"));
 
           if (getRst().getDate("FEC_VCTO_TARJ") == null) {
             setFechaVcto("");
           }
           else {
             Date fec_venc = getRst().getDate("FEC_VCTO_TARJ");
             setFechaVcto(sdf.format(fec_venc));
           }
 
           setEstado(getRst().getString("ESTADO"));
 
           setGlosaTarjeta(getRst().getString("GLOSA"));
 
           if (getRst().getDate("FCH_VCTO_ORI") == null) {
             setFechaVctoOrigen("");
           }
           else {
             Date fec_venc = getRst().getDate("FCH_VCTO_ORI");
 
             setFechaVctoOrigen(sdf.format(fec_venc));
           }
 
         }
 
       }
       catch (Exception e)
       {
         log.error("::Exception, Al obtener datos TRE-RMC " + 
           e.getMessage());
       }
       finally {
         cierraRst();
       }
     }
 
     return vRes;
   }
 
   public void getDepartamentos(DataSource dataSource, String numTRE)
   {
     Vector vRes = new Vector();
 
     String vInstruccion = "";
     Vector vWhere = new Vector();
     String grup_depto = "";
     String desc_depto = "";
     if (conecta(dataSource))
     {
       try
       {
         vInstruccion = "gestion_78.inst02";
         vWhere.add("String," + numTRE);
 
         consultaRst(dataSource, vInstruccion, vWhere);
 
         while (getRst().next())
         {
           grup_depto = getRst().getString("grupo_depto");
           desc_depto = getRst().getString("desc_depto") + " - " + getRst().getString("cod_depto");
           vRes.add(desc_depto);
         }
 
         if (vRes.size() == 0) {
           setGrupoDepto(grup_depto);
           vRes.add("NO HAY DATOS");
           setDepartamentos(vRes.toArray());
         } else {
           setGrupoDepto(grup_depto);
           setDepartamentos(vRes.toArray());
         }
 
       }
       catch (Exception e)
       {
         log.error("ERROR:: Al obtener departamentos TRE " + e);
         setGrupoDepto("");
       }
       finally {
         cierraRst();
       }
     }
   }
 
   public int grabarRMC(DataSource dataSource, String numTRE, String nro_rmc, String usuario, String rutUsuario, String cod_sucursal, String desc_sucursal)
   {
     Date fecha = new Date();
     String vInstruccion = "";
     int intRes = 0;
     SimpleDateFormat sdf = new SimpleDateFormat(messages.getMessage("constante.FORMATO_FECHA_GCP"));
     Vector update = new Vector();
     if (conecta(dataSource))
     {
       try
       {
         vInstruccion = (String)Util.getMap().get("gestion_78.inst03");
 
         vInstruccion = vInstruccion + numTRE + ",";
 
         vInstruccion = vInstruccion + nro_rmc + ",";
 
         vInstruccion = vInstruccion + "'" + usuario + "',";
 
         vInstruccion = vInstruccion + rutUsuario + ",";
 
         vInstruccion = vInstruccion + cod_sucursal + ",";
 
         vInstruccion = vInstruccion + "'" + desc_sucursal + "',";
 
         vInstruccion = vInstruccion + "to_date('" + sdf.format(fecha) + "','dd-mm-yyyy HH24:MI:SS') )";
 
         update.add(vInstruccion);
 
         intRes = update_sql(dataSource, update);
       }
       catch (Exception e)
       {
         log.error("ERROR:: Al grabar RMC - TRE " + e);
         setMens_error("ERROR:: Al grabar RMC");
         return -1;
       } finally {
         cierraRst();
       }
 
     }
 
     return intRes;
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
 
   public void setListaPagina(Vector vector)
   {
     this.listaPagina = vector;
   }
 
   public int getTotalPaginas() {
     int p = 0;
 
     int r = getRegistrosPorBloque();
 
     if (r != 0) {
       p = getTotalReg() / r;
       int b = p * r;
 
       if (b != getTotalReg())
       {
         p++;
       }
     }
     this.totalPaginas = p;
     return this.totalPaginas;
   }
 
   public int getIndice()
   {
     return this.indice;
   }
 
   public int getNroBloque()
   {
     return this.nroBloque;
   }
 
   public int getRegistrosPorBloque()
   {
     if (this.registrosPorBloque == 0) {
       this.registrosPorBloque = 10;
     }
     return this.registrosPorBloque;
   }
 
   public void setIndice(int i)
   {
     this.indice = i;
   }
 
   public void setNroBloque(int i)
   {
     this.nroBloque = i;
   }
 
   public void setRegistrosPorBloque(int i)
   {
     this.registrosPorBloque = i;
   }
 
   public String getHayDatos()
   {
     return this.hayDatos;
   }
 
   public void setHayDatos(String string)
   {
     this.hayDatos = string;
   }
 
   public String getHayProximoBloque()
   {
     return this.hayProximoBloque;
   }
 
   public void setHayProximoBloque(String string)
   {
     this.hayProximoBloque = string;
   }
 
   public void setTotalPaginas(int i)
   {
     this.totalPaginas = i;
   }
 
   public Vector getVctDetalles()
   {
     return this.vctDetalles;
   }
 
   public void setVctDetalles(Vector vector)
   {
     this.vctDetalles = vector;
   }
 
   public static MessageResources getMessages()
   {
     return messages;
   }
 
   public String getMensaje()
   {
     return this.mensaje;
   }
 
   public void setMensaje(String string)
   {
     this.mensaje = string;
   }
 
   public int getContador()
   {
     return this.contador;
   }
 
   public void setContador(int i)
   {
     this.contador = i;
   }
 
   public int getTotalReg()
   {
     return this.totalReg;
   }
 
   public void setTotalReg(int i)
   {
     this.totalReg = i;
   }
 
   public int getTotalRegistros()
   {
     return this.totalRegistros;
   }
 
   public void setTotalRegistros(int i)
   {
     this.totalRegistros = i;
   }
 
   public Vector filtra(ResultSet rst)
   {
     Vector vct_paso = new Vector();
     Vector f = new Vector();
     int k = 0;
     try {
       while (rst.next()) {
         Vector campos = new Vector();
         for (int i = 1; i <= 7; i++)
         {
           if (i == 4)
           {
             String estado = rst.getString(i).toString();
             if (estado.equals("1")) {
               estado = "PENDTE. IMPRESION";
             }
             if (estado.equals("2")) {
               estado = "IMPRESA";
             }
             if (estado.equals("3")) {
               estado = "NC";
             }
             if (estado.equals("4")) {
               estado = "NC";
             }
             campos.add(estado);
           }
           else
           {
             campos.add(rst.getString(i).toString());
           }
         }
         f = (Vector)campos.clone();
         vct_paso.add(k, f);
         k++;
         campos.clear();
       }
     }
     catch (Exception e) {
       log.error("::Exception, " + e.getMessage() + "\n" + 
         e.getCause().toString());
     } finally {
       cierraRst();
     }
     return vct_paso;
   }
 
   public String getFec_inicio()
   {
     return this.fec_inicio;
   }
 
   public void setFec_inicio(String string)
   {
     this.fec_inicio = string;
   }
 
   public Vector getVctExpHead()
   {
     return this.vctExpHead;
   }
 
   public Vector getVctExportar()
   {
     return this.vctExportar;
   }
 
   public void setVctExpHead(Vector vector)
   {
     this.vctExpHead = vector;
   }
 
   public void setVctExportar(Vector vector)
   {
     this.vctExportar = vector;
   }
 
   public Vector getVectorExportar(DataSource dataSource)
   {
     Vector vRes = new Vector();
     String statement = "";
     Vector vWhere = new Vector();
 
     if (conecta(dataSource))
     {
       statement = (String)Util.getMap().get("gestion_53.inst03");
 
       vRes = consulta(dataSource, statement, vWhere, 7);
     }
     cierraRst();
 
     if (vRes.size() != 0)
       setHayDatosExportar("si");
     else {
       setHayDatosExportar("no");
     }
     return vRes;
   }
 
   public String enviarArchivo()
   {
     DownFile objDown = new DownFile();
     String exportFile = 
       objDown.enviarArchivo(this.vctExpHead, this.vctDetalles);
     setMensaje(DownFile.getMensaje());
     return exportFile;
   }
 
   public String getHayDatosExportar()
   {
     return this.hayDatosExportar;
   }
 
   public void setHayDatosExportar(String string)
   {
     this.hayDatosExportar = string;
   }
 
   public String getCodSucursal()
   {
     return this.codSucursal;
   }
 
   public void setCodSucursal(String codSucursal)
   {
     this.codSucursal = codSucursal;
   }
 
   public String getGlosaSucursal()
   {
     return this.glosaSucursal;
   }
 
   public void setGlosaSucursal(String glosaSucursal)
   {
     this.glosaSucursal = glosaSucursal;
   }
 
   public String getNumRMC()
   {
     return this.numRMC;
   }
 
   public void setNumRMC(String numRMC)
   {
     this.numRMC = numRMC;
   }
 
   public String getRutEmpresa()
   {
     return this.rutEmpresa;
   }
 
   public void setRutEmpresa(String rutEmpresa)
   {
     this.rutEmpresa = rutEmpresa;
   }
 
   public String getGlosaTarjeta()
   {
     return this.glosaTarjeta;
   }
 
   public void setGlosaTarjeta(String glosaTarjeta)
   {
     this.glosaTarjeta = glosaTarjeta;
   }
 
   public String getEstado()
   {
     return this.estado;
   }
 
   public void setEstado(String estado)
   {
     this.estado = estado;
   }
 
   public String getArea()
   {
     return this.area;
   }
 
   public void setArea(String area)
   {
     this.area = area;
   }
 
   public String getNumConvenio()
   {
     return this.numConvenio;
   }
 
   public void setNumConvenio(String numConvenio)
   {
     this.numConvenio = numConvenio;
   }
 
   public String getNumLote()
   {
     return this.numLote;
   }
 
   public void setNumLote(String numLote)
   {
     this.numLote = numLote;
   }
 
   public String getFechaVcto()
   {
     return this.fechaVcto;
   }
 
   public void setFechaVcto(String fechaVcto)
   {
     this.fechaVcto = fechaVcto;
   }
 
   public String getFechaVctoOrigen()
   {
     return this.fechaVctoOrigen;
   }
 
   public void setFechaVctoOrigen(String fechaVctoOrigen)
   {
     this.fechaVctoOrigen = fechaVctoOrigen;
   }
 
   public String getMontoOtorgado()
   {
     return this.montoOtorgado;
   }
 
   public void setMontoOtorgado(String montoOtorgado)
   {
     this.montoOtorgado = montoOtorgado;
   }
 
   public String getSaldoDisponible()
   {
     return this.saldoDisponible;
   }
 
   public void setSaldoDisponible(String saldoDisponible)
   {
     this.saldoDisponible = saldoDisponible;
   }
 
   public Object[] getDepartamentos()
   {
     return this.departamentos;
   }
 
   public void setDepartamentos(Object[] departamentos)
   {
     this.departamentos = departamentos;
   }
 
   public String getGrupoDepto()
   {
     return this.grupoDepto;
   }
 
   public void setGrupoDepto(String grupoDepto)
   {
     this.grupoDepto = grupoDepto;
   }
 }

/* Location:           C:\sitios\GestionTV_Ripley\trunk\docs\01 Requerimiento\Fuentes Gestión TV\GestionTV-WC7\WEB-INF\classes\
 * Qualified Name:     cl.ripley.GestionTV.struts.bean.TRE_RMCBean
 * JD-Core Version:    0.6.2
 */