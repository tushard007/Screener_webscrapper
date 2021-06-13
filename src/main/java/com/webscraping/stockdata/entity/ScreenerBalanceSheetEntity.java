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
@Table(name="screener_balance_sheet")
public class ScreenerBalanceSheetEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String CompanyName;
	//------Quaterly Entity------------------
	private String quater;
	private Float quaterlySales;
	private Float quaterlyExpenses;
	private Float quaterlyOperatingProfit;
	private Float quaterlyOPM_inPercent;
	private Float quaterlyOtherIncome;
	private Float quaterlyInterest;
	private Float quaterlyDepreciation;
	private Float quaterlyPBT;
	private Float quaterlyTax_inPercent;
	private Float quaterlyNetProfit;
	private Float quaterlyEps;
	@CreationTimestamp
	private Date dateCreated;
	@Column(name = "timestamp")
	@UpdateTimestamp
	private Date timestamp;
	
	public String getQuater() {
		return quater;
	}
	public void setQuater(String quater) {
		this.quater = quater;
	}
	public Float getQuaterlySales() {
		return quaterlySales;
	}
	public void setQuaterlySales(Float quaterlySales) {
		this.quaterlySales = quaterlySales;
	}
	public Float getQuaterlyExpenses() {
		return quaterlyExpenses;
	}
	public void setQuaterlyExpenses(Float quaterlyExpenses) {
		this.quaterlyExpenses = quaterlyExpenses;
	}
	public Float getQuaterlyOperatingProfit() {
		return quaterlyOperatingProfit;
	}
	public void setQuaterlyOperatingProfit(Float quaterlyOperatingProfit) {
		this.quaterlyOperatingProfit = quaterlyOperatingProfit;
	}
	public Float getQuaterlyOtherIncome() {
		return quaterlyOtherIncome;
	}
	public void setQuaterlyOtherIncome(Float quaterlyOtherIncome) {
		this.quaterlyOtherIncome = quaterlyOtherIncome;
	}
	public Float getQuaterlyInterest() {
		return quaterlyInterest;
	}
	public void setQuaterlyInterest(Float quaterlyInterest) {
		this.quaterlyInterest = quaterlyInterest;
	}
	public Float getQuaterlyDepreciation() {
		return quaterlyDepreciation;
	}
	public void setQuaterlyDepreciation(Float quaterlyDepreciation) {
		this.quaterlyDepreciation = quaterlyDepreciation;
	}
	public Float getQuaterlyPBT() {
		return quaterlyPBT;
	}
	public void setQuaterlyPBT(Float quaterlyPBT) {
		this.quaterlyPBT = quaterlyPBT;
	}
	public Float getQuaterlyNetProfit() {
		return quaterlyNetProfit;
	}
	public void setQuaterlyNetProfit(Float quaterlyNetProfit) {
		this.quaterlyNetProfit = quaterlyNetProfit;
	}
	public Float getQuaterlyEps() {
		return quaterlyEps;
	}
	public void setQuaterlyEPS(Float quaterlyEps) {
		this.quaterlyEps = quaterlyEps;
	}
	public String getCompanyName() {
		return CompanyName;
	}
	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}
	public Float getQuaterlyOPM_inPercent() {
		return quaterlyOPM_inPercent;
	}
	public void setQuaterlyOPM_inPercent(Float quaterlyOPM_inPercent) {
		this.quaterlyOPM_inPercent = quaterlyOPM_inPercent;
	}
	public Float getQuaterlyTax_inPercent() {
		return quaterlyTax_inPercent;
	}
	public void setQuaterlyTax_inPercent(Float quaterlyTax_inPercent) {
		this.quaterlyTax_inPercent = quaterlyTax_inPercent;
	}

}
