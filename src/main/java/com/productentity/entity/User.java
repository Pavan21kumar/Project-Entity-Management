package com.productentity.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "User")
@Getter
@Setter
@Builder
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	@NotNull
	
	private String userName;
	@Min(value = 6000000000l, message = "phone number is not valid,must be greater then")
	@Max(value = 9999999999l, message = "phone number not valid,must be  lessthen ")
	private long phno;
	@NotNull(message = "email should be not null")
	@Email(message = "Email is not valid", regexp = " ^[\\w!#$%&'*+/=?{|}~^-]+(?:\\.[\\w!#$%&'*+/=?{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}")
	private String userEmail;
	@NotNull(message = "password should be not null")
	@Size(min = 8, max = 16, message = "password should be length is 8>= &&<=16")
	@Pattern(regexp = "^(?=.[0-9])(?=.[a-z])(?=.[A-Z])(?=.[@#$%^&+=])(?=\\S+$).{8,}$", message = "give propere password")
	private String password;

	

}
