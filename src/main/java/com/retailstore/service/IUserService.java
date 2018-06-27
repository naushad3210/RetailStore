package com.retailstore.service;

import java.util.List;

import com.retailstore.domain.UserDetails;
import com.retailstore.dto.request.UserRequestDto;

public interface IUserService {
	
	public UserDetails fetchUserByUserId(String userId);
	public UserDetails saveNewUser(UserRequestDto userRequestDto);
	public UserDetails updateUser(UserRequestDto userRequestDto);
	public UserDetails getUserById(String userId);
	public List<UserDetails> getAllUser();

}
