package cl.ripley.framework.util;

import java.io.FileInputStream;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.Vector;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class TestPOI
{
  public static void main(String[] args)
  {
    try
    {      
    	Vector cod_hijo = new Vector();
        POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream("C:/Libro2.xls"));
        HSSFWorkbook wb = new HSSFWorkbook(fs);
        HSSFSheet sheet = wb.getSheetAt(0);
        for(Iterator rows = sheet.rowIterator(); rows.hasNext();)
        {
            HSSFRow row = (HSSFRow)rows.next();
            for(Iterator cells = row.cellIterator(); cells.hasNext();)
            {
                HSSFCell cell = (HSSFCell)cells.next();
                switch(cell.getCellType())
                {
                case 0: // '\0'
                    System.out.println(cell.getNumericCellValue());
                    break;

                case 1: // '\001'
                    cod_hijo.add(cell.getStringCellValue());
                    break;

                default:
                    System.out.println("unsuported sell type");
                    break;
                }
            }

        }

        System.out.println("DATOS DE EXCEL");
        for(int i = 0; i < cod_hijo.size(); i++)
            System.out.println(cod_hijo.get(i));
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
}