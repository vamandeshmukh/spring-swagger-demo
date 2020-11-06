package com.vamandeshmukh.demo;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.vamandeshmukh.demo.dtos.Book;
import com.vamandeshmukh.demo.service.BookService;

@SpringBootApplication
@ComponentScan(basePackages = "com.vamandeshmukh.demo")
@EnableCaching
public class SpringbootjpaApplication {

	@Autowired
	private BookService bookService;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootjpaApplication.class, args);
	}

	@Bean
	InitializingBean sendDatabase() {
		return () -> {
			bookService.addBook(new Book("The Power of your Subconscious Mind", 296, "Joseph Murphy", "self-help",
					2015, 50, "http://localhost:3006/assets/books/SELF-HELP-0001.jpg"));
			bookService.addBook(new Book("Great Gatsby", 240, "F. Scott Fitzgerald", "literature", 1939, 8,
					"http://localhost:3006/assets/books/LITERATURE-0002.jpg"));
			bookService.addBook(new Book("The Alchemist", 50, "Paulo Coelho", "novel", 1990, 9,
					"http://localhost:3006/assets/books/NOVEL-0003.jpg"));
			bookService.addBook(new Book("Data Smart", 624, "Foreman, John", "data-science", 2012, 12,
					"http://localhost:3006/assets/books/DATA-SCIENCE-0005.jpg"));
			bookService.addBook(new Book("God Created the Integers", 114, "Hawking, Stephen", "mathematics", 2006,
					50, "http://localhost:3006/assets/books/MATHEMATICS-0006.jpg"));
		};
	}

}
