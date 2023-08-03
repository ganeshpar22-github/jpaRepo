package com.springdatajpa.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "products", schema = "ecommerce", uniqueConstraints = {
		@UniqueConstraint(name = "sku_unique", columnNames = "sku")
})
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(nullable = false)
	private String sku;
	
	@Column(nullable = false)
	private String name;
	
	private String description;
	private BigDecimal price;
	private boolean active;
	private String imageUrl;
	
	@CreationTimestamp
	private LocalDateTime dateCreated;
	
	@UpdateTimestamp
	private LocalDateTime lastUpdated;

	public Product() {
		super();
		
	}

	public Product(Long id, String sku, String name, String description, BigDecimal price, boolean active,
			String imageUrl, LocalDateTime dateCreated, LocalDateTime lastUpdated) {
		super();
		this.id = id;
		this.sku = sku;
		this.name = name;
		this.description = description;
		this.price = price;
		this.active = active;
		this.imageUrl = imageUrl;
		this.dateCreated = dateCreated;
		this.lastUpdated = lastUpdated;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", sku=" + sku + ", name=" + name + ", description=" + description + ", price="
				+ price + ", active=" + active + ", imageUrl=" + imageUrl + ", dateCreated=" + dateCreated
				+ ", lastUpdated=" + lastUpdated + "]";
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
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

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public LocalDateTime getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}

	public LocalDateTime getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(LocalDateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

}
