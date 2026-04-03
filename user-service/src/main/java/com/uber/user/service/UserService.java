package com.uber.user.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.uber.user.dto.LoginRequest;
import com.uber.user.dto.RegisterRequest;
import com.uber.user.entity.User;
import com.uber.user.repository.UserRepository;
import com.uber.user.security.JwtUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;
	
	private final JwtUtil jwtUtil;
	
	private final PasswordEncoder passwordEncoder;
	
	public User register(RegisterRequest request) {
		
		userRepository.findByEmail(request.getEmail())
		.ifPresent(user -> {
			throw new RuntimeException("Email already exists");
		});
		
		User user = User.builder()
				.name(request.getName())
				.email(request.getEmail())
				.password(passwordEncoder.encode(request.getPassword()))
				.role(request.getRole())
				.build();
		
		return userRepository.save(user);
	}
	
	public String login(LoginRequest request) {
		User user = userRepository.findByEmail(request.getEmail())
				.orElseThrow(() -> new RuntimeException("User not found"));
		
		if(!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
			throw new RuntimeException("Invalid password");
		}
		
		return jwtUtil.generateToken(user.getEmail());
	}
}
