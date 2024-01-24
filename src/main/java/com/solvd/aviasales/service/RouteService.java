package com.solvd.aviasales.service;

import com.solvd.aviasales.domain.structure.Airline;
import com.solvd.aviasales.domain.structure.Route;
import com.solvd.aviasales.persistence.RouteRepository;
import com.solvd.aviasales.persistence.impl.mybatis.RouteRepositoryMybatisImpl;

import java.util.List;

public class RouteService implements GenericCRUDService<Route> {

    private final RouteRepository dao;

    public RouteService() {
        this.dao = new RouteRepositoryMybatisImpl();
    }

    public Route create(Long id,
                        String countryFrom,
                        String countryTo,
                        String seatClass,
                        Double distance,
                        Double price,
                        Airline airline) {
        Route route = new Route();
        route.setId(id);
        route.setCountryFrom(countryFrom);
        route.setCountryTo(countryTo);
        route.setSeatClass(seatClass);
        route.setDistance(distance);
        route.setPrice(price);
        route.setAirline(airline);

        return route;
    }

    @Override
    public List<Route> getAll() {
        return dao.getAll();
    }

    public List<Route> getBySeatClass(String seatClass) {
        return dao.getBySeatClass(seatClass);
    }

    @Override
    public void save(Route route) {
        dao.save(route);
    }

    @Override
    public void update(Route route) {
        dao.update(route);
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }
}
