/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto3.g12.ejemplo.reto3g12grupo3.repository2;

import com.reto3.g12.ejemplo.reto3g12grupo3.entity2.Client;
import com.reto3.g12.ejemplo.reto3g12grupo3.interfaces2.ClientInterface;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jhoan
 */
@Repository

public class ClientRepository {
    @Autowired
    private ClientInterface crud1;
    public List<Client> getAll(){
        return (List<Client>) crud1.findAll();
    }     
    public Optional<Client> getClient(int id){
        return crud1.findById(id);
    }      
    public Client save(Client client){
        return crud1.save(client);     
    }     
    public void delete(Client client){
        crud1.delete(client);
    } 
}

