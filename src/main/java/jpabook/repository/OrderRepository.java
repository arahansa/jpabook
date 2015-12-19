package jpabook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jpabook.model.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
