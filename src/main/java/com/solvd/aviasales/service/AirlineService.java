package com.solvd.aviasales.service;

import com.solvd.aviasales.domain.structure.Airline;
import com.solvd.aviasales.domain.structure.Company;
import com.solvd.aviasales.domain.structure.Route;
import com.solvd.aviasales.persistence.AirlineRepository;
import com.solvd.aviasales.persistence.impl.mybatis.AirlineRepositoryMybatisImpl;

import java.util.List;

public class AirlineService implements GenericCRUDService<Airline> {

    private final AirlineRepository dao;

    public AirlineService() {
        this.dao = new AirlineRepositoryMybatisImpl();
    }

    public Airline create(Long id,
                          String title,
                          Company company,
                          List<Route> routes) {
        Airline airline = new Airline();
        airline.setId(id);
        airline.setTitle(title);
        airline.setCompany(company);
        airline.setRoutes(routes);

        return airline;
    }

    @Override
    public List<Airline> getAll() {
        return dao.getAll();
    }

    @Override
    public void save(Airline airline) {
        dao.save(airline);
    }

    @Override
    public void update(Airline airline) {
        dao.update(airline);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }
}