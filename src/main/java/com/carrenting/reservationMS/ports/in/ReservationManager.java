package com.carrenting.reservationMS.ports.in;

import com.carrenting.reservationMS.ports.data.Reservation;

public interface ReservationManager {

    public void addReservation(Reservation reservation);
    public void deleteReservation(Reservation reservation);

}
