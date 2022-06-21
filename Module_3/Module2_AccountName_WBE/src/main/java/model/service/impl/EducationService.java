package model.service.impl;

import model.bean.Education;
import model.repository.ICustomerRepository;
import model.repository.IEducationRepository;
import model.repository.impl.CustomerRepository;
import model.repository.impl.EducationRepository;
import model.service.IEducationService;

import java.util.List;

public class EducationService implements IEducationService {
    IEducationRepository educationRepository = new EducationRepository();
    @Override
    public List<Education> getAllEducation() {
        return educationRepository.getAllEducation();
    }
}
