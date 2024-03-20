package com.project.Product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import com.project.Product.exception.productNotFoundException;
import com.project.Product.model.product;
import com.project.Product.repository.productRepository;

@Service
public class productService {
	
	@Autowired
	private  productRepository productrepository;
	
	public List<product> getAllProductDetails() {
		
		return productrepository.findAll();
		
	}
	
	public product getproductDetailsById(int id)throws productNotFoundException{
		product product=productrepository.findById(id).get();
		if(null!=product)
			return product;
		else
			throw new productNotFoundException ("product not found"+id);
	}

}
