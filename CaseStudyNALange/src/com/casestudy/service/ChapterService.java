package com.casestudy.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.dao.ChapterDAO;
import com.casestudy.model.Chapter;
import com.casestudy.model.Credentials;
import com.casestudy.model.Member;
import com.casestudy.repository.ChapterRepository;
import com.casestudy.repository.MemberRepository;

@Service("chapterservice")
public class ChapterService implements ChapterDAO {
	@Autowired
	ChapterRepository chapRepos;
	@Autowired
	MemberRepository memRepos;

	@Override
	public List<Chapter> getAllChapters() {
		List<Chapter> list = new ArrayList<>();
		chapRepos.findAll().forEach(list::add);
		return list;
	}

	@Override
	public List<Member> getAllMembers() {
		List<Member> list = new ArrayList<>();
		memRepos.findAll().forEach(list::add);
		return list;

	}

	@Override
	public boolean addChapter(Chapter chapter) {
		return chapRepos.save(chapter) != null;
	}

	@Override
	public Chapter getChapterByName(String name) {
		return chapRepos.findByName(name);
	}

	@Override
	public void saveChap(Chapter chap) {
		chapRepos.save(chap);
	}

}
