package com.productentity.service;

import org.springframework.http.ResponseEntity;

import com.productentity.entity.User;
import com.productentity.util.ResponseStructure;

public interface UserService {

	ResponseEntity<ResponseStructure<User>> saveUser(User user);

}
