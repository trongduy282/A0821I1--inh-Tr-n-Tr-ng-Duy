package com.codegym.student.service;

import com.codegym.student.entity.ClassName;

import java.util.List;

public interface ClassNameService {
    void create (ClassName className);
    void update (ClassName className);
    void delete (Integer id);
    List<ClassName> getAll();
    ClassName findById(Integer id);
}
