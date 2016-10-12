package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.business.ClientInfo;
import com.revature.business.Delegate;
import com.revature.model.Client;

@RestController
@RequestMapping("/coverage")
public class RestClaimController {
	
	@Autowired
	private Delegate delegate;
	
	@Autowired
	private ClientInfo clientInfo;
	
	@RequestMapping(value="/byclientid/{clientID}", method=RequestMethod.GET)
	public ClientInfo checkCoverageById(@PathVariable String clientID){
		if(clientID == null) return null;
		return delegate.getClientInfo(clientID);
	}
	
	
}
