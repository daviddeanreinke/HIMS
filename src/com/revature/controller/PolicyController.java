package com.revature.controller;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.model.HIMSDao;
import com.revature.model.PolicyPlan;

@Controller
@RequestMapping("/policy")
public class PolicyController {
	
	@Autowired
	private HIMSDao himsDaoImpl;
	
	// clicking on the submit button runs this method.
	// ContextRoot/blah/save
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String addClaim(@Valid PolicyPlan policy, BindingResult result){
		
		if(result.hasErrors()){
			return "policyForm";
		}else{
			try{
				himsDaoImpl.savePolicyPlan(policy);
				return "success";
			}catch(DataIntegrityViolationException ex){
				return "error";
			}
		}
	}
	
	// Browsing to ContextRoot/claim causes this method to run.
	@RequestMapping(method=RequestMethod.GET)
	public String displayPolicyForm(Model model){
		model.addAttribute("policy", new PolicyPlan());
		
		return "policyForm";
	}
	
	
}
