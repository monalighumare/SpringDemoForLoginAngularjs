package com.jwt.dao;

import java.math.BigDecimal;
import java.util.List;

import com.jwt.bean.ResponseBean;
import com.jwt.model.Employee;

public interface EmployeeDAO {

	public ResponseBean addEmployee(Employee employee);

	public List<Employee> getAllEmployees();

	public void deleteEmployee(BigDecimal employeeId);

	public ResponseBean updateEmployee(Employee employee);

	public Employee getEmployee(BigDecimal employeeid);

	public Employee getEmployee(String empName);

	public Employee getAllEmployeesWithJoin();
}
