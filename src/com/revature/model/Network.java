package com.revature.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="HIMS_networks")
public class Network {

	@Id
	@GeneratedValue
	private int network_id;
	
	@NotNull
	private String name;
	
	@OneToMany(mappedBy="network")
	private List<Client> clients;
	
	@OneToMany(mappedBy="network")
	private List<Institution> institutions;

	public int getNetwork_id() {
		return network_id;
	}

	public void setNetwork_id(int network_id) {
		this.network_id = network_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public List<Institution> getInstitutions() {
		return institutions;
	}

	public void setInstitutions(List<Institution> institutions) {
		this.institutions = institutions;
	}
	
	

}
