package com.retailstore.enums;

public enum UserType {
	AFILIATE(10),EMPLOYEE(30),OLD_USER(5),NEW_USER(0);
	
	private final int value;
    private UserType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
