package jpabook.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString(exclude="orders")
public class Member extends BaseEntity{
	
	
	@Id
	@GeneratedValue
	@Column(name="MEMBER_ID")
	private Long id;
	
	private String name;
	
	@Embedded
	private Address address;
	
	@OneToMany(mappedBy="member")
	private List<Order> orders = new ArrayList<>();
	
	

}
