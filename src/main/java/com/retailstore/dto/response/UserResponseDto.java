package com.retailstore.dto.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.retailstore.enums.UserType;

/**
 * @author mohammadnaushad
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponseDto  implements Serializable{

	private static final long serialVersionUID = 3901408743981344832L;
	private Long id;
	private String userName;
	private UserType userType;
	private String createDate;
	private String updateDate;
	private String userId;
	
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "UserResponseDto [id=" + id + ", userName=" + userName + ", userType=" + userType + ", createDate="
				+ createDate + ", updateDate=" + updateDate + ", userId=" + userId + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserResponseDto other = (UserResponseDto) obj;
		if (createDate == null) {
			if (other.createDate != null)
				return false;
		} else if (!createDate.equals(other.createDate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (updateDate == null) {
			if (other.updateDate != null)
				return false;
		} else if (!updateDate.equals(other.updateDate))
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
