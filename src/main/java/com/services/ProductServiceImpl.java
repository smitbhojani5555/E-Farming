package com.services;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.table.TblProduct;
import com.table.TblUser;

public class ProductServiceImpl implements ProductService {
	
	private SessionFactory sessionFactory;

	public ProductServiceImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public List<Object[]> listproduct() {
		Session session = sessionFactory.getCurrentSession();
			String sqlQuery = "SELECT t.productid,t.productname,t.description,t.price,t.productimage,t.productcontent,t.status FROM TblProduct t WHERE t.status='1'";
			Query query = session.createQuery(sqlQuery);
			List<Object[]> product = query.list();
			return product;
		
	}
	@Transactional
	public List<Object[]> listadminproduct() {
		Session session = sessionFactory.getCurrentSession();
			String sqlQuery = "SELECT t.productid,t.productname,t.description,t.price,t.productimage,t.productcontent,t.status FROM TblProduct t";
			Query query = session.createQuery(sqlQuery);	
			List<Object[]> product = query.list();
			return product;
		
	}

	@Override
	@Transactional
	public List<Object[]> listproductdisplay(long productid) {
        Session session = sessionFactory.getCurrentSession();
		String sqlQuery = "SELECT t.productid,t.productname,t.description,t.price,t.productimage,t.productcontent FROM TblProduct t WHERE t.productid=:productid";
		Query query = session.createQuery(sqlQuery);
		query.setParameter("productid",productid);
		List<Object[]> productList = query.list();
		return productList;
		
	}

	@Override
	@Transactional
	public String addProduct(String productname, String discription, String productcontent,
			long price,byte[] File) {
		Session session = sessionFactory.getCurrentSession();
		TblProduct tbl = new TblProduct();
		tbl.setProductname(productname);
		tbl.setPrice(price);
		tbl.setDescription(discription);
		tbl.setProductcontent(productcontent);
		tbl.setProductimage(File);
		session.save(tbl);
		return "success";
	
		
		
	}

	
	@Transactional
	public String removeproduct(long productid) {
		Session session = sessionFactory.getCurrentSession();
		TblProduct tbl = new TblProduct();
		tbl.setProductid(productid);
		session.delete(tbl);
		return "success";
		
	}

	@Override
	@Transactional
	public String deleteproduct(int status, int productid) {
		Session session = sessionFactory.getCurrentSession();
		String sqlQuery = "UPDATE tbl_product t  SET t.status=:status WHERE t.product_id=:productid";
		Query query = session.createSQLQuery(sqlQuery);
		query.setParameter("status",status);
		query.setParameter("productid",productid);
		query.executeUpdate();	
		return "success";
		
	}

	@Override
	@Transactional
	public List<Object[]> listcompanyproduct(long userId) {
		Session session = sessionFactory.getCurrentSession();
		String sqlQuery = "SELECT t.productid,t.productname,t.description,t.price,t.productimage,t.productcontent,t.status FROM TblProduct t WHERE t.createdby=:userId";	
		Query query = session.createQuery(sqlQuery);	
		query.setParameter("userId",userId);
		List<Object[]> product = query.list();
		return product;
	}

	@Override
	@Transactional
	public String addcompanyProduct(String productname, long price, String discription, String productcontent, byte[] File,
			long userId) {
		Session session = sessionFactory.getCurrentSession();
		TblProduct tbl = new TblProduct();
		tbl.setProductname(productname);
		tbl.setPrice(price);
		tbl.setDescription(discription);
		tbl.setProductcontent(productcontent);
		tbl.setProductimage(File);
		tbl.setCreatedby(userId);
		session.save(tbl);
		return "success";
		
	}

		
	}
	


