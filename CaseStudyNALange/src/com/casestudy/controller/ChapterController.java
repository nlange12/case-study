package com.casestudy.controller;

import java.security.Principal;

import javax.jws.WebParam.Mode;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.casestudy.dao.ChapterDAO;
import com.casestudy.dao.MemberDAO;
import com.casestudy.model.Chapter;
import com.casestudy.model.Member;
import com.casestudy.service.ChapterService;
import com.casestudy.service.MemberService;

@Controller
@Transactional
public class ChapterController {

	@Autowired
	MemberDAO mDAO;
	@Autowired
	ChapterDAO chapDAO;	
//view all the chapter who currently have members registered to the application
@RequestMapping("/chapters")	
public ModelAndView pickChapter() {
	ModelAndView mv = new ModelAndView("chapters");
	mv.addObject("chapList", chapDAO.getAllChapters());
	return mv;
}
	
	
//create three chapters when application starts	
@RequestMapping("/login")	
public void createChapters() {
	if(chapDAO.getAllChapters().size()==0) {
	Chapter c1 = new Chapter("Nu Tau", "SUNY Albany");
	Chapter c2 = new Chapter("Chi Rho", "Stony Brook");
	Chapter c3 = new Chapter("Kappa Nu", "SUNY Binghamtom");
	
	chapDAO.addChapter(c1);
	chapDAO.addChapter(c2);
	chapDAO.addChapter(c3);
	}
	

}

//display the list of members for that user session's chapter 
@RequestMapping(value = "/members", method = RequestMethod.GET)
public ModelAndView getUserForm(Principal principal) {
	Member member = mDAO.getMemberByUsername(principal.getName());
    ModelAndView mav = new ModelAndView("memberList");
    mav.addObject("memList", mDAO.getChapterMembers(member.getChapter().getName()));
    return mav;
}



}
