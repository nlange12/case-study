package com.casestudy.controller;

import java.security.Principal;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.casestudy.dao.CommentDAO;
import com.casestudy.dao.CredentialDAO;
import com.casestudy.dao.EventDAO;
import com.casestudy.dao.MemberDAO;
import com.casestudy.model.Authorities;
import com.casestudy.model.Comment;
import com.casestudy.model.Credentials;
import com.casestudy.model.Event;
import com.casestudy.model.Member;
import com.casestudy.model.RSVP;

@Controller
public class CommentController {

	@Autowired
	EventDAO eDAO;
	@Autowired
	CommentDAO comDAO;
	@Autowired
	MemberDAO mDAO;
	@Autowired
	CredentialDAO cDAO;

	// takes you to Event Details page to post a comment
	@RequestMapping("/events/{id}/comments")
	public ModelAndView leaveComment(@PathVariable("id") long id, Principal principal) {
		ModelAndView mv = new ModelAndView("postComment");
		Event event = eDAO.findById(id);
		Member member = mDAO.getMemberByUsername(principal.getName());
		Credentials cred = cDAO.getCredByUsername(principal.getName());
		Set<String> authorities = new HashSet<String>(Arrays.asList(cred.getAuthorities().stream().map(a -> a.getAuthority()).toArray(String[]::new)));
		if(authorities.contains("ROLE_ADMIN")) {
			mv.addObject("role","admin");
		}
		mv.addObject("member", member);
		mv.addObject("event", event);
		mv.addObject("rsvp", new RSVP());
		mv.addObject("commentObj", new Comment());
		return mv;
	}

	// Adds comment to Event
	@RequestMapping(value = "/events/{id}/comment", method = RequestMethod.POST)
	public ModelAndView postComment(String content, @PathVariable("id") long id, Principal principal,
			RedirectAttributes redirect) {
		ModelAndView mv = new ModelAndView("redirect:/events");
		Event event = eDAO.findById(id);
		Comment comment = new Comment();
		Member member = mDAO.getMemberByUsername(principal.getName());
		if(content == null) {
			mv= new ModelAndView("redirect:/events/{id}/comments");
			redirect.addFlashAttribute("message","Comment cannot be empty!");
		}else {
		comment.setContent(content);
		comment.setEvent(event);
		comment.setMember(member);
		comment.setTimestamp(new Date());
		event.getComments().add(comment);
		member.getComments().add(comment);
		comDAO.addComment(comment);
		}
		return mv;
	}
	//edit comment
	@RequestMapping("/events/editcomment/{id}")
	public ModelAndView editComment(@PathVariable("id") long id) {
		ModelAndView mv = new ModelAndView("editComment");
		Comment comment = comDAO.findCommentById(id);
		Event event = eDAO.findById(id);
		mv.addObject("event", comment.getEvent());
		mv.addObject("commentObj", comment);
		return mv;
	}
	//post edited comment
	@RequestMapping(value = "/events/editcomment/{id}/processEdit", method = RequestMethod.POST)
	public ModelAndView postEditComment(RedirectAttributes redirect, Principal principal,
			@Valid @ModelAttribute("commentObj") Comment com, @PathVariable("id") long id) {
		ModelAndView mv = new ModelAndView("redirect:/events");
		Comment comment = comDAO.findCommentById(id);
		Event event = eDAO.findById(id);
		comment.setContent(com.getContent());
		comDAO.updateComment(comment);
		redirect.addFlashAttribute("message", "Comment Sucessfully Updated!");

		return mv;
	}
	//delete comment
	@RequestMapping(value = "/events/deletecomment/{id}")
	public ModelAndView deleteUser(@PathVariable("id") long id, RedirectAttributes redirect, Principal principal) {
		comDAO.deleteComment(comDAO.findCommentById(id));
		redirect.addFlashAttribute("message", "Comment Successfully Deleted!");
		ModelAndView mv = new ModelAndView("redirect:/events");
		return mv;
	}
	

}
