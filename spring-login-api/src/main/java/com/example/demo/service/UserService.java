package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.model.UserModel;

public interface UserService {
	public User registerUser(UserModel userModel);
}
