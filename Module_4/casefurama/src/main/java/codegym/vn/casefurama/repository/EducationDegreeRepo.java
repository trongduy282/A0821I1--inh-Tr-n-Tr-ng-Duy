package codegym.vn.casefurama.repository;

import codegym.vn.casefurama.entity.EmployeeDAO.EducationDegree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationDegreeRepo  extends JpaRepository<EducationDegree, Integer> {
}
