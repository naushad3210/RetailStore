package com.retailstore.dto.request;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.retailstore.enums.ItemType;
import com.retailstore.enums.UserType;

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
	@Positive
	private Double billAmount;
	@NotNull
	private ItemType itemType;
	@NotNull
	private UserType userType;
	
	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

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
		return "BillRequestDto [userId=" + userId + ", billAmount=" + billAmount + ", itemType=" + itemType
				+ ", userType=" + userType + "]";
	}
}
