package model.service.impl;

import model.bean.Product;
import model.repository.IProductRepository;
import model.repository.impl.ProductRepository;
import model.service.IProductService;

import java.sql.SQLException;
import java.util.List;

public class ProductService implements IProductService {
    IProductRepository  productRepository = new ProductRepository();
    @Override
    public boolean insertProduct(Product product) throws SQLException {
        return productRepository.insertProduct(product);
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.getAllProduct();
    }

    @Override
    public Product selectProduct(int id) {
        return productRepository.selectProduct(id);
    }

    @Override
    public boolean deleteProduct(int id) throws SQLException {
        return productRepository.deleteProduct(id);
    }

    @Override
    public boolean updateProduct(Product product) throws SQLException {
        return productRepository.updateProduct(product);
    }

    @Override
    public List<Product> search(String nameSearch) {
        return productRepository.search(nameSearch);
    }
}
