package com.revature.model;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="HIMS_claims")
public class Claim {
	// @SequenceGenerator(name="seq", initialValue=1, allocationSize=100)
    //@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
	@Id
	@GeneratedValue
	private int claim_id;
	
	//@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date claim_date;
	
	@DecimalMin(value="0.00")
	@Digits(integer=6, fraction=2)
	private BigDecimal claim_amount;
	
	@DecimalMin(value="0.00")
	@Digits(integer=6, fraction=2)
	private BigDecimal covered_amount;
	
	private String status;
	
	private String details;
	
	@ManyToOne 
	@JoinColumn(name="policy_number")
	private Client client;
	
	@ManyToOne
	@JoinColumn(name="institution_id")
	private Institution institution;

	public int getClaim_id() {
		return claim_id;
	}

	public void setClaim_id(int claim_id) {
		this.claim_id = claim_id;
	}

	public Date getClaim_date() {
		return claim_date;
	}

	public void setClaim_date(Date claim_date) {
		this.claim_date = claim_date;
	}

	public BigDecimal getClaim_amount() {
		return claim_amount;
	}

	public void setClaim_amount(BigDecimal claim_amount) {
		this.claim_amount = claim_amount;
	}

	public BigDecimal getCovered_amount() {
		return covered_amount;
	}

	public void setCovered_amount(BigDecimal covered_amount) {
		this.covered_amount = covered_amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Institution getInstitution() {
		return institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	
}
