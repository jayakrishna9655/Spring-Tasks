package com.jai.productManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	
}
