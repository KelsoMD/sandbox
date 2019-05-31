package com.nesterenok.sandbox.core.converter;

import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.nesterenok.sandbox.api.projection.ProductDto;
import com.nesterenok.sandbox.api.projection.ReceiptDto;
import com.nesterenok.sandbox.core.entity.Product;
import com.nesterenok.sandbox.core.entity.Receipt;

@Component
public class ReceiptConverter {

    private final ProductConverter productConverter;

    @Autowired
    public ReceiptConverter(final ProductConverter productConverter) {
        this.productConverter = productConverter;
    }

    public ReceiptDto convertToDto(final Receipt receipt) {
        // @formatter:off
        return ReceiptDto.builder()
                .id(receipt.getId())
                .title(receipt.getTitle())
                .products(convertProducts(receipt.getProducts()))
                .build();
        // @formatter:on
    }

    private Set<ProductDto> convertProducts(final Set<Product> products) {
        return products.stream().map(productConverter::convertToDto).collect(Collectors.toSet());
    }
}
