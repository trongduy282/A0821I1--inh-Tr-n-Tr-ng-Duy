package model.service;

import model.bean.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProductService {
    public boolean insertProduct(Product product) throws SQLException;
    List<Product> getAllProduct();
    public Product selectProduct(int id);
    public boolean deleteProduct(int id) throws SQLException;
    public boolean updateProduct(Product product) throws SQLException;
    List<Product> search(String nameSearch);
}
