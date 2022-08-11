package codegym.vn.casefurama.service;

import codegym.vn.casefurama.entity.CustomerDAO.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService extends IService<Customer> {

    Page<Customer> searchCustomer(  String customerName,
                                    String customerType,
                                    String genderSearch, Pageable pageable);
}
