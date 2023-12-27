package com.carrenting.reservationMS.ports.out;
import com.carrenting.reservationMS.ports.data.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Date;
import java.util.List;


public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findAllByCarIDAndStartDateGreaterThanEqualAndEndDateLessThanEqual(int carID, Date startDate, Date endDate);
}
