package com.billstore;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.billstore.datastub.BillDataStub;
import com.retailstore.dao.BillDAO;
import com.retailstore.domain.BillDetails;
import com.retailstore.repository.BillDetailsRepository;

@RunWith(MockitoJUnitRunner.class)
public class BiilDaoTesting {
	
	@Mock
	BillDetailsRepository billDetailsRepositoryMock;
	
	@InjectMocks
	BillDAO billDaoMock;
	
	@Test
	public void persistBillTest() {
		when(billDetailsRepositoryMock.save(Mockito.any(BillDetails.class))).thenReturn(BillDataStub.billDetails());
        assertEquals(BillDataStub.billDetails(),billDaoMock.persistBill(BillDataStub.billDetails()));
    }

}
