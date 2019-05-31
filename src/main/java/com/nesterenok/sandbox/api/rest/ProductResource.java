package com.nesterenok.sandbox.api.rest;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nesterenok.sandbox.core.converter.ProductConverter;
import com.nesterenok.sandbox.core.entity.Product;
import com.nesterenok.sandbox.core.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductResource {

    private final ProductRepository productRepository;
    private final ProductConverter productConverter;

    @Autowired
    public ProductResource(final ProductRepository productRepository, final ProductConverter productConverter) {
        this.productRepository = productRepository;
        this.productConverter = productConverter;
    }

    @GetMapping
    public ResponseEntity<?> getProducts() {
        return new ResponseEntity<>(productRepository.findAll(), OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProduct(@PathVariable final Long id) {
        final Product product = productRepository.getOne(id);
        return new ResponseEntity<>(productConverter.convertToDto(product), OK);
    }

    @PostMapping
    public ResponseEntity<?> saveProduct(@RequestBody final Product product) {
        return new ResponseEntity<>(productRepository.save(product), CREATED);
    }

    @DeleteMapping
    public void deleteProduct(@RequestBody final Product product) {
        productRepository.delete(product);
    }
}
