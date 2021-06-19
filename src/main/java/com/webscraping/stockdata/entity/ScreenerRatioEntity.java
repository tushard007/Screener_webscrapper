package com.webscraping.stockdata.entity;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="screener_ratio")
public class ScreenerRatioEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	String CompanyName;
	Float MarketCap;

	Float CurrentPrice;

	Float week52High;

	Float week52Low;

	Float bookValue;

	Float PE;
	String divYeild;

	Float ROCE;

	Float ROE;

	Float debt;

	Float debtToEquity;

	String promoterHolding;

	String pledgedShare;

	Float faceValue;

	Float salesGrowth10Year;

	Float salesGrowth5Year;

	Float salesGrowth3Year;

	Float salesGrowthTTM;

	Float profitGrowth10Year;

	Float profitGrowth5Year;

	Float profitGrowth3Year;

	Float profitGrowthTTM;
	Float priceGrowth10Year;

	Float priceGrowth5Year;

	Float priceGrowth3Year;
	Float priceGrowth1year;
	Float ROE10Year;
	Float ROE5Year;

	Float ROE3Year;

	Float ROETTM;

	Float Sales;

	Float OPM;

	Float Pat;

	Float SalesLatestQuarter;

	Float Asset_Turnover_Ratio;

	Float EVEBITDA;

	Float YOYQuarterlyProfitGrowth;

	Float PricetoBookValue;

	Float ReturnOnAssets;

	Float EBIT;

	Float industry_PE;

	Float interest_cov_ratio;

	Float Tax;

	Float TaxLatestQuarter;



	@CreationTimestamp
	private Date dateCreated;
	@Column(name = "timestamp")
	@UpdateTimestamp
	private Date timestamp;

	public String getCompanyName() {
		return CompanyName;
	}

	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}

	public Float getMarketCap() {
		return MarketCap;
	}

	public void setMarketCap(Float marketCap) {
		MarketCap = marketCap;
	}

	public Float getCurrentPrice() {
		return CurrentPrice;
	}

	public void setCurrentPrice(Float currentPrice) {
		CurrentPrice = currentPrice;
	}

	public Float getWeek52High() {
		return week52High;
	}

	public void setWeek52High(Float week52High) {
		this.week52High = week52High;
	}

	public Float getWeek52Low() {
		return week52Low;
	}

	public void setWeek52Low(Float week52Low) {
		this.week52Low = week52Low;
	}

	public Float getBookValue() {
		return bookValue;
	}

	public void setBookValue(Float bookValue) {
		this.bookValue = bookValue;
	}

	public Float getPE() {
		return PE;
	}

	public void setPE(Float pE) {
		PE = pE;
	}

	public String getDivYeild() {
		return divYeild;
	}

	public void setDivYeild(String divYeild) {
		this.divYeild = divYeild;
	}

	public Float getROCE() {
		return ROCE;
	}

	public void setROCE(Float rOCE) {
		ROCE = rOCE;
	}

	public Float getROE() {
		return ROE;
	}

	public void setROE(Float rOE) {
		ROE = rOE;
	}

	public Float getDebt() {
		return debt;
	}

	public void setDebt(Float debt) {
		this.debt = debt;
	}

	public Float getDebtToEquity() {
		return debtToEquity;
	}

	public void setDebtToEquity(Float debtToEquity) {
		this.debtToEquity = debtToEquity;
	}

	public String getPromoterHolding() {
		return promoterHolding;
	}

	public void setPromoterHolding(String promoterHolding) {
		this.promoterHolding = promoterHolding;
	}

	public String getPledgedShare() {
		return pledgedShare;
	}

	public void setPledgedShare(String pledgedShare) {
		this.pledgedShare = pledgedShare;
	}

	public Float getFaceValue() {
		return faceValue;
	}

	public void setFaceValue(Float faceValue) {
		this.faceValue = faceValue;
	}

	public Float getSalesGrowth10Year() {
		return salesGrowth10Year;
	}

	public void setSalesGrowth10Year(Float salesGrowth10Year) {
		this.salesGrowth10Year = salesGrowth10Year;
	}

	public Float getSalesGrowth5Year() {
		return salesGrowth5Year;
	}

	public void setSalesGrowth5Year(Float salesGrowth5Year) {
		this.salesGrowth5Year = salesGrowth5Year;
	}

	public Float getSalesGrowth3Year() {
		return salesGrowth3Year;
	}

	public void setSalesGrowth3Year(Float salesGrowth3Year) {
		this.salesGrowth3Year = salesGrowth3Year;
	}

	public Float getSalesGrowthTTM() {
		return salesGrowthTTM;
	}

	public void setSalesGrowthTTM(Float salesGrowthTTM) {
		this.salesGrowthTTM = salesGrowthTTM;
	}

	public Float getProfitGrowth10Year() {
		return profitGrowth10Year;
	}

	public void setProfitGrowth10Year(Float profitGrowth10Year) {
		this.profitGrowth10Year = profitGrowth10Year;
	}

	public Float getProfitGrowth5Year() {
		return profitGrowth5Year;
	}

	public void setProfitGrowth5Year(Float profitGrowth5Year) {
		this.profitGrowth5Year = profitGrowth5Year;
	}

	public Float getProfitGrowth3Year() {
		return profitGrowth3Year;
	}

	public void setProfitGrowth3Year(Float profitGrowth3Year) {
		this.profitGrowth3Year = profitGrowth3Year;
	}

	public Float getProfitGrowthTTM() {
		return profitGrowthTTM;
	}

	public void setProfitGrowthTTM(Float profitGrowthTTM) {
		this.profitGrowthTTM = profitGrowthTTM;
	}

	public Float getPriceGrowth10Year() {
		return priceGrowth10Year;
	}

	public void setPriceGrowth10Year(Float priceGrowth10Year) {
		this.priceGrowth10Year = priceGrowth10Year;
	}

	public Float getPriceGrowth5Year() {
		return priceGrowth5Year;
	}

	public void setPriceGrowth5Year(Float priceGrowth5Year) {
		this.priceGrowth5Year = priceGrowth5Year;
	}

	public Float getPriceGrowth3Year() {
		return priceGrowth3Year;
	}

	public void setPriceGrowth3Year(Float priceGrowth3Year) {
		this.priceGrowth3Year = priceGrowth3Year;
	}

	public Float getPriceGrowth1year() {
		return priceGrowth1year;
	}

	public void setPriceGrowth1year(Float priceGrowth1year) {
		this.priceGrowth1year = priceGrowth1year;
	}

	public Float getROE10Year() {
		return ROE10Year;
	}

	public void setROE10Year(Float rOE10Year) {
		ROE10Year = rOE10Year;
	}

	public Float getROE5Year() {
		return ROE5Year;
	}

	public void setROE5Year(Float rOE5Year) {
		ROE5Year = rOE5Year;
	}

	public Float getROE3Year() {
		return ROE3Year;
	}

	public void setROE3Year(Float rOE3Year) {
		ROE3Year = rOE3Year;
	}

	public Float getROETTM() {
		return ROETTM;
	}

	public void setROETTM(Float rOETTM) {
		ROETTM = rOETTM;
	}

	public Float getSales() {
		return Sales;
	}

	public void setSales(Float sales) {
		Sales = sales;
	}

	public Float getOPM() {
		return OPM;
	}

	public void setOPM(Float oPM) {
		OPM = oPM;
	}

	public Float getPat() {
		return Pat;
	}

	public void setPat(Float pat) {
		Pat = pat;
	}

	public Float getSalesLatestQuarter() {
		return SalesLatestQuarter;
	}

	public void setSalesLatestQuarter(Float salesLatestQuarter) {
		SalesLatestQuarter = salesLatestQuarter;
	}

	public Float getAsset_Turnover_Ratio() {
		return Asset_Turnover_Ratio;
	}

	public void setAsset_Turnover_Ratio(Float asset_Turnover_Ratio) {
		Asset_Turnover_Ratio = asset_Turnover_Ratio;
	}

	public Float getEVEBITDA() {
		return EVEBITDA;
	}

	public void setEVEBITDA(Float eVEBITDA) {
		EVEBITDA = eVEBITDA;
	}

	public Float getYOYQuarterlyProfitGrowth() {
		return YOYQuarterlyProfitGrowth;
	}

	public void setYOYQuarterlyProfitGrowth(Float yOYQuarterlyProfitGrowth) {
		YOYQuarterlyProfitGrowth = yOYQuarterlyProfitGrowth;
	}

	public Float getPricetoBookValue() {
		return PricetoBookValue;
	}

	public void setPricetoBookValue(Float pricetoBookValue) {
		PricetoBookValue = pricetoBookValue;
	}

	public Float getReturnOnAssets() {
		return ReturnOnAssets;
	}

	public void setReturnOnAssets(Float returnOnAssets) {
		ReturnOnAssets = returnOnAssets;
	}

	public Float getEBIT() {
		return EBIT;
	}

	public void setEBIT(Float eBIT) {
		EBIT = eBIT;
	}

	public Float getindustry_PE() {
		return industry_PE;
	}

	public void setindustry_PE(Float industry_PE) {
		this.industry_PE = industry_PE;
	}

	public Float getinterest_cov_ratio() {
		return interest_cov_ratio;
	}

	public void setinterest_cov_ratio(Float interest_cov_ratio) {
		this.interest_cov_ratio = interest_cov_ratio;
	}

	public Float getTax() {
		return Tax;
	}

	public void setTax(Float tax) {
		Tax = tax;
	}

	public Float getTaxLatestQuarter() {
		return TaxLatestQuarter;
	}

	public void setTaxLatestQuarter(Float taxLatestQuarter) {
		TaxLatestQuarter = taxLatestQuarter;
	}


}	

