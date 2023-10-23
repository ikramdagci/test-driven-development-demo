package com.ikramdagci.tdd.repositories;

import com.ikramdagci.tdd.models.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order,Integer> {
}
