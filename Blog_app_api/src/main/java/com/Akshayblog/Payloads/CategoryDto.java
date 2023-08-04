package com.Akshayblog.Payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public class CategoryDto {
	
	
	public CategoryDto(Integer categoryId, String categoryTitle, String categoryDescription) {
		super();
		this.categoryId = categoryId;
		this.categoryTitle = categoryTitle;
		this.categoryDescription = categoryDescription;
	}
	public CategoryDto() {
		super();
		
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryTitle() {
		return categoryTitle;
	}
	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}
	public String getCategoryDescription() {
		return categoryDescription;
	}
	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}
	
	
	private Integer categoryId;
	@NotBlank
	@Size(min=4, message="Minimum size is of title getter than 4")
	private String categoryTitle;
	@NotBlank
	@Size(min=10, message="Minimum Size is gretter than 10")
	private String categoryDescription;
	
	@Override
	public String toString() {
		return "CategoryDto [categoryId=" + categoryId + ", categoryTitle=" + categoryTitle + ", categoryDescription="
				+ categoryDescription + "]";
	}
	

}
