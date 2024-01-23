package com.solvd.aviasales.persistence.impl.mybatis;

import com.solvd.aviasales.domain.structure.Company;
import com.solvd.aviasales.persistence.AirlineRepository;
import com.solvd.aviasales.persistence.CompanyRepository;
import com.solvd.aviasales.persistence.PersistenceConfig;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class CompanyRepositoryMybatisImpl implements CompanyRepository {

    @Override
    public List<Company> getAll() {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession(true)) {
            CompanyRepository companyRepository = sqlSession.getMapper(CompanyRepository.class);
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
    public void delete(int id) {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession(true)) {
            CompanyRepository companyRepository = sqlSession.getMapper(CompanyRepository.class);
            companyRepository.delete(id);
            sqlSession.commit();
        }
    }
}
