package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.event.RegistrationCompleteEvent;
import com.example.demo.model.UserModel;
import com.example.demo.service.UserService;

@RestController
public class RegistrationController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	@PostMapping("/register")
	public String registerUser(@RequestBody UserModel userModel,final HttpServletRequest httpServletRequest) {
		User user= userService.registerUser(userModel);
		publisher.publishEvent(new RegistrationCompleteEvent(user, applicationUrl(httpServletRequest)));
		return "Success";
	}
	private String applicationUrl(HttpServletRequest httpServletRequest) {
		return "http://"+httpServletRequest.getServerName()+":"+httpServletRequest.getServerPort()+httpServletRequest.getServletPath();
	}
}
