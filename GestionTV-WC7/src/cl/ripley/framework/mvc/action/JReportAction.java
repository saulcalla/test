package cl.ripley.framework.mvc.action;

import cl.ripley.framework.util.FastByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.export.JRXmlExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionServlet;

public class JReportAction extends Action
{
  public static String bundleApplication = "";

  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    HttpSession sesion = null;

    ActionErrors errors = new ActionErrors();
    ActionForward forward = null;
    Connection con = null;
    try
    {
      String outputFormat = request.getParameter("format");
      String action = request.getParameter("action");
      String reporte = request.getParameter("report");
      String subreporte = request.getParameter("subreport");
      String JRDatasource = request.getParameter("JRDatasource");
      bundleApplication = request.getParameter("bundle");
      con = getDataSource(request, "BaseOracle").getConnection();
      if (JRDatasource == null) {
        JRDatasource = "";
      }

      if (action.equals("preview"))
      {
        outputFormat = getFormatoReporte(outputFormat);

        Map parameters = new HashMap();
        parameters.put("REPORTE_RUTA", getReporte("000"));

        parameters.put("REPORTE_FORMATO", outputFormat);
        parameters.put("REPORTE_ARCHIVO", getReporte(reporte));
        if (subreporte != null) parameters.put("SUBREPORTE", getReporte(subreporte));
        parameters.put("PV_RUTA_IMAGEN", getReporte("000") + "Ripley_logo.jpg");

        Enumeration parametro = request.getParameterNames();

        while (parametro.hasMoreElements()) {
          String nompar = (String)parametro.nextElement();
          String valpar = request.getParameter(nompar);

          nompar = nompar.toUpperCase();

          if (nompar.substring(0, 1).equals("P")) {
            System.out.println("nompar=" + nompar + ",valpar=" + valpar);
            if (nompar.substring(0, 2).equals("PN"))
              parameters.put(nompar, new Integer(valpar));
            else {
              parameters.put(nompar, valpar);
            }

          }

        }

//        String nompar = generarReporte(parameters, con, request, 
//          response, JRDatasource);
        byte abyte0[] = generarReporte(parameters, con, request, response, JRDatasource);
      }
    } catch (Throwable e) {
      try {
        if (con != null)
          con.close();
      }
      catch (SQLException e1) {
        getServlet().log("Connection.close", e1);
      }
      e.printStackTrace();
      e.getMessage();
      try
      {
        if (con != null)
          con.close();
      }
      catch (SQLException ex)
      {
        getServlet().log("Connection.close ", ex);
      }
    }
    finally
    {
      try
      {
        if (con != null)
          con.close();
      }
      catch (SQLException e)
      {
        getServlet().log("Connection.close ", e);
      }

    }

    return forward;
  }

  private byte[] exportReportToBytes(JasperPrint jasperPrint, JRExporter exporter)
    throws JRException
  {
    FastByteArrayOutputStream baos = new FastByteArrayOutputStream();

    exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
    exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);

    exporter.exportReport();

    byte[] output = baos.toByteArray();

    return output;
  }

  private static String actualDir() {
    File dir1 = new File("");
    String currentPath = null;
    try
    {
      currentPath = dir1.getCanonicalPath();
    }
    catch (Exception localException)
    {
    }
    return currentPath;
  }

  private static String cabeceraReporte() {
    String cabecera = "";
    cabecera = "<html>\n";
    cabecera = cabecera + "<head>\n";
    cabecera = cabecera + "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n";
    cabecera = cabecera + "<style>table {page-break-after:always;}</style>";
    cabecera = cabecera + "</head>\n";
    cabecera = cabecera + "<body>\n";

    return cabecera;
  }

  private static String pieReporte() {
    String pie = "";

    pie = "</body>\n";
    pie = pie + "</html>";

    return pie;
  }

  public byte[] generarReporte(Map parameters, Connection con, HttpServletRequest request, HttpServletResponse response, String theJRDataSource)
  {
    String ruta = null;
    String archivo = null;
    String archivoReporte = null;
    String formatoReporte = null;

    ruta = (String)parameters.get("REPORTE_RUTA");
    archivo = (String)parameters.get("REPORTE_ARCHIVO");

    formatoReporte = (String)parameters.get("REPORTE_FORMATO");
    archivoReporte = ruta + archivo;

    OutputStream os = null;

    byte[] output = (byte[])null;
    try
    {
      if (parameters.get("SUBREPORTE") != null) {
        String subReporte = (String)parameters.get("SUBREPORTE");
        if (subReporte != null) {
          JasperReport jasperSubReport = (JasperReport)JRLoader.loadObject(ruta + subReporte);
          parameters.put("DetailSubReport", jasperSubReport);
        }
      }

      JasperReport jasperReport = (JasperReport)JRLoader.loadObject(archivoReporte);
      try
      {
        JasperPrint jasperPrint = new JasperPrint();

        if (theJRDataSource.equals("")) {
          jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, con);
        }
        else {
          Class clase_lista = Class.forName(theJRDataSource);
          Object cc = clase_lista.newInstance();
          Method metodo_lista = cc.getClass().getMethod("getBeanArray", null);
          ArrayList result_list = (ArrayList)metodo_lista.invoke(null, null);
          JRDataSource jrds = new JRBeanArrayDataSource(result_list.toArray());

          jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, jrds);
        }

        if (jasperPrint == null) {
          System.out.println("Reporte es nulo");
        }

        if (formatoReporte.equals("PDF"))
        {
          response.setContentType("application/pdf");
          output = JasperExportManager.exportReportToPdf(jasperPrint);
          response.setContentLength(output.length);
          try
          {
            ServletOutputStream ouputStream = response.getOutputStream();
            ouputStream.write(output);
            ouputStream.flush();
            ouputStream.close();
          } catch (IOException e) {
            System.out.println(e.toString());
            throw new ServletException(e.getMessage(), e);
          }
        } else {
          os = response.getOutputStream();

          int posDot = archivo.indexOf(".");

          String archivoExportado = archivo.substring(0, posDot) + "." + formatoReporte;

          if (formatoReporte.equals("CSV")) {
            response.setContentType("text/plain");

            JRExporter exporter = new JRCsvExporter();
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, archivoExportado);
          }
          else
          {
            JRExporter exporter;
            if (formatoReporte.equals("HTML")) {
              response.setContentType("text/html");
              exporter = new JRHtmlExporter();
            } else if (formatoReporte.equals("XLS")) {
              response.setContentType("application/vnd.ms-excel");
              exporter = new JRXlsExporter();
              exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, archivoExportado);
              exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.TRUE);
            }
            else
            {              
              if (formatoReporte.equals("XML")) {
                response.setContentType("text/xml");
                exporter = new JRXmlExporter();
              }
              else {
                throw new ServletException("Unknown report format: " + formatoReporte);
              }
            }
          }
          JRExporter exporter = new JRXmlExporter();
          exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);

          output = exportReportToBytes(jasperPrint, exporter);

          response.setContentLength(output.length);

          response.setHeader("Content-disposition", "attachment;filename=" + archivoExportado);
          try
          {
            os.write(output);
          }
          catch (IOException e)
          {
            throw new ServletException(e.getMessage(), e);
          }
        }
      }
      catch (JRException e)
      {
        e.printStackTrace();
      } catch (Exception ez) {
        ez.printStackTrace();
      }
    } catch (JRException e) {
      e.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    }

    return output;
  }

  public String getFormatoReporte(String formatoReporte) {
    if ((formatoReporte == null) || (formatoReporte.equals(""))) {
      return "PDF";
    }

    String formato = "";
    try
    {
      ResourceBundle bundle = ResourceBundle.getBundle(bundleApplication);
      formato = bundle.getString(formatoReporte);
    }
    catch (Exception localException) {
    }
    return formato;
  }

  public String getReporte(String numeroReporte) {
    String reporte = "";
    try
    {
      ResourceBundle bundle = ResourceBundle.getBundle(bundleApplication);
      reporte = bundle.getString(numeroReporte);
    }
    catch (Exception localException) {
    }
    return reporte;
  }
}