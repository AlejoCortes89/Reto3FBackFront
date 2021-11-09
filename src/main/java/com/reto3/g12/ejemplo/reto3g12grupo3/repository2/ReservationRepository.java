/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto3.g12.ejemplo.reto3g12grupo3.repository2;

import com.reto3.g12.ejemplo.reto3g12grupo3.entity2.Client;
import com.reto3.g12.ejemplo.reto3g12grupo3.entity2.Reservation;
import com.reto3.g12.ejemplo.reto3g12grupo3.interfaces2.ReservationInterface;
import com.reto3.g12.ejemplo.reto3g12grupo3.reports2.CounterClient;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jhoan
 */
@Repository

public class ReservationRepository {
    @Autowired
    private ReservationInterface crud4;
    public List<Reservation> getAll(){
        return (List<Reservation>) crud4.findAll();
    }     
    public Optional<Reservation> getReservation(int id){
        return crud4.findById(id);
    }     
    public Reservation save(Reservation reservation){
        return crud4.save(reservation);
    }     
    public void delete(Reservation reservation){
        crud4.delete(reservation);
    } 
    public List<Reservation> ReservationStatusRepository (String status){
         return crud4.findAllByStatus(status);
     }
     
     public List<Reservation> ReservationTimeRepository (Date a, Date b){
         return crud4.findAllByStartDateAfterAndStartDateBefore(a, b);
     
     }
     
     public List<CounterClient> getClientRepository(){
         List<CounterClient> res = new ArrayList<>();
         List<Object[]> report = crud4.countTotalReservationsByClient();
         for(int i=0; i<report.size(); i++){
             res.add(new CounterClient((Long)report.get(i)[1],(Client) report.get(i)[0]));
         }
         return res;
     }
   
}

