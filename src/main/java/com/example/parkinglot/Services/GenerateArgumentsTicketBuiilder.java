package com.example.parkinglot.Services;

import com.example.parkinglot.DTOS.GenerateTicketRequestDTO;
import com.example.parkinglot.Models.VehicleType;

public class GenerateArgumentsTicketBuiilder {
    private String vehicleNumber;
    private String vehicleType;
    private Long gateId;

    public GenerateArgumentsTicketBuiilder setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
        return this;
    }

    public GenerateArgumentsTicketBuiilder setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
        return this;
    }

    public GenerateArgumentsTicketBuiilder setGateId(Long gateId) {
        this.gateId = gateId;
        return this;
    }

    public GenerateTicketRequestDTO build() {
        GenerateTicketRequestDTO generateTicketRequestDTO = new GenerateTicketRequestDTO();
        generateTicketRequestDTO.setVehicleNumber(vehicleNumber);
        generateTicketRequestDTO.setVehicleType(VehicleType.valueOf(vehicleType));
        generateTicketRequestDTO.setGateId(gateId);
        return generateTicketRequestDTO;
    }
}
