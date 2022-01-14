package com.example.demo.typeProduct;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeProductService {
    private final TypeProductRepository typeProductRepository;

    public TypeProductService(TypeProductRepository typeProductRepository) {
        this.typeProductRepository = typeProductRepository;
    }

    public List<TypeProduct> getAllTypeObject() {
        return typeProductRepository.findAll();
    }

    public TypeProduct getTypeObject(int id_TypeObject) {
        return typeProductRepository.getById(id_TypeObject);
    }

    public List<TypeProduct> getTypeObjectByName(String nameTypeProduct) {
        return typeProductRepository.findByNameContaining(nameTypeProduct);
    }
}
