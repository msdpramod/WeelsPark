package com.example.parkinglot.DTOS;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class GenerateTicketResponseDTO {
    private Long ticketId;
    private String operatorName;
    private int spotNumber;
    private ResponseStatus responseStatus;
    private String message;


}
