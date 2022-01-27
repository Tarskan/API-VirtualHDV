package com.example.demo.advertType;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertTypeService {
    private final AdvertTypeRepository advertTypeRepository;

    public AdvertTypeService(AdvertTypeRepository advertTypeRepository) {
        this.advertTypeRepository = advertTypeRepository;
    }

    public List<Adverttype> getAllAdvertType() {
        return advertTypeRepository.findAll();
    }

    public Adverttype getAdvertTypeById(int id_adverType) {
        return advertTypeRepository.getById(id_adverType);
    }

    public Adverttype addAdvertType(Adverttype advertType) {
        if (advertTypeRepository.existsById(advertType.getId_adverttype())) {
            throw new IllegalArgumentException("Id " + advertType.getId_adverttype() + " déja utilisé");
        } else {
            return advertTypeRepository.save(advertType);
        }
    }

    public Adverttype modifyAdvertType(Adverttype advertType) {
        if (advertTypeRepository.existsById(advertType.getId_adverttype())) {
            return advertTypeRepository.save(advertType);
        } else {
            throw new IllegalArgumentException("Id: " + advertType.getId_adverttype() + " Non trouvée dans la bdd");
        }
    }

    public String suppAdvertType(int id_typeProduct) {
        if (advertTypeRepository.existsById(id_typeProduct)) {
            Adverttype advertTypeToDelete = advertTypeRepository.getById(id_typeProduct);
            advertTypeRepository.delete(advertTypeToDelete);
            return "Le typeProduct a était supprimer";
        } else {
            return "Id " + id_typeProduct + " n'existe pas ou a deja était supprimer";
        }
    }
}
