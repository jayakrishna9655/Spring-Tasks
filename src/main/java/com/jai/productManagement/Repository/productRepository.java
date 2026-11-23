package com.jai.productManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jai.productManagement.Entity.productEntity;

@Repository
public interface productRepository extends JpaRepository<productEntity, Long>{

}
