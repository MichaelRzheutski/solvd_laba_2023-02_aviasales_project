package com.solvd.aviasales.temporary;

import com.solvd.aviasales.domain.structure.Airline;
import com.solvd.aviasales.domain.structure.Company;
import com.solvd.aviasales.domain.structure.Route;
import com.solvd.aviasales.service.AirlineService;
import com.solvd.aviasales.service.CompanyService;
import com.solvd.aviasales.service.RouteService;

import java.util.ArrayList;
import java.util.List;

public class Tester {

    public static void perform() {
        AirlineService as = new AirlineService();
        CompanyService cs = new CompanyService();
        RouteService rs = new RouteService();

        Company company = new Company();
        company.setId(2L);
        company.setTitle("TEST COMPANY");

        Airline airline = new Airline();
        airline.setId(6L);
        airline.setTitle("TEST AIRLINE");

        Route route = new Route();
        route.setId(43L);
        route.setCountryFrom("Malaysia");
        route.setCountryTo("Japan");
        route.setSeatClass("fsda");
        route.setDistance(777.0);
        route.setPrice(345.5);
        route.setAirline(airline);

        List<Airline> airlines = new ArrayList<>();
        airlines.add(airline);
        company.setAirlines(airlines);
        airline.setCompany(company);

        System.out.println(rs.getBySeatClass("Economy").size());
    }
}
