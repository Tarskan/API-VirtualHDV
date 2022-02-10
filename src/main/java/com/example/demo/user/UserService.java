package com.example.demo.user;

import com.example.demo.advert.Advert;
import com.example.demo.advert.AdvertRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final AdvertRepository advertRepository;

    public UserService(UserRepository userRepository, AdvertRepository advertRepository) {
        this.userRepository = userRepository;
        this.advertRepository = advertRepository;
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User getUser(int id_user) {
        return userRepository.getById(id_user);
    }

    public User addUser(User user) {
        if (userRepository.existsById(user.getId_user())) {
            throw new IllegalArgumentException("Id " + user.getId_user() + " déja utilisé");
        } else {
            return userRepository.save(user);
        }
    }

    public User modifyUser(User user) {
        if (userRepository.existsById(user.getId_user())) {
            return userRepository.save(user);
        } else {
            throw new IllegalArgumentException("Id: " + user.getId_user() + " Non trouvée dans la bdd");
        }
    }

    public String suppUser(int id_user) {
        if (userRepository.existsById(id_user)) {
            List<Advert> myAnnounce = advertRepository.findAll();
            for (int i = 0; i < myAnnounce.size(); i++) {
                if(myAnnounce.get(i).getId_user().equals(id_user)){
                    advertRepository.delete(myAnnounce.get(i));
                }
            }
            User userToDelete = userRepository.getById(id_user);
            userRepository.delete(userToDelete);
            return "L'utilisateur a était supprimer";
        } else {
            return "Id " + id_user + " n'existe pas ou a deja était supprimer";
        }
    }
}
