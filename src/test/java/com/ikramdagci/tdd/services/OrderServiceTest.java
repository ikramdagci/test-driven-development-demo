package com.ikramdagci.tdd.services;

import com.ikramdagci.tdd.dto.OrderDto;
import com.ikramdagci.tdd.services.requests.CreateOrderRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.assertj.core.api.BDDAssertions.then;

public class OrderServiceTest {

    private OrderService orderService;
    @BeforeEach
    public void beforeEach(){
        orderService = new OrderService();
    }
    public static Stream<Arguments> order_requests() {
        return Stream.of(
                Arguments.of("code1",5,BigDecimal.valueOf(12.3),BigDecimal.valueOf(61.5)),
                Arguments.of("code2",10,BigDecimal.valueOf(15),BigDecimal.valueOf(150))
        );
    }

    @Test
    public void itShouldCeateOrderWith5Items(){
        //given
        CreateOrderRequest request = CreateOrderRequest.builder()
                .productCode("code1")
                .amount(5)
                .unitPrice(BigDecimal.valueOf(12.3))
                .build();

        //when
        OrderDto orderDto = orderService.createOrder(request);
        //then
        then(orderDto).isNotNull();
        then(orderDto.getTotalPrice()).isEqualTo(BigDecimal.valueOf(61.5));
    }

    @Test
    public void itShouldCeateOrderWith10Items(){
        //given
        CreateOrderRequest request = CreateOrderRequest.builder()
                .productCode("code1")
                .amount(10)
                .unitPrice(BigDecimal.valueOf(15.0))
                .build();

        //when
        OrderDto orderDto = orderService.createOrder(request);
        //then
        then(orderDto).isNotNull();
        then(orderDto.getTotalPrice()).isEqualTo(BigDecimal.valueOf(150D));
    }

    @ParameterizedTest
    @MethodSource("order_requests")
    public void itShouldCreateOrders(String productCode,Integer amount,BigDecimal unitPrice,BigDecimal expectedTotalPrice) {
        //given
        final CreateOrderRequest request = CreateOrderRequest.builder()
                .productCode(productCode)
                .amount(amount)
                .unitPrice(unitPrice)
                .build();
        //when
        final OrderDto order = orderService.createOrder(request);

        //then
        then(order.getTotalPrice()).isEqualTo(expectedTotalPrice);

    }

}
