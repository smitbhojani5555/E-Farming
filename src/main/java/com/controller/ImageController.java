package com.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.services.ImageService;

@Controller
public class ImageController {
	@Autowired
	private ImageService imageService;

	@RequestMapping("productimage.htm")
	public ModelAndView redirect(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ModelAndView mv = new ModelAndView();
		long productid = Long.parseLong(request.getParameter("productid"));

		List<Object> productList = imageService.listimageproduct(productid);
		byte[] image = (byte[]) productList.get(0);

		response.setContentType("image");
		response.setBufferSize(image.length);
		response.setContentLength(image.length);
		InputStream in = new ByteArrayInputStream(image);

		OutputStream out = response.getOutputStream();
		try {
			byte[] buf = new byte[1024];
			int len;
			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}
			out.close();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@RequestMapping("eventimage.htm")
	public ModelAndView redirecteventimage(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		ModelAndView mv = new ModelAndView();

		int eventid = Integer.parseInt(request.getParameter("eventid"));
		List<Object> productList = imageService.listimage(eventid);

		byte[] image = (byte[]) productList.get(0);

		response.setContentType("image");
		response.setBufferSize(image.length);
		response.setContentLength(image.length);
		InputStream in = new ByteArrayInputStream(image);

		OutputStream out = response.getOutputStream();
		try {
			byte[] buf = new byte[1024];
			int len;
			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}
			out.close();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	@RequestMapping("singleeventimage.htm")
	public ModelAndView redirectproductimagedisplay(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		ModelAndView mv = new ModelAndView();

		int eventid = Integer.parseInt(request.getParameter("id"));
		List<Object> productList = imageService.listeventimage(eventid);

		byte[] image = (byte[]) productList.get(0);

		response.setContentType("image");
		response.setBufferSize(image.length);
		response.setContentLength(image.length);
		InputStream in = new ByteArrayInputStream(image);

		OutputStream out = response.getOutputStream();
		try {
			byte[] buf = new byte[1024];
			int len;
			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}
			out.close();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	@RequestMapping("singleproductimage.htm")
	public ModelAndView redirecteventimagedisplay(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		ModelAndView mv = new ModelAndView();
		Long productid = Long.parseLong(request.getParameter("id"));
		List<Object> productList = imageService.listsingleproductimage(productid);
		byte[] image = (byte[]) productList.get(0);
		response.setContentType("image");
		response.setBufferSize(image.length);
		response.setContentLength(image.length);
		InputStream in = new ByteArrayInputStream(image);
		OutputStream out = response.getOutputStream();
		try {
			byte[] buf = new byte[1024];
			int len;
			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}
			out.close();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping("userimage.htm")
	public ModelAndView redirectuserimagedisplay(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		ModelAndView mv = new ModelAndView();
		Long userid = Long.parseLong(request.getParameter("userid"));
		List<Object> userList = imageService.listuserimage(userid);
		byte[] image = (byte[]) userList.get(0);
		response.setContentType("image");
		response.setBufferSize(image.length);
		response.setContentLength(image.length);
		InputStream in = new ByteArrayInputStream(image);
		OutputStream out = response.getOutputStream();
		try {
			byte[] buf = new byte[1024];
			int len;
			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}
			out.close();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping("userdocumentimage.htm")
	public ModelAndView redirectuserdocumentimagedisplay(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		ModelAndView mv = new ModelAndView();
		Long userid = Long.parseLong(request.getParameter("userid"));
		List<Object> userList = imageService.listuserdocumentimage(userid);
		byte[] image = (byte[]) userList.get(0);
		response.setContentType("image");
		response.setBufferSize(image.length);
		response.setContentLength(image.length);
		InputStream in = new ByteArrayInputStream(image);
		OutputStream out = response.getOutputStream();
		try {
			byte[] buf = new byte[1024];
			int len;
			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}
			out.close();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
