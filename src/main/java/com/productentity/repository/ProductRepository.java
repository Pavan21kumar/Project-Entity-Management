package com.productentity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productentity.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
