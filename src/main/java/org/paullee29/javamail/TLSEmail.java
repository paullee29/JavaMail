package org.paullee29.javamail;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.paullee29.javamail.utilities.EmailUtil;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class TLSEmail {

    /**
     * Outgoing Mail (SMTP) Server
     * requires TLS or SSL: smtp.gmail.com (use authentication)
     * Use Authentication: Yes
     * Port for TLS/STARTTLS: 587
     */

    private static final Logger LOGGER = LogManager.getLogger(TLSEmail.class.getName());

    public static void sendEmail(String fromEmail, String password, String toEmail, String host, String port, String subject, String message) {


        LOGGER.info("TLSEmail Start");
        Properties props = new Properties();
        props.put("mail.smtp.host", host); //SMTP Host
        props.put("mail.smtp.port", port); //TLS Port
        props.put("mail.smtp.auth", "true"); //enable authentication
        props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

        //create Authenticator object to pass in Session.getInstance argument
        Authenticator auth = new Authenticator() {
            //override the getPasswordAuthentication method
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        };
        Session session = Session.getInstance(props, auth);

        EmailUtil.sendEmail(fromEmail, session, toEmail, subject, message);

    }
}