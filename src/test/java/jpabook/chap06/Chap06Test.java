package jpabook.chap06;

import jpabook.JpabookApplication;
import jpabook.model.entity.*;
import jpabook.repository.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.Assert.*;
import java.util.Arrays;



/**
 * Created by arahansa on 2015-12-19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes= JpabookApplication.class)
@WebAppConfiguration
@EnableTransactionManagement
public class Chap06Test {

    public static final String 아라한사 = "아라한사";
    public static final String 인천 = "인천";
    public static final String 전자기기 = "전자기기";
    public static final String 맥북 = "맥북";
    public static final String 남구 = "남구";
    @Autowired TestService testService;

    @Test
    public void test() throws Exception{
        Order savedOrder = testService.saveMockOrder();
        assertEquals(savedOrder.getMember().getName(),아라한사);
        assertEquals(savedOrder.getMember().getCity(),인천);
        assertEquals(savedOrder.getDelivery().getCity(),인천);
        assertEquals(savedOrder.getOrderItems().get(0).getItem().getName(),맥북);
        System.out.println("오더주문 아이디  :"+savedOrder.getId());
    }

    @Service
    @Transactional
    public static class TestService{
        @Autowired MemberRepository memberRepository;
        @Autowired
        CategoryRepository categoryRepository;
        @Autowired
        ItemRepository itemRepository;
        @Autowired
        OrderRepository orderRepository;
        @Autowired
        DeliveryRepository deliveryRepository;

        public Member saveMockMember(){
            final Member member = new Member();
            member.setCity(인천);
            member.setName(아라한사);
            member.setZipcode("22140");
            final Member savedMember = memberRepository.save(member);
            return  savedMember;
        }

        public Category saveMockCategory(){
            final Category category = new Category();
            category.setName(전자기기);
            final Category savedCategory = categoryRepository.save(category);
            return savedCategory;
        }

        public Item saveMockItem(){
            final Item item = new Item();
            item.setCategories(Arrays.asList(saveMockCategory()));
            item.setName(맥북);
            item.setPrice(10);
            item.setStockQuantity(3);
            final Item savedItem = itemRepository.save(item);
            return savedItem;
        }


        public Order saveMockOrder(){
            final OrderItem orderItem = new OrderItem();
            orderItem.setCount(1);
            orderItem.setItem(saveMockItem());

            //관계
            final Order order = new Order();
            order.setDelivery(saveMockDelivery());
            order.addOrderItem(orderItem);
            order.setMember(saveMockMember());
            order.setStatus(OrderStatus.ORDER);
            final Order savedOrder = orderRepository.save(order);
            return savedOrder;
        }

        private Delivery saveMockDelivery() {
            final Delivery delivery = new Delivery();
            delivery.setCity(인천);
            delivery.setStatus(DeliveryStatus.READY);
            delivery.setZipcode("22140");
            delivery.setStreet(남구);
            final Delivery savedDelivery = deliveryRepository.save(delivery);
            return savedDelivery;
        }
    }
    
}
