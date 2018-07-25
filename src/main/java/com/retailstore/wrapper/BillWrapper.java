package com.retailstore.wrapper;

import com.retailstore.domain.BillDetails;
import com.retailstore.dto.response.BillResponseDto;

/**
 * @author mohammadnaushad
 *
 */
public class BillWrapper {
	public static BillResponseDto createBillResponse(BillDetails billDetailsResponse) {
		BillResponseDto billResponseDto = new BillResponseDto();
		billResponseDto.setBillAmount(billDetailsResponse.getBillAmount());
		billResponseDto.setDiscountAmount(billDetailsResponse.getDiscountAmount());
		billResponseDto.setDiscountPercent(billDetailsResponse.getDiscountPercent());
		billResponseDto.setFinalBillAmount(Math.round(billDetailsResponse.getFinalBillAmount()*100D)/100D);
		billResponseDto.setItemType(billDetailsResponse.getItemType());
		billResponseDto.setId(billDetailsResponse.getId());
		billResponseDto.setBillDate(billDetailsResponse.getCreateDate()+"");
		billResponseDto.setUserId(billDetailsResponse.getUserId());
		return billResponseDto;
	}
}
