package codegym.vn.casefurama.service;

import codegym.vn.casefurama.entity.CustomerDAO.CustomerType;
import codegym.vn.casefurama.repository.CustomerTypleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerTypeServiceImpl implements CustomerTypeService {

   @Autowired
    CustomerTypleRepo customerTypleRepo;



    @Override
    public void delete(CustomerType customerType) {

    }

    @Override
    public CustomerType findById(String id) {
        return null;
    }

    @Override
    public void save(CustomerType customerType) {

    }

    @Override
    public Page<CustomerType> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<CustomerType> getAll() {
        return customerTypleRepo.findAll();
    }
}
