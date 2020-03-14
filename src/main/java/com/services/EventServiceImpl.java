package com.services;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.table.TblEvent;
import com.table.TblRegisteredfarmer;

public class EventServiceImpl implements EventService {

	private SessionFactory sessionFactory;

	public EventServiceImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<Object[]> listevent() {
		Session session = sessionFactory.getCurrentSession();
		String sqlQuery = "SELECT t.eventid,t.subject,t.description,t.place,t.date,t.time,t.eventimage,t.status FROM TblEvent t WHERE t.status='1'";
		Query query = session.createQuery(sqlQuery);
		List<Object[]> productList = query.list();
		return productList;

	}

	@Transactional
	public List<Object[]> listadminevent() {
		Session session = sessionFactory.getCurrentSession();
		String sqlQuery = "SELECT t.event_id,t.subject,t.description,t.place,t.date,t.time,t.event_image,t.status FROM tbl_event t ORDER BY `event_id` DESC ";
		Query query = session.createSQLQuery(sqlQuery);
		List<Object[]> eventList = query.list();
		return eventList;

	}

	@Transactional
	public List<Object[]> displayevent(int eventid) {
		Session session = sessionFactory.getCurrentSession();
		String sqlQuery = "SELECT t.eventid,t.subject,t.description,t.place,t.eventimage,t.date,t.time  FROM TblEvent t WHERE t.eventid =:id";
		Query query = session.createQuery(sqlQuery);
		query.setParameter("id", eventid);
		List<Object[]> eventimageList = query.list();
		return eventimageList;

	}

	@Transactional
	public String insertEvent(String subject, String discription, String place, String date, String time, byte[] File) {
		Session session = sessionFactory.getCurrentSession();
		TblEvent tbl = new TblEvent();
		tbl.setSubject(subject);
		tbl.setDescription(discription);
		tbl.setDate(date);
		tbl.setPlace(place);
		tbl.setTime(time);
		tbl.setEventimage(File);
		session.save(tbl);
		return "success";
	}

	@Transactional
	public String removeevent(int eventid) {
		Session session = sessionFactory.getCurrentSession();
		TblEvent tbl = new TblEvent();
		tbl.setEventid(eventid);
		session.delete(tbl);
		return "success";
	}

	@Transactional
	public String deleteevent(int status, int eventid) {
		Session session = sessionFactory.getCurrentSession();
		String sqlQuery = "UPDATE tbl_event t  SET t.status=:status WHERE t.event_id=:eventid";
		Query query = session.createSQLQuery(sqlQuery);
		query.setParameter("status", status);
		query.setParameter("eventid", eventid);
		query.executeUpdate();
		return "success";

	}

	@Transactional
	public String listregisteredfarmer(Long userId) {
		Session session = sessionFactory.getCurrentSession();
		TblRegisteredfarmer tbl = new TblRegisteredfarmer();
		tbl.setFarmerid(userId);
		session.save(tbl);
		return "success";

	}

	@Transactional
	public List<Object[]> listhomeevent() {
		Session session = sessionFactory.getCurrentSession();
		String sqlQuery = "SELECT t.event_id,t.subject,t.description,t.place,t.date,t.time,t.event_image,t.status FROM tbl_event t WHERE t.status='1' LIMIT 6";
		Query query = session.createSQLQuery(sqlQuery);
		List<Object[]> productList = query.list();
		return productList;

	}
}
