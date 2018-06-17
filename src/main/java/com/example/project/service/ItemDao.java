package com.example.project.service;

import java.io.Serializable;
import java.util.List;

public interface ItemDao<T, Id extends Serializable> {
    void update(T entity);

    void save(T entity);

//    T findById(Id id);

    void delete(T entity);

    List<T> findAll();

//    void deleteItem(Id id);
}
