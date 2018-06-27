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
import com.billstore.datastub.UserDataStub;
import com.retailstore.dao.BillDAO;
import com.retailstore.domain.BillDetails;
import com.retailstore.enums.ItemType;
import com.retailstore.factory.DiscountStrategyFactory;
import com.retailstore.service.IUserService;
import com.retailstore.service.impl.BillServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class BillServiceTesting {
	
	@Mock
	BillDAO billDaoMock;
	
	@Mock
	IUserService userServiceMock;
	
	@Mock
	DiscountStrategyFactory discountStrategyFactoryMock;
	
	@InjectMocks
	BillServiceImpl billServiceMock;
	
	@Test
	public void generateBillNonGroceryTest() {
		when(userServiceMock.fetchUserByUserId(Mockito.any(String.class))).thenReturn(UserDataStub.userDetails());
		when(discountStrategyFactoryMock.getStrategy(Mockito.any(ItemType.class))).thenReturn(BillDataStub.billingMockObj(ItemType.OTHER));
		when(billDaoMock.persistBill(Mockito.any(BillDetails.class))).thenReturn(BillDataStub.billDetails());
        assertEquals(BillDataStub.billDetails(),billServiceMock.generateBill(BillDataStub.billRequestDto(ItemType.OTHER)));
    }
	
	@Test
	public void generateBillGroceryTest() {
		when(userServiceMock.fetchUserByUserId(Mockito.any(String.class))).thenReturn(UserDataStub.userDetails());
		when(discountStrategyFactoryMock.getStrategy(Mockito.any(ItemType.class))).thenReturn(BillDataStub.billingMockObj(ItemType.GROCERY));
		when(billDaoMock.persistBill(Mockito.any(BillDetails.class))).thenReturn(BillDataStub.billDetails());
        assertEquals(BillDataStub.billDetails(),billServiceMock.generateBill(BillDataStub.billRequestDto(ItemType.GROCERY)));
    }
	
	@Test(expected = NullPointerException.class)
	public void generateBillGroceryNullTest() {
		when(userServiceMock.fetchUserByUserId(Mockito.any(String.class))).thenReturn(UserDataStub.userDetails());
        assertEquals(BillDataStub.billDetails(),billServiceMock.generateBill(BillDataStub.billRequestDto(null)));
    }


}
