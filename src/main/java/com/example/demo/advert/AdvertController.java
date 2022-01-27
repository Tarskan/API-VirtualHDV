package com.example.demo.advert;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/advert")
public class AdvertController {
    private final AdvertService advertService;

    public AdvertController(AdvertService advertService) {
        this.advertService = advertService;
    }

    @GetMapping
    public List<Advert> getListProduct(){
        return advertService.getAllAdvert();
    }

    @GetMapping("/{id_advert}")
    public Advert getProductById(@PathVariable int id_advert){
        return advertService.getAdvert(id_advert);
    }

    @PutMapping("/{id_advert}/typeProduct/{idTypeProduct}")
    public Advert putTypeProductToTruck(@PathVariable int id_advert, @PathVariable int idTypeProduct) {
        return advertService.putAdvertTypeToAdvert(id_advert, idTypeProduct);
    }

    @PutMapping
    public Advert modifyAdvert(@RequestBody Advert advert) {
        return advertService.modifyAdvert(advert);
    }

    @PostMapping
    public Advert addAdvert(@RequestBody Advert advert) {
        return advertService.addAdvert(advert);
    }

    @DeleteMapping("/{id_advert}")
    public String deleteProduct(@PathVariable int id_advert) {
        return advertService.suppAdvert(id_advert);
    }
}
