package com.example.demo.user;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
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

    public String suppUser(int idUser) {
        if (userRepository.existsById(idUser)) {
            User userToDelete = userRepository.getById(idUser);
            userRepository.delete(userToDelete);
            return "Le typeProduct a était supprimer";
        } else {
            return "Id " + idUser + " n'existe pas ou a deja était supprimer";
        }
    }
}
