package com.example.demo.advert;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8000", maxAge = 3600)
@RestController
@RequestMapping("/api/advert")
public class AdvertController {
    private final AdvertService advertService;

    public AdvertController(AdvertService advertService) {
        this.advertService = advertService;
    }

    @GetMapping("{id_user}")
    public List<Advert> getListAdvert(@PathVariable int id_user){
        return advertService.getAllAdvert(id_user);
    }

    @GetMapping("/index/{id_advert}")
    public Advert getAdvertById(@PathVariable int id_advert){
        return advertService.getAdvert(id_advert);
    }

    @GetMapping("/search/{id_user}")
    public List<Advert> getAdvertByIdUser(@PathVariable int id_user){
        return advertService.getAdvertByIdUSer(id_user);
    }

    @GetMapping("/search/{id_user}/query/{advertName}")
    public List<Advert> getAdvertByQueryAndIdUser(@PathVariable int id_user, @PathVariable String advertName){
        return advertService.getAdvertByQueryAndIdUser(id_user, advertName);
    }

    @GetMapping("/search/name/{nameAdvert}/without/{id_user}")
    public List<Advert> getAdvertByNameWithoutTheUser(@PathVariable String nameAdvert, @PathVariable int id_user){
        return advertService.getAdvertByName(nameAdvert, id_user);
    }

    @GetMapping("/allsold")
    public List<Advert> listAllSellAdvert() {
        return advertService.listAllSellAdvert();
    }

    @GetMapping("/sold/{id_user}")
    public List<Advert> listSellAdvert(@PathVariable int id_user) {
        return advertService.listSellAdvert(id_user);
    }

    @GetMapping("/bought/{id_user}")
    public List<Advert> listBoughtAdvert(@PathVariable int id_user) {
        return advertService.listBoughtAdvert(id_user);
    }

    @GetMapping("/sold/{id_user}/query/{advertName}")
    public List<Advert> listSellAdvertByNAme(@PathVariable int id_user, @PathVariable String advertName) {
        return advertService.listSellAdvertByName(id_user, advertName);
    }

    @GetMapping("/bought/{id_user}/query/{advertName}")
    public List<Advert> listBoughtAdvertByName(@PathVariable int id_user, @PathVariable String advertName) {
        return advertService.listBoughtAdvertByName(id_user, advertName);
    }

    @PutMapping("/{id_advert}/advertType/{id_advertType}")
    public Advert putAdvertTypeToAdvert(@PathVariable int id_advert, @PathVariable int id_advertType) {
        return advertService.putAdvertTypeToAdvert(id_advert, id_advertType);
    }

    @PutMapping
    public Advert modifyAdvert(@RequestBody Advert advert) {
        return advertService.modifyAdvert(advert);
    }

    @PostMapping
    public Advert addAdvert(@RequestBody Advert advert) {
        return advertService.addAdvert(advert);
    }

    @PostMapping("/sold/{id_advert}/to/{id_user}")
    public Advert sellAdvert(@PathVariable int id_advert, @PathVariable int id_user) {
        return advertService.sellAdvert(id_advert, id_user);
    }

    @PostMapping("/image")
    public String uploadImage(@RequestParam MultipartFile imageUpload) throws IOException {
        String url = "";
        url = advertService.imageSave(imageUpload);
        return url;
    }

    @DeleteMapping("/{id_advert}")
    public String deleteProduct(@PathVariable int id_advert) {
        return advertService.suppAdvert(id_advert);
    }

}
