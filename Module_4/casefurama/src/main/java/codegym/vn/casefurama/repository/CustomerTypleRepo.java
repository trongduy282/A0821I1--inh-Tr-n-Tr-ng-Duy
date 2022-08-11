package codegym.vn.casefurama.repository;


import codegym.vn.casefurama.entity.CustomerDAO.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerTypleRepo  extends JpaRepository<CustomerType, Integer> {
}
