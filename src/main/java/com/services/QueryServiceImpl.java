package com.services;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.table.TblComment;
import com.table.TblProblems;

public class QueryServiceImpl implements QueryService {

	private SessionFactory sessionFactory;

	public QueryServiceImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<Object[]> listqueries() {
		Session session = sessionFactory.getCurrentSession();
		String sqlQuery = "SELECT u.first_name,u.data,p.subject,p.problem_id,p.farmer_id,p.description,p.status,p.created_date,u.user_type_id FROM tbl_problems p LEFT JOIN tbl_user u ON u.user_id=p.farmer_id WHERE p.status=1";
		Query query = session.createSQLQuery(sqlQuery);
		List<Object[]> problemList = query.list();
		return problemList;
	}

	@Transactional
	public List<Object[]> listadminqueries() {
		Session session = sessionFactory.getCurrentSession();
		String sqlQuery = "SELECT u.first_name,u.data,p.subject,p.problem_id,p.farmer_id,p.description,p.status,p.created_date FROM tbl_problems p LEFT JOIN tbl_user u ON u.user_id=p.farmer_id  ORDER BY `problem_id` DESC ";
		Query query = session.createSQLQuery(sqlQuery);
		List<Object[]> problemList = query.list();
		return problemList;
	}

	@Transactional
	public List<Object[]> describeproblem(int problemid) {
		Session session = sessionFactory.getCurrentSession();
		String sqlQuery = "SELECT u.first_name,p.subject,p.problem_id,p.description,u.user_id,p.created_date FROM tbl_problems p LEFT JOIN tbl_user u ON u.user_id=p.farmer_id WHERE p.problem_id =:problemid";
		Query query = session.createSQLQuery(sqlQuery);
		query.setParameter("problemid", problemid);
		List<Object[]> problemList = query.list();
		return problemList;
	}

	@Transactional
	public String addUser(String subject, String discription, long farmerId,int status,String createddate) {
		Session session = sessionFactory.getCurrentSession();
		TblProblems tbl = new TblProblems();
		tbl.setSubject(subject);
		tbl.setDescription(discription);
		tbl.setFarmerid(farmerId);
		tbl.setStatus(status);
		tbl.setCreateddate(createddate);
		session.save(tbl);
		return "success";
	}

	@Transactional
	public String addComment(String comment, long agronomistid, int problemid,String createddate1) {
		Session session = sessionFactory.getCurrentSession();
		TblComment tbl = new TblComment();
		tbl.setComment(comment);
		tbl.setProblemid(problemid);
		tbl.setUserid(agronomistid);
		tbl.setCreateddate(createddate1);
		session.save(tbl);
		return "success";
	}

	@Transactional
	public List<Object[]> searchquery(String searchtext) {
		Session session = sessionFactory.getCurrentSession();
		String sqlQuery = "SELECT * FROM tbl_problems p WHERE p.subject LIKE :searchtext";
		Query query = session.createSQLQuery(sqlQuery);
		query.setParameter("searchtext", "%" + searchtext + "%");
		List<Object[]> problemList = query.list();
		return problemList;
	}

	@Override
	@Transactional
	public String removequery(int problemid) {
		Session session = sessionFactory.getCurrentSession();
		String sqlQuery = "DELETE FROM tbl_problems WHERE problem_id=:problemid";
		Query query = session.createSQLQuery(sqlQuery);
		query.setParameter("problemid", problemid);
		query.executeUpdate();
		return "success";

	}

	@Override
	@Transactional
	public String deletequery(int status, int problemid) {
		Session session = sessionFactory.getCurrentSession();
		String sqlQuery = "UPDATE tbl_problems t  SET t.status=:status WHERE t.problem_id=:problemid";
		Query query = session.createSQLQuery(sqlQuery);
		query.setParameter("status", status);
		query.setParameter("problemid", problemid);
		query.executeUpdate();
		return "success";
	}
}
