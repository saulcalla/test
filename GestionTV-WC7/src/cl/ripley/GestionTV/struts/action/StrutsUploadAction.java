 package cl.ripley.GestionTV.struts.action;
 
 import cl.ripley.GestionTV.struts.form.StrutsUploadForm;
 import java.io.ByteArrayOutputStream;
 import java.io.InputStream;
 import java.io.PrintStream;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import org.apache.struts.action.Action;
 import org.apache.struts.action.ActionForm;
 import org.apache.struts.action.ActionForward;
 import org.apache.struts.action.ActionMapping;
 import org.apache.struts.upload.FormFile;
 
 public class StrutsUploadAction extends Action
 {
   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
     throws Exception
   {
     StrutsUploadForm myForm = (StrutsUploadForm)form;
 
     FormFile myFile = myForm.getTheFile();
     String contentType = myFile.getContentType();
     String fileName = myFile.getFileName();
     int fileSize = myFile.getFileSize();
     byte[] fileData = myFile.getFileData();
     try
     {
       ByteArrayOutputStream baos = new ByteArrayOutputStream();
       InputStream stream = myFile.getInputStream();
 
       String data = "";
 
       byte[] buffer = new byte[fileSize];
       int bytesLeidos = 0;
       while ((bytesLeidos = stream.read(buffer, 0, fileSize)) != -1) {
         baos.write(buffer, 0, bytesLeidos);
       }
       data = new String(baos.toByteArray());
 
       System.out.println("contentType: " + contentType);
       System.out.println("File Name: " + fileName);
       System.out.println("File Size: " + fileSize);
       System.out.println(data);
     }
     catch (Exception e) {
       e.printStackTrace();
     }
 
     return mapping.findForward("success");
   }
 }

/* Location:           C:\sitios\GestionTV_Ripley\trunk\docs\01 Requerimiento\Fuentes Gestión TV\GestionTV-WC7\WEB-INF\classes\
 * Qualified Name:     cl.ripley.GestionTV.struts.action.StrutsUploadAction
 * JD-Core Version:    0.6.2
 */