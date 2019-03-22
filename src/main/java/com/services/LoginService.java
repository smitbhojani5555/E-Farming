package com.services;

import java.util.List;

public interface LoginService {

	List<Object[]> verifyUser(String Email, String password);

	List<Object[]> listUser();

	List<Object[]> verifyAdmin(String userName, String password);

	String removeuser(int policyid);

	List<Object[]> verifyforgotpassword(String userName, int usertype);

	String insertforgotpassword(String userName, String createddate,String token,int status,int usertype);

	List<Object[]> veryfyemail(String token);

	String updatePassword(String userId, String password);

	List<Object[]> getuserId(String usertype, String email);

	String deleteuser(int status, Long userId);

	

}
