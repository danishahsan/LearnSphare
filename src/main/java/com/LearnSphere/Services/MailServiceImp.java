package com.LearnSphere.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class MailServiceImp implements MailSenderService{

	@Autowired
	private JavaMailSender mailSender;
	
	@Override
	public void sendMail(String subject, String recipient, String body) {
		

		SimpleMailMessage message=new SimpleMailMessage();
		message.setFrom("ksharpit@gmail.com");
		message.setTo(recipient);
		message.setText(body);
		message.setSubject(subject);
		
		mailSender.send(message);
		
		System.out.println("message sent sucessfully");
	}

	@Override
	public void prepareAndSend(String recipient, String message) {
		// TODO Auto-generated method stub
		
	}
}
