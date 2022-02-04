package com.example.demo.advert;

import com.example.demo.connexion.Connexion;
import com.example.demo.user.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdvertService {
    private final AdvertRepository advertRepository;

    public AdvertService(AdvertRepository advertRepository) {
        this.advertRepository = advertRepository;
    }

    public List<Advert> getAllAdvert() {
        return advertRepository.findAll();
    }

    public Advert getAdvert(int id_product) {
        return advertRepository.getById(id_product);
    }

    public List<Advert> getAdvertByIdUSer(int id_user) {
        List<Advert> allAdvert = advertRepository.findAll();
        List<Advert> list = new ArrayList<Advert>();

        for(var i=0; i<allAdvert.size(); i++){
            if (allAdvert.get(i).getId_user().equals(id_user)){
                list.add(allAdvert.get(i));
            }
        }
        return list;
    }

    public List<Advert> getAdvertByName(String nameAdvert) {
        return advertRepository.findByNameContaining(nameAdvert);
    }

    public Advert addAdvert(Advert advert) {
        if (advertRepository.existsById(advert.getId_advert())) {
            throw new IllegalArgumentException("Id " + advert.getId_advert() + " déja utilisé");
        } else {
            return advertRepository.save(advert);
        }
    }

    public Advert modifyAdvert(Advert advert) {
        if (advertRepository.existsById(advert.getId_advert())) {
            return advertRepository.save(advert);
        } else {
            throw new IllegalArgumentException("Id: " + advert.getId_advert() + " Non trouvée dans la bdd");
        }
    }

    public Advert putAdvertTypeToAdvert(int idProduct, int idTypeProduct) {
        if (advertRepository.existsById(idProduct)) {
            Advert advert = advertRepository.getById(idProduct);
            advert.setId_adverttype(idTypeProduct);
            return advertRepository.save(advert);
        } else {
            throw new IllegalArgumentException("Id: " + idProduct + " Non trouvée dans la bdd");
        }
    }

    public String suppAdvert(int id_advert) {
        if (advertRepository.existsById(id_advert)) {
            Advert typeAdvertToDelete = advertRepository.getById(id_advert);
            advertRepository.delete(typeAdvertToDelete);
            return "Le typeProduct a était supprimer";
        } else {
            return "Id " + id_advert + " n'existe pas ou a deja était supprimer";
        }
    }
}
