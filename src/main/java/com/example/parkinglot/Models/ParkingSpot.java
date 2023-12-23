package com.example.parkinglot.Models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter  @Setter
public class ParkingSpot extends BaseModel{
    private int spotNumber;
    private SpotStatus spotStatus;
    private List<VehicleType> supportedVehicleTypes;
    private Vehicle vehicle;


}
