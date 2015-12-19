package jpabook.chap01;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
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
public class TestChapter01 {

	@PersistenceContext EntityManager em;
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
		   	 members.forEach(n->System.out.println(n.getId()+","+n.getName()));
		   	 System.out.println("JPA Search! ");
		   	 Member getMember = em.find(Member.class, 1L);
		   	 if(getMember!=null){
		   		 System.out.println("getMember :: "+getMember.getName());
		   	 }else{
		   		 System.out.println(" Member null ? ");
		   	 }
		}
	}
	
}
