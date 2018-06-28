package com.retailstore.datastub;

import java.sql.Date;
import java.util.Optional;

import com.retailstore.domain.UserDetails;
import com.retailstore.dto.request.UserRequestDto;
import com.retailstore.dto.response.ResponseDto;
import com.retailstore.dto.response.UserResponseDto;
import com.retailstore.enums.UserType;

public class UserDataStub {
	
	private static final Date userCreateDate= new Date(System.currentTimeMillis());
	
	public static  UserDetails userDetails() {
		UserDetails userDetails = new UserDetails();
		userDetails.setId(1001);
		userDetails.setUserId("999999999");
		userDetails.setUserType(UserType.NEW_USER);
		userDetails.setUserName("Nau");
		userDetails.setCreateDate(userCreateDate);
		userDetails.setLastUpdated(userCreateDate);
		return userDetails;
	}
	
	public static  Optional<UserDetails> userDetailsOptional() {
		return Optional.of(userDetails());
	}
	
	public static  UserResponseDto userResponseDto() {
		UserResponseDto userResponseDto = new UserResponseDto();
		userResponseDto.setId(1001l);
		userResponseDto.setUserName("Nau");
		userResponseDto.setUserId("999999999");
		userResponseDto.setUserType(UserType.NEW_USER);
		userResponseDto.setCreateDate(userCreateDate+"");
		userResponseDto.setUpdateDate(userCreateDate+"");
		
		return userResponseDto;
	}
	
	public static UserRequestDto userRequestDto() {
		UserRequestDto userRequestDto= new UserRequestDto();
		userRequestDto.setUserId("999999999");		
		userRequestDto.setUserName("Nau");
		userRequestDto.setUserType(UserType.NEW_USER);
		return userRequestDto;
	}
	
	public static UserRequestDto userUpadteRequestDto() {
		UserRequestDto userRequestDto= new UserRequestDto();
		userRequestDto.setUserId("999999999");		
		userRequestDto.setUserName("Nau-updated");
		userRequestDto.setUserType(UserType.EMPLOYEE);
		return userRequestDto;
	}
	
	public static ResponseDto<UserResponseDto> userDetailsResponse(){
		ResponseDto<UserResponseDto> userResponse= new ResponseDto<>();
		userResponse.setBody(userResponseDto());
		return userResponse;
	}
	

}
