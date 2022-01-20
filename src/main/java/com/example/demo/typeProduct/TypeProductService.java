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

    public List<TypeProduct> getTypeProductByName(String nameTypeProduct) {
        return typeProductRepository.findByNameContaining(nameTypeProduct);
    }

    public TypeProduct addTypeProduct(TypeProduct typeProduct) {
        if (typeProductRepository.existsById(typeProduct.getId_TypeProduct())) {
            throw new IllegalArgumentException("Id " + typeProduct.getId_TypeProduct() + " déja utilisé");
        } else {
            return typeProductRepository.save(typeProduct);
        }
    }

    public TypeProduct modifyTypeProduct(TypeProduct typeProduct) {
        if (typeProductRepository.existsById(typeProduct.getId_TypeProduct())) {
            return typeProductRepository.save(typeProduct);
        } else {
            throw new IllegalArgumentException("Id: " + typeProduct.getId_TypeProduct() + " Non trouvée dans la bdd");
        }
    }

    public String suppTypeProduct(int id_typeProduct) {
        if (typeProductRepository.existsById(id_typeProduct)) {
            TypeProduct typeProductToDelete = typeProductRepository.getById(id_typeProduct);
            typeProductRepository.delete(typeProductToDelete);
            return "Le typeProduct a était supprimer";
        } else {
            return "Id " + id_typeProduct + " n'existe pas ou a deja était supprimer";
        }
    }
}
