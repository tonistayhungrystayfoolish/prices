package org.antoniogl.vo;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Brand {
    private final long id;

    public Brand(long value) {
        if (value < 0) {
            throw new IllegalArgumentException("Invalid brand value");
        }
        this.id = value;

    }

}
