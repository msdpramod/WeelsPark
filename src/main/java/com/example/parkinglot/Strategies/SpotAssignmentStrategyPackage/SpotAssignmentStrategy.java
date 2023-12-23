package com.example.parkinglot.Strategies.SpotAssignmentStrategyPackage;

import com.example.parkinglot.Models.Gate;
import com.example.parkinglot.Models.ParkingLot;
import com.example.parkinglot.Models.ParkingSpot;
import com.example.parkinglot.Models.VehicleType;

import java.util.Optional;

public interface SpotAssignmentStrategy {
    Optional<ParkingSpot> findSpot(VehicleType vehicleType, ParkingLot parkingLot, Gate entryGate);

}
