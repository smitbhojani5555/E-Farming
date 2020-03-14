package com.services;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

public class EventImageServiceImpl implements EventImageService {

	private SessionFactory sessionFactory;

	public EventImageServiceImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<Object> listimage(int eventid) {
		Session session = sessionFactory.getCurrentSession();
		String sqlQuery = "SELECT t.eventimage FROM TblEvent t WHERE t.eventid= :eventid";
		Query query = session.createQuery(sqlQuery);
		query.setParameter("eventid", eventid);
		List<Object> productList = query.list();

		return productList;

	}

}
