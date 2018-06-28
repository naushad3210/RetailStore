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

import com.retailstore.controller.BillController;
import com.retailstore.datastub.BillDataStub;
import com.retailstore.dto.request.BillRequestDto;
import com.retailstore.enums.ItemType;
import com.retailstore.service.IBillService;

/**
 * @author mohammadnaushad
 *
 */
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class BillControllerTesting {
	
	@Mock
	IBillService billServiceMock;

	@InjectMocks
	BillController billControllerMock;
	
	@Test
	public void generateBillNonGroceryTest() {
		when(billServiceMock.generateBill(Mockito.any(BillRequestDto.class))).thenReturn(BillDataStub.billDetails());
        assertEquals(BillDataStub.billDetailsResponse(),billControllerMock.generateBill(BillDataStub.billRequestDto(ItemType.OTHER)));
    }
	
	@Test
	public void generateBillGroceryTest() {
		when(billServiceMock.generateBill(Mockito.any(BillRequestDto.class))).thenReturn(BillDataStub.billDetails());
        assertEquals(BillDataStub.billDetailsResponse(),billControllerMock.generateBill(BillDataStub.billRequestDto(ItemType.GROCERY)));
    }
	
	@Test
	public void generateBillNullTest() {
		when(billServiceMock.generateBill(Mockito.any(BillRequestDto.class))).thenReturn(BillDataStub.billDetails());
        assertEquals(BillDataStub.billDetailsResponse(),billControllerMock.generateBill(BillDataStub.billRequestDto(null)));
    }
}
