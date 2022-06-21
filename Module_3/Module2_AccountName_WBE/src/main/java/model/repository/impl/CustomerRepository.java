package model.repository.impl;

import model.bean.Customer;
import model.repository.ICustomerRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    private static final String INSERT_CUSTOMER_SQL = "INSERT INTO customer(customer_id, customer_type_id, customer_name,customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address) VALUES (?,?,?,?,?,?,?,?,?);";
    private static final String SELECT_ALL_CUSTOMERS = "select * from customer";
    private static final String UPDATE_CUSTOMERS_SQL = "update customer set customer_type_id= ?, customer_name = ?,customer_birthday= ?, customer_gender =?, customer_id_card= ?,customer_phone=?, customer_email=?,customer_address=? where customer_id = ?;";
    private static final String SELECT_CUSTOMER_BY_ID = "select * from customer where customer_id = ?";
    private static final String DELETE_CUSTOMER_SQL = "delete from customer where customer_id = ?;";
    private static final String SEARCH ="select * from customer where customer_name like ? and customer_id_card like ? and customer_address like ?;";
    @Override
    public boolean insertCustomer(Customer customer) throws SQLException {
        System.out.println(INSERT_CUSTOMER_SQL);
        Connection connection = BaseRepository.getConnect();
        boolean check = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER_SQL);
            preparedStatement.setInt(1, customer.getCustomer_id());
            preparedStatement.setInt(2, customer.getCustomer_type_id());
            preparedStatement.setString(3, customer.getCustomer_name());
            preparedStatement.setString(4, customer.getCustomer_birthday());
            preparedStatement.setInt(5, customer.getCustomer_gender());
            preparedStatement.setString(6, customer.getCustomer_id_card());
            preparedStatement.setString(7, customer.getCustomer_phone());
            preparedStatement.setString(8, customer.getCustomer_email());
            preparedStatement.setString(9, customer.getCustomer_address());
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
    public List<Customer> getAllCustomer() {
        List<Customer> customerList =new ArrayList<>();
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_ALL_CUSTOMERS);
            System.out.println(ps);
            // Step 3: Execute the query or update query
            ResultSet rs = ps.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int customer_id = rs.getInt("customer_id");
                int customer_type_id = rs.getInt("customer_type_id");
                String customer_name = rs.getString("customer_name");
                String customer_birthday = rs.getString("customer_birthday");
                int  customer_gender = rs.getInt("customer_gender");
                String customer_id_card = rs.getString("customer_id_card");
                String customer_phone = rs.getString("customer_phone");
                String customer_email = rs.getString("customer_email");
                String customer_address = rs.getString("customer_address");
                customerList.add(new Customer(customer_id, customer_type_id, customer_name, customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return customerList;
    }

    @Override
    public Customer selectCustomer(int id) {
        Customer customer = null;
        // Step 1: Establishing a Connection
        try (Connection connection = BaseRepository.getConnect();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID);) {
            preparedStatement.setInt(1,id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet resultSet = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (resultSet.next()){
                int customer_id = resultSet.getInt("customer_id");
                String customer_name = resultSet.getString("customer_name");
                String customer_birthday = resultSet.getString("customer_birthday");
                int customer_gender = resultSet.getInt("customer_gender");
                String customer_id_card = resultSet.getString("customer_id_card");
                String customer_phone = resultSet.getString("customer_phone");
                String customer_email = resultSet.getString("customer_email");
                String customer_address = resultSet.getString("customer_address");
                int customer_type_id = resultSet.getInt("customer_type_id");
                customer = new Customer(customer_id, customer_type_id, customer_name, customer_birthday,customer_gender, customer_id_card, customer_phone, customer_email, customer_address);
            }
            preparedStatement.close();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return customer;
    }


    @Override
    public boolean deleteCustomer(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = BaseRepository.getConnect();
             PreparedStatement statement = connection.prepareStatement(DELETE_CUSTOMER_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateCustomer(Customer customer) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = BaseRepository.getConnect();
             PreparedStatement statement = connection.prepareStatement(UPDATE_CUSTOMERS_SQL);) {
            statement.setInt(1, customer.getCustomer_type_id());
            statement.setString(2, customer.getCustomer_name());
            statement.setString(3, customer.getCustomer_birthday());
            statement.setInt(4, customer.getCustomer_gender());
            statement.setString(5, customer.getCustomer_id_card());
            statement.setString(6, customer.getCustomer_phone());
            statement.setString(7, customer.getCustomer_email());
            statement.setString(8, customer.getCustomer_address());
            statement.setInt(9, customer.getCustomer_id());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public List<Customer> search(String nameSearch, String cardSearch, String addressSearch) {
        List<Customer> customerList = new ArrayList<>();
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement ps = connection.prepareStatement(SEARCH);
            ps.setString(1,"%"+ nameSearch+"%");
            ps.setString(2,"%"+ cardSearch+"%");
            ps.setString(3,"%"+ addressSearch +"%");
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                int customer_id = resultSet.getInt("customer_id");
                String customer_name = resultSet.getString("customer_name");
                String customer_birthday = resultSet.getString("customer_birthday");
                int customer_gender = resultSet.getInt("customer_gender");
                String customer_id_card = resultSet.getString("customer_id_card");
                String customer_phone = resultSet.getString("customer_phone");
                String customer_email = resultSet.getString("customer_email");
                String customer_address = resultSet.getString("customer_address");
                int customer_type_id = resultSet.getInt("customer_type_id");
                Customer customer = new Customer(customer_id, customer_type_id, customer_name, customer_birthday,customer_gender, customer_id_card, customer_phone, customer_email, customer_address);
                customerList.add(customer);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerList;
    }
}
