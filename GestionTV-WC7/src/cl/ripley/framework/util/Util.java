package cl.ripley.framework.util;

import java.io.PrintStream;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Vector;

public class Util
{
  private static Map vMap;

  public static String grabaNuloStr(String pValor)
  {
    if (pValor.equals("")) {
      return null;
    }
    return pValor.trim().toUpperCase();
  }

  public static String esNuloStr(String pValor)
  {
    if (pValor == null) {
      return "";
    }
    return pValor.trim().toUpperCase();
  }

  public static int ano(String pValor)
  {
    if (pValor.equals("")) {
      return 0;
    }
    return Integer.parseInt(pValor.substring(6, 10));
  }

  public static int mes(String pValor)
  {
    if (pValor.equals("")) {
      return 0;
    }
    return Integer.parseInt(pValor.substring(3, 5));
  }

  public static int dia(String pValor)
  {
    if (pValor.equals("")) {
      return 0;
    }
    return Integer.parseInt(pValor.substring(0, 2));
  }

  public static Vector stringToVector(String strVector)
  {
    Vector returnVector = new Vector();
    Vector elementVector = new Vector();
    String element = new String("");
    try
    {
      if (strVector != null)
      {
        for (int i = 1; i < strVector.length() - 1; i++) {
          if (strVector.substring(i, i + 1).equals("["))
          {
            elementVector.clear();
            element = "";
          }
          else if (strVector.substring(i, i + 1).equals(","))
          {
            elementVector.addElement(element);
            element = "";
            i++;
          }
          else if (strVector.substring(i, i + 1).equals("]"))
          {
            elementVector.addElement(element);
            returnVector.addElement(elementVector.clone());
          }
          else {
            element = element + strVector.substring(i, i + 1);
          }
        }
      }
    }
    catch (Exception localException)
    {
    }

    return returnVector;
  }

  public static java.util.Date stringToDate(String strDate, String format)
  {
    SimpleDateFormat formatter = new SimpleDateFormat(format);
    ParsePosition pos = new ParsePosition(0);
    java.util.Date datDate = formatter.parse(strDate, pos);
    return datDate;
  }

  public static java.sql.Date stringToDateBD(String strDate, String format)
  {
    java.sql.Date sqlDate = new java.sql.Date(stringToDate(strDate, format).getTime());
    return sqlDate;
  }

  public static String fMonto(String sMonto, String cFormat)
  {
    String resultado = new String("");
    if (!sMonto.equals(""))
    {
      for (; sMonto.length() > 3; sMonto = sMonto.substring(0, sMonto.length() - 3)) {
        resultado = cFormat + sMonto.substring(sMonto.length() - 3, sMonto.length()) + resultado;
      }
      resultado = sMonto + resultado;
    }
    return resultado;
  }

  public static Vector HeadAddBody(Vector VectorUno, Vector VectorDos)
  {
    Vector returnVector = new Vector();
    try
    {
      returnVector.addElement(VectorUno.firstElement());
      for (int i = 0; i < VectorDos.size(); i++) {
        returnVector.addElement(VectorDos.elementAt(i));
      }
    }
    catch (Exception localException)
    {
    }

    return returnVector;
  }

  public static String getFechaSistema()
  {
    java.util.Date d = new java.util.Date();
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", new Locale("es", "CL"));
    String fechaSistema = formatter.format(d);
    return fechaSistema;
  }

  public static String getHoraSistema()
  {
    java.util.Date d = new java.util.Date();
    SimpleDateFormat formatter = new SimpleDateFormat("hh:mm", new Locale("es", "CL"));
    String horaSistema = formatter.format(d);
    return horaSistema;
  }

  public static int convertirToNumero(String strNumerico)
  {
    int intRespuesta = -1;
    try
    {
      intRespuesta = Integer.parseInt(strNumerico);
    }
    catch (Exception e)
    {
      System.out.println(e.toString());
    }
    return intRespuesta;
  }

  public static long convertirToLong(String strNumerico)
  {
    long intRespuesta = -1L;
    try
    {
      intRespuesta = Long.parseLong(strNumerico);
    }
    catch (Exception e)
    {
      System.out.println(e.toString());
    }
    return intRespuesta;
  }

  public static void setMap(Map sMap)
  {
    vMap = sMap;
  }

  public static Map getMap()
  {
    return vMap;
  }

  public String rellenarDato(String numero, char caracterRelleno, int tamanioEsperado)
  {
    String alfanumerico = "";
    int tamanioActual = numero.trim().length();

    if (tamanioActual > tamanioEsperado) {
      return alfanumerico;
    }

    for (int i = 1; i <= tamanioEsperado - tamanioActual; i++) {
      alfanumerico = alfanumerico + caracterRelleno;
    }
    alfanumerico = alfanumerico + numero.trim();

    return alfanumerico;
  }

  public String rellenarDato(int numero, char caracterRelleno, int tamanioEsperado)
  {
    return rellenarDato(String.valueOf(numero).trim(), caracterRelleno, 
      tamanioEsperado);
  }

  public long getTimeFecha(Timestamp fecha) {
    if (fecha != null) {
      return fecha.getTime();
    }
    return 0L;
  }

  public String getFormatoFecha(Timestamp fecha)
  {
    if (fecha != null) {
      String resultado = getFormatoFecha("dd/MM/yyyy", fecha.getTime());

      return resultado;
    }
    return "";
  }

  public static String getFormatoFecha(String patron)
  {
    if ((patron == null) || (patron.equals(""))) {
      patron = "dd/MM/yyyy";
    }

    Timestamp fecha = getTimestamp();
    String resultado = getFormatoFecha(patron, fecha.getTime());

    return resultado;
  }

  public static String getFormatoFecha(String patron, Timestamp fecha) {
    if ((patron == null) || (patron.equals(""))) {
      patron = "dd/MM/yyyy";
    }

    if (fecha != null) {
      String resultado = getFormatoFecha(patron, fecha.getTime());

      return resultado;
    }
    return "";
  }

  public static String getFormatoFecha(String patron, long fecha)
  {
    String resultado = "";

    if ((patron == null) || (patron.equals(""))) {
      patron = "dd/MM/yyyy";
    }

    if (fecha > 0L) {
      SimpleDateFormat formato = new SimpleDateFormat(patron);
      resultado = formato.format(new java.sql.Date(fecha));
    }

    return resultado;
  }

  public String getPatronFechaJava()
  {
    String resultado = "";
    try
    {
      ResourceBundle bundle = ResourceBundle.getBundle(
        "pe.gob.mintra.std.util.Constantes");
      resultado = bundle.getString("const.patronfecha.java");
    }
    catch (Exception localException) {
    }
    return resultado;
  }

  public String getPatronFechaOracle() {
    String patron = "";
    try
    {
      ResourceBundle bundle = ResourceBundle.getBundle(
        "pe.gob.mintra.std.util.Constantes");
      patron = bundle.getString("const.patronfecha.oracle");
    }
    catch (Exception localException) {
    }
    return patron;
  }

  public String getReporte(String numeroReporte) {
    String reporte = "";
    try
    {
      ResourceBundle bundle = ResourceBundle.getBundle(
        "pe.gob.mintra.std.util.Reportes");
      reporte = bundle.getString(numeroReporte);
    }
    catch (Exception localException) {
    }
    return reporte;
  }

  public String getPrioridad(String numpriori) {
    String prioridad = "";
    try
    {
      ResourceBundle bundle = ResourceBundle.getBundle(
        "pe.gob.mintra.std.util.Prioridad");
      prioridad = bundle.getString(numpriori);
    }
    catch (Exception localException) {
    }
    return prioridad;
  }

  public String getAccion(String numaccion) {
    String accion = "";
    try
    {
      ResourceBundle bundle = ResourceBundle.getBundle(
        "pe.gob.mintra.std.util.Acciones");
      accion = bundle.getString(numaccion);
    }
    catch (Exception localException) {
    }
    return accion;
  }

  public String fechasOracle(Timestamp fecha)
  {
    String resultado = "";
    resultado = "To_Date('" + getFormatoFecha(getPatronFechaJava(), fecha) + 
      "','" + getPatronFechaOracle() + "') ";

    return resultado;
  }

  public String fechaHastaOracle(Timestamp fecha) {
    String resultado = "";
    resultado = "To_Date('" + getFormatoFecha(getPatronFechaJava(), fecha) + 
      " 23:59:59','" + getPatronFechaOracle() + " HH24:MI:SS') ";

    return resultado;
  }

  public String betweenFechasOracle(Timestamp fechaMinima, Timestamp fechaMaxima)
  {
    String between = "";
    between = "Between To_Date('" + 
      getFormatoFecha(getPatronFechaJava(), fechaMinima) + "','" + 
      getPatronFechaOracle() + "') And To_Date('" + 
      getFormatoFecha(getPatronFechaJava(), fechaMaxima) + 
      " 23:59:59','" + getPatronFechaOracle() + " HH24:MI:SS')";

    return between;
  }

  public Timestamp getParamToTimestamp(String parametro, String patronFecha) {
    Timestamp resultado = null;

    if ((parametro == null) || (parametro.equals("")) || 
      (parametro.equals("null")))
    {
      return resultado;
    }
    try {
      FormatoFecha formateador = new FormatoFecha(patronFecha);
      resultado = formateador.parseTimestamp(parametro);
    }
    catch (Exception localException)
    {
    }

    return resultado;
  }

  public java.util.Date getParamToDate(String parametro, String patronFecha)
  {
    java.util.Date resultado = null;

    if ((parametro == null) || (parametro.equals("")) || 
      (parametro.equals("null")))
    {
      return resultado;
    }
    try {
      FormatoFecha formateador = new FormatoFecha(patronFecha);
      resultado = formateador.parseDate(parametro);
    }
    catch (Exception localException)
    {
    }

    return resultado;
  }

  public static Timestamp getParamToSQLDate(String parametro, String patronFecha)
  {
    Timestamp resultado = null;

    if ((parametro == null) || (parametro.equals("")) || 
      (parametro.equals("null")))
    {
      return resultado;
    }
    try {
      FormatoFecha formateador = new FormatoFecha(patronFecha);
      resultado = formateador.parseTimestamp(parametro);
    }
    catch (Exception localException) {
    }
    return resultado;
  }

  public String getParamToString(String parametro, String predeterminado)
  {
    String resultado = getParamToString(parametro);

    if (resultado.equals("")) {
      resultado = predeterminado;
    }

    return resultado;
  }

  public String getParamToString(String parametro) {
    String resultado = "";

    if (parametro == null)
    {
      return resultado;
    }
    try {
      if ((parametro.equals("")) || (parametro.equals("null")))
        resultado = "";
      else {
        resultado = parametro.toString();
      }

    }
    catch (Exception localException)
    {
    }

    return resultado;
  }

  public int getParamToInt(String parametro)
  {
    int resultado = 0;

    if ((parametro == null) || (parametro.equals("")) || 
      (parametro.equals("null")))
    {
      return resultado;
    }
    try {
      resultado = Integer.parseInt(parametro);
    }
    catch (Exception localException)
    {
    }

    return resultado;
  }

  public long getParamToLong(String parametro)
  {
    long resultado = 0L;

    if (parametro == null)
    {
      return resultado;
    }
    try {
      resultado = Long.parseLong(parametro);
    }
    catch (Exception localException)
    {
    }

    return resultado;
  }

  public static Timestamp getTimestamp()
  {
    return new Timestamp(new java.util.Date().getTime());
  }

  public Timestamp getTimestamp(long fecha) {
    if (fecha == 0L) {
      return null;
    }
    return new Timestamp(fecha);
  }

  public Timestamp getTimestamp(Long fecha)
  {
    if (fecha == null) {
      return null;
    }
    return new Timestamp(fecha.longValue());
  }

  public java.sql.Date getSQLDate()
  {
    return new java.sql.Date(new java.util.Date().getTime());
  }

  public java.sql.Date getSQLDate(Timestamp fecha) {
    if (fecha == null) {
      return null;
    }
    return new java.sql.Date(fecha.getTime());
  }

  public java.sql.Date getSQLDate(long fecha)
  {
    if (fecha == 0L) {
      return null;
    }
    return new java.sql.Date(fecha);
  }

  public java.sql.Date getSQLDate(Long fecha)
  {
    if (fecha == null) {
      return null;
    }
    return new java.sql.Date(fecha.longValue());
  }

  public String getNullDato(String dato)
  {
    String resultado = null;

    if (dato.equals("")) {
      return resultado;
    }
    resultado = dato;

    return resultado;
  }

  public void setNullDatoInt(PreparedStatement ps, int idxColumn, int dato) throws SQLException
  {
    if (dato == 0)
      ps.setNull(idxColumn, 2);
    else
      ps.setInt(idxColumn, dato);
  }

  public void setNullDatoInt(CallableStatement ps, int idxColumn, int dato)
    throws SQLException
  {
    if (dato == 0)
      ps.setNull(idxColumn, 2);
    else
      ps.setInt(idxColumn, dato);
  }

  public Timestamp getNullDato(long dato)
  {
    if (dato == 0L) {
      return null;
    }
    return new Timestamp(dato);
  }

  public Integer getNullDato(int dato)
  {
    if (dato == 0) {
      return null;
    }
    return new Integer(dato);
  }

  public java.sql.Date getNullDato(java.util.Date dato)
  {
    if (dato == null) {
      return null;
    }
    return new java.sql.Date(dato.getTime());
  }

  public static String getFechaLatina(String string)
  {
    String[] fecha = string.split("-");
    return fecha[2] + "/" + fecha[1] + "/" + fecha[0];
  }

  public static String getFechaLatinaS(String string)
  {
    String[] fecha = string.split("/");
    return fecha[2] + "-" + fecha[1] + "-" + fecha[0];
  }

  public static Timestamp getTimestamp(String fecha)
  {
    System.out.println("fecha=" + fecha);
    java.util.Date dtTemporal = new java.util.Date(0L);

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    try {
      dtTemporal = sdf.parse(fecha.substring(0, 10).trim());
    } catch (ParseException pe) {
      System.out.println(pe.toString());
    }
    return new Timestamp(dtTemporal.getTime());
  }

  public static Timestamp getTimestampDatabase(String fecha) {
    System.out.println("*fecha=" + fecha);
    java.util.Date dtTemporal = new java.util.Date(0L);

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    try {
      dtTemporal = sdf.parse(fecha.substring(0, 10).trim());
    } catch (ParseException pe) {
      System.out.println(pe.toString());
    }
    return new Timestamp(dtTemporal.getTime());
  }
}