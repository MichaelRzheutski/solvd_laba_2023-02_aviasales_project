package com.solvd.aviasales.persistence;

import com.solvd.aviasales.domain.structure.Airline;

import java.util.List;

public interface AirlineRepository {
    List<Airline> findAll();
}
