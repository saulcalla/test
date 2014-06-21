 package cl.ripley.GestionTV.struts.bean;
 
 import java.io.PrintStream;
 import java.util.Date;
 import java.util.Properties;
 import javax.mail.Message;
 import javax.mail.Message.RecipientType;
 import javax.mail.MessagingException;
 import javax.mail.Session;
 import javax.mail.Transport;
 import javax.mail.internet.AddressException;
 import javax.mail.internet.InternetAddress;
 import javax.mail.internet.MimeBodyPart;
 import javax.mail.internet.MimeMessage;
 import javax.mail.internet.MimeMultipart;
 import org.apache.log4j.Logger;
 
 public class EnviaMail
 {
   private String email;
   static Logger log = Logger.getRootLogger();
 
   public void Email(String subject)
   {
     String host = "145.2.0.10";
     String from = "aegonzaleza@ripley.cl";
     String to = "aegonzaleza@ripley.cl";
     String strMsg = "";
     System.out.println("ingreso a funcion que envia Email en GestionBT");
     try
     {
       Properties props = new Properties();
 
       props.put("mail.smtp.host", host);
 
       Session session = Session.getInstance(props);
       System.out.println("Correo enviado desde: " + from);
 
       MimeMessage message = new MimeMessage(session);
       message.setFrom(new InternetAddress(from));
       message.addRecipient(Message.RecipientType.TO, 
         new InternetAddress(to));
       message.setSubject(subject);
       strMsg = "<html>Error en Base de Datos en aplicación: GestionTV \n</html>\n";
       message.setContent(strMsg, "text/html");
 
       Transport.send(message);
       System.out.println("Se envió el correo a: " + to);
     } catch (AddressException e2) {
       System.out.println("NO se envió el correo\\n \\nRevise las Direcciones de correo\\n");
     } catch (MessagingException e) {
       String outMsg = "Error en Base de Datos. \\nPero NO se pudo enviar el correo...\\n\\n";
       boolean errorDetectado = false;
       if (e.getMessage().indexOf("553") > 0) {
         outMsg = outMsg + "Error en el e-mail del Contacto\\n";
         errorDetectado = true;
       }
       if (e.getMessage().indexOf("501") > 0) {
         outMsg = outMsg + "Error en el e-mail del Contacto\\n";
         errorDetectado = true;
       }
       if (e.getMessage().indexOf("550") > 0) {
         outMsg = outMsg + "Error en el e-mail de destino" + e.getMessage();
         errorDetectado = true;
       }
       if (e.getMessage().indexOf("Could not connect to SMTP host") > 0) {
         outMsg = outMsg + "No se puede establecer la conexión al servidor de correos\\n";
         errorDetectado = true;
       }
       if (!errorDetectado)
         outMsg = outMsg + "Error Desconocido\\n" + e.getMessage().replace('\n', ' ');
       outMsg = outMsg + "Por favor dé aviso...\\n";
       System.out.println(outMsg);
     }
   }
 
   public String enviaEmailGCP(String from, String to_mail_cliente, String host, String port, String protocolo, String subject, String mensaje, String usermail, String passmail)
     throws MessagingException
   {
     String resp = "";
     try
     {
       log.info("metodo enviaEmailGCP()");
 
       Properties props = new Properties();
       props.put("mail.transport.protocol", protocolo);
 
       props.put("mail.smtp.host", host);
       props.put("mail.smtp.port", port);
 
       Session mailSession = Session.getInstance(props);
 
       Message msg_client = new MimeMessage(mailSession);
 
       msg_client.setFrom(new InternetAddress(from));
 
       msg_client.setRecipients(Message.RecipientType.TO, 
         InternetAddress.parse(to_mail_cliente));
 
       msg_client.setSentDate(new Date());
 
       msg_client.setSubject(subject);
       msg_client.saveChanges();
 
       MimeMultipart mimeMultipart = new MimeMultipart();
 
       MimeBodyPart text = new MimeBodyPart();
       text.setDisposition("inline");
       text.setContent(mensaje, "text/html");
 
       mimeMultipart.addBodyPart(text);
 
       msg_client.setContent(mimeMultipart);
 
       Transport.send(msg_client);
       log.info("fin metodo enviaEmailGCP()");
     }
     catch (MessagingException e) {
       log.error("ERROR: mail a cliente - enviaEmailGCP()");
       log.error(e.toString());
       return null;
     }
 
     return resp;
   }
 
   public String envia(String from, String to_mail_cliente, String host, String port, String protocolo, String subject, String mensaje, String usermail, String passmail)
   {
     String resp = "";
     try
     {
       log.info("metodo enviaEmailGCP()");
 
       Properties props = new Properties();
       props.put("mail.transport.protocol", protocolo);
 
       props.put("mail.smtp.host", host);
       props.put("mail.smtp.port", port);
 
       Session mailSession = Session.getInstance(props);
 
       Message msg_client = new MimeMessage(mailSession);
 
       msg_client.setFrom(new InternetAddress(from));
 
       msg_client.setRecipients(Message.RecipientType.TO, 
         InternetAddress.parse(to_mail_cliente));
 
       msg_client.setSentDate(new Date());
 
       msg_client.setSubject(subject);
       msg_client.saveChanges();
 
       MimeMultipart mimeMultipart = new MimeMultipart();
 
       MimeBodyPart text = new MimeBodyPart();
       text.setDisposition("inline");
       text.setContent(mensaje, "text/html");
 
       mimeMultipart.addBodyPart(text);
 
       msg_client.setContent(mimeMultipart);
 
       Transport.send(msg_client);
       log.info("fin metodo enviaEmailGCP()");
     }
     catch (MessagingException e)
     {
       e.printStackTrace();
       return null;
     }
 
     return resp;
   }
 
   public static void main(String[] args) {
     EnviaMail e = new EnviaMail();
 
     e.envia("aegonzaleza@ripley.cl", "aegonzaleza@ripley.cl", "10.0.1.44", 
       "25", "smtp", "Comprobante Activacion GiftCard", "prueba salida", "aegonzaleza", "agonzalva");
   }
 
   public String getEmail()
   {
     return this.email;
   }
 
   public void setEmail(String string)
   {
     this.email = string;
   }
 }

/* Location:           C:\sitios\GestionTV_Ripley\trunk\docs\01 Requerimiento\Fuentes Gestión TV\GestionTV-WC7\WEB-INF\classes\
 * Qualified Name:     cl.ripley.GestionTV.struts.bean.EnviaMail
 * JD-Core Version:    0.6.2
 */