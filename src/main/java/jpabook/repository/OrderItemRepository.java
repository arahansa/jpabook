package jpabook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jpabook.model.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
