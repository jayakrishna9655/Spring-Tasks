package com.jai.productManagement.Service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.jai.productManagement.Entity.productEntity;
import com.jai.productManagement.Repository.productRepository;

@Service
public class productService {
	
	private final productRepository repo;
	
	public productService(productRepository repo) {
		this.repo=repo;
	}
	
	public productEntity saveProducts(productEntity proEntity) {
		
		return repo.save(proEntity);
	}

	public List<productEntity> getAllProducts() {
		return repo.findAll();
	}

	public productEntity getProductsById(Long id) {
		return  repo.findById(id).orElseThrow(() -> new RuntimeException("product not with id: "+id));
	}

	public Boolean deleteProductsById(Long id) {
		if(repo.existsById(id)) {
			repo.deleteById(id);
			return true;
		}
		return false;
		 
	}

	public productEntity updateProductsById(Long id, productEntity newDetails) {
		
		return repo.findById(id).map( olddata ->{
				olddata.setName(newDetails.getName());
				olddata.setPrice(newDetails.getPrice());
				olddata.setQuantity(newDetails.getQuantity());
				return repo.save(olddata);
		}).orElse(null);	
		
	}
	

	
	
}
