package cl.ripley.GestionTV.comun;

import java.sql.Connection;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.Vector;
import org.apache.struts.util.MessageResources;

public class Util
{
  protected static MessageResources messages = MessageResources.getMessageResources(
    "cl.ripley.GestionTV.struts.msgPerfiles");
  private static Connection connection;
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
    if (pValor.equals("")) {
      return "Null";
    }

    return pValor.trim();
  }

  public static String verificaNulo(String pValor)
  {
    if (pValor == null) {
      return "";
    }
    return pValor.trim();
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

  public static Vector stringToVector(String strVector) {
    Vector returnVector = new Vector();
    Vector elementVector = new Vector();
    String element = new String("");
    try {
      if (strVector != null)
        for (int i = 1; i < strVector.length() - 1; i++)
          if (strVector.substring(i, i + 1).equals("[")) {
            elementVector.clear();
            element = "";
          } else if (strVector.substring(i, i + 1).equals(",")) {
            elementVector.addElement(element);
            element = "";
            i++;
          } else if (strVector.substring(i, i + 1).equals("]")) {
            elementVector.addElement(element);
            returnVector.addElement(elementVector.clone());
          } else {
            element = element + strVector.substring(i, i + 1);
          }
    }
    catch (Exception e)
    {
      Log.write(Util.class.getClass() + "::" + e.toString());
    }
    return returnVector;
  }

  public static Connection getConnection()
  {
    return connection;
  }

  public static void setConnection(Connection connection)
  {
    connection = connection;
  }

  public static java.util.Date stringToDate(String strDate, String format) {
    SimpleDateFormat formatter = new SimpleDateFormat(format);
    ParsePosition pos = new ParsePosition(0);
    java.util.Date datDate = formatter.parse(strDate, pos);
    return datDate;
  }

  public static java.sql.Date stringToDateBD(String strDate, String format) {
    java.sql.Date sqlDate = 
      new java.sql.Date(stringToDate(strDate, format).getTime());
    return sqlDate;
  }

  public static String fMonto(String sMonto, String cFormat)
  {
    String resultado = new String("");
    if (!sMonto.equals("")) {
      while (sMonto.length() > 3) {
        resultado = 
          cFormat + 
          sMonto.substring(
          sMonto.length() - 3, 
          sMonto.length()) + 
          resultado;
        sMonto = sMonto.substring(0, sMonto.length() - 3);
      }
      resultado = sMonto + resultado;
    }
    return resultado;
  }

  public static Vector HeadAddBody(Vector VectorUno, Vector VectorDos) {
    Vector returnVector = new Vector();
    try {
      returnVector.addElement(VectorUno.firstElement());
      for (int i = 0; i < VectorDos.size(); i++)
        returnVector.addElement(VectorDos.elementAt(i));
    }
    catch (Exception e) {
      Log.write(Util.class.getClass() + "::" + e.toString());
    }
    return returnVector;
  }
  public static Vector HeadAddBodyNew(Vector VectorUno, Vector VectorDos, Vector VectorTres) {
    Vector returnVector = new Vector();
    try {
      returnVector.addElement(VectorTres.firstElement());
      returnVector.addElement(VectorUno.firstElement());
      for (int i = 0; i < VectorDos.size(); i++)
        returnVector.addElement(VectorDos.elementAt(i));
    }
    catch (Exception e) {
      Log.write(Util.class.getClass() + "::" + e.toString());
    }
    return returnVector;
  }

  public static void setMap(Map sMap)
  {
    vMap = sMap;
  }

  public static Map getMap() {
    return vMap;
  }
}