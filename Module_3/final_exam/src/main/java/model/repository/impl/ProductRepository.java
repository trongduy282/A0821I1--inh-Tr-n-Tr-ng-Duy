package model.repository.impl;

import model.bean.Product;
import model.repository.IProductRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private static final String SELECT_ALL_PRODUCT = " select * from product_info ";
    private static final String INSERT_PRODUCT_SQL = " INSERT INTO product_info(product_id, product_name, price,quantity,color,des,category_id) VALUES (?,?,?,?,?,?,?); ";
    private static final String SELECT_PRODUCT_BY_ID = "select * from product_info where product_id = ?";
    private static final String UPDATE_PRODUCT_SQL = "update product_info set product_name= ?, price = ?,quantity= ?, color =?, des= ?,category_id=? where product_id = ?;";
    private static final String DELETE_PRODUCT_SQL = "delete from product_info where product_id = ?;";
    private static final String SEARCH ="select * from product_info where product_name like ?;";

    @Override
    public boolean insertProduct(Product product) throws SQLException {
        System.out.println(INSERT_PRODUCT_SQL);
        Connection connection = BaseRepository.getConnect();
        boolean check = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT_SQL);
            preparedStatement.setInt(1, product.getProduct_id());
            preparedStatement.setString(2, product.getProduct_name());
            preparedStatement.setInt(3, product.getPrice());
            preparedStatement.setInt(4, product.getQuantity());
            preparedStatement.setString(5, product.getColor());
            preparedStatement.setString(6, product.getDes());
            preparedStatement.setInt(7, product.getCategory_id());
//            preparedStatement.setString(8, customer.getCustomer_email());
//            preparedStatement.setString(9, customer.getCustomer_address());
            check = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            connection.close();
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return check;
    }

    @Override
    public List<Product> getAllProduct() {
        List<Product> productList =new ArrayList<>();
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_ALL_PRODUCT);
            System.out.println(ps);
            // Step 3: Execute the query or update query
            ResultSet rs = ps.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int product_id = rs.getInt("product_id");
                String product_name = rs.getString("product_name");
                int price = rs.getInt("price");
                int  quantity = rs.getInt("quantity");
                String color = rs.getString("color");
                String des = rs.getString("des");
                int category_id = rs.getInt("category_id");
                productList.add(new Product(product_id, product_name, price, quantity,color,des,category_id));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return productList;
    }

    @Override
    public Product selectProduct(int id) {
        Product product = null;
        // Step 1: Establishing a Connection
        try (Connection connection = BaseRepository.getConnect();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID);) {
            preparedStatement.setInt(1,id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet resultSet = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (resultSet.next()){
                int product_id = resultSet.getInt("product_id");
                String product_name = resultSet.getString("product_name");
                int price = resultSet.getInt("price");
                int quantity = resultSet.getInt("quantity");
                String color = resultSet.getString("color");
                String des = resultSet.getString("des");
                int category_id = resultSet.getInt("category_id");
//                String customer_address = resultSet.getString("customer_address");
//                int customer_type_id = resultSet.getInt("customer_type_id");
                product = new Product(product_id, product_name, price, quantity,color, des, category_id);
            }
            preparedStatement.close();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public boolean deleteProduct(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = BaseRepository.getConnect();
             PreparedStatement statement = connection.prepareStatement(DELETE_PRODUCT_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateProduct(Product product) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = BaseRepository.getConnect();
//             private static final String UPDATE_PRODUCT_SQL = "update product_info set product_name= ?, price = ?,quantity= ?, color =?, des= ?,category_id=? where product_id = ?;";

             PreparedStatement statement = connection.prepareStatement(UPDATE_PRODUCT_SQL);) {
            statement.setString(1, product.getProduct_name());
            statement.setInt(2, product.getPrice());
            statement.setInt(3, product.getQuantity());
            statement.setString(4, product.getColor());
            statement.setString(5, product.getDes());
            statement.setInt(6, product.getCategory_id());
            statement.setInt(7, product.getProduct_id());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public List<Product> search(String nameSearch) {
        List<Product> productList = new ArrayList<>();
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement ps = connection.prepareStatement(SEARCH);
            ps.setString(1,"%"+ nameSearch+"%");
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                int product_id = resultSet.getInt("product_id");
                String product_name = resultSet.getString("product_name");
                int price = resultSet.getInt("price");
                int quantity = resultSet.getInt("quantity");
                String color = resultSet.getString("color");
                String des = resultSet.getString("des");
                int category_id = resultSet.getInt("category_id");
                Product product = new Product(product_id, product_name, price, quantity,color, des, category_id);
                productList.add(product);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return productList;
    }
}
