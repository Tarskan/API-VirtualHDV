package com.example.demo.advert;

import com.example.demo.connexion.Connexion;
import com.example.demo.user.User;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class AdvertService {
    private final AdvertRepository advertRepository;

    public AdvertService(AdvertRepository advertRepository) {
        this.advertRepository = advertRepository;
    }

    public List<Advert> getAllAdvert(int id_user) {
        List<Advert> allAdvert = advertRepository.findAll();
        List<Advert> list = new ArrayList<Advert>();

        for(var i=0; i<allAdvert.size(); i++){
            if (allAdvert.get(i).getId_user() != id_user) {
                if (allAdvert.get(i).getSoldto() == null) {
                    list.add(allAdvert.get(i));
                }
            }
        }
        return list;
    }

    public Advert getAdvert(int id_advert) {
        return advertRepository.getById(id_advert);
    }

    public List<Advert> getAdvertByIdUSer(int id_user) {
        List<Advert> allAdvert = advertRepository.findAll();
        List<Advert> list = new ArrayList<Advert>();

        for(var i=0; i<allAdvert.size(); i++){
            if (allAdvert.get(i).getSoldto() == null) {
                if (allAdvert.get(i).getId_user().equals(id_user)) {
                    list.add(allAdvert.get(i));
                }
            }
        }
        return list;
    }

    public List<Advert> getAdvertByQueryAndIdUser(int id_user, String query) {
        List<Advert> allAdvert = advertRepository.findByNameContaining(query);
        List<Advert> list = new ArrayList<Advert>();

        for(var i=0; i<allAdvert.size(); i++){
            if (allAdvert.get(i).getSoldto() == null) {
                if (allAdvert.get(i).getId_user().equals(id_user)) {
                    list.add(allAdvert.get(i));
                }
            }
        }
        return list;
    }

    public List<Advert> getAdvertByName(String nameAdvert, int id_user) {
        List<Advert> allAdvert = advertRepository.findByNameContaining(nameAdvert);
        List<Advert> list = new ArrayList<Advert>();

        for(var i=0; i<allAdvert.size(); i++){
            if (allAdvert.get(i).getId_user() != id_user) {
                if (allAdvert.get(i).getSoldto() == null) {
                    list.add(allAdvert.get(i));
                }
            }
        }
        return list;
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

    public Advert putAdvertTypeToAdvert(int id_advert, int id_typeAdvert) {
        if (advertRepository.existsById(id_advert)) {
            Advert advert = advertRepository.getById(id_advert);
            advert.setId_adverttype(id_typeAdvert);
            return advertRepository.save(advert);
        } else {
            throw new IllegalArgumentException("Id: " + id_advert + " Non trouvée dans la bdd");
        }
    }

    public Advert sellAdvert(int id_advert, int id_user) {
        if (advertRepository.existsById(id_advert)) {
            Advert advert = advertRepository.getById(id_advert);
            advert.setSoldto(id_user);
            return advertRepository.save(advert);
        } else {
            throw new IllegalArgumentException("Id: " + id_advert + " Non trouvée dans la bdd");
        }
    }

    public List<Advert> listAllSellAdvert() {
        List<Advert> allAdvert = advertRepository.findAll();
        List<Advert> list = new ArrayList<Advert>();

        for(var i=0; i<allAdvert.size(); i++){
            if(allAdvert.get(i).getSoldto() != null) {
                list.add(allAdvert.get(i));
            }
        }
        if(list.size() >= 10) {
            int cut = list.size() - 5;
            list = list.subList(cut, list.size());
        }
        return list;
    }

    public List<Advert> listBoughtAdvert(int id_user) {
        List<Advert> allAdvert = advertRepository.findAll();
        List<Advert> list = new ArrayList<Advert>();

        for(var i=0; i<allAdvert.size(); i++){
            if(allAdvert.get(i).getSoldto() != null) {
                if (allAdvert.get(i).getSoldto().equals(id_user)) {
                    list.add(allAdvert.get(i));
                }
            }
        }
        return list;
    }

    public List<Advert> listSellAdvert(int id_user) {
        List<Advert> allAdvert = advertRepository.findAll();
        List<Advert> list = new ArrayList<Advert>();

        for(var i=0; i<allAdvert.size(); i++) {
            if (allAdvert.get(i).getSoldto() != null && allAdvert.get(i).getId_user().equals(id_user)){
                if (allAdvert.get(i).getId_user().equals(id_user)) {
                    list.add(allAdvert.get(i));
                }
            }
        }
        return list;
    }

    public List<Advert> listBoughtAdvertByName(int id_user, String advertName) {
        List<Advert> allAdvert = advertRepository.findByNameContaining(advertName);
        List<Advert> list = new ArrayList<Advert>();

        for(var i=0; i<allAdvert.size(); i++){
            if(allAdvert.get(i).getSoldto() != null) {
                if (allAdvert.get(i).getSoldto().equals(id_user)) {
                    list.add(allAdvert.get(i));
                }
            }
        }
        return list;
    }

    public List<Advert> listSellAdvertByName(int id_user, String advertName) {
        List<Advert> allAdvert = advertRepository.findByNameContaining(advertName);
        List<Advert> list = new ArrayList<Advert>();

        for(var i=0; i<allAdvert.size(); i++) {
            if (allAdvert.get(i).getSoldto() != null && allAdvert.get(i).getId_user().equals(id_user)){
                if (allAdvert.get(i).getId_user().equals(id_user)) {
                    list.add(allAdvert.get(i));
                }
            }
        }
        return list;
    }

    public String suppAdvert(int id_advert) {
        if (advertRepository.existsById(id_advert)) {
            Advert typeAdvertToDelete = advertRepository.getById(id_advert);
            advertRepository.delete(typeAdvertToDelete);
            return "L'annonce à était supprimer a était supprimer";
        } else {
            return "Id " + id_advert + " n'existe pas ou a deja était supprimer";
        }
    }

    public String imageSave(MultipartFile imageUpload) throws IOException {
        String folder = "src/main/java/resources/static/images/";
        byte[] image = imageUpload.getBytes();
        Path path = Paths.get(folder + imageUpload.getOriginalFilename());
        Files.write(path, image);
        return path.toString();
    }

}
