package com.revature.business;

import org.springframework.stereotype.Component;

@Component
public class SessionInfo {
	
	private String user_id;
	private int institution_id;
	private String institution_name;
	private int network_id;
	private String network_name;
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getInstitution_id() {
		return institution_id;
	}
	public void setInstitution_id(int institution_id) {
		this.institution_id = institution_id;
	}
	public String getInstitution_name() {
		return institution_name;
	}
	public void setInstitution_name(String institution_name) {
		this.institution_name = institution_name;
	}
	public int getNetwork_id() {
		return network_id;
	}
	public void setNetwork_id(int network_id) {
		this.network_id = network_id;
	}
	public String getNetwork_name() {
		return network_name;
	}
	public void setNetwork_name(String network_name) {
		this.network_name = network_name;
	}
	
	

}
