package com.jai.productManagement.Service;

import java.util.List; 
import org.springframework.stereotype.Service;

import com.jai.productManagement.Entity.ProductPageResponse;
import com.jai.productManagement.Entity.productEntity;
import com.jai.productManagement.Repository.productRepository;
import java.util.Set;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import com.jai.productManagement.Entity.productEntity;

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
	
    private static final Set<String> ALLOWED_SORT_FIELDS = Set.of("id", "name", "price", "quantity");

    public ProductPageResponse searchProducts(String name, int page, int size, String sortBy, String direction) {
        if (page < 0) {
            throw new IllegalArgumentException("page must be >= 0");
        }
        if (size <= 0 || size > 100) {
            throw new IllegalArgumentException("size must be between 1 and 100");
        }
        String sortField = ALLOWED_SORT_FIELDS.contains(sortBy) ? sortBy : "id";
        Sort sort = "desc".equalsIgnoreCase(direction)
                ? Sort.by(sortField).descending()
                : Sort.by(sortField).ascending();

        Pageable pageable = PageRequest.of(page, size, sort);
        String keyword = name == null ? "" : name.trim();

        Page<productEntity> result = repo.searchByName(keyword, pageable);

        return new ProductPageResponse(
                result.getContent(),
                result.getNumber(),
                result.getSize(),
                result.getTotalElements(),
                result.getTotalPages(),
                result.isLast()
        );
    }
	
}
