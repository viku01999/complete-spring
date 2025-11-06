package com.example.springcore;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//public class Library {
//
//	private List<Book> books;
//
//	// constructor injection
//	public Library(List<Book> books) {
//		this.books = books;
//	}
//
//	// setter injection
////	public void setBooks(List<Book> books) {
////		this.books = books;
////	}
//
//	public void printAllBooks() {
//		for (Book book : books) {
//			System.out.println(book.getInfo());
//		}
//	}
//
//}

@Component
public class Library {

	private List<Book> books;

	@Autowired
	public Library(List<Book> books) {
		this.books = books;
	}

	public void printAllBooks() {
		for (Book book : books) {
			System.out.println(book.getInfo());
		}
	}

}

