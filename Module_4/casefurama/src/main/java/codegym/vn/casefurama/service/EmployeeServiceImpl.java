package codegym.vn.casefurama.service;


import codegym.vn.casefurama.entity.EmployeeDAO.Employee;
import codegym.vn.casefurama.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl  implements EmployeeService{

    @Autowired
    EmployeeRepo employeeRepo;

    @Override
    public void delete(Employee employee) {
                        employeeRepo.delete(employee);
    }

    @Override
    public Employee findById(String id) {

        return employeeRepo.findById(id).orElse(null);
    }

    @Override
    public void save(Employee employee) {
            employeeRepo.save(employee);
    }

    @Override
    public Page<Employee> getAll(Pageable pageable) {
        return employeeRepo.findAll(pageable);
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepo.findAll();
    }
}
