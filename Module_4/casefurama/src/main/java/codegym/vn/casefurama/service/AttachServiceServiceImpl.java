package codegym.vn.casefurama.service;


import codegym.vn.casefurama.entity.ContractDao.AttachService;
import codegym.vn.casefurama.repository.AttachServiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachServiceServiceImpl  implements AttachServiceService{

    @Autowired
    AttachServiceRepo attachServiceRepo;

    @Override
    public void delete(AttachService attachService) {

    }

    @Override
    public AttachService findById(String id) {
        return null;
    }

    @Override
    public void save(AttachService attachService) {

    }

    @Override
    public Page<AttachService> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<AttachService> getAll() {
        return attachServiceRepo.findAll();
    }
}
