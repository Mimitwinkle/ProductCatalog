package io.github.mimitwinkle.ProductCatalog.controller;

import java.util.ArrayList;
import java.util.List;

import io.github.mimitwinkle.ProductCatalog.domain.Product;
import io.github.mimitwinkle.ProductCatalog.service.ProductService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	private final ProductService productService;
	
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	// GET
	@GetMapping()
	public List<Product> getAllProducts(){
		return productService.getAllProducts();
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Product> findProductById(@PathVariable("id") long productId) {
		return new ResponseEntity<Product>(productService.getProductById(productId), HttpStatus.OK);
	}
	
	// ToDo: Get by price
	
	// POST
	@PostMapping("/add")
	public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
		return new ResponseEntity<Product>(productService.saveProduct(product), HttpStatus.CREATED);
	}
	
	// PUT
	@PutMapping("/update")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
		return new ResponseEntity<Product>(productService.updateProduct(product), HttpStatus.OK);
	}
	
	// DELETE
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable("id") long productId) {
		productService.deleteProduct(productId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
