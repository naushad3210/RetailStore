package com.retailstore.domain;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.retailstore.enums.UserType;

/*
 * This is our model class and it corresponds to User table in database
 */
@Entity
@Table(name="userDetails",uniqueConstraints = @UniqueConstraint(columnNames = {
		"userId"}))
public class UserDetails{
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="userId")
	private String userId;
	
	@Column(name="userName")
	private String userName;
	
	@Column(name="createDate")
	private Date createDate;
	
	@Column(name="lastUpdated")
	private Date lastUpdated;
	
	@Column(name="userType")
	@Enumerated(EnumType.STRING)
	private UserType userType;
	
	@OneToMany(mappedBy="userFk")
    private Set<BillDetails> billDetails;
	
	@PrePersist
	public void prePersist() {
		this.createDate= new Date(System.currentTimeMillis());
		this.lastUpdated= new Date(System.currentTimeMillis());
	}
	
	@PreUpdate
	public void preUpdate() {
		this.createDate= new Date(System.currentTimeMillis());
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public UserType getUserType() {
		return userType;
	}
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	public Set<BillDetails> getBillDetails() {
		return billDetails;
	}
	public void setBillDetails(Set<BillDetails> billDetails) {
		this.billDetails = billDetails;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDetails other = (UserDetails) obj;
		if (billDetails == null) {
			if (other.billDetails != null)
				return false;
		} else if (!billDetails.equals(other.billDetails))
			return false;
		if (createDate == null) {
			if (other.createDate != null)
				return false;
		} else if (!createDate.equals(other.createDate))
			return false;
		if (id != other.id)
			return false;
		if (lastUpdated == null) {
			if (other.lastUpdated != null)
				return false;
		} else if (!lastUpdated.equals(other.lastUpdated))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (userType != other.userType)
			return false;
		return true;
	}
	
	
}