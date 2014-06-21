package cl.ripley.GestionTV.comun;

import java.util.Map;
import java.util.Vector;
import javax.sql.DataSource;

public class GestionTVFuncion extends ConectaBD
{
  public Vector getOpcionesMenu(DataSource dataSource, String strRut, String strClave, String strSistema)
  {
    Vector vRes = new Vector();

    String statement = 
      (String)Util.getMap().get("GestionTVFunciones.inst01");

    Vector vWhere = new Vector();
    vWhere.add("Int," + strRut);

    Clave objClave = new Clave();
    String Clave = "";
    objClave.codifica(strClave);
    Clave = objClave.getPassword();
    vWhere.add(Clave);

    vWhere.add("Int," + strSistema);
    vRes = consulta(dataSource, statement, vWhere, 5);

    return vRes;
  }
}