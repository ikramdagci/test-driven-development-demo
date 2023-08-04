package com.ikramdagci.tdd.services;

import com.ikramdagci.tdd.dto.OrderDto;
import com.ikramdagci.tdd.services.requests.CreateOrderRequest;
import org.junit.jupiter.api.Test;


import java.math.BigDecimal;

import static org.assertj.core.api.BDDAssertions.then;

public class OrderServiceTest {

    @Test
    public void itShouldCeateOrderWith5Items(){
        //given
        OrderService service = new OrderService();
        CreateOrderRequest request = CreateOrderRequest.builder()
                .productCode("code1")
                .amount(5)
                .unitPrice(BigDecimal.valueOf(12.3))
                .build();

        //when
        OrderDto orderDto = service.createOrder(request);
        //then
        then(orderDto).isNotNull();
        then(orderDto.getTotalPrice()).isEqualTo(BigDecimal.valueOf(61.5));
    }

    @Test
    public void itShouldCreateOrderWith10Items(){
        //given
        OrderService service = new OrderService();
        CreateOrderRequest request = CreateOrderRequest.builder()
                .productCode("code1")
                .amount(10)
                .unitPrice(BigDecimal.valueOf(15.0))
                .build();

        //when
        OrderDto orderDto = service.createOrder(request);
        //then
        then(orderDto).isNotNull();
        then(orderDto.getTotalPrice()).isEqualTo(BigDecimal.valueOf(150D));
    }



}
