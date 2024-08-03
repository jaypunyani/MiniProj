package com.jp.service;

import com.jp.entity.UserEmployee;
import com.jp.model.RegistrationModel;

import jakarta.mail.MessagingException;

public interface IUserRegistrationService {
	public String addUSer(UserEmployee u);

	String sendMail(String message, RegistrationModel user) throws MessagingException;
	

}
