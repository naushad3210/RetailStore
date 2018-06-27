package com.retailstore.dto.request;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.retailstore.enums.ItemType;

/**
 * @author mohammadnaushad
 *
 */
public class BillRequestDto implements Serializable {
	
	private static final long serialVersionUID = -2040675569472299740L;
	@NotNull
	@NotEmpty
	private String userId;
	@NotNull
	private Double billAmount;
	@NotNull
	private ItemType itemType;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Double getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(Double billAmount) {
		this.billAmount = billAmount;
	}
	public ItemType getItemType() {
		return itemType;
	}
	public void setItemType(ItemType itemType) {
		this.itemType = itemType;
	}
	
	@Override
	public String toString() {
		return "BillDto [userId=" + userId + ", billAmount=" + billAmount + ", itemType=" + itemType + "]";
	}
	
}
