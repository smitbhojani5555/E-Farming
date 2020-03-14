package com.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.services.EmailService;
import com.services.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;
	@Autowired
	private EmailService emailService;

	@RequestMapping("login.htm")
	public ModelAndView verifyAdmin(HttpServletRequest request, HttpServletResponse response, Model m) {
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		boolean result = false;
		JSONObject jsonObject = new JSONObject();
		List<Object[]> user = loginService.verifyUser(userName, password);
		if (user != null && !user.isEmpty() && user.get(0) != null) {
			HttpSession session = request.getSession(true);
			session.setAttribute("userId", user.get(0)[0].toString());
		    session.setAttribute("userType", user.get(0)[2].toString());
			session.setAttribute("username", user.get(0)[1].toString());

			jsonObject.put("userId", user.get(0)[0].toString());
			result = true;
			jsonObject.put("response", result);
		}

		try {
			response.getWriter().write(jsonObject.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@RequestMapping("adminlogin.htm")
	public ModelAndView verifyAdminlogin(HttpServletRequest request, HttpServletResponse response, Model m) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("adminlogin");
		return mv;
	}

	@RequestMapping("verifyAdmin.htm")
	public String verifyadmin(HttpServletRequest request, HttpServletResponse response, Model m) {
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		String result = "adminlogin";
		List<Object[]> user = loginService.verifyAdmin(userName, password);
		if (user != null && !user.isEmpty() && user.get(0) != null) {
			HttpSession session = request.getSession(true);
			session.setAttribute("userId", user.get(0)[0].toString());
			session.setAttribute("isadmin", true);
			result = "home";
		}
		return result;
	}

	@RequestMapping("logout.htm")
	public RedirectView logOut(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		session.invalidate();
		return new RedirectView("home.htm");
	}

	@RequestMapping("deleteuser.htm")
	public RedirectView deleteuser(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		int userid = Integer.parseInt(request.getParameter("userid"));
		String userList = loginService.removeuser(userid);
		mv.addObject("userList", userList);

		return new RedirectView("useradmin.htm");
	}

	@RequestMapping("forgotpassword.htm")
	public ModelAndView verifyforgotpassword(HttpServletRequest request, HttpServletResponse response, Model m) {
		ModelAndView mv = new ModelAndView();
		String userName = request.getParameter("forgotemail");
		int usertype = Integer.parseInt(request.getParameter("fusertype"));
		int status = 1;
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		String createddate = dateFormat.format(date);
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 8) { // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String token = salt.toString();

		List<Object[]> user = loginService.verifyforgotpassword(userName, usertype);

		String fpasswordList = loginService.insertforgotpassword(userName, createddate, token, status, usertype);
		try {
			emailService.sendAshtml(userName, "registration message",
					"<a href='http://localhost:8080/EFarming/forgotpasswordmail.htm?token=" + token
							+ "'>Reset My Password</a>");

		} catch (javax.mail.MessagingException e) {

			e.printStackTrace();
		}
		mv.setViewName("home");
		return mv;
	}

	@RequestMapping("forgotpasswordmail.htm")
	public ModelAndView verifyforgotpasswordmail(HttpServletRequest request, HttpServletResponse response, Model m) {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession(true);
		String token = request.getParameter("token");
		List<Object[]> user = loginService.veryfyemail(token);
		if (user != null && !user.isEmpty() && user.get(0) != null) {
			String usertype = user.get(0)[1].toString();
			String email = user.get(0)[0].toString();
			List<Object[]> employeeId1 = loginService.getuserId(usertype, email);
			session.setAttribute("userId1", employeeId1.get(0)[0].toString());
			mv.setViewName("forgotpassword");
			
		}else
		{
			mv.setViewName("home");
		}
		return mv;
		
	}

	@RequestMapping("updatepassword.htm")
	public ModelAndView setnewpassword(HttpServletRequest request, HttpServletResponse response, Model m) {
		ModelAndView mv = new ModelAndView();
		String userId = request.getParameter("userId");
		String password = request.getParameter("newpassword");
		String user = loginService.updatePassword(userId, password);
		mv.setViewName("home");
		return mv;

	}
	
	@RequestMapping("userdelete.htm")
	public RedirectView redirectdisplay(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		int status=Integer.parseInt(request.getParameter("status"));
	      Long userId=Long.parseLong(request.getParameter("id"));
		String userList = loginService.deleteuser(status,userId);
		HttpSession session = request.getSession(true);
		mv.addObject("userList", userList);
		mv.setViewName("product");
		return new RedirectView("adminuser.htm");
	}
}
