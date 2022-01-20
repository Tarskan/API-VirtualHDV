package com.example.demo.product;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getListProduct(){
        return productService.getAllProduct();
    }

    @GetMapping("/{idProduct}")
    public Product getProductById(@PathVariable int idProduct){
        return productService.getProduct(idProduct);
    }

    @GetMapping("/search/{nameProduct}")
    public List<Product> getProductByName(@PathVariable String nameProduct){
        return productService.getObjectByName(nameProduct);
    }

    @PutMapping("/{idProduct}/typeProduct/{idTypeProduct}")
    public Product putTypeProductToTruck(@PathVariable int idProduct, @PathVariable int idTypeProduct) {
        return productService.putTypeProductToProduct(idProduct, idTypeProduct);
    }

    @PutMapping
    public Product modifyProduct(@RequestBody Product product) {
        return productService.modifyProduct(product);
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @DeleteMapping("/{idProduct}")
    public String deleteProduct(@PathVariable int idProduct) {
        return productService.suppProduct(idProduct);
    }
}
