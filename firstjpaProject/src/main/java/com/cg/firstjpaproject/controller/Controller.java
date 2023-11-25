package com.cg.firstjpaproject.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.cg.firstjpaproject.dto.UserDto;
import com.cg.firstjpaproject.entity.User;
import com.cg.firstjpaproject.exceptions.ErrorDetails;
import com.cg.firstjpaproject.exceptions.UserNotFoundException;
import com.cg.firstjpaproject.service.UserService;

@RestController
//@AllArgsConstructor
@RequestMapping("/user")
public class Controller {

	@Autowired
	UserService userv;
	
	@PostMapping("/adduser")
	@ResponseStatus(HttpStatus.CREATED)
	public UserDto addUser(@RequestBody UserDto user) {
		return userv.createUser(user);
	}
	
	@GetMapping("getuser/{id}")
	@ResponseStatus(HttpStatus.OK)
	public UserDto getUserById(@PathVariable Long id){
		return userv.getUserById(id);
	}
	
	@PutMapping("updateuser/{id}")
	@ResponseStatus(HttpStatus.OK)
	public UserDto updateUserById(@PathVariable Long id,@RequestBody UserDto userDto) {
		userDto.setId(id); 
		return userv.updateStudentById(userDto);
	}
	
	@PatchMapping("updateuser/{id}")
	@ResponseStatus(HttpStatus.OK)
	public User updateUserById(@PathVariable long id,@RequestBody User user) {
		user.setId(id);
		return null;
	}
	
	@DeleteMapping("deleteuser/{id}")
	@ResponseStatus(HttpStatus.OK)
	public String deleteUserById(@PathVariable("id") Long uid) {
		userv.deleteUserById(uid);
		return "user deleted with id"+uid;
	}
	
//	@ExceptionHandler(UserNotFoundException.class)
//	@ResponseStatus(HttpStatus.NOT_FOUND)
//	public ErrorDetails handleUserNotFoundException(UserNotFoundException exception, WebRequest webRequest) {
//		ErrorDetails errorDetails = new ErrorDetails(
//				LocalDateTime.now(),
//				exception.getMessage(),
//				webRequest.getDescription(false),
//				"User Not Found");
//		
//		return errorDetails;
//	}
}
