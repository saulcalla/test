package cl.ripley.framework.util;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConexionBD
{
  public static void main(String[] args)
  {
    Connection connection = null;
    Statement st = null;
    ResultSet rs = null;
    try
    {
      Class.forName("COM.ibm.db2.jdbc.net.DB2Driver");

      String url = "jdbc:db2://10.0.150.201:6789/mall";

      connection = DriverManager.getConnection(url, "db2inst1", 
        "db2inst4");

      st = connection.createStatement();

      String query = "SELECT count(1) FROM NOTA_VENTA";

      rs = st.executeQuery(query);

      while (rs.next())
      {
        System.out.println(rs.getInt(1));
      }

      rs.close();
      st.close();
      connection.close();
    }
    catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }
}