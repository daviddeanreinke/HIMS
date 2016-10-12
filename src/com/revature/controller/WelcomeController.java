package com.revature.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.business.LoginBean;
import com.revature.business.SessionInfo;
import com.revature.model.HIMSDao;


@Controller
@RequestMapping("/welcome")
public class WelcomeController {

	@Autowired
	private HIMSDao himsDaoImpl;
	
	@RequestMapping(method=RequestMethod.GET)
	public String displayWelcome(Model model){
		System.out.println("displayWelcome activated");
		model.addAttribute("loginBean", new LoginBean());
		return "welcome";
	}

	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@Valid LoginBean loginBean, BindingResult result, HttpSession session){
		System.out.println("login entered");
		if(result.hasErrors()){
			return "welcome";
		}else{
			try{
				System.out.println("WelcomeController-login-user id: "+loginBean.getUsername());
				SessionInfo sessionInfo = himsDaoImpl.userLogin(loginBean);
				if(sessionInfo != null){
					//login successful
					session.setAttribute("sessionInfo", sessionInfo);
					session.setAttribute("page", "terms");
					return "main";
				}else{
					//login failed
					return "welcome";
				}	
			}catch(DataIntegrityViolationException ex){
				return "error";
			}
		}
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(Model model, HttpSession session){
		System.out.print("logout entered");
		model.addAttribute("loginBean", new LoginBean());
		session.invalidate();
		return "welcome";
	}
	
	@RequestMapping(value="/about", method=RequestMethod.GET)
	public String displayAbout(Model model, HttpSession session){
		System.out.println("about activated");
		session.setAttribute("page", "about");
		//model.addAttribute("loginBean", new LoginBean());
		return "main";
	}
	
	@RequestMapping(value="/terms", method=RequestMethod.GET)
	public String displayTerms(Model model, HttpSession session){
		System.out.println("terms activated");
		session.setAttribute("page", "terms");
		//model.addAttribute("loginBean", new LoginBean());
		return "main";
	}
}
