package cl.ripley.framework.util;

import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Vector;
import org.apache.log4j.Logger;

public class MirrorJava
{
  protected PrintWriter out = null;
  protected int puntero;
  private String mensajeMirror;
  private String mensaje_verbo;
  private static String servidorMirror;
  private static String puertoMirror;
  private static String servicioMirror;
  static Logger log = Logger.getRootLogger();

  final int getInt(String aux)
  {
    try
    {
      if ((aux == null) || (aux.equals(""))) {
        return 0;
      }
      return Integer.parseInt(aux);
    }
    catch (Exception e) {
      this.out.print("MirrorJava::getInt::Exception" + e.getMessage() + " <br>");
    }
    return 0;
  }

  final double getDouble(String s)
  {
    try
    {
      if ((s == null) || (s.trim().equals(""))) {
        return 0.0D;
      }
      return Double.valueOf(s.trim()).doubleValue();
    }
    catch (NumberFormatException e) {
      this.out.print("MirrorJava::getDouble::NumberFormatException\t" + 
        e.getMessage() + "<br>");
    } catch (Exception e) {
      this.out.print("MirrorJava::getDouble::Exception" + 
        e.getMessage() + " <br>");
    }
    return 0.0D;
  }

  public String getCadena(int offset, int length)
    throws Exception
  {
    if (this.mensajeMirror.getBytes() != null) {
      if (offset + length <= this.mensajeMirror.length() + 1) {
        return new String(this.mensajeMirror.getBytes(), offset, length);
      }
      throw new Exception("MirrorJava:: getCadena: (offset=" + offset + "+length=" + 
        length + ") > tamaño del buffer (size+1)=" + this.mensajeMirror.length() + "+1!!");
    }

    throw new Exception("MirrorJava:: getCadena: buffer 'mensajeMirror' ds nulo !!");
  }

  public void inicializaPuntero(int pPuntero)
  {
    this.puntero = pPuntero;
  }

  public void avanzaPuntero(int pPuntero)
  {
    this.puntero += pPuntero;
  }

  public void retrocedePuntero(int pPuntero)
  {
    this.puntero -= pPuntero;
  }

  public boolean existeInformacion(int pPuntero)
  {
    boolean vRetorno = false;
    char mas_paginas = 'C';

    mas_paginas = this.mensajeMirror.charAt(pPuntero + 1);

    if ((mas_paginas == 'C') || (mas_paginas == 'U')) {
      vRetorno = true;
    }
    return vRetorno;
  }

  public int leePuntero()
  {
    return this.puntero;
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
      String vURL = "http://" + 
        getServidorMirror() + 
        ":" + 
        getPuertoMirror() + 
        "/" + 
        getServicioMirror();
      if (msje != null)
      {
        vURL = vURL + "?mensaje_serv=" + msje + "&pTipo=1";
        log.info("LLAMADA MIRROR");
        log.info(vURL);
        url = new URL(vURL); conn = url.openConnection(); conn.setDoInput(true);

        ObjectInputStream vInput = new ObjectInputStream(conn.getInputStream());

        vVector = (Vector)vInput.readObject();
        vInput.close();

        if (((String)vVector.elementAt(0)).equals("0"))
        {
          log.info("RESPUESTA MIRROR OK ");
          setMensajeRespMirror((String)vVector.elementAt(1));
          log.info("[" + getMensajeRespMirror() + "]");
        }
        else {
          setMensajeRespMirror("MirrorJava::enviaMirror: Problemas en estado de retorno.");
          vVector = new Vector();
          this.out.println("MirrorJava::enviaMirror: Problemas en estado de retorno.");
        }
      } else {
        this.out.println("MirrorJava::enviaMirror: Se debe asignar los parámetros de entrada Mirror(Verbo, Servidor, Puerto, Servicio).");
        setMensajeRespMirror("MirrorJava::enviaMirror: Se debe asignar los parámetros de entrada Mirror(Verbo, Servidor, Puerto, Servicio).");
        i = 1;
      }
    }
    catch (Exception e)
    {
      log.error("ERROR :: enviando mensaje a MIRROR " + e.getLocalizedMessage());
      i = 1;
    }

    return i;
  }

  public int enviaMirrorProduccion()
  {
    URL url = null;
    URLConnection conn = null;
    int i = 0;

    Vector vVector = null;
    String vEstado = "-1";

    String vURL = "http://" + 
      getServidorMirror() + 
      ":" + 
      getPuertoMirror() + 
      "/" + 
      getServicioMirror();

    if ((this.mensaje_verbo != null) && 
      (this.mensaje_verbo.length() > 0) && 
      (getServicioMirror() != null) && 
      (getPuertoMirror() != null) && 
      (getServicioMirror() != null))
    {
      try {
        vURL = vURL + "?mensaje_serv=" + this.mensaje_verbo;
        url = new URL(vURL);
        conn = url.openConnection();

        conn.setDoInput(true);
        ObjectInputStream vInput = new ObjectInputStream(conn.getInputStream());

        vVector = new Vector();
        vVector = (Vector)vInput.readObject();
        vInput.close();

        vEstado = (String)vVector.elementAt(0);
        if (vEstado.equals("0")) {
          setMensajeRespMirror((String)vVector.elementAt(1));
        } else {
          setMensajeRespMirror(null);
          vVector = new Vector();
          log.error("MirrorJava::enviaMirror: Problemas en estado de retorno.");
        }
      } catch (Exception e) {
        log.error("MirrorJava::enviaMirror");
        e.printStackTrace();
        i = 1;
      }
    } else {
      log.error("MirrorJava::enviaMirror: Se debe asignar los parámetros de entrada Mirror(Verbo, Servidor, Puerto, Servicio).");
      i = 1;
    }
    return i;
  }

  public void setVerbo(String vMensaje)
  {
    this.mensaje_verbo = vMensaje;
  }

  public String getVerbo() {
    return this.mensaje_verbo;
  }

  public String getMensajeRespMirror()
  {
    return this.mensajeMirror;
  }

  private void setMensajeRespMirror(String pMensaje)
  {
    this.mensajeMirror = pMensaje;
  }

  public static void setServidorMirror(String pServidor)
  {
    servidorMirror = pServidor;
  }

  private String getServidorMirror()
  {
    return servidorMirror;
  }

  public static void setPuertoMirror(String pPuerto)
  {
    puertoMirror = pPuerto;
  }

  private String getPuertoMirror()
  {
    return puertoMirror;
  }

  public static void setServicioMirror(String pServicio)
  {
    servicioMirror = pServicio;
  }

  private String getServicioMirror()
  {
    return servicioMirror;
  }
}