package codegym.vn.casefurama.repository;

import codegym.vn.casefurama.entity.ServiceDAO.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceTypeRepo  extends JpaRepository<ServiceType, Integer> {
}
