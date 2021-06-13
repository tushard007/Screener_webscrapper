package com.webscraping.stockdata.entity;


public class CompnyListBean {
	
	private int id;
	
	private String companyName;
	
	private Integer bseCode;
	
	private String nseCode;
	
	private String industry;
	
	private String sector;

	public CompnyListBean() {
	}

	public CompnyListBean(int id, String companyName, Integer bseCode,
			String nseCode, String industry, String sector) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.bseCode = bseCode;
		this.nseCode = nseCode;
		this.industry = industry;
		this.sector = sector;
		
	}

	@Override
	public String toString() {
		return "StockListEntity [id=" + id + ", companyName=" + companyName
				+ ", bseCode=" + bseCode + ", nseCode=" + nseCode
				+ ", industry=" + industry + "+ sector=" + sector + "]";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public Integer getBseCode() {
		return bseCode;
	}
	public void setBseCode(Integer bseCode) {
		this.bseCode = bseCode;
	}
	public String getNseCode() {
		return nseCode;
	}
	public void setNseCode(String nseCode) {
		this.nseCode = nseCode;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
}
