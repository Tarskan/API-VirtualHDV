package com.example.demo.connexion;

import com.example.demo.user.User;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8000", maxAge = 3600)
@RestController
@RequestMapping("/api/connexion")
public class ConnexionController {

    private final ConnexionService connexionService;

    public ConnexionController(ConnexionService connexionService) { this.connexionService = connexionService; }

    @PostMapping
    public User connexion(@RequestBody Connexion connexion){
        return connexionService.getUserByPseudo(connexion);
    }
}
