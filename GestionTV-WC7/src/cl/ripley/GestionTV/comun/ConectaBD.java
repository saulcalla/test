package cl.ripley.GestionTV.comun;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Map;
import java.util.Vector;
import javax.sql.DataSource;
import org.apache.log4j.Logger;
import org.apache.struts.util.LabelValueBean;
import org.apache.struts.util.MessageResources;

public class ConectaBD
{
  static Logger log = Logger.getRootLogger();

  protected MessageResources messages = MessageResources.getMessageResources(
    "cl.ripley.GestionTV.struts.msgGestionTV");

  Connection conexion = null;
  PreparedStatement pstatement = null;
  private ResultSet rst = null;
  String mens_error = "";
  String mens_pl = "";

  public boolean conecta(DataSource dataSource)
  {
    boolean vConecta = true;
    return vConecta;
  }

  public Vector consulta(DataSource dataSource, String vSql, Vector vCondicion, int vMostrar)
  {
    Vector camposFinal = new Vector();
    SimpleDateFormat df = 
      new SimpleDateFormat(
      this.messages.getMessage("constante.FORMATO_FECHA"));

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    try {
      con = dataSource.getConnection();
      ps = con.prepareStatement(vSql);
      for (int j = 0; j < vCondicion.size(); j++) {
        String[] vCadena = vCondicion.elementAt(j).toString().split(",");
        if (vCadena[0].equals("Date")) {
          java.util.Date date1 = df.parse(vCadena[1]);
          ps.setDate(j + 1, new java.sql.Date(date1.getTime()));
        } else if (vCadena[0].equals("String")) {
          if (vCadena[1].equals("Null"))
            ps.setNull(j + 1, 12);
          else {
            ps.setString(j + 1, vCadena[1]);
          }
        }
        else if (vCadena[0].equals("Like"))
        {
          if (vCadena.length > 1)
            ps.setString(j + 1, vCadena[1] + "%");
          else
            ps.setString(j + 1, "%");
        }
        else if (vCadena[0].equals("Int")) {
          ps.setLong(j + 1, Integer.parseInt(vCadena[1]));
        }
        else {
          ps.setString(j + 1, vCondicion.elementAt(j).toString());
        }
      }

      rs = ps.executeQuery();
      int conta = 0;
      while (rs.next()) {
        Vector campos = new Vector();
        for (int i = 1; i <= vMostrar; i++)
          campos.add(rs.getString(i));
        camposFinal.add(campos);
        
        conta++;
      }
      rs.close();
      ps.close();
      con.close();
    } catch (Exception e) {
      log.error("::Exception, " + e);
      setMens_error(e.getMessage());
    }
    finally {
      if (rs == null){
    	  if (ps != null) try {
    	        ps.close();
    	      } catch (Exception e) {
    	        log.error("::ps, " + e.getMessage());
    	      }
      }
    }try { rs.close();
    } catch (Exception e) {
      log.error("::rs, " + e.getMessage());
    }

   
    try
    {
      if (!con.isClosed())
        con.close();
    }
    catch (Exception e) {
      log.error("::con.isClosed(), " + e.getMessage());
    }
    return camposFinal;
  }
  public Vector consultaParams(DataSource dataSource, String vSql, int vMostrar, String itemspcId)
  {
    Vector camposFinal = new Vector();
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    try {
      ps = null;
      con = dataSource.getConnection();
      ps = con.prepareStatement(vSql);
      
      ps.setString(1, itemspcId);
      
      rs = ps.executeQuery();
      while (rs.next()) {
        Vector campos = new Vector();
        for (int i = 1; i <= vMostrar; i++)
        {
          campos.add(rs.getString(i));
        }camposFinal.add(campos);
      }
    }
    catch (Exception e) {
      log.error("::Exception, " + e.getMessage());

      if (rs != null) try {
          rs.close();
        } catch (Exception ex) {
          log.error("::rs, " + ex.getMessage());
        }

      if (ps != null) try {
          ps.close();
        } catch (Exception ex) {
          log.error("::ps, " + ex.getMessage());
        }
      try
      {
        if (!con.isClosed())
          con.close();
      }
      catch (Exception ex) {
        log.error("::con, " + ex.getMessage());
      }
    }
    finally
    {
      if (rs != null) try {
          rs.close();
        } catch (Exception e) {
          log.error("::rs, " + e.getMessage());
        }

      if (ps != null) try {
          ps.close();
        } catch (Exception e) {
          log.error("::ps, " + e.getMessage());
        }
      try
      {
        if (!con.isClosed())
          con.close();
      }
      catch (Exception e) {
        log.error("::con, " + e.getMessage());
      }

    }

    return camposFinal;
  }
  public Vector consulta(DataSource dataSource, String vSql, int vMostrar)
  {
    Vector camposFinal = new Vector();
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    try {
      ps = null;
      con = dataSource.getConnection();
      ps = con.prepareStatement(vSql);
      rs = ps.executeQuery();
      while (rs.next()) {
        Vector campos = new Vector();
        for (int i = 1; i <= vMostrar; i++)
        {
          campos.add(rs.getString(i));
        }camposFinal.add(campos);
      }
    }
    catch (Exception e) {
      log.error("::Exception, " + e.getMessage());

      if (rs != null) try {
          rs.close();
        } catch (Exception ex) {
          log.error("::rs, " + ex.getMessage());
        }

      if (ps != null) try {
          ps.close();
        } catch (Exception ex) {
          log.error("::ps, " + ex.getMessage());
        }
      try
      {
        if (!con.isClosed())
          con.close();
      }
      catch (Exception ex) {
        log.error("::con, " + ex.getMessage());
      }
    }
    finally
    {
      if (rs != null) try {
          rs.close();
        } catch (Exception e) {
          log.error("::rs, " + e.getMessage());
        }

      if (ps != null) try {
          ps.close();
        } catch (Exception e) {
          log.error("::ps, " + e.getMessage());
        }
      try
      {
        if (!con.isClosed())
          con.close();
      }
      catch (Exception e) {
        log.error("::con, " + e.getMessage());
      }

    }

    return camposFinal;
  }

  public void consultaRst(DataSource dataSource, String query, Vector vCondicion)
  {
    String vSql = (String)Util.getMap().get(query);
    Vector camposFinal = new Vector();
    SimpleDateFormat df = 
      new SimpleDateFormat(
      this.messages.getMessage("constante.FORMATO_FECHA"));

    SimpleDateFormat df2 = 
      new SimpleDateFormat(
      this.messages.getMessage("constante.FORMATO_FECHA_2"));
    try
    {
      this.conexion = dataSource.getConnection();
      this.pstatement = this.conexion.prepareStatement(vSql);
      for (int j = 0; j < vCondicion.size(); j++) {
        String[] vCadena = vCondicion.elementAt(j).toString().split(",");
        if (vCadena[0].equals("Date")) {
          java.util.Date date1 = df.parse(vCadena[1]);
          this.pstatement.setDate(
            j + 1, 
            new java.sql.Date(date1.getTime()));
        }
        if (vCadena[0].equals("Datedmy")) {
          java.util.Date date1 = df2.parse(vCadena[1]);
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
        } else if (vCadena[0].equals("Long")) {
          this.pstatement.setLong(j + 1, Long.parseLong(vCadena[1]));
        } else if (vCadena[0].equals("Like"))
        {
          if (vCadena.length > 1)
            this.pstatement.setString(j + 1, vCadena[1] + "%");
          else {
            this.pstatement.setString(j + 1, "%");
          }
        }
        else
        {
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
      cierraRst();
    }
  }

  public void cierraRst()
  {
    if (this.pstatement != null) {
      try {
        this.pstatement.close();
      } catch (Exception e) {
        log.error("::pstatement, " + e.getMessage());
      }
    }

    if (this.rst != null) {
      try
      {
        this.rst.close();
      } catch (Exception e) {
        log.error("::rst, " + e.getMessage());
      }
    }
    try
    {
      if ((this.conexion != null) && 
        (!this.conexion.isClosed())) {
        this.conexion.close();
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

  public int actualiza(DataSource dataSource, String pSql, Vector pCondicion)
  {
    int vRetorno = 0;
    try {
      vRetorno = actualiza_sql(dataSource, pSql, pCondicion);
    } catch (Exception ex) {
      vRetorno = -1;
      log.error("::Exception, " + ex.getMessage());
    }
    return vRetorno;
  }

  private int actualiza_sql(DataSource dataSource, String pSql, Vector pCondicion) throws SQLException
  {
    int rowCount = 0;
    SimpleDateFormat df = 
      new SimpleDateFormat(
      this.messages.getMessage("constante.FORMATO_FECHA"));

    SimpleDateFormat df2 = 
      new SimpleDateFormat(
      this.messages.getMessage("constante.FORMATO_FECHA_GCP"));

    Connection con = null;
    PreparedStatement ps = null;
    try {
      con = dataSource.getConnection();
      ps = con.prepareStatement(pSql);
      for (int j = 0; j < pCondicion.size(); j++) {
        String[] vCadena = pCondicion.elementAt(j).toString().split(",");
        if (vCadena[0].equals("Datebo"))
        {
          java.util.Date date1 = df2.parse(vCadena[1]);
          ps.setDate(j + 1, new java.sql.Date(date1.getTime()));
        }
        else if (vCadena[0].equals("Datehm")) {
          java.util.Date date1 = df2.parse(vCadena[1]);
          ps.setTimestamp(j + 1, new Timestamp(date1.getTime()));
        }
        else if (vCadena[0].equals("Date")) {
          java.util.Date date1 = df.parse(vCadena[1]);
          ps.setDate(j + 1, new java.sql.Date(date1.getTime()));
        } else if (vCadena[0].equals("String")) {
          if ((vCadena[1].equals("Null")) || (vCadena[1].equals("")))
            ps.setNull(j + 1, 12);
          else {
            ps.setString(j + 1, vCadena[1]);
          }
        }
        else if (vCadena[0].equals("Int")) {
          ps.setLong(j + 1, Integer.parseInt(vCadena[1]));
        } else if (vCadena[0].equals("Long")) {
          ps.setLong(j + 1, Long.parseLong(vCadena[1]));
        }
        else {
          ps.setString(j + 1, pCondicion.elementAt(j).toString());
        }

      }

      rowCount = ps.executeUpdate();
      ps.close();
      con.commit();
      con.close();
    } catch (Exception e) {
      e.printStackTrace();
      log.error("::Exception, " + e.getMessage());
      if (con != null)
        con.rollback();
      rowCount = -1;
    } finally {
      if (ps == null){
    	  try
    	    {
    	      if (!con.isClosed())
    	        con.close();
    	    }
    	    catch (Exception e) {
    	      log.error("::con, " + e.getMessage());
    	    }
      }
    }try { ps.close();
    } catch (Exception e) {
      log.error("::ps, " + e.getMessage());
    }
    
    return rowCount;
  }

  public int actualizaFechaBoleta(DataSource dataSource, String pSql, Vector pCondicion, boolean ultimo_reg)
  {
    int rowCount = 0;
    SimpleDateFormat df = new SimpleDateFormat(this.messages
      .getMessage("constante.FORMATO_FECHA"));

    SimpleDateFormat df2 = new SimpleDateFormat(this.messages
      .getMessage("constante.FORMATO_FECHA_GCP"));

    Connection con = null;
    PreparedStatement ps = null;
    try {
      con = dataSource.getConnection();
      Statement st = con.createStatement();
      ps = con.prepareStatement(pSql);
      int size = pCondicion.size();
      for (int j = 0; j < pCondicion.size(); j++) {
        String[] vCadena = pCondicion.elementAt(j).toString().split(",");
        if (vCadena[0].equals("Datebo"))
        {
          java.util.Date date1 = df2.parse(vCadena[1]);
          ps.setDate(j + 1, new java.sql.Date(date1.getTime()));
        } else if (vCadena[0].equals("Datehm")) {
          java.util.Date date1 = df2.parse(vCadena[1]);
          ps.setTimestamp(j + 1, new Timestamp(date1
            .getTime()));
        } else if (vCadena[0].equals("Date")) {
          java.util.Date date1 = df.parse(vCadena[1]);
          ps.setDate(j + 1, new java.sql.Date(date1.getTime()));
        } else if (vCadena[0].equals("String")) {
          if (vCadena[1].equals("Null"))
            ps.setNull(j + 1, 12);
          else {
            ps.setString(j + 1, vCadena[1]);
          }
        }
        else if (vCadena[0].equals("Int")) {
          ps.setLong(j + 1, Integer.parseInt(vCadena[1]));
        } else if (vCadena[0].equals("Long")) {
          ps.setLong(j + 1, Long.parseLong(vCadena[1]));
        } else {
          ps.setString(j + 1, pCondicion.elementAt(j).toString());
        }
      }

      rowCount = ps.executeUpdate();
      ps.close();
      con.commit();
      con.close();
    }
    catch (Exception e) {
      log.error("::Exception, " + e.getMessage());
      if (con != null)
        try {
          con.rollback();
        }
        catch (SQLException e1) {
          log.error(e1);
        }
      rowCount = -1;
    }

    return rowCount;
  }

  public int insertaTRX_TAR_RIPLEY(DataSource dataSource, String pSql, Vector pCondicion) throws SQLException
  {
    int rowCount = 0;
    SimpleDateFormat df = new SimpleDateFormat(this.messages
      .getMessage("constante.FORMATO_FECHA"));

    Connection con = null;
    CallableStatement cs = null;
    try {
      con = dataSource.getConnection();
      Statement st = con.createStatement();
      cs = con.prepareCall(pSql);

      cs.registerOutParameter(9, 4);
      cs.registerOutParameter(11, 12);
      cs.registerOutParameter(12, 4);

      for (int j = 0; j < pCondicion.size(); j++) {
        String[] vCadena = pCondicion.elementAt(j).toString().split(",");
        if (vCadena[0].equals("Date")) {
          java.util.Date date1 = df.parse(vCadena[1]);
          cs.setDate(j + 1, new java.sql.Date(date1.getTime()));
        } else if (vCadena[0].equals("String")) {
          if (vCadena[1].equals("Null"))
            cs.setNull(j + 1, 12);
          else {
            cs.setString(j + 1, vCadena[1]);
          }
        }
        else if (vCadena[0].equals("Int")) {
          cs.setLong(j + 1, Integer.parseInt(vCadena[1]));
        }
        else {
          cs.setString(j + 1, pCondicion.elementAt(j).toString());
        }
      }

      cs.execute();
      rowCount = cs.getInt(12);
      setMens_pl(cs.getString(11));
      cs.close();
      con.commit();
      con.close();
    } catch (Exception e) {
      con.rollback();
      e.printStackTrace();
      log.error("::Exception, activaGCP_pl " + e.getMessage());
      rowCount = -1;
    } finally {
      if (cs == null){
    	  try
    	    {
    	      if (!con.isClosed())
    	        con.close();
    	    }
    	    catch (Exception e) {
    	      log.error("::con, activaGCP_pl " + e.getMessage());
    	    }
      }
    }
    try { cs.close();
    } catch (Exception e) {
      log.error("::ps, activaGCP_pl " + e.getMessage());
    }
    
    return rowCount;
  }

  public int activaGCP_pl(DataSource dataSource, String pSql, Vector pCondicion) throws SQLException
  {
    int rowCount = 0;
    SimpleDateFormat df = new SimpleDateFormat(this.messages
      .getMessage("constante.FORMATO_FECHA"));

    Connection con = null;
    CallableStatement cs = null;
    try {
      con = dataSource.getConnection();
      Statement st = con.createStatement();
      cs = con.prepareCall(pSql);

      cs.registerOutParameter(9, 4);
      cs.registerOutParameter(11, 12);
      cs.registerOutParameter(12, 4);

      for (int j = 0; j < pCondicion.size(); j++) {
        String[] vCadena = pCondicion.elementAt(j).toString().split(",");
        if (vCadena[0].equals("Date")) {
          java.util.Date date1 = df.parse(vCadena[1]);
          cs.setDate(j + 1, new java.sql.Date(date1.getTime()));
        } else if (vCadena[0].equals("String")) {
          if (vCadena[1].equals("Null"))
            cs.setNull(j + 1, 12);
          else {
            cs.setString(j + 1, vCadena[1]);
          }
        }
        else if (vCadena[0].equals("Int")) {
          cs.setLong(j + 1, Integer.parseInt(vCadena[1]));
        }
        else {
          cs.setString(j + 1, pCondicion.elementAt(j).toString());
        }
      }

      cs.execute();
      rowCount = cs.getInt(12);
      setMens_pl(cs.getString(11));
      cs.close();
      con.commit();
      con.close();
    } catch (Exception e) {
      con.rollback();
      e.printStackTrace();
      log.error("::Exception, activaGCP_pl " + e.getMessage());
      rowCount = -1;
    } finally {
      if (cs == null){
    	  try
    	    {
    	      if (!con.isClosed())
    	        con.close();
    	    }
    	    catch (Exception e) {
    	      log.error("::con, activaGCP_pl " + e.getMessage());
    	    }
      }
    }
    try { cs.close();
    } catch (Exception e) {
      log.error("::ps, activaGCP_pl " + e.getMessage());
    }
    
    return rowCount;
  }

  public int anulaGCP_pl(DataSource dataSource, String pSql, Vector pCondicion)
  {
    int rowCount = 0;
    SimpleDateFormat df = new SimpleDateFormat(this.messages
      .getMessage("constante.FORMATO_FECHA_GCP"));

    Connection con = null;
    CallableStatement cs = null;
    try {
      con = dataSource.getConnection();
      cs = con.prepareCall(pSql);

      cs.registerOutParameter(2, 12);
      cs.registerOutParameter(3, 4);

      for (int j = 0; j < pCondicion.size(); j++) {
        String[] vCadena = pCondicion.elementAt(j).toString().split(",");
        if (vCadena[0].equals("Date")) {
          java.util.Date date1 = df.parse(vCadena[1]);
          cs.setDate(j + 1, new java.sql.Date(date1.getTime()));
        } else if (vCadena[0].equals("String")) {
          if (vCadena[1].equals("Null"))
            cs.setNull(j + 1, 12);
          else {
            cs.setString(j + 1, vCadena[1]);
          }
        }
        else if (vCadena[0].equals("Int")) {
          cs.setLong(j + 1, Integer.parseInt(vCadena[1]));
        }
        else {
          cs.setString(j + 1, pCondicion.elementAt(j).toString());
        }
      }

      cs.execute();
      rowCount = cs.getInt(3);
      setMens_pl(cs.getString(2));
      cs.close();
      con.commit();
      con.close();
    } catch (Exception e) {
      e.printStackTrace();
      log.error("::Exception, " + e.getMessage());
      rowCount = -1;
    } finally {
      if (cs == null){
    	  try
    	    {
    	      if (!con.isClosed())
    	        con.close();
    	    }
    	    catch (Exception e) {
    	      log.error("::con, " + e.getMessage());
    	    }
      }
    }
    try { cs.close();
    } catch (Exception e) {
      log.error("::ps, " + e.getMessage());
    }
    
    return rowCount;
  }

  public int insertaPLAperturaCierre(DataSource dataSource, String pSql, Vector pCondicion)
  {
    int rowCount = 0;
    SimpleDateFormat df = new SimpleDateFormat(this.messages
      .getMessage("constante.FORMATO_FECHA_GCP"));

    SimpleDateFormat df2 = new SimpleDateFormat(this.messages
      .getMessage("constante.FORMATO_FECHA_2"));

    Connection con = null;
    CallableStatement cs = null;
    try {
      con = dataSource.getConnection();
      cs = con.prepareCall(pSql);

      for (int j = 0; j < pCondicion.size(); j++) {
        String[] vCadena = pCondicion.elementAt(j).toString().split(",");
        if (vCadena[0].equals("Datehm")) {
          java.util.Date date1 = df.parse(vCadena[1]);
          cs.setTimestamp(j + 1, new Timestamp(date1.getTime()));
        } else if (vCadena[0].equals("Date")) {
          java.util.Date date1 = df2.parse(vCadena[1]);
          cs.setDate(j + 1, new java.sql.Date(date1.getTime()));
        } else if (vCadena[0].equals("String")) {
          if (vCadena[1].equals("Null"))
            cs.setNull(j + 1, 12);
          else {
            cs.setString(j + 1, vCadena[1]);
          }
        }
        else if (vCadena[0].equals("Int")) {
          cs.setLong(j + 1, Integer.parseInt(vCadena[1]));
        }
        else {
          cs.setString(j + 1, pCondicion.elementAt(j).toString());
        }
      }

      cs.execute();
      con.commit();
    }
    catch (Exception e) {
      e.printStackTrace();
      log.error("::Exception, " + e.getMessage());
      rowCount = -1;
    } finally {
      if (cs == null){
    	  try
    	    {
    	      if (!con.isClosed())
    	        con.close();
    	    }
    	    catch (Exception e) {
    	      log.error("::con, " + e.getMessage());
    	    }
      }
    }
    try { cs.close();
    } catch (Exception e) {
      log.error("::ps, " + e.getMessage());
    }
    
    return rowCount;
  }

  public int inserta(DataSource dataSource, String pSql, Vector pCondicion)
  {
    int vRetorno = 0;
    try {
      vRetorno = actualiza_sql(dataSource, pSql, pCondicion);
    } catch (Exception ex) {
      log.error("::Exception, " + ex.getMessage());
    }
    return vRetorno;
  }

  public Collection consulta(DataSource dataSource, String vSql, Vector vCondicion)
  {
    Vector camposFinal = new Vector();
    Collection beanCollection = null;
    SimpleDateFormat df = 
      new SimpleDateFormat(
      this.messages.getMessage("constante.FORMATO_FECHA"));

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    try {
      con = dataSource.getConnection();
      ps = con.prepareStatement(vSql);
      for (int j = 0; j < vCondicion.size(); j++) {
        String[] vCadena = vCondicion.elementAt(j).toString().split(",");
        if (vCadena[0].equals("Date")) {
          java.util.Date date1 = df.parse(vCadena[1]);
          ps.setDate(j + 1, new java.sql.Date(date1.getTime()));
        } else if (vCadena[0].equals("String")) {
          if (vCadena[1].equals("Null"))
            ps.setNull(j + 1, 12);
          else {
            ps.setString(j + 1, vCadena[1]);
          }
        }
        else if (vCadena[0].equals("Int")) {
          ps.setInt(j + 1, Integer.parseInt(vCadena[1]));
        }
        else {
          ps.setString(j + 1, vCondicion.elementAt(j).toString());
        }
      }

      rs = ps.executeQuery();
      while (rs.next()) {
        camposFinal.add(
          new LabelValueBean(
          rs.getString(2), 
          rs.getString(1)));
      }
      rs.close();
      ps.close();
      con.close();
    } catch (Exception e) {
      log.error("::Exception, " + e.getMessage());
    } finally {
      if (rs == null){
    	  if (ps != null) try {
    	        ps.close();
    	      } catch (Exception e) {
    	        log.error("::ps, " + e.getMessage());
    	      }
      }
    }try { rs.close();
    } catch (Exception e) {
      log.error("::rs, " + e.getMessage());
    }
    
    try
    {
      if (!con.isClosed())
        con.close();
    }
    catch (Exception e) {
      log.error("::con, " + e.getMessage());
    }
    beanCollection = camposFinal;
    return beanCollection;
  }

  public int update_sql(DataSource dataSource, Vector update)
  {
    int rowCount = 0;

    String update_sql = "";
    Statement st = null;
    try
    {
      this.conexion = dataSource.getConnection();
      st = this.conexion.createStatement();
      for (int j = 0; j < update.size(); j++) {
        update_sql = update_sql + (update.get(j) == null ? "" : update.get(j).toString().trim());

        if (!update_sql.equals("")) {
          st.executeUpdate(update_sql);
        }

        if ((j > 0) && (j % 50 == 0)) {
          this.conexion.commit();
        }

        update_sql = "";
      }

      this.conexion.commit();
    }
    catch (Exception e) {
      log.error("::Exception, " + e.getMessage());
      setMens_error(":: Error Actualizando registros " + e.toString());
      rowCount = -1;
    }
    finally {
      if (st != null) {
        try {
          st.close();
        }
        catch (SQLException e) {
          log.error(e);
        }
      }
      cierraRst();
    }

    return rowCount;
  }

  
  
  public int procedure(DataSource dataSource, String pSql, Vector pCondicion) throws SQLException
  {
    int rowCount = 0;
    //SimpleDateFormat df = new SimpleDateFormat(this.messages.getMessage("constante.FORMATO_FECHA"));

    Connection con = null;
    CallableStatement cs = null;
    try {
      con = dataSource.getConnection();
      Statement st = con.createStatement();
      cs = con.prepareCall(pSql);

      cs.registerOutParameter(4, Types.VARCHAR);
      cs.registerOutParameter(5, Types.VARCHAR);
      cs.registerOutParameter(6, Types.INTEGER);
      cs.registerOutParameter(7, Types.CHAR);
      cs.setLong(8, 1);
            
      for (int j = 0; j < pCondicion.size(); j++) {
        String[] vCadena = pCondicion.elementAt(j).toString().split(",");               
        
        if (vCadena[0].equals("String")) {
          if (vCadena[1].equals("Null"))
            cs.setNull(j + 1, 12);
          else {
            cs.setString(j + 1, vCadena[1]);
          }
        }
        else if (vCadena[0].equals("Int")) {
          cs.setLong(j + 1, Integer.parseInt(vCadena[1]));
        }
        else {
          cs.setString(j + 1, pCondicion.elementAt(j).toString());
        }
        
      } 
      
      cs.execute();               
      
      rowCount = Integer.parseInt(cs.getString(5).trim());
    
      cs.close();
      con.commit();
      con.close();
    } catch (Exception e) {
      con.rollback();
      e.printStackTrace();
      log.error("::Exception, availinvstore " + e.getMessage());
      rowCount = -1;
    } finally {
      if (cs == null){
    	  try
    	    {
    	      if (!con.isClosed())
    	        con.close();
    	    }
    	    catch (Exception e) {
    	      log.error("::con, availinvstore " + e.getMessage());
    	    }
      }
    }
    try { cs.close();
    } catch (Exception e) {
      log.error("::ps, availinvstore " + e.getMessage());
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

  public String getMens_pl() {
    return this.mens_pl;
  }

  public void setMens_pl(String mens_pl) {
    this.mens_pl = mens_pl;
  }
}