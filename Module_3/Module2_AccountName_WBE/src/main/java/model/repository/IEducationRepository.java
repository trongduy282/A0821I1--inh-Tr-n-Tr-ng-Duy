package model.repository;

import model.bean.Customer;
import model.bean.Education;

import java.util.List;

public interface IEducationRepository {
    List<Education> getAllEducation();
}
