package com.capgemini.assignment1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Customer customer = (Customer)context.getBean("customer");
		Customer customer1 = (Customer)context.getBean("customer1");
		customer.getDetails();
		customer1.getDetails();

	}

}
