package com.rest1.BookRepository;


import org.springframework.data.repository.CrudRepository;
import com.rest1.Entity.Book;

public interface BookRepo extends CrudRepository<Book, Integer> {
	
	public Book findById(int id);

}
