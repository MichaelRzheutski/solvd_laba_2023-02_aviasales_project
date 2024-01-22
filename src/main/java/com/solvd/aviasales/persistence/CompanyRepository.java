package com.solvd.aviasales.persistence;

import com.solvd.aviasales.domain.structure.Company;

import java.util.List;

public interface CompanyRepository {
    List<Company> findAll();
}
