/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto3.g12.ejemplo.reto3g12grupo3.service2;

import com.reto3.g12.ejemplo.reto3g12grupo3.entity2.Reservation;
import com.reto3.g12.ejemplo.reto3g12grupo3.repository2.ReservationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jhoan
 */

@Service
public class ReservationService {
     @Autowired
    private ReservationRepository crud4;

    public List<Reservation> getAll(){
        return crud4.getAll();
    }

    public Optional<Reservation> getReservation(int reservationId) {
        return crud4.getReservation(reservationId);
    }

    public Reservation save(Reservation reservation){
        if(reservation.getIdReservation()==null){
            return crud4.save(reservation);
        }else{
            Optional<Reservation> e= crud4.getReservation(reservation.getIdReservation());
            if(e.isEmpty()){
                return crud4.save(reservation);
            }else{
                return reservation;
            }
        }
    }

    public Reservation update(Reservation reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservation> e= crud4.getReservation(reservation.getIdReservation());
            if(!e.isEmpty()){

                if(reservation.getStartDate()!=null){
                    e.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    e.get().setStatus(reservation.getStatus());
                }
                crud4.save(e.get());
                return e.get();
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }

    public boolean deleteReservation(int reservationId) {
        Boolean aBoolean = getReservation(reservationId).map(reservation -> {
            crud4.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
