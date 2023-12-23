package com.example.parkinglot.Services;

import com.example.parkinglot.Exceptions.InvalidGateException;
import com.example.parkinglot.Exceptions.NoAvailableSpotException;
import com.example.parkinglot.Models.*;
import com.example.parkinglot.Repositories.*;
import com.example.parkinglot.Strategies.SpotAssignmentStrategyPackage.SpotAssignmentStrategy;

import java.util.Date;
import java.util.Optional;

public class TicketService {

    private IGateRepo gateRepository;
    private VechicleRepository vechicleRepository;
    private SpotAssignmentStrategy spotAssignmentStrategy;
    private TicketRepository ticketRepository;
    private ParkingLotRepository parkingLotRepository;

    public TicketService(IGateRepo gateRepository, VechicleRepository vechicleRepository, SpotAssignmentStrategy spotAssignmentStrategy, TicketRepository ticketRepository, ParkingLotRepository parkingLotRepository) {
        this.gateRepository = gateRepository;
        this.vechicleRepository = vechicleRepository;
        this.spotAssignmentStrategy = spotAssignmentStrategy;
        this.ticketRepository = ticketRepository;
        this.parkingLotRepository = parkingLotRepository;
    }

    public Ticket createTicket(String vehicleNumber, VehicleType vehicleType, Long gateId) throws InvalidGateException, NoAvailableSpotException {
         Optional<Gate> gate = gateRepository.findGateById(gateId);

        if(gate.isEmpty()) {
            throw new InvalidGateException();
        }

        Optional<Vehicle> vehicle = vechicleRepository.findVechicleByNumber(vehicleNumber);
        Vehicle newVehicle ;
        if (vehicle.isEmpty()) {
            newVehicle= new Vehicle();
            newVehicle.setVehicleNumber(vehicleNumber);
            newVehicle.setVehicleType(vehicleType);
            newVehicle=vechicleRepository.save(newVehicle);

        }else {
            newVehicle=vehicle.get();
        }

        Optional<ParkingLot> parkingLot = parkingLotRepository.getParkingLotOfGate(gate.get());
        if (parkingLot.isEmpty()) {
            throw new RuntimeException();
        }

        Optional<ParkingSpot> parkingSpot = spotAssignmentStrategy.findSpot(
                vehicleType,
                parkingLot.get(),
                gate.get()
        );
        if (parkingSpot.isEmpty()) {
            throw new NoAvailableSpotException();
        }

        Ticket ticket = new Ticket();
        ticket.setParkingSpot(parkingSpot.get());
        ticket.setGate(gate.get());
        ticket.setIssuedAt(new Date());
        ticket.setVehicle(newVehicle);
        ticket.setOperator(gate.get().getCurrentOperator());
        return ticketRepository.save(ticket);



    }
}
