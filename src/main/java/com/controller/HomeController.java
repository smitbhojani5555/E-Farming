package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.services.EventService;
import com.services.ProductService;

@Controller
public class HomeController {
	@Autowired
	private EventService eventService;
	@Autowired
	private ProductService productService;

	@RequestMapping("home.htm")
	public ModelAndView redirect(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession(true);	
		List<Object[]> eventList = eventService.listhomeevent();
		mv.addObject("eventList", eventList);
		mv.addObject("userId", session.getAttribute("userId"));
		mv.addObject("isadmin", session.getAttribute("isadmin"));
		mv.addObject("userType", session.getAttribute("userType"));
		mv.setViewName("home");
		return mv;
	}

	@RequestMapping("fromhome.htm")
	public ModelAndView display(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession(true);	
		List<Object[]> eventList = eventService.listevent();
		mv.addObject("eventList", eventList);
		mv.addObject("userId", session.getAttribute("userId"));
		mv.addObject("isadmin", session.getAttribute("isadmin"));
		mv.addObject("userType", session.getAttribute("userType"));
		mv.setViewName("home");
		return mv;
	}

	@RequestMapping("eventredirect.htm")
	public ModelAndView displayevent(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession(true);	
		int eventid =Integer.parseInt(request.getParameter("id"));
		List<Object[]> eventimageList = eventService.displayevent(eventid);
		mv.addObject("eventimageList", eventimageList);
		mv.addObject("userId", session.getAttribute("userId"));
		mv.setViewName("singleevent");
		return mv;
	}
	
	@RequestMapping("productmanage.htm")
	public ModelAndView manageproduct(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		HttpSession session= request.getSession(true);	
		long userId=Long.valueOf((String) session.getAttribute("userId"));
		List<Object[]> productList2 = productService.listcompanyproduct(userId);
		mv.addObject("productList2", productList2);
			mv.setViewName("companyproduct");
		return mv;
	}
}
