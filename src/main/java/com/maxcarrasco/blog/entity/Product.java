package com.maxcarrasco.blog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name",nullable = false,length = 20)
	private String name;
	
	@Column(name="description",nullable = false,length = 100)
	private String description;
	
	@Column(name="price",nullable = false,scale = 2)
	private Double price;
	
	@Column(name="status",nullable = false)
	private Boolean status;
	
	@OneToOne
	@JoinColumn(name="category_id", nullable = false)
	private Category category;
}
