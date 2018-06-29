package com.retailstore.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.retailstore.dao.UserDAO;
import com.retailstore.domain.UserDetails;
import com.retailstore.dto.request.UserRequestDto;
import com.retailstore.service.IUserService;

/**
 * @author mohammadnaushad
 *
 */
@Service("userService")
public class UserServiceImpl implements IUserService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	UserDAO userDao;

	@Override
	@Transactional
	public UserDetails fetchUserByUserId(String userId) {
		LOGGER.info("-- Inside [UserServiceImpl] [Method: fetchUserByUserId()] with [Data:{}]",userId);
		return userDao.fetchUserByUserId(userId);
	}

	@Override
	@Transactional
	public UserDetails saveNewUser(UserRequestDto userDto) {
		LOGGER.info("-- Inside [UserServiceImpl] [Method: saveNewUser()] with [Data:{}]",userDto);
		return userDao.saveNewUser(userDto);
	}

	@Override
	@Transactional
	public UserDetails updateUser(UserRequestDto userRequestDto) {
		LOGGER.info("-- Inside [UserServiceImpl] [Method: updateUser()] with [Data:{}]",userRequestDto);
		return userDao.updateUser(userRequestDto);
	}

	@Override
	@Transactional
	public UserDetails getUserById(String id) {
		LOGGER.info("-- Inside [UserServiceImpl] [Method: getUserById()] with [Data:{}]",id);
		return userDao.fetchUserById(new Long(id));
	}
	
	@Override
	@Transactional
	public List<UserDetails> getAllUser() {
		LOGGER.info("-- Inside [UserServiceImpl] [Method: getAllUser()]");
		return userDao.fetchAllUser();
	}

}
