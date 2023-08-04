package com.ikramdagci.tdd.services;

import com.ikramdagci.tdd.dto.OrderDto;
import com.ikramdagci.tdd.services.requests.CreateOrderRequest;

import java.math.BigDecimal;

public class OrderService {
    public OrderDto createOrder(final CreateOrderRequest request) {
        BigDecimal totalPrice = request.getUnitPrice().multiply(BigDecimal.valueOf(request.getAmount()));
        return OrderDto.builder().totalPrice(totalPrice).build();
    }
}
