package com.services;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

public class AnswerServiceImpl implements AnswerService {

	private SessionFactory sessionFactory;

	public AnswerServiceImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<Object[]> describeanswer(int problemid) {
		Session session = sessionFactory.getCurrentSession();
		String sqlQuery = "SELECT u.first_name,u.user_id,p.comment,p.problem_id,p.comment_id,u.agronomist_type,p.created_date FROM tbl_comment p LEFT JOIN tbl_user u ON u.user_id=p.agronomist_id WHERE p.problem_id =:problemid";
		Query query = session.createSQLQuery(sqlQuery);
		query.setParameter("problemid",problemid);
		List<Object[]> answerList = query.list();
		return answerList;
	}	

}
