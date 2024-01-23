package com.solvd.aviasales.persistence;

import java.util.List;

public interface GenericCRUDRepository<T> {

    List<T> getAll();

    void save(T t);

    void update(T t);

    void delete(int id);
}