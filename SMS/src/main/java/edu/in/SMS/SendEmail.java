package edu.in.SMS;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

 

public class SendEmail {
    public static void main(String[] args) {
        // Sender's email address
        final String fromEmail = "poornesh.ck@prodapt.com";
        final String password = "welcome@123"; // Your email password

 

        // Recipient's email address
        String toEmail = "saijeevan352002@gmail.com";

 

        // Set up properties for the email server
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com"); // Use your email provider's SMTP server
        props.put("mail.smtp.port", "587"); // Port for TLS

 

        // Create a Session object with your email credentials
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

 

        try {
            // Create a MimeMessage object
            Message message = new MimeMessage(session);

 

            // Set the sender and recipient addresses
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject("Subject of your email"); // Set the email subject

 

            // Create the email content
            String emailContent = "This is the email content.";
            message.setText(emailContent);

            session.setDebug(true);


            // Send the email
            Transport.send(message);

 

            System.out.println("Email sent successfully!");

 

        } catch (MessagingException e) {
            e.printStackTrace();
            System.err.println("Error sending email: " + e.getMessage());
        }
    }
}