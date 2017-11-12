package com.fukushima.controll.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fukushima.controll.entity.User;
import com.fukushima.controll.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public List<User> serch() {
		
		List<User> user = userRepository.findAll();
		return user;
	}
}
