package com.solvd.aviasales.persistence;

import com.solvd.aviasales.domain.structure.Airline;
import com.solvd.aviasales.domain.structure.Route;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RouteRepository extends GenericCRUDRepository<Route> {

    List<Route> getBySeatClass(@Param("seatClass") String seatClass);

    List<Route> getAirlineRoutes(@Param("airline") Airline airline);
}