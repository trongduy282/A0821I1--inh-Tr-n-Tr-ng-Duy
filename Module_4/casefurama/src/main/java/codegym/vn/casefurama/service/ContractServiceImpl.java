package codegym.vn.casefurama.service;

import codegym.vn.casefurama.entity.ContractDao.Contract;
import codegym.vn.casefurama.repository.ContractRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    ContractRepo contractRepo;

    @Override
    public void delete(Contract contract) {
        contractRepo.delete(contract);
    }

    @Override
    public Contract findById(String id) {
        return contractRepo.findById(Integer.parseInt(id)).orElse(null);
    }

    @Override
    public void save(Contract contract) {
        contractRepo.save(contract);
    }

    @Override
    public Page<Contract> getAll(Pageable pageable) {
        return contractRepo.findAll(pageable);
    }

    @Override
    public List<Contract> getAll() {
        return contractRepo.findAll();
    }
}
