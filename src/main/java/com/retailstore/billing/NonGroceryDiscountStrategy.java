package com.retailstore.billing;

import java.time.LocalDate;
import java.time.Period;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retailstore.dto.request.UserRequestDto;
import com.retailstore.enums.UserType;
import com.retailstore.service.IUserService;

/**
 * @author mohammadnaushad
 *
 */
@Service
public class NonGroceryDiscountStrategy extends DiscountStrategy{
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	public final int CUSTOMER_AGE_FACTOR=2;
	
	@Autowired
	IUserService userService;

	@Override
	public Double calculateFinalBillAmount(Billing user) {
		LOGGER.info("-- Inside [NonGroceryDiscountStrategy] [Method: calculateFinalBillAmount()]");
		user= checkForOldUser(user);
		Double billAmount=user.getBillDto().getBillAmount();
		
		billAmount -= extraDiscount(billAmount);
		
		billAmount-= billAmount*user.getUserDetails().getUserType().getValue()/100;
		LOGGER.info("-- Leaving [NonGroceryDiscountStrategy] [Method: calculateFinalBillAmount()] with [Final Bill Amount: {}]",billAmount);
		return billAmount;
	}
	
	
	/**
	 * Method to check if the user is a customer for more than certain period
	 * If he gets over certain period then, the user type are updated from  NEW_USER to OLD_USER
	 * @param user
	 * @return
	 */
	private Billing checkForOldUser(Billing user) {
		LOGGER.info("-- Checking User Age With Store!");
		if(user.getUserDetails().getUserType()==UserType.NEW_USER) {
			LocalDate createUserInstant = user.getUserDetails().getCreateDate().toLocalDate();
			Period period = createUserInstant.until(LocalDate.now());
			if(period.getYears()>=CUSTOMER_AGE_FACTOR){
				LOGGER.info("-- User is Old Now! Updating the User in DB!");
				user.getUserDetails().setUserType(UserType.OLD_USER);
				UserRequestDto userRequestDto= new UserRequestDto();
				userRequestDto.setUserType(user.getUserDetails().getUserType());
				userRequestDto.setUserName(user.getUserDetails().getUserName());
				userRequestDto.setUserId(user.getUserDetails().getId()+"");
				userService.updateUser(userRequestDto);
			}
		}
		return user;
	}

}
