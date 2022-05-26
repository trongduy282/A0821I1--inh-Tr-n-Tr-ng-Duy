package model.service.impl;

import model.bean.Product;
import model.service.ProductService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    private static Map<Integer, Product> products;
    static {
        products = new HashMap<>();
        products.put(1, new Product(1,"name1",1,"des1","manu1"));
        products.put(2, new Product(2,"name2",2,"des2","manu2"));
        products.put(3, new Product(3,"name3",3,"des3","manu3"));
        products.put(4, new Product(4,"name4",4,"des4","manu4"));
        products.put(5, new Product(5,"name5",5,"des5","manu5"));
        products.put(6, new Product(6,"name6",6,"des6","manu6"));
    }
    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public void save(Product customer) {

    }

    @Override
    public Product findById(int id) {
        return null;
    }

    @Override
    public void update(int id, Product customer) {

    }

    @Override
    public void remove(int id) {

    }

    @Override
    public void findProduct(String name) {

    }
}
