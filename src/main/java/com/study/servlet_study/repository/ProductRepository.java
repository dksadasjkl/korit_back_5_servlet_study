package com.study.servlet_study.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.study.servlet_study.entity.Product;

public class ProductRepository {
	 private static ProductRepository instance;
	 private List<Product> productList;
	
	 private ProductRepository() {
		 productList = new ArrayList<>();
	}
	
	 public static ProductRepository getInstance() {
		 if (instance == null) {
			 instance = new ProductRepository();
		 }
		 return instance;
	 }
	 
	 public int save(Product product) {
		productList.add(product); 
		return 1;		 
	 }
	
	 public Product findproductName(String productName) {
		 Product findproductName = null;
		 for (Product product : productList) {
			 if (product.getProductName().equals(productName)) {
				 findproductName = product;
				break;
			 }		 
		}
		 return findproductName;
	 } 
	 	 
}
