package com.solvd.aviasales.service;

import com.solvd.aviasales.domain.structure.Airline;
import com.solvd.aviasales.domain.structure.Company;
import com.solvd.aviasales.persistence.CompanyRepository;
import com.solvd.aviasales.persistence.impl.mybatis.CompanyRepositoryMybatisImpl;

import java.util.List;

public class CompanyService implements GenericCRUDService<Company> {

    private final CompanyRepository dao;

    public CompanyService() {
        this.dao = new CompanyRepositoryMybatisImpl();
    }

    public Company create(Long id,
                          String title,
                          List<Airline> airlines) {
        Company company = new Company();
        company.setId(id);
        company.setTitle(title);
        company.setAirlines(airlines);

        return company;
    }

    @Override
    public List<Company> getAll() {
        return dao.getAll();
    }

    @Override
    public void save(Company company) {
        dao.save(company);
    }

    @Override
    public void update(Company company) {
        dao.update(company);
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }
}
