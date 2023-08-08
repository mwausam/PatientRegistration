package hosp.patientreg;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


import lombok.extern.slf4j.Slf4j;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;



@Slf4j
public class SendMail {


    public static void sendGmailEmail(String recipientName,Long referenceNo, String recipientEmail,String senderEmail,String senderPassword) {

        // HTML content for the email
        String htmlContent = """
            <html>
                <body>
                    <h1>Hello %s</h1>
                    <p>Your patient reference number is %d.</p>
                    <p>Thank you for trusting us.</p>
                </body>
            </html>
         """.formatted(recipientName, referenceNo);

        // SMTP server settings
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        // Create a session with the SMTP server
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {
            // Create a MIME message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject("Patient Reference Number");
            
            // Set the content type to HTML
            message.setContent(htmlContent, "text/html");

            // Send the message
            Transport.send(message);

            log.info("Email was sent successfully!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
