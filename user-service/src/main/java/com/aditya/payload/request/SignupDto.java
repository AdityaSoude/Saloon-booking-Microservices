package com.aditya.payload.request;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import com.aditya.domain.UserRole;

@Data
public class SignupDto {
	private String email;
	private String password;
	private String phone;
	private String fullName;
	private String username;
	private UserRole role;


}