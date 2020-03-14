package com.services;

import java.util.List;

public interface ProductService {

	List<Object[]> listproduct();

	List<Object[]> listproductdisplay(long productid);

	String addProduct(String productname, String string, String discription, long price, byte[] file);

	String removeproduct(long productid);

	String deleteproduct(int status, int productid);

	List<Object[]> listadminproduct();

	List<Object[]> listcompanyproduct(long userId);

	String addcompanyProduct(String productname, long price, String discription, String productcontent, byte[] File,
			long userId);

}
