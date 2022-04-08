package io.github.mimitwinkle.ProductCatalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.mimitwinkle.ProductCatalog.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
