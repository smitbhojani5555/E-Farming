package com.services;

import java.util.List;

public interface ContactService {

	String addUser(String Name, String message, String Email);

	List<Object[]> listUser();
	
	

}
