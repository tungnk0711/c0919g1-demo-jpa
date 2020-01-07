package com.codegym.service.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductSpringDataRepository;
import com.codegym.service.IProductSpringDataService;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductSpringDataServiceImpl implements IProductSpringDataService {

    @Autowired
    IProductSpringDataRepository productSpringDataRepository;

    @Override
    public Iterable<Product> findAll() {
        return productSpringDataRepository.findAll();
    }

    @Override
    public void add(Product product) {
        productSpringDataRepository.save(product);
    }

    @Override
    public Product findById(Long id) {
        return productSpringDataRepository.findOne(id);
    }

    @Override
    public long countByName(String name) {
        return productSpringDataRepository.countByName(name);
    }

    @Override
    public Iterable<Product> findByName(String name) {
        return productSpringDataRepository.findByName(name);
    }
}
