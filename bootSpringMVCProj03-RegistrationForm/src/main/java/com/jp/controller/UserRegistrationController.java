package com.jp.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jp.entity.UserEmployee;
import com.jp.model.RegistrationModel;
import com.jp.service.IUserRegistrationService;

import jakarta.mail.MessagingException;

@Controller
public class UserRegistrationController {
	//@Autowired
	private IUserRegistrationService service;
	
	@Autowired
	public UserRegistrationController(IUserRegistrationService service) {
		super();
		this.service = service;
	}

	@GetMapping
	public String showForm() {
		return "registrationForm";
	}
	
	@PostMapping("/register")
	public String registerAndShowMsg(Map<String,Object> map,
										@ModelAttribute("UserReg") RegistrationModel regus) throws MessagingException {
		map.put("user", regus);
		UserEmployee emp = new UserEmployee();
		emp.setUserName(regus.getUsername());emp.setEmail(regus.getEmail());
		emp.setPassword(regus.getPassword());emp.setProfession(regus.getProfession());
		service.addUSer(emp);
		service.sendMail("you are succesfully register", regus);
		return "register_message";
	}
	

}
