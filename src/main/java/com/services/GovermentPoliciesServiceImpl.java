package com.services;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.table.TblEvent;
import com.table.TblGovermentPolicies;
import com.table.TblProduct;

public class GovermentPoliciesServiceImpl implements GovermentPoliciesService {

	private SessionFactory sessionFactory;

	public GovermentPoliciesServiceImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<Object[]> listpolicies() {
		Session session = sessionFactory.getCurrentSession();
		String sqlQuery = "SELECT t.policyid,t.description,t.title,t.createdby,t.critearea,t.status,t.createddate FROM TblGovermentPolicies t WHERE t.status='1'";
		Query query = session.createQuery(sqlQuery);
		List<Object[]> product = query.list();
		return product;
	}
	
	@Transactional
	public List<Object[]> listadminpolicies() {
		Session session = sessionFactory.getCurrentSession();
		String sqlQuery = "SELECT t.policy_id,t.description,t.title,t.created_by,t.critearea,t.status FROM tbl_goverment_policies t ORDER BY `policy_id` DESC";
		Query query = session.createSQLQuery(sqlQuery);
		List<Object[]> govermentpoliciesList = query.list();
		return govermentpoliciesList;
	}

	@Override
	@Transactional
	public String addPolicies(String title, String discription, String createdby,String critearea,int status) {
		Session session = sessionFactory.getCurrentSession();
		TblGovermentPolicies tbl=new TblGovermentPolicies();
		tbl.setTitle(title);
		tbl.setDescription(discription);;
		tbl.setCreatedby(createdby);
		tbl.setCritearea(critearea);
		tbl.setStatus(status);
		session.save(tbl);
		return "success";	
	}

	
	@Transactional
	public String removeevent(int policyid) {
		Session session = sessionFactory.getCurrentSession();
		TblGovermentPolicies tbl = new TblGovermentPolicies();
		tbl.setPolicyid(policyid);
		session.delete(tbl);
		return "success";	
	}

	@Override
	@Transactional
	public String deletepolicies(int status, int policyid) {
		Session session = sessionFactory.getCurrentSession();
		String sqlQuery = "UPDATE tbl_goverment_policies t  SET t.status=:status WHERE t.policy_id=:policyid";
		Query query = session.createSQLQuery(sqlQuery);
		query.setParameter("status",status);
		query.setParameter("policyid",policyid);
		query.executeUpdate();
		return "success";
	}		
}
