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

import com.retailstore.dao.BillDAO;
import com.retailstore.datastub.BillDataStub;
import com.retailstore.domain.BillDetails;
import com.retailstore.repository.BillDetailsRepository;

/**
 * @author mohammadnaushad
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BillDaoTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BillDaoTest.class);
	
	@Mock
	BillDetailsRepository billDetailsRepositoryMock;
	
	@InjectMocks
	BillDAO billDaoMock;
	
	@Test
	public void persistBillTest() {
		LOGGER.info("-- Testing [BillDaoTesting] [Method: persistBillTest()]");
		when(billDetailsRepositoryMock.save(Mockito.any(BillDetails.class))).thenReturn(BillDataStub.billDetails());
        assertEquals(BillDataStub.billDetails(),billDaoMock.persistBill(BillDataStub.billDetails()));
    }
}
