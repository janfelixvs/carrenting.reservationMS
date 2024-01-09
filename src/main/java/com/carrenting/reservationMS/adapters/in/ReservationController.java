package com.carrenting.reservationMS.adapters.in;

import com.carrenting.reservationMS.ports.data.Reservation;
import com.carrenting.reservationMS.ports.in.ReservationManager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.carrenting.reservationMS.dto.CarDto;

import java.util.List;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {

    private final ReservationManager reservationManager;

    public ReservationController(ReservationManager reservationManager) {
        this.reservationManager = reservationManager;
    }

    //POST: http://localhost:8083/api/reservation
    // {"customerId": 1, "carId": 1, "startDate": "2024-07-01T10:00:00", "endDate": "2024-07-03T15:00:00" }
    @PostMapping
    public ResponseEntity<Reservation> addReservation(@RequestBody Reservation reservation) {
        Reservation newReservation = reservationManager.addReservation(reservation);
        return ResponseEntity.ok(newReservation);
    }

    //DELETE: http://localhost:8083/api/reservation/11
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long id) {
        reservationManager.deleteReservation(id);
        return ResponseEntity.ok().build();
    }

    //GET: http://localhost:8083/api/reservation
    @GetMapping
    public ResponseEntity<List<Reservation>> getAllReservations() {
        List<Reservation> reservations = reservationManager.getAllReservations();
        return ResponseEntity.ok(reservations);
    }

    //GET: http://localhost:8083/api/reservation/user/1
    @GetMapping("/user/{userID}")
    public ResponseEntity<List<Reservation>> getAllReservationsByUserID(@PathVariable int userID) {
        List<Reservation> reservations = reservationManager.getAllReservationsByUserID(userID);
        if (reservations.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(reservations);
    }


    // GET: http://localhost:8083/api/reservation/cars
    @GetMapping("/cars")
    public ResponseEntity<List<CarDto>> getAllCars() {
        List<CarDto> cars = reservationManager.getAllCars();
        return ResponseEntity.ok(cars);
    }


    //GET: http://localhost:8083/api/reservation/vehicle?carID=3
    @GetMapping("/vehicle")
    public ResponseEntity<List<Reservation>> getReservationsForVehicle(@RequestParam int carID) {
        List<Reservation> reservations = reservationManager.getReservationsForVehicle(carID);
        return ResponseEntity.ok(reservations);
    }


    //GET: http://localhost:8083/api/reservation/availableVehicle
    @GetMapping("/availableVehicle")
    public ResponseEntity<List<CarDto>> getAvailableVehicle() {
        List<CarDto> carDtoList = reservationManager.getAvailableVehicles();
        return ResponseEntity.ok(carDtoList);
    }

}
