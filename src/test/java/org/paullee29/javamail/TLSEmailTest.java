package com.kore.javamail;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TLSEmailTest {

    @Test
    public void testTLSEmail () {
        String fromEmail = "";
        String password = "";
        String toEmail = "";
        String host = "smtp.office365.com";
        String port = "587";
        String subject = "Test from Java Mail";
        String message = "Test from Java Mail";

        TLSEmail.sendEmail(fromEmail,password, toEmail, host, port, subject, message);


    }

}