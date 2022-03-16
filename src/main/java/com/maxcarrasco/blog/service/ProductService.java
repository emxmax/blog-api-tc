package com.maxcarrasco.blog.service;

import com.maxcarrasco.blog.payload.ProductDto;

public interface ProductService {
	ProductDto createProduct(Long categorytId, ProductDto productDto);
}
