package org.antoniogl.vo;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Currency {
    private String value;

    public Currency(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Null currency value");
        }
    }

}
