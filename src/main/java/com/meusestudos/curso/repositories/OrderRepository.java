package com.meusestudos.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meusestudos.curso.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
