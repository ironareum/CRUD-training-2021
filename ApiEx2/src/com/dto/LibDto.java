package com.dto;

public class LibDto {
	String GU_CODE;
	String LIB_SEQ;
	String LIB_NAME;
	String ADDR;
	String TEL;
	String HPG;
	
	public LibDto(){
		super();
	}
	
	public LibDto(String gu_code, String lib_seq, String lib_name, String addr, String tel, String hpg){
		this.GU_CODE = gu_code;
		this.LIB_SEQ = lib_seq;
		this.LIB_NAME = lib_name;
		this.ADDR = addr;
		this.TEL = tel;
		this.HPG = hpg;
	}
	
	public String getGU_CODE() {
		return GU_CODE;
	}
	public void setGU_CODE(String gU_CODE) {
		GU_CODE = gU_CODE;
	}
	public String getLIB_SEQ() {
		return LIB_SEQ;
	}
	public void setLIB_SEQ(String lIB_SEQ) {
		LIB_SEQ = lIB_SEQ;
	}
	public String getLIB_NAME() {
		return LIB_NAME;
	}
	public void setLIB_NAME(String lIB_NAME) {
		LIB_NAME = lIB_NAME;
	}
	public String getADDR() {
		return ADDR;
	}
	public void setADDR(String aDDR) {
		ADDR = aDDR;
	}
	public String getTEL() {
		return TEL;
	}
	public void setTEL(String tEL) {
		TEL = tEL;
	}
	public String getHPG() {
		return HPG;
	}
	public void setHPG(String hPG) {
		HPG = hPG;
	}
	
	
	
}
