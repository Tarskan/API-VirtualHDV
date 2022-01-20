package com.example.demo.product;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    public Product getProduct(int id_product) {
        return productRepository.getById(id_product);
    }

    public List<Product> getObjectByName(String nameProduct) {
        return productRepository.findByNameContaining(nameProduct);
    }

    public Product addProduct(Product product) {
        if (productRepository.existsById(product.getId_Product())) {
            throw new IllegalArgumentException("Id " + product.getId_Product() + " déja utilisé");
        } else {
            return productRepository.save(product);
        }
    }

    public Product modifyProduct(Product product) {
        if (productRepository.existsById(product.getId_Product())) {
            return productRepository.save(product);
        } else {
            throw new IllegalArgumentException("Id: " + product.getId_Product() + " Non trouvée dans la bdd");
        }
    }

    public Product putTypeProductToProduct(int idProduct, int idTypeProduct) {
        if (productRepository.existsById(idProduct)) {
            Product product = productRepository.getById(idProduct);
            product.setId_typeProduct(idTypeProduct);
            return productRepository.save(product);
        } else {
            throw new IllegalArgumentException("Id: " + idProduct + " Non trouvée dans la bdd");
        }
    }

    public String suppProduct(int id_Product) {
        if (productRepository.existsById(id_Product)) {
            Product typeProductToDelete = productRepository.getById(id_Product);
            productRepository.delete(typeProductToDelete);
            return "Le typeProduct a était supprimer";
        } else {
            return "Id " + id_Product + " n'existe pas ou a deja était supprimer";
        }
    }
}
