package controles;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class Mail {
	
	
	public static void enviar(String destina, int cold) {
		Properties props = new Properties();
        /** Parâmetros de conexão com servidor Live**/
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", "smtp.live.com");
        props.put("mail.smtp.socketFactory.port", "587");
        props.put("mail.smtp.socketFactory.fallback", "false");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "587");
    	Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                     protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                           return new PasswordAuthentication("lembreteclinica@outlook.com", "qweasdzxc123");
                     }
                });
    session.setDebug(true);
    try {
          Message message = new MimeMessage(session);
          message.setFrom(new InternetAddress("lembreteclinica@outlook.com")); //Remetente

          Address[] toUser = InternetAddress.parse(destina);  

          message.setRecipients(Message.RecipientType.TO, toUser);
          String titulo = "Seu Cold foi gerado";
          message.setSubject(titulo);//Assunto
          String msg = "Seu Cold para recuperacao de senha foi gerado ele e: "+cold;
          message.setText(msg);
          Transport.send(message);
          JOptionPane.showMessageDialog(null, "Seu Cold foi enviado para o seu e-mail");				
     } catch (MessagingException e) {
         JOptionPane.showMessageDialog(null, "Falha no envio de e-mail.");
    }
	}

}
