package com.vamandeshmukh.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vamandeshmukh.demo.dtos.Book;
import com.vamandeshmukh.demo.service.BookService;

//connect from postman as http://localhost:8080/books/
@Controller
@RequestMapping("/books")
public class BookController {

	@GetMapping("/hi")
	public String hi() {
		return "Hi!";
	}

	@Autowired
	private BookService bookService;

	@GetMapping(value = { "/" })
	public @ResponseBody List<Book> getLibraryBooks() {

		List<Book> books = bookService.getAllbooks();

		return books;
	}

	@GetMapping("/{id}")
	public @ResponseBody Book getBookById(@PathVariable Long id) {

		return bookService.getBookById(id);
	}

	@PostMapping("/")
	public @ResponseBody Book addBook(@RequestBody Book book) {
		return bookService.addBook(book);
	}

	@PutMapping("/{id}")
	public @ResponseBody Book updateBook(@PathVariable Long id, @RequestBody Book book) {

		return bookService.updateBook(id, book);
	}

	@DeleteMapping("/{id}")
	public @ResponseBody String removeBook(@PathVariable Long id) {
		return bookService.removeBook(id);
	}

}
