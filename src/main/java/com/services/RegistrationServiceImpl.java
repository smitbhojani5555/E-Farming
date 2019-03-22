package com.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.table.TblUser;

public class RegistrationServiceImpl implements RegistrationService {
	
	private SessionFactory sessionFactory;
	public RegistrationServiceImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Transactional
	public String addUser(String firstname, String lastname, String name, String email, String mobileno,
			String password1, int usertype, byte[] File, byte[] File1,String agronomisttype) {
		Session session = sessionFactory.getCurrentSession();
		TblUser tbl = new TblUser();
		tbl.setFirstname(firstname);
		tbl.setLastname(lastname);
		tbl.setName(name);
		tbl.setEmail(email);
		tbl.setMobileno(mobileno);
		tbl.setPassword(password1);
		tbl.setUsertype(usertype);
		tbl.setData(File);
		tbl.setUserdocument(File1);
		tbl.setAgronomisttype(agronomisttype);
		session.save(tbl);
		return "success";
	}
}
