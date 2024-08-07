package com.touristmgntapp.controller;

import java.util.Properties;
import java.util.UUID;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import com.google.gson.JsonObject;
import com.touristmgntapp.dao.Impl.UserTableDaoImplement;


@SuppressWarnings("serial")
@WebServlet("/EmailVerificationServlet")

public class EmailVerificationServlet  extends HttpServlet{
	
	
	public static void sendVerificationEmail(String toEmail) {		

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com"); // use your SMTP host
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); // TLS

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("gsajithkumar2000@gmail.com", "ysrv jtcx flol wouc");
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("gsajithkumar2000@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(toEmail)
            );
            message.setSubject("Email Verification");
            message.setText("Dear User,"
                    + "\n\n Successflly registered Dream Trip. \nYou can proceed now to book your Dream Trip Immidiately!");

            Transport.send(message);

            System.out.println("Verification email sent.");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		UserTableDaoImplement user = new UserTableDaoImplement();
		try {
		String toEmail = request.getParameter("email");
		String token = UUID.randomUUID().toString();
		boolean isEmailExist = user.emailvalid(toEmail);
		JsonObject jsonResponse = new JsonObject();
        jsonResponse.addProperty("exists", isEmailExist);

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print(jsonResponse.toString());
        out.flush();
    
	}catch(Exception e) {
		e.printStackTrace();
	}
	}
}
