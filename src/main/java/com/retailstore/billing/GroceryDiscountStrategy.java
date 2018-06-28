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
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public Double calculateFinalBillAmount(Billing user) {
		LOGGER.info("-- Inside [GroceryDiscountStrategy] [Method: calculateFinalBillAmount()]");
		Double billAmount=user.getBillDto().getBillAmount();
		
		billAmount -= extraDiscount(billAmount);
		LOGGER.info("-- Leaving [GroceryDiscountStrategy] [Method: calculateFinalBillAmount()] with [Final Bill Amount: {}]",billAmount);
		
		return billAmount;
	}

}
