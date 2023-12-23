package com.example.parkinglot.Strategies.SpotAssignmentStrategyPackage;

import com.example.parkinglot.Models.*;

import java.util.Optional;

public class RandomSpotAssignmentStrategy implements SpotAssignmentStrategy{
    @Override
    public Optional<ParkingSpot> findSpot(VehicleType vehicleType, ParkingLot parkingLot, Gate entryGate) {
        for (ParkingFloor parkingFloor: parkingLot.getParkingFloors()) {
            for (ParkingSpot parkingSpot: parkingFloor.getParkingSpots()) {
                if (parkingSpot.getSpotStatus().equals(SpotStatus.VACANT) &&
                        parkingSpot.getSupportedVehicleTypes().contains(vehicleType)) {
                    return Optional.of(parkingSpot);
                }
            }
        }
        return Optional.empty();
    }
}
