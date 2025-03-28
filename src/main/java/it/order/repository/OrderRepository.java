package it.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.order.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}