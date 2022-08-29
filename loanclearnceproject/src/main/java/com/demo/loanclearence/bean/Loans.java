package com.demo.loanclearence.bean;

/*
 * @author : Sravana Kumar B
 * @date : 25-08-2022
 */

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LOANS_TBL")
public class Loans {

	@Id
	@GeneratedValue(generator = "LOANS_SEQ")
	@Column(name = "LOAN_ID" , nullable = false)
	private Long id;

	@Column(name = "LOAN_NAME", nullable = false)
	private String loanName;
	@Column(name = "LOAN_AMOUNT", nullable = false)
	private String loanAmount;
	@Column(name = "ENV_PORT", nullable = false)
	private String environment;
	@Column(name = "START_DATE", nullable = false)
	private String startDate;
	@Column(name = "TENURE", nullable = false)
	private String tenure;
	@Column(name = "YR_MO", nullable = false)
	private String yrmo;
	@Column(name = "INTERST_RATE", nullable = false)
	private String interstrate;
	@Column(name = "LOAN_VENDOR", nullable = false)
	private String loanvendor;
	@Column(name = "TYPE_OF_LOAN", nullable = false)
	private String typeofloan;
	@Column(name="TRANS_DATE", nullable = false)
	private Date transDate;
	

	public Loans() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Loans( String loanName, String loanAmount, String environment, String startDate, String tenure,
			String yrmo, String interstrate, String loanvendor, String typeofloan, Date transDate) {
		
		super();
		this.loanName = loanName;
		this.loanAmount = loanAmount;
		this.environment = environment;
		this.startDate = startDate;
		this.tenure = tenure;
		this.yrmo = yrmo;
		this.interstrate = interstrate;
		this.loanvendor = loanvendor;
		this.typeofloan = typeofloan;
		this.transDate = transDate;
		
	}



	public Date getTransDate() {
		return transDate;
	}
	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}
	public String getEnvironment() {
		return environment;
	}
	public void setEnvironment(String environment) {
		this.environment = environment;
	}
	public String getLoanName() {
		return loanName;
	}
	public void setLoanName(String loanName) {
		this.loanName = loanName;
	}
	public String getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(String loanAmount) {
		this.loanAmount = loanAmount;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getTenure() {
		return tenure;
	}
	public void setTenure(String tenure) {
		this.tenure = tenure;
	}
	public String getYrmo() {
		return yrmo;
	}
	public void setYrmo(String yrmo) {
		this.yrmo = yrmo;
	}
	public String getInterstrate() {
		return interstrate;
	}
	public void setInterstrate(String interstrate) {
		this.interstrate = interstrate;
	}
	public String getLoanvendor() {
		return loanvendor;
	}
	public void setLoanvendor(String loanvendor) {
		this.loanvendor = loanvendor;
	}
	public String getTypeofloan() {
		return typeofloan;
	}
	public void setTypeofloan(String typeofloan) {
		this.typeofloan = typeofloan;
	}



	@Override
	public String toString() {
		return "Loans [id=" + id + ", loanName=" + loanName + ", loanAmount=" + loanAmount + ", environment="
				+ environment + ", startDate=" + startDate + ", tenure=" + tenure + ", yrmo=" + yrmo + ", interstrate="
				+ interstrate + ", loanvendor=" + loanvendor + ", typeofloan=" + typeofloan + ", transDate=" + transDate
				+ "]";
	}

	
}
