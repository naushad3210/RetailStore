package com.retailstore.datastub;

import java.sql.Date;

import com.retailstore.billing.DiscountStrategy;
import com.retailstore.billing.GroceryDiscountStrategy;
import com.retailstore.billing.NonGroceryDiscountStrategy;
import com.retailstore.domain.BillDetails;
import com.retailstore.dto.request.BillRequestDto;
import com.retailstore.dto.response.BillResponseDto;
import com.retailstore.dto.response.ResponseDto;
import com.retailstore.enums.ItemType;
import com.retailstore.enums.UserType;

public class BillDataStub {
	private static final Date billCreateDate= new Date(System.currentTimeMillis());
	
	public static BillRequestDto billRequestDto(ItemType itemType) {
		BillRequestDto billRequestDto = new BillRequestDto();
		billRequestDto.setBillAmount(1000.0);
		billRequestDto.setItemType(itemType);
		billRequestDto.setUserType(UserType.NEW_USER);
		billRequestDto.setUserId("999999999");
		return billRequestDto;
	}
	
	public static BillDetails billDetails(){
		BillDetails billDetails = new BillDetails();
		billDetails.setId(200);
		billDetails.setItemType(ItemType.OTHER);
		billDetails.setBillAmount(1000.0);
		billDetails.setDiscountAmount(335.0);
		billDetails.setFinalBillAmount(665.0);
		billDetails.setCreateDate(billCreateDate);
		billDetails.setUserId("999999999");
		return billDetails;
	}
	
	public static BillResponseDto billResponseDto() {
		BillResponseDto billResponseDto = new BillResponseDto();
		billResponseDto.setBillAmount(1000.0);
		billResponseDto.setDiscountAmount(335.0);
		billResponseDto.setFinalBillAmount(665.0);
		billResponseDto.setItemType(ItemType.OTHER);
		billResponseDto.setId(200l);
		billResponseDto.setUserId("999999999");
		billResponseDto.setBillDate(billCreateDate+"");
		return billResponseDto;
	}
	
	public static ResponseDto<BillResponseDto> billDetailsResponse(){
		ResponseDto<BillResponseDto> billResponse= new ResponseDto<>();
		billResponse.setBody(billResponseDto());
		return billResponse;
	}
	
	public static DiscountStrategy billingMockObj(ItemType itemType) {
		if(itemType==ItemType.GROCERY)
			return new GroceryDiscountStrategy();
		else if(itemType==ItemType.OTHER)
			return new NonGroceryDiscountStrategy();
		else
			return null;
	}
}
