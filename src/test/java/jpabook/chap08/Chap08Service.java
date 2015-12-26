package jpabook.chap08;

import jpabook.model.entity.Delivery;
import jpabook.model.entity.Order;
import jpabook.model.entity.OrderItem;
import jpabook.model.entity.item.Album;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by jarvis on 15. 12. 26..
 */
@Service
@Transactional
public class Chap08Service {

    @PersistenceContext
    EntityManager em;

    public void saveTest(){
        Delivery delivery = new Delivery();
        delivery.setCity("Incheon");
        //em.persist(delivery);

        OrderItem orderItem1  = new OrderItem();
        final Album album = new Album();
        album.setArtist("아티스트 아라한");
        album.setStockQuantity(1);

        em.persist(album);

        orderItem1.setItem(album);
        OrderItem orderItem2 = new OrderItem();
        //em.persist(orderItem1);
        //em.persist(orderItem2);

        Order order = new Order();

        order.setDelivery(delivery);
        order.addOrderItem(orderItem1);
        order.addOrderItem(orderItem2);

        em.persist(order);

        Order getOrder = em.find(Order.class, 1L);
        System.out.println("오더 아이템 양 : "+getOrder.getOrderItems().get(0).getItem().getStockQuantity());
    }

}
