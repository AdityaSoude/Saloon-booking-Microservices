package com.aditya.service;

import com.aditya.exception.UserException;
import com.aditya.payload.request.SignupDto;
import com.aditya.payload.response.AuthResponse;

public interface AuthService {
    AuthResponse login(String username, String password) throws Exception;
    AuthResponse signup(SignupDto req) throws Exception;
    AuthResponse getAccessTokenFromRefreshToken(String refreshToken) throws Exception;
}
