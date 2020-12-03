package com.roberto.iosys.enuns;

public enum EnumCodFile {

	CUSTOMER("001"), SELLER("002"), SALES("003");
	
	private String code;
	
	EnumCodFile(String code) {
		this.code = code;
	}
	
	public String getcode() {
		return code;
	}
	
}
