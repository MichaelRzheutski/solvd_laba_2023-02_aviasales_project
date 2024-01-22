package com.solvd.aviasales.temporary;

import com.solvd.aviasales.domain.structure.Airline;
import com.solvd.aviasales.domain.structure.Company;
import com.solvd.aviasales.domain.structure.Route;
import com.solvd.aviasales.persistence.impl.mybatis.RouteRepositoryMybatisImpl;

import java.util.List;

import static com.solvd.aviasales.util.Printers.PRINTLN;

public class RouteTempMethods {
    private static List<Route> getAllRoutes() {
        return new RouteRepositoryMybatisImpl().findAll();
    }

    public static void printAviasales() {
        List<Company> companies = CompanyTempMethods.getAllCompanies();
        List<Route> routes = getAllRoutes();
        List<Airline> airlines = AirlineTempMethods.getAllAirlines();

        for (Airline airline : airlines) {
            airline.setCompany(companies.get(0));
            airline.setRoutes(routes);

            for (Route route : routes) {
                route.setAirline(airline);
            }
        }

        for (Route route : routes) {
            PRINTLN.info(route);
        }
    }
}
