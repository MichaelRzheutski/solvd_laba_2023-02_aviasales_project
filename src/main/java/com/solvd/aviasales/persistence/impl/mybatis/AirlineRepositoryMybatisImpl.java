package com.solvd.aviasales.persistence.impl.mybatis;

import com.solvd.aviasales.domain.structure.Airline;
import com.solvd.aviasales.domain.structure.Company;
import com.solvd.aviasales.persistence.AirlineRepository;
import com.solvd.aviasales.persistence.PersistenceConfig;
import com.solvd.aviasales.persistence.RouteRepository;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class AirlineRepositoryMybatisImpl implements AirlineRepository {
    @Override
    public List<Airline> getAll() {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession(true)) {
            AirlineRepository airlineRepository = sqlSession.getMapper(AirlineRepository.class);
            RouteRepository routeRepository = sqlSession.getMapper(RouteRepository.class);
            List<Airline> airlines = airlineRepository.getAll();
            airlines.forEach(airline -> airline.setRoutes(routeRepository.getAirlineRoutes(airline)));
            return airlineRepository.getAll();
        }
    }

    @Override
    public void save(Airline airline) {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession(true)) {
            AirlineRepository airlineRepository = sqlSession.getMapper(AirlineRepository.class);
            airlineRepository.save(airline);
            sqlSession.commit();
        }
    }

    @Override
    public void update(Airline airline) {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession(true)) {
            AirlineRepository airlineRepository = sqlSession.getMapper(AirlineRepository.class);
            airlineRepository.update(airline);
            sqlSession.commit();
        }
    }

    @Override
    public void delete(int id) {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession(true)) {
            AirlineRepository airlineRepository = sqlSession.getMapper(AirlineRepository.class);
            airlineRepository.delete(id);
            sqlSession.commit();
        }
    }

    public List<Airline> getCompanyAirlines(Company company) {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession(true)) {
            AirlineRepositoryMybatisImpl airlineRepository = sqlSession.getMapper(AirlineRepositoryMybatisImpl.class);
            return airlineRepository.getCompanyAirlines(company);
        }
    }
}
