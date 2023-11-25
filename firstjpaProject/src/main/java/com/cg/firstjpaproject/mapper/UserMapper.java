package com.cg.firstjpaproject.mapper;

import com.cg.firstjpaproject.dto.UserDto;
import com.cg.firstjpaproject.entity.User;

//convert userJPA entity into UserDto
public class UserMapper {

	public static UserDto mapToUserDto(User user) {
		UserDto userDto = new UserDto(
				user.getId(),
				user.getFirstName(),
				user.getLastName());
		return userDto;
	}
	
	//convert UserDto into user Jpa entity
	public static User mapToUser(UserDto userDto) {
		User user = new User(
				userDto.getId(),
				userDto.getFirstName(),
				userDto.getLastName());
		return user;
	}
}


