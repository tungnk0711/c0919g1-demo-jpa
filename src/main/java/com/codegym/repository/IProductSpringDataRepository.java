package com.codegym.repository;

import com.codegym.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IProductSpringDataRepository extends CrudRepository<Product, Long> {

    long countByName(String name);
    Iterable<Product> findByName(String name);
}
