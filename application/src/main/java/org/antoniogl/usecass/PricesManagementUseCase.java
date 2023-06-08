package org.antoniogl.usecass;

import org.antoniogl.entity.Prices;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PricesManagementUseCase {
    Optional<Prices> getPrices(LocalDateTime filterDate, Long productID, Long brandId);

}
