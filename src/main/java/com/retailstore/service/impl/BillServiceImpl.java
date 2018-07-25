package com.retailstore.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.retailstore.billing.Billing;
import com.retailstore.dao.BillDAO;
import com.retailstore.domain.BillDetails;
import com.retailstore.dto.request.BillRequestDto;
import com.retailstore.factory.DiscountStrategyFactory;
import com.retailstore.service.IBillService;

/**
 * @author mohammadnaushad
 *
 */
@Service("billService")
public class BillServiceImpl implements IBillService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BillServiceImpl.class);
	
	@Autowired
	BillDAO billDao;
	
	@Autowired
	DiscountStrategyFactory discountStrategyFactory;
	
	@Transactional
	public BillDetails generateBill(BillRequestDto billRequestDto) {
		LOGGER.info("-- Inside [BillServiceImpl] [Method: generateBill()] with [Data:{}]",billRequestDto);

		Billing billing = new Billing(discountStrategyFactory.getStrategy(billRequestDto.getItemType()),billRequestDto);
		Double finalBillAmount = billing.calculateFinalBillAmount();
		
		BillDetails billDetails = new BillDetails();
		billDetails.setItemType(billRequestDto.getItemType());
		billDetails.setBillAmount(billRequestDto.getBillAmount());
		billDetails.setDiscountAmount(billRequestDto.getBillAmount()-finalBillAmount);
		billDetails.setFinalBillAmount(finalBillAmount);
		billDetails.setUserId(billRequestDto.getUserId());
		return billDao.persistBill(billDetails);
	}
}
