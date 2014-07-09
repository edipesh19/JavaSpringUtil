package org.springdemo.helloworld.mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;


public class SmtpMailSender implements MailSender{

	private static final Logger logger = LoggerFactory.getLogger(SmtpMailSender.class);
	JavaMailSender javaMailSender;
	
	public void setJavaMailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	@Override
	public void Send(String to, String subject, String body) throws MessagingException {
		MimeMessage message = javaMailSender.createMimeMessage();
		
		MimeMessageHelper helper;
		
		helper = new MimeMessageHelper(message, true);
		
		helper.setSubject(subject);
		helper.setTo(to);
		helper.setText(body,true);
		
		logger.info("Sending SMTP Mail to " + to);
		logger.info("Subject " + subject);
		logger.info("Body " + body);
		javaMailSender.send(message);	
	}

}
