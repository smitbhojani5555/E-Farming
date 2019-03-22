package com.services;

import java.util.List;

public interface EventService {

	List<Object[]> listevent();
	
	List<Object[]> listadminevent();

	List<Object[]> displayevent(int eventid);

	String insertEvent(String subject, String discription, String place, String date,String time, byte[] File);

	String removeevent(int eventid);

	String deleteevent(int status,int eventid);

	String listregisteredfarmer(Long userId);


}

