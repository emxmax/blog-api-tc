package com.maxcarrasco.blog.repository;

import org.springframework.stereotype.Repository;
import com.maxcarrasco.blog.entity.Product;

@Repository
public interface ProductRepository extends GenericRepository<Product, Long>{

}
