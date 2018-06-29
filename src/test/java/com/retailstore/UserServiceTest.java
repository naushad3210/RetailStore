package com.retailstore;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.retailstore.dao.UserDAO;
import com.retailstore.datastub.UserDataStub;
import com.retailstore.dto.request.UserRequestDto;
import com.retailstore.service.impl.UserServiceImpl;

/**
 * @author mohammadnaushad
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceTest.class);
	
	@Mock
	UserDAO userDaoMock;
	
	@InjectMocks
	UserServiceImpl userServiceImplMock;
	
	
	@Test
	public void fetchUserByUserIdTest() {
		LOGGER.info("-- Testing [UserServiceTesting] [Method: fetchUserByUserIdTest()]");
		when(userDaoMock.fetchUserByUserId(Mockito.any(String.class))).thenReturn(UserDataStub.userDetails());
        assertEquals(UserDataStub.userDetails(),userServiceImplMock.fetchUserByUserId("999999999"));
    }
	
	@Test
	public void saveNewUserTest() {
		LOGGER.info("-- Testing [UserServiceTesting] [Method: saveNewUserTest()]");
		when(userDaoMock.saveNewUser(Mockito.any(UserRequestDto.class))).thenReturn(UserDataStub.userDetails());
        assertEquals(UserDataStub.userDetails(),userServiceImplMock.saveNewUser(UserDataStub.userRequestDto()));
    }
	
	@Test
	public void getUserTest() {
		LOGGER.info("-- Testing [UserServiceTesting] [Method: getUserTest()]");
		when(userDaoMock.fetchUserById(Mockito.any(Long.class))).thenReturn(UserDataStub.userDetails());
        assertEquals(UserDataStub.userDetails(),userServiceImplMock.getUserById("1001"));
    }
	
	@Test
	public void updateUserTest() {
		LOGGER.info("-- Testing [UserServiceTesting] [Method: updateUserTest()]");
		when(userDaoMock.updateUser(Mockito.any(UserRequestDto.class))).thenReturn(UserDataStub.userDetails());
        assertEquals(UserDataStub.userDetails(),userServiceImplMock.updateUser(UserDataStub.userUpadteRequestDto()));
    }

}
