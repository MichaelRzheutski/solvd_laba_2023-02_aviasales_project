package com.solvd.aviasales.temporary;

import com.solvd.aviasales.domain.actions.CollectorActions;
import com.solvd.aviasales.domain.session.ResultCollector;
import com.solvd.aviasales.domain.session.RouteCollector;
import com.solvd.aviasales.domain.structure.Airline;
import com.solvd.aviasales.domain.structure.Company;
import com.solvd.aviasales.domain.structure.Route;
import com.solvd.aviasales.persistence.impl.mybatis.AirlineRepositoryMybatisImpl;
import com.solvd.aviasales.persistence.impl.mybatis.CompanyRepositoryMybatisImpl;
import com.solvd.aviasales.persistence.impl.mybatis.RouteRepositoryMybatisImpl;

import java.util.List;

import static com.solvd.aviasales.util.Printers.*;

// Temporary class to hardcoding and checking methods
public class TempMethods {

    public static void checkingToStringMethodsFromHierarchy() {
        Company company = new Company(1L, "Aviasales service");
        Airline airline = new Airline(1L, "Best Air", company);
        Route route = new Route(1L, "Belarus", "China", "Economy", 8000.0, 450.0, airline);
        PRINT2LN.info(route);
        PRINTLN.info("");
    }

    public static void checkingCollectorActionsMethods() {
        Company company = new Company(1L, "Aviasales service");
        Airline airline = new Airline(1L, "Best Air", company);
        Route route1 = new Route(1L, "Belarus", "China", "Economy", 8000.0, 450.0, airline);
        Route route2 = new Route(2L, "China", "Japan", "Economy", 1500.0, 150.0, airline);
        Route route3 = new Route(3L, "Belarus", "Turkey", "Economy", 2000.0, 250.0, airline);
        Route route4 = new Route(4L, "Turkey", "Georgia", "Economy", 700.0, 80.0, airline);
        RouteCollector collector = new RouteCollector();
        collector.addRouteToMinimumDistanceRouteCollection(route1);
        collector.addRouteToMinimumDistanceRouteCollection(route2);
        collector.addRouteToMinimumPriceRouteCollection(route3);
        collector.addRouteToMinimumPriceRouteCollection(route4);
        ResultCollector result = new ResultCollector();
        result.addRouteCollectionToResult(collector);
        CollectorActions.showRouteCollection(collector);
        CollectorActions.showResultCollection(result);
    }

    public static List<Company> getAllCompanies() {
        return new CompanyRepositoryMybatisImpl().findAll();
    }

    public static List<Airline> getAllAirlines() {
        return new AirlineRepositoryMybatisImpl().findAll();
    }

    public static List<Route> getAllRoutes() {
        return new RouteRepositoryMybatisImpl().findAll();
    }
}
