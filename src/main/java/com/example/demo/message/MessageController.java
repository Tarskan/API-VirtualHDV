package com.example.demo.message;

import com.example.demo.tchat.Tchat;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8000", maxAge = 3600)
@RestController
@RequestMapping("/api/message")
public class MessageController {
    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("{id_tchat}")
    public List<Message> getListMessageByIdTchat(@PathVariable int id_tchat){
        return messageService.getAllMessageByTchat(id_tchat);
    }

    @PutMapping
    public Message modifyMessage(@RequestBody Message message) {
        return messageService.modifyMessage(message);
    }

    @PostMapping
    public Message addMessage(@RequestBody Message message) {
        return messageService.addMessageToTchat(message);
    }

    @DeleteMapping("{id_message}")
    public String deleteTchat(@PathVariable int id_message) {
        return messageService.suppMessage(id_message);
    }
}
