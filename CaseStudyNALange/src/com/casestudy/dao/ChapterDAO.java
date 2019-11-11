package com.casestudy.dao;

import java.util.List;

import com.casestudy.model.Chapter;
import com.casestudy.model.Member;

public interface ChapterDAO {

	public List<Chapter> getAllChapters();

	public List<Member> getAllMembers();

	public boolean addChapter(Chapter chapter);

	public Chapter getChapterByName(String name);

	public void saveChap(Chapter chap);
}
