package com.upgrad.hirewheels.services;

import com.upgrad.hirewheels.entities.Booking;
import com.upgrad.hirewheels.entities.Vehicle;

import java.time.LocalDateTime;
import java.util.List;

public interface VehicleService {

    public List<Vehicle> getAllVehicles();
    public List<Vehicle> getAvailableVehicles(Booking booking);
    List<Vehicle> getAvailableVehicle(int categoryId, LocalDateTime pickUpDate, LocalDateTime dropDate, int locationId);
}
