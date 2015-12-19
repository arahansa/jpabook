package jpabook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jpabook.model.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{

}
