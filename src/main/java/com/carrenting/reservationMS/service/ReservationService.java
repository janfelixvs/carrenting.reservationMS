package com.carrenting.reservationMS.service;

import com.carrenting.reservationMS.ports.data.Reservation;
import com.carrenting.reservationMS.ports.in.ReservationManager;
import com.carrenting.reservationMS.ports.out.ReservationRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class ReservationService implements ReservationManager {

    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public Reservation addReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public void deleteReservation(Long reservationId) {
        if (reservationRepository.existsById(reservationId)) {
            reservationRepository.deleteById(reservationId);
        } else {
            throw new EntityNotFoundException("Reservation with id " + reservationId + " not found.");
        }
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public List<Reservation> getReservationsForVehicle(@Param("carID") int carID) {
        return reservationRepository.findByCarID(carID);

    }


}

