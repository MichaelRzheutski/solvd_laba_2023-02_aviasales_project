package com.solvd.aviasales.persistence;

import com.solvd.aviasales.domain.structure.Airline;
import com.solvd.aviasales.domain.structure.Company;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AirlineRepository extends GenericCRUDRepository<Airline> {
    List<Airline> getCompanyAirlines(@Param("company") Company company);
}