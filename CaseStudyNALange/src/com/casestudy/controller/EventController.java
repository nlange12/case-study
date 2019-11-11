package com.casestudy.controller;

import java.security.Principal;
import java.util.Date;

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

import com.casestudy.dao.EventDAO;
import com.casestudy.dao.MemberDAO;
import com.casestudy.model.Event;
import com.casestudy.model.Member;

@Controller
public class EventController {

	@Autowired
	EventDAO eDAO;
	@Autowired
	MemberDAO mDAO;

	// create a new event
	@RequestMapping("/events/createnew")
	public ModelAndView createEvent() {
		ModelAndView mv = new ModelAndView("post");
		mv.addObject("eventObj", new Event());
		return mv;
	}

	// adds new event to databse
	@RequestMapping(value = "/events/processEvent", method = RequestMethod.POST)
	public ModelAndView postEvent(RedirectAttributes redirect, Principal principal, @RequestParam("title") String title,
			@Valid @ModelAttribute("eventObj") Event eve, @RequestParam("content") String content) {
		ModelAndView mv = new ModelAndView("redirect:/events");
		Event event = new Event();
		Member member = mDAO.getMemberByUsername(principal.getName());
		event.setContent(content);
		event.setTitle(title);
		event.setTimestamp(new Date());
		event.setMember(member);
		member.getEvents().add(event);
		eDAO.addEvent(event);
		redirect.addFlashAttribute("message", "Event Sucessfully Uploaded!");
		return mv;

	}
	//edit event
	@RequestMapping("/events/{id}/edit")
	public ModelAndView editEvent(@PathVariable("id") long id) {
		ModelAndView mv = new ModelAndView("editEvent");
		Event event = eDAO.findById(id);
		mv.addObject("eventObj", event);
		mv.addObject("action", "update");
		return mv;
	}
	//process edited event
	@RequestMapping(value = "/events/{id}/processEdit", method = RequestMethod.POST)
	public ModelAndView editEventPost(RedirectAttributes redirect, Principal principal,
			@RequestParam("title") String title, @Valid @ModelAttribute("eventObj") Event eve,
			@RequestParam("content") String content, @PathVariable("id") long id) {
		ModelAndView mv = new ModelAndView("redirect:/events");
		Event event = eDAO.findById(id);
		event.setContent(eve.getContent());
		event.setTitle(eve.getTitle());
		eDAO.updateEvent(event);
		redirect.addFlashAttribute("message", "Event Sucessfully Updated!");

		return mv;
	}
	//delete event
	@RequestMapping(value = "events/{id}/delete")
	public ModelAndView deleteUser(@PathVariable("id") long id, RedirectAttributes redirect, Principal principal) {
		eDAO.deleteEvent(eDAO.findById(id));
		redirect.addFlashAttribute("message", "Event Successfully Deleted!");
		ModelAndView mv = new ModelAndView("redirect:/events");
		return mv;
	}

}
