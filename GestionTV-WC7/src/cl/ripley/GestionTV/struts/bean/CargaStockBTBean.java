 package cl.ripley.GestionTV.struts.bean;
 
 import cl.ripley.GestionTV.comun.ConectaBDJDBC;
 import cl.ripley.GestionTV.comun.Util;
 import java.sql.ResultSet;
 import java.util.Map;
 import java.util.Vector;
 import javax.sql.DataSource;
 import org.apache.log4j.Logger;
 import org.apache.struts.util.MessageResources;
 
 public class CargaStockBTBean extends ConectaBDJDBC
 {
   static Logger log = Logger.getRootLogger();
   protected static MessageResources messages = MessageResources.getMessageResources("cl.ripley.GestionTV.struts.msgGestionTV");
   private String accion;
   private String hayDatos = "no";
   int tot_datos = 0;
   private Vector vect_insert = new Vector();
 
   public void cargaStockBT()
   {
     String instruccion_sql = "";
     Vector vWhere = new Vector();
     try
     {
       instruccion_sql = "gestion_34.inst02";
       consultaRst(instruccion_sql, vWhere);
       log.info("Recorriend SELECT BIG_TICKET");
 
       int sqlcode = 0;
       String sql_insert = "";
       while (getRst().next()) {
         sql_insert = sql_insert + "('" + getRst().getString("NRO_LOC_BOD") + "' ,";
         sql_insert = sql_insert + getRst().getInt("INVENTARIO") + ",";
         sql_insert = sql_insert + getRst().getInt("DISPONIBLE") + ",";
         sql_insert = sql_insert + "'" + getRst().getLong("CODIGO_VTA") + "' ,";
         sql_insert = sql_insert + "'" + getRst().getString("COD_DEPTO") + "' )";
         this.tot_datos += 1;
         this.vect_insert.add(sql_insert);
         sql_insert = "";
       }
 
       log.info(" FIN Recorriendo SELECT BIG_TICKET");
     }
     catch (Exception e) {
       log.error("::Exception, EN CONSULTA STOCK_BT " + e);
       setMens_error(":: Error obteniendo datos desde BT " + e.getLocalizedMessage());
       e.printStackTrace();
     } finally {
       cierraRst();
     }
   }
 
   public void cargaStockTV(DataSource dataSource)
   {
     String vInstruccion = "";
     Vector vWhere = new Vector();
     String sql_truncate = "";
     log.info("Cargando Stock desde BIG_TICKET hacia TV");
 
     sql_truncate = (String)Util.getMap().get("gestion_34.inst01");
     int sqlcode_truncate = elimina(dataSource, sql_truncate, vWhere);
 
     if (sqlcode_truncate < 0) {
       log.error("::Exception, ERROR ELIMINANDO TABLA STCK_BT  ");
       setMens_error("::Exception, ERROR ELIMINANDO TABLA STCK_BT");
     }
 
     try
     {
       log.info("TOTAL DE REGISTROS DE BT : " + getVect_insert().size());
 
       int sql_code_insert = insert_sql(dataSource, getVect_insert());
 
       if ((sqlcode_truncate > 0) && (sql_code_insert > 0))
         setHayDatos("si");
       else
         setHayDatos("no");
     }
     catch (Exception e)
     {
       log.error("::Exception, EN CONSULTA STOCK_BT " + e);
       setMens_error(e.getLocalizedMessage());
     } finally {
       cierraRst();
     }
   }
 
   public String getHayDatos()
   {
     return this.hayDatos;
   }
 
   public void setHayDatos(String string)
   {
     this.hayDatos = string;
   }
 
   public static MessageResources getMessages()
   {
     return messages;
   }
 
   public int getTot_datos()
   {
     return this.tot_datos;
   }
 
   public void setTot_datos(int tot_datos) {
     this.tot_datos = tot_datos;
   }
 
   public Vector getVect_insert()
   {
     return this.vect_insert;
   }
 
   public void setVect_insert(Vector vect_insert)
   {
     this.vect_insert = vect_insert;
   }
 }

/* Location:           C:\sitios\GestionTV_Ripley\trunk\docs\01 Requerimiento\Fuentes Gestión TV\GestionTV-WC7\WEB-INF\classes\
 * Qualified Name:     cl.ripley.GestionTV.struts.bean.CargaStockBTBean
 * JD-Core Version:    0.6.2
 */