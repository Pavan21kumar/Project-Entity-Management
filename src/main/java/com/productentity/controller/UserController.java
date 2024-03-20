package com.productentity.controller;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.productentity.entity.User;
import com.productentity.service.UserService;
import com.productentity.util.ResponseStructure;

import jakarta.validation.Valid;

@RestController
public class UserController {

	private UserService service;
	
	public UserController(UserService service) {
		super();
		this.service = service;
	}

	@PostMapping("/users")
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody @Valid User user)
	{
		return service.saveUser(user);
	}
}
