package codegym.vn.casefurama.service;

import codegym.vn.casefurama.entity.CustomerDAO.Customer;
import codegym.vn.casefurama.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    @Override
    public Page<Customer> getAll(Pageable pageable) {
        return customerRepo.findAll(pageable);
    }

    @Override
    public List<Customer> getAll() {
        return customerRepo.findAll();
    }



    @Override
    public void delete(Customer customer) {
        customerRepo.delete(customer);
    }

    @Override
    public Customer findById(String id) {
        return customerRepo.findById(id).orElse(null);
    }

    @Override
    public void save(Customer customer) {
        customerRepo.save(customer);

    }

    @Override
    public Page<Customer> searchCustomer(String customerName, String customerType, String genderSearch, Pageable pageable) {
         customerName = "%" + customerName  +"%";
         customerType = "%" + customerType  +"%";
         genderSearch = "%" + genderSearch  +"%";
         return customerRepo.searchCustomer(customerName, customerType ,pageable);

    }
}
