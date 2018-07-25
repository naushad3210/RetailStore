package com.retailstore.service;

import com.retailstore.domain.BillDetails;
import com.retailstore.dto.request.BillRequestDto;

/**
 * @author mohammadnaushad
 *
 */
public interface IBillService {
	public BillDetails generateBill(BillRequestDto billDto);
}
