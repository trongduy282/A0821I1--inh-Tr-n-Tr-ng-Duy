package codegym.vn.casefurama.repository;

import codegym.vn.casefurama.entity.EmployeeDAO.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepo extends JpaRepository<Position, Integer> {
}
