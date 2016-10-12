package com.revature.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Client;
import com.revature.model.HIMSDao;

@Service
public class Delegate {
	
	@Autowired
	private HIMSDao himsDaoImpl;
	
	@Autowired
	private ClientInfo clientInfo;

	public ClientInfo getClientInfo(String clientID) {
		Client c = himsDaoImpl.getClient(clientID);
		clientInfo.setClientID(clientID);
		clientInfo.setFirstname(c.getFirstname());
		clientInfo.setLastname(c.getLastname());
		clientInfo.setNetworkID(c.getNetwork().getNetwork_id());
		clientInfo.setPolicyType(c.getPolicyPlan().getPolicy_type());
		clientInfo.setCovered(c.isActive());
		return clientInfo;
	}

	public List<ClientInfo> searchPatient(ClientInfo clientInfo2) {
		List<ClientInfo> cList = himsDaoImpl.searchPatient(clientInfo2);
		return cList;
	}
	
	
}
