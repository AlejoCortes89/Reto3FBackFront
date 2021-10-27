/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto3.g12.ejemplo.reto3g12grupo3.service2;

import com.reto3.g12.ejemplo.reto3g12grupo3.entity2.Category;
import com.reto3.g12.ejemplo.reto3g12grupo3.repository2.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jhoan
 */
@Service

public class CategoryService {
    
    @Autowired
    private CategoryRepository crud2;

    public List<Category> getAll() {
        return crud2.getAll();
    }

    public Optional<Category> getCategory(int categoriaId) {
        return crud2.getCategory(categoriaId);
    }

    public Category save(Category category) {
        if (category.getId()== null) {
            return crud2.save(category);
        } else {
            Optional<Category> category1 = crud2.getCategory(category.getId());
            if (category1.isEmpty()) {
                return crud2.save(category);
            } else {
                return category;
            }
        }
    }

    public Category update(Category category){
        if(category.getId()!=null){
            Optional<Category>g=crud2.getCategory(category.getId());
            if(!g.isEmpty()){
                if(category.getDescription()!=null){
                    g.get().setDescription(category.getDescription());
                }
                if(category.getName()!=null){
                    g.get().setName(category.getName());
                }
                return crud2.save(g.get());
            }
        }
        return category;
    }
    public boolean deletecategory(int categoriaId){
        Boolean d=getCategory(categoriaId).map(category -> {
            crud2.delete(category);
            return true;
        }).orElse(false);
        return d;
    }
    
}
    

