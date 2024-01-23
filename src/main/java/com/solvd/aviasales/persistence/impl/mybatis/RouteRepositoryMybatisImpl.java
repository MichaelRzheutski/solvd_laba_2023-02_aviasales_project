package com.solvd.aviasales.persistence.impl.mybatis;

import com.solvd.aviasales.domain.structure.Airline;
import com.solvd.aviasales.domain.structure.Route;
import com.solvd.aviasales.persistence.PersistenceConfig;
import com.solvd.aviasales.persistence.RouteRepository;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class RouteRepositoryMybatisImpl implements RouteRepository {

    @Override
    public List<Route> getAll() {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession(true)) {
            RouteRepository routeRepository = sqlSession.getMapper(RouteRepository.class);
            return routeRepository.getAll();
        }
    }

    @Override
    public List<Route> getBySeatClass(String seatClass) {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession(true)) {
            RouteRepository routeRepository = sqlSession.getMapper(RouteRepository.class);
            return routeRepository.getBySeatClass(seatClass);
        }
    }

    @Override
    public void save(Route route) {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession(true)) {
            RouteRepository routeRepository = sqlSession.getMapper(RouteRepository.class);
            routeRepository.save(route);
            sqlSession.commit();
        }
    }

    @Override
    public void update(Route route) {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession(true)) {
            RouteRepository routeRepository = sqlSession.getMapper(RouteRepository.class);
            routeRepository.update(route);
            sqlSession.commit();
        }
    }

    @Override
    public void delete(int id) {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession(true)) {
            RouteRepository routeRepository = sqlSession.getMapper(RouteRepository.class);
            routeRepository.delete(id);
            sqlSession.commit();
        }
    }

    public List<Route> getAirlineRoutes(Airline airline) {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession(true)) {
            RouteRepositoryMybatisImpl routeRepository = sqlSession.getMapper(RouteRepositoryMybatisImpl.class);
            return routeRepository.getAirlineRoutes(airline);
        }
    }
}
