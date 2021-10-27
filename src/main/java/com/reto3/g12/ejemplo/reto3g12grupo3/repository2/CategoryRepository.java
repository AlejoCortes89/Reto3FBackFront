/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto3.g12.ejemplo.reto3g12grupo3.repository2;

import com.reto3.g12.ejemplo.reto3g12grupo3.entity2.Audience;
import com.reto3.g12.ejemplo.reto3g12grupo3.entity2.Category;
import com.reto3.g12.ejemplo.reto3g12grupo3.interfaces2.AudienceInterface;
import com.reto3.g12.ejemplo.reto3g12grupo3.interfaces2.CategoryInterface;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jhoan
 */
@Repository

public class CategoryRepository {
    @Autowired
    private CategoryInterface crud2;
    public List<Category> getAll(){
         return (List<Category>) crud2.findAll();
    }      
    public Optional<Category> getCategory(int id){
         return crud2.findById(id);
    }
    public Category save(Category category){
         return crud2.save(category); 
    }
    public void delete(Category category){
         crud2.delete(category);     
    
    }
}
    

