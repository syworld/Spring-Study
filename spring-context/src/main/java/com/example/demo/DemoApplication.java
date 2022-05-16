package com.example.demo;

import java.util.Arrays;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// SpringBoot에서 ComponentScan과 Configuration 설정 모두해주는 어노테이션
//@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
//		ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		String[] beanDefinitionNames = context.getBeanDefinitionNames();

		System.out.println(Arrays.toString(beanDefinitionNames));
		BookService bookService = (BookService) context.getBean("bookService");
		System.out.println(bookService.bookRepository != null);

	}

}
