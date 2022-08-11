package codegym.vn.casefurama.repository;


import codegym.vn.casefurama.entity.ContractDao.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractDetailRepo  extends JpaRepository<ContractDetail,Integer> {


    List<ContractDetail>   findByContract_IdContract(int contractId);
    Page<ContractDetail>   findByContract_IdContract(int contractId, Pageable pageable);


    @Query( value ="INSERT INTO contract_detail (  quantity, id_attach_service, id_contract) VALUES ( ?1, ?2, ?3); ", nativeQuery= true)
    void addContractDetail(   int quantity, int id_attach_service, int id_contract );

    @Query( value ="UPDATE contract_detail SET quantity = ?1 WHERE id_attach_service = ?2 and id_contract = ?3", nativeQuery = true)
    void updateContractDetail( int quantity, int id_attach_service, int id_contract );

    boolean  existsContractDetailByAttachService_IdAttachServiceAndContract_IdContract( int id_attach_service, int id_contract);

    ContractDetail findContractDetailByAttachService_IdAttachServiceAndContract_IdContract( int id_attach_service, int id_contract);
//    ContractDetail findByByAttachService_IdAttachServiceAndContract_IdContract( int id_attach_service, int id_contract);
}
