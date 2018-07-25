package com.retailstore.billing;

import com.retailstore.dto.request.BillRequestDto;

/**
 * @author mohammadnaushad
 *
 */
public class Billing {
	
	private DiscountStrategy discountStrategy;
	private BillRequestDto billDto;

	public Billing(DiscountStrategy discountStrategy,BillRequestDto billDto) {
		this.discountStrategy = discountStrategy;
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

	public BillRequestDto getBillDto() {
		return billDto;
	}

	public void setBillDto(BillRequestDto billDto) {
		this.billDto = billDto;
	}

	@Override
	public String toString() {
		return "Billing [discountStrategy=" + discountStrategy + ", billDto=" + billDto + "]";
	}

}
