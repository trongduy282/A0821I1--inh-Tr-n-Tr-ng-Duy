package model.repository;

import model.bean.Employee;
import model.bean.Service;

import java.sql.SQLException;

public interface IServiceRepository {
    public boolean insertService(Service service) throws SQLException;
}
