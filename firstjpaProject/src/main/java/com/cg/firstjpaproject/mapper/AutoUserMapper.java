package com.cg.firstjpaproject.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.cg.firstjpaproject.dto.UserDto;
import com.cg.firstjpaproject.entity.User;

@Mapper
public interface AutoUserMapper {

	//providing the implementation of the interface at the compilation time
	AutoUserMapper Mapper = Mappers.getMapper(AutoUserMapper.class);
	
	User maptoUser(UserDto userDto);
	UserDto maptoUserDto(User user);
}
