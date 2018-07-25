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
import com.retailstore.enums.ItemType;
import com.retailstore.factory.DiscountStrategyFactory;
import com.retailstore.service.impl.BillServiceImpl;

/**
 * @author mohammadnaushad
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BillServiceTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BillServiceTest.class);
	
	@Mock
	BillDAO billDaoMock;
	
	@Mock
	DiscountStrategyFactory discountStrategyFactoryMock;
	
	@InjectMocks
	BillServiceImpl billServiceMock;
	
	@Test
	public void generateBillNonGroceryTest() {
		LOGGER.info("-- Testing [BillServiceTesting] [Method: generateBillNonGroceryTest()]");
		when(discountStrategyFactoryMock.getStrategy(Mockito.any(ItemType.class))).thenReturn(BillDataStub.billingMockObj(ItemType.OTHER));
		when(billDaoMock.persistBill(Mockito.any(BillDetails.class))).thenReturn(BillDataStub.billDetails());
        assertEquals(BillDataStub.billDetails(),billServiceMock.generateBill(BillDataStub.billRequestDto(ItemType.OTHER)));
    }
	
	@Test
	public void generateBillGroceryTest() {
		LOGGER.info("-- Testing [BillServiceTesting] [Method: generateBillGroceryTest()]");
		when(discountStrategyFactoryMock.getStrategy(Mockito.any(ItemType.class))).thenReturn(BillDataStub.billingMockObj(ItemType.GROCERY));
		when(billDaoMock.persistBill(Mockito.any(BillDetails.class))).thenReturn(BillDataStub.billDetails());
        assertEquals(BillDataStub.billDetails(),billServiceMock.generateBill(BillDataStub.billRequestDto(ItemType.GROCERY)));
    }
	
	@Test(expected = NullPointerException.class)
	public void generateBillGroceryNullTest() {
		LOGGER.info("-- Testing [BillServiceTesting] [Method: generateBillGroceryNullTest()]");
        assertEquals(BillDataStub.billDetails(),billServiceMock.generateBill(BillDataStub.billRequestDto(null)));
    }
}
