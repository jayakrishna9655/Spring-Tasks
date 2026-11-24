package com.jai.productManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jai.productManagement.Entity.productEntity;
import com.jai.productManagement.Service.productService;

@RestController
@RequestMapping("/api")
public class productController {
	
	@Autowired
	productService service;
	
	@GetMapping("/")
	public String sayHello() {
		return "Hi Jai";
	}
	
	@PostMapping("/products")
	public productEntity saveProducts(@RequestBody productEntity proEntity) {
		
		return service.saveProducts(proEntity);
		
	}
	
	@GetMapping("/products")
	public List<productEntity> getAllProducts() {
		return service.getAllProducts();
	}
	
	@GetMapping("/products/{ID}")
	public productEntity getProductsById(@PathVariable("ID") Long id) {
		return service.getProductsById(id);
	}
	
	@PutMapping("/products/{ID}")
	public ResponseEntity<productEntity> updateProductsById(@PathVariable("ID") Long id,@RequestBody productEntity proEntity){
		
		productEntity updated = service.updateProductsById(id,proEntity);
		
		if(updated !=null) {
			return ResponseEntity.ok(updated);
		}
		else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@DeleteMapping("/products/{ID}")
	public ResponseEntity<Void> deleteProductsById(@PathVariable("ID") Long id) {
		
		Boolean ischeck = service.deleteProductsById(id);
		
		if(ischeck) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
		
	}
	
	
}
