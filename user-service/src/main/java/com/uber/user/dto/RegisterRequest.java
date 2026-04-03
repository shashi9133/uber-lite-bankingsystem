package com.uber.user.dto;

import com.uber.user.entity.Role;

import lombok.Data;

@Data
public class RegisterRequest {

	private String name;
	private String email;
	private String password;
	private Role role;
}
