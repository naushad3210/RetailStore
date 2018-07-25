package com.retailstore.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.retailstore.domain.BillDetails;
import com.retailstore.dto.request.BillRequestDto;
import com.retailstore.dto.response.BillResponseDto;
import com.retailstore.dto.response.ResponseDto;
import com.retailstore.service.IBillService;
import com.retailstore.wrapper.BillWrapper;

/**
 * @author mohammadnaushad
 *
 */
@RestController
public class BillController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BillController.class);
	
	@Autowired
	IBillService billService;
	
	@PostMapping(value = "/bill",  headers = "Accept=application/json")
	public ResponseDto<BillResponseDto> generateBill(@RequestBody @Valid BillRequestDto billRequestDto) {
		LOGGER.info("-- Inside [BillController] [Method:generateBill()] with [Data:{}]",billRequestDto);
		BillDetails billDetailsResponse = billService.generateBill(billRequestDto);
		
		ResponseDto<BillResponseDto> billResponse= new ResponseDto<>();
		billResponse.setBody(BillWrapper.createBillResponse(billDetailsResponse));
		return billResponse;
	}
}
