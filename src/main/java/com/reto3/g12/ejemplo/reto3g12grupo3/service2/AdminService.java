/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto3.g12.ejemplo.reto3g12grupo3.service2;

import com.reto3.g12.ejemplo.reto3g12grupo3.entity2.Admin;
import com.reto3.g12.ejemplo.reto3g12grupo3.repository2.AdminRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jhoan
 */

@Service
public class AdminService {
    
    @Autowired
    private AdminRepository crud5;

    public List<Admin> getAll(){
        return crud5.getAll();
    }

    public Optional<Admin> getAdmin(int id) {
        return crud5.getAdmin(id);
    }

    public Admin save(Admin admin){
        if(admin.getId()==null){
            return crud5.save(admin);
        }else{
            Optional<Admin> e=crud5.getAdmin(admin.getId());
            if(e.isEmpty()){
                return crud5.save(admin);
            }else{
                return admin;
            }
        }
    }

    public Admin update(Admin admin){
        if(admin.getId()!=null){
            Optional<Admin> e=crud5.getAdmin(admin.getId());
            if(!e.isEmpty()){
                if(admin.getName()!=null){
                    e.get().setName(admin.getName());
                }
                if(admin.getEmail()!=null){
                    e.get().setEmail(admin.getEmail());
                }
                if(admin.getPassword()!=null){
                   e.get().setPassword(admin.getPassword());
                }
                crud5.save(e.get());
                return e.get();
            }else{
                return admin;
            }
        }else{
            return admin;
        }
    }
     public boolean deleteAdmin(int id) {
        Boolean aBoolean = getAdmin(id).map(admin -> {
            crud5.delete(admin);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
    
}
