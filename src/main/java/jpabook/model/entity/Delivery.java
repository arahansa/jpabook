package jpabook.model.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by arahansa on 2015-12-19.
 */
@Entity
@Data
public class Delivery {
    @Id
    @GeneratedValue
    @Column(name="DELIVERY_ID")
    private Long id;

    @OneToOne(mappedBy = "delivery")
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;


}
