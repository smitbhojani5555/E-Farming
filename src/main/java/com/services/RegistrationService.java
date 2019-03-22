package com.services;

import java.util.List;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public interface RegistrationService {

	

	String addUser(String firstname, String lastname, String name, String email, String mobileno, String password1,
			int usertype, byte[] File,byte[] File1,String agronomisttype);

	

	
	
}
