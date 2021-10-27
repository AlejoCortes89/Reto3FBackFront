/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto3.g12.ejemplo.reto3g12grupo3.service2;

import com.reto3.g12.ejemplo.reto3g12grupo3.entity2.Client;
import com.reto3.g12.ejemplo.reto3g12grupo3.repository2.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jhoan
 */
@Service


public class ClientService {
     @Autowired
     private ClientRepository crud1;
     
     public List<Client> getAll(){
        return crud1.getAll();
    }
     
      public Optional<Client> getClient(int clientId) {
        return crud1.getClient(clientId);
    }

    public Client save(Client client){
        if(client.getIdClient()==null){
            return crud1.save(client);
        }else{
            Optional<Client> e= crud1.getClient(client.getIdClient());
            if(e.isEmpty()){
                return crud1.save(client);
            }else{
                return client;
            }
        }
    }

    public Client update(Client client){
        if(client.getIdClient()!=null){
            Optional<Client> e= crud1.getClient(client.getIdClient());
            if(!e.isEmpty()){
                if(client.getName()!=null){
                    e.get().setName(client.getName());
                }
                if(client.getAge()!=null){
                    e.get().setAge(client.getAge());
                }
                if(client.getPassword()!=null){
                    e.get().setPassword(client.getPassword());
                }
                 if(client.getEmail()!=null){
                    e.get().setEmail(client.getEmail());
                }
                crud1.save(e.get());
                return e.get();
            }else{
                return client;
            }
        }else{
            return client;
        }
    }

    public boolean deleteClient(int clientId) {
        Boolean aBoolean = getClient(clientId).map(client -> {
            crud1.delete(client);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
}

