package codegym.vn.casefurama.service;

import codegym.vn.casefurama.entity.ServiceDAO.RentType;
import codegym.vn.casefurama.entity.ServiceDAO.Service;
import codegym.vn.casefurama.entity.ServiceDAO.ServiceType;
import codegym.vn.casefurama.repository.RentTypeRepo;
import codegym.vn.casefurama.repository.ServiceRepo;
import codegym.vn.casefurama.repository.ServiceTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


@org.springframework.stereotype.Service
public class ServiceDaoServiceImpl implements ServiceDaoService {

    @Autowired
    ServiceRepo serviceRepo;
    @Autowired
    RentTypeRepo rentTypeRepo;

    @Autowired
    ServiceTypeRepo serviceTypeRepo;

    @Override
    public List<RentType> findAllRentTypes() {
        return rentTypeRepo.findAll();
    }

    @Override
    public List<ServiceType> findAllServiceTypes() {
        return serviceTypeRepo.findAll();
    }

    @Override
    public void delete(int id) {
                serviceRepo.delete( findById(id));
    }

    @Override
    public Service findById(int id) {
        return serviceRepo.findById(id).orElse(null);
    }

    @Override
    public void save(Service service) {
                serviceRepo.save(service);
    }

    @Override
    public Page<Service> getAll(Pageable pageable) {
        return serviceRepo.findAll(pageable);
    }

    @Override
    public List<Service> getAll() {
        return serviceRepo.findAll();
    }
}
