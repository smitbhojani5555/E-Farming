package com.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.services.EventService;

@Controller
public class EventController {
	@Autowired
	private EventService eventService;

	@RequestMapping("event.htm")
	public ModelAndView redirect(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession(true);
		List<Object[]> eventList1 = eventService.listevent();
		mv.addObject("eventList1", session.getAttribute("userId"));
		mv.addObject("eventList1", eventList1);
		mv.setViewName("event");
		return mv;

	}

	@RequestMapping("delete.htm")
	public ModelAndView redirectdisplay(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		int status = Integer.parseInt(request.getParameter("status"));
		int eventid = Integer.parseInt(request.getParameter("eventid"));
		String eventList = eventService.deleteevent(status, eventid);
		HttpSession session = request.getSession(true);
		mv.addObject("eventList", eventList);
		mv.setViewName("event");
		return mv;
	}

	@RequestMapping("join.htm")
	public ModelAndView joinredirect(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		List<Object[]> eventList = eventService.listevent();
		mv.addObject("eventList", eventList);
		mv.setViewName("eventregister");
		return mv;

	}

	@RequestMapping("addevent.htm")
	public RedirectView insert(HttpServletRequest request, HttpServletResponse response,
			@RequestParam CommonsMultipartFile eventimage) throws Exception, IOException {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession(true);
		String path = session.getServletContext().getRealPath("/");
		String filename = eventimage.getOriginalFilename();
		System.out.println(path + " " + filename);
		try {
			byte barr[] = eventimage.getBytes();
			BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(path + "/" + filename));
			bout.write(barr);
			bout.flush();
			bout.close();

		} catch (Exception e) {
			System.out.println(e);
		}

		byte[] File = eventimage.getBytes();
		String s = Base64.getEncoder().encodeToString(File);
		eventService.insertEvent(request.getParameter("subject"), request.getParameter("discription"),
				request.getParameter("place"), request.getParameter("date"), request.getParameter("time"), File);
		List<Object[]> eventList = eventService.listadminevent();
		mv.addObject("eventList", eventList);
		mv.setViewName("adminevent");
		return new RedirectView("eventadmin.htm");

	}

	@RequestMapping("deleteevent.htm")
	public RedirectView redirectto(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		int eventid = Integer.parseInt(request.getParameter("eventid"));
		String eventList = eventService.removeevent(eventid);
		return new RedirectView("eventadmin.htm");

	}

}
