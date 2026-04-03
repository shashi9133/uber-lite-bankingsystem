package com.uber.user.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uber.user.dto.LoginRequest;
import com.uber.user.dto.RegisterRequest;
import com.uber.user.entity.User;
import com.uber.user.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;
	
	@PostMapping("/register")
	public User register(@RequestBody RegisterRequest request) {
		return userService.register(request);
	}
	
	@PostMapping("/login")
	public String login(@RequestBody LoginRequest request) {
		return userService.login(request);
	}
	
	@GetMapping("/profile")
	public String profile() {
		String email = SecurityContextHolder.getContext()
				.getAuthentication()
				.getName();
		return " User Email: " + email;
	}
}
