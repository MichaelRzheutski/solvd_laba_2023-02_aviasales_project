package com.solvd.aviasales.persistence.impl.mybatis;

import com.solvd.aviasales.domain.structure.Company;
import com.solvd.aviasales.persistence.AirlineRepository;
import com.solvd.aviasales.persistence.CompanyRepository;
import com.solvd.aviasales.persistence.PersistenceConfig;
import com.solvd.aviasales.persistence.RouteRepository;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class CompanyRepositoryMybatisImpl implements CompanyRepository {

    @Override
    public List<Company> getAll() {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession(true)) {
            CompanyRepository companyRepository = sqlSession.getMapper(CompanyRepository.class);
            AirlineRepository airlineRepository = sqlSession.getMapper(AirlineRepository.class);
            RouteRepository routeRepository = sqlSession.getMapper(RouteRepository.class);
            List<Company> companies = companyRepository.getAll();
            companies.forEach(company -> {
                company.setAirlines(airlineRepository.getCompanyAirlines(company));
                company.getAirlines().forEach(airline -> airline.setRoutes(routeRepository.getAirlineRoutes(airline)));
            });
            return companyRepository.getAll();
        }
    }

    @Override
    public void save(Company company) {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession(true)) {
            CompanyRepository companyRepository = sqlSession.getMapper(CompanyRepository.class);
            companyRepository.save(company);
            sqlSession.commit();
        }
    }

    @Override
    public void update(Company company) {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession(true)) {
            CompanyRepository companyRepository = sqlSession.getMapper(CompanyRepository.class);
            companyRepository.update(company);
            sqlSession.commit();
        }
    }

    @Override
    public void delete(Long id) {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession(true)) {
            CompanyRepository companyRepository = sqlSession.getMapper(CompanyRepository.class);
            companyRepository.delete(id);
            sqlSession.commit();
        }
    }
}
