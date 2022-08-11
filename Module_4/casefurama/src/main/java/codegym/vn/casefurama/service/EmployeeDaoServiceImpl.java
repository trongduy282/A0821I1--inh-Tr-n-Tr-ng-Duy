package codegym.vn.casefurama.service;


import codegym.vn.casefurama.entity.EmployeeDAO.Division;
import codegym.vn.casefurama.entity.EmployeeDAO.EducationDegree;
import codegym.vn.casefurama.entity.EmployeeDAO.Position;
import codegym.vn.casefurama.repository.DivisionRepo;
import codegym.vn.casefurama.repository.EducationDegreeRepo;
import codegym.vn.casefurama.repository.PositionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeDaoServiceImpl implements EmployeeDaoService {



    @Autowired
    PositionRepo positionRepo;
    @Autowired
    DivisionRepo divisionRepo;

    @Autowired
    EducationDegreeRepo educationDegreeRepo;

    @Override
    public List<Position> findAllPositions() {
        return positionRepo.findAll();
    }

    @Override
    public List<Division> findAllDivisions() {
        return divisionRepo.findAll();
    }

    @Override
    public List<EducationDegree> findAllEducationDegrees() {
        return educationDegreeRepo.findAll();
    }
}
