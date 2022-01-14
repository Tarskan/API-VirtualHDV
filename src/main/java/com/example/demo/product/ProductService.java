package com.example.demo.product;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository objectRepository;

    public ProductService(ProductRepository objectRepository) {
        this.objectRepository = objectRepository;
    }

    public List<Product> getAllObject() {
        return objectRepository.findAll();
    }

    public Product getObject(int id_Object) {
        return objectRepository.getById(id_Object);
    }

    public List<Product> getObjectByName(String nameObject) {
        return objectRepository.findByNameContaining(nameObject);
    }
}
