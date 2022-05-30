package model.repository;

import model.bean.Product;

import java.util.List;

public interface IProductRepository {
        List<Product> getAllProducts();
        Product findById(int id );
        Product findByName(String name);
        void add(Product product);
        void update(int id, Product product);
        void remove(int id);
        void view(int id);
    }
