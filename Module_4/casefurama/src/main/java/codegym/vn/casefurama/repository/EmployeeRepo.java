package codegym.vn.casefurama.repository;


import codegym.vn.casefurama.entity.EmployeeDAO.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, String> {
}
