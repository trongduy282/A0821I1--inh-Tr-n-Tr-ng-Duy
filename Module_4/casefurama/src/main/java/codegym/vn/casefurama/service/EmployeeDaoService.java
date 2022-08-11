package codegym.vn.casefurama.service;

import codegym.vn.casefurama.entity.EmployeeDAO.Division;
import codegym.vn.casefurama.entity.EmployeeDAO.EducationDegree;
import codegym.vn.casefurama.entity.EmployeeDAO.Position;

import java.util.List;


public  interface EmployeeDaoService {

    List<Position>  findAllPositions();
    List<Division>  findAllDivisions();
    List<EducationDegree>  findAllEducationDegrees();

}
