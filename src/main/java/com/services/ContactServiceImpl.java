package com.services;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.table.TblMessage;

public class ContactServiceImpl implements ContactService{

	
	private SessionFactory sessionFactory;

	public ContactServiceImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public String addUser(String Name, String message, String Email) {
		Session session = sessionFactory.getCurrentSession();
		TblMessage tbl = new TblMessage();
		tbl.setName(Name);
		tbl.setMessage(message);
		tbl.setEmail(Email);
		session.save(tbl);
		return "success";
	}


	@Transactional
	public List<Object[]> listUser() {
		Session session = sessionFactory.getCurrentSession();
		String sqlQuery = "SELECT t.id,t.name,t.email,t.message FROM TblMessage t";
		Query query = session.createQuery(sqlQuery);
		List<Object[]> user = query.list();
		return user;
	}
}
