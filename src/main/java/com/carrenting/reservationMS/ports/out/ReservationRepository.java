package com.carrenting.reservationMS.ports.out;
import com.carrenting.reservationMS.ports.data.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Date;




public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    void addReservation(Date startDate, Date endDate);
    void deleteReservation(Long id);





}
