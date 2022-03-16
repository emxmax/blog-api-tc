package com.maxcarrasco.blog.repository;

import org.springframework.stereotype.Repository;

import com.maxcarrasco.blog.entity.Category;

@Repository
public interface CategoryRepository extends GenericRepository<Category, Long>{
	
}
