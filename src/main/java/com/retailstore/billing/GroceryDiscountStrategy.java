package com.retailstore.billing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author mohammadnaushad
 *
 */
@Service
public class GroceryDiscountStrategy  extends DiscountStrategy{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(GroceryDiscountStrategy.class);
	
	@Override
	public Double calculateFinalBillAmount(Billing bill) {
		LOGGER.info("-- Inside [GroceryDiscountStrategy] [Method: calculateFinalBillAmount()]");
		Double billAmount=bill.getBillDto().getBillAmount();
		
		billAmount -= extraDiscount(billAmount);
		LOGGER.info("-- Leaving [GroceryDiscountStrategy] [Method: calculateFinalBillAmount()] with [Final Bill Amount: {}]",billAmount);
		
		return billAmount;
	}
}
