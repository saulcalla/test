 package cl.ripley.GestionTV.struts.bean;
 
 import cl.ripley.GestionTV.comun.ConectaBD;
 import cl.ripley.GestionTV.comun.Util;
 import java.io.PrintStream;
 import java.util.Iterator;
 import java.util.Map;
 import java.util.Vector;
 import javax.sql.DataSource;
 import org.apache.log4j.Logger;
 import org.apache.poi.hssf.usermodel.HSSFCell;
 import org.apache.poi.hssf.usermodel.HSSFRow;
 import org.apache.poi.hssf.usermodel.HSSFSheet;
 import org.apache.poi.hssf.usermodel.HSSFWorkbook;
 import org.apache.poi.poifs.filesystem.POIFSFileSystem;
 import org.apache.struts.upload.FormFile;
 import org.apache.struts.util.MessageResources;
 
 public class BorradoPromocionesBean extends ConectaBD
 {
   static Logger log = Logger.getRootLogger();
   protected static MessageResources messages = MessageResources.getMessageResources("cl.ripley.GestionTV.struts.msgGestionTV");
   private String accion;
   private Vector vctDetalles;
   private int contador = 0;
   private String flagDatosBD = "si";
   private String hayDatos = "no";
   private String hayDatosExportar = "no";
   private String hayProximoBloque = "si";
   private int indice = 0;
   private Vector listaPagina = new Vector();
   private String mensaje = "";
   private int nroBloque = -1;
   private int registrosPorBloque = 10;
   private int totalPaginas = 0;
   private int totalRegistros = 0;
   private int totalReg = 0;
   private Vector vctExportar = new Vector();
   private Vector vctExpHead = new Vector();
   private Vector vctRegistros;
   Vector vectDelete = new Vector();
 
   public int SqlBorradoDePromociones(DataSource dataSource, String tipo, Vector vectorSql)
   {
     int intRes = 0;
     String statement = "";
     Vector v_delete = new Vector();
     String sql_delete = "";
     String padre = "";
     String hijo = "";
     try
     {
       if (conecta(dataSource))
       {
         if (tipo.equals("1"))
           statement = (String)Util.getMap().get("gestion_66.inst01");
         if (tipo.equals("2"))
           statement = (String)Util.getMap().get("gestion_66.inst02");
         if (tipo.equals("3")) {
           statement = (String)Util.getMap().get("gestion_66.inst03");
         }
         String cadena = null;
 
         if ((tipo.equals("1")) || (tipo.equals("2")))
         {
           for (int i = 0; i < vectorSql.size(); i++)
           {
             cadena = vectorSql.get(i).toString().toUpperCase();
             if ((cadena.equals("PADRE")) || (cadena.equals("HIJO"))) {
               cadena = "";
             } else {
               sql_delete = statement.replaceAll("X", cadena);
               v_delete.add(sql_delete);
               cadena = "";
               sql_delete = "";
             }
           }
         }
         else
         {
           for (int i = 0; i < vectorSql.size(); i++)
           {
             cadena = vectorSql.get(i).toString().toUpperCase();
 
             if (cadena.equals("PADRE|HIJO"))
             {
               cadena = "";
             }
             else
             {
               int ind = cadena.indexOf("|");
 
               if (ind > 0) {
                 hijo = cadena.substring(ind + 1, cadena.length());
                 padre = cadena.substring(0, ind);
 
                 sql_delete = statement.replaceAll("PADRE", padre);
 
                 sql_delete = sql_delete.replaceAll("HIJO", hijo);
 
                 v_delete.add(sql_delete);
               }
               cadena = "";
               sql_delete = "";
             }
 
           }
 
         }
 
         setVectDelete(v_delete);
 
         for (int x = 0; x < getVectDelete().size(); x++) {
           System.out.println(getVectDelete().get(x).toString());
         }
 
       }
 
     }
     catch (Exception e)
     {
       log.error("ERROR: Al generar SQL borrado Promociones " + e);
     } finally {
       cierraRst();
     }
     return intRes;
   }
 
   public Vector lecturaExcel(FormFile myFile, String tipo)
   {
     Vector data = new Vector();
     boolean concatenar = false;
     String campo = "";
     try {
       POIFSFileSystem fs = new POIFSFileSystem(myFile
         .getInputStream());
       HSSFWorkbook wb = new HSSFWorkbook(fs);
 
       HSSFSheet sheet = wb.getSheetAt(0);
 
       Iterator rows = sheet.rowIterator();
       Iterator cells;
       for (; rows.hasNext(); 
         cells.hasNext())
       {
         HSSFRow row = (HSSFRow)rows.next();
 
         cells = row.cellIterator();

         HSSFCell cell = (HSSFCell)cells.next();
         switch (cell.getCellType()) {
         case 0:
           setMens_error("ERROR: Tipo de dato debe ser 'TEXTO'");
           return null;
         case 1:
           if ((tipo.equals("1")) || (tipo.equals("2"))) {
             data.add(cell.getStringCellValue());
           }
           if (tipo.equals("3"))
           {
             if (concatenar) {
               campo = campo + "|" + cell.getStringCellValue();
               data.add(campo);
               concatenar = false;
             } else {
               campo = cell.getStringCellValue();
               concatenar = true;
             }
 
           }
 
           break;
         }
 
       }
 
     }
     catch (Exception e)
     {
       log.error("ERROR: al leer excel " + e);
       return null;
     }
 
     return data;
   }
 
   public int borrarPromocion(DataSource dataSource)
   {
     int intRes = 0;
     if (conecta(dataSource)) {
       try {
         if (getVectDelete().size() > 0)
           intRes = update_sql(dataSource, getVectDelete());
         else
           setMens_error("Problemas al borrar promocion.\nCargue nuevamente el archivo.");
       }
       catch (Exception e) {
         log.error("::Exception, EN borradoPromocion " + e.toString());
         setMens_error("Error al borrar promocion.");
         intRes = -1;
       }
       finally {
         cierraRst();
       }
     }
 
     return intRes;
   }
 
   public int getIndice()
   {
     return this.indice;
   }
 
   public int getNroBloque()
   {
     return this.nroBloque;
   }
 
   public int getRegistrosPorBloque()
   {
     if (this.registrosPorBloque == 0) {
       this.registrosPorBloque = 10;
     }
     return this.registrosPorBloque;
   }
 
   public void setIndice(int i)
   {
     this.indice = i;
   }
 
   public void setNroBloque(int i)
   {
     this.nroBloque = i;
   }
 
   public void setRegistrosPorBloque(int i)
   {
     this.registrosPorBloque = i;
   }
 
   public String getHayDatos()
   {
     return this.hayDatos;
   }
 
   public void setHayDatos(String string)
   {
     this.hayDatos = string;
   }
 
   public String getHayProximoBloque()
   {
     return this.hayProximoBloque;
   }
 
   public void setHayProximoBloque(String string)
   {
     this.hayProximoBloque = string;
   }
 
   public void setTotalPaginas(int i)
   {
     this.totalPaginas = i;
   }
 
   public static MessageResources getMessages()
   {
     return messages;
   }
 
   public String getMensaje()
   {
     return this.mensaje;
   }
 
   public void setMensaje(String string)
   {
     this.mensaje = string;
   }
 
   public int getContador()
   {
     return this.contador;
   }
 
   public void setContador(int i)
   {
     this.contador = i;
   }
 
   public int getTotalReg()
   {
     return this.totalReg;
   }
 
   public void setTotalReg(int i)
   {
     this.totalReg = i;
   }
 
   public int getTotalRegistros()
   {
     return this.totalRegistros;
   }
 
   public void setTotalRegistros(int i)
   {
     this.totalRegistros = i;
   }
 
   public Vector getVctExpHead()
   {
     return this.vctExpHead;
   }
 
   public Vector getVctExportar()
   {
     return this.vctExportar;
   }
 
   public void setVctExpHead(Vector vector)
   {
     this.vctExpHead = vector;
   }
 
   public void setVctExportar(Vector vector)
   {
     this.vctExportar = vector;
   }
 
   public String getHayDatosExportar()
   {
     return this.hayDatosExportar;
   }
 
   public void setHayDatosExportar(String string)
   {
     this.hayDatosExportar = string;
   }
 
   public Vector getVctRegistros() {
     return this.vctRegistros;
   }
 
   public void setVctRegistros(Vector vctRegistros)
   {
     this.vctRegistros = vctRegistros;
   }
 
   public Vector getVectDelete()
   {
     return this.vectDelete;
   }
 
   public void setVectDelete(Vector vectDelete)
   {
     this.vectDelete = vectDelete;
   }
 }

/* Location:           C:\sitios\GestionTV_Ripley\trunk\docs\01 Requerimiento\Fuentes Gestión TV\GestionTV-WC7\WEB-INF\classes\
 * Qualified Name:     cl.ripley.GestionTV.struts.bean.BorradoPromocionesBean
 * JD-Core Version:    0.6.2
 */