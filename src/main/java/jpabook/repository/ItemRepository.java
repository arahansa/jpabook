package jpabook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jpabook.model.entity.item.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{

}
