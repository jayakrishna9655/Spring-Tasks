package com.jai.productManagement.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jai.productManagement.Entity.productEntity;

@Repository
public interface productRepository extends JpaRepository<productEntity, Long>{

	@Query("SELECT p FROM productEntity p WHERE (:name = '' OR LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%')))")
	Page<productEntity> searchByName(@Param("name") String name, Pageable pageable);

}
