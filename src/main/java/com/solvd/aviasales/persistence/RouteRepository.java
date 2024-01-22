package com.solvd.aviasales.persistence;

import com.solvd.aviasales.domain.structure.Route;

import java.util.List;

public interface RouteRepository {
    List<Route> findAll();
}
