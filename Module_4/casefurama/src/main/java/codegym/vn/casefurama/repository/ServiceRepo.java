package codegym.vn.casefurama.repository;


import codegym.vn.casefurama.entity.ServiceDAO.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepo extends JpaRepository<Service,Integer> {
}
