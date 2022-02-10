package com.example.demo.user;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8000", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getListUser(){
        return userService.getAllUser();
    }

    @GetMapping("/{id_user}")
    public User getUserById(@PathVariable int id_user){
        return userService.getUser(id_user);
    }

    @PutMapping
    public User modifyUser(@RequestBody User user) {
        return userService.modifyUser(user);
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @DeleteMapping("{idUser}")
    public String deleteUser(@PathVariable int idUser) {
        return userService.suppUser(idUser);
    }
}
