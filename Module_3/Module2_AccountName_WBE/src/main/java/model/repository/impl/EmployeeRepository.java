package model.repository.impl;

import model.bean.Customer;
import model.bean.Employee;
import model.repository.IEmployeeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {
    private static final String SELECT_ALL_EMPLOYEE = "select * from employee";
    private static final String INSERT_EMPLOYEE_SQL = "INSERT INTO employee(employee_id, employee_name, employee_birthday,employee_id_card,employee_salary,employee_phone,employee_email,employee_address,position_id,education_degree_id,division_id) VALUES (?,?,?,?,?,?,?,?,?,?,?);";
    private static final String SELECT_EMPLOYEE_BY_ID = "select * from employee where employee_id = ?";
    private static final String UPDATE_EMPLOYEE_SQL = "update employee set employee_name = ?, employee_birthday = ?,employee_id_card= ?, employee_salary =?, employee_phone= ?,employee_email=?, employee_address=?,position_id=?, education_degree_id=?, division_id=? where employee_id = ?;";
    private static final String DELETE_EMPLOYEE_SQL = "delete from employee where employee_id = ?;";
    private static final String SEARCH ="select * from employee where employee_name like ? and employee_id_card like ? and employee_address like ?;";
    @Override
    public boolean insertEmployee(Employee employee) throws SQLException {
        System.out.println(INSERT_EMPLOYEE_SQL);
        Connection connection = BaseRepository.getConnect();
        boolean check = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE_SQL);
            preparedStatement.setInt(1, employee.getEmployee_id());
            preparedStatement.setString(2, employee.getEmployee_name());
            preparedStatement.setString(3, employee.getEmployee_birthday());
            preparedStatement.setString(4, employee.getEmployee_id_card());
            preparedStatement.setString(5, employee.getEmployee_salary());
            preparedStatement.setString(6, employee.getEmployee_phone());
            preparedStatement.setString(7, employee.getEmployee_email());
            preparedStatement.setString(8, employee.getEmployee_address());
            preparedStatement.setInt(9, employee.getPosition_id());
            preparedStatement.setInt(10, employee.getEducation_degree_id());
            preparedStatement.setInt(11, employee.getDivision_id());
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
    public List<Employee> getAllEmployee() {
        List<Employee> employeeList =new ArrayList<>();
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_ALL_EMPLOYEE);
            System.out.println(ps);
            // Step 3: Execute the query or update query
            ResultSet rs = ps.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int employee_id = rs.getInt("employee_id");
                String employee_name = rs.getString("employee_name");
                String employee_birthday = rs.getString("employee_birthday");
                String employee_id_card = rs.getString("employee_id_card");
                String employee_salary = rs.getString("employee_salary");
                String employee_phone = rs.getString("employee_phone");
                String employee_email = rs.getString("employee_email");
                String employee_address = rs.getString("employee_address");
                int position_id = rs.getInt("position_id");
                int education_degree_id = rs.getInt("education_degree_id");
                int division_id = rs.getInt("division_id");

                employeeList.add(new Employee(employee_id, employee_name, employee_birthday, employee_id_card,employee_salary,employee_phone,employee_email,employee_address,position_id,education_degree_id,division_id));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return employeeList;
    }

    @Override
    public Employee selectEmployee(int id) {
        Employee employee = null;
        // Step 1: Establishing a Connection
        try (Connection connection = BaseRepository.getConnect();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID);) {
            preparedStatement.setInt(1,id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()){
                int employee_id = rs.getInt("employee_id");
                String employee_name = rs.getString("employee_name");
                String employee_birthday = rs.getString("employee_birthday");
                String employee_id_card = rs.getString("employee_id_card");
                String employee_salary = rs.getString("employee_salary");
                String employee_phone = rs.getString("employee_phone");
                String employee_email = rs.getString("employee_email");
                String employee_address = rs.getString("employee_address");
                int position_id = rs.getInt("position_id");
                int education_degree_id = rs.getInt("education_degree_id");
                int division_id = rs.getInt("division_id");
                employee = new Employee(employee_id, employee_name, employee_birthday, employee_id_card,employee_salary,employee_phone,employee_email,employee_address,position_id,education_degree_id,division_id);
            }
            preparedStatement.close();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public boolean deleteEmployee(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = BaseRepository.getConnect();
             PreparedStatement statement = connection.prepareStatement(DELETE_EMPLOYEE_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateEmployee(Employee employee) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = BaseRepository.getConnect();
             PreparedStatement statement = connection.prepareStatement(UPDATE_EMPLOYEE_SQL);) {
            statement.setString(1, employee.getEmployee_name());
            statement.setString(2, employee.getEmployee_birthday());
            statement.setString(3, employee.getEmployee_id_card());
            statement.setString(4, employee.getEmployee_salary());
            statement.setString(5, employee.getEmployee_phone());
            statement.setString(6, employee.getEmployee_email());
            statement.setString(7, employee.getEmployee_address());
            statement.setInt(8, employee.getPosition_id());
            statement.setInt(9, employee.getEducation_degree_id());
            statement.setInt(10, employee.getDivision_id());
            statement.setInt(11, employee.getEmployee_id());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public List<Employee> search(String nameSearch, String cardSearch, String addressSearch) {
        List<Employee> employeeList = new ArrayList<>();
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement ps = connection.prepareStatement(SEARCH);
            ps.setString(1,"%"+ nameSearch+"%");
            ps.setString(2,"%"+ cardSearch+"%");
            ps.setString(3,"%"+ addressSearch +"%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int employee_id = rs.getInt("employee_id");
                String employee_name = rs.getString("employee_name");
                String employee_birthday = rs.getString("employee_birthday");
                String employee_id_card = rs.getString("employee_id_card");
                String employee_salary = rs.getString("employee_salary");
                String employee_phone = rs.getString("employee_phone");
                String employee_email = rs.getString("employee_email");
                String employee_address = rs.getString("employee_address");
                int position_id = rs.getInt("position_id");
                int education_degree_id = rs.getInt("education_degree_id");
                int division_id = rs.getInt("division_id");
                Employee employee = new Employee(employee_id, employee_name, employee_birthday, employee_id_card,employee_salary,employee_phone,employee_email,employee_address,position_id,education_degree_id,division_id);
                employeeList.add(employee);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeeList;
    }
}
