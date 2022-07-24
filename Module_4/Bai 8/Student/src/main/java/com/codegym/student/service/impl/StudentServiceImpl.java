package com.codegym.student.service.impl;

import com.codegym.student.entity.Student;
import com.codegym.student.repository.StudentRepository;
import com.codegym.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;
    @Override
    public void create(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void update(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void delete(Integer id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    //Phân trang bước 2
    @Override
    public Page<Student> findAllWithPaging(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    @Override
    public Page<Student> sort(Pageable pageable,String sortBy) {
        if("".equals(sortBy))
            return findAllWithPaging(pageable);
        else if("name".equals(sortBy))
            return studentRepository.findByOrderByNameAsc(pageable);
        else if("email".equals(sortBy))
            return studentRepository.findByOrderByEmailAsc(pageable);
        return null;
    }

    @Override
    public Page<Student> findByNameContaining(String name, Pageable pageable) {
        return studentRepository.findByNameContaining(name,pageable);
    }

    @Override
    public Page<Student> searchAndSort(Pageable pageable, String searchBy, String searchVal) {
        if(searchBy == null || searchVal == null) {
            return findAllWithPaging(pageable);
        }
        else {
            switch(searchBy) {
                case "name":
                    return studentRepository.findByNameContaining(pageable, searchVal);
                case "email":
                    return studentRepository.findByEmailContaining(pageable, searchVal);
                default:
                    return findAllWithPaging(pageable);
            }
        }
    }

    @Override
    public Student findById(Integer id) {
        return studentRepository.findById(id).orElse(null);
    }
}
