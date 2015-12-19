package jpabook.repository;

import jpabook.model.entity.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by arahansa on 2015-12-19.
 */
public interface DeliveryRepository extends JpaRepository<Delivery,Long> {
}
