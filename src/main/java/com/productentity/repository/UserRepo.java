package com.productentity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productentity.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
