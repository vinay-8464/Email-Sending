package com.email.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;

@SpringBootApplication
public class EmailApplication {
    @Autowired
    private EmailSenderService emailSenderService;


    public static void main(String[] args) {
        SpringApplication.run(EmailApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void triggerMail() throws MessagingException {
    	String[] emails= {"jaguvinay2002@gmail.com","rajavinay8464@gmail.com"};
    	for(String email: emails) {
	        emailSenderService.sendMailWithAttachment(email,
	                "This is email body.",
	                "This email subject", "" +
	                "/home/vinay/Downloads/email.txt");
    	}

    }

}
