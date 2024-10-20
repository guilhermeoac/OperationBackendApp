package com.ntd.operationservice.dto;

import java.math.BigDecimal;

public record OperationOutputDTO(
        Long id,
        String type,
        BigDecimal cost
) {

}
