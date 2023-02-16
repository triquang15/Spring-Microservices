package com.devteam.mapper;

import com.devteam.dto.UserDto;
import com.devteam.entity.User;

public class UserMapper {
	
	// Convert User JPA Entity into UserDto
	public static UserDto mapToUserDto(User user) {
		UserDto savedUserDto = new UserDto(
				user.getId(), 
				user.getFirstname(), 
				user.getLastname(), 
				user.getEmail());
		
		return savedUserDto;
	}
	
	// Convert UserDto JPA Entity into UserDto
	public static User mapToUser(UserDto userDto) {
		User user = new User(
				userDto.getId(), 
				userDto.getFirstname(), 
				userDto.getLastname(), 
				userDto.getEmail());
		return user;
	}
}
