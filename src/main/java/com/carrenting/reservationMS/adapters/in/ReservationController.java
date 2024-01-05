package com.carrenting.reservationMS.adapters.in;

import com.carrenting.reservationMS.ports.data.Reservation;
import com.carrenting.reservationMS.ports.in.ReservationManager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {

    private final ReservationManager reservationManager;

    public ReservationController(ReservationManager reservationManager) {
        this.reservationManager = reservationManager;
    }

    @PostMapping
    public ResponseEntity<Reservation> addReservation(@RequestBody Reservation reservation) {
        Reservation newReservation = reservationManager.addReservation(reservation);
        return ResponseEntity.ok(newReservation);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long id) {
        reservationManager.deleteReservation(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Reservation>> getAllReservations() {
        List<Reservation> reservations = reservationManager.getAllReservations();
        return ResponseEntity.ok(reservations);
    }



    @GetMapping("/vehicle")
    public ResponseEntity<List<Reservation>> getReservationsForVehicle(@RequestParam int carID) {
        List<Reservation> reservations = reservationManager.getReservationsForVehicle(carID);
        return ResponseEntity.ok(reservations);
    }





}
