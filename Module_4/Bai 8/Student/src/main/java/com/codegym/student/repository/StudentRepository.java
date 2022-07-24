package com.codegym.student.repository;

import com.codegym.student.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    Page<Student> findByOrderByNameAsc(Pageable pageable);
    Page<Student> findByOrderByEmailAsc(Pageable pageable);

    Page<Student> findByNameContaining(String name,Pageable pageable);
    Page<Student> findByNameContaining(Pageable pageable, String searchVal);
    Page<Student> findByEmailContaining(Pageable pageable, String searchVal);

    List<Student> findByNameContaining(String searchVal);
}
