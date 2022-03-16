package com.maxcarrasco.blog.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.maxcarrasco.blog.entity.Category;
import com.maxcarrasco.blog.payload.CategoryDto;
import com.maxcarrasco.blog.repository.CategoryRepository;
import com.maxcarrasco.blog.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	private CategoryRepository categoryRepository;
	private ModelMapper mapper;
	
	public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper mapper) {
		this.categoryRepository = categoryRepository;
		this.mapper = mapper;
	}

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		
		Category category = mapToEntity(categoryDto);
		Category newCategory = categoryRepository.save(category);
		CategoryDto responseCategory = mapToDto(newCategory);
		
		return responseCategory;
	}


	// convert Entity to Dto
	private CategoryDto mapToDto(Category category) {
		CategoryDto categoryDto = mapper.map(category, CategoryDto.class);
		return categoryDto;
	}
	
	// convert DTO to entity
	private Category mapToEntity(CategoryDto categoryDto) {
		Category category = mapper.map(categoryDto, Category.class);
		return category;
	}

}
