package com.productentity.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.productentity.entity.User;
import com.productentity.repository.UserRepo;
import com.productentity.util.ResponseStructure;

@Service
public class UserServiceImpl implements UserService {

	private UserRepo repo;
	private ResponseStructure<User> structure;

	public UserServiceImpl(UserRepo repo, ResponseStructure<User> structure) {
	
		this.repo = repo;
		this.structure = structure;
	}

	@Override
	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {

		User user2 = repo.save(user);
		User build = User.builder().userEmail("pavan").build();
		System.out.println(build.getUserName()  );
		return ResponseEntity.ok(structure.setStatuscode(HttpStatus.OK.value()).setMessage("userdata is strorred").setData(user2));
		
	}

}
