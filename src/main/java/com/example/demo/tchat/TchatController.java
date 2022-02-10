package com.example.demo.tchat;

import com.example.demo.advert.Advert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8000", maxAge = 3600)
@RestController
@RequestMapping("/api/tchat")
public class TchatController {
    private final TchatService tchatService;

    public TchatController(TchatService tchatService) {
        this.tchatService = tchatService;
    }

    @GetMapping("{id_user}")
    public List<TchatDTO> getListTchatDTO(@PathVariable int id_user){
        return tchatService.getAllTchat(id_user);
    }

    @PutMapping
    public Tchat modifyTchat(@RequestBody Tchat tchat) {
        return tchatService.modifyTchat(tchat);
    }

    @PostMapping
    public Tchat addTchat(@RequestBody Tchat tchat) {
        return tchatService.addTchat(tchat);
    }

    @DeleteMapping("{id_tchat}")
    public String deleteTchat(@PathVariable int id_tchat) {
        return tchatService.suppTchat(id_tchat);
    }
}
