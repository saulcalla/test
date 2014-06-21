package cl.ripley.framework.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test
{
  SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");

  public static void main(String[] args)
  {
    Connection connection = null;
    Statement st = null;
    ResultSet rs = null;
    try
    {
      Class.forName("COM.ibm.db2.jdbc.net.DB2Driver");

      String url = "jdbc:db2://10.0.150.201:6789/mall";

      connection = DriverManager.getConnection(url, "db2inst1", "db2inst4");
      st = connection.createStatement();
      String query = "SELECT count(1) FROM NOTA_VENTA";

      rs = st.executeQuery(query);
      System.out.println("DATA [" + connection.getCatalog() + "]");
      while (rs.next())
      {
        System.out.println(rs.getInt(1));
      }

    }
    catch (ClassNotFoundException e)
    {
      e.printStackTrace();
      System.exit(1);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  public int enviaMirror(String mensaje)
    throws Exception
  {
    URL url = null;
    URLConnection conn = null;
    int i = 0;
    Vector vVector = null;
    String msje = mensaje;
    vVector = new Vector();
    try {
      String vURL = "http://10.0.150.101:8080/MirapiJava/mirapi";
      if (msje != null)
      {
        vURL = vURL + "?mensaje_serv=" + msje + "&pTipo=1";
        System.out.println("LLAMADA MIRROR");
        System.out.println(vURL);
        url = new URL(vURL); conn = url.openConnection(); conn.setDoInput(true);

        ObjectInputStream vInput = new ObjectInputStream(conn.getInputStream());

        vVector = (Vector)vInput.readObject();
        vInput.close();

        if (((String)vVector.elementAt(0)).equals("0"))
        {
          System.out.println("RESPUESTA MIRROR OK ");
          System.out.println(vVector.elementAt(1).toString());
        }
        else
        {
          vVector = new Vector();
          System.out.println("MirrorJava::enviaMirror: Problemas en estado de retorno.");
        }
      } else {
        System.out.println("MirrorJava::enviaMirror: Se debe asignar los parámetros de entrada Mirror(Verbo, Servidor, Puerto, Servicio).");
      }

    }
    catch (Exception e)
    {
      System.out.println("ERROR :: enviando mensaje a MIRROR " + e.getLocalizedMessage());
      i = 1;
    }

    return i;
  }

  public Calendar comparaFechas(Calendar fecha_1, Calendar fecha_2)
  {
    int dia_cal = fecha_1.get(5);

    System.out.println("Comparacion Fechas ");
    System.out.println("Fecha1 : " + this.sdf.format(fecha_1.getTime()));
    System.out.println("Fecha2 : " + this.sdf.format(fecha_2.getTime()));

    if (fecha_1.getTime().before(fecha_2.getTime())) {
      dia_cal++;
      fecha_1.set(5, dia_cal);
    }

    return fecha_1;
  }

  public String getVoucherMirror(String mensaje_resp_mirror)
  {
    String resp = "";
    String tarj_car = "";
    String tarj_gcp = "";
    String abono = "";
    long monto_r = 0L;
    try
    {
      int busqueda = mensaje_resp_mirror.indexOf("TOTAL A PAGAR");
      if (busqueda < 0) {
        return null;
      }

      resp = "CUENTA\tCAR \t\t\t401501134274480414\n";
      resp = resp + "NUMERO SUCURSAL \t\t039\n";
      resp = resp + "TARJETA GCP \t\t\t191627\n";
      resp = resp + "TOTAL ABONADO \t\t\t150000\n";

      resp = resp + "FECHA PRIMER VENCIMIENTO\t" + mensaje_resp_mirror.substring(46, 54) + "\n";

      Pattern pattern = Pattern.compile("TOTAL A PAGAR *.\\d*");
      Matcher matcher = pattern.matcher(mensaje_resp_mirror);

      if (matcher.find())
      {
        String tot = matcher.group();

        pattern = Pattern.compile("\\d.*");
        matcher = pattern.matcher(tot);
        if (matcher.find()) {
          monto_r = Long.valueOf(matcher.group()).longValue();

          System.out.println("Monto refinanciado : " + monto_r);
        }

      }

      resp = resp + "TOTAL A PAGAR \t\t\t" + monto_r + "\n";

      busqueda = mensaje_resp_mirror.indexOf("MES");
      if (busqueda > 0)
      {
        pattern = Pattern.compile("MES *.\\d* A *.\\d* *.\\d*");
        matcher = pattern.matcher(mensaje_resp_mirror);
        if (matcher.find())
        {
          System.out.println(matcher.group());
        }

        pattern = Pattern.compile("MENSUAL *.\\d*[.|,]*.\\d*");
        matcher = pattern.matcher(mensaje_resp_mirror);
        if (matcher.find())
        {
          System.out.println("TASA : \t" + matcher.group().replaceAll("MENSUAL", "").trim());
        }

        resp = resp + mensaje_resp_mirror.substring(113, 131) + "\n";
        resp = resp + "CUOTAS " + mensaje_resp_mirror.substring(186, 211) + "\n";
        resp = resp + mensaje_resp_mirror.substring(211, 280).replaceAll("@î", " ") + "\n";
      }

      System.out.println("Voucher generado \n" + resp);
    }
    catch (Exception e)
    {
      System.out.println("ERRO: getVoucherMirror() " + e.toString());
      return null;
    }

    return resp;
  }

  public void voucherHTML(String resp)
  {
    String cuenta_car = "";
    String cuenta_gcp = "";
    String sucursal = "";
    String caja = "";
    String abono = "";
    String total_refina = "";
    String primer_venc = "";
    String cuotas = "";

    String web = "http://localhost:8080/GestionTV/pages/";
    String link = "";
    String mensaje_cliente = "";
    try {
      link = web + "voucherGCPHTML.jsp?cuenta_car=" + cuenta_car + "&cuenta_gcp=" + cuenta_gcp + "&sucursal=" + sucursal + 
        "&caja=" + caja + "&abono=" + abono + "&total_refina=" + total_refina + "&primer_venc=" + primer_venc + "&cuotas=" + cuotas;

      URL url = new URL(link);

      URLConnection httpCon = url.openConnection();

      BufferedReader rd = new BufferedReader(new InputStreamReader(httpCon.getInputStream()));
      String line;
      while ((line = rd.readLine()) != null)
      {        
        mensaje_cliente = mensaje_cliente + line;
      }

      System.out.println(mensaje_cliente);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}