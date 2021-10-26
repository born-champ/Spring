package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Employee;
import com.dao.EmployeeDao;

@Service
public class EmployeeService {

	@Autowired
	EmployeeDao employeeDao;
	
	public List<Employee> getAllEmployee() {
		return employeeDao.getAllEmployee();
	}
	
	
	public String storeEmployee(Employee emp) {
		if (employeeDao.storeEmployeeRecord(emp)) {
			return "Stored";
		} else {
			return "didn't store";

		}
	}
	
	public String updateEmployee(Employee emp) {
		if (employeeDao.updateEmployeeRecord(emp)>0) {
			return "Updated";
		} else {
			return "didn't update";

		}
	}
	
	public String deleteEmployee(int id) {
		if (employeeDao.deleteEmployeeRecord(id)>0) {
			return "Deleted";
		} else {
			return "didn't delete";

		}
	}
}