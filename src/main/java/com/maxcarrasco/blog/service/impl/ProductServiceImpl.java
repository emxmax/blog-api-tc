package com.maxcarrasco.blog.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.maxcarrasco.blog.entity.Product;
import com.maxcarrasco.blog.payload.ProductDto;
import com.maxcarrasco.blog.repository.ProductRepository;
import com.maxcarrasco.blog.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	private ProductRepository productReposity;
	private ModelMapper mapper;
	
	public ProductServiceImpl(ProductRepository productReposity, ModelMapper mapper) {
		this.productReposity=productReposity;
		this.mapper=mapper;
	}

	@Override
	public ProductDto createProduct(ProductDto productDto) {
		
		Product product = mapToEntity(productDto);
		Product newproduct = productReposity.save(product);
		ProductDto productResponse = mapToDto(newproduct);
		
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
