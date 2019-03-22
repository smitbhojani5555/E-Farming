package com.services;

import java.util.List;

public interface GovermentPoliciesService {

	List<Object[]> listpolicies();
	String addPolicies(String title, String discription, String createdby,String critearea,int status);
	String removeevent(int policyid);
	String deletepolicies(int status, int policyid);
	List<Object[]> listadminpolicies();


	
}

	