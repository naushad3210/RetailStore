package com.retailstore.billing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
/**
 *
 * @author mohammadnaushad
 * 
 */
@Service
public abstract class DiscountStrategy {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DiscountStrategy.class);
	public abstract Double calculateFinalBillAmount(Billing bill);
	
	private static final int DISOCUNT_FACTOR=5;
	private static final int DISOCUNT_QUOTIENT=100;
	
	protected Double extraDiscount(Double billAmount) {
		int extraDiscountAmount=0;
		if(billAmount>DISOCUNT_QUOTIENT) {
			LOGGER.info("-- Providing Extra Discount To User !!");
			int amountLeft= billAmount.intValue()/100;
			extraDiscountAmount= amountLeft*DISOCUNT_FACTOR;
			return (double) extraDiscountAmount;
		}
		LOGGER.info("-- User Not Eligible For Extra Discount!!");
		return (double) extraDiscountAmount;
	}
}
