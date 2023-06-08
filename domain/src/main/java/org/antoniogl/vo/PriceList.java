package org.antoniogl.vo;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PriceList {
    private long id;

    public PriceList(long value) {
        if (value < 0) {
            throw new IllegalArgumentException("Invalid price list value");
        }
        this.id = value;

    }
}
