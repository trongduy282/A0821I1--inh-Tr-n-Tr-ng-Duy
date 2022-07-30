package com.codegym.addtocart.service;

import com.codegym.addtocart.model.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();
    Optional<Product> findById(Long id);
}
