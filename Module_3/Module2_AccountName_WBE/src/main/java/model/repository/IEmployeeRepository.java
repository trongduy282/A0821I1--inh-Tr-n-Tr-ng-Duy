package model.repository;

import model.bean.Customer;
import model.bean.Employee;

import java.sql.SQLException;
import java.util.List;

public interface IEmployeeRepository {
    public boolean insertEmployee(Employee employee) throws SQLException;
    List<Employee> getAllEmployee();
    public Employee selectEmployee(int id);
    public boolean deleteEmployee(int id) throws SQLException;
    public boolean updateEmployee(Employee employee) throws SQLException;
    List<Employee> search(String nameSearch,String cardSearch,String addressSearch);
}
