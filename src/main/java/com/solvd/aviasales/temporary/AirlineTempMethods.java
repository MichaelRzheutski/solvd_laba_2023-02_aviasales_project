package com.solvd.aviasales.temporary;

import com.solvd.aviasales.domain.structure.Airline;
import com.solvd.aviasales.persistence.impl.mybatis.AirlineRepositoryMybatisImpl;

import java.util.List;

public class AirlineTempMethods {
    static List<Airline> getAllAirlines() {
        return new AirlineRepositoryMybatisImpl().findAll();
    }
}
