package model.service;

import model.bean.Service;

import java.sql.SQLException;

public interface IServiceService {
    public boolean insertService(Service service) throws SQLException;
}
