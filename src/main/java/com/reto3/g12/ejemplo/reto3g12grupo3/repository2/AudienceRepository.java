/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto3.g12.ejemplo.reto3g12grupo3.repository2;

import com.reto3.g12.ejemplo.reto3g12grupo3.entity2.Audience;
import com.reto3.g12.ejemplo.reto3g12grupo3.interfaces2.AudienceInterface;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jhoan
 */
@Repository
public class AudienceRepository {
     @Autowired
     private AudienceInterface crud;
     public List<Audience> getAll(){
         return (List<Audience>) crud.findAll();
     }      
     public Optional<Audience> getAudience(int id){
         return crud.findById(id);
     }
     public Audience save(Audience audience){
         return crud.save(audience); 
     }
     public void delete(Audience audience){
         crud.delete(audience);  
     }
}

