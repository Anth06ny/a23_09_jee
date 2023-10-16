package com.example.a23_09_jee;

import com.example.a23_09_jee.beans.MessageBean;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("tchat")
public class TchatAPI {

    private ArrayList<MessageBean> list = new ArrayList<>();

    public TchatAPI() {
        list.add(new MessageBean("Toto", "Coucou"));
        list.add(new MessageBean("Titi", "Salut"));
        list.add(new MessageBean("Toto", "Hello"));
        list.add(new MessageBean("Titi", "Ca va ?"));
        list.add(new MessageBean("Toto", "Ca va !!"));
    }

    //http://localhost:8080/tchat/saveMessage
    //Json Attendu : {"pseudo": "toto", "message": "coucou"}
    @PostMapping("/saveMessage")
    public void saveMessage(@RequestBody MessageBean message) {
        System.out.println("/saveMessage : " + message.getPseudo() + " : " + message.getMessage());

        //Ajout du message à la liste
        list.add(message);
    }

    //http://localhost:8080/tchat/allMessages
    @GetMapping("/allMessages")
    public ArrayList<MessageBean> getMessages() {
        System.out.println("/allMessages");

        return list;
    }

    //http://localhost:8080/tchat/filter?filter=Ca%20va
    @GetMapping("/filter")
    public ArrayList<MessageBean> filter(String filter, String pseudo) {
        System.out.println("/filter");

        ArrayList<MessageBean> sortie = new ArrayList<>();

        for (MessageBean messageBean : list) {
            //Si le message contient le filtre
            if(messageBean.getMessage() != null && messageBean.getMessage().contains(filter)) {
                if(pseudo == null || pseudo.equals(messageBean.getPseudo())){
                    sortie.add(messageBean);
                }
            }
        }

        return sortie;
    }
}
