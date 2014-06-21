package cl.ripley.GestionTV.comun;

import cl.ripley.GestionTV.oem.OEMasociaciones;
import cl.ripley.GestionTV.oem.OEMbundles;
import cl.ripley.GestionTV.oem.OEMcatalogos;
import cl.ripley.GestionTV.oem.OEMclientescar;
import cl.ripley.GestionTV.oem.OEMproductos;
import cl.ripley.GestionTV.oem.OEMpromociones;
import cl.ripley.GestionTV.oem.OEMzonas;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Vector;
import org.apache.struts.util.MessageResources;

public class Archivo extends ConectaBD
{
  protected static MessageResources messages = MessageResources.getMessageResources("cl.ripley.GestionTV.struts.msgGestionTV");
  URL url;
  String pathDirTxt;

  public Vector txtToVector(String inUrl)
  {
    Vector vector = new Vector();
    String spCol = messages.getMessage("SEPARADOR_COLUMNA");
    try
    {
      this.url = new URL(inUrl);
    }
    catch (MalformedURLException e) {
      System.out.println("ERROR URL");
    }

    String str = "";
    BufferedReader buffer;
    try {
      buffer = new BufferedReader(new InputStreamReader(this.url.openStream()));

      String linea = buffer.readLine();
      while (linea != null)
      {
        String[] fila = linea.split(spCol);
        Vector campos = new Vector();

        for (int i = 0; i < fila.length; i++) {
          str = fila[i];
          if ((str == null) || (str.equals("null")) || (str.equals("NULL"))) {
            str = "";
          }
          campos.add(str);
        }
        vector.add(campos);

        linea = buffer.readLine();
      }
    } catch (IOException e) {
      Log.write("ERROR de apertura del archivo " + e.toString());
      buffer = null;
    }
    catch (Exception e)
    {      
      Log.write("ERROR " + e.toString());
      buffer = null;
    }
    return vector;
  }

  public Vector txtToVector(String pathDir, String archivo)
  {
    Vector vector = new Vector();
    String spCol = messages.getMessage("SEPARADOR_COLUMNA");
    BufferedReader buffer;
    try
    {
      String pathArchivo = pathDir + archivo;
      buffer = new BufferedReader(
        new InputStreamReader(
        new FileInputStream(pathArchivo)));

      String linea = buffer.readLine();

      while (linea != null)
        if (linea.endsWith("<!>")) {
          String[] fila = linea.split(spCol);
          Vector campos = new Vector();
          for (int i = 0; i < fila.length; i++) {
            String str = fila[i];
            if ((str == null) || (str.equals("null")) || (str.equals("NULL"))) {
              str = "";
            }
            campos.add(str);
          }
          campos.add(" ");
          vector.add(campos);
          linea = buffer.readLine();
        }
        else {
          String[] fila = linea.split(spCol);
          Vector campos = new Vector();
          for (int i = 0; i < fila.length; i++) {
            String str = fila[i];
            if ((str == null) || (str.equals("null")) || (str.equals("NULL"))) {
              str = "";
            }
            campos.add(str);
          }
          vector.add(campos);
          linea = buffer.readLine();
        }
    }
    catch (IOException e) {
      Log.write("ERROR de apertura del archivo " + e.toString());
      buffer = null;
    }
    catch (Exception e)
    {      
      Log.write("ERROR " + e.toString());
      buffer = null;
    }
    return vector;
  }

  public void cargaOEM_Remoto()
  {
    OEMproductos pro = new OEMproductos();
    OEMcatalogos cat = new OEMcatalogos();
    OEMzonas zon = new OEMzonas();
    OEMpromociones prs = new OEMpromociones();
    OEMasociaciones aso = new OEMasociaciones();
    OEMbundles bun = new OEMbundles();
    OEMclientescar cli = new OEMclientescar();

    String PRO_URL = messages.getMessage("URL_ARCHIVO_PRODUCTO");
    String CAT_URL = messages.getMessage("URL_ARCHIVO_CATALOGO");
    String ZON_URL = messages.getMessage("URL_ARCHIVO_ZONA");
    String PRS_URL = messages.getMessage("URL_ARCHIVO_PROMOCION");
    String ASO_URL = messages.getMessage("URL_ARCHIVO_ASOCIACION");
    String BUN_URL = messages.getMessage("URL_ARCHIVO_BUNDLES");
    String CLI_URL = messages.getMessage("URL_ARCHIVO_CLIENTESCAR");
  }

  public void cargaOEM_Local()
  {
    OEMproductos pro = new OEMproductos();
    OEMcatalogos cat = new OEMcatalogos();
    OEMzonas zon = new OEMzonas();
    OEMpromociones prs = new OEMpromociones();
    OEMasociaciones aso = new OEMasociaciones();
    OEMbundles bun = new OEMbundles();
    OEMclientescar cli = new OEMclientescar();

    String archivoPRO = messages.getMessage("ARCHIVO_PROD");
    String archivoCAT = messages.getMessage("ARCHIVO_CATALOGO");
    String archivoZON = messages.getMessage("ARCHIVO_ZONA");
    String archivoPRS = messages.getMessage("ARCHIVO_PROMOCION");
    String archivoASO = messages.getMessage("ARCHIVO_ASOCIACION");
    String archivoBUN = messages.getMessage("ARCHIVO_BUNDLES");
    String archivoCLI = messages.getMessage("URL_ARCHIVO_CLIENTESCAR");
    String path = messages.getMessage("pathDirTxt");
  }

  public String getPathDirTxt()
  {
    return this.pathDirTxt;
  }

  public void setPathDirTxt(String string)
  {
    this.pathDirTxt = string;
  }
}