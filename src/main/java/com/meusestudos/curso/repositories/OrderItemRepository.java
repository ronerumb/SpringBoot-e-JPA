package com.meusestudos.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meusestudos.curso.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
