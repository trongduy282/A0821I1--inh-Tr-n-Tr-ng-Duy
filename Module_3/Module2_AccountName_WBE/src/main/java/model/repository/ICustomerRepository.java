package model.repository;

import model.bean.Customer;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerRepository {
    public boolean insertCustomer(Customer customer) throws SQLException;
    List<Customer> getAllCustomer();
    public Customer selectCustomer(int id);
    public boolean deleteCustomer(int id) throws SQLException;
    public boolean updateCustomer(Customer customer) throws SQLException;
    List<Customer> search(String nameSearch,String cardSearch,String addressSearch);
}
