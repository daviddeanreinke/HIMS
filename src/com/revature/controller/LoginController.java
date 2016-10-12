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
import com.revature.model.HIMSDao;
import com.revature.model.Login;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private HIMSDao himsDaoImpl;
	
	@RequestMapping(method=RequestMethod.GET)
	public String displayLoginForm(Model model){
		System.out.println("displayLogin activated");
		model.addAttribute("login", new Login());
		return "loginForm";
	}
	
	// clicking on the submit button runs this method.
	// ContextRoot/claim/save
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveLogin(@Valid Login login, BindingResult result){
		
		if(result.hasErrors()){
			return "loginForm";
		}else{
			try{
				System.out.println("LoginController-savelogin-user id: " + login.getUserid());
				himsDaoImpl.saveLogin(login);
				return "success";
			}catch(DataIntegrityViolationException ex){
				return "error";
			}
		}
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@Valid LoginBean loginBean, BindingResult result, HttpSession session){
		if(result.hasErrors()){
			return "loginForm";
		}else{
			try{
				System.out.println("LoginCOntroller-login-user id: "+loginBean.getUsername());
				if(himsDaoImpl.userLogin(loginBean) != null){
					//login success.. now fill out the sessionInfo and add to session
					// perhaps change the DaoImpl to return the sessionInfo object and check if it is null
					// navigate to main page here but for now
					return "success";
				}else{
					//login failed
					return "loginForm";
				}	
			}catch(DataIntegrityViolationException ex){
				return "error";
			}
		}
	}
	
}
