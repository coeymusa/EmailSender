package com.smartstream.cms.email;

import java.util.Properties;

import javax.mail.Session;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmailController {

//	@PostMapping("/send/{toEmail}/{fromEmail}/{host}")
//	public @ResponseBody ResponseEntity<String> sendEmail(@PathVariable("toEmail") String toEmail,@PathVariable("fromEmail")  String fromEmail, @PathVariable("host")  String host) {
//		System.out.println("SimpleEmail Start");
//
//		String smtpHostServer = host;
//		Properties props = System.getProperties();
//		props.put("mail.smtp.host", smtpHostServer);
//
//		Session session = Session.getInstance(props, null);
//		EmailBusinessService.sendEmail(session, toEmail, "Subject", "Body", fromEmail);
//		return ResponseEntity.ok("");
//	}
//	
	
	
	@PostMapping("/send")
	public @ResponseBody ResponseEntity<String> sendEmail(@RequestParam("toEmail")  String toEmail,@RequestParam("fromEmail") String fromEmail, @RequestParam("host") String host) {
		System.out.println("SimpleEmail Start");

		String smtpHostServer = host;
		Properties props = System.getProperties();
		props.put("mail.smtp.host", smtpHostServer);

		Session session = Session.getInstance(props, null);
		EmailBusinessService.sendEmail(session, toEmail, "Subject", "Body", fromEmail);
		return ResponseEntity.ok("");
	}

}
