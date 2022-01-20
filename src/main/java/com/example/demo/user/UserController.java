package com.example.demo.user;

import com.example.demo.product.Product;
import com.example.demo.product.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getListProduct(){
        return userService.getAllUser();
    }

    @GetMapping("/{idProduct}")
    public User getProductById(@PathVariable int idUser){
        return userService.getUser(idUser);
    }

    @GetMapping("/search/{nameProduct}")
    public List<User> getUserByName(@PathVariable String nameProduct){
        return userService.getUserByName(nameProduct);
    }

    @PutMapping
    public User modifyUser(@RequestBody User user) {
        return userService.modifyUser(user);
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @DeleteMapping("/{idProduct}")
    public String deleteUser(@PathVariable int idUser) {
        return userService.suppUser(idUser);
    }
}
