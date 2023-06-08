package org.antoniogl.ports.input;

import lombok.AllArgsConstructor;
import org.antoniogl.entity.Prices;
import org.antoniogl.ports.exception.ProductNotFoundException;
import org.antoniogl.ports.output.PricesManagementOutputPort;
import org.antoniogl.usecass.PricesManagementUseCase;

import java.time.LocalDateTime;
import java.util.Optional;

@AllArgsConstructor
public class PricesManagementInputPort implements PricesManagementUseCase {

    PricesManagementOutputPort priceRepository;

    @Override
    public Optional<Prices> getPrices(LocalDateTime filterDate, Long productID, Long brandId) {
        return Optional.ofNullable(priceRepository.findPrices(filterDate, productID, brandId)
                .orElseThrow(() -> new ProductNotFoundException("Price not found")));
    }
}