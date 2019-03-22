package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.services.EventService;
import com.services.GovermentPoliciesService;
import com.services.LoginService;
import com.services.ProductService;
import com.services.QueryService;

@Controller
public class AdminController {
	@Autowired
	private ProductService productService;
	@Autowired
	private EventService eventService;
	@Autowired
	private GovermentPoliciesService govermentpoliciesService;
	@Autowired
	private QueryService queryService;
	@Autowired
	private LoginService loginService;

	@RequestMapping("dashbord.htm")
	public ModelAndView verifyAdminlogin(HttpServletRequest request, HttpServletResponse response, Model m) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("adminhome");
		return mv;
	}

	@RequestMapping("productadmin.htm")
	public ModelAndView redirectadminproduct(HttpServletRequest request, HttpServletResponse response, Model m) {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession(true);
		List<Object[]> productList1 = productService.listadminproduct();
		mv.addObject("productList1", productList1);

		mv.setViewName("adminproduct");
		return mv;
	}

	@RequestMapping("eventadmin.htm")
	public ModelAndView redirectadminevent(HttpServletRequest request, HttpServletResponse response, Model m) {
		ModelAndView mv = new ModelAndView();
		List<Object[]> eventList = eventService.listadminevent();
		mv.addObject("eventList", eventList);
		mv.setViewName("adminevent");
		return mv;
	}

	@RequestMapping("policyadmin.htm")
	public ModelAndView redirectadminpolicy(HttpServletRequest request, HttpServletResponse response, Model m) {
		ModelAndView mv = new ModelAndView();
		List<Object[]> govermentpoliciesList1 = govermentpoliciesService.listadminpolicies();
		mv.addObject("govermentpoliciesList1", govermentpoliciesList1);
		mv.setViewName("admingovermentpolicies");
		return mv;
	}

	@RequestMapping("queriesadmin.htm")
	public ModelAndView redirectadminqueries(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession(true);
		List<Object[]> problemList1 = queryService.listadminqueries();
		mv.addObject("problemList1", problemList1);
		mv.setViewName("adminqueries");
		return mv;
	}

	@RequestMapping("useradmin.htm")
	public ModelAndView redirectadminuser(HttpServletRequest request, HttpServletResponse response, Model m) {
		ModelAndView mv = new ModelAndView();
		List<Object[]> userList = loginService.listUser();
		mv.addObject("userList", userList);
		mv.setViewName("adminuser");
		return mv;
	}
}
