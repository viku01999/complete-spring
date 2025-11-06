package com.example.springcore;

import org.springframework.stereotype.Component;

//public class Book {
//	
//	private String title;
//	private String author;
//	
//	
//	public void setTitle(String title) {
//		this.title = title;
//	}
//	
//	public void setAuthor(String author) {
//		this.author = author;	
//	}
//	
//	public String getInfo() {
//		return "Book: " + title + " | Auther: " + author;
//	}
//	
//}


@Component("book1") //spring will manage this bean
public class Book {
	
    private String title = "Spring in Action";
    private String author = "Craig Walls";
	
	
	public String getInfo() {
		return "Book: " + title + " | Auther: " + author;
	}
	
}