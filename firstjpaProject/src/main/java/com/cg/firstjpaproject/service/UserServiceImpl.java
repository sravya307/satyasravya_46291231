package com.cg.firstjpaproject.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.firstjpaproject.dto.UserDto;
import com.cg.firstjpaproject.entity.User;
import com.cg.firstjpaproject.exceptions.UserNotFoundException;
import com.cg.firstjpaproject.mapper.AutoUserMapper;
import com.cg.firstjpaproject.repository.UserRepository;

@Service

public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository urepo;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public UserDto createUser(UserDto userDto) {
	/*	//convert UserDto into User JPA Entity
//		User user = new User(
//			userDto.getId(),userDto.getFirstName(),
//			userDto.getLastName());
		
		
		//using UserMapper Class		
		User user = UserMapper.mapToUser(userDto);
				
		User savedUser =  urepo.save(user);
		 
		//convert user jpa entity to userDto
//		UserDto savedUserDto = new UserDto(
//				savedUser.getId(),
//				savedUser.getFirstName(),
//				savedUser.getLastName());
		
		UserDto savedUserDto = UserMapper.mapToUserDto(savedUser);		
		return savedUserDto;*/
		User user = modelMapper.map(userDto, User.class);
		User savedUser =  urepo.save(user);
		UserDto savedUserDto = modelMapper.map(savedUser, UserDto.class);
		
		return savedUserDto;
	}
	
	
	@Override
	public UserDto getUserById(Long UserId) {		
		User user = urepo.findById(UserId).orElseThrow(
				() -> new UserNotFoundException("User","id",UserId));
		//User user1 = user.get();		
	//	UserDto udto = modelMapper.map(user, UserDto.class);
		
		return AutoUserMapper.Mapper.maptoUserDto(user);
	}
	
	
	@Override
	public UserDto updateStudentById(UserDto userDto) {
		User user = modelMapper.map(userDto, User.class);
		Optional<User> udetails = urepo.findById(user.getId());
		if(udetails.isPresent()) {
			User userUpdate = udetails.get();
			userUpdate.setId(user.getId());
			userUpdate.setFirstName(user.getFirstName());
			userUpdate.setLastName(user.getLastName());
			urepo.save(userUpdate);
			UserDto udto = modelMapper.map(userUpdate, UserDto.class);
			return udto;
		}
		else {
			return null;
		}
		//return null;
	}


	@Override
	public void deleteUserById(Long uid) {
		Optional<User> udetails = urepo.findById(uid);
		if(udetails.isPresent()) {
			urepo.delete(udetails.get());
		}else {
			throw new UserNotFoundException("User","id",uid);
		}
		
	}

}
