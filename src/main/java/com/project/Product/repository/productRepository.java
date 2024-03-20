package com.project.Product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Product.model.product;

@Repository
public interface productRepository  extends JpaRepository<product, Integer>{

}
