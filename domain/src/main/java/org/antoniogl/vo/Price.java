package org.antoniogl.vo;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Price {
    private final double value;

    public Price(double value) {
        if (value < 0) {
            throw new IllegalArgumentException("Invalid price value");
        }
        this.value = value;

    }

}
