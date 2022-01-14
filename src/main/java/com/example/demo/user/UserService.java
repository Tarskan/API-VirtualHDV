package com.example.demo.user;

import com.example.demo.typeProduct.TypeProduct;
import com.example.demo.typeProduct.TypeProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllTypeObject() {
        return userRepository.findAll();
    }

    public User getTypeObject(int id_User) {
        return userRepository.getById(id_User);
    }

    public List<User> getTypeObjectByName(String nameTypeProduct) {
        return userRepository.findByNameContaining(nameTypeProduct);
    }
}
