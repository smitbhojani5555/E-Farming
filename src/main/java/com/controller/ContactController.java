package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.services.ContactService;
import com.services.EmailService;
import com.services.EventService;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;

@Controller
public class ContactController {
	@Autowired
	private ContactService contactService;
	
	@Autowired
	private EmailService emailService;
	
	@RequestMapping("contact.htm")
	public ModelAndView redirect(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		HttpSession session =  request.getSession(true);
	     mv.setViewName("contact");
	     mv.addObject("userId",session.getAttribute("userId"));
	   return mv;
	}
	@RequestMapping("sendmessage.htm")
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) throws MessagingException {
		ModelAndView mv = new ModelAndView();
        
		contactService.addUser(request.getParameter("Name"), request.getParameter("message"),
				request.getParameter("Email"));
		try {
			emailService.sendAshtml("efarmingcontact@gmail.com",request.getParameter("message"), "jaymataji");
		} catch (javax.mail.MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<Object[]> userList = contactService.listUser();
		mv.addObject("userList", userList);
		
		mv.setViewName("home");
		return mv;

	}
	@RequestMapping("about.htm")
	public ModelAndView redirecttoabout(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		HttpSession session=request.getSession(true);
		mv.addObject("userId",session.getAttribute("userId"));
	   mv.setViewName("about");
	   return mv;
	}
}  