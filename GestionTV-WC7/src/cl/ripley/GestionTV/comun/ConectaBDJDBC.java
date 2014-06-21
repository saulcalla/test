package cl.ripley.GestionTV.comun;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.Vector;
import javax.sql.DataSource;
import org.apache.log4j.Logger;
import org.apache.struts.util.MessageResources;

public class ConectaBDJDBC
{
  static Logger log = Logger.getRootLogger();

  protected MessageResources messages = MessageResources.getMessageResources(
    "cl.ripley.GestionTV.struts.conectaBDJDBC");

  Connection conexion = null;
  PreparedStatement pstatement = null;
  private ResultSet rst = null;
  String mens_error = "";
  Statement st = null;
  static String insert = "INSERT INTO FETVIR_MAE_STK_BTK (TVMSB_NRO_LOC_BOD, TVMSB_INV_PROD, TVMSB_DIS_PROD, TVMSB_COD_VTA, TVMSB_COD_DPTO ) VALUES";

  public Connection getConnection()
  {
    try
    {
      if (this.conexion == null) {
        Class.forName(this.messages.getMessage("gestiontv.bt.class.for.name"));

        this.conexion = DriverManager.getConnection(this.messages.getMessage("gestiontv.bt.url.conexion"), 
          this.messages.getMessage("gestiontv.bt.usuario.conexion"), 
          this.messages.getMessage("gestiontv.bt.password.conexion"));
      }
      else {
        log.info("Conexion a BigTicket Ya existe");
        return this.conexion;
      }
    }
    catch (ClassNotFoundException e)
    {
      log.error("Error al crear conexion con BD " + e.toString());
    }
    catch (SQLException e) {
      log.error("Error al conectarse con BD " + e.toString());
    }

    return this.conexion;
  }

  public void consultaRst(String query, Vector vCondicion)
  {
    String vSql = (String)Util.getMap().get(query);
    Vector camposFinal = new Vector();
    SimpleDateFormat df = 
      new SimpleDateFormat(
      this.messages.getMessage("constante.FORMATO_FECHA"));
    try
    {
      this.conexion = getConnection();
      this.pstatement = this.conexion.prepareStatement(vSql);
      for (int j = 0; j < vCondicion.size(); j++) {
        String[] vCadena = vCondicion.elementAt(j).toString().split(",");
        if (vCadena[0].equals("Date")) {
          java.util.Date date1 = df.parse(vCadena[1]);
          this.pstatement.setDate(
            j + 1, 
            new java.sql.Date(date1.getTime()));
        } else if (vCadena[0].equals("String")) {
          if (vCadena[1].equals("Null"))
            this.pstatement.setNull(j + 1, 12);
          else {
            this.pstatement.setString(j + 1, vCadena[1]);
          }
        }
        else if (vCadena[0].equals("Int")) {
          this.pstatement.setLong(j + 1, Integer.parseInt(vCadena[1]));
        }
        else {
          this.pstatement.setString(
            j + 1, 
            vCondicion.elementAt(j).toString());
        }
      }
      setRst(this.pstatement.executeQuery());
    }
    catch (Exception e) {
      log.error("::Exception, " + e.getMessage());
      e.printStackTrace();
    }
  }

  public void cierraRst()
  {
    if (this.pstatement != null) {
      try {
        this.pstatement.close();
        this.pstatement = null;
      } catch (Exception e) {
        log.error("::pstatement, " + e.getMessage());
      }
    }

    if (this.rst != null) {
      try
      {
        this.rst.close();
        this.rst = null;
      } catch (Exception e) {
        log.error("::rst, " + e.getMessage());
      }
    }

    if (this.st != null) {
      try
      {
        this.st.close();
        this.st = null;
      } catch (Exception e) {
        log.error("::rst, " + e.getMessage());
      }
    }
    try
    {
      if ((this.conexion != null) && 
        (!this.conexion.isClosed())) {
        this.conexion.close();
        this.conexion = null;
      }

    }
    catch (Exception e)
    {
      log.error("::conexion, " + e.getMessage());
    }
  }

  public int elimina(DataSource dataSource, String pSql, Vector pCondicion)
  {
    int vRetorno = 0;
    try {
      vRetorno = actualiza_sql(dataSource, pSql, pCondicion);
    } catch (Exception ex) {
      log.error("::Exception, " + ex.getMessage());
    }
    return vRetorno;
  }

  private int actualiza_sql(DataSource dataSource, String pSql, Vector pCondicion)
  {
    int rowCount = 0;
    SimpleDateFormat df = 
      new SimpleDateFormat(
      this.messages.getMessage("constante.FORMATO_FECHA"));
    try
    {
      this.conexion = dataSource.getConnection();
      this.st = this.conexion.createStatement();
      this.pstatement = this.conexion.prepareStatement(pSql);
      for (int j = 0; j < pCondicion.size(); j++) {
        String[] vCadena = pCondicion.elementAt(j).toString().split(",");
        if (vCadena[0].equals("Date")) {
          java.util.Date date1 = df.parse(vCadena[1]);
          this.pstatement.setDate(j + 1, new java.sql.Date(date1.getTime()));
        } else if (vCadena[0].equals("String")) {
          if (vCadena[1].equals("Null"))
            this.pstatement.setNull(j + 1, 12);
          else {
            this.pstatement.setString(j + 1, vCadena[1]);
          }
        }
        else if (vCadena[0].equals("Int")) {
          this.pstatement.setLong(j + 1, Integer.parseInt(vCadena[1]));
        }
        else {
          this.pstatement.setString(j + 1, pCondicion.elementAt(j).toString());
        }
      }
      rowCount = this.pstatement.executeUpdate(pSql);
      this.conexion.commit();
      log.info("ELIMINA pstatement.executeUpdate " + rowCount);
    }
    catch (Exception e) {
      log.error("::Exception, " + e.getMessage());
      rowCount = -1;
    }
    finally {
      cierraRst();
    }

    return rowCount;
  }

  public int insert_sql(DataSource dataSource, Vector insert)
  {
    int rowCount = 0;

    String insert_str = insert.toString();
    try
    {
      this.conexion = dataSource.getConnection();
      this.st = this.conexion.createStatement();
      for (int j = 0; j < insert.size(); j++) {
        insert_str = insert_str + (insert.get(j) == null ? "" : insert.get(j).toString().trim());

        if ((j < insert.size() - 1) && (j % 1000 != 0)) {
          insert_str = insert_str + ",\n";
        }
        else {
          insert_str = insert_str;
        }

        if (j % 1000 == 0) {
          this.st.executeUpdate(insert_str);
          this.conexion.commit();

          insert_str = "";
          insert_str = insert_str + insert;
        }

      }

      this.st.executeUpdate(insert_str);
      this.conexion.commit();
    }
    catch (Exception e) {
      log.error("::Exception, " + e.getMessage());
      setMens_error(":: Error insertando registros desde BT " + e.toString());
      rowCount = -1;
    }
    finally {
      cierraRst();
    }

    return rowCount;
  }

  public ResultSet getRst()
  {
    return this.rst;
  }

  public void setRst(ResultSet set)
  {
    this.rst = set;
  }

  public String getMens_error() {
    return this.mens_error;
  }

  public void setMens_error(String mens_error) {
    this.mens_error = mens_error;
  }
}