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
import com.retailstore.domain.UserDetails;
import com.retailstore.repository.UserRepository;

/**
 * @author mohammadnaushad
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserDaoTest.class);
	
	@Mock
	UserRepository userRepositoryMock; 
	
	@InjectMocks
	UserDAO userDaoMock;
	
	@Test
	public void fetchUserByUserIdTest(){
		LOGGER.info("-- Testing [UserDaoTesting] [Method: fetchUserByUserIdTest()]");
		when(userRepositoryMock.findByUserId(Mockito.any(String.class))).thenReturn(UserDataStub.userDetails());
        assertEquals(UserDataStub.userDetails(),userDaoMock.fetchUserByUserId("999999999"));
    }
	
	@Test
	public void fetchUserIdTest(){
		LOGGER.info("-- Testing [UserDaoTesting] [Method: fetchUserIdTest()]");
		when(userRepositoryMock.findById(Mockito.any(Long.class))).thenReturn(UserDataStub.userDetailsOptional());
        assertEquals(UserDataStub.userDetails(),userDaoMock.fetchUserById(1001l));
    }
	
	@Test
	public void saveNewUser(){
		LOGGER.info("-- Testing [UserDaoTesting] [Method: saveNewUser()]");
		when(userRepositoryMock.save(Mockito.any(UserDetails.class))).thenReturn(UserDataStub.userDetails());
        assertEquals(UserDataStub.userDetails(),userDaoMock.saveNewUser(UserDataStub.userRequestDto()));
    }
	
	@Test
	public void updateUser(){
		LOGGER.info("-- Testing [UserDaoTesting] [Method: updateUser()]");
		when(userRepositoryMock.save(Mockito.any(UserDetails.class))).thenReturn(UserDataStub.userDetails());
        assertEquals(UserDataStub.userDetails(),userDaoMock.saveNewUser(UserDataStub.userUpadteRequestDto()));
    }

}
