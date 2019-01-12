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

    System.out.println(1);
    Session session = Session.getDefaultInstance(props);
    System.out.println(2);
    //Здесь не робит
    MimeMessage message = new MimeMessage(session);
    System.out.println(3);
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
      System.out.println(1);
      message.setText(body);
      System.out.println(2);
      Transport transport = session.getTransport("smtp");
      System.out.println(3);
      transport.connect(host, from, pass);
      System.out.println(4);
      transport.sendMessage(message, message.getAllRecipients());
      System.out.println(5);
      transport.close();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}
