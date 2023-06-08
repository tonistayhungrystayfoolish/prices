package org.antoniogl.ports.output;

import org.antoniogl.entity.Prices;
import java.time.LocalDateTime;
import java.util.Optional;

public interface PricesManagementOutputPort {
    Optional<Prices> findPrices(LocalDateTime filterDate, Long productId, Long brandId);

}
