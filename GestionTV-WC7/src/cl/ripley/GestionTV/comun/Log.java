package cl.ripley.GestionTV.comun;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.struts.util.MessageResources;

public class Log
{
  public static boolean ENABLED = false;
  static PrintWriter writer;
  static Class supClass = Log.class;
  protected static MessageResources messages = MessageResources.getMessageResources("cl.ripley.GestionTV.struts.msgGestionTV");

  static { String enabledStr = ConfigManager.getProperty("debug.enabled");

    if (enabledStr != null)
      ENABLED = Boolean.valueOf(enabledStr).booleanValue();
  }

  public static synchronized void write(String mensaje)
  {
    String msgError = "";
    String path = messages.getMessage("pathDirTxt");

    SimpleDateFormat formatter = 
      new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    String dateString = formatter.format(new Date());
    try
    {
      FileOutputStream fos = new FileOutputStream(path + "CargaOEM.log", true);
      mensaje = "[" + dateString + "] " + mensaje + "\n";
      fos.write(mensaje.getBytes());
      fos.close();
    }
    catch (FileNotFoundException e) {
      msgError = "Log.java FileNotFoundException " + e.getMessage();
    }
    catch (IOException e) {
      msgError = "Log.java IOException " + e.getMessage();
    }
    catch (Exception e) {
      msgError = "Log.java Exception " + e.getMessage();
    }

    if (!msgError.equals(""))
      try {
        FileOutputStream fos = new FileOutputStream(path + "CargaOEM.log", true);
        mensaje = "[" + dateString + "]" + msgError + "\n";
        fos.write(mensaje.getBytes());
        fos.close();
      }
      catch (Exception e) {
        System.out.println("ERROR Log.java " + e.getMessage());
      }
  }

  public static void setOut(OutputStream o)
  {
    if (ENABLED)
      writer = new PrintWriter(o);
  }

  public static void println(Object o)
  {
    if (ENABLED) {
      SimpleDateFormat formatter = 
        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      String dateString = formatter.format(new Date());

      writer.print("[" + dateString + "] ");
      writer.print(o.toString());
      writer.println();
      writer.flush();
    }
  }

  public static void println(Class claseOrigen, Object o) {
    if (ENABLED) {
      SimpleDateFormat formatter = 
        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      String dateString = formatter.format(new Date());
      String pckNomClass = claseOrigen.getName();
      String NomClass = 
        pckNomClass.substring(
        pckNomClass.lastIndexOf(".") + 1, 
        pckNomClass.length());
      writer.print("[" + dateString + "] ");
      writer.print(" " + NomClass + ": ");
      writer.print(o.toString());
      writer.println();
      writer.flush();
    }
  }

  public static void println(Class claseOrigen, Throwable t) {
    if (ENABLED) {
      writer.println("***begin println(Throwable)*******");
      SimpleDateFormat formatter = 
        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      String dateString = formatter.format(new Date());
      String pckNomClass = claseOrigen.getName();
      String NomClass = 
        pckNomClass.substring(
        pckNomClass.lastIndexOf(".") + 1, 
        pckNomClass.length());
      writer.print("[" + dateString + "] ");
      writer.print(" " + NomClass + ": ");
      writer.println("message " + t.getMessage());
      writer.println("traceback " + throwableToString(t));
      writer.println("***end println(Throwable)*******");
      writer.flush();
    }
  }

  public static void println(Throwable t) {
    if (ENABLED) {
      writer.println("***begin println(Throwable)*******");
      SimpleDateFormat formatter = 
        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      String dateString = formatter.format(new Date());
      writer.print("[" + dateString + "] ");
      writer.println("message " + t.getMessage());
      writer.println("traceback " + throwableToString(t));
      writer.println("***end println(Throwable)*******");
      writer.flush();
    }
  }

  private static String throwableToString(Throwable t) {
    StringWriter writer = new StringWriter();
    t.printStackTrace(new PrintWriter(writer));
    return writer.toString();
  }
}