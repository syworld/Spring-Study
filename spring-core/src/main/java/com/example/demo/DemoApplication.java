package com.example.demo;

import java.util.Arrays;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
		String[] beanDefinitionNames = context.getBeanDefinitionNames();

		System.out.println(Arrays.toString(beanDefinitionNames));
		BookService bookService = (BookService) context.getBean("bookService");
		System.out.println(bookService.bookRepository != null);

	}

}
