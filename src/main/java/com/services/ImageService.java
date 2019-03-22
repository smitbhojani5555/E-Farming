package com.services;

import java.util.List;

public interface ImageService {

	List<Object> listimageproduct(long productid);

	List<Object> listimage(int eventid);

	List<Object> listeventimage(int eventid);

	List<Object> listsingleproductimage(Long productid);

	List<Object> listuserimage(Long userid);

	List<Object> listuserdocumentimage(Long userid);

	
}
