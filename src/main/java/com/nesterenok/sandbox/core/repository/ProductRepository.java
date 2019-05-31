package com.nesterenok.sandbox.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import com.nesterenok.sandbox.core.entity.Product;

@Component
public interface ProductRepository extends JpaRepository<Product, Long> {
}
