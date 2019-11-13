package com.casestudy.controller;

import java.security.Principal;
import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.casestudy.dao.ChapterDAO;
import com.casestudy.dao.CommentDAO;
import com.casestudy.dao.CredentialDAO;
import com.casestudy.dao.EventDAO;
import com.casestudy.dao.MemberDAO;
import com.casestudy.model.Chapter;
import com.casestudy.model.Comment;
import com.casestudy.model.Event;
import com.casestudy.model.Member;
import com.casestudy.service.ChapterService;
import com.casestudy.service.CommentService;
import com.casestudy.service.CredentialsService;
import com.casestudy.service.EventService;
import com.casestudy.service.MemberService;

@Controller
@Transactional
public class HomeController {
	@Autowired
	CredentialDAO cDAO;
	@Autowired
	MemberDAO mDAO;
	@Autowired
	ChapterDAO chapDAO;
	@Autowired
	EventDAO eDAO;
	@Autowired
	CommentDAO comDAO;

	// go to home page after authentication
	@RequestMapping("/")
	public ModelAndView getHome(Principal principal) {
		Member member = mDAO.getMemberByUsername(principal.getName());
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("memberName", member.getName());
		mv.addObject("chapterName", member.getChapter().getName());
		mv.addObject("chapterSchool", member.getChapter().getSchool());
		 mv.addObject("member", member);
		return mv;
	}
	//page showing all events
	@RequestMapping("/events")
	public ModelAndView getEvents(Principal principal) {
		ModelAndView mv = new ModelAndView("events");
		mv.addObject("member", mDAO.getMemberByUsername(principal.getName()));
		mv.addObject("eventList", eDAO.getAllEvents());
		return mv;
	}
	//go to mandated programs page
	@RequestMapping("/programs")
	public ModelAndView seePrograms() {
		ModelAndView mv = new ModelAndView("programs");
		return mv;
	}
}
