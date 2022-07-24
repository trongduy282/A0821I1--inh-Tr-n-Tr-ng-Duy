package com.codegym.student.service;

import com.codegym.student.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StudentService {
    void create (Student student);
    void update (Student student);
    void delete (Integer id);
    List<Student> getAll();
    //Phân trang: Bước 1
    Page<Student> findAllWithPaging(Pageable pageable);
    Page<Student> sort(Pageable pageable, String sortBy);
    Page<Student> findByNameContaining(String name, Pageable pageable);
    Page<Student> searchAndSort(Pageable pageable, String searchBy, String searchVal);
    Student findById(Integer id);
}
