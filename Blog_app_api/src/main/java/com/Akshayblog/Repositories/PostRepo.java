package com.Akshayblog.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Akshayblog.Entities.Category;
import com.Akshayblog.Entities.Post;
import com.Akshayblog.Entities.User;

import jakarta.transaction.Transactional;

public interface PostRepo extends JpaRepository<Post, Integer> {
	
	List<Post> findByUser(User user);
	List<Post> findByCategory(Category cat);
	
	@Transactional
	@Modifying
	//@Query("from ShippingDocumentsJsonEntity e where e.fulfillmentId in ?1")
	
	@Query("select p FROM Post p WHERE p.title like : keyword")
    List<Post> searchByTitile(@Param("keyword") String title);
	Post save(Post posts);
	
	List<Post> searchByTitle(String string);
	
	
	
}



