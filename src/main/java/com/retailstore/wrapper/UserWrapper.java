package com.retailstore.wrapper;

import java.util.ArrayList;
import java.util.List;

import com.retailstore.domain.UserDetails;
import com.retailstore.dto.response.UserResponseDto;

public class UserWrapper {

	public static UserResponseDto createUserResponse(UserDetails userDetailsResponse) {
		UserResponseDto userResponseDto = new UserResponseDto();
		userResponseDto.setId(userDetailsResponse.getId());
		userResponseDto.setUserId(userDetailsResponse.getUserId());
		userResponseDto.setUserName(userDetailsResponse.getUserName());
		userResponseDto.setUserType(userDetailsResponse.getUserType());
		userResponseDto.setCreateDate(userDetailsResponse.getCreateDate()+"");
		userResponseDto.setUpdateDate(userDetailsResponse.getLastUpdated()+"");
		
		return userResponseDto;
	}
	
	public static List<UserResponseDto> createUserResponseList(List<UserDetails> userDetailsList ) {
		List<UserResponseDto> userResponseList = new ArrayList<>();
		
		userDetailsList.stream()
		.forEach(s->{
			UserResponseDto userResponseDto = new UserResponseDto();
			userResponseDto.setId(s.getId());
			userResponseDto.setUserName(s.getUserName());
			userResponseDto.setUserId(s.getUserId());
			userResponseDto.setUserType(s.getUserType());
			userResponseDto.setCreateDate(s.getCreateDate()+"");
			userResponseDto.setUpdateDate(s.getLastUpdated()+"");
			userResponseList.add(userResponseDto);
		});
		return userResponseList;
	}
}
