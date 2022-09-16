package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
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
	public String registerUser(@RequestBody UserModel userModel) {
		System.out.println(userModel);
		User user= userService.registerUser(userModel);
		publisher.publishEvent(new RegistrationCompleteEvent(user, ""));
		return "Success";
	}
}
