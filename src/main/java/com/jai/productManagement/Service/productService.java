package com.jai.productManagement.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jai.productManagement.Entity.productEntity;
import com.jai.productManagement.Repository.productRepository;

@Service
public class productService {

	@Autowired
	productRepository repo;
	
	public productEntity saveProducts(productEntity proEntity) {
		
		return repo.save(proEntity);
	}

	public List<productEntity> getAllProducts() {
		return repo.findAll();
	}

	public productEntity getProductsById(Long id) {
		return  repo.findById(id).get();
	}
	

	
	
}
