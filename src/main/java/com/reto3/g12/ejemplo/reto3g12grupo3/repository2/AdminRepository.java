/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto3.g12.ejemplo.reto3g12grupo3.repository2;

import com.reto3.g12.ejemplo.reto3g12grupo3.entity2.Admin;
import com.reto3.g12.ejemplo.reto3g12grupo3.interfaces2.AdminInterface;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jhoan
 */

@Repository
public class AdminRepository {
    
    @Autowired
     private AdminInterface crud;
     public List<Admin> getAll(){
         return (List<Admin>) crud.findAll();
     }      
     public Optional<Admin> getAdmin(int id){
         return crud.findById(id);
     }
     public Admin save(Admin admin){
         return crud.save(admin); 
     }
     public void delete(Admin admin){
         crud.delete(admin);  
     }
    
}
