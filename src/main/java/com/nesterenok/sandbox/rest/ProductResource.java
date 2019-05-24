package com.nesterenok.sandbox.rest;

import static org.springframework.http.HttpStatus.OK;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nesterenok.sandbox.api.Product;

@RestController(value = "/product")
public class ProductResource {

    @GetMapping
    public ResponseEntity<?> getProduct() {
        return new ResponseEntity<>(Product.builder().title("Egg").amount(5).build(), OK);
    }
}
