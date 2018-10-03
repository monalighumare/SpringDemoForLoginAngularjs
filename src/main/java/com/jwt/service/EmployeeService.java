package com.jwt.service;

import java.math.BigDecimal;
import java.util.List;

import com.jwt.bean.ResponseBean;
import com.jwt.model.Employee;

public interface EmployeeService {
	
	public ResponseBean addEmployee(Employee employee);

	public List<Employee> getAllEmployees();

	public void deleteEmployee(BigDecimal employeeId);

	public Employee getEmployee(BigDecimal employeeid);
	
	public Employee getEmployee(String empName);
	
	public ResponseBean updateEmployee(Employee employee);

	public Employee getAllEmployeesWithJoin();
}
