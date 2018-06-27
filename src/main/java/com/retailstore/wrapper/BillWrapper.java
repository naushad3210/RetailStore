package com.retailstore.wrapper;

import com.retailstore.domain.BillDetails;
import com.retailstore.dto.response.BillResponseDto;

public class BillWrapper {
	
	public static BillResponseDto createBillResponse(BillDetails billDetailsResponse) {
		BillResponseDto billResponseDto = new BillResponseDto();
		billResponseDto.setBillAmount(billDetailsResponse.getBillAmount());
		billResponseDto.setDiscountAmount(billDetailsResponse.getDiscountAmount());
		billResponseDto.setDiscountPercent(billDetailsResponse.getDiscountPercent());
		billResponseDto.setFinalBillAmount(billDetailsResponse.getFinalBillAmount());
		billResponseDto.setItemType(billDetailsResponse.getItemType());
		billResponseDto.setId(billDetailsResponse.getId());
		billResponseDto.setUserId(billDetailsResponse.getUserFk().getId());
		billResponseDto.setBillDate(billDetailsResponse.getCreateDate()+"");
		
		return billResponseDto;
	}
	
}
