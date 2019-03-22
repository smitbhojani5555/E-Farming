package com.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("FileUploadController")
public class FileUploadController {
	@Autowired
	ServletContext context;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getPage() {
		ModelAndView mv = new ModelAndView();
		return mv;
	}

	@RequestMapping(value = "fileupload", method = RequestMethod.POST)

	public @ResponseBody Map<String, Object> fileUpload(MultipartHttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<String> list = new ArrayList<String>();
		Iterator itr = request.getFileNames();
		MultipartFile mpf = null;
		while (itr.hasNext())
			mpf = request.getFile((String) itr.next());
		{
			try {
				FileCopyUtils.copy(mpf.getBytes(), new FileOutputStream(
						context.getRealPath("/resources") + "/" + mpf.getOriginalFilename().replace(" ", ".")));
				list.add(mpf.getOriginalFilename().replace(" ", "."));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		map.put("status", "2000");
		map.put("successfulList", "fileUploadedlist");
		return map;

	}

}
