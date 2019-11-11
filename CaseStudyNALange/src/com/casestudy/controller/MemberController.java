package com.casestudy.controller;

import java.security.Principal;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.casestudy.model.Credentials;
import com.casestudy.model.Member;
import com.casestudy.dao.ChapterDAO;
import com.casestudy.dao.CredentialDAO;
import com.casestudy.dao.MemberDAO;
import com.casestudy.model.Authorities;
import com.casestudy.model.Chapter;

@Controller
public class MemberController {
	@Autowired
	CredentialDAO cDAO;
	@Autowired
	MemberDAO mDAO;
	@Autowired
	ChapterDAO chapDAO;

	// add forms to registration page
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView getUserCredentialForm() {
		ModelAndView mv = new ModelAndView("registrationForm");
		mv.addObject("resFormObj", new Credentials());
		mv.addObject("memFormObj", new Member());

		return mv;
	}

	// register member
	@RequestMapping(value = "processCredential", method = RequestMethod.POST)
	public ModelAndView loginProcess(@Valid @ModelAttribute("resFormObj") Credentials cred,
			@Valid @ModelAttribute("memFormObj") Member mem, BindingResult br,
			@RequestParam("confpassword") String confpassword, @RequestParam("chapter.name") String chapName,
			@RequestParam("chapter.school") String chapSchool, RedirectAttributes redirect, Principal principal) {
		Credentials credential = cDAO.getCredByUsername(cred.getUsername());
		ModelAndView mv = null;
		Authorities role = new Authorities();
		Chapter chap = chapDAO.getChapterByName(chapName);

		if (br.hasErrors()) {
			br.getAllErrors().forEach(System.out::println);
			mv = new ModelAndView("login");
			mv.addObject("message", "error Loggin in");
		} else {
			if (credential == null) {
				if (cred.getPassword().equals(confpassword)) {

					// create a credential for the member
					credential = new Credentials();
					credential.setName(cred.getName());
					credential.setUsername(cred.getUsername());
					String encoded = new BCryptPasswordEncoder().encode(cred.getPassword());
					credential.setPassword(encoded);
					credential.setEnabled(true);

					// give the credential and authority
					role.setCredentials(credential);
					role.setAuthority("ROLE_USER");
					credential.getAuthorities().add(role);

					// create the new member
					Member mem1 = new Member();
					mem1.setUsername(cred.getUsername());
					mem1.setName(mem.getName());
					mem1.setPassword(cred.getPassword());
					mem1.setPhoneNum(mem.getPhoneNum());
					mem1.setIntiationYr(mem.getIntiationYr());
					mem1.setEmail(mem.getEmail());
					mem1.setChapName(chapName);
					mem1.setCredential(credential);
					credential.setMember(mem1);

					// check to see if the members chapter is already in the database
					// if it is not create a new chapter to add to database
					// if it is add that member to that chapters list of members
					if (chap == null) {
						Chapter newChap = new Chapter();
						newChap.setName(chapName);
						newChap.setSchool(chapSchool);
						chapDAO.addChapter(newChap);
						mem1.setChapter(chapDAO.getChapterByName(chapName));
					} else {
						mem1.setChapter(chapDAO.getChapterByName(chapName));
						chap.getMembers().add(mem1);
					}

					cDAO.addCred(credential);
					mv = new ModelAndView("redirect:/login");
					redirect.addFlashAttribute("message", "Registration Succesful!\n You Can Now Login");
				}
			} else { //update Member information
				Member mem1 = mDAO.getMemberByUsername(principal.getName());

				credential.setName(cred.getName());
				credential.setUsername(cred.getUsername());
				String encoded = new BCryptPasswordEncoder().encode(cred.getPassword());
				credential.setPassword(encoded);
				credential.setEnabled(true);

				mem1.setUsername(cred.getUsername());
				mem1.setName(mem.getName());
				mem1.setPassword(cred.getPassword());
				mem1.setPhoneNum(mem.getPhoneNum());
				mem1.setIntiationYr(mem.getIntiationYr());
				mem1.setEmail(mem.getEmail());
				mem1.setChapName(chapName);
				mem1.setCredential(credential);
				credential.setMember(mem1);

				if (chap == null) {
					Chapter newChap = new Chapter();
					newChap.setName(chapName);
					newChap.setSchool(chapSchool);
					chapDAO.addChapter(newChap);
					mem1.setChapter(chapDAO.getChapterByName(chapName));
				} else {
					mem1.setChapter(chapDAO.getChapterByName(chapName));
				}

				mDAO.updateMember(mem1);
				mv = new ModelAndView("redirect:/");
				redirect.addFlashAttribute("message", "Information Successfully updated!");
			}
		}
		return mv;
	}
	//takes member to edit information page
	@RequestMapping("/edit")
	public ModelAndView editMember(Principal principal) {
		ModelAndView mv = new ModelAndView("registrationForm");
		mv.addObject("resFormObj", cDAO.getCredByUsername(principal.getName()));
		mv.addObject("memFormObj", mDAO.getMemberByUsername(principal.getName()));
		mv.addObject("action", "update");
		return mv;
	}
	//delete member account
	@RequestMapping(value = "/delete/{username}")
	public ModelAndView deleteUser(@PathVariable("username") String username, RedirectAttributes redirect, Principal principal) {
		cDAO.deleteCred(cDAO.getCredByUsername(principal.getName()));
		redirect.addFlashAttribute("message", "User Successfully Deleted!");
		ModelAndView mv = new ModelAndView("redirect:/login");
		return mv;
	}

}
