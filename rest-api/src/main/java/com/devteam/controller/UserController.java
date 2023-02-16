package com.devteam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devteam.dto.UserDto;
import com.devteam.entity.User;
import com.devteam.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	// http://localhost:8080/api/users
	@PostMapping
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto user) {
		UserDto newUser = userService.createUser(user);

		return new ResponseEntity<>(newUser, HttpStatus.CREATED);
	}

	// http://localhost:8080/api/users/1
	@GetMapping("/{id}")
	public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId) {
		UserDto userById = userService.getUserById(userId);

		return new ResponseEntity<>(userById, HttpStatus.OK);
	}

	// http://localhost:8080/api/users
	@GetMapping
	public ResponseEntity<List<UserDto>> getAllUsers() {
		List<UserDto> allUsers = userService.getAllUsers();

		return new ResponseEntity<>(allUsers, HttpStatus.OK);
	}

	
	// http://localhost:8080/api/users/1
	@PutMapping("/{id}")
	public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long userId, @RequestBody UserDto user) {
		
		user.setId(userId);
		UserDto updateUser = userService.updateUser(user);

		return new ResponseEntity<>(updateUser, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId) {
		userService.deleteUser(userId);
		
		return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
	}

}
