package com.logicify.shopcart.domain;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;

import javax.persistence.Id;
import javax.persistence.Table;

import com.logicify.shopcart.domain.Product;

@Entity
@Table(name="Category", schema = "PUBLIC")
public class Category extends DTO {

	private Set<Product> products = new HashSet<Product>();

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="catid")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="description")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	@ManyToMany(mappedBy="categories")
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
}
