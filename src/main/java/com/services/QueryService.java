package com.services;

import java.util.List;

public interface QueryService {



	List<Object[]> listqueries();

	List<Object[]> describeproblem(int problemid);

	String addUser(String subject, String discription,long farmerId,int status,String createddate);

	String addComment(String parameter,long agronomistid, int problemid,String createddate1);

	List<Object[]> searchquery( String searchtext);

	String removequery(int problemid);

	String deletequery(int status, int problemid);

	List<Object[]> listadminqueries();

	

	
	

}
