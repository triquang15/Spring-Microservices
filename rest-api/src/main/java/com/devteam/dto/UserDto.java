package com.devteam.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	private Long id;
	
	@NotEmpty(message = "Last name is required")
	private String lastname;
	
	@NotEmpty(message = "First name is required")
	private String firstname;
	
	@NotEmpty(message = "Email is required.")
	@Email(message = "Email address should be valid")
	private String email;
}
