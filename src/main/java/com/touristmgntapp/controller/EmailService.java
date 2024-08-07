package com.touristmgntapp.controller;

import javax.mail.*;
import javax.mail.internet.*;
import javax.servlet.annotation.WebServlet;

import java.util.Properties;

public class EmailService {

    public void sendEmailWithHtml(String recipientEmail, String subject, String htmlContent) throws MessagingException {
        // Setup mail server properties

        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587"); // or your SMTP port
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        // Create a Session object
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("gsajithkumar2000@gmail.com", "ysrv jtcx flol wouc");
            }
        });

        // Create a new message
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("gsajithkumar2000@gmail.com"));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
        message.setSubject(subject);

        // Set content as HTML
        message.setContent(htmlContent, "text/html");

        // Send message
        Transport.send(message);
        System.out.println("Email sent successfully to " + recipientEmail);
    }
    
        
    public void sentEmail(String recipientEmail, String htmlContent) throws MessagingException {
        EmailService emailService = new EmailService();
       
        emailService.sendEmailWithHtml(recipientEmail, "Dream Trip", htmlContent);
    }
}
