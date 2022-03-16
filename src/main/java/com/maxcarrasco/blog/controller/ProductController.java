package com.maxcarrasco.blog.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maxcarrasco.blog.payload.ProductDto;
import com.maxcarrasco.blog.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {
	
	private ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@PostMapping("/categories/{categoryId}/products")
	public ResponseEntity<ProductDto> createProduct(@PathVariable(value="categoryId")Long categoryId, @RequestBody ProductDto productDto){
		return new ResponseEntity<>(productService.createProduct(categoryId, productDto), HttpStatus.CREATED);
	}
	
}
