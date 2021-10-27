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
    private AdminRepository crud6;

    public List<Admin> getAll(){
        return crud6.getAll();
    }

    public Optional<Admin> getAdmin(int id) {
        return crud6.getAdmin(id);
    }

    public Admin save(Admin admin){
        if(admin.getId()==null){
            return crud6.save(admin);
        }else{
            Optional<Admin> e=crud6.getAdmin(admin.getId());
            if(e.isEmpty()){
                return crud6.save(admin);
            }else{
                return admin;
            }
        }
    }

    public Admin update(Admin admin){
        if(admin.getId()!=null){
            Optional<Admin> e=crud6.getAdmin(admin.getId());
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
                crud6.save(e.get());
                return e.get();
            }else{
                return admin;
            }
        }else{
            return admin;
        }
    }
    
}
