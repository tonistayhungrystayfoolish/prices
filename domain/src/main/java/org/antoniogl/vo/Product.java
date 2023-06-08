package org.antoniogl.vo;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Product {
    private final long id;

    public Product(long id) {
        if (id < 0) {
            throw new IllegalArgumentException("Null id product");
        }
        this.id = id;
    }
}
