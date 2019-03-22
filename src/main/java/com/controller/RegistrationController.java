package com.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

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

import com.services.EmailService;
import com.services.ImageService;
import com.services.RegistrationService;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import com.table.TblUser;

@Controller
public class RegistrationController {
	@Autowired
	private RegistrationService registrationService;
	@Autowired
	private EmailService emailService;
	@Autowired
	private ImageService imageService;

	TblUser user = new TblUser();

	@RequestMapping("register.htm")
	public RedirectView insert(HttpServletRequest request, HttpServletResponse response,
			 @RequestParam CommonsMultipartFile file,@RequestParam CommonsMultipartFile userdocument) throws Exception, IOException {
		ModelAndView mv = new ModelAndView();
		HttpSession session=request.getSession(true);
		 
		int usertype = Integer.parseInt(request.getParameter("usertype"));
		String agronomisttype = request.getParameter("agronomisttype");
		String path=session.getServletContext().getRealPath("/");  
        String filename=file.getOriginalFilename();  
        String filename1=userdocument.getOriginalFilename();  
        System.out.println(path+" "+filename);  
        try{  
        byte barr[]=file.getBytes();
        byte doc[]=userdocument.getBytes();
        BufferedOutputStream bout=new BufferedOutputStream(  
                new FileOutputStream(path+"/"+filename));  
        BufferedOutputStream dout=new BufferedOutputStream(  
                new FileOutputStream(path+"/"+filename1));  
       bout.write(barr);  
       dout.write(doc);
       bout.flush();
       dout.flush();       bout.close();  
       dout.close();
         
       }catch(Exception e){System.out.println(e);}  
       
		byte[] File = file.getBytes();
		 String s = Base64.getEncoder().encodeToString(File);
		 byte[] File1 = userdocument.getBytes();
		 String s1 = Base64.getEncoder().encodeToString(File1);
		registrationService.addUser(request.getParameter("firstname"), request.getParameter("lastname"),
				request.getParameter("name"), request.getParameter("email"), request.getParameter("mobileno"),
				request.getParameter("password1"), usertype,File,File1,agronomisttype);
		try {
			emailService.sendAshtml(request.getParameter("email"), "registration message",
					"you have registered in the efarming");

		} catch (javax.mail.MessagingException e) {

			e.printStackTrace();
	}
		
		return new RedirectView("home.htm");

	}

}
