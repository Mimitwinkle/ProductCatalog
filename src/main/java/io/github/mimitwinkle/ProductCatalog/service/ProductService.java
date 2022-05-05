package io.github.mimitwinkle.ProductCatalog.service;

import java.util.List;

import io.github.mimitwinkle.ProductCatalog.domain.Product;

public interface ProductService {
	
	Product saveProduct(Product product);
	List<Product> getAllProducts();
	Product getProductById(long id);
	Product updateProduct(Product product);
	void deleteProduct(long id);
}
