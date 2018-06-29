package com.retailstore.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.retailstore.domain.UserDetails;
import com.retailstore.dto.request.UserRequestDto;
import com.retailstore.exceptions.ResourceNotFoundException;
import com.retailstore.repository.UserRepository;

/**
 * @author mohammadnaushad
 *
 */
@Repository
public class UserDAO {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserDAO.class);
	
	@Autowired
	UserRepository userRepository;

	public UserDetails fetchUserByUserId(String userId) {
		LOGGER.info("-- Inside [UserDAO] [Method: fetchUserByUserId()] with [Data:{}]",userId);
		UserDetails userDetails = userRepository.findByUserId(userId);
		 		if(userDetails==null)
		 			throw new ResourceNotFoundException("User", "userId", userId);
		 		else
		 			return userDetails;
	}
	
	public UserDetails fetchUserById(Long id) {
		LOGGER.info("-- Inside [UserDAO] [Method: fetchUserById()] with [Data:{}]",id);
		return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
	}
	
	public List<UserDetails> fetchAllUser() {
		LOGGER.info("-- Inside [UserDAO] [Method: fetchAllUser()]");
		return userRepository.findAll();
	}
	
	public UserDetails saveNewUser(UserRequestDto userRequestDto) {
		LOGGER.info("-- Inside [UserDAO] [Method: saveNewUser()] with [Data:{}]",userRequestDto);
		UserDetails entity = new UserDetails();
		entity.setUserId(userRequestDto.getUserId());
		entity.setUserType(userRequestDto.getUserType());
		entity.setUserName(userRequestDto.getUserName());
		return userRepository.save(entity);
	}
	
	public UserDetails updateUser(UserRequestDto userRequestDto) {
		LOGGER.info("-- Inside [UserDAO] [Method: updateUser()] with [Data:{}]",userRequestDto);
		UserDetails userDetails = fetchUserById(new Long(userRequestDto.getUserId()));
		
		if(userDetails==null)
			throw new ResourceNotFoundException("User", "userId", userRequestDto.getUserId());
		
		if(userRequestDto.getUserType()!=null)
			userDetails.setUserType(userRequestDto.getUserType());
		if(userRequestDto.getUserName()!=null)
			userDetails.setUserName(userRequestDto.getUserName());
		
		return userRepository.save(userDetails);
	}

}
