package com.jwt.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jwt.model.User;

@Controller
@RequestMapping(value = "/")
public class LoginController {

	@RequestMapping(value = "/")
	public String showPage() throws IOException {
//		System.out.println("login");
		return "login";
	}
	
	@RequestMapping(value = "/loginPage", method = RequestMethod.POST)
	public  String loginEmployee(@RequestBody User user, ModelAndView model,HttpServletResponse resp) throws IOException {
		try {
			System.out.println("login "+user.getUserName());
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/emp/";
//		model.setViewName("home");
//		return model;
	}
}
