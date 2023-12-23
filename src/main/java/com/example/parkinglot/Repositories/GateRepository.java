package com.example.parkinglot.Repositories;

import com.example.parkinglot.Models.Gate;

import java.util.Optional;

public class GateRepository implements IGateRepo{
    @Override
    public Optional<Gate> findGateById(Long gateId) {
        return Optional.empty();
    }


}
