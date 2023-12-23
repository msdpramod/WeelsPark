package com.example.parkinglot.Models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter @Setter
public class ParkingLot extends BaseModel{
    private List<ParkingFloor> parkingFloors;
    private List<Gate>gates;
    private int Capacity;
}
