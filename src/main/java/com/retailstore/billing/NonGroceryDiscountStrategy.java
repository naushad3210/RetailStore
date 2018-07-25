package com.retailstore.billing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author mohammadnaushad
 *
 */
@Service
public class NonGroceryDiscountStrategy extends DiscountStrategy{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(NonGroceryDiscountStrategy.class);
	
	@Override
	public Double calculateFinalBillAmount(Billing bill) {
		LOGGER.info("-- Inside [NonGroceryDiscountStrategy] [Method: calculateFinalBillAmount()]");
		Double billAmount=bill.getBillDto().getBillAmount();
		
		billAmount -= extraDiscount(billAmount);
		
		billAmount-= billAmount*bill.getBillDto().getUserType().getValue()/100;
		LOGGER.info("-- Leaving [NonGroceryDiscountStrategy] [Method: calculateFinalBillAmount()] with [Final Bill Amount: {}]",billAmount);
		return billAmount;
	}
}
