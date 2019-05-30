package com.nesterenok.sandbox.rest;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.nesterenok.sandbox.api.Product;
import io.swagger.annotations.Api;

@Api
@RepositoryRestResource(collectionResourceRel = "products", path = "products")
public interface ProductResource extends PagingAndSortingRepository<Product, Long> {

}
