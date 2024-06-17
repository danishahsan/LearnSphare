package com.LearnSphere.Services;

public interface MailSenderService {
	public void sendMail(String sender, String recipient, String message);
	public void prepareAndSend(String recipient, String message);
}
