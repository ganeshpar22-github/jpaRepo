package com.springdatajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springdatajpa.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
