package com.services;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.table.TblForgotPassword;

public class LoginServiceImpl implements LoginService {

	private SessionFactory sessionFactory;

	public LoginServiceImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<Object[]> verifyUser(String Email, String password) {
		Session session = sessionFactory.getCurrentSession();
		String sqlQuery = "SELECT t.id,t.email,t.usertype FROM TblUser t WHERE t.password= :password AND t.email= :username";
		Query query = session.createQuery(sqlQuery);
		query.setParameter("password", password);
		query.setParameter("username", Email);
		List<Object[]> user = query.list();
		return user;
	}

	@Transactional
	public List<Object[]> listUser() {
		Session session = sessionFactory.getCurrentSession();
		String sqlQuery = "SELECT t.user_id,t.first_name,t.last_name,t.status,t.email,t.password,t.userdocument,t.data,t.mobile_no,t.user_type_id FROM tbl_user t  ORDER BY `user_id` DESC ";
		Query query = session.createSQLQuery(sqlQuery);
		List<Object[]> userList = query.list();
		return userList;
	}

	@Transactional
	public List<Object[]> verifyAdmin(String userName, String password) {
		Session session = sessionFactory.getCurrentSession();
		String sqlQuery = "SELECT t.id,t.name FROM TblUser t WHERE t.password= :password AND t.email= :username AND t.usertype='4'";
		Query query = session.createQuery(sqlQuery);
		query.setParameter("password", password);
		query.setParameter("username", userName);
		List<Object[]> user = query.list();
		return user;
	}

	@Transactional
	public String removeuser(int userid) {
		Session session = sessionFactory.getCurrentSession();
		String sqlQuery = "DELETE FROM tbl_user WHERE user_id=:userid";
		Query query = session.createSQLQuery(sqlQuery);
		query.setParameter("userid", userid);
		query.executeUpdate();
		return "success";

	}

	@Transactional
	public List<Object[]> verifyforgotpassword(String userName, int usertype) {
		Session session = sessionFactory.getCurrentSession();
		String sqlQuery = "SELECT t.id,t.name FROM TblUser t WHERE t.email= :username AND t.usertype=:usertype";
		Query query = session.createQuery(sqlQuery);
		query.setParameter("usertype", usertype);
		query.setParameter("username", userName);
		List<Object[]> user = query.list();
		return user;
	}

	@Transactional
	public String insertforgotpassword(String email, String createddate, String token, int status, int usertype) {
		Session session = sessionFactory.getCurrentSession();
		TblForgotPassword tbl = new TblForgotPassword();
		tbl.setEmail(email);
		tbl.setCreateddate(createddate);
		tbl.setToken(token);
		tbl.setStatus(status);
		tbl.setUsertype(usertype);
		session.save(tbl);
		return "success";
	}

	@Transactional
	public List veryfyemail(String token) {
		Session session = sessionFactory.getCurrentSession();
		String sqlQuery = "SELECT t.email,t.user_type FROM tbl_forgot_password t WHERE t.token=:token AND t.status='1'";
		Query query = session.createSQLQuery(sqlQuery);
		query.setParameter("token", token);
		List<Object[]> user = query.list();
		return user;
	}

	@Transactional
	public String updatePassword(String userId, String password) {
		Session session = sessionFactory.getCurrentSession();
		String sqlQuery = "UPDATE tbl_user t  SET t.password=:password WHERE t.user_id=:userid";
		Query query = session.createSQLQuery(sqlQuery);
		query.setParameter("userid", userId);
		query.setParameter("password", password);
		query.executeUpdate();
		return "success";

	}

	@Transactional
	public List<Object[]> getuserId(String usertype, String email) {
		Session session = sessionFactory.getCurrentSession();
		String sqlQuery2 = "SELECT t.user_id,t.first_name FROM Tbl_user t WHERE t.user_type_id=:usertype AND t.email=:email";
		Query query = session.createSQLQuery(sqlQuery2);
		query.setParameter("usertype", usertype);
		query.setParameter("email", email);
		List employeeId1 = query.list();
		return employeeId1;

	}

	@Transactional
	public String deleteuser(int status, Long userId) {
		Session session = sessionFactory.getCurrentSession();
		String sqlQuery = "UPDATE tbl_user t  SET t.status=:status WHERE t.product_id=:productid";
		Query query = session.createSQLQuery(sqlQuery);
		query.setParameter("status", status);
		query.setParameter("productid", userId);
		query.executeUpdate();
		return "success";

	}
}
