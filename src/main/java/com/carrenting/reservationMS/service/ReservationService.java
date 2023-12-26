package com.carrenting.reservationMS.service;

import com.carrenting.reservationMS.ports.data.Reservation;
import com.carrenting.reservationMS.ports.in.ReservationManager;
import com.carrenting.reservationMS.ports.out.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ReservationService implements ReservationManager {

    @Autowired
    private ReservationRepository reservationRepository;


    @Override
    public void addReservation(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    @Override
    public void deleteReservation(Reservation reservation) {
        reservationRepository.deleteById(reservation.getId());
    }
}
