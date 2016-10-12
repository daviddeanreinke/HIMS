package com.revature.controller;


import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.model.Client;
import com.revature.model.HIMSDao;

@Controller
@RequestMapping("/client")
public class ClientController {
	
	@Autowired
	private HIMSDao himsDaoImpl;

	
	// clicking on the submit button runs this method.
	// ContextRoot/claim/save
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveClaim(@Valid Client client, BindingResult result){
		
		if(result.hasErrors()){
			return "clientForm";
		}else{
			try{
				System.out.println("ClientController-saveClaim-ep date: " + client.getExpiration_date());
				himsDaoImpl.saveClient(client);
				return "success";
			}catch(DataIntegrityViolationException ex){
				return "error";
			}
		}
	}
	
	// Browsing to ContextRoot/client causes this method to run.
	@RequestMapping(method=RequestMethod.GET)
	public String displayClaimForm(Model model){
		model.addAttribute("client", new Client());
		
		return "clientForm";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		System.out.println("entered initBinder");
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    sdf.setLenient(true);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
	
}
