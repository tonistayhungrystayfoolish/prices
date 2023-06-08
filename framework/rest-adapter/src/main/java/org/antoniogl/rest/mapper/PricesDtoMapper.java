package org.antoniogl.rest.mapper;

import io.tej.SwaggerCodgen.model.PricesResponseDto;
import org.antoniogl.entity.Prices;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PricesDtoMapper {
    @Mapping(source = "product.id", target = "productId")
    @Mapping(source = "brand.id", target = "brandId")
    @Mapping(source = "priceList.id", target = "priceList")
    @Mapping(source = "price.value", target = "price")
    @Mapping(source = "startDate", target = "startDate")
    @Mapping(source = "endDate", target = "endDate")
    PricesResponseDto toDto(Prices prices);
}
