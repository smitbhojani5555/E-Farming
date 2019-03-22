package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.services.GovermentPoliciesService;

@Controller
public class GovermentPoliciesController {
	@Autowired
	private GovermentPoliciesService govermentpoliciesService;

	@RequestMapping("govermentpolicies.htm")
	public ModelAndView redirect(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		HttpSession session= request.getSession(true);
		List<Object[]> govermentpoliciesList = govermentpoliciesService.listpolicies();
		mv.addObject("govermentpolicesList", govermentpoliciesList);
		mv.addObject("userId", session.getAttribute("userId"));
		mv.addObject("usertype", session.getAttribute("usertype"));
		mv.setViewName("govermentpolicies");
		return mv;
	}
	@RequestMapping("addpolicy.htm")
	public ModelAndView redirect1(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
	    int status=0;
		govermentpoliciesService.addPolicies(request.getParameter("title"), request.getParameter("discription"),
	    request.getParameter("createdby"),request.getParameter("critearea"),status);
		List<Object[]> govermentpoliciesList1 = govermentpoliciesService.listadminpolicies();
		mv.addObject("govermentpoliciesList1", govermentpoliciesList1);
	    mv.setViewName("admingovermentpolicies");
		return mv;
		
	}
	@RequestMapping("deletepolicy.htm")
	public RedirectView redirectto(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		int policyid = Integer.parseInt(request.getParameter("policyid"));
		String govermentpoliciesList1  = govermentpoliciesService.removeevent(policyid);
		mv.addObject("govermentpoliciesList1", govermentpoliciesList1);
		
		return new RedirectView("policyadmin.htm");

	}
	@RequestMapping("deletepolicies.htm")
	public ModelAndView redirectdisplay(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		int status=Integer.parseInt(request.getParameter("status"));
		int policyid=Integer.parseInt(request.getParameter("policyid"));
		String govermentpoliciesList = govermentpoliciesService.deletepolicies(status,policyid);
		HttpSession session = request.getSession(true);
		mv.addObject("govermentpoliciesList", govermentpoliciesList);
		mv.setViewName("admingovermentpolicies");
		return mv;
	}

}
