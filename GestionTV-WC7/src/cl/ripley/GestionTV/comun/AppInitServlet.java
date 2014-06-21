package cl.ripley.GestionTV.comun;

import java.io.IOException;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.struts.util.MessageResources;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class AppInitServlet extends GenericServlet
{
  private Map sqlStatements = new HashMap();
  private static final String DEFAULT_PROYECT = "default";
  private static final String XML_PROYECTO = "NombreProyecto";
  private static final String XML_DATABASE = "nombre";
  private static final String XML_BEAN = "NombreBean";
  private static final String XML_VALOR = "valor";
  private static final String XML_INST01 = "Instruccion01";
  private static final String XML_INST02 = "Instruccion02";
  private static final String XML_INST03 = "Instruccion03";
  private static final String XML_INST04 = "Instruccion04";
  static Logger log = Logger.getLogger(AppInitServlet.class);

  protected static MessageResources messages = MessageResources.getMessageResources("cl.ripley.GestionTV.struts.msgGestionTV");

  public void init(ServletConfig conf)
    throws ServletException
  {
    super.init(conf);

    String configDir = getInitParameter("configSystem");
    String pathSystem = "";
    try
    {
      ConfigManager.load(configDir, conf);

      String pathContexto = conf.getServletContext().getRealPath("/");
      PropertyConfigurator.configure(pathContexto + ConfigManager.getProperty("log.path"));
      log.info("Comienzo de la Aplicación init()");

      cargaXML(conf);
    }
    catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }

  public void service(ServletRequest req, ServletResponse res)
  {
  }

  private void cargaXML(ServletConfig config)
  {
    try
    {
      String configDir = getInitParameter("configSystem");
      String path_xml = ConfigManager.getProperty("xml.path");
      String database = "default";

      SAXParserFactory parserFactory = SAXParserFactory.newInstance();
      parserFactory.setValidating(true);
      parserFactory.setNamespaceAware(true);

      cargaSQL(
        parserFactory.newSAXParser(), 
        database, 
        new InputSource(getPath(path_xml)));
    }
    catch (Exception exception) {
      System.err.print("Error cargaXML.exception....");
      exception.printStackTrace();
    }
  }

  private void cargaSQL(SAXParser parser, final String proyect, InputSource fuente)
    throws SAXException, IOException
  {
    try
    {
      parser.parse(fuente, new DefaultHandler() {
        private boolean encontrado;
        private String v_valor;
        private String v_operacion;
        private StringBuffer v_instruccion = new StringBuffer();
        //private final String proyect;

        public void startElement(String namespace, String name, String qName, Attributes attrs) { if (!this.encontrado) {
            if ((name.equals("NombreProyecto")) && 
              (attrs.getValue("nombre").equals(proyect))) {
              this.encontrado = true;
            }
          }
          else if (name.equals("NombreBean")) {
            this.v_valor = attrs.getValue("valor");
          }
          else if (name.equals("Instruccion01")) {
            this.v_operacion = "inst01";
            this.v_instruccion.setLength(0);
          } else if (name.equals("Instruccion02")) {
            this.v_operacion = "inst02";
            this.v_instruccion.setLength(0);
          } else if (name.equals("Instruccion03")) {
            this.v_operacion = "inst03";
            this.v_instruccion.setLength(0);
          } else if (name.equals("Instruccion04")) {
            this.v_operacion = "inst04";
            this.v_instruccion.setLength(0);
          }
        }

        public void characters(char[] chars, int start, int length)
          throws SAXException
        {
          if ((this.encontrado) && (this.v_valor != null) && (this.v_operacion != null))
            this.v_instruccion.append(chars, start, length);
        }

        public void endElement(String namespace, String name, String qName)
          throws SAXException
        {
          if (this.encontrado) {
            if (name.equals("NombreProyecto")) {
              this.encontrado = false;
              throw new AppInitServlet.ParsingDoneException();
            }

            if (name.equals("NombreBean")) {
              this.v_valor = null;
            }
            else if ((name.equals("Instruccion01")) || 
              (name.equals("Instruccion02")) || 
              (name.equals("Instruccion03")) || 
              (name.equals("Instruccion04"))) {
              AppInitServlet.this.sqlStatements.put(
                AppInitServlet.this.formaClave(this.v_operacion, this.v_valor), 
                this.v_instruccion.toString());

              this.v_instruccion.setLength(0);
              this.v_operacion = null;
            }

          }

          Util.setMap(AppInitServlet.this.sqlStatements);
        }
      });
    }
    catch (ParsingDoneException localParsingDoneException)
    {
    }
  }

  private String formaClave(String v_operacion, String v_valor)
  {
    return v_valor + "." + v_operacion;
  }

  private String getPath(String path)
    throws IOException
  {
    String url;
    try
    {
      url = new URL(path).toString();
    }
    catch (MalformedURLException exception)
    {      
      URL u = getServletContext().getResource(path);
      url = u != null ? u.toString() : path;
    }
    return url;
  }

  private class ParsingDoneException extends SAXException
  {
    ParsingDoneException()
    {
      super();
    }
  }
}