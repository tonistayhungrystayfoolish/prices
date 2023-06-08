package org.antoniogl.rest.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.tej.SwaggerCodgen.api.PricesApi;
import io.tej.SwaggerCodgen.model.PricesResponseDto;
import lombok.AllArgsConstructor;
import org.antoniogl.entity.Prices;
import org.antoniogl.rest.exceptions.PriceNotFoundException;
import org.antoniogl.rest.mapper.PricesDtoMapper;
import org.antoniogl.usecass.PricesManagementUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
@Tag(name = "Prices Management Adapter", description = "Prices operations")
public class PricesManagementAdapter implements PricesApi {

    private final PricesManagementUseCase pricesManagementUseCase;

    private final PricesDtoMapper pricesDtoMapper;

    @Operation(summary = "Get prices")
    @ApiResponse(responseCode = "200", description = "Price found", content = @Content(mediaType = "application/json", schema = @Schema(type = "object", implementation = PricesResponseDto.class)))
    @ApiResponse(responseCode = "204", description = "No price found", content = @Content(mediaType = "application/json"))
    @Override
    public ResponseEntity<PricesResponseDto> getPrices(Long productId, Long brandId, LocalDateTime filterDate) {
        Optional<Prices> optionalPrices = pricesManagementUseCase.getPrices(filterDate, productId, brandId);
        return optionalPrices.map(pricesDtoMapper::toDto)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new PriceNotFoundException("Price not found"));
    }
}