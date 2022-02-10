package com.example.demo.message;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {
    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<Message> getAllMessageByTchat(int id_tchat) {
        List<Message> allMessage = messageRepository.findAll();
        List<Message> list = new ArrayList<Message>();

        for(var i=0; i<allMessage.size(); i++){
            if (allMessage.get(i).getId_tchat().equals(id_tchat)) {
                list.add(allMessage.get(i));
            }
        }
        return list;
    }

    public Message addMessageToTchat(Message message) {
        if (messageRepository.existsById(message.getId_message())) {
            throw new IllegalArgumentException("Id " + message.getId_message() + " déja utilisé");
        } else {
            return messageRepository.save(message);
        }
    }

    public Message modifyMessage(Message message) {
        if (messageRepository.existsById(message.getId_message())) {
            return messageRepository.save(message);
        } else {
            throw new IllegalArgumentException("Id: " + message.getId_message() + " Non trouvée dans la bdd");
        }
    }

    public String suppMessage(int id_message) {
        if (messageRepository.existsById(id_message)) {
            Message messageToDelete = messageRepository.getById(id_message);
            messageRepository.delete(messageToDelete);
            return "L'annonce à était supprimer a était supprimer";
        } else {
            return "Id " + id_message + " n'existe pas ou a deja était supprimer";
        }
    }

    public List<Message> getMessageByName(String textContaining, int id_tchat) {
        List<Message> allMessage = messageRepository.findByTextContaining(textContaining);
        List<Message> list = new ArrayList<Message>();

        for(var i=0; i<allMessage.size(); i++){
            if (allMessage.get(i).getId_tchat().equals(id_tchat)) {
                list.add(allMessage.get(i));
            }
        }
        return list;
    }

}
