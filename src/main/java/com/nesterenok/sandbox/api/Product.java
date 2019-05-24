package com.nesterenok.sandbox.api;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Builder
@EqualsAndHashCode
@ToString
public class Product {

    private String title;
    private long amount;
    private String trademark;
}
