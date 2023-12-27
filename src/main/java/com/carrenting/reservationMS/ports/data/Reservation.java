package com.carrenting.reservationMS.ports.data;

import java.util.Date;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationID;

    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;

    private int customerID;
    private int carID;


    @SuppressWarnings("unused")
    public Reservation(Date startDate, Date endDate, int customerID, int carID) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.customerID = customerID;
        this.carID = carID;
    }

    @SuppressWarnings("unused")
    public Reservation() {
    }

}
