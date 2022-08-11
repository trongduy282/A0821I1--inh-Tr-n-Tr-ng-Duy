package codegym.vn.casefurama.repository;

import codegym.vn.casefurama.entity.EmployeeDAO.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public  interface DivisionRepo extends JpaRepository<Division, Integer> {
}
