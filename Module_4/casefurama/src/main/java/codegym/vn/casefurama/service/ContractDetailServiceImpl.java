package codegym.vn.casefurama.service;

import codegym.vn.casefurama.entity.ContractDao.ContractDetail;
import codegym.vn.casefurama.repository.ContractDetailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ContractDetailServiceImpl  implements ContractDetailService{

    @Autowired
    ContractDetailRepo contractDetailRepo;

    @Override
    public void delete(ContractDetail contractDetail) {
            contractDetailRepo.delete(contractDetail);
    }

    @Override
    public ContractDetail findById(String id) {
        return contractDetailRepo.findById( Integer.parseInt(id) ).orElse(null);
    }

    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepo.save(contractDetail);

    }

    @Override
    public Page<ContractDetail> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<ContractDetail> getAll() {
        return contractDetailRepo.findAll();
    }

    @Override
    public List<ContractDetail> findByContract_IdContract(int contractId) {
        return contractDetailRepo.findByContract_IdContract(contractId);
    }

    @Override
    public Page<ContractDetail> findByContract_IdContract(int contractId, Pageable pageable) {
        return contractDetailRepo.findByContract_IdContract(contractId, pageable);
    }

    @Override
    public void addContractDetail(int quantity, int id_attach_service, int id_contract) {
        contractDetailRepo.addContractDetail(quantity, id_attach_service, id_contract);
    }

    @Override
    public void updateContractDetail(int quantity, int id_attach_service, int id_contract) {
            contractDetailRepo.updateContractDetail(quantity, id_attach_service, id_contract);
    }

    @Override
    public boolean existsContractDetailByAttachService_IdAttachServiceAndContract_IdContract(int id_attach_service, int id_contract) {
        return contractDetailRepo.existsContractDetailByAttachService_IdAttachServiceAndContract_IdContract(id_attach_service,id_contract);
    }

    @Override
    public ContractDetail findContractDetailByAttachService_IdAttachServiceAndContract_IdContract(int id_attach_service, int id_contract) {
        return contractDetailRepo.findContractDetailByAttachService_IdAttachServiceAndContract_IdContract(id_attach_service,id_contract);
    }


}
