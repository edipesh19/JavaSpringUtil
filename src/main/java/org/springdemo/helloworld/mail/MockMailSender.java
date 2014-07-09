package org.springdemo.helloworld.mail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MockMailSender implements MailSender {
	
private static final Logger logger = LoggerFactory.getLogger(MockMailSender.class);
	
	@Override
	public void Send(String to, String subject, String body){
		logger.info("Sending Mock Mail to " + to);
		logger.info("Subject " + subject);
		logger.info("Body " + body);
		
	}

}
