package cl.ripley.GestionTV.oem;

import cl.ripley.GestionTV.comun.Util;
import cl.ripley.GestionTV.struts.bean.CargasBean;
import java.io.PrintStream;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.apache.struts.util.MessageResources;

public class OEMasociaciones
{
  protected static MessageResources messages = MessageResources.getMessageResources("cl.ripley.GestionTV.struts.msgGestionTV");
  private static Hashtable hshPagina = new Hashtable();
  private static int OEMcontador;
  private static int paginaActual;
  private static int totalPaginas;
  private static String hayProximoBloque = "si";
  private static String[] paginas;
  private static String hayDatos = "no";
  private static String fechacarga = " ";
  private static Vector vectorExportar;

  public static void CargaTodasPaginasBD(Vector vct)
  {
    Vector vctPaginas = new Vector();
    Vector vctFila = new Vector();
    Vector vctTmp = new Vector();

    Hashtable hshRelPaginas = new Hashtable();
    boolean vEsPrimer = true;
    try
    {
      hshPagina.clear();
      Enumeration e = vct.elements();

      int i = 1; int j = 1; int contador = 0;
      boolean entro = false;

      while (e.hasMoreElements()) {
        contador++;

        Vector reg = (Vector)e.nextElement();

        if (i > 50) {
          vctPaginas.add(vctTmp);
          hshRelPaginas.put(String.valueOf(j), vctTmp);
          entro = true;
          vctPaginas = new Vector();
          vctTmp = new Vector();
          i = 1;
          j++;
        }
        else {
          vctTmp.add(reg);
          reg = new Vector();
          i++;
        }
      }

      if (i > 1) {
        vctPaginas.add(vctTmp);
        hshRelPaginas.put(String.valueOf(j), vctTmp);
        setHayDatos("si");
        entro = true;
      } else {
        setHayDatos("no");
      }

      if (entro) {
        setOEMcontador(contador);
        setPaginaActual(1);
        setHshPagina(hshRelPaginas);
        setTotalPaginas(getHshPagina().size());
        setHayProximoBloque("si");
      }
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
  }

  public static Vector CargaPaginas(String strNumPagina)
  {
    Hashtable hshLocPag = getHshPagina();
    Vector vcttmpPag = (Vector)hshLocPag.get(strNumPagina);
    Vector vctRetPaginas = new Vector();

    if (vcttmpPag != null) {
      vctRetPaginas = vcttmpPag;
      setHayDatos("si");
    } else {
      setHayDatos("no");
    }

    int totIndex = hshLocPag.size();
    setTotalPaginas(totIndex);
    if (Integer.parseInt(strNumPagina) >= totIndex)
      setHayProximoBloque("no");
    else {
      setHayProximoBloque("si");
    }
    return vctRetPaginas;
  }

  public static Vector CargaTotal(int total)
  {
    Vector vctPagina = new Vector();
    String vctPaginaAux = new String();
    CargasBean objBean = new CargasBean();
    if (total > 0) {
      objBean.setTotalPaginas(getTotalPaginas());
      int j = 0;
      for (j = 1; j <= total; j++) {
        vctPagina = CargaPaginas(Integer.toString(j));
        vctPaginaAux = vctPaginaAux + vctPagina;
      }
    }

    vctPagina = Util.stringToVector(vctPaginaAux);
    return vctPagina;
  }

  public static String getHayDatos()
  {
    return hayDatos;
  }

  public static String getHayProximoBloque()
  {
    return hayProximoBloque;
  }

  public static int getOEMcontador()
  {
    return OEMcontador;
  }

  public static int getPaginaActual()
  {
    return paginaActual;
  }

  public static String[] getPaginas()
  {
    return paginas;
  }

  public static int getTotalPaginas()
  {
    return totalPaginas;
  }

  public static void setHayDatos(String string)
  {
    hayDatos = string;
  }

  public static void setHayProximoBloque(String string)
  {
    hayProximoBloque = string;
  }

  public static void setOEMcontador(int i)
  {
    OEMcontador = i;
  }

  public static void setPaginaActual(int i)
  {
    paginaActual = i;
  }

  public static void setPaginas(String[] strings)
  {
    paginas = strings;
  }

  public static void setTotalPaginas(int i)
  {
    totalPaginas = i;
  }

  public static Hashtable getHshPagina()
  {
    return hshPagina;
  }

  public static void setHshPagina(Hashtable hashtable)
  {
    hshPagina = hashtable;
  }

  public static String getFechacarga()
  {
    return fechacarga;
  }

  public static void setFechacarga(String string)
  {
    fechacarga = string;
  }

  public static void CargaTodasPaginasExportar(Vector vct)
  {
    Vector vctTmp = new Vector();
    try {
      hshPagina.clear();
      Enumeration e = vct.elements();

      while (e.hasMoreElements()) {
        Vector reg = (Vector)e.nextElement();
        vctTmp.add(reg);
        reg = new Vector();
      }
    }
    catch (Exception e) {
      System.out.println(e);
    }
    setVectorExportar(vctTmp);
  }

  public static Vector getVectorExportar()
  {
    return vectorExportar;
  }

  public static void setVectorExportar(Vector vector)
  {
    vectorExportar = vector;
  }
}