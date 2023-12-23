package com.example.parkinglot.DTOS;

import com.example.parkinglot.Models.VehicleType;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class GenerateTicketRequestDTO {
    private String vehicleNumber;
    private VehicleType vehicleType;
    private Long gateId;


}
