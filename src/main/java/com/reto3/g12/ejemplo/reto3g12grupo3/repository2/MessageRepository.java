/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto3.g12.ejemplo.reto3g12grupo3.repository2;

import com.reto3.g12.ejemplo.reto3g12grupo3.entity2.Message;
import com.reto3.g12.ejemplo.reto3g12grupo3.interfaces2.MessageInterface;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jhoan
 */
@Repository

public class MessageRepository {
    @Autowired
    private MessageInterface crud3;
    public List<Message> getAll(){
        return (List<Message>) crud3.findAll();
    }     
    public Optional<Message> getMessage(int id){
        return crud3.findById(id);
    }      
    public Message save(Message message){
        return crud3.save(message);     
    }     
    public void delete(Message message){
        crud3.delete(message);     
    } 
}

