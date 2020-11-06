package com.vamandeshmukh.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import com.vamandeshmukh.demo.controllers.BookController;

@ExtendWith(MockitoExtension.class)
public class BookControllerTest {

	private MockMvc mockMvc;

	@InjectMocks
	BookController bookController;

	@Test
	public void testHi() {
		System.out.println("testHi");
		assertThat(bookController.hi()).contains("Hi!");
	}

	@Test
	public void testGetBookById() throws Exception {
		System.out.println("testGetBookById");
		assertThat(bookController.hi()).contains("Hi!");

	}

}