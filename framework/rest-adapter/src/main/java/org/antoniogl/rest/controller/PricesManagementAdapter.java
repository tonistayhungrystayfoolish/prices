package org.antoniogl.rest.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.antoniogl.entity.Prices;
import org.antoniogl.rest.dto.Request.GetPricesDto;
import org.antoniogl.rest.dto.Response.PricesResponseDto;
import org.antoniogl.rest.mapper.PricesDtoMapper;
import org.antoniogl.usecass.PricesManagementUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/prices")
@Tag(name = "Prices Management Adapter", description = "Prices operations")
public class PricesManagementAdapter {

    private final PricesManagementUseCase pricesManagementUseCase;

    private final PricesDtoMapper pricesDtoMapper;

    @GetMapping
    @Operation(summary = "Get prices")
    @ApiResponse(responseCode = "200", description = "Price found", content = @Content(mediaType = "application/json", schema = @Schema(type = "object", implementation = PricesResponseDto.class)))
    @ApiResponse(responseCode = "204", description = "No price found", content = @Content(mediaType = "application/json"))
    public ResponseEntity<PricesResponseDto> getPrices(@Valid GetPricesDto getPricesDto) {
        Optional<Prices> optionalPrices = pricesManagementUseCase.getPrices(
                getPricesDto.getFilterDate(),
                getPricesDto.getProductId(),
                getPricesDto.getBrandId());
        return optionalPrices.map(pricesDtoMapper::toDto)
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.notFound()::build);
    }
}