package com.LearnSphere.Controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.thymeleaf.TemplateEngine;

import java.util.concurrent.TimeUnit;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;


@Controller
public class EmailSenderController {

	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private TemplateEngine templateEngine;
	
	public EmailSenderController(TemplateEngine templateEngine)
	{
		this.templateEngine = templateEngine;
	}


	public static final Integer EXPIRE_MINS = 5;

	public static int otp;
	public void sendEmail(String toEmail)

	{
		otp=generateOTP();
		
		String body="Your OTP is:otp ",subject="OTP Verification";
		
		SimpleMailMessage message=new SimpleMailMessage();
		message.setFrom("ksharpit@gmail.com");
		message.setTo(toEmail);
		message.setText(body);
		message.setSubject(subject);

		mailSender.send(message);

		System.out.println("message sent sucessfully");
	}


	public int generateOTP(){
		Random random = new Random();
		int otp = 100000 + random.nextInt(900000);
		return otp;
	}
}
