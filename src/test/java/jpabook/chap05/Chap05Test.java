package jpabook.chap05;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import jpabook.model.entity.Item;
import jpabook.model.entity.Order;
import jpabook.model.entity.OrderItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import jpabook.JpabookApplication;
import jpabook.model.entity.Member;
import jpabook.repository.MemberRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=JpabookApplication.class)
@WebAppConfiguration
@EnableTransactionManagement
public class Chap05Test {


	@Autowired TestService testService;
	@Autowired MemberRepository memberRepository;
	
	@Test
	public void firstTest() throws Exception {
		System.out.println("Hello world?"); 
		testService.createMemberAndMakeOrder();
	}
	
	
	@Transactional
	@Service
	public static class TestService{
		@PersistenceContext EntityManager em;
		@Autowired MemberRepository memberRepository;
		
		public void createMemberAndMakeOrder(){
			System.out.println("JPA test in service running");
		   	 
		   	 Member member = new Member();
		   	 
		   	 member.setCity("Incheon");
		   	 member.setName("arahansa");
		   	 member.setStreet("Namgu");
		   	 member.setZipcode("402743");
		   	 em.persist(member);
		   	 em.flush();
		   	 //memberRepository.save(member);
		   	 
		   	 List<Member> members = memberRepository.findAll();
		   	 members.forEach(n -> System.out.println(n.getId() + "," + n.getName()));

		   	 final Member getMember = em.find(Member.class, 1L);
		   	 if(getMember!=null){
		   		 System.out.println("getMember :: "+getMember.getName());
		   	 }else{
		   		 System.out.println(" Member null ? ");
		   	 }

			Item item = new Item();
			item.setName("맥북");
			item.setPrice(1000);
			item.setStockQuantity(1);
			em.persist(item);
			em.flush();
			final Item getItem = em.find(Item.class, 1L);

			OrderItem orderItem = new OrderItem();
			orderItem.setCount(1);
			orderItem.setOrderPrice(1500);
			orderItem.setItem(getItem);
			em.persist(orderItem);


			Order order = new Order();
			order.setMember(getMember);
			order.addOrderItem(orderItem);
			order.setOrderDate(new Date());
			em.persist(order);
			em.flush();
			em.clear();
			Order getOrder = em.find(Order.class, 1L);
			OrderItem getOrderItem = getOrder.getOrderItems().get(0);
			System.out.println("아이템 이름  :"+getOrderItem.getItem().getName());
			System.out.println("아이템 주문자 이름  : "+getOrder.getMember().getName());
		}
	}
	
}
