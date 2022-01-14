package com.example.demo.typeProduct;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TypeProductRepository extends JpaRepository<TypeProduct, Integer> {
    List<TypeProduct> findByNameContaining(String name);
}
