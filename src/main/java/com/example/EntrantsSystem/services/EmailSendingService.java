package com.example.EntrantsSystem.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSendingService {

    private static final Logger Log= LoggerFactory.getLogger(EmailSendingService.class);

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${appBaseDomain}")
    private String appBaseDomain;
    @Value("${verifyLink}")
    private String verifyLink;

    public void sendVerificationEmail(String userEmail, String hash) {
        Log.info("Sending verification email with hash={}",hash);
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setTo(userEmail);
        simpleMailMessage.setSubject("Please verify your email");

        String text = "Click link below to confirm email and finish registration.\n";
        String link = appBaseDomain + verifyLink + hash;

        simpleMailMessage.setText(text + link);

        try {
            javaMailSender.send(simpleMailMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
