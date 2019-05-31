package com.nesterenok.sandbox.api.projection;

import java.util.Set;
import com.nesterenok.sandbox.core.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ReceiptDto {

    private long id;
    private String title;
    private Set<ProductDto> products;
}
