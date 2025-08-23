package com.aditya.service;


import java.util.List;

import com.aditya.exception.UserException;
import com.aditya.modal.User;


public interface UserService {
	User getUserByEmail(String email) throws UserException;
	User getUserFromJwtToken(String jwt) throws Exception;
	User getUserById(Long id) throws UserException;
	List<User> getAllUsers();

}
