package com.retailstore.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.retailstore.billing.Billing;
import com.retailstore.dao.BillDAO;
import com.retailstore.domain.BillDetails;
import com.retailstore.domain.UserDetails;
import com.retailstore.dto.request.BillRequestDto;
import com.retailstore.factory.DiscountStrategyFactory;
import com.retailstore.service.IBillService;
import com.retailstore.service.IUserService;

@Service("billService")
public class BillServiceImpl implements IBillService {
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	@Autowired
	BillDAO billDao;
	
	@Autowired
	IUserService userService;
	
	@Autowired
	DiscountStrategyFactory discountStrategyFactory;
	
	@Transactional
	public BillDetails generateBill(BillRequestDto billRequestDto) {
		LOGGER.info("-- Inside [BillServiceImpl] [Method: generateBill()] with [Data:{}]",billRequestDto);
		UserDetails userDetails= userService.fetchUserByUserId(billRequestDto.getUserId());

		Billing billing = new Billing(discountStrategyFactory.getStrategy(billRequestDto.getItemType()),userDetails,billRequestDto);
		Double finalBillAmount = billing.calculateFinalBillAmount();
		
		BillDetails billDetails = new BillDetails();
		billDetails.setItemType(billRequestDto.getItemType());
		billDetails.setUserFk(userDetails);
		billDetails.setBillAmount(billRequestDto.getBillAmount());
		billDetails.setDiscountAmount(billRequestDto.getBillAmount()-finalBillAmount);
		billDetails.setFinalBillAmount(finalBillAmount);
		
		return billDao.persistBill(billDetails);
	}

}
