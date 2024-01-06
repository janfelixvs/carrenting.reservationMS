package com.carrenting.reservationMS.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "maintenance")
public class MaintenanceDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maintenanceID;
    private int carID;
    private Date startDate;
    private Date endDate;
    private String status;

    public MaintenanceDto(int carID, Date startDate, Date endDate, String status) {
        this.carID = carID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = (status != null) ? status : "Annahme";
    }
}