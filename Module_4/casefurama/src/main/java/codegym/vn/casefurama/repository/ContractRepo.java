package codegym.vn.casefurama.repository;

import codegym.vn.casefurama.entity.ContractDao.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepo  extends JpaRepository<Contract, Integer> {
}
