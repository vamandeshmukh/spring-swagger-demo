package com.vamandeshmukh.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vamandeshmukh.demo.dtos.Book;

@Repository
public interface BookDao extends JpaRepository<Book, Long> {

	List<Book> findAll();

	void deleteById(Long id);

}
