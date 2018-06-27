package com.retailstore.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.retailstore.domain.BillDetails;
import com.retailstore.repository.BillDetailsRepository;

@Repository
public class BillDAO {
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private BillDetailsRepository billDetailsRepository;
	
	public BillDetails persistBill(BillDetails billDetails) {
		LOGGER.info("-- Inside [BillDAO] [Method: persistBill()] with [Data:{}]",billDetails.getFinalBillAmount());
		return billDetailsRepository.save(billDetails);
	}

}
