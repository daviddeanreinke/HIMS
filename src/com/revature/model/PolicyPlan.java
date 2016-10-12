package com.revature.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import com.revature.model.Client;

@Entity
@Table(name="HIMS_policies")
public class PolicyPlan {
	
	@Id
	@NotNull
	private String policy_type;
	
	@DecimalMin(value="0.00")
	@Digits(integer=6, fraction=2)
	private BigDecimal premium;
	
	private String details;

	@OneToMany(mappedBy="policyPlan")
	private List<Client> clients;

	public String getPolicy_type() {
		return policy_type;
	}

	public void setPolicy_type(String policy_type) {
		this.policy_type = policy_type;
	}

	public BigDecimal getPremium() {
		return premium;
	}

	public void setPremium(BigDecimal premium) {
		this.premium = premium;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}


	
	
}
