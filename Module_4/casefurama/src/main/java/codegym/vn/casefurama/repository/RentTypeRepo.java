package codegym.vn.casefurama.repository;

import codegym.vn.casefurama.entity.ServiceDAO.RentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentTypeRepo extends JpaRepository<RentType, Integer> {
}
