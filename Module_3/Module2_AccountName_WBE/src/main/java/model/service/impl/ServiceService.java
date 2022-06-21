package model.service.impl;

import model.bean.Service;
import model.repository.IEmployeeRepository;
import model.repository.IServiceRepository;
import model.repository.impl.EmployeeRepository;
import model.repository.impl.ServiceRepository;
import model.service.IServiceService;

import java.sql.SQLException;

public class ServiceService implements IServiceService {
    IServiceRepository serviceRepository = new ServiceRepository();
    @Override
    public boolean insertService(Service service) throws SQLException {
        return serviceRepository.insertService(service);
    }
}
