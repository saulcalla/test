package cl.ripley.GestionTV.comun;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Properties;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

public class ConfigManager
{
  private static Properties props = new Properties();

  public static void load(String dir)
    throws IOException
  {
    dir = new File(dir).getAbsolutePath();
    File propDir = new File(dir);
    if (propDir.isDirectory()) {
      String[] flist = propDir.list();
      for (int i = 0; i < flist.length; i++)
        props.load(new FileInputStream(new File(propDir, flist[i])));
    }
    else {
      props.load(new FileInputStream(new File(dir)));
    }
  }

  public static void load(String dir, ServletConfig conf) throws IOException {
    InputStream is = conf.getServletContext().getResourceAsStream(dir);
    props.load(is);
  }

  public static String getProperty(String key) {
    return props.getProperty(key);
  }

  public static boolean getBooleanProperty(String key) {
    String value = props.getProperty(key);
    if (value != null) {
      return Boolean.valueOf(value).booleanValue();
    }
    return false;
  }

  public static String getPathSystem()
  {
    String pckPath = AppInitServlet.class.getName();
    String name = 
      pckPath.substring(pckPath.lastIndexOf(".") + 1) + ".class";
    URL url = AppInitServlet.class.getResource(name);
    String path = url.getPath();
    try {
      path = URLDecoder.decode(path, "UTF-8");
    } catch (Exception e) {
      System.out.println("Error conversion: " + e);
    }

    path = 
      path.substring(
      0, 
      path.length() - 
      (pckPath + ".class").length() - 
      getProperty("classes.path").length());
    return path;
  }

  public static String getUrlSystem()
  {
    String pckPath = AppInitServlet.class.getName();
    String name = 
      pckPath.substring(pckPath.lastIndexOf(".") + 1) + ".class";
    URL url = AppInitServlet.class.getResource(name);
    String path = 
      url.getProtocol() + "://" + url.getHost() + ":" + url.getPort();
    path = 
      path.substring(
      0, 
      path.length() - 
      (pckPath + ".class").length() - 
      getProperty("classes.path").length());
    return path;
  }
}