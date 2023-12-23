package com.example.parkinglot.Repositories;

import com.example.parkinglot.Models.Gate;

import java.util.Optional;

public interface IGateRepo {
    Optional<Gate> findGateById(Long gateId);
}
