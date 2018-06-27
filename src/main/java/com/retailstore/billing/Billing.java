package com.retailstore.billing;

import com.retailstore.domain.UserDetails;
import com.retailstore.dto.request.BillRequestDto;

public class Billing {
	
	private UserDetails userDetails;
	private DiscountStrategy discountStrategy;
	private BillRequestDto billDto;

	public Billing(DiscountStrategy discountStrategy,UserDetails userDetails,BillRequestDto billDto) {
		this.discountStrategy = discountStrategy;
		this.userDetails = userDetails;
		this.billDto = billDto;
	}
	
	public Double calculateFinalBillAmount() {
		return discountStrategy.calculateFinalBillAmount(this);
	}

	public DiscountStrategy getDiscountStrategy() {
		return discountStrategy;
	}

	public void setDiscountStrategy(DiscountStrategy discountStrategy) {
		this.discountStrategy = discountStrategy;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	public BillRequestDto getBillDto() {
		return billDto;
	}

	public void setBillDto(BillRequestDto billDto) {
		this.billDto = billDto;
	}

	@Override
	public String toString() {
		return "Billing [userDetails=" + userDetails + ", discountStrategy=" + discountStrategy + ", billDto=" + billDto
				+ "]";
	}
	
	

}
