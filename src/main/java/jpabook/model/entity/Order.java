package jpabook.model.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name="ORDERS")
@Data
public class Order {
	
	
	@Id
	@GeneratedValue
	@Column(name="ORDER_ID")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="MEMBER_ID")
	private Member member;
	
	@OneToMany(mappedBy="order")
	private List<OrderItem> orderItems = new ArrayList<OrderItem>();

	@OneToOne
	@JoinColumn(name="DELIVERY_ID")
	private Delivery delivery; // 배송정보


	@Temporal(TemporalType.TIMESTAMP)
	private Date orderDate; // 주문시간
	
	@Enumerated(EnumType.STRING)
	private OrderStatus status;

	//== 연관관계 메소드 ==//
	public void setMember(Member member){
		//기존 관계 제거
		if(this.member!=null){
			this.member.getOrders().remove(this);
		}
		this.member = member;
		member.getOrders().add(this);
	}
	public void addOrderItem(OrderItem orderItem){
		orderItems.add(orderItem);
		orderItem.setOrder(this);
	}

	public void setDelivery(Delivery delivery){
		this.delivery = delivery;
		delivery.setOrder(this);
	}

}
