/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto3.g12.ejemplo.reto3g12grupo3.service2;

import com.reto3.g12.ejemplo.reto3g12grupo3.entity2.Message;
import com.reto3.g12.ejemplo.reto3g12grupo3.repository2.MessageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jhoan
 */

@Service


public class MessageService {
    @Autowired
    private MessageRepository crud3;

    public List<Message> getAll(){
        return crud3.getAll();
    }

    public Optional<Message> getMessage(int messageId) {
        return crud3.getMessage(messageId);
    }

    public Message save(Message message){
        if(message.getIdMessage()==null){
            return crud3.save(message);
        }else{
            Optional<Message> e= crud3.getMessage(message.getIdMessage());
            if(e.isEmpty()){
                return crud3.save(message);
            }else{
                return message;
            }
        }
    }

    public Message update(Message message){
        if(message.getIdMessage()!=null){
            Optional<Message> e= crud3.getMessage(message.getIdMessage());
            if(!e.isEmpty()){
                if(message.getMessageText()!=null){
                    e.get().setMessageText(message.getMessageText());
                }
                crud3.save(e.get());
                return e.get();
            }else{
                return message;
            }
        }else{
            return message;
        }
    }

    public boolean deleteMessage(int messageId) {
        Boolean aBoolean = getMessage(messageId).map(message -> {
            crud3.delete(message);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
}
    
    
