package com.example.testproduct.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.testproduct.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
