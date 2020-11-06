package com.vamandeshmukh.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vamandeshmukh.demo.dao.BookDao;
import com.vamandeshmukh.demo.dtos.Book;

@Service
public class BookService {

	@Autowired
	private BookDao library;

	public List<Book> getAllbooks() {
		System.out.println("Books...");
		return library.findAll();
	}

	public Book getBookById(Long id) {
		System.out.println("Book");
		return library.findById(id).get();
	}

	public Book addBook(Book book) {
		System.out.println("Book added.");
		return library.save(book);

	}

	public Book updateBook(Long id, Book book) {
		System.out.println("Book updated.");

		Optional<Book> repBook = library.findById(id);

		if (repBook.isPresent()) {

			Book bookToBeUpdated = repBook.get();
			bookToBeUpdated.setAvailableCopies(book.getAvailableCopies());
			bookToBeUpdated.setTotalCopies(book.getTotalCopies());
			bookToBeUpdated.setAuthor(book.getAuthor());
			bookToBeUpdated.setCategory(book.getCategory());
			bookToBeUpdated.setPrice(book.getPrice());
			bookToBeUpdated.setPublishYear(book.getPublishYear());

			return library.save(bookToBeUpdated);

		}

		return null;
	}

	public String removeBook(Long bookId) {
		System.out.println("Book removed.");

		library.deleteById(bookId);
		return "Book deleted Sucessfully";
	}

}
