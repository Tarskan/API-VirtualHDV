package com.example.demo.tchat;

import com.example.demo.advert.AdvertRepository;
import com.example.demo.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TchatService {
    private final TchatRepository tchatRepository;
    private final UserRepository userRepository;
    private final AdvertRepository advertRepository;

    public TchatService(TchatRepository tchatRepository, UserRepository userRepository, AdvertRepository advertRepository) {
        this.tchatRepository = tchatRepository;
        this.userRepository = userRepository;
        this.advertRepository = advertRepository;
    }

    public List<TchatDTO> getAllTchat(int id_user) {
        List<Tchat> allTchat = tchatRepository.findAll();
        List<TchatDTO> list = new ArrayList<TchatDTO>();

        for(var i=0; i<allTchat.size(); i++){
            TchatDTO tchatDTO = new TchatDTO();
            if (allTchat.get(i).getId_userone().equals(id_user)) {
                tchatDTO.setVendor(userRepository.getById(allTchat.get(i).getId_userone()));
                tchatDTO.setTchat(allTchat.get(i));
                tchatDTO.setAdvert(advertRepository.getById(allTchat.get(i).getId_advert()));
                list.add(tchatDTO);
            } else if (allTchat.get(i).getId_usertwo().equals(id_user)) {
                tchatDTO.setVendor(userRepository.getById(allTchat.get(i).getId_userone()));
                tchatDTO.setTchat(allTchat.get(i));
                tchatDTO.setAdvert(advertRepository.getById(allTchat.get(i).getId_advert()));
                list.add(tchatDTO);
            }
        }
        return list;
    }

    public Tchat addTchat(Tchat tchat) {
        if (tchatRepository.existsById(tchat.getId_tchat())) {
            throw new IllegalArgumentException("Id " + tchat.getId_tchat() + " déja utilisé");
        } else {
            return tchatRepository.save(tchat);
        }
    }

    public Tchat modifyTchat(Tchat tchat) {
        if (tchatRepository.existsById(tchat.getId_tchat())) {
            return tchatRepository.save(tchat);
        } else {
            throw new IllegalArgumentException("Id: " + tchat.getId_tchat() + " Non trouvée dans la bdd");
        }
    }

    public String suppTchat(int id_tchat) {
        if (tchatRepository.existsById(id_tchat)) {
            Tchat tchatToDelete = tchatRepository.getById(id_tchat);
            tchatRepository.delete(tchatToDelete);
            return "L'annonce à était supprimer a était supprimer";
        } else {
            return "Id " + id_tchat + " n'existe pas ou a deja était supprimer";
        }
    }

}
