package com.casestudy.controller;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.casestudy.dao.EventDAO;
import com.casestudy.dao.MemberDAO;
import com.casestudy.dao.RSVPDAO;
import com.casestudy.model.Event;
import com.casestudy.model.Member;
import com.casestudy.model.RSVP;

@Controller
public class EventController {

	@Autowired
	EventDAO eDAO;
	@Autowired
	MemberDAO mDAO;
	@Autowired
	RSVPDAO rDAO;

	@InitBinder
	public void initialbinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		binder.registerCustomEditor(Date.class, "date", new CustomDateEditor(sdf, false));
	}

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
			@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
			@Valid @ModelAttribute("eventObj") Event eve,BindingResult br, @RequestParam("content") String content) {
		ModelAndView mv = new ModelAndView("redirect:/events");
		Event event = new Event();
		Member member = mDAO.getMemberByUsername(principal.getName());
		if (br.hasErrors()) {
			mv = new ModelAndView("post");
			mv.addObject("eventObj", new Event());
            mv.addObject("message","Events Must Have a Title,Date, and Description!");
        }
		
		event.setContent(content);
		event.setTitle(title);
		event.setDate(date);
		event.setTimestamp(new Date());
		event.setMember(member);
		member.getEvents().add(event);
		eDAO.addEvent(event);
		redirect.addFlashAttribute("message", "Event Sucessfully Uploaded!");
		return mv;

	}

	// edit event
	@RequestMapping("/events/{id}/edit")
	public ModelAndView editEvent(@PathVariable("id") long id) {
		ModelAndView mv = new ModelAndView("editEvent");
		Event event = eDAO.findById(id);
		mv.addObject("eventObj", event);
		mv.addObject("action", "update");
		return mv;
	}

	// process edited event
	@RequestMapping(value = "/events/{id}/processEdit", method = RequestMethod.POST)
	public ModelAndView editEventPost(RedirectAttributes redirect, Principal principal,
			@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
			@RequestParam("title") String title, @Valid @ModelAttribute("eventObj") Event eve,
			@RequestParam("content") String content, @PathVariable("id") long id, BindingResult br) {
		ModelAndView mv = new ModelAndView("redirect:/events");
		Event event = eDAO.findById(id);
		event.setContent(eve.getContent());
		event.setTitle(eve.getTitle());
		event.setDate(eve.getDate());
		eDAO.updateEvent(event);
		redirect.addFlashAttribute("message", "Event Sucessfully Updated!");

		return mv;
	}

	// delete event
	@RequestMapping(value = "events/{id}/delete")
	public ModelAndView deleteUser(@PathVariable("id") long id, RedirectAttributes redirect, Principal principal) {
		eDAO.deleteEvent(eDAO.findById(id));
		redirect.addFlashAttribute("message", "Event Successfully Deleted!");
		ModelAndView mv = new ModelAndView("redirect:/events");
		return mv;
	}

	// search events by between two dates
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ModelAndView search(@RequestParam("d1") @DateTimeFormat(pattern = "yyyy-MM-dd") Date d1,
			@RequestParam("d2") @DateTimeFormat(pattern = "yyyy-MM-dd") Date d2, RedirectAttributes redirect)
			throws ParseException {
		List<Event> list = new ArrayList<Event>();
		ModelAndView mv = null;
		if (d1 == null || d2 == null) {
			mv = new ModelAndView("redirect:/events");
			return mv;
		}

		list = eDAO.getEventByDate(d1, d2);
		if (list.size() == 0) {
			redirect.addFlashAttribute("message", "No Results Found!");
			mv = new ModelAndView("redirect:/events");
			return mv;

		} else {
			mv = new ModelAndView("events");
			mv.addObject("eventList", list);
			return mv;
		}

	}
	//rsvp for event
	@RequestMapping(value = "/events/{id}/rsvp", method = RequestMethod.POST)
	public ModelAndView rsvpForEvent( @PathVariable("id") long id, Principal principal,
			RedirectAttributes redirect) {
		ModelAndView mv = new ModelAndView("redirect:/events");
		Event event = eDAO.findById(id);
		Member member = mDAO.getMemberByUsername(principal.getName());
		RSVP rsvp = new RSVP();
		rsvp.setName(member.getName());
		rsvp.setEmail(member.getEmail());
		rsvp.setChapName(member.getChapName());
		rsvp.setMember(member);
		rsvp.setEvent(event);
		event.getRsvp().add(rsvp);
		member.getRsvp().add(rsvp);
		rDAO.addRSVP(rsvp);
		redirect.addFlashAttribute("message", "You Have Succesfully RSVP'd for This Event!");
		return mv;
	}
	//unrsvp for event
	@RequestMapping(value = "/events/{id}/unrsvp")
	public ModelAndView unRSVP(@PathVariable("id") long id, RedirectAttributes redirect, Principal principal) {
		Member member = mDAO.getMemberByUsername(principal.getName());
		Event event = eDAO.findById(id);
		ModelAndView mv= null;
		rDAO.deleteRSVP(rDAO.findById(id));
		redirect.addFlashAttribute("message", "You Have UN-RSVP'd for this event!");
		 mv = new ModelAndView("redirect:/events");
		return mv;
	}

}
