package com.Akshayblog.Services.impl;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
//import org.modelmapper.internal.bytebuddy.asm.Advice.OffsetMapping.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import com.Akshayblog.Entities.Category;
import com.Akshayblog.Entities.Post;
import com.Akshayblog.Entities.User;
import com.Akshayblog.Exception.ResourceNotFoundException;
import com.Akshayblog.Payloads.PostDto;
import com.Akshayblog.Payloads.PostResponse;
import com.Akshayblog.Repositories.CategoryRepo;
import com.Akshayblog.Repositories.PostRepo;
import com.Akshayblog.Repositories.UserRepo;
import com.Akshayblog.Services.FileService;
import com.Akshayblog.Services.PostService;

//import jakarta.persistence.PostRemove;
@Service
@RestController
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;
	
//	@Autowired
//	private FileService fileService;
	
	//Create PostImpl
	@Override
	public PostDto createPost(PostDto postDto, Integer postId, Integer userId, Integer categoryId) {
		

		User user = this.userRepo.findById(userId)
				.orElseThrow(()->new ResourceNotFoundException("User", "UserId",userId));
		
		Category category = this.categoryRepo.findById(categoryId)
				.orElseThrow(()-> new ResourceNotFoundException("Category", "CategoryId", categoryId));
				
		Post post = this.modelMapper.map(postDto,  Post.class);
		post.setImageName("Default.png");
		post.setAddedDate(new Date(0));
		post.setUser(user);
		post.setCategory(category);
		
		Post newPost=this.postRepo.save(post);
		return this.modelMapper.map(newPost, PostDto.class);
	}
	
	//Update PostImpl

	@Override
	public PostDto updatePost(PostDto postDto, Integer postId) {
		Post post=	this.postRepo.findById(postId)
				.orElseThrow(()->new ResourceNotFoundException("Post", "PostID", postId));
		
		post.setTitle(postDto.getTitle());
		post.setContent(postDto.getContent());
		post.setImageName(postDto.getImageName());
		Post updatePost = this.postRepo.save(post);
		return this.modelMapper.map(updatePost, PostDto.class);
	}
    
	//Delete PostImpl
	@Override
	public void deletePost(Integer postId) {
	Post post=	this.postRepo.findById(postId)
		.orElseThrow(()->new ResourceNotFoundException("Post", "PostID", postId));
		this.postRepo.delete(post);
	}

	//GetAllPostImpl
	@Override
	public PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy,  String sortDir) {
		
		Sort sort=null;
		if(sortDir.equalsIgnoreCase("asc"))
		{
			sort= Sort.by(sortBy).ascending();
		}
		else
		{
			sort = Sort.by(sortBy).descending();
		}
		
		PageRequest p = PageRequest.of(pageNumber, pageSize, sort);
		
		Page<Post> pagePost= this.postRepo.findAll(p);
		
		List<Post> allPost = pagePost.getContent();
		
		List<PostDto>postDto=allPost.stream().map((post)->this
				.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		
		PostResponse postResponse = new PostResponse();
		postResponse.setContent(postDto);
		postResponse.setPageNumber(pagePost.getNumber());
		postResponse.setPageSizee(pagePost.getSize());
		postResponse.setTotalElement(pagePost.getTotalElements());
		postResponse.setTotalPages(pagePost.getTotalPages());
		postResponse.setLastPage(pagePost.isLast());
		
		return postResponse;
	}
     
	// GetPostBy Id
	@Override
	public PostDto getPostById(Integer postId) {
		Post posts=this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post", "PostId", postId));
		return this.modelMapper.map(posts, PostDto.class) ;
	}

	 //Get Post By Category
	@Override
	public List<PostDto> getPostByCategory(Integer categoryId) {
		
		Category cat = this.categoryRepo.findById(categoryId)
				.orElseThrow(()-> new ResourceNotFoundException("Category", "CategoryId", categoryId));
		List<Post> posts=  this.postRepo.findByCategory(cat);
		
		List<PostDto> postDto =posts.stream().map((post) -> this
				.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		return postDto;
	}
   
	 //GetPost By User
	@Override
	public List<PostDto> getPostByUser(Integer userId) {
		User user= userRepo.findById(userId)
				.orElseThrow(()->new ResourceNotFoundException("User", "UserId", userId));
		List<Post> posts= this.postRepo.findByUser(user);
		
		List<PostDto> postDto  = posts.stream().map((post)->this
				.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		return postDto;
	}
	//search post
	@Override
	public List<PostDto> searchPost(String keyword) {
	    List<Post> posts= this.postRepo.searchByTitle("%"+keyword+"%");
	    List<PostDto> postDtos = posts.stream().map((post)->this.modelMapper
	    		.map(post, PostDto.class)).collect(Collectors.toList());
		return postDtos;
	}

	@Override
	public PostDto createPost(PostDto postDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostDto updatePost(PostDto postdto, Integer postId, Integer userId, Integer categoryId) {
		// TODO Auto-generated method stub
		return null;

	}
}
