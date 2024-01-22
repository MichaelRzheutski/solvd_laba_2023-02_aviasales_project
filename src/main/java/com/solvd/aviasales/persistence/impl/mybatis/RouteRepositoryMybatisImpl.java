package com.solvd.aviasales.persistence.impl.mybatis;

import com.solvd.aviasales.domain.structure.Route;
import com.solvd.aviasales.persistence.PersistenceConfig;
import com.solvd.aviasales.persistence.RouteRepository;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class RouteRepositoryMybatisImpl implements RouteRepository {
    @Override
    public List<Route> findAll() {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession(true)) {
            RouteRepository routeRepository = sqlSession.getMapper(RouteRepository.class);
            return routeRepository.findAll();
        }
    }
}
