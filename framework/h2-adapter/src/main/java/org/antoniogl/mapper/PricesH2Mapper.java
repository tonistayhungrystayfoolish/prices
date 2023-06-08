package org.antoniogl.mapper;

import org.antoniogl.data.PricesData;
import org.antoniogl.entity.Prices;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PricesH2Mapper {

    @Mapping(source = "brand.id", target = "brandId")
    @Mapping(source = "currency.value", target = "currency")
    @Mapping(source = "price.value", target = "price")
    @Mapping(source = "priceList.id", target = "priceList")
    @Mapping(source = "priority.value", target = "priority")
    @Mapping(source = "product.id", target = "productId")
    PricesData toData(Prices domain);

    @InheritInverseConfiguration
    Prices toDomain(PricesData priceData);
}