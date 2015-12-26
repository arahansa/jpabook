package jpabook.model.entity;

import javax.persistence.*;

import jpabook.model.entity.item.Item;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name="ORDER_ITEM")
@Data
@ToString(exclude="order")
public class OrderItem {
	
	
	@Id
	@GeneratedValue
	@Column(name="ORDER_ITEM_ID")
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="ITEM_ID")
	private Item item;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="ORDER_ID")
	private Order order;
	
	private int orderPrice;
	private int count;

}
