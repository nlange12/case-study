package com.casestudy.dao;

import java.util.List;

import com.casestudy.model.Member;

public interface MemberDAO {

	public Member getMemberByName(String name);
	
	public Member getMemberByUsername(String username);
	
	public boolean addMember(Member member);
	
	public List<Member> getAllMembers();
	
	public void deleteMemberByUsername(String username);
	
	 public boolean updateMember(Member member);
	 
	 public List<Member> getChapterMembers(String chapName);
}
