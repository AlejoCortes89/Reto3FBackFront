/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.reto3.g12.ejemplo.reto3g12grupo3.interfaces2;

import com.reto3.g12.ejemplo.reto3g12grupo3.entity2.Audience;
import com.reto3.g12.ejemplo.reto3g12grupo3.entity2.Category;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author jhoan
 */
public interface CategoryInterface extends CrudRepository<Category,Integer> {
    
}
