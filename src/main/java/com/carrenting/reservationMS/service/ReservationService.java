package com.carrenting.reservationMS.service;

import com.carrenting.reservationMS.dto.CarDto;
import com.carrenting.reservationMS.dto.MaintenanceDto;
import com.carrenting.reservationMS.feign.CarClient;
import com.carrenting.reservationMS.feign.MaintenanceClient;
import com.carrenting.reservationMS.ports.data.Reservation;
import com.carrenting.reservationMS.ports.in.ReservationManager;
import com.carrenting.reservationMS.ports.out.ReservationRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class ReservationService implements ReservationManager {

    private final ReservationRepository reservationRepository;
    private final MaintenanceClient maintenanceClient;
    private final CarClient carClient;


    @Autowired
    public ReservationService(ReservationRepository reservationRepository,
                              CarClient carClient,
                              MaintenanceClient maintenanceClient) {
        this.reservationRepository = reservationRepository;
        this.carClient = carClient;
        this.maintenanceClient = maintenanceClient;
    }

    @Override
    public Reservation addReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public void deleteReservation(Long reservationId) {
        if (reservationRepository.existsById(reservationId)) {
            reservationRepository.deleteById(reservationId);
        } else {
            throw new EntityNotFoundException("Reservation with id " + reservationId + " not found.");
        }
    }

    @Override
    public List<Reservation> getAllReservations() {
        List<Reservation> reservationList=  reservationRepository.findAll();
        return reservationList;
    }

    @Override
    public List<Reservation> getAllReservationsByUserID(@Param("customerID") int userID) {
        List<Reservation> reservationList = reservationRepository.findAll();
        return reservationList.stream()
                .filter(reservation -> reservation.getCustomerID() == userID)
                .collect(Collectors.toList());
    }


    @Override
    public List<Reservation> getReservationsForVehicle(@Param("carID") int carID) {
        return reservationRepository.findByCarID(carID);

    }

    @Override
    public List<CarDto> getAllCars() {
        return carClient.getAllCars();
    }

    /*
    public List<CarDto> getAvailableVehicles() {
        List<CarDto> allCars = carClient.getAllCars();
        List<MaintenanceDto> carsInRepair = maintenanceClient.getAllMaintenances();
        List<CarDto> availableCars = allCars.stream()
                                .filter(car -> !carsInRepair.contains(car))
                                .collect(Collectors.toList());
         return availableCars;
    }*/

    public List<CarDto> getAvailableVehicles(){
        boolean test;
        List<MaintenanceDto> maintenanceDtosList = maintenanceClient.getAllMaintenances();
        List<CarDto> carDtoList = carClient.getAllCars();
        List <CarDto> finalList = new ArrayList<CarDto>();
        for(CarDto i : carDtoList){
            test = false;
            int j = i.getCarID();
            for(MaintenanceDto maintenanceDto : maintenanceDtosList){
                if(j==maintenanceDto.getCarID())
                    test=true;
            }
            if (!test)
                finalList.add(i);

        }
        return finalList;
    }

}
