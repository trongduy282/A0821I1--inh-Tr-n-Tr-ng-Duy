package com.codegym.student.repository;

import com.codegym.student.entity.ClassName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassNameRepository extends JpaRepository<ClassName, Integer> {
}
