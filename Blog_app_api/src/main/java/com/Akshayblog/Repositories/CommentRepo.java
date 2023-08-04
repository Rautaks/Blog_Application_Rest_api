package com.Akshayblog.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Akshayblog.Entities .Comment ;

public interface CommentRepo extends JpaRepository<Comment, Integer> {
	
	

}
