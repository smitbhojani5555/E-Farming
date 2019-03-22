package com.services;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.table.TblUser;
@Repository
public class FileUploadServiceImpl implements FileUploadService {

	private SessionFactory sessionFactory;
	public FileUploadServiceImpl(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}
	 	@Override
	public void setData(byte[] bytes) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void saveFile(TblUser tbluser) {
		// TODO Auto-generated method stub
		
	}
	
	}


