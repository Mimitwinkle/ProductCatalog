package io.github.mimitwinkle.ProductCatalog.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import io.github.mimitwinkle.ProductCatalog.domain.Product;
import io.github.mimitwinkle.ProductCatalog.exception.ResourceNotFoundException;
import io.github.mimitwinkle.ProductCatalog.repository.ProductRepository;
import io.github.mimitwinkle.ProductCatalog.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductRepository productRepository;

	public ProductServiceImpl(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}

	@Override
	public Product saveProduct(Product product) {

		return productRepository.save(product);
	}

	@Override
	public List<Product> getAllProducts() {

		return productRepository.findAll();
	}

	@Override
	public Product getProductById(long id) {

		Optional<Product> product = productRepository.findById(id);
		
		// If a product is found not found with a matching id, throw error
		return productRepository.findById(id).orElseThrow(() -> 
				new ResourceNotFoundException("Product", "ID", product));
	}

	@Override
	public Product updateProduct(Product product, long id) {
		
		// Check whether product exists in database
		Product existingProduct = productRepository.findById(id).orElseThrow(() -> 
		new ResourceNotFoundException("Product", "ID", product));
		
		// If found, update data
		existingProduct.setName(product.getName());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setDescription(product.getDescription());
		productRepository.save(existingProduct);
		
		return existingProduct;
	}

	@Override
	public void deleteProduct(long id) {
		
		// Check whether product exists in database
		productRepository.findById(id).orElseThrow(() -> 
				new ResourceNotFoundException("Product", "ID", id));
		
		// If found, delete
		productRepository.deleteById(id);
	}

}

