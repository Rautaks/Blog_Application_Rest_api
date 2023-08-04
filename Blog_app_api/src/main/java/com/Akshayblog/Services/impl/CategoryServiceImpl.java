package com.Akshayblog.Services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.Akshayblog.Entities.Category;
import com.Akshayblog.Exception.ResourceNotFoundException;
import com.Akshayblog.Payloads.CategoryDto;
import com.Akshayblog.Repositories.CategoryRepo;
import com.Akshayblog.Services.CategoryService;
@Service
@Repository
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	
	public CategoryDto createCategory(CategoryDto categoryDto) {
		
		Category cat = this.modelMapper.map(categoryDto, Category.class);
		Category addedCat = this.categoryRepo.save(cat);
	
		return this.modelMapper.map(addedCat, CategoryDto.class);
	}
   
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		
		Category cat = this.categoryRepo.findById(categoryId)
				.orElseThrow(()->new ResourceNotFoundException("Category", "Category Id", categoryId));
		
		cat.setCategoryTitle(categoryDto.getCategoryTitle());
		cat.setCategoryDescription(categoryDto.getCategoryDescription());
		Category updatedcat=this.categoryRepo.save(cat);
		
		return this.modelMapper.map(updatedcat, CategoryDto.class);
	}

	
	public void deleteCategory(Integer categoryId) {
		
	   Category cat = this.categoryRepo.findById(categoryId)
			   .orElseThrow(()->new ResourceNotFoundException("Category","category id", categoryId));
			   this.categoryRepo.delete(cat);
			  
	}

	
	public CategoryDto getCategory(Integer categoryId) {
		Category cat = this.categoryRepo.findById(categoryId)
				.orElseThrow(()-> new ResourceNotFoundException("Category", "Category Id", categoryId));
		
		return this.modelMapper.map(cat, CategoryDto.class);
	}

	
	public List<CategoryDto> getcategories() {
		List<Category>categories=this.categoryRepo.findAll();
		List<CategoryDto> catDtos = categories.stream()
				.map((cat)->this.modelMapper.map(cat, CategoryDto.class))
				.collect(Collectors.toList());
		return catDtos;
	}
	
	public CategoryDto updateCategory(CategoryDto categoryDto) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<CategoryDto> getCategories() {
		// TODO Auto-generated method stub
		return null;
	}



}
