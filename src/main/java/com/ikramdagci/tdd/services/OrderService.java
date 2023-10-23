package com.ikramdagci.tdd.services;

import com.ikramdagci.tdd.clients.PaymentClient;
import com.ikramdagci.tdd.dto.OrderDto;
import com.ikramdagci.tdd.models.Order;
import com.ikramdagci.tdd.repositories.OrderRepository;
import com.ikramdagci.tdd.services.requests.CreateOrderRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final PaymentClient paymentClient;

    public OrderService(final OrderRepository orderRepository, final PaymentClient paymentClient) {
        this.orderRepository = orderRepository;
        this.paymentClient = paymentClient;
    }

    public OrderDto createOrder(final CreateOrderRequest request) {
        BigDecimal totalPrice = request.getUnitPrice().multiply(BigDecimal.valueOf(request.getAmount()));
        Order order = Order.builder().totalPrice(totalPrice).build();
        this.paymentClient.pay(order);
        final Order save = this.orderRepository.save(order);
        return OrderDto.builder().id(save.getId()).totalPrice(totalPrice).build();
    }
}
