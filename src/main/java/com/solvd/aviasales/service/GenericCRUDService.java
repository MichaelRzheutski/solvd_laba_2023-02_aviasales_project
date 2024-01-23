package com.solvd.aviasales.service;

import java.util.List;

public interface GenericCRUDService<T> {

    List<T> getAll();

    void save(T t);

    void update(T t);

    void delete(int id);
}
