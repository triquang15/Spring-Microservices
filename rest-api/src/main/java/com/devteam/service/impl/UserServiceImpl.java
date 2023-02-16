package com.devteam.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devteam.dao.UserRepository;
import com.devteam.dto.UserDto;
import com.devteam.entity.User;
import com.devteam.mapper.UserMapper;
import com.devteam.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userDto) {
		//User user = UserMapper.mapToUser(userDto);		
		User user = modelMapper.map(userDto, User.class);

		User savedUser = userRepository.save(user);

	//	UserDto savedUserDto = UserMapper.mapToUserDto(savedUser);
		UserDto savedUserDto = modelMapper.map(savedUser, UserDto.class);

		return savedUserDto;
	}

	@Override
	public UserDto getUserById(Long userId) {
		Optional<User> optionalUser = userRepository.findById(userId);

		User user = optionalUser.get();
		
	//	return UserMapper.mapToUserDto(user);
		return modelMapper.map(user, UserDto.class);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users = userRepository.findAll();
		
	//	return users.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());
		return users.stream().map((user) -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
	}

	@Override
	public UserDto updateUser(UserDto user) {
		User existingUser = userRepository.findById(user.getId()).get();
		existingUser.setLastname(user.getLastname());
		existingUser.setFirstname(user.getFirstname());
		existingUser.setEmail(user.getEmail());

		User updatedUser = userRepository.save(existingUser);
		
//		return UserMapper.mapToUserDto(updatedUser);
		return modelMapper.map(updatedUser, UserDto.class);
	}

	@Override
	public void deleteUser(Long userId) {
		userRepository.deleteById(userId);

	}

}
