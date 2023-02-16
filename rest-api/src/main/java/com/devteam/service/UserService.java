package com.devteam.service;

import java.util.List;

import com.devteam.dto.UserDto;

public interface UserService {
	UserDto createUser(UserDto user);

	UserDto getUserById(Long userId);

	List<UserDto> getAllUsers();

	UserDto updateUser(UserDto user);
	
	void deleteUser(Long userId);
}
