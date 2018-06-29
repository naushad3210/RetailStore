package com.retailstore.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.retailstore.domain.UserDetails;
import com.retailstore.dto.request.UserRequestDto;
import com.retailstore.dto.response.ResponseDto;
import com.retailstore.dto.response.UserResponseDto;
import com.retailstore.service.IUserService;
import com.retailstore.wrapper.UserWrapper;

/**
 * @author mohammadnaushad
 *
 */
@RestController
public class UserController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	IUserService userService;
	
	@PostMapping(value = "/user",  headers = "Accept=application/json")
	public ResponseDto<UserResponseDto> saveNewUser(@RequestBody @Valid UserRequestDto userRequestDto) {
		LOGGER.info("-- Inside [UserController] [Method: saveNewUser()] with [Data:{}]",userRequestDto);
		UserDetails userDetailsResponse = userService.saveNewUser(userRequestDto);
		
		ResponseDto<UserResponseDto> userResponse= new ResponseDto<>();
		userResponse.setBody(UserWrapper.createUserResponse(userDetailsResponse));
	 
		return userResponse;
	}
	
	@GetMapping(value = "/user/{userId}",  headers = "Accept=application/json")
	public ResponseDto<UserResponseDto> getUserByUserId(@PathVariable("userId") String userId) {
		LOGGER.info("-- Inside [UserController] [Method: getUserByUserId()] with [Data:{}]",userId);
		UserDetails userDetailsResponse = userService.fetchUserByUserId(userId);
		
		ResponseDto<UserResponseDto> userResponse= new ResponseDto<>();
		userResponse.setBody(UserWrapper.createUserResponse(userDetailsResponse));
	 
		return userResponse;
	}
	
	@GetMapping(value = "/user",  headers = "Accept=application/json")
	public ResponseDto<List<UserResponseDto>> getAllUsers() {
		LOGGER.info("-- Inside [UserController] [Method: getAllUsers()]");
		List<UserDetails> userDetailsList = userService.getAllUser();
		
		ResponseDto<List<UserResponseDto>> userResponse= new ResponseDto<>();
		userResponse.setBody(UserWrapper.createUserResponseList(userDetailsList));
	 
		return userResponse;
	}

}
