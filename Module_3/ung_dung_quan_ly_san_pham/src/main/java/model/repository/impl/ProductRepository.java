package model.repository.impl;

import model.bean.Product;
import model.repository.IProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    // tạo 1 list giả để dùng tạm
    public static List<Product> productList =new ArrayList<>();
    static{
        productList.add(new Product(1,"name1",1,"1","1"));
        productList.add(new Product(2,"name2",2,"2","2"));
        productList.add(new Product(3,"name3",3,"3","3"));
        productList.add(new Product(4,"name4",4,"4","4"));
        productList.add(new Product(5,"name5",5,"5","5"));
        productList.add(new Product(6,"name6",6,"6","6"));
    }
    @Override
    public List<Product> getAllProducts() {
        // kết nối database => lấy list
        return productList;
    }

    @Override
    public Product findById(int id) {
        return productList.get(id);
    }

    public Product findByName(String name) {
        Product result = null;
        for (Product p : productList) {
            if (name.equals(p.getName())) {
                return result = productList.get(p.getId());
            }
        }
        return null;
    }
    @Override
    public void add(Product product) {
        productList.add(product);
    }

    @Override
    public void update(int id, Product product) {
        productList.set(id,product);
    }

    @Override
    public void remove(int id) {
        productList.remove(id);
    }

    @Override
    public void view(int id) {
        productList.get(id);
    }

}
