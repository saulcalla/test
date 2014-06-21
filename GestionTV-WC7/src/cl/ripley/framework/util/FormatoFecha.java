package cl.ripley.framework.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class FormatoFecha
{
  protected static final String PATTERN_DEFAULT = "dd/MM/yyyy HH:mm:ss";
  private SimpleDateFormat formatter = null;

  public FormatoFecha()
  {
    this.formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
  }

  public FormatoFecha(String pattern)
  {
    try
    {
      this.formatter = new SimpleDateFormat(pattern);
    } catch (Exception e) {
      this.formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    }
  }

  public java.util.Date parseDate(String dateString)
    throws IllegalArgumentException, ParseException, NullPointerException
  {
    if ((dateString == null) || (dateString.trim().equalsIgnoreCase(""))) {
      throw new IllegalArgumentException(
        "[WARNING] Texto fecha no debe ser nulo o vacío");
    }

    if (this.formatter == null) {
      throw new NullPointerException(
        "[ERROR] Debe crear instancia de la clase Render");
    }

    java.util.Date date = null;
    try
    {
      date = new java.util.Date(this.formatter.parse(dateString).getTime());
    } catch (ParseException e) {
      throw new ParseException("[ERROR] Imposible convertir texto fecha a java.sql.Date", 
        e.getErrorOffset());
    }

    return date;
  }

  public java.sql.Date parseSQLDate(String dateString)
    throws IllegalArgumentException, ParseException, NullPointerException
  {
    if ((dateString == null) || (dateString.trim().equalsIgnoreCase(""))) {
      throw new IllegalArgumentException(
        "[WARNING] Texto fecha no debe ser nulo o vacío");
    }

    if (this.formatter == null) {
      throw new NullPointerException(
        "[ERROR] Debe crear instancia de la clase Render");
    }

    java.util.Date date = null;
    try
    {
      date = this.formatter.parse(dateString);
    }
    catch (ParseException e) {
      e.printStackTrace();
      throw new ParseException("[ERROR] Imposible convertir texto fecha a java.sql.Date", 
        e.getErrorOffset());
    }

    return new java.sql.Date(date.getTime());
  }

  public Timestamp parseTimestamp(String dateString)
    throws IllegalArgumentException, ParseException, NullPointerException
  {
    if ((dateString == null) || (dateString.trim().equalsIgnoreCase(""))) {
      throw new IllegalArgumentException(
        "[WARNING] Texto fecha no debe ser nulo o vacío");
    }

    if (this.formatter == null) {
      throw new NullPointerException(
        "[ERROR] Debe crear instancia de la clase Render");
    }

    Timestamp date = null;
    try
    {
      date = new Timestamp(this.formatter.parse(dateString).getTime());
    } catch (ParseException e) {
      e.printStackTrace();
      throw new ParseException("[ERROR] Imposible convertir texto fecha a java.sql.Date", 
        e.getErrorOffset());
    }

    return date;
  }

  public String formatDate(java.util.Date date)
    throws IllegalArgumentException, NullPointerException
  {
    if (date == null) {
      throw new IllegalArgumentException(
        "[WARNING] Objeto fecha SQL no debe ser nulo");
    }

    if (this.formatter == null) {
      throw new NullPointerException(
        "[ERROR] Debe crear instancia de la clase Render");
    }

    return this.formatter.format(date);
  }

  public String formatDate(java.sql.Date dateSQL)
    throws IllegalArgumentException, NullPointerException
  {
    if (dateSQL == null) {
      throw new IllegalArgumentException(
        "[WARNING] Objeto fecha no debe ser nulo");
    }

    return formatDate(new java.util.Date(dateSQL.getTime()));
  }

  public String formatDate(Timestamp dateTimestamp)
    throws IllegalArgumentException, NullPointerException
  {
    if (dateTimestamp == null) {
      throw new IllegalArgumentException(
        "[WARNING] Objeto fecha no debe ser nulo");
    }

    return formatDate(new java.util.Date(dateTimestamp.getTime()));
  }

  public String formatDate()
    throws IllegalArgumentException, NullPointerException
  {
    return formatDate(new java.util.Date());
  }

  public static Timestamp getTimestamp()
  {
    return new Timestamp(new java.util.Date().getTime());
  }

  public java.sql.Date getSQLDate(Timestamp fecha)
  {
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
}