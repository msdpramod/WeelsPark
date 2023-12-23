package com.example.parkinglot.Models;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Vehicle extends BaseModel{
    private String VehicleNumber;
    private VehicleType VehicleType;

}
