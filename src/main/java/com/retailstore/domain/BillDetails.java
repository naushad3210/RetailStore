package com.retailstore.domain;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.retailstore.enums.ItemType;

@Entity
@Table(name="billDetails")
public class BillDetails {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="userId")
	private String userId;
	
	@Column(name="itemType")
	@Enumerated(EnumType.STRING)
	private ItemType itemType;
	
	@Column(name="billAmount")
	private Double billAmount;
	
	@Column(name="discountAmount")
	private Double discountAmount;
	
	@Column(name="finalBillAmount")
	private Double finalBillAmount;
	
	@Column(name="discountPercent")
	private Double discountPercent;
	
	@Column(name="createDate")
	private Date createDate;
	
	@PrePersist
	public void prePersist() {
		this.createDate= new Date(System.currentTimeMillis());
	}
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}

	public ItemType getItemType() {
		return itemType;
	}


	public void setItemType(ItemType itemType) {
		this.itemType = itemType;
	}


	public Double getBillAmount() {
		return billAmount;
	}


	public void setBillAmount(Double billAmount) {
		this.billAmount = billAmount;
	}


	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((billAmount == null) ? 0 : billAmount.hashCode());
		result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result + ((discountAmount == null) ? 0 : discountAmount.hashCode());
		result = prime * result + ((discountPercent == null) ? 0 : discountPercent.hashCode());
		result = prime * result + ((finalBillAmount == null) ? 0 : finalBillAmount.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((itemType == null) ? 0 : itemType.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BillDetails other = (BillDetails) obj;
		if (billAmount == null) {
			if (other.billAmount != null)
				return false;
		} else if (!billAmount.equals(other.billAmount))
			return false;
		if (createDate == null) {
			if (other.createDate != null)
				return false;
		} else if (!createDate.equals(other.createDate))
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
		if (id != other.id)
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
