package com.jwt.dao;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
//import java.util.Map;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jwt.bean.ResponseBean;
import com.jwt.model.Employee;
import com.jwt.model.User;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public ResponseBean addEmployee(Employee employee) {
		sessionFactory.getCurrentSession().saveOrUpdate(employee);
//		List<ResponseBean> list = new ArrayList<ResponseBean>();
		ResponseBean bean = new ResponseBean();
		bean.setStatus("Success");
		bean.setDescription("saved successfully");
//		list.add(bean);
		return bean;
	}

	
	@Override
	public Employee getAllEmployeesWithJoin() {
		List<User> arrUser = new ArrayList<User>();
		List<Employee> arremp = new ArrayList<>();
		Employee obj = new Employee();
		
		Query query = sessionFactory.getCurrentSession().createSQLQuery("getEmployeeList");
		
		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List<Map<String,Object>> empInfo = query.list();
//		System.out.println(empInfo.get(0).get("empname"));;
//		for(int i=0;i<empInfo.size();i++) {
//			System.out.println("empInfo "+empInfo.get(i));
//			
//		}
		for(Map<String,Object> rs : empInfo) {
			User userObj = new User();
			Employee empObj = new Employee();
			
			System.out.println(rs.get("empname"));
			empObj.setId( (BigDecimal) rs.get("empid"));
			empObj.setName((String) rs.get("empname"));
			empObj.setAddress((String) rs.get("empaddress"));
			
			arrUser.add(userObj);
			arremp.add(empObj);
		}
		obj.setEmployeeList(arremp);
		obj.setUserList(arrUser);
		return obj;
	}

	@Override
	public List<Employee> getAllEmployees() {
		Query query = sessionFactory.getCurrentSession().createSQLQuery("getEmployeeList")
//				Query query = sessionFactory.getCurrentSession().createSQLQuery("getEmployeeList :empid,:empAge")
				.addEntity(Employee.class);
//				.setParameter("empid",1)
//				.setParameter("empAge",23);
		List<Employee> allEmployees = query.list();
		return allEmployees;
	}
	

	@Override
	public void deleteEmployee(BigDecimal employeeId) {
		Employee employee = (Employee) sessionFactory.getCurrentSession().load(
				Employee.class, employeeId);
		if (null != employee) {
			this.sessionFactory.getCurrentSession().delete(employee);
		}

	}

	public Employee getEmployee(BigDecimal empid) {
		return (Employee) sessionFactory.getCurrentSession().get(
				Employee.class, empid);
	}
	
	@Override
	public Employee getEmployee(String empName) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public ResponseBean updateEmployee(Employee employee) {
		sessionFactory.getCurrentSession().update(employee);
//		List<ResponseBean> list = new ArrayList<ResponseBean>();
		ResponseBean bean = new ResponseBean();
		bean.setStatus("Success");
		bean.setDescription("saved successfully");
//		list.add(bean);
		return bean;
	}


	
}