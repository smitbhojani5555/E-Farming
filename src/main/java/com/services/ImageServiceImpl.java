package com.services;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

public class ImageServiceImpl implements ImageService {

	private SessionFactory sessionFactory;

	public ImageServiceImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<Object> listimageproduct(long productid) {
		Session session = sessionFactory.getCurrentSession();
		String sqlQuery = "SELECT t.productimage FROM TblProduct t WHERE t.productid= :productid";
		Query query = session.createQuery(sqlQuery);
		query.setParameter("productid", productid);
		List<Object> productList = query.list();

		return productList;

	}

	@Transactional
	public List<Object> listimage(int eventid) {
		Session session = sessionFactory.getCurrentSession();
		String sqlQuery = "SELECT t.eventimage FROM TblEvent t WHERE t.eventid= :eventid";
		Query query = session.createQuery(sqlQuery);
		query.setParameter("eventid", eventid);
		List<Object> eventList = query.list();

		return eventList;

	}

	@Transactional
	public List<Object> listeventimage(int eventid) {
		Session session = sessionFactory.getCurrentSession();
		String sqlQuery = "SELECT t.eventimage FROM TblEvent t WHERE t.eventid= :eventid";
		Query query = session.createQuery(sqlQuery);
		query.setParameter("eventid", eventid);
		List<Object> imageList = query.list();

		return imageList;

	}

	@Transactional
	public List<Object> listsingleproductimage(Long productid) {
		Session session = sessionFactory.getCurrentSession();
		String sqlQuery = "SELECT t.productimage FROM TblProduct t WHERE t.productid= :productid";
		Query query = session.createQuery(sqlQuery);
		query.setParameter("productid", productid);
		List<Object> eventimageList = query.list();

		return eventimageList;

	}

	@Transactional
	public List<Object> listuserimage(Long userid) {
		Session session = sessionFactory.getCurrentSession();
		String sqlQuery = "SELECT t.data FROM TblUser t WHERE t.id= :userid";
		Query query = session.createQuery(sqlQuery);
		query.setParameter("userid", userid);
		List<Object> userimageList = query.list();

		return userimageList;

	}

	@Transactional
	public List<Object> listuserdocumentimage(Long userid) {
		Session session = sessionFactory.getCurrentSession();
		String sqlQuery = "SELECT t.userdocument FROM TblUser t WHERE t.id= :userid";
		Query query = session.createQuery(sqlQuery);
		query.setParameter("userid", userid);
		List<Object> userimageList = query.list();

		return userimageList;

	}

}
