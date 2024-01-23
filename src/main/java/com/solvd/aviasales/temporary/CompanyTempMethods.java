package com.solvd.aviasales.temporary;

import com.solvd.aviasales.domain.structure.Company;
import com.solvd.aviasales.persistence.impl.mybatis.CompanyRepositoryMybatisImpl;

import java.util.List;

public class CompanyTempMethods {
    static List<Company> getAllCompanies() {
        return new CompanyRepositoryMybatisImpl().getAll();
    }
}
