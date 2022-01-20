package com.example.demo.typeProduct;

import com.example.demo.product.Product;
import com.example.demo.product.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;

@RestController
@RequestMapping("/api/typeproduct")
public class TypeProductController {
    private final TypeProductService typeProductService;

    public TypeProductController(TypeProductService typeProductService) {
        this.typeProductService = typeProductService;
    }

    @GetMapping
    public List<TypeProduct> getListTypeProduct(){
        return typeProductService.getAllTypeObject();
    }

    @GetMapping("/{idTypeProduct}")
    public TypeProduct getTypeProductById(@PathVariable int idTypeProduct){
        return typeProductService.getTypeObject(idTypeProduct);
    }

    @GetMapping("/search/{nameTypeProduct}")
    public List<TypeProduct> getTypeProductByName(@PathVariable String nameTypeProduct){
        return typeProductService.getTypeProductByName(nameTypeProduct);
    }

    @PutMapping
    public TypeProduct modifyTypeProduct(@RequestBody TypeProduct typeProduct) {
        return typeProductService.modifyTypeProduct(typeProduct);
    }

    @PostMapping
    public TypeProduct addTypeProduct(@RequestBody TypeProduct typeProduct) {
        return typeProductService.addTypeProduct(typeProduct);
    }

    @DeleteMapping("/{idTypeProduct}")
    public String deleteTypeProduct(@PathVariable int idTypeProduct) {
        return typeProductService.suppTypeProduct(idTypeProduct);
    }
}
