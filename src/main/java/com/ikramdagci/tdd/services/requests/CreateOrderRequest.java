package com.ikramdagci.tdd.services.requests;

import lombok.*;

import java.math.BigDecimal;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderRequest {
    private String productCode;
    private Integer amount;
    private BigDecimal unitPrice;
}
