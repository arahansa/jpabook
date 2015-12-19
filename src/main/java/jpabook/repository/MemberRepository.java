package jpabook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jpabook.model.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{

}
