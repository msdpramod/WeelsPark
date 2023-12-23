package com.example.parkinglot.Models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter @Setter
public class ParkingFloor extends BaseModel{
    private List<ParkingSpot> parkingSpots;
    private int floorNumber;
}
