package com.Akshayblog.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Akshayblog.Payloads.CategoryDto;

@Service
public interface CategoryService {
	
	//create
    public  String createCategory(CategoryDto categoryDto);
	
  //get all
  	List<CategoryDto> getCategories();
  	
	//update
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer catId);
	
	//delete
	public void deleteCategory(Integer categoryId);
	
	//get
	public  CategoryDto getCategory(Integer categoryId);
	

	

	

}
