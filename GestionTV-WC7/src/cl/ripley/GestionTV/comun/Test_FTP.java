package cl.ripley.GestionTV.comun;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.MalformedURLException;
import org.apache.commons.net.ftp.FTPClient;

class Test_FTP
{
  public static void main(String[] args)
    throws MalformedURLException, IOException
  {
    try
    {
      String fileName = "archivos-pdf-new/PDFVCTO20/06/00001050200706.pdf";
      System.out.println(fileName.substring(30));
      FTPClient f = new FTPClient();
      for (int x = 0; x < 10; x++)
      {
        try
        {
          f.connect("10.0.152.12");
          f.login("tvirtual", "Virtual");
          System.out.println(f.printWorkingDirectory());
          System.out.println(fileName.substring(17, 29));
          System.out.println(fileName.substring(31));
          f.changeWorkingDirectory(fileName.substring(17, 29));

          System.out.println(f.printWorkingDirectory());

          String[] datos = f.listNames("00001050200706.pdf");
          if (datos.length > 0)
            System.out.println("ARCHIVO EXISTE !!!!");
          for (int y = 0; y < datos.length; y++) {
            System.out.println("archivo : " + datos[y]);
          }
          InputStream in = f.retrieveFileStream(fileName);
          int bit = in.available();
          FileOutputStream out = new FileOutputStream("c:/Informe" + x + ".pdf");

          while (bit >= 0) {
            bit = in.read();
            if (bit != -1) {
              out.write(bit);
            }
          }

          System.out.println(x + " : " + f.isConnected());
          in.close();
          out.close();
        }
        catch (IOException e)
        {
          e.printStackTrace();
          try
          {
            if (f.isConnected())
            {
              f.logout();
              f.disconnect();
            }
          }
          catch (Exception ex) {
            ex.printStackTrace();
          }
        }
        finally
        {
          try
          {
            if (f.isConnected())
            {
              f.logout();
              f.disconnect();
            }
          }
          catch (Exception e) {
            e.printStackTrace();
          }

        }

      }

    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
}