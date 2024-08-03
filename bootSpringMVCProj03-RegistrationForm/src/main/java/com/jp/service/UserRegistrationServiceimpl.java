package com.jp.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.jp.entity.UserEmployee;
import com.jp.model.RegistrationModel;
import com.jp.repository.UserEmployeeRepo;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
@Service
public class UserRegistrationServiceimpl implements IUserRegistrationService {

	//@Autowired
	private UserEmployeeRepo repo;
	//@Autowired
	private JavaMailSender sender;
	@Value("${spring.mail.username}")
	private String fromMail;
	
	@Override
	public String addUSer(UserEmployee u) {
		
		UserEmployee userEmployee = repo.save(u);
		return userEmployee.getUserName()+"register succesfully";
	}
	
	@Autowired
	public UserRegistrationServiceimpl(UserEmployeeRepo repo, JavaMailSender sender) {
		super();
		this.repo = repo;
		this.sender = sender;
	}



	@Override
	public String sendMail(String message,RegistrationModel user) throws MessagingException {
		MimeMessage mimeMessage = sender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
		mimeMessageHelper.setFrom(fromMail);
		mimeMessageHelper.setCc(user.getEmail());
		mimeMessageHelper.setSubject("open it know");
		mimeMessageHelper.setSentDate(new Date());
		mimeMessageHelper.setText(message);
		sender.send(mimeMessage);
		return "mail sent to "+user.getUsername();
		
		
	}

}
