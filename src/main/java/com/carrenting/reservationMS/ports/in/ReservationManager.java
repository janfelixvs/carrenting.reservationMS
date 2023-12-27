package com.carrenting.reservationMS.ports.in;

import com.carrenting.reservationMS.ports.data.Reservation;
import java.util.Date;
import java.util.List;

public interface ReservationManager {

    Reservation addReservation(Reservation reservation);

    void deleteReservation(Long reservationId);

    List<Reservation> getAllReservations();

    List<Reservation> getReservationsForVehicleInTimeframe(int carID, Date startDate, Date endDate);
}
