package com.cg.firstjpaproject.service;

import com.cg.firstjpaproject.dto.UserDto;
import com.cg.firstjpaproject.entity.User;

public interface UserService {

	UserDto createUser(UserDto userDto);
	
	UserDto getUserById(Long UserId);
	
	UserDto updateStudentById(UserDto user);
	
	public void deleteUserById(Long uid);
}
