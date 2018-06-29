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

import com.retailstore.controller.UserController;
import com.retailstore.datastub.UserDataStub;
import com.retailstore.dto.request.UserRequestDto;
import com.retailstore.service.IUserService;

/**
 * @author mohammadnaushad
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserControllerTest.class);
	
	@Mock
	IUserService userServiceMock;
	
	@InjectMocks
	UserController userControllerMock;
	
	@Test
	public void saveNewUserTest() {
		LOGGER.info("-- Testing [UserControllerTesting] [Method: saveNewUserTest()]");
		when(userServiceMock.saveNewUser(Mockito.any(UserRequestDto.class))).thenReturn(UserDataStub.userDetails());
        assertEquals(UserDataStub.userDetailsResponse(),userControllerMock.saveNewUser(UserDataStub.userRequestDto()));
    }
	
	@Test
	public void getUserByUserIdTest() {
		LOGGER.info("-- Testing [UserControllerTesting] [Method: getUserByUserIdTest()]");
		when(userServiceMock.fetchUserByUserId(Mockito.any(String.class))).thenReturn(UserDataStub.userDetails());
        assertEquals(UserDataStub.userDetailsResponse(),userControllerMock.getUserByUserId("999999999"));
    }
	
}
