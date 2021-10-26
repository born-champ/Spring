package com;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	@RequestMapping(value="empInfo", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee getEmployee() {
		Employee emp=new Employee(100,"Raj",12000);
		return emp;
	}
	
	@RequestMapping(value="employees", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> getAllEmployeeInfo(){
		List<Employee> listOfEmp=new ArrayList<>();
		listOfEmp.add(new Employee(1,"Ashu",12000));
		listOfEmp.add(new Employee(2,"Abhi",22000));
		return listOfEmp;
		
		
	}
	@RequestMapping(value="singleQuery", method= RequestMethod.GET)
	public String singleQuery(@RequestParam("name") String fname) {
		return "welcome"+fname;
	}
	
	@RequestMapping(value="multipleQuery", method= RequestMethod.GET)
	public String singleQuery(@RequestParam("name") String name, @RequestParam("pass") String pass) {
		if (name.equals("Raj")&&(pass.equals(123))) {
			return "success";
			
		} else {
			return "failure";
		}
		
	}
	
	@RequestMapping(value="singlePath/{name}", method= RequestMethod.GET)
	public String singlePath(@PathVariable("name") String name) {
		return "welcome"+name;
	}
	
	@RequestMapping(value="multiPath/{id}/{name}/{salary}", method= RequestMethod.GET)
	public String multiPath(@PathVariable("id") int id, @PathVariable("name") String name, @PathVariable("salary") float salary ) {
		return "welcome " +name+ " your Id is " +id+ " and your salary " +salary;
	}
	
	@RequestMapping(value="storeEmployees", method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	
	public String storeEmployeeInfo(@RequestBody Employee emp) {
		System.out.println(emp);
		return "stored";
		
		
	}
	
@RequestMapping(value="updateEmployees", method= RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	
	public String updateEmployeeInfo(@RequestBody Employee emp) {
		System.out.println(emp);
		return "updated";
		
		
	}


@RequestMapping(value="deleteEmployees/{id}", method= RequestMethod.DELETE)

public String deleteEmployeeInfo(@PathVariable("id") int id) {
	return "deleted Id is "+id ;
	
	
}
	

	
}
