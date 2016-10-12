package com.revature.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.model.Claim;
import com.revature.model.Client;
import com.revature.model.HIMSDao;

@Controller
@RequestMapping("/claim")
public class ClaimController {
	
	@Autowired
	private HIMSDao himsDaoImpl;

	
	@RequestMapping(value="/verify", method=RequestMethod.POST)
	public String verifyClient(@Valid Client client, BindingResult result) {
		if(result.hasErrors()) {
			return "claimForm";
		}else{
			try{
				client = himsDaoImpl.checkPolicy(client);
				if(client == null)
					return "error";
				else{
					return "success";
				}
					
			}catch(DataIntegrityViolationException ex){
				return "error";
			}
		}
	}
	
	// clicking on the submit button runs this method.
	// ContextRoot/claim/save
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String addClaim(@Valid Claim claim, BindingResult result){
		
		if(result.hasErrors()){
			return "claimForm";
		}else{
			try{
				himsDaoImpl.saveClaim(claim);
				return "success";
			}catch(DataIntegrityViolationException ex){
				return "error";
			}
		}
	}
	
	// Browsing to ContextRoot/claim causes this method to run.
	@RequestMapping(method=RequestMethod.GET)
	public String displayClaimForm(Model model){
		model.addAttribute("claim", new Claim());
		
		return "claimForm";
	}
	
	
}
