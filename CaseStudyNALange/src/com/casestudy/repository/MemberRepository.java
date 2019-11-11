package com.casestudy.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.model.Member;

@Repository
public interface MemberRepository extends CrudRepository<Member, String> {

	Member findByUsername(String username);
	
	Member findByName(String name);
	
	List<Member> findByChapName(String chapName);
	
	
}
