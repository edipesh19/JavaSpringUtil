package org.springdemo.helloworld.controllers;


import javax.mail.MessagingException;

import org.springdemo.helloworld.mail.MailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

	private MailSender mailSender;
	
	@Autowired
	public RootController(MailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	@RequestMapping("/")
	public String home() throws MessagingException{
		mailSender.Send("dipeshkumar.dutta@gmail.com", "Mail Test", "Mail From Manidip Duth");
		return "Mail Send!";
	}

}
