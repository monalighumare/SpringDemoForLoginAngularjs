package com.jwt.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.jwt.bean.ResponseBean;
import com.jwt.model.Employee;
import com.jwt.model.User;
import com.jwt.service.EmployeeService;

@Controller
//@RequestMapping(value = "/emp")
public class EmployeeController {
			
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value = "/emp")
	public ModelAndView showPage(ModelAndView model) throws IOException {
		System.out.println("/emp");
		model.setViewName("home");
		return model;
//		return "home";
	}
		
	
	//@CrossOrigin(origins = "*")
	@RequestMapping(value = "/employee")
	public  void  listEmployee(ModelAndView model,HttpServletResponse resp) throws IOException {
		List<Employee> listEmployee = employeeService.getAllEmployees();
		System.out.println(listEmployee.get(0).getName());
		model.addObject("listEmployee", listEmployee);
		model.setViewName("home");
	    resp.getWriter().write(new Gson().toJson(listEmployee));
	}
	


	@RequestMapping(value = "/newEmployee", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) {
		Employee employee = new Employee();
		model.addObject("employee", employee);
		model.setViewName("EmployeeForm");
		return model;
	}

	//@CrossOrigin(origins = "*")
	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	public void saveEmployee(@RequestBody Employee employee,HttpServletResponse response) throws IOException {
		try {
			ResponseBean bean =null;
			System.out.println(employee.getId()+" name "+employee.getName());
			if (employee.getId() ==null || employee.getId().compareTo(BigDecimal.ZERO) == 0 ) { // if employee id is 0 then creating the
				// employee other updating the employee
				bean =employeeService.addEmployee(employee);
			} else {
				bean = employeeService.updateEmployee(employee);
			}
			response.getWriter().write(new Gson().toJson(bean));

		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET)
	public void deleteEmployee(Employee employee,HttpServletRequest request,HttpServletResponse resp) throws IOException {
		System.out.println(employee.getId());
		employeeService.deleteEmployee(employee.getId());
		resp.getWriter().write("deleted");
	}

	//@CrossOrigin(origins = "*")
	@RequestMapping(value = "/editEmployee", method = RequestMethod.GET)
	public void editContact(Employee employee,HttpServletRequest request,HttpServletResponse resp) throws IOException {
		Employee employee1 = employeeService.getEmployee(employee.getId());
		ModelAndView model = new ModelAndView("EmployeeForm");
		model.addObject("employee", employee1);
		resp.getWriter().write(new Gson().toJson(employee1));
	}

}