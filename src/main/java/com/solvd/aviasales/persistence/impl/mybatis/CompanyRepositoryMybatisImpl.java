package com.solvd.aviasales.persistence.impl.mybatis;

import com.solvd.aviasales.domain.structure.Company;
import com.solvd.aviasales.persistence.CompanyRepository;
import com.solvd.aviasales.persistence.PersistenceConfig;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class CompanyRepositoryMybatisImpl implements CompanyRepository {
    @Override
    public List<Company> findAll() {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession(true)) {
            CompanyRepository companyRepository = sqlSession.getMapper(CompanyRepository.class);
            return companyRepository.findAll();
        }
    }
}
