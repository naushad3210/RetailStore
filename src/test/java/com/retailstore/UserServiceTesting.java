package com.retailstore;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.retailstore.dao.UserDAO;
import com.retailstore.datastub.UserDataStub;
import com.retailstore.dto.request.UserRequestDto;
import com.retailstore.service.impl.UserServiceImpl;

/**
 * @author mohammadnaushad
 *
 */
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class UserServiceTesting {
	
	@Mock
	UserDAO userDaoMock;
	
	@InjectMocks
	UserServiceImpl userServiceImplMock;
	
	
	@Test
	public void fetchUserByUserIdTest() {
		when(userDaoMock.fetchUserByUserId(Mockito.any(String.class))).thenReturn(UserDataStub.userDetails());
        assertEquals(UserDataStub.userDetails(),userServiceImplMock.fetchUserByUserId("999999999"));
    }
	
	@Test
	public void saveNewUserTest() {
		when(userDaoMock.saveNewUser(Mockito.any(UserRequestDto.class))).thenReturn(UserDataStub.userDetails());
        assertEquals(UserDataStub.userDetails(),userServiceImplMock.saveNewUser(UserDataStub.userRequestDto()));
    }
	
	@Test
	public void getUserTest() {
		when(userDaoMock.fetchUserById(Mockito.any(Long.class))).thenReturn(UserDataStub.userDetails());
        assertEquals(UserDataStub.userDetails(),userServiceImplMock.getUserById("1001"));
    }
	
	@Test
	public void updateUserTest() {
		when(userDaoMock.updateUser(Mockito.any(UserRequestDto.class))).thenReturn(UserDataStub.userDetails());
        assertEquals(UserDataStub.userDetails(),userServiceImplMock.updateUser(UserDataStub.userUpadteRequestDto()));
    }

}
