package com.Akshayblog.Entities;
import java.sql.Date;
import java.util.Optional;
import java.util.Set;
import java.util.HashSet;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name="post1")

public class Post {
	
	public Post(Integer id, String title, String content, String imageName, Date addedDate, Category category,
			User user) {
		super();
		this.postId = id;
		this.title = title;
		this.content = content;
		this.imageName = imageName;
		this.addedDate = addedDate;
		this.category = category;
		this.user = user;
	}
	public Post() {
		super();
		
	}
	public Integer getPostId() {
		return postId;
	}
	public void setPostId(Integer id) {
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
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	@Override
	public String toString() {
		return "Post [postId=" + postId + ", title=" + title + ", content=" + content + ", imageName=" + imageName
				+ ", addedDate=" + addedDate + ", category=" + category + ", user=" + user + "]";
	}



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Post_id", length=100, nullable=false)
	private Integer postId;
	private String title;
	
	@Column(length=1000)
	private String content;
	
	private String imageName;
	private Date addedDate;
	
	@ManyToOne
	private Category category;
	@ManyToOne
	private User user;
	
	public static Optional<User> stream() {
		
		return null;
	}
	
	@OneToMany(mappedBy = "post", cascade= CascadeType.ALL)
	private Set<Comment> comments = new HashSet<>();
	
	

}
