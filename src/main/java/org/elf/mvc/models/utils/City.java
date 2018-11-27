package org.elf.mvc.models.utils;

public enum City {
	CHINA_CN(86);
	
	
	
	private  int value;
    City(int value) {
		this.value = value;
	}
	public int getValue() {
		return value;
	}
    
    
}
