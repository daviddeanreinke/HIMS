package com.revature.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.revature.business.ClientInfo;
import com.revature.business.Delegate;

@Controller
@RequestMapping("/main")
public class MainController {
	
	@Autowired
	private Delegate delegate;
	
	@RequestMapping(method=RequestMethod.GET)
	public String displayMain(Model model, HttpSession session){
		System.out.println("main activated");
		//model.addAttribute("login", new Login());
		return "main";
	}
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public String displaySearch(Model model, HttpSession session){
		System.out.println("search activated");
		session.setAttribute("page", "search");
		model.addAttribute("clientInfo", new ClientInfo());
		return "main";
	}
	
	@RequestMapping(value="/searchPatient", method=RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.OK) 
	public String searchPatient(Model model, HttpSession session, ClientInfo clientInfo){
		
		// to do
		System.out.println("searchPatient activated");
		
		// use Business Delegate pattern
		//List<ClientInfo> cList = himsDaoImpl.searchPatient(clientInfo);
		List<ClientInfo> cList = delegate.searchPatient(clientInfo);
		
		session.setAttribute("page", "search");
		session.setAttribute("patientList", cList);
		return "main";
	}
	
	@RequestMapping(value="/claim", method=RequestMethod.GET)
	public String displayClaim(Model model, HttpSession session){
		System.out.println("search activated");
		session.setAttribute("page", "claim");
		//model.addAttribute("loginBean", new LoginBean());
		return "main";
	}
}
