package com.maxcarrasco.blog.payload;

import lombok.Data;

@Data
public class ProductDto {
	private Long id;
	private String name;
	private String description;
	private Double price;
	private Boolean status;
}
