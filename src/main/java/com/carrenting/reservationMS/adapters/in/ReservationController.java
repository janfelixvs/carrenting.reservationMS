package com.carrenting.reservationMS.adapters.in;
import com.carrenting.reservationMS.ports.data.Reservation;
import com.carrenting.reservationMS.ports.in.ReservationManager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/cars")
public class ReservationController
{
    private final ReservationManager reservationManager;

    public ReservationController(ReservationManager reservationManager){
        this.reservationManager=reservationManager;
    }

    @PostMapping
    public ResponseEntity<Reservation> addReservation(@RequestBody Reservation reservation){

    }

}
