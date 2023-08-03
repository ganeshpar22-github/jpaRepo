package com.springdatajpa.repository;

import java.math.BigDecimal;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springdatajpa.entity.Product;

@SpringBootTest
class ProductRepositoryTest {

	@Autowired
	private ProductRepository productRepository;

	@Test
	void saveMethod() {
		// create a product object and save that product object in db and then display
		// the product information

		// create product object
		Product product = new Product();
		product.setName("Product 1");
		product.setDescription("This is product 1");
		product.setSku("100ABC");
		product.setActive(true);
		product.setPrice(new BigDecimal(100));
		product.setImageUrl("product1.jpeg");

		// save product object
		Product savedProduct = productRepository.save(product);

		// display saved product
		System.out.println(savedProduct.getId());
		System.out.println(savedProduct.toString());

	}

	@Test
	void updateUsingSaveMethod() {
		// first retrieve the entity by id, then update the entity with new info, then
		// save the entity
		
		//retrieve entity
		Long id = 1L;
		Product product = productRepository.findById(id).get();
		
		//update entity with new info
		product.setName("updated product name");
		product.setDescription("update description");
		
		//save entity
		productRepository.save(product);
	}
	
	@Test
	void findByIdMethod() {
		
		Long id = 1L;		//hardcoded the data, bassically comes from client
		Product product = productRepository.findById(id).get();
		
		System.out.println(product.toString());
		
	}
	
	
	@Test
	void saveAllMethod() {
		
		Product product = new Product();
		product.setName("Product 2");
		product.setDescription("This is product 12");
		product.setSku("1541HD");
		product.setActive(true);
		product.setPrice(new BigDecimal(1500));
		product.setImageUrl("product2.jpeg");
		
		
		Product product3 = new Product();
		product3.setName("Product 3");
		product3.setDescription("This is product 3");
		product3.setSku("1040ABC");
		product3.setActive(true);
		product3.setPrice(new BigDecimal(4100));
		product3.setImageUrl("product3.jpeg");
		
		productRepository.saveAll(Arrays.asList(product,product3));
		
	}
	
	@Test
	void findAllMethod() {
		
	java.util.List<Product> products =	productRepository.findAll();
	
	products.forEach((p) -> {
		System.out.println(p.getName());
	});
		
	}
	
	@Test
	void deleteByIdMethod() {
		
		Long id = 2L;
		productRepository.deleteById(id);
		
	}
	
	@Test
	void countMethod() {
		
		long count = productRepository.count();
		System.out.println(count);
	}
	
	
	@Test
	void entityExistMethod()
	{
		
		Long id = 1L;
		boolean result = productRepository.existsById(id);
		System.out.println(result);
	}
	
	
}
