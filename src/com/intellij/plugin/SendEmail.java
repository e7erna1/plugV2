package com.intellij.plugin;


import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class SendEmail {
  static void sendSomeEmail(String from, String pass, String[] to, String subject, String body) {
    Properties props = System.getProperties();
    String host = "smtp.gmail.com";
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.host", host);
    props.put("mail.smtp.user", from);
    props.put("mail.smtp.password", pass);
    props.put("mail.smtp.port", "587");
    props.put("mail.smtp.auth", "true");

    Session session = Session.getDefaultInstance(props);
    MimeMessage message = new MimeMessage(session);
    try {
      message.setFrom(new InternetAddress(from));
      InternetAddress[] toAddress = new InternetAddress[to.length];

      for (int i = 0; i < to.length; i++) {
        toAddress[i] = new InternetAddress(to[i]);
      }

      for (InternetAddress toAddres : toAddress) {
        message.addRecipient(Message.RecipientType.TO, toAddres);
      }

      message.setSubject(subject);
      message.setText(body);
      Transport transport = session.getTransport("smtp");
      transport.connect(host, from, pass);
      transport.sendMessage(message, message.getAllRecipients());
      transport.close();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}
