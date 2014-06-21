 package cl.ripley.GestionTV.struts.bean;
 
 import java.io.PrintStream;
 import java.util.Date;
 import java.util.Properties;
 import javax.mail.Message;
 import javax.mail.Message.RecipientType;
 import javax.mail.MessagingException;
 import javax.mail.Session;
 import javax.mail.Transport;
 import javax.mail.internet.InternetAddress;
 import javax.mail.internet.MimeBodyPart;
 import javax.mail.internet.MimeMessage;
 import javax.mail.internet.MimeMultipart;
 
 public class TestMail
 {
   public String envia(String from, String to_mail_cliente, String host, String port, String protocolo, String subject, String mensaje, String usermail, String passmail)
   {
     String resp = "";
     try
     {
       System.out.println("metodo enviaEmailGCP()");
 
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
       System.out.println("fin metodo enviaEmailGCP()");
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
     e.envia("aegonzaleza@ripley.cl", "agonzalva@gmail.com", "10.0.1.23", 
       "25", "smtp", "Comprobante Activacion GiftCard", "prueba salida", "aegonzaleza", "agonzalva");
   }
 }

/* Location:           C:\sitios\GestionTV_Ripley\trunk\docs\01 Requerimiento\Fuentes Gestión TV\GestionTV-WC7\WEB-INF\classes\
 * Qualified Name:     cl.ripley.GestionTV.struts.bean.TestMail
 * JD-Core Version:    0.6.2
 */