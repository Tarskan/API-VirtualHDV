package com.example.demo.connexion;

import com.example.demo.user.User;
import com.example.demo.user.UserRepository;
import org.springframework.stereotype.Service;


@Service
public class ConnexionService {
    private final UserRepository userRepository;

    public ConnexionService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByPseudo(Connexion user) {
        var userWanted = userRepository.findByPseudo(user.getPseudo());

        if(userWanted.getPassword().equals(user.getPassword())){
            return userWanted;
        } else {
            throw new IllegalArgumentException("Mauvais identifiant");
        }
    }
}
