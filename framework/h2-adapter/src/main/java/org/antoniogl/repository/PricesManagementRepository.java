package org.antoniogl.repository;

import org.antoniogl.data.PricesData;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PricesManagementRepository extends JpaRepository<PricesData, Long> {
    @Query(" SELECT pd FROM PricesData pd " +
            "WHERE :filterDate >= pd.startDate AND :filterDate <= pd.endDate AND pd.productId = :productId AND pd.brandId = :brandId")
    List<PricesData> findPrices(@Param("filterDate") LocalDateTime filterDate,
                                @Param("productId") Long productId,
                                @Param("brandId") Long brandId,
                                Sort sort);
}