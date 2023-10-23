package com.ikramdagci.tdd.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class OrderDto {
    private Integer id;
    private BigDecimal totalPrice;
}
