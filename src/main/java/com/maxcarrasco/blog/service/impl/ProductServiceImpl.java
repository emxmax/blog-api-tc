package com.maxcarrasco.blog.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.maxcarrasco.blog.entity.Category;
import com.maxcarrasco.blog.entity.Product;
import com.maxcarrasco.blog.payload.ProductDto;
import com.maxcarrasco.blog.repository.CategoryRepository;
import com.maxcarrasco.blog.repository.ProductRepository;
import com.maxcarrasco.blog.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	private ProductRepository productReposity;
	private CategoryRepository categoryRepository;
	private ModelMapper mapper;
	
	public ProductServiceImpl(ProductRepository productReposity, ModelMapper mapper, CategoryRepository categoryRepository) {
		this.productReposity=productReposity;
		this.categoryRepository=categoryRepository;
		this.mapper=mapper;
	}

	@Override
	public ProductDto createProduct(Long categoryId, ProductDto productDto) {
		
		Product product = mapToEntity(productDto);
		
		Category category = categoryRepository.findById(categoryId).orElseThrow();
		
		product.setCategory(category);
		
		Product newProduct = productReposity.save(product);
		ProductDto productResponse = mapToDto(newProduct);
		
		return productResponse;
	}
	
	// convert Entity to Dto
	private ProductDto mapToDto(Product product) {
		ProductDto productDto=mapper.map(product, ProductDto.class);		
		return productDto;
	}

	// convert DTO to entity
	private Product mapToEntity(ProductDto productDto) {
		Product product=mapper.map(productDto, Product.class);
		return product;
	}

}
