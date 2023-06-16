package utilities;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

public class EmailUtils {

    public static void sendMail() {
        Properties props = new Properties();
        //load a properties file from class path, inside static method
        String projectPath = System.getProperty("user.dir");
        try {
            props.load(new FileInputStream(projectPath + "/src/test/resources/properties/EmailInfo.properties"));
        }
        catch (IOException e1) {
            e1.printStackTrace();
        }
        //get the property value and print it out
        final String fromEmail = props.getProperty("fromEmail");
        final String passwd = props.getProperty("password");
        String toEmail = props.getProperty("toEmail");
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtp.socketFactory.port", "465"); //SSL Port
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
        props.put("mail.smtp.auth", "true"); //Enabling SMTP Authentication
        props.put("mail.smtp.port", "465"); //SMTP Port
        props.put("mail.smtp.starttls.enable", "true");

        Authenticator auth = new Authenticator() {
            //override the getPasswordAuthentication method
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, passwd);
            }
        };

        Session session = Session.getDefaultInstance(props, auth);
        session.setDebug(true);
        try {
            MimeMessage msg = new MimeMessage(session);
            //set message headers
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");
            msg.setFrom(new InternetAddress(fromEmail, "LYNX FLEET-AUTOMATION"));
            msg.setReplyTo(InternetAddress.parse(toEmail, false));
            msg.setSubject("Execution Results", "UTF-8");
            msg.setSentDate(new Date());
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
            System.out.println("Message is ready");
            //Transport.send(msg);
            // Second part is attachment
            // Create the message body part
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText("Hello Team, \n \n Please find the execution results.");
            // Create a multipart message for attachment
            Multipart multipart = new MimeMultipart();
            // Set text message part
            multipart.addBodyPart(messageBodyPart);
            messageBodyPart = new MimeBodyPart();
            String filename = projectPath + props.getProperty("filename");
            DataSource source = new FileDataSource(filename);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName("report.html");
            multipart.addBodyPart(messageBodyPart);
            // Send the complete message parts
            msg.setContent(multipart);
            Transport.send(msg);
            System.out.println("Email sent successfully!!");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
