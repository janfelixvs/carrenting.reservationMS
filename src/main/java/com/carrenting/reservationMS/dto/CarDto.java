package com.carrenting.reservationMS.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarDto{
    private int carID;
    private String licensePlate;
    private Integer mileage;
    private String brand;
    private String model;
}
