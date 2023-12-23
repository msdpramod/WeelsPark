package com.example.parkinglot.Controllers;

import com.example.parkinglot.DTOS.GenerateTicketRequestDTO;
import com.example.parkinglot.DTOS.GenerateTicketResponseDTO;
import com.example.parkinglot.DTOS.ResponseStatus;
import com.example.parkinglot.Exceptions.InvalidGateException;
import com.example.parkinglot.Exceptions.NoAvailableSpotException;
import com.example.parkinglot.Models.Gate;
import com.example.parkinglot.Models.Ticket;
import com.example.parkinglot.Models.Vehicle;
import com.example.parkinglot.Models.VehicleType;
import com.example.parkinglot.Services.TicketService;

public class TicketController {
    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public GenerateTicketResponseDTO generateTicket(GenerateTicketRequestDTO generateTicketRequestDTO) throws InvalidGateException {
         String vehicleNumber=generateTicketRequestDTO.getVehicleNumber();
         VehicleType vehicleType= generateTicketRequestDTO.getVehicleType();
         Long gateId= generateTicketRequestDTO.getGateId();
        Ticket ticket = new Ticket();
        GenerateTicketResponseDTO response = new GenerateTicketResponseDTO();
        try {
            ticket = ticketService.createTicket(
                    vehicleNumber,
                    vehicleType,
                    gateId);
        }
        catch (InvalidGateException e) {
            response.setResponseStatus(ResponseStatus.FAILURE);
            response.setMessage("Gate ID is invalid");
            return response;
        } catch (NoAvailableSpotException e) {
            response.setResponseStatus(ResponseStatus.SUCCESS);
            response.setMessage("No parking spot available");
            return response;
        }
         GenerateTicketResponseDTO generateTicketResponseDTO = new GenerateTicketResponseDTO();
         generateTicketResponseDTO.setResponseStatus(ResponseStatus.SUCCESS);
         generateTicketResponseDTO.setTicketId(ticket.getId());
         generateTicketResponseDTO.setOperatorName(ticket.getOperator().getName());
         generateTicketResponseDTO.setSpotNumber(ticket.getParkingSpot().getSpotNumber());
         return generateTicketResponseDTO;
    }

}
