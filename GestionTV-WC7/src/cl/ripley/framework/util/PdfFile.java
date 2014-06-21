package cl.ripley.framework.util;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.Vector;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;

public class PdfFile extends Action
{
  Font fontTitulos = new Font(1, 7.0F, 1);
  Font fontTitulos2 = new Font(1, 7.0F, 1);
  Font fontTitulos3 = new Font(1, 10.0F, 1);
  Font fontValores = new Font(1, 7.0F, 0);
  Font fontTablaHeader = new Font(1, 8.0F, 1, Color.black);
  private static final String TAB = "\t";

  public void GenerarPDF(HttpServletRequest request, HttpServletResponse httpServletResponse, Vector resultado, String fechaIni)
  {
    ByteArrayOutputStream PDF = null;
    try
    {
      PDF = generatePDF(request, resultado, fechaIni);
      httpServletResponse.setHeader("Cache-control", "no-cache");
      httpServletResponse.setHeader("Pragma", "no-cache");
      httpServletResponse.setDateHeader("Expires", 0L);
      httpServletResponse.setHeader("Content-disposition", "attachment; filename=Informe.pdf");

      httpServletResponse.setContentType("application/pdf");
      httpServletResponse.setContentLength(PDF.size());

      ServletOutputStream sos = httpServletResponse.getOutputStream();
      PDF.writeTo(sos);
      sos.flush();
      sos.close();
    } catch (IOException dex) {
      System.out.println(dex.getMessage());
    } finally {
      if (PDF != null)
        PDF.reset();
    }
  }

  private ByteArrayOutputStream generatePDF(HttpServletRequest request, Vector resultado, String fechaIni)
  {
    Document doc = new Document(PageSize.LETTER, 30.0F, 30.0F, 30.0F, 30.0F);
    ByteArrayOutputStream PDF = new ByteArrayOutputStream();

    PdfWriter docWriter = null;
    try
    {
      docWriter = PdfWriter.getInstance(doc, PDF);
      Calendar c = Calendar.getInstance(TimeZone.getTimeZone("America/Santiago"));
      int hour = c.get(11);
      int min = c.get(12);
      int sec = c.get(13);
      String num = nTabs(150) + " Página ";
      Phrase fecha = new Phrase(fecha() + " " + hour + ":" + min + ":" + sec + num, FontFactory.getFont("Helvetica", 8.0F));
      HeaderFooter footer = new HeaderFooter(fecha, true);

      doc.setFooter(footer);

      doc.open();

      doc.add(new Phrase(""));
      doc.add(getTableEncabezado(request, resultado, fechaIni));
      doc.add(getTableDetalle(request, resultado, fechaIni));

      PdfPTable tabla = null;
      tabla = new PdfPTable(10);
      tabla.setWidthPercentage(100.0F);
      int[] headerwidths = { 11, 33, 7, 7, 7, 7, 7, 7, 7, 7 };
      tabla.setWidths(headerwidths);
      doc.add(tabla);
      doc.close();
      docWriter.close();
    } catch (DocumentException e) {
      System.out.println(e.getMessage());
    }

    return PDF;
  }

  private PdfPTable getTableEncabezado(HttpServletRequest request, Vector resultado, String fechaIni) {
    PdfPTable tablaGeneral = null;

    tablaGeneral = new PdfPTable(1);
    tablaGeneral.setWidthPercentage(100.0F);

    int[] headerwidths = { 10, 20, 10, 20 };
    try {
      tablaGeneral.setWidths(headerwidths);
    }
    catch (DocumentException localDocumentException)
    {
    }

    String text = "";
    Phrase FI = new Phrase("FECHA : " + fechaIni, this.fontTitulos);
    Phrase texto = new Phrase(text, this.fontTitulos);
    PdfPCell textoCell = new PdfPCell(texto);
    PdfPCell fechaI = new PdfPCell(FI);

    textoCell.setBorder(0);
    fechaI.setBorder(0);

    Phrase blank = new Phrase(" ");
    PdfPCell blankCell = new PdfPCell(blank);
    blankCell.setBorder(0);
    String t = "Informe de Stock Ripley Channel";
    Phrase titulo = new Phrase(t, this.fontTitulos3);
    PdfPCell tituloCell = new PdfPCell(titulo);

    tituloCell.setHorizontalAlignment(1);
    fechaI.setHorizontalAlignment(1);

    tablaGeneral.addCell(blankCell);

    blankCell.setColspan(0);
    tituloCell.setColspan(0);
    fechaI.setColspan(0);

    tablaGeneral.addCell(tituloCell);
    tablaGeneral.addCell(blankCell);
    tablaGeneral.addCell(blankCell);
    tablaGeneral.addCell(fechaI);
    tablaGeneral.addCell(blankCell);
    tablaGeneral.addCell(blankCell);
    tablaGeneral.addCell(blankCell);

    return tablaGeneral;
  }

  private PdfPTable getTableDetalle(HttpServletRequest request, Vector resultado, String fechaIni) {
    PdfPTable tablaGeneral = null;

    Vector e = (Vector)resultado.elementAt(0);
    tablaGeneral = new PdfPTable(e.size());
    tablaGeneral.setWidthPercentage(100.0F);

    int[] headerwidths = { 10, 20, 10, 20 };
    try {
      tablaGeneral.setWidths(headerwidths);
    }
    catch (DocumentException localDocumentException)
    {
    }

    Phrase titulo = new Phrase("Cod. Producto", this.fontTablaHeader);
    PdfPCell HeaderCell = new PdfPCell(titulo);
    HeaderCell.setHorizontalAlignment(1);
    tablaGeneral.addCell(HeaderCell);

    titulo = new Phrase("Descripcion", this.fontTablaHeader);
    HeaderCell = new PdfPCell(titulo);
    HeaderCell.setHorizontalAlignment(1);
    tablaGeneral.addCell(HeaderCell);

    titulo = new Phrase("Stock", this.fontTablaHeader);
    HeaderCell = new PdfPCell(titulo);
    HeaderCell.setHorizontalAlignment(1);
    tablaGeneral.addCell(HeaderCell);

    titulo = new Phrase("En Aprobacion", this.fontTablaHeader);
    HeaderCell = new PdfPCell(titulo);
    HeaderCell.setHorizontalAlignment(1);
    tablaGeneral.addCell(HeaderCell);

    titulo = new Phrase("Vta. RChannel", this.fontTablaHeader);
    HeaderCell = new PdfPCell(titulo);
    HeaderCell.setHorizontalAlignment(1);
    tablaGeneral.addCell(HeaderCell);

    for (int k = 0; k < resultado.size(); k++) {
      Vector element = (Vector)resultado.elementAt(k);

      if (element.size() > 0)
        for (int i = 0; i < element.size(); i++) {
          titulo = new Phrase((String)element.elementAt(i), this.fontValores);
          HeaderCell = new PdfPCell(titulo);
          String valor = (String)element.elementAt(i);
          try
          {
            long x = Long.parseLong(valor.trim());
            HeaderCell.setHorizontalAlignment(1);
          } catch (Exception ex) {
            HeaderCell.setHorizontalAlignment(0);
          }

          tablaGeneral.addCell(HeaderCell);
        }
    }
    return tablaGeneral;
  }
  private String fecha() {
    Calendar c = Calendar.getInstance();
    int mes = c.get(2);
    int diaSemana = c.get(7);
    String[] nombreDia = { "Domingo", "Lunes", "Martes", "Miércoles", 
      "Jueves", "Viernes", "Sábado" };
    String[] nombreMeses = { "Enero", "Febrero", "Marzo", "Abril", "Mayo", 
      "Junio", "Julio", "Agosto", "Septiembre", "Octubre", 
      "Noviembre", "Diciembre" };
    String nomDia = nombreDia[(diaSemana - 1)];
    String nomMes = nombreMeses[mes];
    return nomDia + ", " + c.get(5) + " de " + nomMes + 
      " de " + c.get(1);
  }

  private String nTabs(int n) {
    String tabs = "";
    for (int i = 0; i < n; i++)
      tabs = tabs + "\t";
    return tabs;
  }
}