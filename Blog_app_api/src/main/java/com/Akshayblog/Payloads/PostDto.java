package com.Akshayblog.Payloads;

import java.sql.Date;
import java.util.Set;
import java.util.HashSet;

import com.Akshayblog.Entities.Comment;


public class PostDto {
	private Integer postId;
	private String title;
	private String content;
	//private String imageName("default.png");
	private String imageName;
    private Date addedDate;
	private CategoryDto category;
	private UserDto user;
	private Set<Comment> comments = new HashSet();
	
	public PostDto(Integer id, String title, String content, String imageName, Date addedDate, CategoryDto category, UserDto user) {
		super();
		this.postId = id;
		this.title = title;
		this.content = content;
		this.imageName = imageName;
		this.addedDate = addedDate;
		this.category = category;
		this.user = user;
	}
      
	
	public PostDto() {
		super();
		
	}
     
	public int getId() {
		return postId;
	}
	public void setId(Integer id) {
		this.postId = id;
	}
		
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	public CategoryDto getCategory() {
		return category;
	}

	public void setCategory(CategoryDto category) {
		this.category = category;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "PostDto [postId=" + postId + ", Title=" + title + ", content=" + content + ", imageName=" + imageName
				+ ", addedDate=" + addedDate + ", category=" + category + ", user=" + user + "]";
	}

	

}
