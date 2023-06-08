package org.antoniogl.vo;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Priority {
    private final int value;

    public Priority(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("Invalid priority value");
        }
        this.value = value;

    }

}
