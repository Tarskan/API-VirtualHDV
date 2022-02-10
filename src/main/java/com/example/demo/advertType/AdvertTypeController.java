package com.example.demo.advertType;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8000", maxAge = 3600)
@RestController
@RequestMapping("/api/advertType")
public class AdvertTypeController {
    private final AdvertTypeService advertTypeService;

    public AdvertTypeController(AdvertTypeService advertTypeService) {
        this.advertTypeService = advertTypeService;
    }

    @GetMapping
    public List<Adverttype> getListAdvertType(){
        return advertTypeService.getAllAdvertType();
    }

    @GetMapping("/{id_AdvertType}")
    public Adverttype getTypeProductById(@PathVariable int id_AdvertType){
        return advertTypeService.getAdvertTypeById(id_AdvertType);
    }

    @PutMapping
    public Adverttype modifyTypeProduct(@RequestBody Adverttype advertType) {
        return advertTypeService.modifyAdvertType(advertType);
    }

    @PostMapping
    public Adverttype addTypeProduct(@RequestBody Adverttype advertType) {
        return advertTypeService.addAdvertType(advertType);
    }

    @DeleteMapping("/{idTypeProduct}")
    public String deleteTypeProduct(@PathVariable int idTypeProduct) {
        return advertTypeService.suppAdvertType(idTypeProduct);
    }
}
