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
import com.services.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;

	@RequestMapping("product.htm")
	public ModelAndView redirect(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession(true);
		List<Object[]> productList = productService.listproduct();
		mv.addObject("productList", productList);
		mv.addObject("isuserId", session.getAttribute("userId"));
		mv.setViewName("product");
		return mv;
	}

	@RequestMapping("listproduct.htm")
	public ModelAndView redirectcompanyproduct(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		int userId = Integer.parseInt(request.getParameter("userId"));
		List<Object[]> productList = productService.listcompanyproduct(userId);
		mv.addObject("productList", productList);
		mv.setViewName("product");
		return mv;
	}

	@RequestMapping("productredirect.htm")
	public ModelAndView productredirect(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		Long productid = Long.parseLong(request.getParameter("productid"));
		List<Object[]> singleproductList = productService.listproductdisplay(productid);
		mv.addObject("singleproductList", singleproductList);
		mv.setViewName("singleproduct");
		return mv;
	}

	@RequestMapping("insertproduct.htm")
	public RedirectView insert(HttpServletRequest request, HttpServletResponse response,
			@RequestParam CommonsMultipartFile productimage) throws Exception, IOException {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession(true);
		long price = Long.parseLong(request.getParameter("price"));
		String path = session.getServletContext().getRealPath("/");
		String filename = productimage.getOriginalFilename();
		System.out.println(path + " " + filename);
		try {
			byte barr[] = productimage.getBytes();
			BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(path + "/" + filename));
			bout.write(barr);
			bout.flush();
			bout.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		byte[] File = productimage.getBytes();
		String s = Base64.getEncoder().encodeToString(File);
		productService.addProduct(request.getParameter("productname"), request.getParameter("content"),
				request.getParameter("discription"), price, File);
		List<Object[]> productList1 = productService.listadminproduct();
		mv.addObject("productList1", productList1);
		mv.setViewName("adminproduct");
		return new RedirectView("productadmin.htm");
	}

	@RequestMapping("insertcompanyproduct.htm")
	public ModelAndView insertcompanyproduct(HttpServletRequest request, HttpServletResponse response,
			@RequestParam CommonsMultipartFile productimage) throws Exception, IOException {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession(true);
		long userId = Long.valueOf((String) session.getAttribute("userId"));
		long price = Long.parseLong(request.getParameter("price"));
		String path = session.getServletContext().getRealPath("/");
		String filename = productimage.getOriginalFilename();
		System.out.println(path + " " + filename);
		try {
			byte barr[] = productimage.getBytes();
			BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(path + "/" + filename));
			bout.write(barr);
			bout.flush();
			bout.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		byte[] File = productimage.getBytes();
		String s = Base64.getEncoder().encodeToString(File);
		productService.addcompanyProduct(request.getParameter("productname"), price,
				request.getParameter("discription"), request.getParameter("productcontent"), File, userId);
		List<Object[]> productList2 = productService.listcompanyproduct(userId);
		mv.addObject("productList2", productList2);
		mv.setViewName("companyproduct");
		return mv;
	}

	@RequestMapping("deleteproduct.htm")
	public RedirectView redirectto(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		long productid = Long.parseLong(request.getParameter("productid"));
		String productList1 = productService.removeproduct(productid);
		mv.addObject("productList1", productList1);
		return new RedirectView("productadmin.htm");
	}

	@RequestMapping("productdelete.htm")
	public ModelAndView redirectdisplay(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		int status = Integer.parseInt(request.getParameter("status"));
		int productid = Integer.parseInt(request.getParameter("productid"));
		String productList = productService.deleteproduct(status, productid);
		HttpSession session = request.getSession(true);
		mv.addObject("productList", productList);
		mv.setViewName("product");
		return mv;
	}

}
