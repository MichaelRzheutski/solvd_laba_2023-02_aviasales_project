package com.solvd.aviasales.persistence.impl.mybatis;

import com.solvd.aviasales.domain.structure.Airline;
import com.solvd.aviasales.persistence.AirlineRepository;
import com.solvd.aviasales.persistence.PersistenceConfig;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class AirlineRepositoryMybatisImpl implements AirlineRepository {
    @Override
    public List<Airline> findAll() {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession(true)) {
            AirlineRepository airlineRepository = sqlSession.getMapper(AirlineRepository.class);
            return airlineRepository.findAll();
        }
    }
}
