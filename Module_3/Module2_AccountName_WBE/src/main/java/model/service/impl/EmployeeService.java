package model.service.impl;

import model.bean.Employee;
import model.repository.IEmployeeRepository;
import model.repository.impl.EmployeeRepository;
import model.service.IEmployeeService;

import java.sql.SQLException;
import java.util.List;

public class EmployeeService implements IEmployeeService {
    IEmployeeRepository employeeRepository = new EmployeeRepository();
    @Override
    public boolean insertEmployee(Employee employee) throws SQLException {
        return employeeRepository.insertEmployee(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.getAllEmployee();
    }

    @Override
    public Employee selectEmployee(int id) {
        return employeeRepository.selectEmployee(id);
    }

    @Override
    public boolean deleteEmployee(int id) throws SQLException {
        return employeeRepository.deleteEmployee(id);
    }

    @Override
    public boolean updateEmployee(Employee employee) throws SQLException {
        return employeeRepository.updateEmployee(employee);
    }

    @Override
    public List<Employee> search(String nameSearch, String cardSearch, String addressSearch) {
        return employeeRepository.search(nameSearch,cardSearch,addressSearch);
    }
}
