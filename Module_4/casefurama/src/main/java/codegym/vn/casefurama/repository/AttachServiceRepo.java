package codegym.vn.casefurama.repository;


import codegym.vn.casefurama.entity.ContractDao.AttachService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttachServiceRepo extends JpaRepository<AttachService, Integer> {
}
