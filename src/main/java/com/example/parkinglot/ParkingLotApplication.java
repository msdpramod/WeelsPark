package com.example.parkinglot;

import com.example.parkinglot.Controllers.TicketController;
import com.example.parkinglot.Repositories.GateRepository;
import com.example.parkinglot.Repositories.ParkingLotRepository;
import com.example.parkinglot.Repositories.TicketRepository;
import com.example.parkinglot.Repositories.VechicleRepository;
import com.example.parkinglot.Services.TicketService;
import com.example.parkinglot.Strategies.SpotAssignmentStrategyPackage.RandomSpotAssignmentStrategy;
import com.example.parkinglot.Strategies.SpotAssignmentStrategyPackage.SpotAssignmentStrategy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ParkingLotApplication {


    public static void main(String[] args) {
        GateRepository gateRepository = new GateRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        TicketRepository ticketRepository = new TicketRepository();
        VechicleRepository vehicleRepository = new VechicleRepository();
        SpotAssignmentStrategy spotAssignmentStrategy = new RandomSpotAssignmentStrategy();

        TicketService ticketService = new TicketService(
                gateRepository,
                vehicleRepository,
                spotAssignmentStrategy,
                ticketRepository,
                parkingLotRepository
        );

        TicketController ticketController = new TicketController(ticketService);

        System.out.println("Application has started on part :8080");
    }

}
