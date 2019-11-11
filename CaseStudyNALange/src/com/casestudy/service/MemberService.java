package com.casestudy.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.dao.MemberDAO;
import com.casestudy.model.Member;
import com.casestudy.repository.MemberRepository;

@Transactional
@Service
public class MemberService implements MemberDAO {

	MemberRepository memRepos;

	@Autowired
	public MemberService(MemberRepository memRepos) {
		super();
		this.memRepos = memRepos;
	}

	@Override
	public Member getMemberByName(String name) {
		return memRepos.findByName(name);
	}

	@Override
	public Member getMemberByUsername(String username) {
		return memRepos.findByUsername(username);
	}

	@Override
	public boolean addMember(Member member) {
		return memRepos.save(member) != null;
	}

	@Override
	public List<Member> getAllMembers() {
		List<Member> memberList = new ArrayList<Member>();
		memRepos.findAll().forEach(memberList::add);
		return memberList;
	}

	@Override
	public void deleteMemberByUsername(String username) {
		Member member = memRepos.findByUsername(username);
		memRepos.delete(member);
	}

	@Override
	@Transactional
	public boolean updateMember(Member member) {
		return memRepos.save(member) != null;
	}

	@Override
	public List<Member> getChapterMembers(String chapName) {
		List<Member> list = new ArrayList<>();
		memRepos.findByChapName(chapName).forEach(list::add);
		return list;
	}

}
