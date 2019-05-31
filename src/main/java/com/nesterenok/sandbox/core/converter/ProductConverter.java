package com.nesterenok.sandbox.core.converter;

import org.springframework.stereotype.Component;
import com.nesterenok.sandbox.core.entity.Product;
import com.nesterenok.sandbox.api.projection.ProductDto;

@Component
public class ProductConverter {

    public ProductDto convertToDto(Product product) {
        // @formatter:off
        return ProductDto.builder()
                .id(product.getId())
                .title(product.getTitle())
                .amount(product.getAmount())
                .trademark(product.getTrademark())
        .build();
        // @formatter:on
    }
}
