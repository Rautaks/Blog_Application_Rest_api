package com.Akshayblog.Services;

import java.util.List;

import org.springframework.stereotype.Service;


import com.Akshayblog.Payloads.PostDto;
import com.Akshayblog.Payloads.PostResponse;
@Service
public interface PostService {
	
	//create
	PostDto createPost(PostDto postDto);
	
	//update
	PostDto updatePost(PostDto postdto,Integer postId, Integer userId, Integer categoryId);
	
	//Delete
	void deletePost(Integer postId);
	
	//get AllPost
	PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);
	
	//Get Single Post
	PostDto getPostById(Integer postId);
	
	//Get all post of category
	List<PostDto> getPostByCategory(Integer categoryId);
	
	//Get All post by user
	List<PostDto> getPostByUser(Integer userId);
	
    //Search Post
	List<PostDto> searchPost(String keyword);
	

	PostDto createPost(PostDto postDto, Integer postId, Integer userId, Integer categoryId);

	PostDto updatePost(PostDto postdto, Integer postId);	

}






