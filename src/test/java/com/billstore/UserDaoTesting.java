package com.billstore;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.billstore.datastub.UserDataStub;
import com.retailstore.dao.UserDAO;
import com.retailstore.domain.UserDetails;
import com.retailstore.repository.UserRepository;

@RunWith(MockitoJUnitRunner.class)
public class UserDaoTesting {
	
	@Mock
	UserRepository userRepositoryMock; 
	
	@InjectMocks
	UserDAO userDaoMock;
	
	@Test
	public void fetchUserByUserIdTest(){
		when(userRepositoryMock.findByUserId(Mockito.any(String.class))).thenReturn(UserDataStub.userDetails());
        assertEquals(UserDataStub.userDetails(),userDaoMock.fetchUserByUserId("999999999"));
    }
	
	@Test
	public void fetchUserIdTest(){
		when(userRepositoryMock.findById(Mockito.any(Long.class))).thenReturn(UserDataStub.userDetailsOptional());
        assertEquals(UserDataStub.userDetails(),userDaoMock.fetchUserById(1001l));
    }
	
	@Test
	public void saveNewUser(){
		when(userRepositoryMock.save(Mockito.any(UserDetails.class))).thenReturn(UserDataStub.userDetails());
        assertEquals(UserDataStub.userDetails(),userDaoMock.saveNewUser(UserDataStub.userRequestDto()));
    }
	
	@Test
	public void updateUser(){
		when(userRepositoryMock.save(Mockito.any(UserDetails.class))).thenReturn(UserDataStub.userDetails());
        assertEquals(UserDataStub.userDetails(),userDaoMock.saveNewUser(UserDataStub.userUpadteRequestDto()));
    }

}
