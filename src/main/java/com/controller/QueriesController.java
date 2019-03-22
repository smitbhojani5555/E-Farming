package com.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.services.AnswerService;
import com.services.QueryService;
import org.json.*;

@Controller
public class QueriesController {
	@Autowired
	private QueryService queryService;
	@Autowired
	 AnswerService answerService;

	@RequestMapping("queries.htm")
	public ModelAndView redirect(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		List<Object[]> problemList = queryService.listqueries();
		HttpSession session = request.getSession(true);	
		mv.addObject("problemList", problemList);
		mv.addObject("userId", session.getAttribute("userId"));
		mv.addObject("userType", session.getAttribute("userType"));
		mv.addObject("username", session.getAttribute("username"));
		mv.setViewName("queries");
		return mv;
	}

	@RequestMapping("problem.htm")
	public ModelAndView redirecttoproblem(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		HttpSession session=request.getSession(true);
		int problemid =Integer.parseInt(request.getParameter("problemid"));
		List<Object[]> problemList2 = queryService.describeproblem(problemid);
		List<Object[]> answerList=answerService.describeanswer(problemid);
	    mv.addObject("problemList2", problemList2);
	    mv.addObject("answerList", answerList);
	    mv.addObject("userId", session.getAttribute("userId"));
	    mv.addObject("userType", session.getAttribute("userType"));
		mv.setViewName("problem");
		return mv;
	}
	@RequestMapping("insert.htm")
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) throws MessagingException {
		ModelAndView mv = new ModelAndView();
	    long farmerid=Long.parseLong(request.getParameter("userId"));
	    int status=0;
	    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		String createddate=dateFormat.format(date); 
       	queryService.addUser(request.getParameter("subject"),request.getParameter("description"), farmerid,status,createddate);  
		List<Object[]> problemList = queryService.listqueries();
		mv.addObject("problemList", problemList);
		mv.setViewName("queries");
		return mv;

	}
	
	@RequestMapping("insertcomment.htm")
	public ModelAndView insertcomment(HttpServletRequest request, HttpServletResponse response) throws MessagingException {
		ModelAndView mv = new ModelAndView();
	 long agronomistid=Long.parseLong(request.getParameter("userId"));
	 DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		String createddate1=dateFormat.format(date);
	    int problemid=Integer.parseInt(request.getParameter("problemid"));
       	queryService.addComment(request.getParameter("comment"),agronomistid,problemid,createddate1);
       	List<Object[]> problemList2 = queryService.describeproblem(problemid);
		List<Object[]> answerList=answerService.describeanswer(problemid);
	    mv.addObject("problemList2", problemList2);
	    mv.addObject("answerList", answerList);
	    
		mv.setViewName("problem");
		return mv;
	}
	@RequestMapping("searchquery.htm")
	public String searchQuery(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String searchtext = request.getParameter("search");
		
		List<Object[]> searchproblemList = queryService.searchquery(searchtext);
		 final JSONArray dataList = new JSONArray();
         for (final Object[] obj : searchproblemList) {
             final JSONObject returnData = new JSONObject();
             returnData.put("index",obj[0] != null ? obj[0].toString() : "");
             returnData.put("problem",obj[1] != null ? obj[1].toString() : "");
             dataList.put(returnData);
         }
         try {
 			response.getWriter().write(dataList.toString());
 		} catch (IOException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
         
	return null;
	}	
	@RequestMapping("deletequeries.htm")
	public ModelAndView redirectto(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		int problemid = Integer.parseInt(request.getParameter("problemid"));
		String eventList = queryService.removequery(problemid);
		List<Object[]> problemList1 = queryService.listadminqueries();
		mv.addObject("problemList1", problemList1);
		
		mv.setViewName("adminqueries");
		return mv;
	}

	@RequestMapping("deletequery.htm")
	public ModelAndView redirectdisplay(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		int status=Integer.parseInt(request.getParameter("status"));
		int problemid=Integer.parseInt(request.getParameter("problemid"));
		String problemList = queryService.deletequery(status,problemid);
		HttpSession session = request.getSession(true);
		mv.addObject("problemList", problemList);
		mv.setViewName("queries");
		return mv;
	}
}
