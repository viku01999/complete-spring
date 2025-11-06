package com.example.springcore;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//public class App {
//	public static void main(String[] args) {
//		
//		//load sppring ioc container
//		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//		
//		
//		Library library = (Library) context.getBean("library");
//		
//		library.printAllBooks();
//		
//	}
//}

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		Library library = context.getBean(Library.class);
		library.printAllBooks();
	}
}