package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
		Employee emp=(Employee)ac.getBean("emp");
		System.out.println(emp);
		emp.setId(100);
		emp.setName("Shaan");
		emp.setSalary(1000);
		Address add =emp.getAdd();
		add.setCity("Mum");
		add.setState("Mah");
		emp.setAdd(add);
		System.out.println(emp);

	}

}
