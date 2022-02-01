package com.example.demo.advert;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8000", maxAge = 3600)
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
    public Advert getAdvertById(@PathVariable int idAdvert){
        return advertService.getAdvert(idAdvert);
    }

    @GetMapping("/search/{id_user}")
    public List<Advert> getAdvertByIdUser(@PathVariable int id_user){
        return advertService.getAdvertByIdUSer(id_user);
    }

    @PutMapping("/{id_advert}/typeProduct/{idAdvertType}")
    public Advert putAdvertTypeToAdvert(@PathVariable int id_advert, @PathVariable int idAdvertType) {
        return advertService.putAdvertTypeToAdvert(id_advert, idAdvertType);
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
