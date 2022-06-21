package model.repository.impl;

import model.bean.Service;
import model.repository.IServiceRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ServiceRepository implements IServiceRepository {
    private static final String INSERT_SERVICE_SQL = "INSERT INTO service(service_id, service_name, service_area,service_cost,service_max_people,rent_type_id,service_type_id,standard_room,description_other_convenience,pool_area,number_of_floors) VALUES (?,?,?,?,?,?,?,?,?,?,?);";

    @Override
    public boolean insertService(Service service) throws SQLException {
        System.out.println(INSERT_SERVICE_SQL);
        Connection connection = BaseRepository.getConnect();
        boolean check = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SERVICE_SQL);
            preparedStatement.setInt(1, service.getService_id());
            preparedStatement.setString(2, service.getService_name());
            preparedStatement.setInt(3, service.getService_area());
            preparedStatement.setDouble(4, service.getService_cost());
            preparedStatement.setInt(5, service.getService_max_people());
            preparedStatement.setInt(6, service.getRent_type_id());
            preparedStatement.setInt(7, service.getService_type_id());
            preparedStatement.setString(8, service.getStandard_room());
            preparedStatement.setString(9, service.getDescription_other_convenience());
            preparedStatement.setDouble(10, service.getPool_area());
            preparedStatement.setInt(11, service.getNumber_of_floors());
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
}
