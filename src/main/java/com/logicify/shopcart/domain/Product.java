package com.logicify.shopcart.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Product", schema = "PUBLIC")
public class Product extends DTO {
	
	
	private Set<Category> categories = new HashSet<Category>();
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="prodid")
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
	
	@ManyToMany
    @JoinTable(name="prodcat",
                joinColumns={@JoinColumn(name="catid")},
                inverseJoinColumns={@JoinColumn(name="prodid")})
	public Set<Category> getCategories() {
		return categories;
	}
	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}
	
}
