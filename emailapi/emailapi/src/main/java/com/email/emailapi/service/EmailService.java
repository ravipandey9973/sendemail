package com.email.emailapi.service;



import org.springframework.boot.rsocket.server.RSocketServer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service

public class EmailService {

public boolean sendEmail(String subject,String message,String to)
     {
         boolean f=false;
         String from ="ravipandey5146@gmail.com";
         // variable for gmail
        String host ="smtp.gmail.com";

        //get the system properties
        Properties properties = System.getProperties();
        System.out.println("PROPERTIES"+properties);

        //setting important information to properties object

         //host set

         properties.put("mail.smtp.host",host);
         properties.put("mail.smtp.host",465);
         properties.put("mail.smpt.ssl.enable","true");
         properties.put("mail.smtp.auth","true");

         // step 1: to get the session object..
         Session session =Session.getInstance(properties,new Authenticator(){
             @Override
             protected javax.mail.PasswordAuthentication getPasswordAuthentication(){
               return new PasswordAuthentication("ravipandey5146@gmail.com","******");
             }
         });
         session.setDebug(true);


         //Step 2: compare the message [text,multi media]

         MimeMessage m = new MimeMessage(session);

         try {
             //from email
             m.setFrom(from);
             //adding recipient to message
             m.addRecipient(Message.RecipientType.TO,new InternetAddress(to));

             //adding subject to message
             m.setSubject(subject);

             // adding text to message

             m.setText(message);

             //send

             //step 3:send the message using Transport class
             Transport.send(m);

             System.out.println("sent success..................");
             f=true;
         }catch (Exception e){
             e.printStackTrace();
         }

         return f;

     }
}
