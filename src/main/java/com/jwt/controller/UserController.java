package com.jwt.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jwt.service.EmployeeService;


@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	
	private static final Logger logger = Logger
			.getLogger(EmployeeController.class);
	@Autowired
	private EmployeeService empService;
	
	
//	@RequestMapping(value = "/")
//	public String showPage() throws IOException {
//		return "login";
//	}
	
	@RequestMapping(value = "/login")
	public ModelAndView validateLogin(HttpServletRequest request) throws IOException {
		String name=request.getParameter("name");
		System.out.println("UserController()"+name);
//		Map<String, Object> model = new HashMap<String, Object>();
		empService.getEmployee(name);
		return new ModelAndView("welcome");
		
		
//		return "welcome";
	}
	
	@RequestMapping(value = "/welcome")
	public String showPageWelcome() throws IOException {
//		model.setViewName("login");
		return "welcome";
	}
}
