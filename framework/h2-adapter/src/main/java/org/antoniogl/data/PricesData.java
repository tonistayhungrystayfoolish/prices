package org.antoniogl.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "prices")
public class PricesData {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;
    @Column(name = "brand_id")
    private long brandId;
    @Column(name = "currency")
    private String currency;
    @Column(name = "start_date")
    private LocalDateTime startDate;
    @Column(name = "end_date")
    private LocalDateTime endDate;
    @Column(name = "price_list")
    private long priceList;
    @Column(name = "product_id")
    private long productId;
    @Column(name = "priority")
    private int priority;
    @Column(name = "price")
    private double price;
}