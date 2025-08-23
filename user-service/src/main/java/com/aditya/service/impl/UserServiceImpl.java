package com.aditya.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.aditya.exception.UserException;
import com.aditya.modal.User;
import com.aditya.payload.dto.KeycloakUserinfo;
import com.aditya.repository.UserRepository;
import com.aditya.service.KeycloakUserService;
import com.aditya.service.UserService;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


	private final UserRepository userRepository;
	private final KeycloakUserService keycloakUserService;



	@Override
	public User getUserByEmail(String email) throws UserException {
		User user=userRepository.findByEmail(email);
		if(user==null){
			throw new UserException("User not found with email: "+email);
		}
		return user;
	}

	@Override
	public User getUserFromJwtToken(String jwt) throws Exception {
		KeycloakUserinfo userinfo = keycloakUserService.fetchUserProfileByJwt(jwt);
        return userRepository.findByEmail(userinfo.getEmail());
	}

	@Override
	public User getUserById(Long id) throws UserException {
		return userRepository.findById(id).orElse(null);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}


}
