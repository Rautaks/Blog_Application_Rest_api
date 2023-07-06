package com.rest1.services;
import java.util.*;
import java.util.stream.Collectors;

import com.rest1.BookRepository.BookRepo;
import com.rest1.Entity.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class BookService {
	
//	private static  List<Book> list = new ArrayList<>();
//	
//	static {
//		
//		list.add(new Book(12, "java complete Reference", "qpr"));
//		list.add(new Book(13, "Python in complete Information", "xyz"));
//		list.add(new Book(14, "html, css study", "jwt"));
//	}
	
	@Autowired
	private BookRepo bookRepo;
	
	//getAllBooks
	public List<Book> getAllBooks()
	{
		List<Book> list = (List<Book>)this.bookRepo.findAll();
		return list;
	}
	
	//getSingleBook
	
	public Book getBookById(int id)
	{
		Book book = null;
		try {
		//book=list.stream().filter(e->e.getId()==id).findFirst().get();
			book = this.bookRepo.findById(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return book;
	}
	
	// Create book
	public Book addBook(Book b)
	{
		Book result = bookRepo.save(b);
		return result;
	}

	
	//Delete book by BookId
	public void deleteBook(int bookId) 
	{
	 //list=list.stream().filter(book->book.getId()!=bookId).collect(Collectors.toList());
		bookRepo.deleteById(bookId);
	}
	
	
    //update book
	public void updateBook(Book book, int bookId) {
		
		book.setId(bookId);
		bookRepo.save(book);
		
		
		
//		list = list.stream().map(b->
//		{
//			if(b.getId()==bookId)
//			{
//				b.setTitle(book.getTitle());
//				b.setAuther(book.getAuther());
//			}
//			return b;
//		}).collect(Collectors.toList());
		
		
	}
	
	
}

















