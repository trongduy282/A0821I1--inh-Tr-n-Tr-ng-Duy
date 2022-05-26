package model.service;

import model.bean.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    void save(Product customer);
    Product findById(int id);
    void update(int id, Product customer);
    void remove(int id);
    void findProduct(String name);
}
