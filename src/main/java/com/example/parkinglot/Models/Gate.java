package com.example.parkinglot.Models;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Gate extends BaseModel {
    private GateStatus gateStatus;
    private GateType gateType;
    private int GateNumber;
    private Operator CurrentOperator;
}
