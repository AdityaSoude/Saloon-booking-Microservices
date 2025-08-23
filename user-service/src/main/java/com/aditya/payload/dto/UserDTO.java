package com.aditya.payload.dto;

import com.aditya.domain.UserRole;

import lombok.Data;

@Data
public class UserDTO {

    private Long id;
    private String fullName;
    private String email;
    private String role;
}
