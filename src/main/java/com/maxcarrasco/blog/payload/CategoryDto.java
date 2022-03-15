package com.maxcarrasco.blog.payload;

import lombok.Data;

@Data
public class CategoryDto {
	private Long id;
	private String name;
	private Boolean status;
}
