package org.antoniogl;

import lombok.AllArgsConstructor;
import org.antoniogl.entity.Prices;
import org.antoniogl.mapper.PricesH2Mapper;
import org.antoniogl.ports.output.PricesManagementOutputPort;
import org.antoniogl.repository.PricesManagementRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PricesManagementH2Adapter implements PricesManagementOutputPort {
    public static final String PRIORITY = "priority";
    PricesManagementRepository pricesRepository;
    PricesH2Mapper priceMapper;

    @Override
    public Optional<Prices> findPrices(LocalDateTime filterDate, Long productId, Long brandId) {
        return pricesRepository.findPrices(filterDate, productId, brandId, Sort.by(PRIORITY).descending())
                .stream().findFirst()
                .map(priceMapper::toDomain);
    }
}
