package com.jwt.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jwt.bean.ResponseBean;
import com.jwt.dao.EmployeeDAO;
import com.jwt.model.Employee;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	@Transactional
	public ResponseBean addEmployee(Employee employee) {
		ResponseBean bean= employeeDAO.addEmployee(employee);
		return bean;
	}

	@Override
	@Transactional
	public List<Employee> getAllEmployees() {
		return employeeDAO.getAllEmployees();
	}
	
	@Override
	@Transactional
	public Employee getAllEmployeesWithJoin() {
		return employeeDAO.getAllEmployeesWithJoin();
	}
//	
	@Override
	@Transactional
	public void deleteEmployee(BigDecimal employeeId) {
		employeeDAO.deleteEmployee(employeeId);
	}

	public Employee getEmployee(BigDecimal empid) {
		return employeeDAO.getEmployee(empid);
	}

	public ResponseBean updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		ResponseBean list = employeeDAO.updateEmployee(employee);
		 return list;
	} 

	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	@Override
	public Employee getEmployee(String empName) {
		return employeeDAO.getEmployee(empName);
	}

	

}
