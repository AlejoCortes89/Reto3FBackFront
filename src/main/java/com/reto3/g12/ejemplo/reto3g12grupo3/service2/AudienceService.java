/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto3.g12.ejemplo.reto3g12grupo3.service2;

import com.reto3.g12.ejemplo.reto3g12grupo3.entity2.Audience;
import com.reto3.g12.ejemplo.reto3g12grupo3.repository2.AudienceRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jhoan
 */
@Service
public class AudienceService {
     @Autowired
    private AudienceRepository crud;

    public List<Audience> getAll(){
        return crud.getAll();
    }

    public Optional<Audience> getAudience(int audienceId) {
        return crud.getAudience(audienceId);
    }

    public Audience save(Audience audience){
        if(audience.getId()==null){
            return crud.save(audience);
        }else{
            Optional<Audience> e=crud.getAudience(audience.getId());
            if(e.isEmpty()){
                return crud.save(audience);
            }else{
                return audience;
            }
        }
    }

    public Audience update(Audience audience){
        if(audience.getId()!=null){
            Optional<Audience> e=crud.getAudience(audience.getId());
            if(!e.isEmpty()){
                if(audience.getName()!=null){
                    e.get().setName(audience.getName());
                }
                if(audience.getOwner()!=null){
                    e.get().setOwner(audience.getOwner());
                }
                if(audience.getCapacity()!=null){
                    e.get().setCapacity(audience.getCapacity());
                }
                if(audience.getDescription()!=null){
                    e.get().setDescription(audience.getDescription());
                }
                if(audience.getCategory()!=null){
                    e.get().setCategory(audience.getCategory());
                }
                crud.save(e.get());
                return e.get();
            }else{
                return audience;
            }
        }else{
            return audience;
        }
    }
        public boolean deleteAudience(int audienceId) {
        Boolean aBoolean = getAudience(audienceId).map(audience -> {
            crud.delete(audience);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
}

    
