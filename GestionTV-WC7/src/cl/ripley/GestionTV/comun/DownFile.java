package cl.ripley.GestionTV.comun;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

public class DownFile
  implements Serializable
{
  private Vector tableData;
  private String nameFile = "DefaultName";

  private String extFile = "txt";

  private String pathFile = "";

  private String separador = "\t";

  private static String mensaje = "";

  public void exportToFile()
  {
    try
    {
      String enter = new String("\n");
      String contentFile = new String();
      SimpleDateFormat formatter = new SimpleDateFormat("MMddhhmmss");
      Date currentTime = new Date();
      String dateString = formatter.format(currentTime);
      setNameFile(getNameFile() + dateString);
      String pathNameDate = getPathFile() + getNameFile() + getExtFile();
      FileOutputStream outFile = new FileOutputStream(pathNameDate, true);
      Vector columna = getTableData();
      for (int col = 0; col < columna.size(); col++) {
        Vector fila = (Vector)columna.elementAt(col);
         for (int fil = 0; fil < fila.size(); fil++) {
          contentFile = fila.elementAt(fil).toString().replaceAll("\t", "").replaceAll("\n", "").trim() + getSeparador();
          outFile.write(contentFile.getBytes());
        }
        outFile.write(enter.getBytes());
      }
      outFile.close();
      if (existFiles(dateString))
        deleteFiles(dateString);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  public boolean existFiles(String dateString)
  {
    return true;
  }

  public void deleteFiles(String dateString) {
  }

  public Vector getTableData() {
    return this.tableData;
  }

  public void setTableData(Vector tableData) {
    this.tableData = tableData;
  }

  public DownFile()
  {
  }

  public String getNameFile()
  {
    return this.nameFile;
  }

  public void setNameFile(String nameFile) {
    this.nameFile = nameFile;
  }

  public String getExtFile() {
    return this.extFile;
  }

  public void setExtFile(String extFile) {
    this.extFile = extFile;
  }

  public String getPathFile() {
    return this.pathFile;
  }

  public void setPathFile(String pathFile) {
    this.pathFile = pathFile;
  }

  public DownFile(Vector tableData)
  {
  }

  public String getSeparador()
  {
    return this.separador;
  }

  public void setSeparador(String separador) {
    this.separador = separador;
  }

  public String enviarArchivo(Vector head, Vector detalles)
  {
    String exportFile = new String("");
    try
    {
      String pathFile = 
        ConfigManager.getPathSystem() + 
        ConfigManager.getProperty("exportToFile.location");
      String nameSystem = 
        ConfigManager.getPathSystem().substring(
        ConfigManager.getPathSystem()
        .substring(
        0, 
        ConfigManager.getPathSystem().length() - 1)
        .lastIndexOf("/"));
      DownFile exportar = new DownFile();
      exportar.setNameFile(
        ConfigManager.getProperty("exportToFile.name"));
      exportar.setExtFile(ConfigManager.getProperty("exportToFile.ext"));
      exportar.setPathFile(pathFile);
      exportar.setSeparador(
        ConfigManager.getProperty("exportToFile.separador"));
      exportar.setTableData(Util.HeadAddBody(head, detalles));

      exportar.exportToFile();
      exportFile = nameSystem + ConfigManager.getProperty("exportToFile.location") + exportar.getNameFile() + exportar.getExtFile();

      setMensaje("Exportación exitosa..");
      System.out.println("Exportacion Exitosa");
    }
    catch (Exception e)
    {
      setMensaje("Error al Exportar");
      System.out.println("ERROR " + e);
      Log.println(getClass(), e);
      return exportFile;
    }
    return exportFile;
  }

  public String enviarArchivoNew(Vector head, Vector detalles, Vector nota) {
    String exportFile = new String("");
    try
    {
      String pathFile = 
        ConfigManager.getPathSystem() + 
        ConfigManager.getProperty("exportToFile.location");
      String nameSystem = 
        ConfigManager.getPathSystem().substring(
        ConfigManager.getPathSystem()
        .substring(
        0, 
        ConfigManager.getPathSystem().length() - 1)
        .lastIndexOf("/"));
      DownFile exportar = new DownFile();
      exportar.setNameFile(
        ConfigManager.getProperty("exportToFile.name"));
      exportar.setExtFile(ConfigManager.getProperty("exportToFile.ext"));
      exportar.setPathFile(pathFile);
      exportar.setSeparador(
        ConfigManager.getProperty("exportToFile.separador"));
      exportar.setTableData(Util.HeadAddBodyNew(head, detalles, nota));

      exportar.exportToFile();
      exportFile = nameSystem + ConfigManager.getProperty("exportToFile.location") + exportar.getNameFile() + exportar.getExtFile();

      setMensaje("Exportación exitosa..");
      System.out.println("Exportacion Exitosa");
    }
    catch (Exception e)
    {
      setMensaje("Error al Exportar");
      System.out.println("ERROR " + e);
      Log.println(getClass(), e);
      return exportFile;
    }
    return exportFile;
  }

  public static String getMensaje()
  {
    return mensaje;
  }

  public void setMensaje(String string)
  {
    mensaje = string;
  }

  public static String exportaArchivo(Vector head, Vector detalles)
  {
    DownFile objDown = new DownFile();
    String exportFile = objDown.enviarArchivo(head, detalles);
    objDown.setMensaje(getMensaje());
    return exportFile;
  }
}