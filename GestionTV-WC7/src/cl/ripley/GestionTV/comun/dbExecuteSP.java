package cl.ripley.GestionTV.comun;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class dbExecuteSP
{
  public final int SP_QUERY = 10;
  public final int SP_UPDATE = 20;
  public final int SP_PARAM = 30;
  public final String SP_IN = "in";
  public final String SP_OUT = "out";
  public final String SP_INOUT = "inout";

  private ResultSet resultData = null;
  private Connection connection = null;
  private ResultSetMetaData metaData = null;
  private String strStoreProc = new String();
  private CallableStatement storeProc;
  private int typeSP = 10;

  public dbExecuteSP()
  {
  }

  public dbExecuteSP(Connection connection)
  {
    setConnection(connection);
  }

  public void setStoreProc(Connection connection, String storeProc, int typeSP)
  {
    try
    {
      this.typeSP = typeSP;
      this.strStoreProc = storeProc;
      this.storeProc = connection.prepareCall(storeProc);
    } catch (SQLException e) {
      Log.write(dbExecuteSP.class.getClass() + "::" + e.toString());
    } catch (Exception e) {
      Log.write(dbExecuteSP.class.getClass() + "::" + e.toString());
    }
  }

  public void setStoreProc(String storeProc, int typeSP)
  {
    try
    {
      this.typeSP = typeSP;
      this.strStoreProc = storeProc;
      this.storeProc = this.connection.prepareCall(storeProc);
    } catch (SQLException e) {
      Log.write(dbExecuteSP.class.getClass() + "::" + e.toString());
    } catch (Exception e) {
      Log.write(dbExecuteSP.class.getClass() + "::" + e.toString());
    }
  }

  public CallableStatement getStoreProc() {
    return this.storeProc;
  }

  public boolean executeStoreProc()
    throws SQLException
  {
    if (this.typeSP == 10) {
      this.resultData = this.storeProc.executeQuery();
      this.metaData = this.resultData.getMetaData();
    }
    else if (this.typeSP == 20) {
      this.storeProc.executeUpdate();
    } else {
      this.storeProc.execute();
    }
    return true;
  }

  public void setSPParamOut(int parameterIndex, int sqlType)
  {
    try
    {
      this.storeProc.registerOutParameter(parameterIndex, sqlType);
    } catch (SQLException e) {
      Log.write(dbExecuteSP.class.getClass() + "::" + e.toString());
    } catch (Exception e) {
      Log.write(dbExecuteSP.class.getClass() + "::" + e.toString());
    }
  }

  public Connection getConnection()
  {
    return this.connection;
  }

  public ResultSetMetaData getMetaData()
  {
    return this.metaData;
  }

  public ResultSet getResultData()
  {
    return this.resultData;
  }

  public String getStrStoreProc()
  {
    return this.strStoreProc;
  }

  public int getTypeSP()
  {
    return this.typeSP;
  }

  public void setConnection(Connection connection)
  {
    this.connection = connection;
  }

  public void setMetaData(ResultSetMetaData data)
  {
    this.metaData = data;
  }

  public void setResultData(ResultSet set)
  {
    this.resultData = set;
  }

  public void setStoreProc(CallableStatement statement)
  {
    this.storeProc = statement;
  }

  public void setStrStoreProc(String string)
  {
    this.strStoreProc = string;
  }

  public void setTypeSP(int i)
  {
    this.typeSP = i;
  }
}