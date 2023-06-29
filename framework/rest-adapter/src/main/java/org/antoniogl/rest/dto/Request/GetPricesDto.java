package org.antoniogl.rest.dto.Request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

@Getter
@Setter
public class GetPricesDto {
    @NotNull
    Long productId;
    @NotNull
    Long brandId;
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME)
    LocalDateTime filterDate;
}
