package com.services;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.table.TblUser;

@Repository
public class FileUploadServiceImpl implements FileUploadService {

	private SessionFactory sessionFactory;

	public FileUploadServiceImpl(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}

	public void setData(byte[] bytes) {
		// TODO Auto-generated method stub

	}

	public void saveFile(TblUser tbluser) {
		// TODO Auto-generated method stub

	}

}
