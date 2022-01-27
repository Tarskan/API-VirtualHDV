package com.example.demo.advertType;

import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/{idTypeProduct}")
    public Adverttype getTypeProductById(@PathVariable int idTypeProduct){
        return advertTypeService.getAdvertTypeById(idTypeProduct);
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
