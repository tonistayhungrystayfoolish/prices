package org.antoniogl.entity;

import lombok.Builder;
import lombok.Getter;
import org.antoniogl.vo.*;

import java.time.LocalDateTime;

@Builder
@Getter
public class Prices {
    private Brand brand;
    private Currency currency;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private PriceList priceList;
    private Price price;
    private Product product;
    private Priority priority;
}
