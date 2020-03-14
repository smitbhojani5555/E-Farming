package com.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.services.EmailService;
import com.services.EventService;

@Controller
public class AjaxContoller {
	
	@Autowired
	private EventService eventService;
	@Autowired
	private EmailService emailService;
	
	@RequestMapping("farmerentry.htm")
	public ModelAndView redirectdisplay(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv= new ModelAndView();
		HttpSession session= request.getSession(true);
			Long UserId=Long.parseLong(request.getParameter("userId"));
			String username=String.valueOf(session.getAttribute("username"));
			JSONObject jsonObject = new JSONObject();
		String farmerList = eventService.listregisteredfarmer(UserId);
		try {
			emailService.sendAshtml(username,request.getParameter("EventRegistration Message"), "Dear sir you are registered for the event check timings for the event");
		} catch (javax.mail.MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jsonObject.put("userId",session.getAttribute("userId"));
		
		try {
			response.getWriter().write(jsonObject.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	   }
		
	}
