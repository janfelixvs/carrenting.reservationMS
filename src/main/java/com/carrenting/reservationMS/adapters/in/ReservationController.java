package com.carrenting.reservationMS.adapters.in;

import com.carrenting.reservationMS.ports.data.Reservation;
import com.carrenting.reservationMS.ports.in.ReservationManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    @GetMapping("/vehicle/{carId}")
    public ResponseEntity<List<Reservation>> getReservationsForVehicle(
            @PathVariable int carId,
            @RequestParam String startDateStr,
            @RequestParam String endDateStr) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        try {
            Date startDate = dateFormat.parse(startDateStr);
            Date endDate = dateFormat.parse(endDateStr);
            List<Reservation> reservations = reservationManager.getReservationsForVehicleInTimeframe(carId, startDate, endDate);
            return ResponseEntity.ok(reservations);
        } catch (ParseException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }


}
