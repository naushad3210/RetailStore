package com.retailstore.dto.request;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.retailstore.enums.UserType;

/**
 * @author mohammadnaushad
 *
 */
public class UserRequestDto implements Serializable {
	
	private static final long serialVersionUID = -8602701292282278050L;
	@NotNull
	@NotEmpty
	private String userId;
	private String userName;
	@NotNull
	private UserType userType;
	
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
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "UserRequestDto [userId=" + userId + ", userName=" + userName + ", userType=" + userType + "]";
	}
	
}
