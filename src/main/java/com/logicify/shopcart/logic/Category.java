package com.logicify.shopcart.logic;

import java.util.HashSet;
import java.util.Set;

public class Category {
	private Long id;
	private String name;
	private String description;
	private Set products = new HashSet();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Set getProducts() {
		return products;
	}
	public void setProducts(Set products) {
		this.products = products;
	}
	
}
