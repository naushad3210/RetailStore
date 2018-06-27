package com.retailstore.dto.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.retailstore.enums.ItemType;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BillResponseDto implements Serializable {

	private static final long serialVersionUID = -1432009807338622302L;
	private Long id;
	private Double billAmount;
	private ItemType itemType;
	private Double discountAmount;
	private Double finalBillAmount;
	private Double discountPercent;
	private String billDate;
	private Long userId;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getDiscountAmount() {
		return discountAmount;
	}
	public void setDiscountAmount(Double discountAmount) {
		this.discountAmount = discountAmount;
	}
	public Double getFinalBillAmount() {
		return finalBillAmount;
	}
	public void setFinalBillAmount(Double finalBillAmount) {
		this.finalBillAmount = finalBillAmount;
	}
	public Double getDiscountPercent() {
		return discountPercent;
	}
	public void setDiscountPercent(Double discountPercent) {
		this.discountPercent = discountPercent;
	}
	
	public String getBillDate() {
		return billDate;
	}
	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}
	@Override
	public String toString() {
		return "BillResponseDto [id=" + id + ", billAmount=" + billAmount + ", itemType=" + itemType
				+ ", discountAmount=" + discountAmount + ", finalBillAmount=" + finalBillAmount + ", discountPercent="
				+ discountPercent + ", billDate=" + billDate + ", userId=" + userId + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BillResponseDto other = (BillResponseDto) obj;
		if (billAmount == null) {
			if (other.billAmount != null)
				return false;
		} else if (!billAmount.equals(other.billAmount))
			return false;
		if (billDate == null) {
			if (other.billDate != null)
				return false;
		} else if (!billDate.equals(other.billDate))
			return false;
		if (discountAmount == null) {
			if (other.discountAmount != null)
				return false;
		} else if (!discountAmount.equals(other.discountAmount))
			return false;
		if (discountPercent == null) {
			if (other.discountPercent != null)
				return false;
		} else if (!discountPercent.equals(other.discountPercent))
			return false;
		if (finalBillAmount == null) {
			if (other.finalBillAmount != null)
				return false;
		} else if (!finalBillAmount.equals(other.finalBillAmount))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (itemType != other.itemType)
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	
	
	
	
}
