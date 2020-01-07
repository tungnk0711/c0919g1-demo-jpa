package com.codegym.service;

import com.codegym.model.Product;

public interface IGeneralSpringDataService<E> {
    Iterable<E> findAll();
    void add(E e);
    E findById(Long id);

    long countByName(String name);

    Iterable<Product> findByName(String name);
}
